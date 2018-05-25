//import java.awt.Color;
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JRadioButton;
//import javax.swing.SwingUtilities;
//
//public class MainClass {
//
//  public static void main(String[] args) {
//    // instantiate an anonymous class that implements
//    // Runnable
//    // using lambda notation
//    SwingUtilities.invokeLater(() -> createGUI());
//  }
//
//  private static void createGUI() {
//    JFrame frame = new JFrame("H's and Fibonacci squares");
//    frame.setSize(1920, 1080);
//    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//    // What goes in the frame
//    Viewer viewer = new Viewer();
//    frame.add(viewer);
//
//    JRadioButton add = new JRadioButton("Add level");
//    JRadioButton remove = new JRadioButton("Remove Level");
//    JButton reset = new JButton("Reset");
//
//
//    // Connect the view to a model
//    DrawingModel model = new DrawingModel();
//    model.addView(viewer);
//
//    // Show it (execute this line last)
//    frame.setVisible(true);
//
//    // Adding HShapes
//    // model.addShape(new HShape(100,100,Color.CYAN,180));
//    // model.addShape(new HShape(300,300,Color.CYAN,360));
////    model.addShape(new FibonacciSquare(300, 300, Color.BLACK, 0, 7));
////    model.addShape(new FibonacciSquare(500, 300, Color.CYAN, 1, 13));
////    model.addShape(new FibonacciSquare(300, 400, Color.GREEN, 2, 8));
////    model.addShape(new FibonacciSquare(400, 400, Color.RED, 3, 10));
//    // this HShape has nested HShapes4
////
////    HShape frog = new HShape(200, 500, Color.CYAN, 270);
////    model.addShape(frog);
////    for (int i = 0; i < 7; i++) {
////      frog.addInnerH();
////
////    }
////    for (int i = 0; i < 7; i++) {
////      model.addShape(frog.getInnerH(i));
////    }
//
//    Shape hShape = new HShape(100, 100, Color.GREEN, 600);
//
//    model.addShape(hShape);
//
//    hShape.addLevel();
//    hShape.addLevel();
//     hShape.addLevel();
//     hShape.addLevel();
//
//    FibonacciSquare currentSquare = new FibonacciSquare(1100, 500, Color.BLACK, 0, 0);
//    model.addShape(currentSquare);
//
//    for (int i = 0; i < 20; i++) {
//      currentSquare.addLevel();
//    }
//
//  }
//}


import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;

public class MainClass {

  public static void main(String[] args) {
    // instantiate an anonymous class that implements
    // Runnable
    // new Runnable() { // override of run }
    /*
     * SwingUtilities.invokeLater(new Runnable() {
     *
     * @Override public void run() { createGUI(); } });
     */

    // Shorter version of the same code
    // using lambda notation
    SwingUtilities.invokeLater(() -> createGUI());
  }

  public static void createGUI() {
    JFrame frame = new JFrame("H's and Fibonacci squares");
    frame.setSize(1920, 1080);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // What goes in the frame
    Viewer viewer = new Viewer();
    frame.add(viewer);

    // Buttons at the top of the frame
    JRadioButton add = new JRadioButton("Add level");
    JRadioButton remove = new JRadioButton("Remove level");
    JButton reset = new JButton("Reset");
    JPanel northPanel = new JPanel();
    northPanel.setBackground(Color.WHITE);
    northPanel.add(add);
    northPanel.add(remove);
    northPanel.add(reset);
    frame.add(northPanel, BorderLayout.NORTH);

    // Connect the two radio buttons and select the add button
    ButtonGroup group = new ButtonGroup();
    group.add(add);
    group.add(remove);
    add.setSelected(true);

    // Connect the view to a model
    DrawingModel model = new DrawingModel();
    model.addView(viewer);

    TextViewer textViewer = new TextViewer();
    model.addView(textViewer);

    // Create a controller
    Controller controller = new Controller(model);

    // The controller listens to the button clicks
    add.addActionListener(controller);
    remove.addActionListener(controller);
    reset.addActionListener(controller);
    // The controller listens to the mouse clicks on the display panel
    viewer.addMouseListener(controller);

    // Show it (execute this line last)
    frame.setVisible(true);

    model.addShape(new HShape(100, 100, Color.GREEN, 729));
    model.addShape(new FibonacciSquare(1150, 500, Color.BLACK, 0, 0));

//    for(Shape s: model.getShapes()) {
//         System.out.println(s.toString());
//    }
  }
}



