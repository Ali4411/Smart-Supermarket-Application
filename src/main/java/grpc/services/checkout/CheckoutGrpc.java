package grpc.services.checkout;

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
 * The Checkout service definition.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: checkout.proto")
public final class CheckoutGrpc {

  private CheckoutGrpc() {}

  public static final String SERVICE_NAME = "checkout.Checkout";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<grpc.services.checkout.CartContents,
      grpc.services.checkout.CartContents> getTransferForCheckoutMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "TransferForCheckout",
      requestType = grpc.services.checkout.CartContents.class,
      responseType = grpc.services.checkout.CartContents.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<grpc.services.checkout.CartContents,
      grpc.services.checkout.CartContents> getTransferForCheckoutMethod() {
    io.grpc.MethodDescriptor<grpc.services.checkout.CartContents, grpc.services.checkout.CartContents> getTransferForCheckoutMethod;
    if ((getTransferForCheckoutMethod = CheckoutGrpc.getTransferForCheckoutMethod) == null) {
      synchronized (CheckoutGrpc.class) {
        if ((getTransferForCheckoutMethod = CheckoutGrpc.getTransferForCheckoutMethod) == null) {
          CheckoutGrpc.getTransferForCheckoutMethod = getTransferForCheckoutMethod = 
              io.grpc.MethodDescriptor.<grpc.services.checkout.CartContents, grpc.services.checkout.CartContents>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "checkout.Checkout", "TransferForCheckout"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.services.checkout.CartContents.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.services.checkout.CartContents.getDefaultInstance()))
                  .setSchemaDescriptor(new CheckoutMethodDescriptorSupplier("TransferForCheckout"))
                  .build();
          }
        }
     }
     return getTransferForCheckoutMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.services.checkout.CartContents,
      grpc.services.checkout.Receipt> getProcessPaymentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ProcessPayment",
      requestType = grpc.services.checkout.CartContents.class,
      responseType = grpc.services.checkout.Receipt.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<grpc.services.checkout.CartContents,
      grpc.services.checkout.Receipt> getProcessPaymentMethod() {
    io.grpc.MethodDescriptor<grpc.services.checkout.CartContents, grpc.services.checkout.Receipt> getProcessPaymentMethod;
    if ((getProcessPaymentMethod = CheckoutGrpc.getProcessPaymentMethod) == null) {
      synchronized (CheckoutGrpc.class) {
        if ((getProcessPaymentMethod = CheckoutGrpc.getProcessPaymentMethod) == null) {
          CheckoutGrpc.getProcessPaymentMethod = getProcessPaymentMethod = 
              io.grpc.MethodDescriptor.<grpc.services.checkout.CartContents, grpc.services.checkout.Receipt>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "checkout.Checkout", "ProcessPayment"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.services.checkout.CartContents.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.services.checkout.Receipt.getDefaultInstance()))
                  .setSchemaDescriptor(new CheckoutMethodDescriptorSupplier("ProcessPayment"))
                  .build();
          }
        }
     }
     return getProcessPaymentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.services.checkout.ApplyVoucher,
      grpc.services.checkout.VoucherResult> getApplyDiscountMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ApplyDiscount",
      requestType = grpc.services.checkout.ApplyVoucher.class,
      responseType = grpc.services.checkout.VoucherResult.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.services.checkout.ApplyVoucher,
      grpc.services.checkout.VoucherResult> getApplyDiscountMethod() {
    io.grpc.MethodDescriptor<grpc.services.checkout.ApplyVoucher, grpc.services.checkout.VoucherResult> getApplyDiscountMethod;
    if ((getApplyDiscountMethod = CheckoutGrpc.getApplyDiscountMethod) == null) {
      synchronized (CheckoutGrpc.class) {
        if ((getApplyDiscountMethod = CheckoutGrpc.getApplyDiscountMethod) == null) {
          CheckoutGrpc.getApplyDiscountMethod = getApplyDiscountMethod = 
              io.grpc.MethodDescriptor.<grpc.services.checkout.ApplyVoucher, grpc.services.checkout.VoucherResult>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "checkout.Checkout", "ApplyDiscount"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.services.checkout.ApplyVoucher.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.services.checkout.VoucherResult.getDefaultInstance()))
                  .setSchemaDescriptor(new CheckoutMethodDescriptorSupplier("ApplyDiscount"))
                  .build();
          }
        }
     }
     return getApplyDiscountMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CheckoutStub newStub(io.grpc.Channel channel) {
    return new CheckoutStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CheckoutBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new CheckoutBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CheckoutFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new CheckoutFutureStub(channel);
  }

  /**
   * <pre>
   * The Checkout service definition.
   * </pre>
   */
  public static abstract class CheckoutImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     *bidirectional streaming RPC
     * </pre>
     */
    public io.grpc.stub.StreamObserver<grpc.services.checkout.CartContents> transferForCheckout(
        io.grpc.stub.StreamObserver<grpc.services.checkout.CartContents> responseObserver) {
      return asyncUnimplementedStreamingCall(getTransferForCheckoutMethod(), responseObserver);
    }

    /**
     * <pre>
     *client-side streaming RPC
     * </pre>
     */
    public io.grpc.stub.StreamObserver<grpc.services.checkout.CartContents> processPayment(
        io.grpc.stub.StreamObserver<grpc.services.checkout.Receipt> responseObserver) {
      return asyncUnimplementedStreamingCall(getProcessPaymentMethod(), responseObserver);
    }

    /**
     * <pre>
     *simple RPC
     * </pre>
     */
    public void applyDiscount(grpc.services.checkout.ApplyVoucher request,
        io.grpc.stub.StreamObserver<grpc.services.checkout.VoucherResult> responseObserver) {
      asyncUnimplementedUnaryCall(getApplyDiscountMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getTransferForCheckoutMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                grpc.services.checkout.CartContents,
                grpc.services.checkout.CartContents>(
                  this, METHODID_TRANSFER_FOR_CHECKOUT)))
          .addMethod(
            getProcessPaymentMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                grpc.services.checkout.CartContents,
                grpc.services.checkout.Receipt>(
                  this, METHODID_PROCESS_PAYMENT)))
          .addMethod(
            getApplyDiscountMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.services.checkout.ApplyVoucher,
                grpc.services.checkout.VoucherResult>(
                  this, METHODID_APPLY_DISCOUNT)))
          .build();
    }
  }

  /**
   * <pre>
   * The Checkout service definition.
   * </pre>
   */
  public static final class CheckoutStub extends io.grpc.stub.AbstractStub<CheckoutStub> {
    private CheckoutStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CheckoutStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CheckoutStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CheckoutStub(channel, callOptions);
    }

    /**
     * <pre>
     *bidirectional streaming RPC
     * </pre>
     */
    public io.grpc.stub.StreamObserver<grpc.services.checkout.CartContents> transferForCheckout(
        io.grpc.stub.StreamObserver<grpc.services.checkout.CartContents> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getTransferForCheckoutMethod(), getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     *client-side streaming RPC
     * </pre>
     */
    public io.grpc.stub.StreamObserver<grpc.services.checkout.CartContents> processPayment(
        io.grpc.stub.StreamObserver<grpc.services.checkout.Receipt> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getProcessPaymentMethod(), getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     *simple RPC
     * </pre>
     */
    public void applyDiscount(grpc.services.checkout.ApplyVoucher request,
        io.grpc.stub.StreamObserver<grpc.services.checkout.VoucherResult> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getApplyDiscountMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * The Checkout service definition.
   * </pre>
   */
  public static final class CheckoutBlockingStub extends io.grpc.stub.AbstractStub<CheckoutBlockingStub> {
    private CheckoutBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CheckoutBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CheckoutBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CheckoutBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     *simple RPC
     * </pre>
     */
    public grpc.services.checkout.VoucherResult applyDiscount(grpc.services.checkout.ApplyVoucher request) {
      return blockingUnaryCall(
          getChannel(), getApplyDiscountMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * The Checkout service definition.
   * </pre>
   */
  public static final class CheckoutFutureStub extends io.grpc.stub.AbstractStub<CheckoutFutureStub> {
    private CheckoutFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CheckoutFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CheckoutFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CheckoutFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     *simple RPC
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.services.checkout.VoucherResult> applyDiscount(
        grpc.services.checkout.ApplyVoucher request) {
      return futureUnaryCall(
          getChannel().newCall(getApplyDiscountMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_APPLY_DISCOUNT = 0;
  private static final int METHODID_TRANSFER_FOR_CHECKOUT = 1;
  private static final int METHODID_PROCESS_PAYMENT = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CheckoutImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CheckoutImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_APPLY_DISCOUNT:
          serviceImpl.applyDiscount((grpc.services.checkout.ApplyVoucher) request,
              (io.grpc.stub.StreamObserver<grpc.services.checkout.VoucherResult>) responseObserver);
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
        case METHODID_TRANSFER_FOR_CHECKOUT:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.transferForCheckout(
              (io.grpc.stub.StreamObserver<grpc.services.checkout.CartContents>) responseObserver);
        case METHODID_PROCESS_PAYMENT:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.processPayment(
              (io.grpc.stub.StreamObserver<grpc.services.checkout.Receipt>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class CheckoutBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CheckoutBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpc.services.checkout.CheckoutServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Checkout");
    }
  }

  private static final class CheckoutFileDescriptorSupplier
      extends CheckoutBaseDescriptorSupplier {
    CheckoutFileDescriptorSupplier() {}
  }

  private static final class CheckoutMethodDescriptorSupplier
      extends CheckoutBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CheckoutMethodDescriptorSupplier(String methodName) {
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
      synchronized (CheckoutGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CheckoutFileDescriptorSupplier())
              .addMethod(getTransferForCheckoutMethod())
              .addMethod(getProcessPaymentMethod())
              .addMethod(getApplyDiscountMethod())
              .build();
        }
      }
    }
    return result;
  }
}
