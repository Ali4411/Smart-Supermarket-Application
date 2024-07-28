package client;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

import java.awt.*;

public class GUIStyler {
    
    private static final Font defaultFont = new Font("Arial", Font.PLAIN, 14);
    private static final Color lightGrayColor = Color.LIGHT_GRAY;
    private static final Color blackColor = Color.BLACK;
    private static final Color darkGrayColor = Color.DARK_GRAY;
    private static final Color whiteColor = Color.WHITE;
    private static final Color panelGrayColor = new Color(240,240,240);
    private static final Color buttonBlueColor = new Color(70, 130, 180);
    
    public static void styleButton(JButton button) {
        button.setFont(defaultFont);
        button.setBackground(buttonBlueColor);
        button.setForeground(whiteColor);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createLineBorder(darkGrayColor));
        Insets paddingInsets = new Insets(5, 20, 5, 20);

        button.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(darkGrayColor, 1, true),
                new EmptyBorder(paddingInsets)
        ));
    }

    public static void styleLabel(JLabel label) {
        label.setFont(defaultFont);
    }

    public static void styleComboBox(JComboBox<?> comboBox) {
        comboBox.setFont(defaultFont);
        comboBox.setBackground(whiteColor);
        comboBox.setForeground(blackColor);
        comboBox.setBorder(BorderFactory.createLineBorder(darkGrayColor));
    }

    public static void styleTextField(JTextField textField) {
        textField.setFont(defaultFont);
        textField.setBackground(whiteColor);
        textField.setForeground(blackColor);
        textField.setBorder(BorderFactory.createLineBorder(darkGrayColor));
        Insets paddingInsets = new Insets(5, 0, 5, 0);
        textField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(darkGrayColor, 1, true),
                new EmptyBorder(paddingInsets)
        ));
    }

    public static void styleTable(JTable table, boolean lastColumnIsButton){
        table.setFillsViewportHeight(true);
        table.setRowHeight(30);
        table.setFont(defaultFont);
        table.setShowGrid(true);
        table.setGridColor(lightGrayColor);
        table.setSelectionBackground(whiteColor);
        table.setSelectionForeground(blackColor);

        // Set custom header renderer
        JTableHeader header = table.getTableHeader();
        header.setFont(defaultFont);
        header.setBackground(lightGrayColor);
        header.setForeground(blackColor);

        // Center align the header text
        TableCellRenderer rendererFromHeader = table.getTableHeader().getDefaultRenderer();
        JLabel headerLabel = (JLabel) rendererFromHeader;
        headerLabel.setHorizontalAlignment(JLabel.CENTER);

        if(lastColumnIsButton) {
            // style last column to look like button
            table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
                @Override
                public Component getTableCellRendererComponent(JTable table, Object value,
                                                            boolean isSelected, boolean hasFocus,
                                                            int row, int column) {
                    Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                    if (column == table.getColumnCount() - 1) {
                        c.setBackground(buttonBlueColor);
                        c.setForeground(whiteColor);
                        setHorizontalAlignment(JLabel.CENTER);
                    } 
                    else{
                        c.setBackground(whiteColor);
                        c.setForeground(blackColor);
                        setHorizontalAlignment(JLabel.LEFT);
                    }
                    return c;
                }
            });
        }
    }

    public static void stylePanel(JPanel panel) {
        panel.setFont(defaultFont);
        panel.setBackground(panelGrayColor);
        panel.setForeground(blackColor);
        Insets paddingInsets = new Insets(10, 10, 10, 10);
        panel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(darkGrayColor, 1, true),
                new EmptyBorder(paddingInsets)
        ));
    }
}
