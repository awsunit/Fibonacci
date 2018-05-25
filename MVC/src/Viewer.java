import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Viewer extends JPanel implements View {

  // The model this View is connected to
  private DrawingModel model;

  public Viewer() {
    setBackground(Color.WHITE);
  }

  @Override
  public void update(DrawingModel model) {
    this.model = model;
    repaint(); // will eventually call paintComponent
  }

  @Override
  protected void paintComponent(Graphics graphics) {
    super.paintComponent(graphics);

    // display of the shapes
    if (model != null) {
      for (Shape shape : model.getShapes()) {
        shape.draw(graphics);
      }
    }
  }

}




