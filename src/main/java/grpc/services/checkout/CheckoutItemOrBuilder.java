// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: checkout.proto

package grpc.services.checkout;

public interface CheckoutItemOrBuilder extends
    // @@protoc_insertion_point(interface_extends:checkout.CheckoutItem)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * ID of the item
   * </pre>
   *
   * <code>string item_id = 1;</code>
   */
  java.lang.String getItemId();
  /**
   * <pre>
   * ID of the item
   * </pre>
   *
   * <code>string item_id = 1;</code>
   */
  com.google.protobuf.ByteString
      getItemIdBytes();

  /**
   * <pre>
   * Name of the item
   * </pre>
   *
   * <code>string name = 2;</code>
   */
  java.lang.String getName();
  /**
   * <pre>
   * Name of the item
   * </pre>
   *
   * <code>string name = 2;</code>
   */
  com.google.protobuf.ByteString
      getNameBytes();

  /**
   * <pre>
   * Quantity of the item in the cart
   * </pre>
   *
   * <code>int32 quantity = 3;</code>
   */
  int getQuantity();

  /**
   * <pre>
   * Price of the item
   * </pre>
   *
   * <code>float price = 4;</code>
   */
  float getPrice();
}