import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Random;

public class FibonacciSquare extends AbstractShape {

	private int quadrant;
	private int myPlaceInFibSeq;
	
	protected int getFibSeq() {
		return myPlaceInFibSeq;
	}
	protected void setFibSeq(int i) {
		myPlaceInFibSeq = i;
	}

	public FibonacciSquare(int x, int y, Color c, int size, int quadrant, int plcInFibSq) {
		super(x, y, c, size);
		this.setQuadrant(quadrant);
		this.setFibSeq(plcInFibSq);
		
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

	protected static FibonacciSquare addLevel(FibonacciSquare baseSqr) {
		int x = baseSqr.getX();
		int y =  baseSqr.getY();
		int baseQuadrant = baseSqr.getQuadrant();
		
		int baseFibSeq = baseSqr.getFibSeq();
		int baseFibSeqVal = baseSqr.getSize();
		
		FibonacciSquare sqr;
		int myFibSeqVal = FibonacciVal.FibonnaciNum(baseFibSeq + 2);
		
		
		
		switch(baseQuadrant) {
		
		case 1:
			System.out.println("baseq " + baseQuadrant);
			//quad1
			int deltaX = (myFibSeqVal/2) - (baseFibSeqVal/2);
			int nuX = x - deltaX;
			sqr = new FibonacciSquare(nuX,y,Color.BLACK,myFibSeqVal,baseQuadrant+1,baseFibSeq + 1);
			return sqr;
		case 2:
			System.out.println("baseq " + baseQuadrant);
			//quad2
			int deltaY = (myFibSeqVal/2) - (baseFibSeqVal/2);
			int nuY = y - deltaY;
			sqr = new FibonacciSquare(x,nuY,Color.BLACK,myFibSeqVal,baseQuadrant+1,baseFibSeq + 1);
			return sqr;
			
		case 3:
			System.out.println("baseq " + baseQuadrant);
//			//quad3
			int deltax = (myFibSeqVal/2) - (baseFibSeqVal/2);
			int nuy = y - (myFibSeqVal/2 + ((myFibSeqVal/2) - (baseFibSeqVal)) ) ;
			int nux = x - deltax;
			sqr = new FibonacciSquare(nux,nuy,Color.BLACK,myFibSeqVal,baseQuadrant+1,baseFibSeq + 1);
			return sqr;
			
		case 4:	
//			//quad4
		
			int deltx = (myFibSeqVal/2) - (baseFibSeqVal/2);
			int nuyy = y - ((myFibSeqVal/2) - (baseFibSeqVal/2) ) ;
			int nuxx = x - myFibSeqVal + baseFibSeqVal;
			sqr = new FibonacciSquare(nuxx,nuyy,Color.BLACK,myFibSeqVal,baseQuadrant-3,baseFibSeq + 1);
			System.out.println("was here");
			return sqr;

			
			
			
		}
	//to make compiler happy
	 sqr = new FibonacciSquare(11,11,Color.BLACK,myFibSeqVal,baseQuadrant+1,baseFibSeq + 1);
	return sqr;
		
		
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
