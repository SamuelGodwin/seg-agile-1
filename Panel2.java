/**
 * 
 */
package section2.view2;

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
import section2.controller2.ButtonListener2;
import somedatamodel.SomeDataClass;

/**
 *  
 * Class description
 * 
 * @author Samuel
 *
 */
public class Panel2 extends JPanel {

	private JScrollPane firstPanelScroll;
	private JLabel titleLabel;
	private JLabel nameLabel;
	private JLabel effortLabel;
	private JLabel reqLabel;
	private String titleText;
	private JPanel newTaskContent;	
	private JSlider effortSlider;
	private JTextField nameField;
	private JButton plusButton;
	private JButton saveButton;
	private ActionListener buttonController;
	private MainGUI mainGui;
	private String invalidString;
	private SomeDataClass someData;

	/**
	 * Constructor method for Panel2. Sets someData field of this class as a
	 * reference to the object someData passed as a parameter.
	 * Finally, sets up Panel1 GUI.
	 * 
	 * @param someData
	 */
	public Panel2(SomeDataClass someData, MainGUI mainGui) {	
		
		this.someData = someData;
		this.mainGui = mainGui;
		
		titleText = "NEW TASK<br>";
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
		nameLabel = new JLabel("<html><div style='text-align: center;'><br>Task Name:</div></html>");
		effortLabel = new JLabel("<html><div style='text-align: center;'><br>Task Effort:</div></html>");
		reqLabel = new JLabel("<html><div style='text-align: center;'><br>Task Requirements:</div></html>");
		
		saveButton = new JButton("Save");

		buttonController = new ButtonListener2(this, mainGui);
		saveButton.setName("save");
		saveButton.addActionListener(buttonController);
				
		newTaskContent.add(titleLabel);
		newTaskContent.add(nameLabel);
		nameField = new JTextField();
		newTaskContent.add(nameField);
		newTaskContent.add(effortLabel);
		effortSlider = new JSlider(0, 10);
		newTaskContent.add(effortSlider);
		newTaskContent.add(reqLabel);
		plusButton = new JButton("+");
		newTaskContent.add(plusButton);
		newTaskContent.add(saveButton);
		
		containerNewTask.add(newTaskContent);
		
		// 'firstPanelScroll' contains 'containerNewTask'.
		firstPanelScroll = new JScrollPane(containerNewTask);
		// 'secondPanelCenter' contains 'firstsPanelScroll'.
		secondPanelCenter.add(firstPanelScroll);

		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		//nameLabel.setHorizontalAlignment(JLabel.CENTER);
		//effortLabel.setHorizontalAlignment(JLabel.CENTER);
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
