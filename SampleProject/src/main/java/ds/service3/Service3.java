package ds.service3;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import ds.service3.Service3Grpc.Service3ImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class Service3 extends Service3ImplBase {

	private Map<String, Float> energyUsageData = new HashMap<>();
	private Map<String, Float> energyDistribution = new HashMap<>();
	private Map<String, String> energySavingSchedules = new HashMap<>();
	private static ServiceRegistry serviceRegistry = new ServiceRegistry();

	public static void main(String[] args) throws InterruptedException, IOException {
		Service3 service1 = new Service3();

		int port = 50053;

		Server server = ServerBuilder.forPort(port)
				.addService(service1)
				.intercept(new AuthenticationInterceptor())
				.build()
				.start();

		// Register the service
		serviceRegistry.registerService("Service3", "localhost:" + port);

		System.out.println("Service-3 started, listening on " + port);

		server.awaitTermination();
	}

	@Override
	public void monitorEnergyUsage(MonitorEnergyUsageRequest request,
			StreamObserver<MonitorEnergyUsageResponse> responseObserver) {
		Context.CancellableContext context = Context.current().withDeadlineAfter(5, TimeUnit.SECONDS,
				Context.current().executor());
		context.run(() -> {
			try {
				String areaId = request.getAreaId();
				float currentUsage = getCurrentUsage(areaId);
				float averageUsage = getAverageUsage(areaId);

				MonitorEnergyUsageResponse response = MonitorEnergyUsageResponse.newBuilder()
						.setCurrentUsage(currentUsage)
						.setAverageUsage(averageUsage)
						.build();

				responseObserver.onNext(response);
				responseObserver.onCompleted();
			} catch (Exception e) {
				responseObserver
						.onError(Status.INTERNAL.withDescription("Internal error occurred").asRuntimeException());
			}
		});
	}

	private float getCurrentUsage(String areaId) {
		// Simulate fetching real-time energy usage data
		return energyUsageData.getOrDefault(areaId, 0.0f);
	}

	private float getAverageUsage(String areaId) {
		// Simulate calculating average usage over a period
		return energyUsageData.getOrDefault(areaId, 0.0f) / 2; // Dummy calculation
	}

	@Override
	public void adjustEnergyDistribution(AdjustEnergyDistributionRequest request,
			StreamObserver<AdjustEnergyDistributionResponse> responseObserver) {
		try {
			String areaId = request.getAreaId();
			float distributionPercentage = request.getDistributionPercentage();

			if (distributionPercentage < 0 || distributionPercentage > 100) {
				AdjustEnergyDistributionResponse response = AdjustEnergyDistributionResponse.newBuilder()
						.setSuccess(false)
						.setMessage("Invalid distribution percentage")
						.build();
				responseObserver.onNext(response);
				responseObserver.onCompleted();
				return;
			}

			// Simulate adjusting energy distribution
			energyDistribution.put(areaId, distributionPercentage);

			AdjustEnergyDistributionResponse response = AdjustEnergyDistributionResponse.newBuilder()
					.setSuccess(true)
					.setMessage("Energy distribution adjusted successfully")
					.build();

			responseObserver.onNext(response);
			responseObserver.onCompleted();
		} catch (Exception e) {
			responseObserver.onError(Status.INTERNAL.withDescription("Internal error occurred").asRuntimeException());
		}
	}

	@Override
	public void scheduleEnergySaving(ScheduleEnergySavingRequest request,
			StreamObserver<ScheduleEnergySavingResponse> responseObserver) {
		try {
			String areaId = request.getAreaId();
			String schedule = request.getSchedule();

			if (!isValidSchedule(schedule)) {
				ScheduleEnergySavingResponse response = ScheduleEnergySavingResponse.newBuilder()
						.setSuccess(false)
						.setMessage("Invalid schedule format")
						.build();
				responseObserver.onNext(response);
				responseObserver.onCompleted();
				return;
			}

			// Simulate scheduling energy-saving measures
			energySavingSchedules.put(areaId, schedule);

			ScheduleEnergySavingResponse response = ScheduleEnergySavingResponse.newBuilder()
					.setSuccess(true)
					.setMessage("Energy-saving measures scheduled successfully")
					.build();

			responseObserver.onNext(response);
			responseObserver.onCompleted();
		} catch (Exception e) {
			responseObserver.onError(Status.INTERNAL.withDescription("Internal error occurred").asRuntimeException());
		}
	}

	private boolean isValidSchedule(String schedule) {
		// Simulate schedule validation
		return schedule.matches("\\d{2}:\\d{2}-\\d{2}:\\d{2}"); // Dummy validation for HH:MM-HH:MM format
	}

	// Method to discover a service
	public static String discoverService(String serviceName) {
		return serviceRegistry.discoverService(serviceName);
	}

	// Authentication Interceptor
	static class AuthenticationInterceptor implements ServerInterceptor {
		@Override
		public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(ServerCall<ReqT, RespT> call, Metadata headers,
				ServerCallHandler<ReqT, RespT> next) {
			String authToken = headers.get(Key.of("Authorization", Metadata.ASCII_STRING_MARSHALLER));
			if (authToken == null || !authToken.equals("valid-token")) {
				call.close(Status.UNAUTHENTICATED.withDescription("Invalid token"), headers);
				return new ServerCall.Listener<ReqT>() {
				};
			}
			return next.startCall(call, headers);
		}
	}
}