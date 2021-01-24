
package section3.controller3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import main.MainGUI;
import section3.view3.Panel3;

/**
 * Class description
 * 
 * @author Samuel
 *
 */
public class ButtonListener3 implements ActionListener {

	private Panel3 panel3;
	private MainGUI mainGui;
	
	/**
	 * Constructor for ButtonListener3, Panel3 is a parameter in this constructor
	 * @param panel3
	 */
	public ButtonListener3(Panel3 panel3, MainGUI mainGui){
		 this.panel3=panel3;
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