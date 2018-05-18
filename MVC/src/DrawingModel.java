import java.util.ArrayList;

public class DrawingModel {
	// the list of the shapes
	protected ArrayList<Shape> shapes = new ArrayList<Shape>();

	// the list of the views connected to this model
	private ArrayList<View> views = new ArrayList<View>();

	// A client should be able to add a Shape to the model
	public void addShape(AbstractShape s) {
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
		// with an index
		// for (int i = 0; i < views.size(); i ++) {
		// views.get(i).update(this);
		// }

		// or with a for-each loop
		for (View v : views) {
			v.update(this);
		}
	}
	
	// Returns the list of the shapes
	public ArrayList<Shape> getShapes() {
		// Change this later so that a deep copy is returned (or a copy that 
		// behaves like a deep copy)
		 ArrayList<Shape> listOfShapes = new ArrayList<>();
		    for (Shape shape :shapes) {
		      listOfShapes.add(shape.copy());
		    }
		    return listOfShapes;
	}
	
	
	public void addLevel() {
		for(Shape shape: shapes) {
			((AbstractShape) shape).addLevel();
			updateAll();
		}
	}
	
	
}







