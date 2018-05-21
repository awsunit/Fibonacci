import java.awt.Color;

public abstract class AbstractShape implements Shape {

	private int x;
	private int y;
	// the sqr that the H resides in
	private int containerSqrSize;
	private Color c;
	// innerH's
	protected Shape[] shapeArray;

	public AbstractShape(int x, int y, Color c, int containerSqrSize) {

		this.setX(x);
		this.setY(y);
		this.setColor(c);
		this.setSize(containerSqrSize);
	}

	protected int getX() {
		return x;
	}

	protected int getY() {
		return y;
	}

	protected Color getColor() {
		return c;
	}

	protected int getSize() {
		return containerSqrSize;
	}

	protected void setSize(int size) {
		this.containerSqrSize = size;
	}

	protected void setColor(Color c) {
		this.c = c;
	}

	protected void setX(int x) {
		this.x = x;
	}

	protected void setY(int y) {
		this.y = y;
	}

	public boolean contains(int clickedX, int clickedY) {
		int xFrom, xTo, yFrom, yTo,rowSize,xNoMansFrom,xNoMansTo,yNoMansTopFrom,yNoMansTopTo,yNoMansBotFrom,yNoMansBotTo ;
		boolean widthOk, heightOk, noMans1,noMans2;

		xFrom = this.getX();
		xTo = this.getSize() + xFrom;
		yFrom = this.getY();
		yTo = this.getSize() + yFrom;
		
		//middle square sections
		rowSize = this.getSize()/3;
		xNoMansFrom = xFrom + rowSize;
		xNoMansTo = xFrom + rowSize*2;
		
		yNoMansTopFrom = yFrom;
		yNoMansTopTo = yFrom + rowSize;
		
		yNoMansBotFrom = yFrom + (2*rowSize);
		yNoMansBotTo = yTo;
		
		noMans1 = (clickedX > xNoMansFrom && clickedX < xNoMansTo)&&(clickedY > yFrom && clickedY < yNoMansTopTo);
		noMans2 = (clickedX > xNoMansFrom && clickedX < xNoMansTo)&&(clickedY > yNoMansBotFrom && clickedY < yTo);
		
		

		//wish java could read things like 0<x<1
		widthOk = (clickedX >= xFrom) && (clickedX <= xTo);
		heightOk = (clickedY >= yFrom) && (clickedY <= yTo);
		
		if(noMans1 || noMans2) {
			return false;
		}

		return (widthOk && heightOk);

	}

}
