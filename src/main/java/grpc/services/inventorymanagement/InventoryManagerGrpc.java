package grpc.services.inventorymanagement;

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
 * The Inventory Managment service definition.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: invertorymanagement.proto")
public final class InventoryManagerGrpc {

  private InventoryManagerGrpc() {}

  public static final String SERVICE_NAME = "inventorymanagement.InventoryManager";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<grpc.services.inventorymanagement.ItemRequest,
      grpc.services.inventorymanagement.StockLevel> getCheckStockMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CheckStock",
      requestType = grpc.services.inventorymanagement.ItemRequest.class,
      responseType = grpc.services.inventorymanagement.StockLevel.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.services.inventorymanagement.ItemRequest,
      grpc.services.inventorymanagement.StockLevel> getCheckStockMethod() {
    io.grpc.MethodDescriptor<grpc.services.inventorymanagement.ItemRequest, grpc.services.inventorymanagement.StockLevel> getCheckStockMethod;
    if ((getCheckStockMethod = InventoryManagerGrpc.getCheckStockMethod) == null) {
      synchronized (InventoryManagerGrpc.class) {
        if ((getCheckStockMethod = InventoryManagerGrpc.getCheckStockMethod) == null) {
          InventoryManagerGrpc.getCheckStockMethod = getCheckStockMethod = 
              io.grpc.MethodDescriptor.<grpc.services.inventorymanagement.ItemRequest, grpc.services.inventorymanagement.StockLevel>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "inventorymanagement.InventoryManager", "CheckStock"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.services.inventorymanagement.ItemRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.services.inventorymanagement.StockLevel.getDefaultInstance()))
                  .setSchemaDescriptor(new InventoryManagerMethodDescriptorSupplier("CheckStock"))
                  .build();
          }
        }
     }
     return getCheckStockMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.services.inventorymanagement.UpdateRequest,
      grpc.services.inventorymanagement.Status> getUpdateStockMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateStock",
      requestType = grpc.services.inventorymanagement.UpdateRequest.class,
      responseType = grpc.services.inventorymanagement.Status.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.services.inventorymanagement.UpdateRequest,
      grpc.services.inventorymanagement.Status> getUpdateStockMethod() {
    io.grpc.MethodDescriptor<grpc.services.inventorymanagement.UpdateRequest, grpc.services.inventorymanagement.Status> getUpdateStockMethod;
    if ((getUpdateStockMethod = InventoryManagerGrpc.getUpdateStockMethod) == null) {
      synchronized (InventoryManagerGrpc.class) {
        if ((getUpdateStockMethod = InventoryManagerGrpc.getUpdateStockMethod) == null) {
          InventoryManagerGrpc.getUpdateStockMethod = getUpdateStockMethod = 
              io.grpc.MethodDescriptor.<grpc.services.inventorymanagement.UpdateRequest, grpc.services.inventorymanagement.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "inventorymanagement.InventoryManager", "UpdateStock"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.services.inventorymanagement.UpdateRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.services.inventorymanagement.Status.getDefaultInstance()))
                  .setSchemaDescriptor(new InventoryManagerMethodDescriptorSupplier("UpdateStock"))
                  .build();
          }
        }
     }
     return getUpdateStockMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.services.inventorymanagement.ItemRequest,
      grpc.services.inventorymanagement.ItemInfo> getGetItemInfoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetItemInfo",
      requestType = grpc.services.inventorymanagement.ItemRequest.class,
      responseType = grpc.services.inventorymanagement.ItemInfo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.services.inventorymanagement.ItemRequest,
      grpc.services.inventorymanagement.ItemInfo> getGetItemInfoMethod() {
    io.grpc.MethodDescriptor<grpc.services.inventorymanagement.ItemRequest, grpc.services.inventorymanagement.ItemInfo> getGetItemInfoMethod;
    if ((getGetItemInfoMethod = InventoryManagerGrpc.getGetItemInfoMethod) == null) {
      synchronized (InventoryManagerGrpc.class) {
        if ((getGetItemInfoMethod = InventoryManagerGrpc.getGetItemInfoMethod) == null) {
          InventoryManagerGrpc.getGetItemInfoMethod = getGetItemInfoMethod = 
              io.grpc.MethodDescriptor.<grpc.services.inventorymanagement.ItemRequest, grpc.services.inventorymanagement.ItemInfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "inventorymanagement.InventoryManager", "GetItemInfo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.services.inventorymanagement.ItemRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.services.inventorymanagement.ItemInfo.getDefaultInstance()))
                  .setSchemaDescriptor(new InventoryManagerMethodDescriptorSupplier("GetItemInfo"))
                  .build();
          }
        }
     }
     return getGetItemInfoMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static InventoryManagerStub newStub(io.grpc.Channel channel) {
    return new InventoryManagerStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static InventoryManagerBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new InventoryManagerBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static InventoryManagerFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new InventoryManagerFutureStub(channel);
  }

  /**
   * <pre>
   * The Inventory Managment service definition.
   * </pre>
   */
  public static abstract class InventoryManagerImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Manage inventory
     * </pre>
     */
    public void checkStock(grpc.services.inventorymanagement.ItemRequest request,
        io.grpc.stub.StreamObserver<grpc.services.inventorymanagement.StockLevel> responseObserver) {
      asyncUnimplementedUnaryCall(getCheckStockMethod(), responseObserver);
    }

    /**
     * <pre>
     *simple RPC
     * </pre>
     */
    public void updateStock(grpc.services.inventorymanagement.UpdateRequest request,
        io.grpc.stub.StreamObserver<grpc.services.inventorymanagement.Status> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateStockMethod(), responseObserver);
    }

    /**
     * <pre>
     *simple RPC
     * </pre>
     */
    public void getItemInfo(grpc.services.inventorymanagement.ItemRequest request,
        io.grpc.stub.StreamObserver<grpc.services.inventorymanagement.ItemInfo> responseObserver) {
      asyncUnimplementedUnaryCall(getGetItemInfoMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCheckStockMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.services.inventorymanagement.ItemRequest,
                grpc.services.inventorymanagement.StockLevel>(
                  this, METHODID_CHECK_STOCK)))
          .addMethod(
            getUpdateStockMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.services.inventorymanagement.UpdateRequest,
                grpc.services.inventorymanagement.Status>(
                  this, METHODID_UPDATE_STOCK)))
          .addMethod(
            getGetItemInfoMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.services.inventorymanagement.ItemRequest,
                grpc.services.inventorymanagement.ItemInfo>(
                  this, METHODID_GET_ITEM_INFO)))
          .build();
    }
  }

  /**
   * <pre>
   * The Inventory Managment service definition.
   * </pre>
   */
  public static final class InventoryManagerStub extends io.grpc.stub.AbstractStub<InventoryManagerStub> {
    private InventoryManagerStub(io.grpc.Channel channel) {
      super(channel);
    }

    private InventoryManagerStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected InventoryManagerStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new InventoryManagerStub(channel, callOptions);
    }

    /**
     * <pre>
     * Manage inventory
     * </pre>
     */
    public void checkStock(grpc.services.inventorymanagement.ItemRequest request,
        io.grpc.stub.StreamObserver<grpc.services.inventorymanagement.StockLevel> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCheckStockMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *simple RPC
     * </pre>
     */
    public void updateStock(grpc.services.inventorymanagement.UpdateRequest request,
        io.grpc.stub.StreamObserver<grpc.services.inventorymanagement.Status> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateStockMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *simple RPC
     * </pre>
     */
    public void getItemInfo(grpc.services.inventorymanagement.ItemRequest request,
        io.grpc.stub.StreamObserver<grpc.services.inventorymanagement.ItemInfo> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetItemInfoMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * The Inventory Managment service definition.
   * </pre>
   */
  public static final class InventoryManagerBlockingStub extends io.grpc.stub.AbstractStub<InventoryManagerBlockingStub> {
    private InventoryManagerBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private InventoryManagerBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected InventoryManagerBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new InventoryManagerBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Manage inventory
     * </pre>
     */
    public grpc.services.inventorymanagement.StockLevel checkStock(grpc.services.inventorymanagement.ItemRequest request) {
      return blockingUnaryCall(
          getChannel(), getCheckStockMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *simple RPC
     * </pre>
     */
    public grpc.services.inventorymanagement.Status updateStock(grpc.services.inventorymanagement.UpdateRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateStockMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *simple RPC
     * </pre>
     */
    public grpc.services.inventorymanagement.ItemInfo getItemInfo(grpc.services.inventorymanagement.ItemRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetItemInfoMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * The Inventory Managment service definition.
   * </pre>
   */
  public static final class InventoryManagerFutureStub extends io.grpc.stub.AbstractStub<InventoryManagerFutureStub> {
    private InventoryManagerFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private InventoryManagerFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected InventoryManagerFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new InventoryManagerFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Manage inventory
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.services.inventorymanagement.StockLevel> checkStock(
        grpc.services.inventorymanagement.ItemRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCheckStockMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     *simple RPC
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.services.inventorymanagement.Status> updateStock(
        grpc.services.inventorymanagement.UpdateRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateStockMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     *simple RPC
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.services.inventorymanagement.ItemInfo> getItemInfo(
        grpc.services.inventorymanagement.ItemRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetItemInfoMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CHECK_STOCK = 0;
  private static final int METHODID_UPDATE_STOCK = 1;
  private static final int METHODID_GET_ITEM_INFO = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final InventoryManagerImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(InventoryManagerImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CHECK_STOCK:
          serviceImpl.checkStock((grpc.services.inventorymanagement.ItemRequest) request,
              (io.grpc.stub.StreamObserver<grpc.services.inventorymanagement.StockLevel>) responseObserver);
          break;
        case METHODID_UPDATE_STOCK:
          serviceImpl.updateStock((grpc.services.inventorymanagement.UpdateRequest) request,
              (io.grpc.stub.StreamObserver<grpc.services.inventorymanagement.Status>) responseObserver);
          break;
        case METHODID_GET_ITEM_INFO:
          serviceImpl.getItemInfo((grpc.services.inventorymanagement.ItemRequest) request,
              (io.grpc.stub.StreamObserver<grpc.services.inventorymanagement.ItemInfo>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class InventoryManagerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    InventoryManagerBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpc.services.inventorymanagement.InventoryManagementServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("InventoryManager");
    }
  }

  private static final class InventoryManagerFileDescriptorSupplier
      extends InventoryManagerBaseDescriptorSupplier {
    InventoryManagerFileDescriptorSupplier() {}
  }

  private static final class InventoryManagerMethodDescriptorSupplier
      extends InventoryManagerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    InventoryManagerMethodDescriptorSupplier(String methodName) {
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
      synchronized (InventoryManagerGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new InventoryManagerFileDescriptorSupplier())
              .addMethod(getCheckStockMethod())
              .addMethod(getUpdateStockMethod())
              .addMethod(getGetItemInfoMethod())
              .build();
        }
      }
    }
    return result;
  }
}
