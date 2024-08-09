package ds.service3;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 * <pre>
 * Interface exported by the server.
 * </pre>
 */
@javax.annotation.Generated(value = "by gRPC proto compiler (version 1.15.0)", comments = "Source: service3.proto")
public final class Service3Grpc {

  private Service3Grpc() {
  }

  public static final String SERVICE_NAME = "service3.Service3";

  // Static method descriptors that strictly reflect the proto.
  private static volatile MethodDescriptor<MonitorEnergyUsageRequest, MonitorEnergyUsageResponse> getMonitorEnergyUsageMethod;

  @RpcMethod(fullMethodName = SERVICE_NAME + '/'
      + "MonitorEnergyUsage", requestType = MonitorEnergyUsageRequest.class, responseType = MonitorEnergyUsageResponse.class, methodType = MethodDescriptor.MethodType.UNARY)
  public static MethodDescriptor<MonitorEnergyUsageRequest, MonitorEnergyUsageResponse> getMonitorEnergyUsageMethod() {
    MethodDescriptor<MonitorEnergyUsageRequest, MonitorEnergyUsageResponse> getMonitorEnergyUsageMethod;
    if ((getMonitorEnergyUsageMethod = Service3Grpc.getMonitorEnergyUsageMethod) == null) {
      synchronized (Service3Grpc.class) {
        if ((getMonitorEnergyUsageMethod = Service3Grpc.getMonitorEnergyUsageMethod) == null) {
          Service3Grpc.getMonitorEnergyUsageMethod = getMonitorEnergyUsageMethod = MethodDescriptor
              .<MonitorEnergyUsageRequest, MonitorEnergyUsageResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "service3.Service3", "MonitorEnergyUsage"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(ProtoUtils.marshaller(
                  MonitorEnergyUsageRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(
                  MonitorEnergyUsageResponse.getDefaultInstance()))
              .setSchemaDescriptor(new Service3MethodDescriptorSupplier("MonitorEnergyUsage"))
              .build();
        }
      }
    }
    return getMonitorEnergyUsageMethod;
  }

  private static volatile MethodDescriptor<AdjustEnergyDistributionRequest, AdjustEnergyDistributionResponse> getAdjustEnergyDistributionMethod;

  @RpcMethod(fullMethodName = SERVICE_NAME + '/'
      + "AdjustEnergyDistribution", requestType = AdjustEnergyDistributionRequest.class, responseType = AdjustEnergyDistributionResponse.class, methodType = MethodDescriptor.MethodType.UNARY)
  public static MethodDescriptor<AdjustEnergyDistributionRequest, AdjustEnergyDistributionResponse> getAdjustEnergyDistributionMethod() {
    MethodDescriptor<AdjustEnergyDistributionRequest, AdjustEnergyDistributionResponse> getAdjustEnergyDistributionMethod;
    if ((getAdjustEnergyDistributionMethod = Service3Grpc.getAdjustEnergyDistributionMethod) == null) {
      synchronized (Service3Grpc.class) {
        if ((getAdjustEnergyDistributionMethod = Service3Grpc.getAdjustEnergyDistributionMethod) == null) {
          Service3Grpc.getAdjustEnergyDistributionMethod = getAdjustEnergyDistributionMethod = MethodDescriptor
              .<AdjustEnergyDistributionRequest, AdjustEnergyDistributionResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "service3.Service3", "AdjustEnergyDistribution"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(ProtoUtils.marshaller(
                  AdjustEnergyDistributionRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(
                  AdjustEnergyDistributionResponse.getDefaultInstance()))
              .setSchemaDescriptor(new Service3MethodDescriptorSupplier("AdjustEnergyDistribution"))
              .build();
        }
      }
    }
    return getAdjustEnergyDistributionMethod;
  }

  private static volatile MethodDescriptor<ScheduleEnergySavingRequest, ScheduleEnergySavingResponse> getScheduleEnergySavingMethod;

  @RpcMethod(fullMethodName = SERVICE_NAME + '/'
      + "ScheduleEnergySaving", requestType = ScheduleEnergySavingRequest.class, responseType = ScheduleEnergySavingResponse.class, methodType = MethodDescriptor.MethodType.UNARY)
  public static MethodDescriptor<ScheduleEnergySavingRequest, ScheduleEnergySavingResponse> getScheduleEnergySavingMethod() {
    MethodDescriptor<ScheduleEnergySavingRequest, ScheduleEnergySavingResponse> getScheduleEnergySavingMethod;
    if ((getScheduleEnergySavingMethod = Service3Grpc.getScheduleEnergySavingMethod) == null) {
      synchronized (Service3Grpc.class) {
        if ((getScheduleEnergySavingMethod = Service3Grpc.getScheduleEnergySavingMethod) == null) {
          Service3Grpc.getScheduleEnergySavingMethod = getScheduleEnergySavingMethod = MethodDescriptor
              .<ScheduleEnergySavingRequest, ScheduleEnergySavingResponse>newBuilder()
              .setType(MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "service3.Service3", "ScheduleEnergySaving"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(ProtoUtils.marshaller(
                  ScheduleEnergySavingRequest.getDefaultInstance()))
              .setResponseMarshaller(ProtoUtils.marshaller(
                  ScheduleEnergySavingResponse.getDefaultInstance()))
              .setSchemaDescriptor(new Service3MethodDescriptorSupplier("ScheduleEnergySaving"))
              .build();
        }
      }
    }
    return getScheduleEnergySavingMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static Service3Stub newStub(io.grpc.Channel channel) {
    return new Service3Stub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output
   * calls on the service
   */
  public static Service3BlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new Service3BlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the
   * service
   */
  public static Service3FutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new Service3FutureStub(channel);
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static abstract class Service3ImplBase implements BindableService {

    public void monitorEnergyUsage(MonitorEnergyUsageRequest request,
        StreamObserver<MonitorEnergyUsageResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getMonitorEnergyUsageMethod(), responseObserver);
    }

    public void adjustEnergyDistribution(AdjustEnergyDistributionRequest request,
        StreamObserver<AdjustEnergyDistributionResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getAdjustEnergyDistributionMethod(), responseObserver);
    }

    public void scheduleEnergySaving(ScheduleEnergySavingRequest request,
        StreamObserver<ScheduleEnergySavingResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getScheduleEnergySavingMethod(), responseObserver);
    }

    @java.lang.Override
    public final ServerServiceDefinition bindService() {
      return ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getMonitorEnergyUsageMethod(),
              asyncUnaryCall(
                  new MethodHandlers<MonitorEnergyUsageRequest, MonitorEnergyUsageResponse>(
                      this, METHODID_MONITOR_ENERGY_USAGE)))
          .addMethod(
              getAdjustEnergyDistributionMethod(),
              asyncUnaryCall(
                  new MethodHandlers<AdjustEnergyDistributionRequest, AdjustEnergyDistributionResponse>(
                      this, METHODID_ADJUST_ENERGY_DISTRIBUTION)))
          .addMethod(
              getScheduleEnergySavingMethod(),
              asyncUnaryCall(
                  new MethodHandlers<ScheduleEnergySavingRequest, ScheduleEnergySavingResponse>(
                      this, METHODID_SCHEDULE_ENERGY_SAVING)))
          .build();
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class Service3Stub extends io.grpc.stub.AbstractStub<Service3Stub> {
    private Service3Stub(io.grpc.Channel channel) {
      super(channel);
    }

    private Service3Stub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected Service3Stub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new Service3Stub(channel, callOptions);
    }

    public void monitorEnergyUsage(MonitorEnergyUsageRequest request,
        StreamObserver<MonitorEnergyUsageResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getMonitorEnergyUsageMethod(), getCallOptions()), request, responseObserver);
    }

    public void adjustEnergyDistribution(AdjustEnergyDistributionRequest request,
        StreamObserver<AdjustEnergyDistributionResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAdjustEnergyDistributionMethod(), getCallOptions()), request, responseObserver);
    }

    public void scheduleEnergySaving(ScheduleEnergySavingRequest request,
        StreamObserver<ScheduleEnergySavingResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getScheduleEnergySavingMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class Service3BlockingStub extends io.grpc.stub.AbstractStub<Service3BlockingStub> {
    private Service3BlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private Service3BlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected Service3BlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new Service3BlockingStub(channel, callOptions);
    }

    public MonitorEnergyUsageResponse monitorEnergyUsage(MonitorEnergyUsageRequest request) {
      return blockingUnaryCall(
          getChannel(), getMonitorEnergyUsageMethod(), getCallOptions(), request);
    }

    public AdjustEnergyDistributionResponse adjustEnergyDistribution(AdjustEnergyDistributionRequest request) {
      return blockingUnaryCall(
          getChannel(), getAdjustEnergyDistributionMethod(), getCallOptions(), request);
    }

    public ScheduleEnergySavingResponse scheduleEnergySaving(ScheduleEnergySavingRequest request) {
      return blockingUnaryCall(
          getChannel(), getScheduleEnergySavingMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class Service3FutureStub extends io.grpc.stub.AbstractStub<Service3FutureStub> {
    private Service3FutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private Service3FutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected Service3FutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new Service3FutureStub(channel, callOptions);
    }

    public com.google.common.util.concurrent.ListenableFuture<MonitorEnergyUsageResponse> monitorEnergyUsage(
        MonitorEnergyUsageRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getMonitorEnergyUsageMethod(), getCallOptions()), request);
    }

    public com.google.common.util.concurrent.ListenableFuture<AdjustEnergyDistributionResponse> adjustEnergyDistribution(
        AdjustEnergyDistributionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getAdjustEnergyDistributionMethod(), getCallOptions()), request);
    }

    public com.google.common.util.concurrent.ListenableFuture<ScheduleEnergySavingResponse> scheduleEnergySaving(
        ScheduleEnergySavingRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getScheduleEnergySavingMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_MONITOR_ENERGY_USAGE = 0;
  private static final int METHODID_ADJUST_ENERGY_DISTRIBUTION = 1;
  private static final int METHODID_SCHEDULE_ENERGY_SAVING = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final Service3ImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(Service3ImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_MONITOR_ENERGY_USAGE:
          serviceImpl.monitorEnergyUsage((MonitorEnergyUsageRequest) request,
              (StreamObserver<MonitorEnergyUsageResponse>) responseObserver);
          break;
        case METHODID_ADJUST_ENERGY_DISTRIBUTION:
          serviceImpl.adjustEnergyDistribution((AdjustEnergyDistributionRequest) request,
              (StreamObserver<AdjustEnergyDistributionResponse>) responseObserver);
          break;
        case METHODID_SCHEDULE_ENERGY_SAVING:
          serviceImpl.scheduleEnergySaving((ScheduleEnergySavingRequest) request,
              (StreamObserver<ScheduleEnergySavingResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public StreamObserver<Req> invoke(
        StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class Service3BaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    Service3BaseDescriptorSupplier() {
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return Service3Impl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Service3");
    }
  }

  private static final class Service3FileDescriptorSupplier
      extends Service3BaseDescriptorSupplier {
    Service3FileDescriptorSupplier() {
    }
  }

  private static final class Service3MethodDescriptorSupplier
      extends Service3BaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    Service3MethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (Service3Grpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new Service3FileDescriptorSupplier())
              .addMethod(getMonitorEnergyUsageMethod())
              .addMethod(getAdjustEnergyDistributionMethod())
              .addMethod(getScheduleEnergySavingMethod())
              .build();
        }
      }
    }
    return result;
  }
}