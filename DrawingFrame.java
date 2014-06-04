// Tadhg Coffey	
// 11/14/13  CS111B  Project 3

/*
 * This program allows the user to draw using a mouse.  
 * Colors are chosen via radio buttons.
 * The user can clear the canvas via clear button.
 * 
 * DrawingFrame class sets up a frame, drawing panel 
 * and control panel.
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DrawingFrame extends JFrame { 

	private Container contentPane; 
	private DrawingPanel drawingPanel;
	private DrawingControlPanel drawingControlPanel;
		
	//Sets up a drawingFrame (called and created from Main)
	public DrawingFrame() {
		super("Canvas");
		setSize(800, 600);
		contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());
		contentPane.setBackground(Color.darkGray);

		drawingPanel = new DrawingPanel();
		drawingControlPanel = new DrawingControlPanel(drawingPanel);
	
		contentPane.add(drawingPanel);
		contentPane.add(drawingControlPanel);
	
		setVisible(true);
	}
	

	//creates a new Drawing Frame
	public static void main(String args[]) {
		DrawingFrame frame = new DrawingFrame();
	    frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
	}


}
