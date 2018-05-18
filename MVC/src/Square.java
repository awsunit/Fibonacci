import java.awt.Color;
import java.awt.Graphics;

public class Square extends AbstractShape implements Shape {


  public Square(int xLocation, int yLocation, Color color, int size) {
    super(xLocation, yLocation, color, size);
  }


  @Override
  public void draw(Graphics graphics) {
    graphics.setColor(color);
    graphics.fillRect(xLocation, yLocation, size, size);
  }

  @Override
  public Shape copy() {
    return new Square(xLocation, yLocation, color, size);
  }
}
