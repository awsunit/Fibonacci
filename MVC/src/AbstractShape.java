import java.awt.Color;

public abstract class AbstractShape implements Shape {

  protected final int xLocation;
  protected final int yLocation;
  //the sqr that the H resides in
  protected final int size;
  protected final Color color;

  public AbstractShape(int xLocation, int yLocation, Color color, int size) {
    this.xLocation = xLocation;
    this.yLocation = yLocation;
    this.color = color;
    this.size = size;
  }
}
