
package section1.controller1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import main.MainGUI;
import section1.view1.Panel1;

/**
 * Class description
 * 
 * @author Samuel
 *
 */
public class ButtonListener1 implements ActionListener {

	private Panel1 panel1;
	private MainGUI mainGui; // not sure if this properly follows mvc at the moment
	
	/**
	 * Constructor for ButtonListener1, Panel1 is a parameter in this constructor
	 * @param panel1
	 */
	public ButtonListener1(Panel1 panel1, MainGUI mainGui){
		 this.panel1=panel1;	
		 this.mainGui=mainGui;
	}
	
	/**
	 * Method description
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
	
		JButton button = (JButton) e.getSource();
		
		if(button.getName().equals("add new task")){
			
			mainGui.enterNewTask();
			
		}
	}
}