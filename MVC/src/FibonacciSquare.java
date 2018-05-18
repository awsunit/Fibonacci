import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class FibonacciSquare extends AbstractShape {

	private int quadrant;
	private int myPlaceInFibSeq;
	private ArrayList<FibonacciSquare> innerSqr = new ArrayList<FibonacciSquare>();

	public FibonacciSquare(int x, int y, Color c, int quadrant, int plcInFibSq) {
		super(x, y, c, FibonacciVal.FibonnaciNum(plcInFibSq));
		this.setQuadrant(quadrant % 4);
		this.setFibSeq(plcInFibSq);
		this.shapeArray = new FibonacciSquare[1];

	}

	@Override
	public void draw(Graphics g) {

		int size = this.getSize();
		int x = this.getX();
		int y = this.getY();
		g.setColor(this.getColor());
		g.drawRect(x, y, size, size);
		int startAngle = quadrant * 90;
		int arcX = x - size + (quadrant % 3 != 0 ? size : 0);
		int arcY = y - (quadrant > 1 ? size : 0);
		g.drawArc(arcX, arcY, 2 * size, 2 * size, startAngle, 90);

	}

	
	protected FibonacciSquare addLevel() {
		int x = this.getX();
		int y = this.getY();

		int nextSize = FibonacciVal.FibonnaciNum(myPlaceInFibSeq + 1);
		int prevSize = FibonacciVal.FibonnaciNum(myPlaceInFibSeq - 1);

		switch (quadrant) {

		case 0:
			x -= nextSize;
			break;
		case 1:
			y += this.getSize();
			break;
		case 2:
			x += this.getSize();
			y -= prevSize;
			break;
		case 3:
			x -= prevSize;
			y -= nextSize;
			break;
		}
		return new FibonacciSquare(x, y, this.getColor(), (quadrant + 1) % 4, myPlaceInFibSeq + 1);

	}

	protected void setQuadrant(int q) {
		this.quadrant = q;
	}

	protected int getQuadrant() {
		return this.quadrant;
	}

	protected int getFibSeq() {
		return myPlaceInFibSeq;
	}

	protected void setFibSeq(int i) {
		myPlaceInFibSeq = i;
	}

}
