import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;

public class MainClass {

  public static void main(String[] args) {
    // instantiate an anonymous class that implements
    // Runnable
    // using lambda notation
    SwingUtilities.invokeLater(() -> createGUI());
  }

  private static void createGUI() {
    JFrame frame = new JFrame("H's and Fibonacci squares");
    frame.setSize(1920, 1080);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // What goes in the frame
    Viewer v = new Viewer();
    frame.add(v);

    JRadioButton add = new JRadioButton("Add level");
    JRadioButton remove = new JRadioButton("Remove Level");
    JButton reset = new JButton("Reset");


    // Connect the view to a model
    DrawingModel model = new DrawingModel();
    model.addView(v);

    // Show it (execute this line last)
    frame.setVisible(true);

    // Adding HShapes
    // model.addShape(new HShape(100,100,Color.CYAN,180));
    // model.addShape(new HShape(300,300,Color.CYAN,360));
//    model.addShape(new FibonacciSquare(300, 300, Color.BLACK, 0, 7));
//    model.addShape(new FibonacciSquare(500, 300, Color.CYAN, 1, 13));
//    model.addShape(new FibonacciSquare(300, 400, Color.GREEN, 2, 8));
//    model.addShape(new FibonacciSquare(400, 400, Color.RED, 3, 10));
    // this HShape has nested HShapes4
//
//    HShape frog = new HShape(200, 500, Color.CYAN, 270);
//    model.addShape(frog);
//    for (int i = 0; i < 7; i++) {
//      frog.addInnerH();
//
//    }
//    for (int i = 0; i < 7; i++) {
//      model.addShape(frog.getInnerH(i));
//    }

    Shape hShape = new HShape(100, 100, Color.GREEN, 600);

    model.addShape(hShape);

    ((HShape) hShape).addInnerH();
    ((HShape) hShape).addInnerH();
    ((HShape) hShape).addInnerH();
    ((HShape) hShape).addInnerH();

    FibonacciSquare currentSquare = new FibonacciSquare(1200, 540, Color.BLACK, 0, 0);
    for (int i = 0; i < 20; i++) {
      currentSquare = currentSquare.nextSquare();
      model.addShape(currentSquare);
    }
    currentSquare = new FibonacciSquare(300, 760, new Color(0x7e1e9c), 0, 0);
    for (int i = 0; i < 20; i++) {
      currentSquare = currentSquare.nextSquare();
      model.addShape(currentSquare);
    }

  }
}
