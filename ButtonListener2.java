
package section2.controller2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import main.MainGUI;
import section2.view2.Panel2;

/**
 * Class description
 * 
 * @author Samuel
 *
 */
public class ButtonListener2 implements ActionListener {

	private Panel2 panel2;
	private MainGUI mainGui;
	
	/**
	 * Constructor for ButtonListener2, Panel2 is a parameter in this constructor
	 * @param panel2
	 */
	public ButtonListener2(Panel2 panel2, MainGUI mainGui){
		 this.panel2=panel2;
		 this.mainGui=mainGui;
	}
	
	/**
	 * Method for the action of the button clicked 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
			
		JButton button = (JButton) e.getSource();
		
		// TODO: check if fields are empty, check if user is sure.
		if(button.getName().equals("save")){
			
			System.out.println("Updates databases, returns to dashboard.");

			Object[] options = {"Yee",
            "Cancel"};
			
			int showBox = JOptionPane.showOptionDialog(null,
			"Are you sure? Check first!",
			"A Silly Question",
			JOptionPane.YES_NO_OPTION,
			JOptionPane.QUESTION_MESSAGE,
			null,     //do not use a custom Icon
			options,  //the titles of buttons
			options[1]); //default button title
			
		}	
	}
}