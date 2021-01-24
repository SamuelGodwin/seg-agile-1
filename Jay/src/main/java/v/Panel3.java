package v;

/**
 * 
 */


import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import c.ButtonListener3;
import c.MainGUI;
import m.People;
import m.SomeDataClass;

/**
 *  
 * Class description
 * 
 * @author Samuel
 *
 */
public class Panel3 extends JPanel implements Observer {

	
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
	private boolean name1=false;
	private boolean name2=false;
	private int capacity=5;
	private String firstName = "";
	private String surname = "";
	private String employeeNum = "";
	private People people;

	public JSlider getSkillSlider() {
		return skillSlider;
	}


	public JTextField getEmployeeNoField() {
		return employeeNoField;
	}


	/**
	 * Constructor method for Panel3. Sets fields.
	 * Finally, sets up Panel1 GUI.
	 * 
	 * @param mainGUI 
	 * 
	 * @param someData
	 */
	public Panel3(SomeDataClass someData, MainGUI mainGui) {	
		people = new People(firstName , surname , employeeNum , capacity , someData);
		people.addObserver(this);
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
		saveButton.setEnabled(false);
		buttonController = new ButtonListener3(this, mainGui , people , someData);
		saveButton.setName("save");
		saveButton.addActionListener(buttonController);
		
		
		
		newTaskContent.add(titleLabel);
		newTaskContent.add(firstNameLabel);
		firstNameField = new JTextField();
		newTaskContent.add(firstNameField);
		firstNameField.addKeyListener((KeyListener) new KeyAdapter() {
	        public void keyReleased(KeyEvent e) {
	                if(isString(firstNameField.getText())==false || firstNameField.getText().isEmpty()) {
	                	name1=false;
	                	isItCorrect();
	                	//System.out.println(isItCorrect);
	                }else {
	                	name1=true;
	                	//System.out.println(isItCorrect);
	                	isItCorrect();
	                }
	        }
		});
		newTaskContent.add(surnameLabel);
		surnameField = new JTextField();
		surnameField.addKeyListener((KeyListener) new KeyAdapter() {
	        public void keyReleased(KeyEvent e) {
	                if(isString(surnameField.getText())==false || surnameField.getText().isEmpty()) {
	                	name2=false;
	                	isItCorrect();
	                }else {
	                	name2=true;
	                	isItCorrect();
	                }
	        }
		});
		newTaskContent.add(surnameField);
		newTaskContent.add(employeeNoLabel);
		employeeNoField = new JTextField();
		surnameField.addKeyListener((KeyListener) new KeyAdapter() {
	        public void keyReleased(KeyEvent e) {
	                
	        }
		});
		newTaskContent.add(employeeNoField);
		newTaskContent.add(skillLabel);
		skillSlider = new JSlider(1, 10);
		skillSlider.addChangeListener(new ChangeListener() {
		      public void stateChanged(ChangeEvent event) {
		    	  capacity = skillSlider.getValue();  
		    	
		      }
		    });
		skillSlider.setMajorTickSpacing(1);
		skillSlider.setPaintTicks(true);
		skillSlider.setPaintLabels(true);
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

	public JTextField getFirstNameField() {
		return firstNameField;
	}

	public JTextField getSurnameField() {
		return surnameField;
	}


	/**
	 * This method is called only if user tries to enter invalid info.
	 * Sets JLabel to inform the user accordingly.
	 */

	
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
	
	public void isItCorrect() {
		if(name1==true && name2==true) {
			saveButton.setEnabled(true);
		}else {
			saveButton.setEnabled(false);
		}
	}
	
	public String getFirst() {
		return firstNameField.getText();
	}
	
	public String getSurname() {
		return surnameField.getText();
	}
	
	public String getNum() {
		return employeeNoField.getText();
	}
	
	public int getCapacity() {
		return capacity;
	}


	@Override
	public void update(Observable arg0, Object arg1) {
		saveButton.setEnabled(false);
		name1= false;
		name2=false;
		revalidate();
		repaint();
	}
	
	


}
