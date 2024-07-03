package grpc.services.smartcart;

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
 * The Smart Cart service definition.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: smartcart.proto")
public final class SmartCartGrpc {

  private SmartCartGrpc() {}

  public static final String SERVICE_NAME = "smartcart.SmartCart";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<grpc.services.smartcart.CartUpdateRequest,
      grpc.services.smartcart.CartStatus> getAddToCartMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AddToCart",
      requestType = grpc.services.smartcart.CartUpdateRequest.class,
      responseType = grpc.services.smartcart.CartStatus.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.services.smartcart.CartUpdateRequest,
      grpc.services.smartcart.CartStatus> getAddToCartMethod() {
    io.grpc.MethodDescriptor<grpc.services.smartcart.CartUpdateRequest, grpc.services.smartcart.CartStatus> getAddToCartMethod;
    if ((getAddToCartMethod = SmartCartGrpc.getAddToCartMethod) == null) {
      synchronized (SmartCartGrpc.class) {
        if ((getAddToCartMethod = SmartCartGrpc.getAddToCartMethod) == null) {
          SmartCartGrpc.getAddToCartMethod = getAddToCartMethod = 
              io.grpc.MethodDescriptor.<grpc.services.smartcart.CartUpdateRequest, grpc.services.smartcart.CartStatus>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "smartcart.SmartCart", "AddToCart"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.services.smartcart.CartUpdateRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.services.smartcart.CartStatus.getDefaultInstance()))
                  .setSchemaDescriptor(new SmartCartMethodDescriptorSupplier("AddToCart"))
                  .build();
          }
        }
     }
     return getAddToCartMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.services.smartcart.CartUpdateRequest,
      grpc.services.smartcart.CartStatus> getRemoveFromCartMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RemoveFromCart",
      requestType = grpc.services.smartcart.CartUpdateRequest.class,
      responseType = grpc.services.smartcart.CartStatus.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.services.smartcart.CartUpdateRequest,
      grpc.services.smartcart.CartStatus> getRemoveFromCartMethod() {
    io.grpc.MethodDescriptor<grpc.services.smartcart.CartUpdateRequest, grpc.services.smartcart.CartStatus> getRemoveFromCartMethod;
    if ((getRemoveFromCartMethod = SmartCartGrpc.getRemoveFromCartMethod) == null) {
      synchronized (SmartCartGrpc.class) {
        if ((getRemoveFromCartMethod = SmartCartGrpc.getRemoveFromCartMethod) == null) {
          SmartCartGrpc.getRemoveFromCartMethod = getRemoveFromCartMethod = 
              io.grpc.MethodDescriptor.<grpc.services.smartcart.CartUpdateRequest, grpc.services.smartcart.CartStatus>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "smartcart.SmartCart", "RemoveFromCart"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.services.smartcart.CartUpdateRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.services.smartcart.CartStatus.getDefaultInstance()))
                  .setSchemaDescriptor(new SmartCartMethodDescriptorSupplier("RemoveFromCart"))
                  .build();
          }
        }
     }
     return getRemoveFromCartMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.services.smartcart.CartRequest,
      grpc.services.smartcart.CartContents> getGetCartContentsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetCartContents",
      requestType = grpc.services.smartcart.CartRequest.class,
      responseType = grpc.services.smartcart.CartContents.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<grpc.services.smartcart.CartRequest,
      grpc.services.smartcart.CartContents> getGetCartContentsMethod() {
    io.grpc.MethodDescriptor<grpc.services.smartcart.CartRequest, grpc.services.smartcart.CartContents> getGetCartContentsMethod;
    if ((getGetCartContentsMethod = SmartCartGrpc.getGetCartContentsMethod) == null) {
      synchronized (SmartCartGrpc.class) {
        if ((getGetCartContentsMethod = SmartCartGrpc.getGetCartContentsMethod) == null) {
          SmartCartGrpc.getGetCartContentsMethod = getGetCartContentsMethod = 
              io.grpc.MethodDescriptor.<grpc.services.smartcart.CartRequest, grpc.services.smartcart.CartContents>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "smartcart.SmartCart", "GetCartContents"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.services.smartcart.CartRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.services.smartcart.CartContents.getDefaultInstance()))
                  .setSchemaDescriptor(new SmartCartMethodDescriptorSupplier("GetCartContents"))
                  .build();
          }
        }
     }
     return getGetCartContentsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SmartCartStub newStub(io.grpc.Channel channel) {
    return new SmartCartStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SmartCartBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new SmartCartBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SmartCartFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new SmartCartFutureStub(channel);
  }

  /**
   * <pre>
   * The Smart Cart service definition.
   * </pre>
   */
  public static abstract class SmartCartImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * simple RPC. Add an item into cart
     * </pre>
     */
    public void addToCart(grpc.services.smartcart.CartUpdateRequest request,
        io.grpc.stub.StreamObserver<grpc.services.smartcart.CartStatus> responseObserver) {
      asyncUnimplementedUnaryCall(getAddToCartMethod(), responseObserver);
    }

    /**
     * <pre>
     * simple RPC. Remove an item from cart
     * </pre>
     */
    public void removeFromCart(grpc.services.smartcart.CartUpdateRequest request,
        io.grpc.stub.StreamObserver<grpc.services.smartcart.CartStatus> responseObserver) {
      asyncUnimplementedUnaryCall(getRemoveFromCartMethod(), responseObserver);
    }

    /**
     * <pre>
     * server-side streaming RPC.
     * Allows the client to continuously receive updates about the current contents of the cart.
     * </pre>
     */
    public void getCartContents(grpc.services.smartcart.CartRequest request,
        io.grpc.stub.StreamObserver<grpc.services.smartcart.CartContents> responseObserver) {
      asyncUnimplementedUnaryCall(getGetCartContentsMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getAddToCartMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.services.smartcart.CartUpdateRequest,
                grpc.services.smartcart.CartStatus>(
                  this, METHODID_ADD_TO_CART)))
          .addMethod(
            getRemoveFromCartMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.services.smartcart.CartUpdateRequest,
                grpc.services.smartcart.CartStatus>(
                  this, METHODID_REMOVE_FROM_CART)))
          .addMethod(
            getGetCartContentsMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                grpc.services.smartcart.CartRequest,
                grpc.services.smartcart.CartContents>(
                  this, METHODID_GET_CART_CONTENTS)))
          .build();
    }
  }

  /**
   * <pre>
   * The Smart Cart service definition.
   * </pre>
   */
  public static final class SmartCartStub extends io.grpc.stub.AbstractStub<SmartCartStub> {
    private SmartCartStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SmartCartStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SmartCartStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SmartCartStub(channel, callOptions);
    }

    /**
     * <pre>
     * simple RPC. Add an item into cart
     * </pre>
     */
    public void addToCart(grpc.services.smartcart.CartUpdateRequest request,
        io.grpc.stub.StreamObserver<grpc.services.smartcart.CartStatus> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAddToCartMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * simple RPC. Remove an item from cart
     * </pre>
     */
    public void removeFromCart(grpc.services.smartcart.CartUpdateRequest request,
        io.grpc.stub.StreamObserver<grpc.services.smartcart.CartStatus> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getRemoveFromCartMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * server-side streaming RPC.
     * Allows the client to continuously receive updates about the current contents of the cart.
     * </pre>
     */
    public void getCartContents(grpc.services.smartcart.CartRequest request,
        io.grpc.stub.StreamObserver<grpc.services.smartcart.CartContents> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getGetCartContentsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * The Smart Cart service definition.
   * </pre>
   */
  public static final class SmartCartBlockingStub extends io.grpc.stub.AbstractStub<SmartCartBlockingStub> {
    private SmartCartBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SmartCartBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SmartCartBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SmartCartBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * simple RPC. Add an item into cart
     * </pre>
     */
    public grpc.services.smartcart.CartStatus addToCart(grpc.services.smartcart.CartUpdateRequest request) {
      return blockingUnaryCall(
          getChannel(), getAddToCartMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * simple RPC. Remove an item from cart
     * </pre>
     */
    public grpc.services.smartcart.CartStatus removeFromCart(grpc.services.smartcart.CartUpdateRequest request) {
      return blockingUnaryCall(
          getChannel(), getRemoveFromCartMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * server-side streaming RPC.
     * Allows the client to continuously receive updates about the current contents of the cart.
     * </pre>
     */
    public java.util.Iterator<grpc.services.smartcart.CartContents> getCartContents(
        grpc.services.smartcart.CartRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getGetCartContentsMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * The Smart Cart service definition.
   * </pre>
   */
  public static final class SmartCartFutureStub extends io.grpc.stub.AbstractStub<SmartCartFutureStub> {
    private SmartCartFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SmartCartFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SmartCartFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SmartCartFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * simple RPC. Add an item into cart
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.services.smartcart.CartStatus> addToCart(
        grpc.services.smartcart.CartUpdateRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getAddToCartMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * simple RPC. Remove an item from cart
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.services.smartcart.CartStatus> removeFromCart(
        grpc.services.smartcart.CartUpdateRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getRemoveFromCartMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ADD_TO_CART = 0;
  private static final int METHODID_REMOVE_FROM_CART = 1;
  private static final int METHODID_GET_CART_CONTENTS = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final SmartCartImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(SmartCartImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ADD_TO_CART:
          serviceImpl.addToCart((grpc.services.smartcart.CartUpdateRequest) request,
              (io.grpc.stub.StreamObserver<grpc.services.smartcart.CartStatus>) responseObserver);
          break;
        case METHODID_REMOVE_FROM_CART:
          serviceImpl.removeFromCart((grpc.services.smartcart.CartUpdateRequest) request,
              (io.grpc.stub.StreamObserver<grpc.services.smartcart.CartStatus>) responseObserver);
          break;
        case METHODID_GET_CART_CONTENTS:
          serviceImpl.getCartContents((grpc.services.smartcart.CartRequest) request,
              (io.grpc.stub.StreamObserver<grpc.services.smartcart.CartContents>) responseObserver);
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

  private static abstract class SmartCartBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SmartCartBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpc.services.smartcart.SmartCartServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SmartCart");
    }
  }

  private static final class SmartCartFileDescriptorSupplier
      extends SmartCartBaseDescriptorSupplier {
    SmartCartFileDescriptorSupplier() {}
  }

  private static final class SmartCartMethodDescriptorSupplier
      extends SmartCartBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    SmartCartMethodDescriptorSupplier(String methodName) {
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
      synchronized (SmartCartGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SmartCartFileDescriptorSupplier())
              .addMethod(getAddToCartMethod())
              .addMethod(getRemoveFromCartMethod())
              .addMethod(getGetCartContentsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
