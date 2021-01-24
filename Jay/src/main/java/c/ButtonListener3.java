
package c;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import m.People;
import m.Task;
import v.Panel3;
import m.SomeDataClass;

/**
 * Class description
 * 
 * @author Samuel
 *
 */
public class ButtonListener3 implements ActionListener {

	private Panel3 panel3;
	private MainGUI mainGui;
	private People people;
	private SomeDataClass someData;
	
	/**
	 * Constructor for ButtonListener3, Panel3 is a parameter in this constructor
	 * @param panel3
	 */
	public ButtonListener3(Panel3 panel3, MainGUI mainGui , People people , SomeDataClass someData){
		 this.panel3=panel3;
		 this.mainGui=mainGui;
		 this.people=people;
		 this.someData = someData;
	}
	
	/**
	 * Method for the action of the button clicked
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
			
		JButton button = (JButton) e.getSource();
		
		// TODO: check if fields are empty, check if user is sure.
		if(button.getName().equals("save")){
			
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
			
			if (showBox == JOptionPane.YES_OPTION) {
				
				People thePeople = new People(panel3.getFirst(), panel3.getSurname() , panel3.getNum() , panel3.getCapacity() , someData);
				people.add_People(thePeople);
				panel3.getFirstNameField().setText("");
				panel3.getSurnameField().setText("");
				panel3.getEmployeeNoField().setText("");
				panel3.getSkillSlider().setValue(5);
			}
			
		}
	}
}