import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
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

//		FibonacciVal val = new FibonacciVal();
//		System.out.println(val.FibonnaciNum(6));
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

		// Buttons
		JRadioButton add = new JRadioButton("Add");
		JRadioButton remove = new JRadioButton("Remove");
		JRadioButton reset = new JRadioButton("Reset");
		JRadioButton addShape = new JRadioButton("Shape");

		// Panel for the buttons
		JPanel buttPan = new JPanel();
		buttPan.add(add);
		buttPan.add(remove);
		buttPan.add(reset);
		buttPan.add(addShape);

		// Connect panel to frame
		frame.add(buttPan, BorderLayout.NORTH);

		// ButtonGroup
		ButtonGroup buttGroup = new ButtonGroup();
		buttGroup.add(add);
		buttGroup.add(remove);
		add.setSelected(true);

		// Controller setup
		Controller controller = new Controller(model);

		// Connect buttons with controller
		add.addActionListener(controller);
		remove.addActionListener(controller);
		reset.addActionListener(controller);
		addShape.addActionListener(controller);

		// connect mouselistener
		v.addMouseListener(controller);

		// Show it (execute this line last)
		frame.setVisible(true);

		// Adding HShapes
		// model.addShape(new HShape(800, 100, Color.CYAN, 180));
		// model.addShape(new HShape(300,300,Color.CYAN,360));
		//
		// model.shapes.get(0).addLevel();
		
		
		
		

		// this HShape has nested HShapes
		HShape frog = new HShape(200, 100, Color.YELLOW, 270);
		model.addShape(frog);
		
	
		
		
		 // adding fibsqrs
//		 model.addShape(new FibonacciSquare(500, 100, Color.GREEN, 1, 10));
//		 model.addShape(new FibonacciSquare(600, 200, Color.BLUE, 2, 12));
//		 model.addShape(new FibonacciSquare(130, 300, Color.RED, 3, 15));
//		 model.addShape(new FibonacciSquare(500, 500, Color.PINK, 4, 11));
		
		 

	}
}
