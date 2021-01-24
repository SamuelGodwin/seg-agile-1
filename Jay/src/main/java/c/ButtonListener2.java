
package c;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import m.ListOfTasks;
import m.Task;
import v.Panel2;
import m.SomeDataClass;

/**
 * Class description
 *
 * @author Samuel
 *
 */
public class ButtonListener2 implements ActionListener {

	private Panel2 panel2;
	private MainGUI mainGui;
	private String name;
	private int capacity;
	private ArrayList<Task> requirements;
	private int time;
	private Task task;
	private SomeDataClass someData;

	/**
	 * Constructor for ButtonListener2, Panel2 is a parameter in this constructor
	 * @param panel2
	 */
	public ButtonListener2(Panel2 panel2, MainGUI mainGui , Task task , SomeDataClass someData){
		 this.panel2=panel2;
		 this.mainGui=mainGui;
		 this.someData=someData;
		 this.task=task;
	}

	/**
	 * Method for the action of the button clicked
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		JButton button = (JButton) e.getSource();

		// TODO: check if fields are empty, check if user is sure.
		if(button.getName().equals("save")){

			//System.out.println("Updates databases, returns to dashboard.");

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
				if(!panel2.getRequirements().isEmpty())
				for(Task t : panel2.getRequirements()) {

				}
				//System.out.println(panel2.getTime()  + "  "+ "lol");
				Task theTask = new Task(panel2.getName(), panel2.getCapacity() , panel2.getRequirements() , panel2.getTime() , panel2.getPeople(),  someData);
				task.add_Task(theTask);
				panel2.getEffortSlider().setValue(5);
				panel2.getTheTime().setValue(1);
				panel2.getNameField().setText("");
				panel2.getThePeople().setValue(1);
				//panel2.setTaskIn(task);
			}
			//how to refresh ?

			//PASSES VALUES TO THE FRAME
			//PASSES VALUES TO SOMEDATACLASS
			//PASSES VALUES TO LISTOFTASKS

		}
	}
}
