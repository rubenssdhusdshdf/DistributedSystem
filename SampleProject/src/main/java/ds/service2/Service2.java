package ds.service2;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.HashMap;
import java.util.Map;

import ds.service2.Service2Grpc.Service2ImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import io.grpc.Context;
import io.grpc.Status;

import io.grpc.stub.MetadataUtils;
import io.grpc.Metadata;

public class Service2 extends Service2ImplBase {

	private static final Metadata.Key<String> AUTH_TOKEN_KEY = Metadata.Key.of("auth-token",
			Metadata.ASCII_STRING_MARSHALLER);
	private static final String SERVICE_TYPE = "_http._tcp.local.";
	private static final Map<String, Integer> fillLevelsMap = new HashMap<>();

	public static void main(String[] args) throws InterruptedException, IOException {
		Service2 service2 = new Service2();

		int port = 50052;

		// Register service with jmDNS
		registerService(port, "Service2");

		// Discover services with jmDNS
		discoverServices();

		Server server = ServerBuilder.forPort(port)
				.addService(service2)
				.intercept(MetadataUtils.newDeadlineInterceptor(5, TimeUnit.SECONDS))
				.build()
				.start();

		System.out.println("Service-2 started, listening on " + port);

		server.awaitTermination();
	}

	private static void registerService(int port, String serviceName) {
		try {
			JmDNS jmdns = JmDNS.create();
			ServiceInfo serviceInfo = ServiceInfo.create(SERVICE_TYPE, serviceName, port, serviceName);
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

	// Smart Waste Management Functionality Implementations

	@Override
	public void checkBinStatus(CheckBinStatusRequest request, StreamObserver<CheckBinStatusResponse> responseObserver) {
		try {
			// Complex logic to determine bin status and fill level
			boolean isFull = checkBinFullStatus(request.getBinId());
			int fillLevel = calculateFillLevel(request.getBinId());

			// Store the fill level in the map for monitoring trends
			fillLevelsMap.put(request.getBinId(), fillLevel);

			// Prepare the response with bin status
			CheckBinStatusResponse response = CheckBinStatusResponse.newBuilder()
					.setIsFull(isFull)
					.setFillLevel(fillLevel)
					.setMessage("Bin status retrieved successfully")
					.build();

			responseObserver.onNext(response);
			responseObserver.onCompleted();
		} catch (Exception e) {
			responseObserver.onError(
					Status.INTERNAL.withDescription("Error checking bin status").withCause(e).asRuntimeException());
		}
	}

	@Override
	public void scheduleCollection(ScheduleCollectionRequest request,
			StreamObserver<ScheduleCollectionResponse> responseObserver) {
		try {
			// Complex logic to schedule waste collection based on historical fill levels
			boolean success = scheduleWasteCollection(request.getAreaId(), request.getSchedule());

			// Prepare the response for scheduled collection
			ScheduleCollectionResponse response = ScheduleCollectionResponse.newBuilder()
					.setSuccess(success)
					.setMessage("Waste collection scheduled successfully")
					.build();

			responseObserver.onNext(response);
			responseObserver.onCompleted();
		} catch (Exception e) {
			responseObserver.onError(Status.INTERNAL.withDescription("Error scheduling waste collection").withCause(e)
					.asRuntimeException());
		}
	}

	@Override
	public void optimizeCollectionRoute(OptimizeCollectionRouteRequest request,
			StreamObserver<OptimizeCollectionRouteResponse> responseObserver) {
		try {
			// Complex logic to optimize the collection route based on historical data
			String optimizedRoute = optimizeCollectionRoute(request.getAreaId());

			// Prepare the response for optimized route
			OptimizeCollectionRouteResponse response = OptimizeCollectionRouteResponse.newBuilder()
					.setSuccess(true) // For simplicity, always setting success to true
					.setOptimizedRoute(optimizedRoute)
					.build();

			responseObserver.onNext(response);
			responseObserver.onCompleted();
		} catch (Exception e) {
			responseObserver.onError(Status.INTERNAL.withDescription("Error optimizing collection route").withCause(e)
					.asRuntimeException());
		}
	}

	// Dummy implementations for the complex logic methods
	private boolean checkBinFullStatus(String binId) {
		// Implement the logic to check if the bin is full
		return false;
	}

	private int calculateFillLevel(String binId) {
		// Implement the logic to calculate the fill level of the bin
		return 0;
	}

	private boolean scheduleWasteCollection(String areaId, String schedule) {
		// Implement the logic to schedule waste collection
		return true;
	}

	private String optimizeCollectionRoute(String areaId) {
		// Implement the logic to optimize the collection route
		return "Optimized Route";
	}
}