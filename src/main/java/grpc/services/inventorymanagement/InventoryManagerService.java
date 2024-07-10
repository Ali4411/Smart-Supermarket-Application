package grpc.services.inventorymanagement;

import java.io.IOException;
import java.util.logging.Logger;

import data.DataStore;
import data.Product;
import grpc.services.inventorymanagement.InventoryManagerGrpc.InventoryManagerImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class InventoryManagerService extends InventoryManagerImplBase {

	private static final Logger logger = Logger.getLogger(InventoryManagerService.class.getName());

	public static void main(String[] args) {
		
		InventoryManagerService inventorymanagerservice = new InventoryManagerService();
		
		int port = 50051;
	    
		try {
			Server server = ServerBuilder.forPort(port)
			    .addService(inventorymanagerservice)
			    .build()
			    .start();
			 
			DataStore.initializeProducts();

			logger.info("Server started, listening on " + port);
			
			 server.awaitTermination();

			 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

    @Override
    public void checkStock(ItemRequest request, StreamObserver<StockLevel> responseObserver) {
		String id=request.getItemId(); 
		Product p = DataStore.getProduct(id);
		int stock=0;
		if(p != null){
			stock = p.getStock();
		} else {
			// ??????????
		}

		StockLevel reply = StockLevel.newBuilder().setItemId(id).setQuantity(stock).build();
	     
		 responseObserver.onNext(reply);
	     
	     responseObserver.onCompleted();
         
    }

    @Override
    public void getItemInfo(ItemRequest request, StreamObserver<ItemInfo> responseObserver) {
        String id=request.getItemId(); 
		Product p = DataStore.getProduct(id);
		String name = ""; 
  		String description = ""; 
  		float price = 0; 
		
		if(p != null){
			name = p.getName();
			description = p.getDescription();
			price = p.getPrice();
		} else {
			// ??????????
		}

		ItemInfo reply = ItemInfo.newBuilder().setItemId(id).setName(name).setDescription(description).setPrice(price).build();
	     
		 responseObserver.onNext(reply);
	     
	     responseObserver.onCompleted();
    }

    @Override
    public void updateStock(UpdateRequest request, StreamObserver<Status> responseObserver) {
        String id=request.getItemId(); 
		int quantity = request.getQuantity();

		DataStore.updateProductStock(id, quantity);

		Status reply = Status.newBuilder().setMessage("Stock updated successfully").setSuccess(true).build();
	     
		 responseObserver.onNext(reply);
	     
	     responseObserver.onCompleted();

		 // failed????
		

    }
	
	


	

}
