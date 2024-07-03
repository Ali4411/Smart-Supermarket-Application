// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: checkout.proto

package grpc.services.checkout;

public final class CheckoutServiceImpl {
  private CheckoutServiceImpl() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_checkout_CartContents_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_checkout_CartContents_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_checkout_CartItem_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_checkout_CartItem_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_checkout_Receipt_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_checkout_Receipt_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_checkout_ApplyVoucher_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_checkout_ApplyVoucher_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_checkout_VoucherResult_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_checkout_VoucherResult_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\016checkout.proto\022\010checkout\"Q\n\014CartConten" +
      "ts\022!\n\005items\030\001 \003(\0132\022.checkout.CartItem\022\017\n" +
      "\007cart_id\030\002 \001(\t\022\r\n\005total\030\003 \001(\002\"J\n\010CartIte" +
      "m\022\017\n\007item_id\030\001 \001(\t\022\014\n\004name\030\002 \001(\t\022\020\n\010quan" +
      "tity\030\003 \001(\005\022\r\n\005price\030\004 \001(\002\"]\n\007Receipt\022\026\n\016" +
      "transaction_id\030\001 \001(\t\022\r\n\005total\030\002 \001(\002\022+\n\017p" +
      "urchased_items\030\003 \003(\0132\022.checkout.CartItem" +
      "\"5\n\014ApplyVoucher\022\017\n\007cart_id\030\001 \001(\t\022\024\n\014vou" +
      "cher_code\030\002 \001(\t\"[\n\rVoucherResult\022\017\n\007cart" +
      "_id\030\001 \001(\t\022\027\n\017discount_amount\030\002 \001(\002\022\017\n\007me" +
      "ssage\030\003 \001(\t\022\017\n\007success\030\004 \001(\0102\326\001\n\010Checkou" +
      "t\022I\n\023TransferForCheckout\022\026.checkout.Cart" +
      "Contents\032\026.checkout.CartContents(\0010\001\022=\n\016" +
      "ProcessPayment\022\026.checkout.CartContents\032\021" +
      ".checkout.Receipt(\001\022@\n\rApplyDiscount\022\026.c" +
      "heckout.ApplyVoucher\032\027.checkout.VoucherR" +
      "esultB/\n\026grpc.services.checkoutB\023Checkou" +
      "tServiceImplP\001b\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_checkout_CartContents_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_checkout_CartContents_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_checkout_CartContents_descriptor,
        new java.lang.String[] { "Items", "CartId", "Total", });
    internal_static_checkout_CartItem_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_checkout_CartItem_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_checkout_CartItem_descriptor,
        new java.lang.String[] { "ItemId", "Name", "Quantity", "Price", });
    internal_static_checkout_Receipt_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_checkout_Receipt_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_checkout_Receipt_descriptor,
        new java.lang.String[] { "TransactionId", "Total", "PurchasedItems", });
    internal_static_checkout_ApplyVoucher_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_checkout_ApplyVoucher_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_checkout_ApplyVoucher_descriptor,
        new java.lang.String[] { "CartId", "VoucherCode", });
    internal_static_checkout_VoucherResult_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_checkout_VoucherResult_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_checkout_VoucherResult_descriptor,
        new java.lang.String[] { "CartId", "DiscountAmount", "Message", "Success", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
