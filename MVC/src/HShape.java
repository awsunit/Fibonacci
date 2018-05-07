import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class HShape extends AbstractShape {

	private ArrayList<HShape> innerH = new ArrayList<HShape>(7);

	public HShape(int x, int y, Color c, int size) {
		super(x, y, c, size);

	}

	@Override
	public void draw(Graphics g) {
		int x = this.getX();
		int y = this.getY();
		int width = this.getSize();
		int height = this.getSize();
		g.setColor(this.getColor());

		// first draw outside square
		g.drawRect(x, y, width, height);

		// width of individual sqrs comprising hshape
		int miniSqrWidth = width / 3;

		// create H
		createH(x, y, miniSqrWidth, g);

		// trace outline of the smallsqrs
		traceSmallSqr(x, y, miniSqrWidth, width, height, g);
	}

	// creates 7 inner h's occupying sqrs that comprise this H
	// adds to innerH ->> arraylist
	// color can easily be modified
	protected void addInnerH(int x, int y, Color c, int size) {
		int nuSize = size / 3;

		// topleft
		innerH.add(new HShape(x, y, Color.YELLOW, nuSize));
		// topright
		innerH.add(new HShape(x + (2 * nuSize), y, Color.YELLOW, nuSize));
		// midleft
		innerH.add(new HShape(x, y + nuSize, Color.YELLOW, nuSize));
		// midmid
		innerH.add(new HShape(x + nuSize, y + nuSize, Color.YELLOW, nuSize));
		// midright
		innerH.add(new HShape(x + (2 * nuSize), y + nuSize, Color.YELLOW, nuSize));
		// botleft
		innerH.add(new HShape(x, y + (2 * nuSize), Color.YELLOW, nuSize));
		// botright
		innerH.add(new HShape(x + (2 * nuSize), y + (2 * nuSize), Color.YELLOW, nuSize));

	}

	// returns the innerH at the given index
	protected HShape getInnerH(int index) {
		return innerH.get(index);
	}

	// private field required a method to retrieve size.
	protected int innerHSize() {
		return innerH.size();

	}

	//creates H shape, filled but not outlined
	protected void createH(int x, int y, int miniSqrWidth, Graphics g) {
		
		// //first sqr top left corner
		g.fillRect(x, y, miniSqrWidth, miniSqrWidth);
		// //skip middle on top right corner
		g.fillRect(x + (2 * miniSqrWidth), y, miniSqrWidth, miniSqrWidth);
		//
		// //middle row left sqr
		g.fillRect(x, y + miniSqrWidth, miniSqrWidth, miniSqrWidth);
		// //middle mid sqr
		g.fillRect(x + miniSqrWidth, y + miniSqrWidth, miniSqrWidth, miniSqrWidth);
		// //middle right sqr
		g.fillRect(x + (2 * miniSqrWidth), y + miniSqrWidth, miniSqrWidth, miniSqrWidth);
		//
		// //bottom row
		g.fillRect(x, y + (2 * miniSqrWidth), miniSqrWidth, miniSqrWidth);
		g.fillRect(x + (2 * miniSqrWidth), y + (2 * miniSqrWidth), miniSqrWidth, miniSqrWidth);

	}

	//outlines all the sqrs comprising the H
	//color easily modified
	protected void traceSmallSqr(int x, int y, int miniSqrWidth, int width, int height, Graphics g) {
		g.setColor(Color.BLACK);
		g.drawRect(x, y, miniSqrWidth, miniSqrWidth);
		g.drawRect(x + (2 * miniSqrWidth), y, miniSqrWidth, miniSqrWidth);
		g.drawRect(x, y + miniSqrWidth, miniSqrWidth, miniSqrWidth);
		g.drawRect(x + miniSqrWidth, y + miniSqrWidth, miniSqrWidth, miniSqrWidth);
		g.drawRect(x + (2 * miniSqrWidth), y + miniSqrWidth, miniSqrWidth, miniSqrWidth);
		g.drawRect(x, y + (2 * miniSqrWidth), miniSqrWidth, miniSqrWidth);
		g.drawRect(x + (2 * miniSqrWidth), y + (2 * miniSqrWidth), miniSqrWidth, miniSqrWidth);
		g.drawRect(x, y, width, height);

	}
}
