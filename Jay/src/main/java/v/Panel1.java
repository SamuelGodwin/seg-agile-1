/**
 * 
 */
package v;

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

import c.ButtonListener1;
import c.MainGUI;
import m.ListOfTasks;
import m.SomeDataClass;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map;
//import java.util.TreeMap.Entry;
import m.Task;
import java.util.ArrayList;
import m.People;

/**
 *  
 * Class description
 * 
 * @author Samuel
 *
 */
public class Panel1 extends JPanel implements Observer{

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
	private ListOfTasks taskIn;

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
		this.someData.addObserver(this);
		
		
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
		
		listOfTasks = new JList<String>(someData.getStrings());
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

	@Override
	public void update(Observable arg0, Object arg1) {
		//System.out.println(someData.getStrings()[0]);
		listOfTasks.setListData(someData.getStrings());
		//System.out.println(listOfTasks.get(0));
		someData.calculations();
	 	if(!someData.calculations().isEmpty()){
	 		System.out.println("it goes there lol");
	 		for(Map.Entry<Task , ArrayList<People>> entry : someData.calculations().entrySet()){
	 			System.out.println("Task name " + entry.getKey().getStartTime());
	 		}
	 	}
	}
}