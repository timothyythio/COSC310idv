import java.awt.*;        // Using AWT container and component classes
import java.awt.event.*;  // Using AWT event classes and listener interfaces
import javax.swing.JButton;
import javax.swing.*;
import javax.swing.BoxLayout;

public class mainStockGui {
    private static JFrame frame;
    public static void addComponentsToPane(Container pane) {
        JButton btnAddProduct;
        JButton btnEditProduct;
        JButton btnViewProduct;
        JButton btnExit;
        JButton btnReturn;
        JLabel label;
            
        pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));


        pane.add(Box.createRigidArea(new Dimension(0,20)));
        label = new JLabel("What would you like to do?");
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        pane.add(label);
        pane.add(Box.createRigidArea(new Dimension(0,20)));


        btnAddProduct = new JButton("Add a Product");
        btnAddProduct.setAlignmentX(Component.CENTER_ALIGNMENT);
        pane.add(btnAddProduct);
        pane.add(Box.createRigidArea(new Dimension(0,20)));


        btnEditProduct = new JButton("Edit a Product");
        btnEditProduct.setAlignmentX(Component.CENTER_ALIGNMENT);
        pane.add(btnEditProduct);
        pane.add(Box.createRigidArea(new Dimension(0,20)));


        btnViewProduct = new JButton("View a Product");
        btnViewProduct.setAlignmentX(Component.CENTER_ALIGNMENT);
        pane.add(btnViewProduct);
        pane.add(Box.createRigidArea(new Dimension(0,20)));

        btnReturn = new JButton("Return to Main Menu");
        btnReturn.setAlignmentX(Component.CENTER_ALIGNMENT);
        pane.add(btnReturn);
        pane.add(Box.createRigidArea(new Dimension(0,20)));

        btnExit = new JButton("Exit Program");
        btnExit.setAlignmentX(Component.CENTER_ALIGNMENT);
        pane.add(btnExit);



        //Listeners
        btnAddProduct.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                AddProduct.main(null);
            }
        });

        btnViewProduct.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                ViewProduct.main(null);
            }
        });

        btnEditProduct.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                EditProduct.main(null);
            }
        });

        btnReturn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                MainMenu.main(null);
                
            }
        });

        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }



    private static void createAndShowGUI() {
        //Create and set up the window.
        frame = new JFrame("Stock Level Monitoring");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        //Set up the content pane.
        addComponentsToPane(frame.getContentPane());

        //Display the window.
        frame.setPreferredSize(new Dimension(600, 350));
        frame.pack();
        frame.setVisible(true);
    }


    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}