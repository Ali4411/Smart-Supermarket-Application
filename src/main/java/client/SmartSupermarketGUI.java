package client;

import javax.jmdns.ServiceInfo;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.text.BadLocationException;

import grpc.services.checkout.CheckoutItem;
import grpc.services.checkout.VoucherResult;
import grpc.services.inventorymanagement.ItemInfo;
import grpc.services.smartcart.CartItem;
import grpc.services.smartcart.CartStatus;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import jmdns.ServiceDiscovery;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SmartSupermarketGUI extends JFrame {
    private static final String inventoryServiceName = "inventory_service";
    private static final String cartServiceName = "cart_service";
    private static final String checkoutServiceName = "checkout_service";

    private ServiceDiscovery serviceDiscovery;

    private InventoryClient inventoryClient;
    private CartClient cartClient;
    private CheckoutClient checkoutClient;

    private JPanel cartPanel;
    private JPanel productPanel;
    private JPanel cartDetailsPanel;
    private JPanel checkoutPanel;
    private JPanel checkoutTablePanel;
    private JPanel checkoutVoucherPanel;
    private JPanel checkoutPaymentPanel;
    private JPanel checkoutRecieptPanel;
    private JPanel totalCostPanel;
    private JPanel voucherResultPanel;

    private JComboBox<String> cartSelection;
    private JTable productTable;
    private DefaultTableModel productTableModel;
    private JTable cartTable;
    private DefaultTableModel cartTableModel;
    private JTable checkoutTable;
    private DefaultTableModel checkoutTableModel;
    private JTextField voucherCodeField;
    private JButton checkoutButton;
    private JButton makePaymentButton;
    private JButton applyVoucherButton;
    private JLabel totalCostlabel;
    private JLabel voucherResultLabel;

    private ArrayList<String> shoppingCarts;
	private ArrayList<ItemInfo> products;
    private List<CartItem> productsInCart;
    private float totalCheckoutCost;

    public SmartSupermarketGUI() {
        
        try {
            // discover services
            serviceDiscovery = new ServiceDiscovery();
            serviceDiscovery.discoverServices();

            // wait for service discovery
            Thread.sleep(2000);

            inventoryClient = new InventoryClient(getChannelForService(inventoryServiceName));
            checkoutClient = new CheckoutClient(getChannelForService(checkoutServiceName));
            cartClient = new CartClient(getChannelForService(cartServiceName));

            // Initialize shopping carts
            shoppingCarts = new ArrayList<>();
            for (int i = 1; i <= 5; i++) {
                shoppingCarts.add("cart_00" +i);
            }

            // Initialize products            
            products = new ArrayList<>();
            for (int i = 1; i <= 5; i++) {
                ItemInfo item = inventoryClient.getItemInfo("item_00" +i);
                products.add(item);
            }

            setupGUI();

            updateCartDetails();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void setupGUI() {
        // Set up frame
        setTitle("Supermarket GUI");
        setSize(1200, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Cart selection panel
        cartPanel = new JPanel();
        cartPanel.setLayout(new FlowLayout());

        cartSelection = new JComboBox<>();
        for(String c : shoppingCarts){
            cartSelection.addItem(c);
        }
        cartSelection.addActionListener(new CartSelectionListener());
        JLabel selectCartLabel = new JLabel("Select Cart:");
        cartPanel.add(selectCartLabel);
        cartPanel.add(cartSelection);

        // Product selection panel
        productPanel = new JPanel();     
        productPanel.setLayout(new BoxLayout(productPanel, BoxLayout.Y_AXIS));
        productTableModel = new DefaultTableModel(new Object[]{"Id","Name", "Description", "Price", "Stock", ""}, 0){
            @Override
            public boolean isCellEditable(int row, int column) {
                // make cells uneditable
                return false;
            }
        };

        populateProducts();

        productTable = new JTable(productTableModel);
        // hide id column
        productTable.getColumnModel().removeColumn(productTable.getColumnModel().getColumn(0));

        productTable.addMouseListener(new AddProductListener());
        JScrollPane scrollPane = new JScrollPane(productTable);
        JLabel productLabel = new JLabel("Select Product:");
        productPanel.add(productLabel);
        productPanel.add(scrollPane);

        // Cart details panel
        cartDetailsPanel = new JPanel();
        // cart table
        cartDetailsPanel.setLayout(new BoxLayout(cartDetailsPanel, BoxLayout.Y_AXIS));
        cartTableModel = new DefaultTableModel(new Object[]{"Id","Name", "Quantity", "Price", ""}, 0){
            @Override
            public boolean isCellEditable(int row, int column) {
                // make cells uneditable
                return false;
            }
        };

        cartTable = new JTable(cartTableModel);
        // hide id column
        cartTable.getColumnModel().removeColumn(cartTable.getColumnModel().getColumn(0));

        cartTable.addMouseListener(new RemoveProductListener());
        JScrollPane cartScrollPane = new JScrollPane(cartTable);

        // go to checkout
        checkoutButton = new JButton("Go to Checkout");
        checkoutButton.addActionListener(new CheckoutListener());
        
        JLabel cartLabel = new JLabel("Your Shopping Cart:");
        cartDetailsPanel.add(cartLabel);
        cartDetailsPanel.add(cartScrollPane);
        cartDetailsPanel.add(checkoutButton);

        // Checkout panel
        checkoutPanel = new JPanel();
        checkoutTablePanel = new JPanel();
        checkoutVoucherPanel = new JPanel();
        checkoutPaymentPanel = new JPanel();
        checkoutRecieptPanel = new JPanel();
        totalCostPanel = new JPanel();
        voucherResultPanel = new JPanel();
        

        checkoutTableModel = new DefaultTableModel(new Object[]{"Id","Name", "Quantity", "Price"}, 0){
            @Override
            public boolean isCellEditable(int row, int column) {
                // make cells uneditable
                return false;
            }
        };

        checkoutTable = new JTable(checkoutTableModel);
        // hide id column
        checkoutTable.getColumnModel().removeColumn(checkoutTable.getColumnModel().getColumn(0));

        JScrollPane checkoutScrollPane = new JScrollPane(checkoutTable);

        checkoutTablePanel.add(checkoutScrollPane);

        totalCostPanel.setLayout(new FlowLayout());
        totalCostPanel.add(new JLabel("Total Cost:"));
        totalCostlabel = new JLabel("0");
        totalCostPanel.add(totalCostlabel);

        checkoutVoucherPanel.setLayout(new FlowLayout());
        voucherCodeField = new JTextField(10);
        applyVoucherButton = new JButton("Apply Voucher");
        applyVoucherButton.addActionListener(new ApplyVoucherListner());
        checkoutVoucherPanel.add(new JLabel("Voucher Code:"));
        checkoutVoucherPanel.add(voucherCodeField);
        checkoutVoucherPanel.add(applyVoucherButton);


        makePaymentButton = new JButton("Make Payment");
        makePaymentButton.addActionListener(new MakePaymentListener());

        checkoutPaymentPanel.add(makePaymentButton);
        voucherResultLabel = new JLabel("No Voucher applied");
        voucherResultPanel.add(voucherResultLabel);
        voucherResultPanel.setVisible(false);
        checkoutRecieptPanel.setVisible(false);

        checkoutPanel.setLayout(new BoxLayout(checkoutPanel, BoxLayout.Y_AXIS));
        checkoutPanel.add(checkoutTablePanel);
        checkoutPanel.add(totalCostPanel);
        checkoutPanel.add(voucherResultPanel);
        checkoutPanel.add(checkoutVoucherPanel);
        checkoutPanel.add(checkoutPaymentPanel);
        checkoutPanel.add(checkoutRecieptPanel);
        checkoutPanel.setVisible(false);

        // style the components
        GUIStyler.styleButton(checkoutButton);
        GUIStyler.styleButton(makePaymentButton);
        GUIStyler.styleButton(applyVoucherButton);
        GUIStyler.styleComboBox(cartSelection);
        GUIStyler.styleLabel(cartLabel);
        GUIStyler.styleLabel(selectCartLabel);
        GUIStyler.styleLabel(totalCostlabel);
        GUIStyler.styleLabel(productLabel);
        GUIStyler.styleTextField(voucherCodeField);
        GUIStyler.styleTable(cartTable, true);
        GUIStyler.styleTable(productTable, true);
        GUIStyler.styleTable(checkoutTable, false);
        GUIStyler.stylePanel(cartDetailsPanel);
        GUIStyler.stylePanel(productPanel);
        GUIStyler.stylePanel(cartPanel);
        GUIStyler.stylePanel(checkoutPanel);
        GUIStyler.stylePanel(checkoutTablePanel);
        GUIStyler.stylePanel(checkoutVoucherPanel);
        GUIStyler.stylePanel(checkoutPaymentPanel);
        GUIStyler.stylePanel(checkoutRecieptPanel);
        GUIStyler.stylePanel(totalCostPanel);
        GUIStyler.stylePanel(voucherResultPanel);

        // Add panels to frame
        add(cartPanel, BorderLayout.NORTH);
        add(productPanel, BorderLayout.WEST);
        add(cartDetailsPanel, BorderLayout.EAST);
        add(checkoutPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    private void populateProducts(){
        for(ItemInfo p : products){
            int stock = inventoryClient.CheckStock(p.getItemId()).getQuantity();
            productTableModel.addRow(new Object[]{p.getItemId(), p.getName(), p.getDescription(), p.getPrice(), stock, "Add to Cart"});
        }
    }

    private void addToCart(String itemId) {
        String cartId = getSelectedCart();
        CartStatus status = cartClient.addToCart(cartId, itemId);
        JOptionPane.showMessageDialog(this, status.getMessage());

        updateCartDetails();
    }

    private String getSelectedCart() {
        int selectedCartIndex = cartSelection.getSelectedIndex();
        return shoppingCarts.get(selectedCartIndex);
    }

    private void updateCartDetails() {
        String cartId = getSelectedCart();
        
        productsInCart = cartClient.getCartContents(cartId);
        cartTableModel.setRowCount(0);;
        for(CartItem p : productsInCart){
            cartTableModel.addRow(new Object[]{p.getItemId(), p.getName(), p.getQuantity(), p.getPrice(), "Remove"});
        }
    }

    private void removeFromCart(String itemId) {
        String cartId = getSelectedCart();
        CartStatus status = cartClient.removeFromCart(cartId, itemId);
        JOptionPane.showMessageDialog(this, status.getMessage());
        updateCartDetails();
    }

    private void goToCheckout() {
        String cartId = getSelectedCart();
        try {
            checkoutClient.transferCart(productsInCart, cartId);
        
            List<CheckoutItem> checkoutitems = checkoutClient.getItemsForCheckout();

            for(CheckoutItem p : checkoutitems){
                checkoutTableModel.addRow(new Object[]{p.getItemId(), p.getName(), p.getQuantity(), p.getPrice() * p.getQuantity()});
            }
            totalCheckoutCost = checkoutClient.getTotalCheckoutCost();

            totalCostlabel.setText(Float.toString(totalCheckoutCost));
            cartPanel.setVisible(false);
            productPanel.setVisible(false);
            cartDetailsPanel.setVisible(false);
            checkoutPanel.setVisible(true);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void applyVoucher(){
        String cartId = getSelectedCart();
        String voucherCode = voucherCodeField.getText();
        VoucherResult voucherResult = checkoutClient.applyVoucher(cartId, voucherCode);
        JOptionPane.showMessageDialog(this, voucherResult.getMessage());
        voucherResultLabel.setText("Voucher discount applied: " + Float.toString(voucherResult.getDiscountAmount()));
        totalCostlabel.setText(Float.toString(totalCheckoutCost - voucherResult.getDiscountAmount()));
        voucherResultPanel.setVisible(true);
    }

    private void makePayment(){
        String cartId = getSelectedCart();
        try {
            checkoutClient.completePayment(cartId);
            JOptionPane.showMessageDialog(this, "Payment Successful");
            checkoutPaymentPanel.setVisible(false);
            voucherResultPanel.setVisible(false);
            checkoutVoucherPanel.setVisible(false);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    

    private class CartSelectionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            updateCartDetails();
        }
    }

    private class AddProductListener implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getClickCount() == 1) {
                JTable target = (JTable) e.getSource();
                int row = target.getSelectedRow();
                int column = target.getSelectedColumn();
                if(column == 4){
                    String ItemId = productTable.getModel().getValueAt(row, 0).toString();
                    // Perform action when cell is clicked
                    System.out.println("Adding to cart: " + ItemId);
                    addToCart(ItemId);
                }
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    }

    private class RemoveProductListener implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getClickCount() == 1) {
                JTable target = (JTable) e.getSource();
                int row = target.getSelectedRow();
                int column = target.getSelectedColumn();
                if(column == 3){
                    String ItemId = cartTable.getModel().getValueAt(row, 0).toString();
                    // Perform action when cell is clicked
                    System.out.println("Removing from cart: " + ItemId);
                    removeFromCart(ItemId);
                }
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    }

    private class CheckoutListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            goToCheckout();
        }
    }

    private class MakePaymentListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            makePayment();
        }
    }

    private class ApplyVoucherListner implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            applyVoucher();
        }
    }

    private ManagedChannel getChannelForService(String serviceName) {
        ServiceInfo serviceInfo = serviceDiscovery.getServiceByName(serviceName);
        if (serviceInfo == null) {
            throw new IllegalStateException("Service not found: " + serviceName);
        }

        String host = serviceInfo.getHostAddresses()[0];
        int port = serviceInfo.getPort();

        return ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SmartSupermarketGUI::new);
    }
}
