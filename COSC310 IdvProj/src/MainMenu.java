import java.awt.*;        // Using AWT container and component classes
import java.awt.event.*;  // Using AWT event classes and listener interfaces
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.*;
import javax.swing.BoxLayout;

public class MainMenu extends Frame {
    private static JFrame frame;
    public static void addComponentsToPane(Container pane) {
     JButton btnStock;
     JButton btnStopper; 
     JButton btnMap;
     JButton btnBase; 
     JButton btnExit;
     JLabel label;

    pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS)); 
     //welcome text
    pane.add(Box.createRigidArea(new Dimension(0,20)));
    label = new JLabel("Hello! Please select one of the following options");
    label.setAlignmentX(Component.CENTER_ALIGNMENT);
    pane.add(label);
    pane.add(Box.createRigidArea(new Dimension(0,20)));
    
    //Buttons 
       
    btnStock = new JButton("Stock Level Monitoring");
    btnStock.setAlignmentX(Component.CENTER_ALIGNMENT);
    btnStock.setAlignmentY(Component.BOTTOM_ALIGNMENT);
    pane.add(btnStock);
    pane.add(Box.createRigidArea(new Dimension(0,20)));

    btnStopper = new JButton("Stopper");
    btnStopper.setAlignmentX(Component.CENTER_ALIGNMENT);
    pane.add(btnStopper);
    pane.add(Box.createRigidArea(new Dimension(0,20)));

    btnMap = new JButton("Storage Map");
    btnMap.setAlignmentX(Component.CENTER_ALIGNMENT);
    pane.add(btnMap);
    pane.add(Box.createRigidArea(new Dimension(0,20)));

    btnBase = new JButton("Base Map");
    btnBase.setAlignmentX(Component.CENTER_ALIGNMENT);
    pane.add(btnBase);
    pane.add(Box.createRigidArea(new Dimension(0,20)));

    btnExit = new JButton("Exit Program");
    btnExit.setAlignmentX(Component.CENTER_ALIGNMENT);
    pane.add(btnExit);


    //Listeners
    btnStock.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            frame.setVisible(false);
            mainStockGui.main(null);
          
        }
      });
    btnStopper.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          //
        }
      });
    btnMap.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          //
        }
      });
    btnBase.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            //
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
    frame = new JFrame("Main Menu");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      //Set up the content pane.
    addComponentsToPane(frame.getContentPane());

    //Display the window.
    frame.setPreferredSize(new Dimension(600, 350));
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