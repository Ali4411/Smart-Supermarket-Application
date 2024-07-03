// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: invertorymanagement.proto

package grpc.services.inventorymanagement;

public final class InventoryManagementServiceImpl {
  private InventoryManagementServiceImpl() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_inventorymanagement_ItemRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_inventorymanagement_ItemRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_inventorymanagement_StockLevel_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_inventorymanagement_StockLevel_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_inventorymanagement_UpdateRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_inventorymanagement_UpdateRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_inventorymanagement_Status_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_inventorymanagement_Status_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_inventorymanagement_ItemInfo_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_inventorymanagement_ItemInfo_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\031invertorymanagement.proto\022\023inventoryma" +
      "nagement\"\036\n\013ItemRequest\022\017\n\007item_id\030\001 \001(\t" +
      "\"/\n\nStockLevel\022\017\n\007item_id\030\001 \001(\t\022\020\n\010quant" +
      "ity\030\002 \001(\005\"2\n\rUpdateRequest\022\017\n\007item_id\030\001 " +
      "\001(\t\022\020\n\010quantity\030\002 \001(\005\"*\n\006Status\022\017\n\007messa" +
      "ge\030\001 \001(\t\022\017\n\007success\030\002 \001(\010\"M\n\010ItemInfo\022\017\n" +
      "\007item_id\030\001 \001(\t\022\014\n\004name\030\002 \001(\t\022\023\n\013descript" +
      "ion\030\003 \001(\t\022\r\n\005price\030\004 \001(\0022\203\002\n\020InventoryMa" +
      "nager\022O\n\nCheckStock\022 .inventorymanagemen" +
      "t.ItemRequest\032\037.inventorymanagement.Stoc" +
      "kLevel\022N\n\013UpdateStock\022\".inventorymanagem" +
      "ent.UpdateRequest\032\033.inventorymanagement." +
      "Status\022N\n\013GetItemInfo\022 .inventorymanagem" +
      "ent.ItemRequest\032\035.inventorymanagement.It" +
      "emInfoBE\n!grpc.services.inventorymanagem" +
      "entB\036InventoryManagementServiceImplP\001b\006p" +
      "roto3"
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
    internal_static_inventorymanagement_ItemRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_inventorymanagement_ItemRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_inventorymanagement_ItemRequest_descriptor,
        new java.lang.String[] { "ItemId", });
    internal_static_inventorymanagement_StockLevel_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_inventorymanagement_StockLevel_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_inventorymanagement_StockLevel_descriptor,
        new java.lang.String[] { "ItemId", "Quantity", });
    internal_static_inventorymanagement_UpdateRequest_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_inventorymanagement_UpdateRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_inventorymanagement_UpdateRequest_descriptor,
        new java.lang.String[] { "ItemId", "Quantity", });
    internal_static_inventorymanagement_Status_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_inventorymanagement_Status_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_inventorymanagement_Status_descriptor,
        new java.lang.String[] { "Message", "Success", });
    internal_static_inventorymanagement_ItemInfo_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_inventorymanagement_ItemInfo_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_inventorymanagement_ItemInfo_descriptor,
        new java.lang.String[] { "ItemId", "Name", "Description", "Price", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}