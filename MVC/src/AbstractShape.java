import java.awt.Color;

public abstract class AbstractShape implements Shape {

  protected final int xLocation;
  protected final int yLocation;
  //the sqr that the H resides in
  protected final int size;
  protected final Color color;
  protected int level;
  public boolean hasChildren;

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
  public int getxlocation() {
    return xLocation;
  }

  @Override
  public int getylocation() {
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
    return false;
  }

  @Override
  public boolean removeLevel() {
    return false;
  }

  @Override
  public String toString() {
	  String s = "I am a " + this.getClass() + "\n" +
			  "I live at (x,y) = (" + this.getXSize() + "," +
			  this.getYSize() + ")\n" + "I am " + 
			  color + " colored" + "\n" 
			  		+ "I am a level " + this.level;
	  return s;
  }
  
 
 
}
