import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class HShape extends AbstractShape {

  private ArrayList<HShape> innerH = new ArrayList<>(7);

  public HShape(int xLocation, int yLocation, Color color, int size) {
    super(xLocation, yLocation, color, size);

  }

  @Override
  public void draw(Graphics g) {
    int x = this.getxLocation();
    int y = this.getyLocation();
    int width = this.getSize();
    int height = this.getSize();
    g.setColor(this.getColor());

    // first draw outside square
    g.drawRect(x, y, width, height);

    // width of individual sqrs comprising hshape
    int miniSqrWidth = width / 3;

    // create H
    createH(x, y, miniSqrWidth, g);

    // trace outline of the smallsqrs
    traceSmallSqr(x, y, miniSqrWidth, width, height, g);
  }

  // creates 7 inner h's occupying sqrs that comprise this H
  // adds to innerH ->> arraylist
  // color can easily be modified
  protected void addInnerH() {
    int newSize = this.size / 3;

    // topleft
    innerH.add(new HShape(xLocation, yLocation, Color.YELLOW, newSize));
    // topright
    innerH.add(new HShape(xLocation + (2 * newSize), yLocation, Color.YELLOW, newSize));
    // midleft
    innerH.add(new HShape(xLocation, yLocation + newSize, Color.YELLOW, newSize));
    // midmid
    innerH.add(new HShape(xLocation + newSize, yLocation + newSize, Color.YELLOW, newSize));
    // midright
    innerH.add(new HShape(xLocation + (2 * newSize), yLocation + newSize, Color.YELLOW, newSize));
    // botleft
    innerH.add(new HShape(xLocation, yLocation + (2 * newSize), Color.YELLOW, newSize));
    // botright
    innerH.add(
        new HShape(xLocation + (2 * newSize), yLocation + (2 * newSize), Color.YELLOW, newSize));

  }

  // returns the innerH at the given index
  protected HShape getInnerH(int index) {
    return innerH.get(index);
  }

  // private field required a method to retrieve size.
  protected int innerHSize() {
    return innerH.size();

  }

  //creates H shape, filled but not outlined
  protected void createH(int x, int y, int miniSqrWidth, Graphics g) {

    // //first sqr top left corner
    g.fillRect(x, y, miniSqrWidth, miniSqrWidth);
    // //skip middle on top right corner
    g.fillRect(x + (2 * miniSqrWidth), y, miniSqrWidth, miniSqrWidth);
    //
    // //middle row left sqr
    g.fillRect(x, y + miniSqrWidth, miniSqrWidth, miniSqrWidth);
    // //middle mid sqr
    g.fillRect(x + miniSqrWidth, y + miniSqrWidth, miniSqrWidth, miniSqrWidth);
    // //middle right sqr
    g.fillRect(x + (2 * miniSqrWidth), y + miniSqrWidth, miniSqrWidth, miniSqrWidth);
    //
    // //bottom row
    g.fillRect(x, y + (2 * miniSqrWidth), miniSqrWidth, miniSqrWidth);
    g.fillRect(x + (2 * miniSqrWidth), y + (2 * miniSqrWidth), miniSqrWidth, miniSqrWidth);

  }

  //outlines all the sqrs comprising the H
  //color easily modified
  protected void traceSmallSqr(int x, int y, int miniSqrWidth, int width, int height, Graphics g) {
    g.setColor(Color.BLACK);
    g.drawRect(x, y, miniSqrWidth, miniSqrWidth);
    g.drawRect(x + (2 * miniSqrWidth), y, miniSqrWidth, miniSqrWidth);
    g.drawRect(x, y + miniSqrWidth, miniSqrWidth, miniSqrWidth);
    g.drawRect(x + miniSqrWidth, y + miniSqrWidth, miniSqrWidth, miniSqrWidth);
    g.drawRect(x + (2 * miniSqrWidth), y + miniSqrWidth, miniSqrWidth, miniSqrWidth);
    g.drawRect(x, y + (2 * miniSqrWidth), miniSqrWidth, miniSqrWidth);
    g.drawRect(x + (2 * miniSqrWidth), y + (2 * miniSqrWidth), miniSqrWidth, miniSqrWidth);
    g.drawRect(x, y, width, height);

  }

  @Override
  public HShape copy() {
    return new HShape(xLocation,yLocation,color,size);
  }
}
