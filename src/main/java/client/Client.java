package client;

import java.io.IOException;
import java.util.List;

import javax.jmdns.ServiceInfo;

import grpc.services.smartcart.CartItem;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import jmdns.ServiceDiscovery;

public class Client {

    private static final String inventoryServiceName = "inventory_service";
    private static final String cartServiceName = "cart_service";
    private static final String checkoutServiceName = "checkout_service";

    private static ServiceDiscovery serviceDiscovery;
    
    public static void main(String[] args) {
        try {
            serviceDiscovery = new ServiceDiscovery();
            serviceDiscovery.discoverServices();

            Thread.sleep(2000);
            
            // Inventory
            InventoryClient inventoryClient = new InventoryClient(getChannelForService(inventoryServiceName));
            inventoryClient.CheckStock("item_003");
            inventoryClient.getItemInfo("item_003");
            inventoryClient.UpdateStock("item_003", 2);
            inventoryClient.CheckStock("item_003");
            
            CartClient cartClient = new CartClient(getChannelForService(cartServiceName));
            String cartToUse = "cart_002";
            cartClient.addToCart(cartToUse, "item_003");
            cartClient.addToCart(cartToUse, "item_003");
            cartClient.addToCart(cartToUse, "item_003");
            cartClient.addToCart(cartToUse, "item_003");
            cartClient.addToCart(cartToUse, "item_002");
            cartClient.addToCart(cartToUse, "item_002");
            cartClient.addToCart(cartToUse, "item_005");

            cartClient.removeFromCart(cartToUse, "item_003");

            List<CartItem> cartItems = cartClient.getCartContents(cartToUse);

            System.out.println("Transferring cart for checkout"); 
            
            CheckoutClient checkoutClient = new CheckoutClient(getChannelForService(checkoutServiceName));
            checkoutClient.transferCart(cartItems, cartToUse);

            System.out.println("Applying voucher Save5"); 
            checkoutClient.applyVoucher(cartToUse, "Save5");
            
            System.out.println("Processing payment"); 
            checkoutClient.completePayment(cartToUse);
            
            //retreving reply from service
            inventoryClient.CheckStock("item_003");
            inventoryClient.CheckStock("item_002");
            inventoryClient.CheckStock("item_005");
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private static ManagedChannel getChannelForService(String serviceName) {
        ServiceInfo serviceInfo = serviceDiscovery.getServiceByName(serviceName);
        if (serviceInfo == null) {
            throw new IllegalStateException("Service not found: " + serviceName);
        }

        String host = serviceInfo.getHostAddresses()[0];
        int port = serviceInfo.getPort();

        return ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
    }
    
}
