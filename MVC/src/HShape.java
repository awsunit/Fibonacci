import java.awt.Color;
import java.awt.Graphics;

public class HShape extends AbstractShape {

  private Shape[] shapes = new Shape[9];

  public HShape(int xLocation, int yLocation, Color color, int size) {
    super(xLocation, yLocation, color, size);
    int smallSquareSize = size / 3;
    for (int row = 0; row < 3; row++) {
      for (int col = 0; col < 3; col++) {
        shapes[3 * row + col] =
            new Square(xLocation + (smallSquareSize * col), yLocation + (smallSquareSize * row),
                ((col != 1 || row == 1) ? color : Color.WHITE), smallSquareSize);
      }
    }
  }

  private void setShapes(Shape[] shapes) {
    this.shapes = shapes;
  }

  private Shape[] copyShapes() {
    Shape[] copy = new Shape[9];
    for (int i = 0; i < 9; i++) {
      copy[i] = shapes[i].copy();
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

  @Override
  public boolean addLevel() {
    if (size / 3 < 25) {
      return false;
    }
    if (!hasChildren) {
      for (int row = 0; row < 3; row++) {
        for (int col = 0; col < 3; col++) {
          if (col != 1 || row == 1) {
            shapes[3 * row + col] =
                new HShape(xLocation + ((size / 3) * col), yLocation + ((size / 3) * row), color,
                    size / 3);
          }
        }
      }
      hasChildren = true;
      return true;
    } else {
      for (int row = 0; row < 3; row++) {
        for (int col = 0; col < 3; col++) {
          if (col != 1 || row == 1) {
            shapes[3 * row + col].addLevel();
          }
        }
      }
      return true;
    }
  }


  @Override
  public HShape copy() {
    HShape copy = new HShape(xLocation, yLocation, color, size);
    copy.setShapes(copyShapes());
    return copy;
  }
}
