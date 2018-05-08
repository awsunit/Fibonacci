import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class FibonacciSquare extends AbstractShape {


	private int quadrant;
	private int myPlaceInFibSeq;
	private ArrayList<FibonacciSquare> innerSqr = new ArrayList<FibonacciSquare>();
	
	
	//removing int size, 
	public FibonacciSquare(int x, int y, Color c, int quadrant, int plcInFibSq) {
		super(x, y, c, FibonacciVal.FibonnaciNum(plcInFibSq));
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
			g.drawArc(x, y, width, height, 0, 90);
			// draw actual square arc occupies
			g.drawRect(x + width / 2, y, width / 2, height / 2);
			break;
		
		case 2:
			g.drawArc(x, y, width, height, 90, 90);
			// draw actual square arc occupies
			g.drawRect(this.getX(), this.getY(), width / 2, height / 2);
			break;
			
		case 3:
			g.drawArc(x, y, width, height, 180, 90);
			// draw actual square arc occupies
			g.drawRect(this.getX(), this.getY() + (width/2), width / 2, height / 2);
			break;
		
		case 4:
			g.drawArc(x, y, width, height, 270, 90);
			g.drawRect(this.getX() + (width/2), this.getY() + (width/2), width / 2, height / 2);
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
		
		
		System.out.println("recieved pos in seg " + baseFibSeq);
		System.out.println("passed pos in seg " + (baseFibSeq + 1));
		System.out.println("recieved val of seg " + baseFibSeqVal);
		System.out.println("passes val of seg " + myFibSeqVal);
		switch(baseQuadrant) {
		//removing all the size terms from each case, was fourth in position
		case 1:
			System.out.println("baseq " + baseQuadrant);
			//quad1
			//(baseFibSeqVal/2)-((myFibSeqVal/2)-(baseFibSeqVal/2))
			int nuX = x - (baseFibSeqVal/2)-((myFibSeqVal/2)-(baseFibSeqVal/2)) ;
			sqr = new FibonacciSquare(nuX,y,Color.BLACK,baseQuadrant+1,baseFibSeq + 1);
			return sqr;
		case 2:
			System.out.println("baseq " + baseQuadrant);
			//quad2
			int deltaY = (myFibSeqVal/2) - (baseFibSeqVal/2);
			int nuY = y - deltaY;
			sqr = new FibonacciSquare(x,nuY,Color.BLACK,baseQuadrant+1,baseFibSeq + 1);
			return sqr;
			
		case 3:
			System.out.println("baseq " + baseQuadrant);
//			//quad3
			int deltax = (myFibSeqVal/2) - (baseFibSeqVal/2);
			int nuy = y - (myFibSeqVal/2 + ((myFibSeqVal/2) - (baseFibSeqVal)) ) ;
			int nux = x - deltax;
			sqr = new FibonacciSquare(nux,nuy,Color.BLACK,baseQuadrant+1,baseFibSeq + 1);
			return sqr;
			
		case 4:	
//			//quad4
		
			int deltx = (myFibSeqVal/2) - (baseFibSeqVal/2);
			int nuyy = y - ((myFibSeqVal/2) - (baseFibSeqVal/2) ) ;
			int nuxx = x - myFibSeqVal + baseFibSeqVal;
			sqr = new FibonacciSquare(nuxx,nuyy,Color.BLACK,baseQuadrant-3,baseFibSeq + 1);
			System.out.println("was here");
			return sqr;

			
			
			
		}
	//to make compiler happy
	 sqr = new FibonacciSquare(11,11,Color.BLACK,baseQuadrant+1,baseFibSeq + 1);
	return sqr;
		
		
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
