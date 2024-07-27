package client;

import grpc.services.inventorymanagement.InventoryManagerGrpc;
import grpc.services.inventorymanagement.ItemRequest;
import grpc.services.inventorymanagement.Status;
import grpc.services.inventorymanagement.StockLevel;
import grpc.services.inventorymanagement.UpdateRequest;
import grpc.services.inventorymanagement.InventoryManagerGrpc.InventoryManagerBlockingStub;
import grpc.services.inventorymanagement.ItemInfo;
import io.grpc.ManagedChannel;

public class InventoryClient {
    private InventoryManagerBlockingStub blockingStub;

    public InventoryClient(ManagedChannel channel)
    {
        blockingStub = InventoryManagerGrpc.newBlockingStub(channel);
    }

    public StockLevel CheckStock(String productid) {
        //preparing message to send
        ItemRequest request = ItemRequest.newBuilder().setItemId(productid).build();

        //retreving reply from service
        StockLevel response = blockingStub.checkStock(request);

        System.out.println("The item ID is: " + response.getItemId());
        System.out.println("Its stock is: " + response.getQuantity());
        System.out.println("--------------------------------");
        return response;
    }

    public ItemInfo getItemInfo(String productid) {
        //preparing message to send
        ItemRequest request = ItemRequest.newBuilder().setItemId(productid).build();

        //retreving reply from service
        ItemInfo response = blockingStub.getItemInfo(request);

        System.out.println("Item ID is: " + response.getItemId());
        System.out.println("Item name is: " + response.getName());
        System.out.println("Item description is: " + response.getDescription());
        System.out.println("Item price is: " + response.getPrice());
        System.out.println("--------------------------------");

        return response;
    }

    public Status UpdateStock(String productid, int quantityToIncrease) {

        //preparing message to send
        UpdateRequest request = UpdateRequest.newBuilder().setItemId(productid).setQuantity(quantityToIncrease).build();

        //retreving reply from service
        Status response = blockingStub.updateStock(request);

        System.out.println("Message: " + response.getMessage());
        System.out.println("Success: " + response.getSuccess());
        System.out.println("--------------------------------");

        return response;
    }
}
