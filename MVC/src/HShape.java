import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class HShape extends AbstractShape {

	String[] jar = new String[7];

	public HShape(int x, int y, Color c, int size) {
		super(x, y, c, size);
		this.shapeArray = new HShape[7];

	}

	@Override
	public void draw(Graphics g) {
		int x = this.getX();
		int y = this.getY();
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

		
		
		if (this.shapeArray[0] != null) {
			for (Shape s : this.shapeArray) {
				s.draw(g);
			}
		}

	}

	// creates 7 inner h's occupying sqrs that comprise this H
	// adds them to shapeArray
	// color can easily be modified
	@Override
	public boolean addLevel() {

		
		
		if (this.shapeArray[0] == null) {

			int nuSize = this.getSize() / 3;
	

			
			//checking that h's will render, if not returning false
			if (nuSize > 20) {
				System.out.println("inside HShapes were null, creating now");
				shapeArray[0] = new HShape(this.getX(), this.getY(),this.getColor(), nuSize);
				shapeArray[1] = new HShape(this.getX() + (2 * nuSize), this.getY(), this.getColor(), nuSize);
				shapeArray[2] = new HShape(this.getX(), this.getY() + nuSize, this.getColor(), nuSize);
				shapeArray[3] = new HShape(this.getX() + nuSize, this.getY() + nuSize, this.getColor(), nuSize);
				shapeArray[4] = new HShape(this.getX() + (2 * nuSize), this.getY() + nuSize,this.getColor(), nuSize);
				shapeArray[5] = new HShape(this.getX(), this.getY() + (2 * nuSize), this.getColor(), nuSize);
				shapeArray[6] = new HShape(this.getX() + (2 * nuSize), this.getY() + (2 * nuSize), this.getColor(), nuSize);
			} else {
				
				return false;
			
			}
		} else {
			System.out.println("inside h's were full, making them parents");
			for (int i = 0; i < this.shapeArray.length; i++) {
				this.shapeArray[i].addLevel();
			}
		}

		return true;
	}

	// use recursive calling...
	public boolean removeLevel() {

		int i = 0;
		if (this.shapeArray[0] != null) {
			for (Shape s : shapeArray) {
				s.removeLevel();
			}
		} else if (this.shapeArray[0] == null) {
			if (i > 0) {
			}
		}
		return false;
	}

	// returns the innerH at the given index
	protected Shape getInnerH(int index) {
		return this.shapeArray[index];
	}

	// creates H shape, filled but not outlined
	protected void createH(int x, int y, int miniSqrWidth, Graphics g) {

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (i == 1 && (j == 0 || j == 2)) {
					g.setColor(Color.WHITE);
				}
				g.fillRect(x + (i * miniSqrWidth), y + (j * miniSqrWidth), miniSqrWidth, miniSqrWidth);
				g.setColor(this.getColor());
			}
		}

	}

	// outlines all the sqrs comprising the H
	// color easily modified
	protected void traceSmallSqr(int x, int y, int miniSqrWidth, int width, int height, Graphics g) {
		g.setColor(Color.BLACK);
		for(int i = 0; i < 3; i ++) {
			for(int j = 0; j < 3; j ++) {
				if(!((i == 1 && j == 0) || (i == 1 && j == 2))) {
				g.drawRect(x + (i * miniSqrWidth), y + (j * miniSqrWidth),miniSqrWidth, miniSqrWidth);
				}
			}
		}


	}

	@Override
	public HShape copy() {
		return new HShape(this.getX(), this.getY(), this.getColor(), this.getSize());
	}
}
