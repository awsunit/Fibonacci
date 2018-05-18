import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Controller implements ActionListener, MouseListener{
	
	private boolean addLevel;
	private DrawingModel model;
	
	public Controller(DrawingModel m) {
		this.model = m;
	}
	
	
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().contains("Add")) {
			addLevel = true;
			System.out.println(addLevel);
		}
		else if(e.getActionCommand().contains("Remove")) {
			addLevel = false;
			System.out.println(addLevel);
		}
		else if(e.getActionCommand().contains("Reset")) {
			//all nested arrays become null
		}
	}
	
	
	
	
	
	
	

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	

}
