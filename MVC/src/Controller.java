import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;

public class Controller implements ActionListener, MouseListener {

  private DrawingModel model;
  private boolean addLevel = true;

  // Connect controller and model (in the constructor)
  public Controller(DrawingModel model) {
    this.model = model;
  }

  @Override
  public void mousePressed(MouseEvent e) {
    if (addLevel) {
      boolean success = model.addLevel(e.getX(), e.getY());

      if (!success) {
        // display a message box stating that no more level can be added
        // look at JOptionePane.showMessageDialog
        JOptionPane.showMessageDialog(null, "No more levels may be added.");

      }
    } else {
      boolean success = model.removeLevel(e.getX(), e.getY());
      if (!success) {
        // display a message stating that no more level can be removed
        JOptionPane.showMessageDialog(null, "No more levels to remove.");
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
      model.reset();
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