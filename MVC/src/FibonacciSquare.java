import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Random;

public class FibonacciSquare extends AbstractShape {
	@Override
	public void draw(Graphics g) {
		// print Fibonacci at a random location
		// CHANGE THIS
		Random rand = new Random();
		// font size
		int fsize = rand.nextInt(16) + 10;
		Font font = new Font("Courier", Font.BOLD, fsize);
		g.setFont(font);
		// random color for the font
		g.setColor(new Color(rand.nextInt()));
		// random location
		int x = rand.nextInt(1000);
		int y = rand.nextInt(800);
		g.drawString("Fibonacci!", x, y);
	}
}
