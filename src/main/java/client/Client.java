package client;

import grpc.services.inventorymanagement.InventoryManagerGrpc;
import grpc.services.inventorymanagement.ItemRequest;
import grpc.services.inventorymanagement.Status;
import grpc.services.inventorymanagement.StockLevel;
import grpc.services.inventorymanagement.UpdateRequest;
import grpc.services.inventorymanagement.InventoryManagerGrpc.InventoryManagerBlockingStub;
import grpc.services.smartcart.CartRequest;
import grpc.services.smartcart.CartStatus;
import grpc.services.smartcart.CartUpdateRequest;
import grpc.services.smartcart.SmartCartGrpc;
import grpc.services.smartcart.SmartCartGrpc.SmartCartBlockingStub;
import grpc.services.inventorymanagement.ItemInfo;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class Client {
    public static void main(String[] args) {
        
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext().build();
        InventoryManagerBlockingStub blockingStub = InventoryManagerGrpc.newBlockingStub(channel);

        // METHOD ONE //
        //preparing message to send
        ItemRequest request = ItemRequest.newBuilder().setItemId("item_003").build();

        //retreving reply from service
        StockLevel response = blockingStub.checkStock(request);

        System.out.println("Id=" + response.getItemId());
        System.out.println("Quantity=" + response.getQuantity());
        

        // METHOD TWO //
        //preparing message to send
        ItemRequest request2 = ItemRequest.newBuilder().setItemId("item_003").build();

        //retreving reply from service
        ItemInfo response2 = blockingStub.getItemInfo(request2);

        System.out.println("Id=" + response2.getItemId());
        System.out.println("Name=" + response2.getName());
        System.out.println("Desc=" + response2.getDescription());
        System.out.println("price=" + response2.getPrice());


        // METHOD THREE //
        //preparing message to send
        UpdateRequest request3 = UpdateRequest.newBuilder().setItemId("item_002").setQuantity(2).build();

        //retreving reply from service
        Status response3 = blockingStub.updateStock(request3);

        System.out.println("Message" + response3.getMessage());
        System.out.println("Success" + response3.getSuccess());

        ManagedChannel cartChannel = ManagedChannelBuilder.forAddress("localhost", 50052).usePlaintext().build();
        SmartCartBlockingStub cartBlockingStub = SmartCartGrpc.newBlockingStub(cartChannel);

        // METHOD THREE //
        //preparing message to send
        CartUpdateRequest request4 = CartUpdateRequest.newBuilder().setCartId("cart_002").setItemId("item_003").build();

        //retreving reply from service
        CartStatus response4 = cartBlockingStub.addToCart(request4);

        System.out.println("Message" + response4.getMessage());
        System.out.println("Success" + response4.getSuccess());
       

    }
}
