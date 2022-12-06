import java.awt.*;        // Using AWT container and component classes
import java.awt.event.*;  // Using AWT event classes and listener interfaces
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class AddProduct extends Frame {
    private static int promptCount = 0;
    private static String[] prompts = {"Enter New Product Name:", "   Enter New Part Number: "
    , "Enter New Product Label: ", "Enter New Starting Inventory: ", "Enter New Inventory Received: ", 
    "Enter New Inventory Shipped: ", "Enter New Inventory On Hand: ", "Enter New Minimum Requirement: "};
    private static String[] inputs = new String[9];
    private static JLabel prompt;
    private static JTextField in;
    private static JTextArea out;
    private static JButton btnFinish;
    private static JFrame frame;
    public static void addComponentsToPane(Container pane) {
        JButton btnNext;


        pane.setLayout(new FlowLayout());

        prompt = new JLabel("             Enter New Product ID:");
        pane.add(prompt);

        in = new JTextField(15);
        out = new JTextArea(1, 15);
        pane.add(in);
        pane.add(out);
        out.setVisible(false);
        in.requestFocus();      


        btnNext = new JButton("Next");
        btnNext.setAlignmentX(Component.CENTER_ALIGNMENT);
        pane.add(btnNext);

        btnFinish = new JButton("Finish");
        btnFinish.setAlignmentX(Component.CENTER_ALIGNMENT);
        pane.add(btnFinish);
        btnFinish.setVisible(false);

      //Listeners
        btnNext.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnNext.setText("Next");    
                String ins;
                if (promptCount==prompts.length) {
                    ins = in.getText();
                    if (ins.length() == 0) 
                        prompt.setText("Enter a value:                                                        ");
                    else {
                        inputs[promptCount] = ins;
                        promptCount++;
                        in.setText("");
                    }   
                } else if (promptCount<prompts.length) {
                    prompt.setText(prompts[promptCount]);
                    ins = in.getText();
                    if (ins.length() == 0) 
                        prompt.setText("                               Enter a value:");
                    else {
                        inputs[promptCount] = ins;
                        promptCount++;
                        in.setText("");
                    }
                }else {
                    int errorCode = DatabaseReaderJDBC.addProduct(inputs);   
                    if (errorCode != 0) {
                        prompt.setText("Product Write Failed! Please Try Again");
                        btnNext.setText("Try Again");
                        promptCount = 0;
                    } else {
                        btnNext.setVisible(false);
                        btnFinish.setVisible(true);
                        out.setVisible(true);
                        prompt.setText("Product Written Successfully");
                        out.append("Product ID: " + inputs[0] + "\n");
		                out.append("Product Name: " + inputs[1]+ "\n");
		                out.append("Part Number: " + inputs[2]+ "\n");
		                out.append("Product Label: " + inputs[3]+ "\n");
		                out.append("Start Inventory: " + inputs[4]+ "\n");
		                out.append("Inventory Received: " + inputs[5]+ "\n");
		                out.append("Inventory Shipped: " + inputs[6]+ "\n");
		                out.append("Inventory On Hand: " + inputs[7]+ "\n");
                        out.append("Minimum Required: " + inputs[8]);
                    }
                    
                } 
            }
        });

        btnFinish.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                mainStockGui.main(null);
            }
        });
    }

    private static void createAndShowGUI() {
        //Create and set up the window.
        frame = new JFrame("Add Product");
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