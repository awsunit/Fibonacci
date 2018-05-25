import java.awt.Color;

public abstract class AbstractShape implements Shape {

  protected final int xLocation;
  protected final int yLocation;
  protected final int size;
  protected final Color color;
  protected boolean hasChildren;
  protected Shape[] children = new Shape[0];

  public AbstractShape(int xLocation, int yLocation, Color color, int size) {
    this.xLocation = xLocation;
    this.yLocation = yLocation;
    this.color = color;
    this.size = size;
    hasChildren = false;
  }


  @Override
  public Shape topLevel() {
    return null;
  }

  @Override
  public boolean hasChildren() {
    return hasChildren;
  }

  @Override
  public int getxLocation() {
    return xLocation;
  }

  @Override
  public int getyLocation() {
    return yLocation;
  }

  @Override
  public int getXSize() {
    return size;
  }

  @Override
  public int getYSize() {
    return size;
  }

  @Override
  public boolean addLevel() {
    if (canAddLevel()) {
      if (hasChildren()) {
        for (Shape child :
            children) {
          child.addLevel();
        }
        return true;
      }
      createChildren();
      hasChildren = true;
      return true;
    }
    return false;
  }

  @Override
  public boolean removeLevel() {
    if (!hasChildren()) {
      return false;
    }
    if (children[0].hasChildren()) {
      for (Shape child :
          children) {
        child.removeLevel();
      }
      return true;
    }
    children = new Shape[children.length];
    hasChildren = false;
    return true;
  }

  protected void createChildren() {
  }

  @Override
  public boolean canAddLevel() {
    return false;
  }
}
