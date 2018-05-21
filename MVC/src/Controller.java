import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Controller implements ActionListener, MouseListener {

  private DrawingModel model;
  private boolean addLevel = true;

  // Connect controller and model (in the constructor)
  public Controller(DrawingModel model) {
    this.model = model;
  }

  @Override
  public void mousePressed(MouseEvent e) {
    System.out.printf("(x,y)=(%d,%d)\n", e.getX(), e.getY());
    if (addLevel) {
      boolean success = model.addLevel(e.getX(), e.getY());
      if (!success) {
        // display a message box stating that no more level can be added
        // look at JOptionePane.showMessageDialog
      }
    } else {
      boolean success = model.removeLevel(e.getX(), e.getY());
      if (!success) {
        // display a message stating that no more level can be removed
      }
    }

  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getActionCommand().contains("Add")) {
      addLevel = true;
    } else if (e.getActionCommand().contains("Remove")) {
      addLevel = false;
    } else {
      // has to be reset
    }
  }

  // Not used
  @Override
  public void mouseClicked(MouseEvent e) {
  }

  @Override
  public void mouseEntered(MouseEvent e) {
    // TODO Auto-generated method stub

  }

  @Override
  public void mouseExited(MouseEvent e) {
    // TODO Auto-generated method stub

  }

  @Override
  public void mouseReleased(MouseEvent e) {
    // TODO Auto-generated method stub

  }
}