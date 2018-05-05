import java.awt.Color;

public abstract class AbstractShape implements Shape {
	
	private int x;
	private int y;
	private int containerSqrSize;
	private Color c;
	
	
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
		this.y= y;
	}

}
