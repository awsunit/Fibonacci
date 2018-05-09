import java.util.ArrayList;

public class DrawingModel {

  // the list of the shapes
  private ArrayList<Shape> shapes = new ArrayList<Shape>();

  // the list of the views connected to this model
  private ArrayList<View> views = new ArrayList<View>();

  // A client should be able to add a Shape to the model
  public void addShape(Shape s) {
    shapes.add(s);
    updateAll();
  }

  // A viewer should be able to register with the model
  public void addView(View v) {
    views.add(v);
    v.update(this);
  }

  // It should notify all viewers when something in the model changes.
  public void updateAll() {
    for (View v : views) {
      v.update(this);
    }
  }

  /**
   *
    * @return A deep copy of the shapes in the model
   */
  public ArrayList<Shape> getShapes() {

    ArrayList<Shape> listOfShapes = new ArrayList<>();
    for (Shape shape :
        shapes) {
      listOfShapes.add(shape.copy());
    }
    return listOfShapes;
  }


}







