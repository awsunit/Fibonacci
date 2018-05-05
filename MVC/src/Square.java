import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Square extends AbstractShape {

	
	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		Random rand = new Random();
		int x,y,width,height;
		
		
		x = rand.nextInt(1000);
		y = rand.nextInt(800);
		
		width = height = 50;
		g.setColor(Color.CYAN);
		
		
		g.drawRect(x, y, width, height);
		
	}
}
