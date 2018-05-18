import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class HShape extends AbstractShape {

//	private HShape[] innerH = new ArrayList<HShape>(7);

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
		
		
		
		if(this.shapeArray[0] != null) {
			System.out.println("indraw");
			for(int i = 0; i < this.shapeArray.length;i ++) {
				HShape f = (HShape)shapeArray[i];
				g.drawRect(f.getX(), f.getY(), f.getSize(), f.getSize());
				createH(f.getX(), f.getY(),miniSqrWidth, g);
				
//				g.drawRect(x, y, miniSqrWidth, height);
			}
		}
	}

	
	
	
	// creates 7 inner h's occupying sqrs that comprise this H
	// adds to shapeArray 
	// color can easily be modified
	public void addLevel() {
		
		if(this.shapeArray[0] == null) {
	
		
		
		int nuSize = this.getSize() / 3;

		shapeArray[0] = new HShape(this.getX(), this.getY(),this.getColor(), nuSize);
		shapeArray[1] = new HShape(this.getX() + (2 * nuSize), this.getY(), this.getColor(), nuSize);
		shapeArray[2] = new HShape(this.getX(), this.getY() + nuSize, this.getColor(), nuSize);
		shapeArray[3] = new HShape(this.getX() + nuSize, this.getY() + nuSize, this.getColor(), nuSize);
		shapeArray[4] = new HShape(this.getX() + (2 * nuSize), this.getY() + nuSize,this.getColor(), nuSize);
		shapeArray[5] = new HShape(this.getX(), this.getY() + (2 * nuSize), this.getColor(), nuSize);
		shapeArray[6] = new HShape(this.getX() + (2 * nuSize), this.getY() + (2 * nuSize), this.getColor(), nuSize);
	
		}
		else {
			for(int i = 0; i < this.shapeArray.length; i ++) {
				
				this.shapeArray[i].addLevel();
			}
		}


	}

//	// returns the innerH at the given index
//	protected HShape getInnerH(int index) {
//		return innerH.get(index);
//	}
//
//	// private field required a method to retrieve size.
//	protected int innerHSize() {
//		return innerH.size();
//
//	}

	// creates H shape, filled but not outlined
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

	// outlines all the sqrs comprising the H
	// color easily modified
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
		return new HShape(this.getX(),this.getY(),this.getColor(),this.getSize());
	}
}
