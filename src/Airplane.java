// Jacob Conrad, Practice 5, April 13, 2020, The Airplane class has a constructor to create an airplane, has setlocation and move methods to make the plane fly based on a movement variable, and has setters and getters for various properties

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Airplane {

	private Rectangle body, wings, tail;
	private int x,y, panelHeight, panelWidth, movement, planeNumber;
	private boolean outOfBounds = false;
	private MovementHolder movementHolder;
	
	// Airplane constructor, creates the airplane and sets its location then passes in the panelWidth, panelHeight, planeNumber, movementHolder
	public Airplane(int x, int y, int panelHeight, int panelWidth, MovementHolder movementHolder, int planeNumber)
	{
		body = new Rectangle();
		wings = new Rectangle();
		tail = new Rectangle();
		body.setSize(110, 20);
		wings.setRotation(-45);
		wings.setSize(75, 20);
		tail.setRotation(45);
		tail.setSize(40, 20);
		this.panelHeight = panelHeight;
		this.panelWidth = panelWidth;
		this.planeNumber = planeNumber;
		this.movementHolder = movementHolder;
		setLocation(x, y);
	}
	
	// Sets the location of the wings, body, and tail and initializes the x and y variables
	public void setLocation(int x, int y)
	{
		this.x = x;
		this.y = y;
		body.setLocation(x + 25, y + 11);
		wings.setLocation(x + 45, y + 11);
		tail.setLocation(x, y);
	}
	
	// When the mouse is clicked on the airplane the movement of airplane is set to the movementHolder value
	public void mouseClicked(MouseEvent e)
	{
		movement = movementHolder.getMovement();
	}
	
	public void setMovement(int movement)
	{
		this.movement = movement;
	}
	
	public int getMovement()
	{
		return movement;
	}
	
	// If movement = 1 the logic for random movement is run, if movement = 2 the logic for follow the leader is run, if movement = 3/ anything else the logic for do nothing is run
	public void move(int dx, int dy, Airplane leader, Boolean isLeader) {

		if (movement == 1) {
			Random rand = new Random();
			int randX = rand.nextInt(15);
			int randY = rand.nextInt(15);
			int randomXSign = rand.nextInt(2);
			int randomYSign = rand.nextInt(2);

			if (randomXSign == 0) {
				randX *= -1;
			}
			if (randomYSign == 0) {
				randY *= -1;
			}
			setLocation(randX + getXLocation(), randY + getYLocation());
		}
		else if (movement == 2) { 
			if (isLeader == true)
			{
				setLocation(leader.getXLocation() + dx, leader.getYLocation() + dy);
			}
			else
			{
				if((leader.getXLocation() >= panelWidth || leader.getXLocation() < getXLocation()) && leader.movement == 2)
				{
					setLocation(getXLocation() + dx, getYLocation() + dy);
				}
				else
				{
					setLocation(leader.getXLocation() - planeNumber * 200 + dx, leader.getYLocation() + dy);
				}
			}
		}
		else
		{
			// nothing	
		}
	}
	
	// Checks if the airplane contains a point
	public boolean contains(Point p)
	{
		return (body.contains(p) || wings.contains(p) || tail.contains(p));
	}
	
	public int getXLocation()
	{
		return x;
	}
	
	public int getYLocation()
	{
		return y;
	}
	
	public int getWidth()
	{
		return (tail.getWidth() / 2) + body.getWidth();
	}
	
	public int getHeight()
	{
		return wings.getHeight();
	}
	
	// Wrap around method, when the plane goes through the border of the frame it wraps around to the other side
	public void wrapAround()
	{
		if(getXLocation() > 0 && getXLocation() < panelWidth)
		{
			outOfBounds = false;
		}
		if(getYLocation() > 0 && getYLocation() < panelHeight)
		{
			outOfBounds = false;
		}
		
		if(getXLocation() >= panelWidth && outOfBounds == false)
		{
			setLocation(0-getWidth(), y);
			outOfBounds =  true;
		}
		
		if(getXLocation()+getWidth() <= 0 && outOfBounds == false)
		{
			setLocation(panelWidth, y);
			outOfBounds =  true;
		}
		
		if(getYLocation() >= panelHeight && outOfBounds == false)
		{
			setLocation(x, 0-getHeight());
			outOfBounds =  true;
		}
		
		if(getYLocation()+getHeight() <= 0 && outOfBounds == false)
		{
			setLocation(x, panelHeight);
			outOfBounds =  true;
		}
	}
	
	public void setColor(Color color)
	{
		body.setColor(color);
		wings.setColor(color);
		tail.setColor(color);
	}
	
	// Paints the body, wings, and tail
	public void paint(Graphics2D brush){
		body.paint(brush);
		wings.paint(brush);
		tail.paint(brush);
	}
}
