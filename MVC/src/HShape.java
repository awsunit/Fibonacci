import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class HShape extends AbstractShape {

  private ArrayList<Shape> shapes = new ArrayList<>(9);

  public HShape(int xLocation, int yLocation, Color color, int size) {
    super(xLocation, yLocation, color, size);
    int smallSquareSize = size / 3;
    for (int row = 0; row < 3; row++) {
      for (int col = 0; col < 3; col++) {
        shapes.add(
            new Square(xLocation + (smallSquareSize * col), yLocation + (smallSquareSize * row),
                ((col != 1 || row == 1) ? color : Color.WHITE), smallSquareSize));
      }
    }
  }

  private void setShapes(ArrayList<Shape> shapes) {
    this.shapes = shapes;
  }

  private ArrayList<Shape> copyShapes() {
    ArrayList<Shape> copy = new ArrayList<>(7);
    for (Shape shape :
        shapes) {
      copy.add(shape.copy());
    }
    return copy;
  }

  @Override
  public void draw(Graphics graphics) {
    for (Shape shape :
        shapes) {
      shape.draw(graphics);
    }
  }

  public boolean addInnerH() {
    if (size / 3 < 25) {
      return false;
    }
    for (int row = 0; row < 3; row++) {
      for (int col = 0; col < 3; col++) {
        if (col != 1 || row == 1) {
          int index = 3 * row + col;
          if (shapes.get(index) instanceof Square) {
            shapes.set(index,
                new HShape(xLocation + ((size / 3) * col), yLocation + ((size / 3) * row), color,
                    size / 3));
          } else if (shapes.get(index) instanceof HShape) {
            ((HShape) shapes.get(index)).addInnerH();
          }
        }
      }
    }
    return true;
  }


  @Override
  public HShape copy() {
    HShape copy = new HShape(xLocation, yLocation, color, size);
    copy.setShapes(copyShapes());
    return copy;
  }
}
