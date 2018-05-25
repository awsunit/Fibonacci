import java.awt.Color;
import java.awt.Graphics;

public class HShape extends AbstractShape {

  public HShape(int xLocation, int yLocation, Color color, int size) {
    super(xLocation, yLocation, color, size);
    children = new Shape[7];

  }

  private void setChildren(Shape[] children) {
    this.children = children;
  }

  private Shape[] copyShapes() {
    Shape[] copy = new Shape[7];
    for (int i = 0; i < 7; i++) {
      copy[i] = children[i].copy();
    }
    return copy;
  }

//  @Override
//  public void draw(Graphics graphics) {
//    for (Shape shape :
//        shapes) {
//      shape.draw(graphics);
//    }
//  }

//  // TODO: 5/21/18 replace this garbage
//  @Override
//  public boolean addLevel() {
//    if (size / 3 < 25) {
//      return false;
//    }
//    if (!hasChildren) {
//      for (int row = 0; row < 3; row++) {
//        for (int col = 0; col < 3; col++) {
//          if (col != 1 || row == 1) {
//            shapes[3 * row + col] =
//                new HShape(xLocation + ((size / 3) * col), yLocation + ((size / 3) * row), color,
//                    size / 3);
//          }
//        }
//      }
//      hasChildren = true;
//      return true;
//    } else {
//      boolean success = true;
//      for (int row = 0; row < 3; row++) {
//        for (int col = 0; col < 3; col++) {
//          if (col != 1 || row == 1) {
//            success = success & shapes[3 * row + col].addLevel();
//          }
//        }
//      }
//      return success;
//    }
//  }

  @Override
  protected void createChildren() {
    hasChildren = true;
    int smallSquareSize = size / 3;
    for (int row = 0; row < 3; row++) {
      for (int col = 0; col < 3; col++) {
        if (col != 1 || row == 1) {
          int index = 3 * row + col;
          children[index + ((index > 0 ? (index > 7 ? -2 : -1) : 0))] =
              new HShape(xLocation + (smallSquareSize * col), yLocation + (smallSquareSize * row),
                  color, smallSquareSize);
        }
      }
    }
  }


  @Override
  public void draw(Graphics graphics) {
    graphics.setColor(color);
    if (!hasChildren) {
      graphics.fillRect(xLocation, yLocation, size, size);
    }
    graphics.setColor(Color.WHITE);
    graphics.fillRect(xLocation + size / 3, yLocation, size / 3, size / 3);
    graphics.fillRect(xLocation + size / 3, yLocation + 2 * size / 3, size / 3, size / 3);
    if (hasChildren) {
      for (Shape child :
          children) {
        child.draw(graphics);
      }
    }
  }

  @Override
  public Shape topLevel() {
    return new HShape(xLocation, yLocation, color, size);
  }

  @Override
  public int getLevel() {
    if (!hasChildren) {
      return 1;
    }
    return 1 + children[0].getLevel();
  }

  @Override
  public String toString() {
    return "HShape:"
        + "\nLevel " + getLevel()
        + "\nColor " + color
        + "\nX co-ord " + xLocation
        + "\nY co-ord " + yLocation;
  }


  @Override
  public HShape copy() {
    HShape copy = new HShape(xLocation, yLocation, color, size);
    if (hasChildren) {
      copy.setChildren(copyShapes());
      copy.hasChildren = true;
    }
    return copy;
  }

  @Override
  public boolean canAddLevel() {
    if (hasChildren) {
      return children[0].canAddLevel();
    }
    return size / 3 > 25;
  }
}
