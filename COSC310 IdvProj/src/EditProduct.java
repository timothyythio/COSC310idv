import java.awt.*;        // Using AWT container and component classes
import java.awt.event.*;  // Using AWT event classes and listener interfaces
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.*;

public class EditProduct extends Frame {
    
    private static JFrame frame;
    private static String attr;
    private static String newChange;
    private static String prod;


    private static int buttonPresses;

    private static JButton btn1;
    private static JButton btn2;
    private static JButton btn3;
    private static JButton btn4;
    private static JButton btn5;
    private static JButton btn6;
    private static JButton btn7;
    private static JButton btn8;
    private static JButton btn9;
    private static JButton nextBtn;
    private static JTextField in;
    private static JTextArea out;
    private static JLabel label;
    private static JButton backBtn;


    public static void addComponentsToPane(Container pane) {
    
        pane.setLayout(new FlowLayout());

        backBtn = new JButton("Back");
        backBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        pane.add(backBtn);

        label = new JLabel("Which product would you like to change?");
        pane.add(label);

        in = new JTextField(15);
        out = new JTextArea(1, 15);
        

        nextBtn = new JButton("Next");
        nextBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        pane.add(nextBtn);
    
        pane.add(in);
        pane.add(out);
        displayProducts(pane);

        in.requestFocus();   
        // pane.add(Box.createRigidArea(new Dimension(1000,20)));
        btn1 = new JButton("Product ID");
        btn1.setAlignmentX(Component.CENTER_ALIGNMENT);

        btn2 = new JButton("Product Name");
        btn2.setAlignmentX(Component.CENTER_ALIGNMENT);

        btn3 = new JButton("Part Number");
        btn3.setAlignmentX(Component.CENTER_ALIGNMENT);

        btn4 = new JButton("Product Label");
        btn4.setAlignmentX(Component.CENTER_ALIGNMENT);

        btn5 = new JButton("Starting Inventory");
        btn5.setAlignmentX(Component.CENTER_ALIGNMENT);

        btn6 = new JButton("Inventory Received");
        btn6.setAlignmentX(Component.CENTER_ALIGNMENT);

        btn7 = new JButton("Inventory Shipped");
        btn7.setAlignmentX(Component.CENTER_ALIGNMENT);

        btn8 = new JButton("Inventory on Hand");
        btn8.setAlignmentX(Component.CENTER_ALIGNMENT);

        btn9 = new JButton("Minimum Requirement");
        btn9.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        //Listeners
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                attr = "productId";
                buttonPresses++;
                removeButtons(pane);
            }
        });
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                attr = "productName";
                buttonPresses++;
                removeButtons(pane);
            }
        });
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                attr = "partNumber";
                buttonPresses++;
                removeButtons(pane);
            }
        });
        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                attr = "productLabel";
                buttonPresses++;
                removeButtons(pane);
            }
        });
        btn5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                attr = "startingInventory";
                buttonPresses++;
                removeButtons(pane);
            }
        });
        btn6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                attr = "inventoryReceived";
                buttonPresses++;
                removeButtons(pane);
            }
        });
        btn7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                attr = "inventoryShipped";
                buttonPresses++;
                removeButtons(pane);
            }
        });
        btn8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                attr = "inventoryOnHand";
                buttonPresses++;
                removeButtons(pane);
            }
        });
        btn9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                attr = "minimumRequired";
                buttonPresses++;
                removeButtons(pane);
            }
        });
        nextBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (buttonPresses == 0) {
                    prod = in.getText();
                    if (prod== null || prod.length()==0) {
                        label.setText("Please Select a Product!");
                    } else {
                        in.setText("");
                        in.setVisible(false);
                        showButtons(pane);
                        buttonPresses++;
                    }
                } else if (buttonPresses == 2) {
                    newChange = in.getText();
                    System.out.println(newChange);
                    int errorCode = DatabaseReaderJDBC.editProduct(prod, attr, newChange);
                    if (errorCode==0) {
                        label.setText("Change Successful!");
                        nextBtn.setText("Finish");
                        buttonPresses++;
                    }
                } else if (buttonPresses == 1) {
                    
                    label.setText("Select an attribute to change!");
                } else if (buttonPresses == 3) {
                    frame.setVisible(false);
                    mainStockGui.main(null);
                }
                
            }
        });

        backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (buttonPresses == 1) {
                    buttonPresses--;
                    backBtn.setVisible(false);
                    nextBtn.setVisible(false);
                    in.setVisible(false);
                    label.setVisible(false);
                    removeButtons(pane);
                    addComponentsToPane(pane);
                } else if (buttonPresses == 0) {

                    frame.setVisible(false);
                    mainStockGui.main(null);

                } 
                else if (buttonPresses == 2) {
                    buttonPresses--;
                    showButtons(pane);
                }
                
            }
        });


    }
    public static void showButtons(Container pane) {
        out.setVisible(false);
        label.setText("Select an attribute to change: ");
        pane.add(btn1);
        pane.add(btn2);
        pane.add(btn3);
        pane.add(btn4);
        pane.add(btn5);
        pane.add(btn6);
        pane.add(btn7);
        pane.add(btn8);
        pane.add(btn9);

        if (!btn1.isVisible()) {
            btn1.setVisible(true);
            btn2.setVisible(true);
            btn3.setVisible(true);
            btn4.setVisible(true);
            btn5.setVisible(true);
            btn6.setVisible(true);
            btn7.setVisible(true);
            btn8.setVisible(true);
            btn9.setVisible(true);
        }
    }

    public static void removeButtons(Container pane) {
        btn1.setVisible(false);
        btn2.setVisible(false);
        btn3.setVisible(false);
        btn4.setVisible(false);
        btn5.setVisible(false);
        btn6.setVisible(false);
        btn7.setVisible(false);
        btn8.setVisible(false);
        btn9.setVisible(false);
        in.setText("");
        if (buttonPresses==2) {
            in.setVisible(true);
            label.setText("Enter the requested change");
        }    
    }

    public static void displayProducts(Container pane) {
        String[] res = DatabaseReaderJDBC.prodList();
        for (String s : res)
            out.append(s + "\n");
      }


    private static void createAndShowGUI() {
        //Create and set up the window.
        frame = new JFrame("Edit Product");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Set up the content pane.
        addComponentsToPane(frame.getContentPane());

        //Display the window.
        frame.setPreferredSize(new Dimension(400, 300));
        frame.pack();
        frame.setVisible(true);
        buttonPresses = 0;
    }


    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}