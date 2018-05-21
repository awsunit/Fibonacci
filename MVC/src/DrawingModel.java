import java.util.ArrayList;

public class DrawingModel {
	// the list of the shapes
	protected ArrayList<Shape> shapes = new ArrayList<Shape>();

	// the list of the views connected to this model
	private ArrayList<View> views = new ArrayList<View>();

	// A client should be able to add a Shape to the model
	
	//deleted abstract
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

	// Returns the list of the shapes -- deepcopy
	public ArrayList<Shape> getShapes() {
		
		ArrayList<Shape> listOfShapes = new ArrayList<>();
		for (Shape shape : shapes) {
			listOfShapes.add(shape.copy());
		}
		return listOfShapes;
	}

	// checks each of the shapes returns abstractshapes.contains bool
	public boolean contains(int clickedX, int clickedY) {

		for (Shape s : shapes) {
			if (s.contains(clickedX, clickedY)) {
				return true;
			}
		}
		return false;
	}

	//checks for shape at position of mouse click, if one is present, calls that shapes addLevel
	//notice that this only checks those initial shapes contained in array...
	public boolean addLevel(int clickedX, int clickedY) {

		for (int j = 0;j < shapes.size(); j ++) {
			if (shapes.get(j).contains(clickedX, clickedY)) {				
				shapes.get(j).addLevel();
				updateAll();
				return true;
			}
		}
		return false;
	}

	//similar to addLevel
	public boolean removeLevel(int clickedX, int clickedY) {
		
		for (Shape shape : shapes) {
			if (shape.contains(clickedX, clickedY)) {
				shape.removeLevel();
				updateAll();
				return true;
			}
		}
		return false;
	}

}
