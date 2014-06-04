// Tadhg Coffey	
// 11/14/13  CS111B  Project 3

/*
 * This program allows the user to draw using a mouse. 
 * Colors are chosen via radio buttons.
 * The user can clear the canvas via clear button.
 * 
 * DrawingControlPanel class sets up the ControlPanel with radio buttons to choose color 
 * and a JButton to clear the drawingPanel. Listeners are used to store the users choice.
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DrawingControlPanel extends JPanel {
	
	//instance data
	private DrawingPanel drawingPanel;
	private JButton clearButton;
	private JRadioButton redRadio, yellowRadio, cyanRadio, eraserRadio;
	protected static Color currentColor = Color.red;      //current chosen RadioButton indicates current color 

	//Constructor: sets up the DrawingControlPanel with various buttons to choose color and clear drawing
	public DrawingControlPanel(DrawingPanel drawingPanel) {
		this.drawingPanel = drawingPanel;   
		
		setPreferredSize(new Dimension(600,38));
		setBackground(Color.lightGray);
		
		redRadio = new JRadioButton("red", true);     //set red as default selection
		redRadio.addActionListener(new ColorSelectionListener());
		redRadio.setBackground(Color.red);
		
		yellowRadio = new JRadioButton("yellow");
		yellowRadio.addActionListener(new ColorSelectionListener());
		yellowRadio.setBackground(Color.yellow);
		
		cyanRadio = new JRadioButton("cyan");
		cyanRadio.addActionListener(new ColorSelectionListener());		
		cyanRadio.setBackground(Color.cyan);
		
		eraserRadio = new JRadioButton("Eraser");
		eraserRadio.addActionListener(new ColorSelectionListener());	
		eraserRadio.setBackground(Color.white);
		
		clearButton = new JButton("Clear Drawing");
		clearButton.addActionListener(new ClearButtonListener());		
		
		//ButtonGroup only allows 1 radioButtton to be active at a time 
		ButtonGroup group = new ButtonGroup();
		group.add(redRadio);
		group.add(yellowRadio);
		group.add(cyanRadio);
		group.add(eraserRadio);

		add(redRadio);
		add(yellowRadio);
		add(cyanRadio);
		add(eraserRadio);
		add(clearButton);       
	}
	
	//when the user clicks a Clear Button, all drawn items are erased
	public class ClearButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			drawingPanel.clearPoints();
		}
	}
	
	// when the user clicks a JRadioButton, change color accordingly
	public class ColorSelectionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource()==redRadio) {
				currentColor = Color.red;
			}else if(e.getSource()==yellowRadio) {
				currentColor = Color.yellow;
			}else if(e.getSource()==cyanRadio) {
				currentColor = Color.cyan;
			}else if(e.getSource()==eraserRadio) {
				currentColor = Color.white;
			}
		}                         
	}
	
	//Getter: for other classes to get the currentColor chosen by user
	public static Color getCurrentColor(){
		return currentColor;
	}

}