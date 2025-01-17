// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: invertorymanagement.proto

package grpc.services.inventorymanagement;

/**
 * <pre>
 * The request message containing the item ID.
 * </pre>
 *
 * Protobuf type {@code inventorymanagement.ItemRequest}
 */
public  final class ItemRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:inventorymanagement.ItemRequest)
    ItemRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use ItemRequest.newBuilder() to construct.
  private ItemRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private ItemRequest() {
    itemId_ = "";
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private ItemRequest(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10: {
            java.lang.String s = input.readStringRequireUtf8();

            itemId_ = s;
            break;
          }
          default: {
            if (!parseUnknownFieldProto3(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return grpc.services.inventorymanagement.InventoryManagementServiceImpl.internal_static_inventorymanagement_ItemRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return grpc.services.inventorymanagement.InventoryManagementServiceImpl.internal_static_inventorymanagement_ItemRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            grpc.services.inventorymanagement.ItemRequest.class, grpc.services.inventorymanagement.ItemRequest.Builder.class);
  }

  public static final int ITEM_ID_FIELD_NUMBER = 1;
  private volatile java.lang.Object itemId_;
  /**
   * <pre>
   * ID of the item to check stock info and item info
   * </pre>
   *
   * <code>string item_id = 1;</code>
   */
  public java.lang.String getItemId() {
    java.lang.Object ref = itemId_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      itemId_ = s;
      return s;
    }
  }
  /**
   * <pre>
   * ID of the item to check stock info and item info
   * </pre>
   *
   * <code>string item_id = 1;</code>
   */
  public com.google.protobuf.ByteString
      getItemIdBytes() {
    java.lang.Object ref = itemId_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      itemId_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!getItemIdBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, itemId_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getItemIdBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, itemId_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof grpc.services.inventorymanagement.ItemRequest)) {
      return super.equals(obj);
    }
    grpc.services.inventorymanagement.ItemRequest other = (grpc.services.inventorymanagement.ItemRequest) obj;

    boolean result = true;
    result = result && getItemId()
        .equals(other.getItemId());
    result = result && unknownFields.equals(other.unknownFields);
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + ITEM_ID_FIELD_NUMBER;
    hash = (53 * hash) + getItemId().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static grpc.services.inventorymanagement.ItemRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static grpc.services.inventorymanagement.ItemRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static grpc.services.inventorymanagement.ItemRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static grpc.services.inventorymanagement.ItemRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static grpc.services.inventorymanagement.ItemRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static grpc.services.inventorymanagement.ItemRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static grpc.services.inventorymanagement.ItemRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static grpc.services.inventorymanagement.ItemRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static grpc.services.inventorymanagement.ItemRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static grpc.services.inventorymanagement.ItemRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static grpc.services.inventorymanagement.ItemRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static grpc.services.inventorymanagement.ItemRequest parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(grpc.services.inventorymanagement.ItemRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * <pre>
   * The request message containing the item ID.
   * </pre>
   *
   * Protobuf type {@code inventorymanagement.ItemRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:inventorymanagement.ItemRequest)
      grpc.services.inventorymanagement.ItemRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return grpc.services.inventorymanagement.InventoryManagementServiceImpl.internal_static_inventorymanagement_ItemRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return grpc.services.inventorymanagement.InventoryManagementServiceImpl.internal_static_inventorymanagement_ItemRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              grpc.services.inventorymanagement.ItemRequest.class, grpc.services.inventorymanagement.ItemRequest.Builder.class);
    }

    // Construct using grpc.services.inventorymanagement.ItemRequest.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      itemId_ = "";

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return grpc.services.inventorymanagement.InventoryManagementServiceImpl.internal_static_inventorymanagement_ItemRequest_descriptor;
    }

    @java.lang.Override
    public grpc.services.inventorymanagement.ItemRequest getDefaultInstanceForType() {
      return grpc.services.inventorymanagement.ItemRequest.getDefaultInstance();
    }

    @java.lang.Override
    public grpc.services.inventorymanagement.ItemRequest build() {
      grpc.services.inventorymanagement.ItemRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public grpc.services.inventorymanagement.ItemRequest buildPartial() {
      grpc.services.inventorymanagement.ItemRequest result = new grpc.services.inventorymanagement.ItemRequest(this);
      result.itemId_ = itemId_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return (Builder) super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof grpc.services.inventorymanagement.ItemRequest) {
        return mergeFrom((grpc.services.inventorymanagement.ItemRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(grpc.services.inventorymanagement.ItemRequest other) {
      if (other == grpc.services.inventorymanagement.ItemRequest.getDefaultInstance()) return this;
      if (!other.getItemId().isEmpty()) {
        itemId_ = other.itemId_;
        onChanged();
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      grpc.services.inventorymanagement.ItemRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (grpc.services.inventorymanagement.ItemRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object itemId_ = "";
    /**
     * <pre>
     * ID of the item to check stock info and item info
     * </pre>
     *
     * <code>string item_id = 1;</code>
     */
    public java.lang.String getItemId() {
      java.lang.Object ref = itemId_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        itemId_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <pre>
     * ID of the item to check stock info and item info
     * </pre>
     *
     * <code>string item_id = 1;</code>
     */
    public com.google.protobuf.ByteString
        getItemIdBytes() {
      java.lang.Object ref = itemId_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        itemId_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <pre>
     * ID of the item to check stock info and item info
     * </pre>
     *
     * <code>string item_id = 1;</code>
     */
    public Builder setItemId(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      itemId_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * ID of the item to check stock info and item info
     * </pre>
     *
     * <code>string item_id = 1;</code>
     */
    public Builder clearItemId() {
      
      itemId_ = getDefaultInstance().getItemId();
      onChanged();
      return this;
    }
    /**
     * <pre>
     * ID of the item to check stock info and item info
     * </pre>
     *
     * <code>string item_id = 1;</code>
     */
    public Builder setItemIdBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      itemId_ = value;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:inventorymanagement.ItemRequest)
  }

  // @@protoc_insertion_point(class_scope:inventorymanagement.ItemRequest)
  private static final grpc.services.inventorymanagement.ItemRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new grpc.services.inventorymanagement.ItemRequest();
  }

  public static grpc.services.inventorymanagement.ItemRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<ItemRequest>
      PARSER = new com.google.protobuf.AbstractParser<ItemRequest>() {
    @java.lang.Override
    public ItemRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new ItemRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<ItemRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<ItemRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public grpc.services.inventorymanagement.ItemRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

