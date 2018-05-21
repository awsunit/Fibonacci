import java.awt.Graphics;

public interface Shape {

  /**
   * Draws the shape in the given window
   *
   * @param graphics the window to draw in
   */
  void draw(Graphics graphics);

  /**
   * @return A deep copy of the shape
   */
  Shape copy();

  boolean addLevel();
  boolean removeLevel();
  boolean hasChildren();

  Shape topLevel();

  int getXSize();
  int getYSize();
  int getxlocation();
  int getylocation();
}
