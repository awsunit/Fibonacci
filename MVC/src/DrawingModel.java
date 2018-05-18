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

  public void addShape(ArrayList<Shape> shapes) {
    this.shapes.addAll(shapes);
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







