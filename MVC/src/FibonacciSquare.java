import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Random;

public class FibonacciSquare extends AbstractShape {

	private int quadrant;

	public FibonacciSquare(int x, int y, Color c, int size, int quadrant) {
		super(x, y, c, size);
		this.setQuadrant(quadrant);
		
	}

	@Override
	public void draw(Graphics g) {

		int x = this.getX();
		int y = this.getY();
		int width = this.getSize();
		int height = this.getSize();
		g.setColor(this.getColor());

		// first draw the outside square that arc is part of - keeping in case 
		//g.drawRect(x, y, width, height);
		
		switch(this.quadrant) {
		
		case 1:
			quad1(x, y, width, height, 0, 90, g);
			break;
		
		case 2:
			quad2(x, y, width, height, 90, 90, g);
			break;
			
		case 3:
			quad3(x, y, width, height, 180, 90, g);
			break;
		
		case 4:
			quad4(x, y, width, height, 270, 90, g);
			break;
		}
			
			

	}

	protected void setQuadrant(int q) {
		this.quadrant = q;
	}

	protected int getQuadrant() {
		return this.quadrant;
	}

	protected void quad1(int arcStartX, int arcStartY, int width, int height, int thetaNaught, int thetaFinal,
			Graphics g) {
		g.drawArc(arcStartX, arcStartY, width, height, thetaNaught, thetaFinal);
		// draw actual square arc occupies
		g.drawRect(arcStartX + width / 2, arcStartY, width / 2, height / 2);
	}

	protected void quad2(int arcStartX, int arcStartY, int width, int height, int thetaNaught, int thetaFinal,
			Graphics g) {
		g.drawArc(arcStartX, arcStartY, width, height, thetaNaught, thetaFinal);
		// draw actual square arc occupies
		g.drawRect(this.getX(), this.getY(), width / 2, height / 2);
	}

	protected void quad3(int arcStartX, int arcStartY, int width, int height, int thetaNaught, int thetaFinal,
			Graphics g) {
		g.drawArc(arcStartX, arcStartY, width, height, thetaNaught, thetaFinal);
		// draw actual square arc occupies
		g.drawRect(this.getX(), this.getY() + (width/2), width / 2, height / 2);
	}

	protected void quad4(int arcStartX, int arcStartY, int width, int height, int thetaNaught, int thetaFinal,
			Graphics g) {
		g.drawArc(arcStartX, arcStartY, width, height, thetaNaught, thetaFinal);
		g.drawRect(this.getX() + (width/2), this.getY() + (width/2), width / 2, height / 2);
	}
}
