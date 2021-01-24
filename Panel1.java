/**
 * 
 */
package section1.view1;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import main.MainGUI;
import section1.controller1.ButtonListener1;
import somedatamodel.SomeDataClass;

/**
 *  
 * Class description
 * 
 * @author Samuel
 *
 */
public class Panel1 extends JPanel {

	private JScrollPane firstPanelScroll;
	private JList<String> listOfTasks;
	private JButton newTaskButton;
	private JLabel label;
	private JLabel label2;
	private String titleText;
	private SomeDataClass someData;
	private JPanel containsLabels;
	private ButtonListener1 buttonController;
	private MainGUI mainGui;

	/**
	 * Constructor method for Panel1. Sets fields of this class to object references
	 * passed as a parameters.
	 * Finally, sets up Panel1 GUI.
	 * 
	 * @param someData, mainGui
	 */
	public Panel1(SomeDataClass someData, MainGUI mainGui) {	
		
		this.someData = someData;
		this.mainGui = mainGui;
		
		titleText = "DASHBOARD<br>";
		this.setLayout(new GridLayout(1,1));
		this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		JPanel firstPanelCenter = new JPanel();
		firstPanelCenter.setLayout(new GridLayout(1,1)); 
						
		this.add(firstPanelCenter, BorderLayout.CENTER);
		
		JPanel containsLabelContainer = new JPanel();
		containsLabelContainer.setLayout(new GridBagLayout()); 
		containsLabels = new JPanel();
		containsLabels.setLayout(new BoxLayout(containsLabels, BoxLayout.Y_AXIS));

		label = new JLabel("<html><div style='text-align: center;'>" + titleText + "</div></html>");
		
		listOfTasks = new JList<String>(someData.getSomeArray());
		containsLabels.add(label);
		newTaskButton = new JButton("Add New Task");
		
		buttonController = new ButtonListener1(this, mainGui);
		newTaskButton.setName("add new task");
		newTaskButton.addActionListener(buttonController);
		
		containsLabels.add(listOfTasks);
		containsLabels.add(newTaskButton);

		containsLabelContainer.add(containsLabels);
		
		// 'firstPanelScroll' contains 'containsLabelContainer'.
		firstPanelScroll = new JScrollPane(containsLabelContainer);
		// 'firstPanelCenter' contains 'firstsPanelScroll'.
		firstPanelCenter.add(firstPanelScroll);

		label.setHorizontalAlignment(JLabel.CENTER);
		
		this.setVisible(true);

	}
}
