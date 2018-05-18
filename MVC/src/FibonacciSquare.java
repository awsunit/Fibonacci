import java.awt.Color;
import java.awt.Graphics;

public class FibonacciSquare extends AbstractShape {

  private int quadrant;
  private int sequenceIndex;

  public FibonacciSquare(int xLocation, int yLocation, Color color, int quadrant,
      int sequenceIndex) {
    super(xLocation, yLocation, color, fibonacciSum(sequenceIndex));
    this.setQuadrant(quadrant % 4);
    this.setSequenceIndex(sequenceIndex);

  }

  private static int fibonacciSum(int n) {
    if (n < 1) {
      return 0;
    }
    int prevSum = 0;
    int curSum = 1;
    for (int i = 1; i < n; i++) {
      curSum += prevSum;
      prevSum = curSum - prevSum;
    }
    return curSum;
  }

  public FibonacciSquare nextSquare() {
    int nextSize = fibonacciSum(sequenceIndex + 1);
    int prevSize = fibonacciSum(sequenceIndex - 1);
    int nextX = xLocation;
    int nextY = yLocation;

    switch (quadrant) {
      case 0:
        nextX -= nextSize;
        break;
      case 1:
        nextY += size;
        break;
      case 2:
        nextX += size;
        nextY -= prevSize;
        break;
      case 3:
        nextY -= nextSize;
        nextX -= prevSize;
        break;

    }

    return new FibonacciSquare(nextX, nextY, color, (quadrant + 1) % 4, sequenceIndex + 1);

  }


  private void setSequenceIndex(int sequenceIndex) {
    this.sequenceIndex = sequenceIndex;
  }

  public void draw(Graphics graphics) {

    graphics.setColor(color);
    graphics.drawRect(xLocation, yLocation, size, size);
    int startAngle = quadrant * 90;
    int arcX = xLocation - (quadrant % 3 == 0 ? size : 0);
    int arcY = yLocation - (quadrant > 1 ? size : 0);
    graphics.drawArc(arcX, arcY, 2 * size, 2 * size, startAngle, 90);

  }

  public FibonacciSquare copy() {
    return new FibonacciSquare(xLocation, yLocation, color, quadrant, sequenceIndex);
  }

  private void setQuadrant(int quadrant) {
    this.quadrant = quadrant % 4;
  }

}

