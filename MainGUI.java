/**
 * 
 */
package main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import section1.view1.Panel1;
import section2.view2.Panel2;
import section3.view3.Panel3;
import section4.view4.Panel4;
import somedatamodel.SomeDataClass;

/**
 * Class description
 * 
 * @author Samuel
 *
 */
public class MainGUI {

	private JFrame window = new JFrame("SEG Agile Project");
	private JPanel topBar; // topmost bar of application
	private JPanel contentPane; // panel that holds each of our JPanels, i.e. the content
	private JPanel bottomBar; // bottommost bar of application, holds button, textarea
	private JButton newPeopleButton;
	private JButton newTaskButton;
	private JButton dashBoardButton;
	private JLabel bottomText;
	private JButton refreshButton;
	private ArrayList<JPanel> ContentPanels;
	private int panelIndex = 0;
	private MainButtonController buttonController;
	private Panel1 firstPanel;
	private Panel3 thirdPanel;
	private Panel2 secondPanel;
	private Panel4 fourthPanel;
	private JButton helpButton;

	/**
	 * Constructor method for MainGUI. Creates an object of someData.
	 * This method also sets up MainGUI's user interface.
	 * 
	 */
	public MainGUI() {

		SomeDataClass someData = new SomeDataClass();

		firstPanel = new Panel1(someData, this);
		secondPanel = new Panel2(someData, this);
		thirdPanel = new Panel3(someData, this);
		fourthPanel = new Panel4(someData);

		ContentPanels = new ArrayList();

		ContentPanels.add(firstPanel);
		ContentPanels.add(secondPanel);
		ContentPanels.add(thirdPanel);
		ContentPanels.add(fourthPanel);

		window.setSize(1000, 800);
		window.setPreferredSize(new Dimension(1000, 800));
		window.setLayout(new BorderLayout());
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		topBar = new JPanel();
		topBar.setLayout(new FlowLayout(FlowLayout.CENTER));
		window.add(topBar, BorderLayout.NORTH);
		
		dashBoardButton = new JButton("Dashboard");
		topBar.add(dashBoardButton, BorderLayout.WEST);
		
		newTaskButton = new JButton("New Task");
		topBar.add(newTaskButton, BorderLayout.WEST);
		
		newPeopleButton = new JButton("Add People");
		topBar.add(newPeopleButton, BorderLayout.WEST);
	
		refreshButton = new JButton("Refresh");
		topBar.add(refreshButton);

		buttonController = new MainButtonController(this, someData, secondPanel, thirdPanel);
		refreshButton.setName("refresh");
		refreshButton.addActionListener(buttonController);

		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout());

		window.add(contentPane, BorderLayout.CENTER);

		bottomBar = new JPanel();
		bottomBar.setLayout(new BorderLayout());
		window.add(bottomBar, BorderLayout.SOUTH);

		bottomText = new JLabel("SEG AGILE PROJECT TEAM JAY", SwingConstants.CENTER);
		bottomBar.add(bottomText, BorderLayout.CENTER);

		helpButton = new JButton("Help");
		bottomBar.add(helpButton, BorderLayout.EAST);

		contentPane.add(firstPanel);

		helpButton.setName("help");
		helpButton.addActionListener(buttonController);
	
		dashBoardButton.setName("dashboard");
		dashBoardButton.addActionListener(buttonController);
		newPeopleButton.setName("add people");
		newPeopleButton.addActionListener(buttonController);
		newTaskButton.setName("new task");
		newTaskButton.addActionListener(buttonController);
		
		dashBoardButton.setEnabled(false);

		window.pack();
		window.setVisible(true);

	}
	
	/**
	 * 
	 */
	public void enterDashboard() {
			contentPane.remove(ContentPanels.get(panelIndex));
			panelIndex = 0;
			contentPane.repaint();
			contentPane.add(ContentPanels.get(panelIndex));
			contentPane.repaint();
			window.setVisible(true);
			
			dashBoardButton.setEnabled(false);
			newTaskButton.setEnabled(true);
			newPeopleButton.setEnabled(true);
			refreshButton.setEnabled(true);
			
	}
	
	/**
	 * 
	 */
	public void enterNewTask() {
			contentPane.remove(ContentPanels.get(panelIndex));
			panelIndex = 1;
			contentPane.repaint();
			contentPane.add(ContentPanels.get(panelIndex));
			contentPane.repaint();
			window.setVisible(true);
			
			dashBoardButton.setEnabled(true);
			newTaskButton.setEnabled(false);
			newPeopleButton.setEnabled(true);
			refreshButton.setEnabled(false);
	}
	
	/**
	 * 
	 */
	public void enterAddPeople() {
			contentPane.remove(ContentPanels.get(panelIndex));
			panelIndex = 2;
			contentPane.repaint();
			contentPane.add(ContentPanels.get(panelIndex));
			contentPane.repaint();
			window.setVisible(true);
			
			dashBoardButton.setEnabled(true);
			newTaskButton.setEnabled(true);
			newPeopleButton.setEnabled(false);
			refreshButton.setEnabled(false);
	}
	
	/**
	 * 
	 */
	public void enterOther() {
			contentPane.remove(ContentPanels.get(panelIndex));
			panelIndex = 3;
			contentPane.repaint();
			contentPane.add(ContentPanels.get(panelIndex));
			contentPane.repaint();
			window.setVisible(true);
			
			dashBoardButton.setEnabled(true);
			newTaskButton.setEnabled(true);
			newPeopleButton.setEnabled(true);
			refreshButton.setEnabled(true);
	}
	

	/**
	 * Sets size of JFrame window, based on passed parameters x and y.
	 * 
	 * @param x
	 * @param y
	 */
	public void setSize(int x, int y) {
		window.setSize(x, y);
	}

	/**
	 * Sets whether or not JFrame window is resizable, based on boolean passed parameter x.
	 * 
	 * @param x
	 */
	public void setResizeable(boolean x) {
		window.setResizable(x);
	}

	/**
	 * This is an accessor method for firstPanel.
	 * 
	 * @return firstPanel, (instance of Panel1, extends JPanel).
	 */
	public Panel1 getPanel1() {
		return firstPanel;
	}

}
