import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Random;

public class HShape extends AbstractShape {

	public HShape(int x, int y, Color c, int size) {
		this.setX(x);
		this.setY(y);
		this.setColor(c);
		this.setSize(size);

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

		// //top row
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

		// trace outline of smallsqrs
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
