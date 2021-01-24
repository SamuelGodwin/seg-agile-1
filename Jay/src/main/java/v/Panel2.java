/**
 *
 */
package v;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import c.ButtonListener2;
import c.MainGUI;
import m.ListOfTasks;
//import c.SliderListener;
//import m.Slider;
import m.SomeDataClass;
import m.Task;

/**
 *
 * Class description
 *
 * @author Samuel
 *
 */
@SuppressWarnings("deprecation")
public class Panel2 extends JPanel implements Observer{

	private static final long serialVersionUID = 1L;
	private JScrollPane firstPanelScroll;
	private JLabel titleLabel;
	private JLabel nameLabel;
	private JLabel effortLabel;
	private JLabel checkLabel;
	private JLabel reqLabel;
	private String titleText;
	private JPanel newTaskContent;
	private JSlider effortSlider;
	private JTextField nameField;
	private JSpinner amountOfPerson;
	private JLabel peopleToAdd;

	public JSlider getEffortSlider() {
		return effortSlider;
	}

	public JTextField getNameField() {
		return nameField;
	}

	public JSpinner getTheTime() {
		return theTime;
	}

	public JSpinner getThePeople() {
		return amountOfPerson;
	}

	public void setTheTime(JSpinner theTime) {
		this.theTime = theTime;
	}

	private JButton plusButton;
	private JButton saveButton;
	private ActionListener buttonController;
	private MainGUI mainGui;
	private String invalidString;
	private SomeDataClass someData;
	private JComboBox<Task> tasksTo;
	private Task tasks;
	private ListOfTasks taskIn;
	private String nameContent="";
	private int effortContent=5;
	private JSpinner theTime;
	private JLabel selectTime;
	private int timeContent=1;
	private int amountToAdd=1;
	private JCheckBox check;
	private ArrayList<Task> checkboxes;
	private JLabel noLabel;
	private ArrayList<Task> theArray = new ArrayList<Task>();
	private ArrayList<JCheckBox> boxes = new ArrayList<JCheckBox>();

	/**
	 * Constructor method for Panel2. Sets someData field of this class as a
	 * reference to the object someData passed as a parameter.
	 * Finally, sets up Panel1 GUI.
	 *
	 * @param someData
	 */
	public Panel2(SomeDataClass someData, MainGUI mainGui) {
		ArrayList<Task> checkboxes = new ArrayList<Task>();
		tasks = new Task(nameContent , effortContent , checkboxes , timeContent , amountToAdd , someData);
		this.someData = someData;
		this.mainGui = mainGui;
		tasks.addObserver(this);
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
		selectTime = new JLabel("<html><div style='text-align: center;'><br>Select an amount of Hours:</div></html>");
		checkLabel = new JLabel("<html><div style='text-align: center;'><br>Select a prerequisite(*):</div></html>");
		noLabel = new JLabel("<html><div style='text-align: center;'><br>No prerequisite for the moment :</div></html>");
		saveButton = new JButton("Save");

		saveButton.setEnabled(false);
		newTaskContent.add(titleLabel);
		newTaskContent.add(nameLabel);
		nameField = new JTextField();
		nameField.setName("nameField");
		newTaskContent.add(nameField);
		SpinnerModel value = new SpinnerNumberModel(1,1,1000,1);
		amountOfPerson = new JSpinner(value);
		amountOfPerson.addChangeListener(new ChangeListener(){
			public void stateChanged(ChangeEvent e) {
	         amountToAdd = (int) ((JSpinner)e.getSource()).getValue();
	        }});
		SpinnerModel values = new SpinnerNumberModel(1,1,1000,1);
		theTime = new JSpinner(values);
		theTime.setName("setTime");
		theTime.addChangeListener(new ChangeListener() {
	        public void stateChanged(ChangeEvent e) {
	         timeContent = (int) ((JSpinner)e.getSource()).getValue();
	        }});

	    newTaskContent.add(selectTime);
		newTaskContent.add(theTime);
		nameField.addKeyListener((KeyListener) new KeyAdapter() {
	        public void keyReleased(KeyEvent e) {
	                if(isString(nameField.getText())==false || nameField.getText().isEmpty()) {
	                	saveButton.setEnabled(false);
	                }else {
	                	saveButton.setEnabled(true);
	                }
	        }
		});
		effortSlider = new JSlider(1, 10);
		effortSlider.setName("effortSlider");
		effortSlider.addChangeListener(new ChangeListener() {
		      public void stateChanged(ChangeEvent event) {
		    	  effortContent = effortSlider.getValue();

		      }
		    });
		effortSlider.setMajorTickSpacing(1);
		effortSlider.setPaintTicks(true);
		effortSlider.setPaintLabels(true);

		newTaskContent.add(effortSlider);
		newTaskContent.add(amountOfPerson);
		saveButton.setName("save");

		buttonController = new ButtonListener2(this, mainGui , tasks , someData);

		saveButton.addActionListener(buttonController);

		newTaskContent.add(saveButton);

		containerNewTask.add(newTaskContent);
		// 'firstPanelScroll' contains 'containerNewTask'.
		firstPanelScroll = new JScrollPane(containerNewTask);
		secondPanelCenter.add(firstPanelScroll);

		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		this.setVisible(true);

	}

	@Override
	public void update(Observable arg0, Object arg1) {
		if(!boxes.isEmpty()) {
			for(JCheckBox myBox : boxes) {

				newTaskContent.remove(myBox);

			}
			boxes.clear();
		}
		saveButton.setEnabled(false);
		theArray = tasks.getTasks();
		checkboxes = new ArrayList<Task>();
		if(!theArray.isEmpty()) {
			newTaskContent.add(checkLabel);
			for(Task element : theArray) {
				final JCheckBox box = new JCheckBox(element.getName() , false);
				boxes.add(box);
				box.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent actionEvent) {
				        if(box.isSelected()) {
				        	String theBox = box.getText();
				        	for(Task toadd : theArray) {
				        		if(toadd.getName().equals(theBox)) {
				        			checkboxes.add(toadd);
				        			tasks.setRequirements(checkboxes);
				        		}
				        	}
				        }else {
				        	String theBox = box.getText();
				        	for(Task toadd : theArray) {
				        		if(toadd.getName().equals(theBox)) {
				        			checkboxes.remove(toadd);
				        			tasks.setRequirements(checkboxes);
				        		}
				        	}
				        }
					}});
			    newTaskContent.add(box);
			}
		}else {
			newTaskContent.add(noLabel);
		}
		newTaskContent.remove(saveButton);
		newTaskContent.add(saveButton);
		revalidate();
		repaint();
		//make the save move down
		//check if it has the same name and change the label
		//solve the problem of adding too much boxes
	}

	public boolean isString(String s){
    	boolean hasNoNum=false;
		if(s != null){
        	for(int i = 0; i < s.length(); i++){
            	if(!Character.isDigit(s.charAt(i))){
                	 hasNoNum = true;
            	}else {
            		return false;
            	}
        	}
    	}
        return hasNoNum;
	}

	public String getName() {
		return nameField.getText();
	}

	public int getTime() {
		return timeContent;
	}

	public int getCapacity() {
		return effortContent;
	}

	public ArrayList<Task> getRequirements(){
		if(checkboxes == null) {
			checkboxes = new ArrayList<Task>();
			return checkboxes;
		}
		return checkboxes;
	}

	public Task getTask(){
		return tasks;
	}

	public int getPeople(){
		return amountToAdd;
	}

	}
