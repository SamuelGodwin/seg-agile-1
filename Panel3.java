/**
 * 
 */
package section3.view3;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextField;
import main.MainGUI;
import section3.controller3.ButtonListener3;
import somedatamodel.SomeDataClass;

/**
 *  
 * Class description
 * 
 * @author Samuel
 *
 */
public class Panel3 extends JPanel {

	private JScrollPane firstPanelScroll;
	private JLabel titleLabel;
	private JLabel firstNameLabel;
	private JLabel skillLabel;
	private String titleText;
	private SomeDataClass someData;
	private JPanel newTaskContent;
	private JSlider skillSlider;
	private JTextField firstNameField;
	private JButton saveButton;
	private JLabel surnameLabel;
	private JTextField surnameField;
	private JLabel employeeNoLabel;
	private JTextField employeeNoField;
	private MainGUI mainGui;
	private ActionListener buttonController;
	private String invalidString;

	/**
	 * Constructor method for Panel3. Sets fields.
	 * Finally, sets up Panel1 GUI.
	 * 
	 * @param mainGUI 
	 * 
	 * @param someData
	 */
	public Panel3(SomeDataClass someData, MainGUI mainGui) {	
		
		this.someData = someData;
		
		this.mainGui = mainGui;
		
		titleText = "ADD A PERSON<br>";
		this.setLayout(new GridLayout(1,1));
		this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		JPanel secondPanelCenter = new JPanel();
		secondPanelCenter.setLayout(new GridLayout(1,1)); 
						
		this.add(secondPanelCenter, BorderLayout.CENTER);
		
		JPanel containerNewTask = new JPanel();
		containerNewTask.setLayout(new GridBagLayout()); 
		
		newTaskContent = new JPanel();
		newTaskContent.setLayout(new BoxLayout(newTaskContent, BoxLayout.Y_AXIS));
		titleLabel = new JLabel("<html><div style='text-align: center;'>" + titleText + "</div></html>");
		firstNameLabel = new JLabel("<html><div style='text-align: center;'><br>Name (*):</div></html>");
		surnameLabel = new JLabel("<html><div style='text-align: center;'><br>Surname (*):</div></html>");
		employeeNoLabel = new JLabel("<html><div style='text-align: center;'><br>Employee Number (if any):</div></html>");
		skillLabel = new JLabel("<html><div style='text-align: center;'><br>Employee Skill:</div></html>");
		
		saveButton = new JButton("Save");

		buttonController = new ButtonListener3(this, mainGui);
		saveButton.setName("save");
		saveButton.addActionListener(buttonController);
				
		newTaskContent.add(titleLabel);
		newTaskContent.add(firstNameLabel);
		firstNameField = new JTextField();
		newTaskContent.add(firstNameField);
		newTaskContent.add(surnameLabel);
		surnameField = new JTextField();
		newTaskContent.add(surnameField);
		newTaskContent.add(employeeNoLabel);
		employeeNoField = new JTextField();
		newTaskContent.add(employeeNoField);
		newTaskContent.add(skillLabel);
		skillSlider = new JSlider(0, 10);
		newTaskContent.add(skillSlider);
		newTaskContent.add(saveButton);
		
		containerNewTask.add(newTaskContent);
		
		// 'firstPanelScroll' contains 'containerNewTask'.
		firstPanelScroll = new JScrollPane(containerNewTask);
		// 'secondPanelCenter' contains 'firstsPanelScroll'.
		secondPanelCenter.add(firstPanelScroll);

		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		//nameLabel.setHorizontalAlignment(JLabel.CENTER);
		//skillLabel.setHorizontalAlignment(JLabel.CENTER);
		//reqLabel.setHorizontalAlignment(JLabel.CENTER);
		
		this.setVisible(true);

	}

	/**
	 * This method is called only if user tries to enter invalid info.
	 * Sets JLabel to inform the user accordingly.
	 */
	public void invalidSomething() {
		invalidString = "(Please enter a valid name or employee no., etc).";
		// popup dialog box?
	}


}
