// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: smartcart.proto

package grpc.services.smartcart;

public final class SmartCartServiceImpl {
  private SmartCartServiceImpl() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_smartcart_CartUpdateRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_smartcart_CartUpdateRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_smartcart_CartStatus_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_smartcart_CartStatus_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_smartcart_CartRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_smartcart_CartRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_smartcart_CartContents_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_smartcart_CartContents_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_smartcart_CartItem_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_smartcart_CartItem_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\017smartcart.proto\022\tsmartcart\"5\n\021CartUpda" +
      "teRequest\022\017\n\007item_id\030\001 \001(\t\022\017\n\007cart_id\030\002 " +
      "\001(\t\".\n\nCartStatus\022\017\n\007message\030\001 \001(\t\022\017\n\007su" +
      "ccess\030\002 \001(\010\"\036\n\013CartRequest\022\017\n\007cart_id\030\001 " +
      "\001(\t\"R\n\014CartContents\022\"\n\005items\030\001 \003(\0132\023.sma" +
      "rtcart.CartItem\022\017\n\007cart_id\030\002 \001(\t\022\r\n\005tota" +
      "l\030\003 \001(\002\"J\n\010CartItem\022\017\n\007item_id\030\001 \001(\t\022\014\n\004" +
      "name\030\002 \001(\t\022\020\n\010quantity\030\003 \001(\005\022\r\n\005price\030\004 " +
      "\001(\0022\332\001\n\tSmartCart\022@\n\tAddToCart\022\034.smartca" +
      "rt.CartUpdateRequest\032\025.smartcart.CartSta" +
      "tus\022E\n\016RemoveFromCart\022\034.smartcart.CartUp" +
      "dateRequest\032\025.smartcart.CartStatus\022D\n\017Ge" +
      "tCartContents\022\026.smartcart.CartRequest\032\027." +
      "smartcart.CartContents0\001B1\n\027grpc.service" +
      "s.smartcartB\024SmartCartServiceImplP\001b\006pro" +
      "to3"
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
    internal_static_smartcart_CartUpdateRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_smartcart_CartUpdateRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_smartcart_CartUpdateRequest_descriptor,
        new java.lang.String[] { "ItemId", "CartId", });
    internal_static_smartcart_CartStatus_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_smartcart_CartStatus_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_smartcart_CartStatus_descriptor,
        new java.lang.String[] { "Message", "Success", });
    internal_static_smartcart_CartRequest_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_smartcart_CartRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_smartcart_CartRequest_descriptor,
        new java.lang.String[] { "CartId", });
    internal_static_smartcart_CartContents_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_smartcart_CartContents_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_smartcart_CartContents_descriptor,
        new java.lang.String[] { "Items", "CartId", "Total", });
    internal_static_smartcart_CartItem_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_smartcart_CartItem_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_smartcart_CartItem_descriptor,
        new java.lang.String[] { "ItemId", "Name", "Quantity", "Price", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}