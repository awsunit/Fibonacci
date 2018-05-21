import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Viewer extends JPanel implements View {

	// The model this View is connected to
	private DrawingModel model;

	public Viewer() {
		setBackground(Color.WHITE);
	}

	@Override
	public void update(DrawingModel model) {

		this.model = model;
		repaint(); // will eventually call paintComponent

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		// display of the shapes
		if (model != null) {
			for (Shape s : model.getShapes()) {

				//trying to get the inner ones
				//if children are present, tried (for each) trying (for loop)
				if (((AbstractShape) s).shapeArray[0] != null) {
					//model.add(shape) hmmmm
					for(int i = 0; i < ((AbstractShape) s).shapeArray.length;i ++ )
					{
						((AbstractShape) s).shapeArray[i].draw(g);
					}
//					for (Shape sh : ((AbstractShape) s).shapeArray) {
//						sh.draw(g);
//					}
				}
				s.draw(g);

			}
		}
	}

}
