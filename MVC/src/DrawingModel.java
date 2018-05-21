import java.util.ArrayList;

public class DrawingModel {

  // the list of the shapes
  private final ArrayList<Shape> shapes = new ArrayList<>();

  // the list of the views connected to this model
  private final ArrayList<View> views = new ArrayList<>();

  // A client should be able to add a Shape to the model
  public void addShape(Shape shape) {
    shapes.add(shape);
    updateAll();
  }


  // A viewer should be able to register with the model
  public void addView(View view) {
    views.add(view);
    view.update(this);
  }

  // It should notify all viewers when something in the model changes.
  private void updateAll() {
    for (View view : views) {
      view.update(this);
    }
  }

  public boolean addLevel(int x, int y) {
    if (x>850){
      shapes.get(1).addLevel();
    } else {
      Shape shape = shapes.get(0);
      int xSize = shape.getXSize();
      int ySize = shape.getYSize();
      int xLocation = shape.getxlocation();
      int yLocation = shape.getylocation();

      if (x>xLocation&&x<xLocation+xSize&&y>yLocation&&y<yLocation+ySize){
        shape.addLevel();
      }
    }
    updateAll();
    return false;
  }

  public boolean removeLevel(int x, int y) {
    if (x>850){
      shapes.get(1).removeLevel();
    } else {
      Shape shape = shapes.get(0);
      int xSize = shape.getXSize();
      int ySize = shape.getYSize();
      int xLocation = shape.getxlocation();
      int yLocation = shape.getylocation();

      if (x>xLocation&&x<xLocation+xSize&&y>yLocation&&y<yLocation+ySize){
        shape.removeLevel();
      }
    }
    updateAll();
    return false;
  }

  public void reset(){
    for (int i = 0; i < shapes.size(); i++) {
      shapes.set(i,shapes.get(i).topLevel());
    }
    updateAll();
  }

  /**
   * @return A deep copy of the shapes in the model
   */
  public ArrayList<Shape> getShapes() {

    ArrayList<Shape> copyOfShapes = new ArrayList<>();
    for (Shape shape :
        shapes) {
      copyOfShapes.add(shape.copy());
    }
    return copyOfShapes;
  }


}







