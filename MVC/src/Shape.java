import java.awt.Graphics;

public interface Shape {
	

	Shape copy();

	boolean addLevel();

	boolean removeLevel();

	boolean contains(int i, int j);
	
	void draw(Graphics g);
}
