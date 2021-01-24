/**
 * 
 */
package section4.view4;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import somedatamodel.SomeDataClass;

/**
 *  
 * Class description
 * 
 * @author Samuel
 *
 */
public class Panel4 extends JPanel {

	private JScrollPane firstPanelScroll;
	private JLabel titleLabel;
	private String titleText;
	private JPanel newTaskContent;
	private String instructionsText;
	private JLabel instructionsLabel;

	/**
	 * Constructor method for Panel4. Sets fields.
	 * Finally, sets up Panel4 GUI.
	 * 
	 * @param someData
	 */
	public Panel4(SomeDataClass someData) {	
				
		titleText = "Instructions<br>";
		instructionsText = "<br>Instructions instructions instructions<br>instructions instructions.";

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
		instructionsLabel = new JLabel("<html><div style='text-align: center;'>" + instructionsText + "</div></html>");		
		
		newTaskContent.add(titleLabel);
		newTaskContent.add(instructionsLabel);
		
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
}
