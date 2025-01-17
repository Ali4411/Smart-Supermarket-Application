// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: checkout.proto

package grpc.services.checkout;

/**
 * Protobuf type {@code checkout.ApplyVoucher}
 */
public  final class ApplyVoucher extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:checkout.ApplyVoucher)
    ApplyVoucherOrBuilder {
private static final long serialVersionUID = 0L;
  // Use ApplyVoucher.newBuilder() to construct.
  private ApplyVoucher(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private ApplyVoucher() {
    cartId_ = "";
    voucherCode_ = "";
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private ApplyVoucher(
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

            cartId_ = s;
            break;
          }
          case 18: {
            java.lang.String s = input.readStringRequireUtf8();

            voucherCode_ = s;
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
    return grpc.services.checkout.CheckoutServiceImpl.internal_static_checkout_ApplyVoucher_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return grpc.services.checkout.CheckoutServiceImpl.internal_static_checkout_ApplyVoucher_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            grpc.services.checkout.ApplyVoucher.class, grpc.services.checkout.ApplyVoucher.Builder.class);
  }

  public static final int CART_ID_FIELD_NUMBER = 1;
  private volatile java.lang.Object cartId_;
  /**
   * <pre>
   * ID of the cart 
   * </pre>
   *
   * <code>string cart_id = 1;</code>
   */
  public java.lang.String getCartId() {
    java.lang.Object ref = cartId_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      cartId_ = s;
      return s;
    }
  }
  /**
   * <pre>
   * ID of the cart 
   * </pre>
   *
   * <code>string cart_id = 1;</code>
   */
  public com.google.protobuf.ByteString
      getCartIdBytes() {
    java.lang.Object ref = cartId_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      cartId_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int VOUCHER_CODE_FIELD_NUMBER = 2;
  private volatile java.lang.Object voucherCode_;
  /**
   * <pre>
   * Voucher code
   * </pre>
   *
   * <code>string voucher_code = 2;</code>
   */
  public java.lang.String getVoucherCode() {
    java.lang.Object ref = voucherCode_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      voucherCode_ = s;
      return s;
    }
  }
  /**
   * <pre>
   * Voucher code
   * </pre>
   *
   * <code>string voucher_code = 2;</code>
   */
  public com.google.protobuf.ByteString
      getVoucherCodeBytes() {
    java.lang.Object ref = voucherCode_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      voucherCode_ = b;
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
    if (!getCartIdBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, cartId_);
    }
    if (!getVoucherCodeBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, voucherCode_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getCartIdBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, cartId_);
    }
    if (!getVoucherCodeBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, voucherCode_);
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
    if (!(obj instanceof grpc.services.checkout.ApplyVoucher)) {
      return super.equals(obj);
    }
    grpc.services.checkout.ApplyVoucher other = (grpc.services.checkout.ApplyVoucher) obj;

    boolean result = true;
    result = result && getCartId()
        .equals(other.getCartId());
    result = result && getVoucherCode()
        .equals(other.getVoucherCode());
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
    hash = (37 * hash) + CART_ID_FIELD_NUMBER;
    hash = (53 * hash) + getCartId().hashCode();
    hash = (37 * hash) + VOUCHER_CODE_FIELD_NUMBER;
    hash = (53 * hash) + getVoucherCode().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static grpc.services.checkout.ApplyVoucher parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static grpc.services.checkout.ApplyVoucher parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static grpc.services.checkout.ApplyVoucher parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static grpc.services.checkout.ApplyVoucher parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static grpc.services.checkout.ApplyVoucher parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static grpc.services.checkout.ApplyVoucher parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static grpc.services.checkout.ApplyVoucher parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static grpc.services.checkout.ApplyVoucher parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static grpc.services.checkout.ApplyVoucher parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static grpc.services.checkout.ApplyVoucher parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static grpc.services.checkout.ApplyVoucher parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static grpc.services.checkout.ApplyVoucher parseFrom(
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
  public static Builder newBuilder(grpc.services.checkout.ApplyVoucher prototype) {
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
   * Protobuf type {@code checkout.ApplyVoucher}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:checkout.ApplyVoucher)
      grpc.services.checkout.ApplyVoucherOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return grpc.services.checkout.CheckoutServiceImpl.internal_static_checkout_ApplyVoucher_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return grpc.services.checkout.CheckoutServiceImpl.internal_static_checkout_ApplyVoucher_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              grpc.services.checkout.ApplyVoucher.class, grpc.services.checkout.ApplyVoucher.Builder.class);
    }

    // Construct using grpc.services.checkout.ApplyVoucher.newBuilder()
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
      cartId_ = "";

      voucherCode_ = "";

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return grpc.services.checkout.CheckoutServiceImpl.internal_static_checkout_ApplyVoucher_descriptor;
    }

    @java.lang.Override
    public grpc.services.checkout.ApplyVoucher getDefaultInstanceForType() {
      return grpc.services.checkout.ApplyVoucher.getDefaultInstance();
    }

    @java.lang.Override
    public grpc.services.checkout.ApplyVoucher build() {
      grpc.services.checkout.ApplyVoucher result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public grpc.services.checkout.ApplyVoucher buildPartial() {
      grpc.services.checkout.ApplyVoucher result = new grpc.services.checkout.ApplyVoucher(this);
      result.cartId_ = cartId_;
      result.voucherCode_ = voucherCode_;
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
      if (other instanceof grpc.services.checkout.ApplyVoucher) {
        return mergeFrom((grpc.services.checkout.ApplyVoucher)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(grpc.services.checkout.ApplyVoucher other) {
      if (other == grpc.services.checkout.ApplyVoucher.getDefaultInstance()) return this;
      if (!other.getCartId().isEmpty()) {
        cartId_ = other.cartId_;
        onChanged();
      }
      if (!other.getVoucherCode().isEmpty()) {
        voucherCode_ = other.voucherCode_;
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
      grpc.services.checkout.ApplyVoucher parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (grpc.services.checkout.ApplyVoucher) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object cartId_ = "";
    /**
     * <pre>
     * ID of the cart 
     * </pre>
     *
     * <code>string cart_id = 1;</code>
     */
    public java.lang.String getCartId() {
      java.lang.Object ref = cartId_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        cartId_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <pre>
     * ID of the cart 
     * </pre>
     *
     * <code>string cart_id = 1;</code>
     */
    public com.google.protobuf.ByteString
        getCartIdBytes() {
      java.lang.Object ref = cartId_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        cartId_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <pre>
     * ID of the cart 
     * </pre>
     *
     * <code>string cart_id = 1;</code>
     */
    public Builder setCartId(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      cartId_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * ID of the cart 
     * </pre>
     *
     * <code>string cart_id = 1;</code>
     */
    public Builder clearCartId() {
      
      cartId_ = getDefaultInstance().getCartId();
      onChanged();
      return this;
    }
    /**
     * <pre>
     * ID of the cart 
     * </pre>
     *
     * <code>string cart_id = 1;</code>
     */
    public Builder setCartIdBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      cartId_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object voucherCode_ = "";
    /**
     * <pre>
     * Voucher code
     * </pre>
     *
     * <code>string voucher_code = 2;</code>
     */
    public java.lang.String getVoucherCode() {
      java.lang.Object ref = voucherCode_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        voucherCode_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <pre>
     * Voucher code
     * </pre>
     *
     * <code>string voucher_code = 2;</code>
     */
    public com.google.protobuf.ByteString
        getVoucherCodeBytes() {
      java.lang.Object ref = voucherCode_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        voucherCode_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <pre>
     * Voucher code
     * </pre>
     *
     * <code>string voucher_code = 2;</code>
     */
    public Builder setVoucherCode(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      voucherCode_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * Voucher code
     * </pre>
     *
     * <code>string voucher_code = 2;</code>
     */
    public Builder clearVoucherCode() {
      
      voucherCode_ = getDefaultInstance().getVoucherCode();
      onChanged();
      return this;
    }
    /**
     * <pre>
     * Voucher code
     * </pre>
     *
     * <code>string voucher_code = 2;</code>
     */
    public Builder setVoucherCodeBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      voucherCode_ = value;
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


    // @@protoc_insertion_point(builder_scope:checkout.ApplyVoucher)
  }

  // @@protoc_insertion_point(class_scope:checkout.ApplyVoucher)
  private static final grpc.services.checkout.ApplyVoucher DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new grpc.services.checkout.ApplyVoucher();
  }

  public static grpc.services.checkout.ApplyVoucher getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<ApplyVoucher>
      PARSER = new com.google.protobuf.AbstractParser<ApplyVoucher>() {
    @java.lang.Override
    public ApplyVoucher parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new ApplyVoucher(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<ApplyVoucher> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<ApplyVoucher> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public grpc.services.checkout.ApplyVoucher getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

