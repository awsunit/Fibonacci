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
		
		// Create 10 shapes
		model.addShape(new HShape(100,100,Color.CYAN,180));
		model.addShape(new HShape(300,300,Color.CYAN,360));
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




