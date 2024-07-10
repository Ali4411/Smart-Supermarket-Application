package grpc.services.smartcart;

import java.io.IOException;
import java.util.logging.Logger;

import data.Cart;
import data.DataStore;
import grpc.services.inventorymanagement.InventoryManagerGrpc;
import grpc.services.inventorymanagement.InventoryManagerGrpc.InventoryManagerBlockingStub;
import grpc.services.inventorymanagement.ItemInfo;
import grpc.services.inventorymanagement.ItemRequest;
import grpc.services.smartcart.SmartCartGrpc.SmartCartImplBase;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class SmartCartService extends SmartCartImplBase {
    private static final Logger logger = Logger.getLogger(SmartCartService.class.getName());

    public static void main(String[] args) {
		
		SmartCartService smartcartservice = new SmartCartService();
		
		int port = 50052;
	    
		try {
			Server server = ServerBuilder.forPort(port)
			    .addService(smartcartservice)
			    .build()
			    .start();
			 
			DataStore.initializeCarts();

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
    public void addToCart(CartUpdateRequest request, StreamObserver<CartStatus> responseObserver) {
        String cartId = request.getCartId(); 
		String productId = request.getItemId(); 
		Cart c = DataStore.getCart(cartId);
		ItemInfo item = getProductFromInventory(productId);
		CartItem cartItem = CartItem.newBuilder().setItemId(item.getItemId()).setName(item.getName()).setPrice(item.getPrice()).setQuantity(1).build();

		c.addProduct(cartItem);

		CartStatus reply = CartStatus.newBuilder().setSuccess(true).setMessage("Item added to cart.").build();
	     
		responseObserver.onNext(reply);
	     
	    responseObserver.onCompleted();
    }

    @Override
    public void getCartContents(CartRequest request, StreamObserver<CartContents> responseObserver) {
        // TODO Auto-generated method stub
        super.getCartContents(request, responseObserver);
    }

    @Override
    public void removeFromCart(CartUpdateRequest request, StreamObserver<CartStatus> responseObserver) {
        // TODO Auto-generated method stub
        super.removeFromCart(request, responseObserver);
    }

	private ItemInfo getProductFromInventory(String productId)
	{
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext().build();
        InventoryManagerBlockingStub blockingStub = InventoryManagerGrpc.newBlockingStub(channel);

        //preparing message to send
        ItemRequest request = ItemRequest.newBuilder().setItemId("item_003").build();

        //retreving reply from service
        return blockingStub.getItemInfo(request);
	}

    
    
}
