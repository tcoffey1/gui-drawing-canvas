// Tadhg Coffey	
// 11/14/13  CS111B  Project 3

/*
 * DrawingPanel class sets up a panel and listeners for mouse events. 
 * When the mouse is clicked, drawing can begin by moving the mouse. 
 * When the mouse is clicked again, drawing is de-activated.
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

//primary panel for drawing 
public class DrawingPanel extends JPanel {	
	
	///instance data
	private boolean mouseInMotion;      
	private boolean mouseClicked;
	private ArrayList<PointColor> pointList;  //an Array of objects that hold point location and point color
	private Color colorChoice;
	private PointColor pointColor;     //objects that hold point and color
	private Point pointME;             //the point location from the mouse event
	
	//constructor: set up DrawingPanel and listeners for mouse events
	public DrawingPanel() {
	
		setPreferredSize(new Dimension(600,500));
		setBackground(Color.white);
		
		//create empty arrayList
		pointList = new ArrayList<PointColor>();

		mouseClicked = false;
		mouseInMotion = false;
		
		addMouseListener(new DrawListener());
		addMouseMotionListener(new DrawListener());
	}
	
	//Clears the drawing space and resets the mouse so that the
	//user must click mouse to activate drawing ability again after clearing
	public void clearPoints() {
		pointList.clear();
		repaint();
		mouseClicked = false;
		mouseInMotion = false;
	}

	
	//Drawing in action: When the mouse is moved, drawing occurs in selected color. 
	public void paintComponent(Graphics page) {
		super.paintComponent(page);

		for(PointColor pointColor : pointList) {
			
			if (pointColor.getColor() == Color.red){
				page.setColor(Color.red);
			}
			else if (pointColor.getColor() == Color.yellow){
				page.setColor(Color.yellow);
			}
			else if (pointColor.getColor() == Color.cyan){
				page.setColor(Color.cyan);
			}
			else if (pointColor.getColor() == Color.white){
				page.setColor(Color.white);
			}
			page.fillOval(pointColor.getPoint().x, pointColor.getPoint().y, 20, 20);
		}
	}

	//if mouse is clicked, enable drawing ability
	//disable drawing ability if mouse clicked again
	private class DrawListener implements MouseListener, MouseMotionListener {
		public void mouseClicked(MouseEvent event) {
				
			if(!mouseClicked){  
				mouseInMotion = true;
				mouseClicked = true;
			}else if (mouseClicked){
				mouseInMotion = false; //deactivates drawing ability
				mouseClicked = false;
			}
			repaint();	
		}	
		
		
		//PointColor objects are created with the location from the mouseEvent 
		//and color from DrawingControlPanel 
		public void mouseMoved(MouseEvent event) {
		
			if(mouseInMotion) {
			
				pointME = event.getPoint();
				colorChoice = DrawingControlPanel.getCurrentColor();

				pointColor = new PointColor(pointME, colorChoice);	
				pointList.add(pointColor);
				repaint();
			}
		
		}
		public void mouseDragged(MouseEvent event) {}
		public void mousePressed(MouseEvent event) {}
		public void mouseReleased(MouseEvent event) {}
		public void mouseEntered(MouseEvent event) {}
		public void mouseExited(MouseEvent event) {}
	}
}
