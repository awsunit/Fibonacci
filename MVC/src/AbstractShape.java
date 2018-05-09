import java.awt.Color;

public abstract class AbstractShape implements Shape {

  protected int xLocation;
  protected int yLocation;
  //the sqr that the H resides in
  protected int size;
  protected Color color;

  public AbstractShape(int xLocation, int yLocation, Color color, int size) {
    this.setxLocation(xLocation);
    this.setyLocation(yLocation);
    this.setColor(color);
    this.setSize(size);
  }


  protected int getxLocation() {
    return xLocation;
  }

  protected void setxLocation(int xLocation) {
    this.xLocation = xLocation;
  }

  protected int getyLocation() {
    return yLocation;
  }

  protected void setyLocation(int yLocation) {
    this.yLocation = yLocation;
  }

  protected Color getColor() {
    return color;
  }

  protected void setColor(Color c) {
    this.color = c;
  }

  protected int getSize() {
    return size;
  }

  protected void setSize(int size) {
    this.size = size;
  }

}
