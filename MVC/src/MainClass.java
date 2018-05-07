import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class MainClass {
	public static void main(String[] args) {
		// instantiate an anonymous class that implements
		// Runnable
		// new Runnable() { // override of run }
		/*
		 * SwingUtilities.invokeLater(new Runnable() {
		 * 
		 * @Override public void run() { createGUI(); } });
		 */

		// Shorter version of the same code
		// using lambda notation
		SwingUtilities.invokeLater(() -> createGUI());
	}

	public static void createGUI() {
		JFrame frame = new JFrame("H's and Fibonacci squares");
		frame.setSize(1000, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// What goes in the frame
		Viewer v = new Viewer();
		frame.add(v);

		// Connect the view to a model
		DrawingModel model = new DrawingModel();
		model.addView(v);

		// Show it (execute this line last)
		frame.setVisible(true);
		
		//Adding HShapes
		model.addShape(new HShape(100,100,Color.CYAN,180));
		model.addShape(new HShape(300,300,Color.CYAN,360));
	
		//this HShape has nested HShapes
		HShape frog = new HShape(200,50,Color.DARK_GRAY,270);
		model.addShape(frog);
		for(int i = 0; i < 7;i++) {
			frog.addInnerH(frog.getX(), frog.getY(), frog.getColor(), frog.getSize());
			
		}
		for(int i = 0; i < 7; i ++) {
			model.addShape(frog.getInnerH(i));
		}
	
		
		
		
		model.addShape(new FibonacciSquare(400,100,Color.BLACK,180, 1));
		model.addShape(new FibonacciSquare(600,200,Color.BLACK,240, 2));
		model.addShape(new FibonacciSquare(800,400,Color.RED,180, 3));
		model.addShape(new FibonacciSquare(500,500,Color.YELLOW,360, 4));
		
		
		
		
//		for(int i = 1; i <= 10; i ++) {
//			model.addShape(new HShape(300,300,Color.CYAN,360));
////			if (Math.random() >= 0.5) {
////				model.addShape(new HShape());
////			} else {
////				model.addShape(new FibonacciSquare());
////			}
//		}
		
		
	}
}




