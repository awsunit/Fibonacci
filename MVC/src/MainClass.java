import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class MainClass {

  public static void main(String[] args) {
    // instantiate an anonymous class that implements
    // Runnable
    // Shorter version of the same code
    // using lambda notation
    SwingUtilities.invokeLater(() -> createGUI());
  }

  public static void createGUI() {
    JFrame frame = new JFrame("H's and Fibonacci squares");
    frame.setSize(1240, 1024);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // What goes in the frame
    Viewer v = new Viewer();
    frame.add(v);

    // Connect the view to a model
    DrawingModel model = new DrawingModel();
    model.addView(v);

    // Show it (execute this line last)
    frame.setVisible(true);

    // Adding HShapes
    // model.addShape(new HShape(100,100,Color.CYAN,180));
    // model.addShape(new HShape(300,300,Color.CYAN,360));
    // model.addShape(new FibonacciSquare(300, 300, Color.BLACK, jack, 1));
    // model.addShape(new FibonacciSquare(300, 300, Color.CYAN, jill, 2));
    // model.addShape(new FibonacciSquare(300, 300, Color.RED, bill, 3));
    // this HShape has nested HShapes

    HShape frog = new HShape(200, 500, Color.CYAN, 270);
    model.addShape(frog);
    for (int i = 0; i < 7; i++) {
      frog.addInnerH();

    }
    for (int i = 0; i < 7; i++) {
      model.addShape(frog.getInnerH(i));
    }

    FibonacciSquare currentSquare = new FibonacciSquare(1240/2, 1024/2, Color.BLACK, 0, 0);
    for (int i = 0; i < 17; i++) {
      currentSquare=currentSquare.nextSquare();
      model.addShape(currentSquare);
    }

  }
}
