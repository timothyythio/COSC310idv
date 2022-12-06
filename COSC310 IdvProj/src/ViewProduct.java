import java.awt.*;        // Using AWT container and component classes
import java.awt.event.*;  // Using AWT event classes and listener interfaces
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.*;

public class ViewProduct extends Frame {
    private static JFrame frame; 
    private static String prod;
    private static String[] prodDetail;
    private static JTextArea out;
    private static JTextField in;
    private static JTextArea displayRes;

    public static void addComponentsToPane(Container pane) {
    JButton btnConfirm;
    JButton btnShowProds;
    JButton btnBack;
    JButton btnExit;
    JLabel label;

    pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
    label = new JLabel("Select a product");
    pane.add(label);

    in = new JTextField(15);
    out = new JTextArea(1, 15);
    
   
    pane.add(in);
    // pane.add(out);
    in.requestFocus();        // start with focus on this field
    
    displayRes = new JTextArea(10,15);

    pane.add(displayRes);

    displayRes.setEditable(false);
    displayProducts(pane);
    pane.setLayout(new FlowLayout());
    btnConfirm = new JButton("Confirm");
    btnConfirm.setAlignmentX(Component.CENTER_ALIGNMENT);
    pane.add(btnConfirm);

    btnShowProds = new JButton("Show Product List");
    btnShowProds.setAlignmentX(Component.CENTER_ALIGNMENT);
    pane.add(btnShowProds);

    btnExit = new JButton("Exit Program");
    btnExit.setAlignmentX(Component.CENTER_ALIGNMENT);
    pane.add(btnExit);

    btnBack = new JButton("Go Back");
    btnBack.setAlignmentX(Component.CENTER_ALIGNMENT);
    pane.add(btnBack);

      //Listeners
    btnConfirm.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            prod = in.getText();
            prodDetail = DatabaseReaderJDBC.viewProduct(prod);
            displayResults(frame.getContentPane());
        }
      });
      btnShowProds.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
           displayProducts(pane);
        }
      });
      btnBack.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
           frame.setVisible(false);
           mainStockGui.main(null);
        }
      });

      btnExit.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(ABORT);
        }
      });
  }

  public static void displayResults(Container pane) {

    if(in.getText() == "" || in.getText() == null) {
      displayRes.setText("Please enter a product!");
    }
    else if (prodDetail == null) {
      in.setText("");
      displayRes.setText("Product not found, please try again");
    }
    else {
      in.setText("");
      displayRes.setText("");
      displayRes.append("Product ID: " + prodDetail[1] + "\n");
		  displayRes.append("Product Name: " + prodDetail[2]+ "\n");
		  displayRes.append("Part Number: " + prodDetail[3]+ "\n");
		  displayRes.append("Product Label: " + prodDetail[4]+ "\n");
		  displayRes.append("Start Inventory: " + prodDetail[5]+ "\n");
		  displayRes.append("Inventory Received: " + prodDetail[6]+ "\n");
		  displayRes.append("Inventory Shipped: " + prodDetail[7]+ "\n");
		  displayRes.append("Inventory On Hand: " + prodDetail[8]+ "\n");
		  displayRes.append("Minimum Required: " + prodDetail[9]);
    }
  }

  public static void displayProducts(Container pane) {
    String[] res = DatabaseReaderJDBC.prodList();
    displayRes.setText("");
    for (String s : res)
        displayRes.append(s + "\n");
  }


  private static void createAndShowGUI() {
      //Create and set up the window.
      frame = new JFrame("View Product");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      //Set up the content pane.
      addComponentsToPane(frame.getContentPane());

      //Display the window.
      frame.setPreferredSize(new Dimension(400, 300));
      frame.pack();
      frame.setVisible(true);
  }


  public static void main(String[] args) {
      javax.swing.SwingUtilities.invokeLater(new Runnable() {
          public void run() {
              createAndShowGUI();
          }
      });
  }
}