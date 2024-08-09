package ds.service1;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import ds.service1.Service1Grpc.Service1ImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import io.grpc.Context;
import io.grpc.Status;

import io.grpc.stub.MetadataUtils;
import io.grpc.Metadata;

public class Service1 extends Service1ImplBase {

	private static final Metadata.Key<String> AUTH_TOKEN_KEY = Metadata.Key.of("auth-token",
			Metadata.ASCII_STRING_MARSHALLER);
	private static final String SERVICE_TYPE = "_http._tcp.local.";

	public static void main(String[] args) throws InterruptedException, IOException {
		Service1 service1 = new Service1();

		int port = 50051;

		// Register service with jmDNS
		registerService(port);

		// Discover services with jmDNS
		discoverServices();

		Server server = ServerBuilder.forPort(port)
				.addService(service1)
				.build()
				.start();

		System.out.println("Service-1 started, listening on " + port);

		server.awaitTermination();
	}

	private static void registerService(int port) {
		try {
			JmDNS jmdns = JmDNS.create();
			ServiceInfo serviceInfo = ServiceInfo.create(SERVICE_TYPE, "Service1", port, "Service1");
			jmdns.registerService(serviceInfo);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void discoverServices() {
		try {
			JmDNS jmdns = JmDNS.create();
			ServiceInfo[] services = jmdns.list(SERVICE_TYPE);
			for (ServiceInfo service : services) {
				System.out.println("Discovered service: " + service.getName() + " at " + service.getAddress() + ":"
						+ service.getPort());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Example method with Metadata
	@Override
	public void controlTrafficLight(ControlTrafficLightRequest request,
			StreamObserver<ControlTrafficLightResponse> responseObserver) {
		// Retrieve metadata
		Metadata metadata = MetadataUtils.fromIncomingContext();
		String clientId = metadata.get(Metadata.Key.of("client-id", Metadata.ASCII_STRING_MARSHALLER));

		// Implement logic for controlTrafficLight RPC method
		String intersectionId = request.getIntersectionId();
		String lightState = request.getLightState();

		// Perform traffic light control logic

		ControlTrafficLightResponse response = ControlTrafficLightResponse.newBuilder()
				.setSuccess(true)
				.setMessage("Traffic light at intersection " + intersectionId + " set to " + lightState)
				.build();

		responseObserver.onNext(response);
		responseObserver.onCompleted();
	}

	@Override
	public void monitorTraffic(MonitorTrafficRequest request, StreamObserver<MonitorTrafficResponse> responseObserver) {
		// Set a deadline for the RPC call
		Context.current().withDeadlineAfter(5, TimeUnit.SECONDS, Context.current().executor()).run(() -> {
			// Retrieve metadata
			Metadata metadata = MetadataUtils.fromIncomingContext();
			String authToken = metadata.get(AUTH_TOKEN_KEY);

			// Check authentication
			if (!isValidAuthToken(authToken)) {
				responseObserver
						.onError(Status.UNAUTHENTICATED.withDescription("Invalid auth token").asRuntimeException());
				return;
			}

			// Implement logic for monitorTraffic RPC method
			String areaId = request.getAreaId();

			// Retrieve vehicle count and average speed data for the specified area
			MonitorTrafficResponse response = MonitorTrafficResponse.newBuilder()
					.setVehicleCount(100) // Sample vehicle count data
					.setAverageSpeed(30.5f) // Sample average speed data
					.build();

			responseObserver.onNext(response);
			responseObserver.onCompleted();
		});
	}

	@Override
	public void adjustTrafficFlow(AdjustTrafficFlowRequest request,
			StreamObserver<AdjustTrafficFlowResponse> responseObserver) {
		// Set a deadline for the RPC call
		Context.current().withDeadlineAfter(5, TimeUnit.SECONDS, Context.current().executor()).run(() -> {
			// Retrieve metadata
			Metadata metadata = MetadataUtils.fromIncomingContext();
			String authToken = metadata.get(AUTH_TOKEN_KEY);

			// Check authentication
			if (!isValidAuthToken(authToken)) {
				responseObserver
						.onError(Status.UNAUTHENTICATED.withDescription("Invalid auth token").asRuntimeException());
				return;
			}

			// Implement logic for adjustTrafficFlow RPC method
			String areaId = request.getAreaId();
			String timingSchedule = request.getTimingSchedule();

			// Adjust traffic light timing schedule for optimized flow
			AdjustTrafficFlowResponse response = AdjustTrafficFlowResponse.newBuilder()
					.setSuccess(true)
					.setMessage("Traffic flow adjusted for area " + areaId + " with timing schedule: " + timingSchedule)
					.build();

			responseObserver.onNext(response);
			responseObserver.onCompleted();
		});
	}

	private boolean isValidAuthToken(String authToken) {
		// Implement your authentication logic here
		return "valid-token".equals(authToken);
	}
}