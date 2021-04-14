// Jacob Conrad, Practice 5, April 13, 2020, The DrawingPanel class creates a panel that is places in the App/ JFrame. In this class there are airplanes created and actions can happen to them based on a timer, radio buttons, and buttons clicks

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class DrawingPanel extends JPanel implements MouseListener {

	private Airplane leader, follower1, follower2, follower3;
	private AppTimer appTimer;
	private MovementHolder movementHolder;

	// DrawingPanel constructor, does all basic requirements of a panel and includes airplane instances. There is also a mouseClicked method to to check which airplane is being clicked
	public DrawingPanel(MovementHolder movementHolder){
		super();
		this.setSize(1000,900);
		this.setPreferredSize(new Dimension(1000,900));
		this.setBackground(Color.cyan);
		this.movementHolder = movementHolder;
		appTimer = new AppTimer(this, null, movementHolder);
		appTimer.start();
		leader = new Airplane(100,25, getHeight(), getWidth(), movementHolder, 0);
		leader.setColor(Color.green);
		leader.setMovement(2);
		follower1 = new Airplane(100,225, getHeight(), getWidth(), movementHolder, 1);
		follower2 = new Airplane(100,425, getHeight(), getWidth(), movementHolder, 2);
		follower3 = new Airplane(100,625, getHeight(), getWidth(), movementHolder, 3);
	
		this.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (leader.contains(e.getPoint()))
				{
					leader.mouseClicked(e);
					if(leader.getMovement() == 2)
					{
						leader.setLocation(leader.getXLocation()-200, leader.getYLocation());
					}
				}
				if (follower1.contains(e.getPoint()))
				{
					follower1.mouseClicked(e);
				}
				if (follower2.contains(e.getPoint()))
				{
					follower2.mouseClicked(e);
				}
				if (follower3.contains(e.getPoint()))
				{
					follower3.mouseClicked(e);
				}
			}
		});
	}
	
	// Calls the move method of each plane to make the planes fly
	public void move(int dx, int dy) {
		follower1.move(dx, dy, leader, false);
		follower2.move(dx, dy, leader, false);
		follower3.move(dx, dy, leader, false);
		leader.move(dx, dy, leader, true);
		leader.wrapAround();
		follower1.wrapAround();
		follower2.wrapAround();
		follower3.wrapAround();
	}

	// Paints the planes on the DrawingPanel
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D brush = (Graphics2D) g;
		leader.paint(brush);
		follower1.paint(brush);
		follower2.paint(brush);
		follower3.paint(brush);
	}
	
	@Override
	public void mouseEntered(MouseEvent e)
	{
		
	}
	
	@Override
	public void mouseExited(MouseEvent e)
	{
		
	}
	
	@Override
	public void mousePressed(MouseEvent e)
	{
		
	}
	
	@Override
	public void mouseReleased(MouseEvent e)
	{
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	
	}
}
