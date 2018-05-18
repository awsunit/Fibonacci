import java.awt.Graphics;

public interface Shape {
	void draw(Graphics g);
	
	Shape copy();
	 void addLevel();
}
