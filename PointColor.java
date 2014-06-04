// Tadhg Coffey	
// 11/14/13  CS111B  Project 3

/*
 * PointColor class sets up a point object that hold both its location and color 
 */

import java.awt.*;

//Point objects with location and color
public class PointColor{

	private Color color;        
	private Point point;       
		
	//Constructor: sets up a new point location object w/ color 
	public PointColor(Point pointME, Color colorChoice) {
		point = pointME;
		color = colorChoice;
	}
	
	//Setters:
	public void setPoint(Point pointME){
		point = pointME;
	}	
	public void setColor(Color ColorChoice){
		color = ColorChoice;
	}

	
	//Getters:
	public Color getColor(){
		return color;
	}
	public Point getPoint(){
		return point;
	}

}
