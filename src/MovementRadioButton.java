// Jacob Conrad, Practice 5, April 13, 2020, The MovementRadioButton class extends JRadioButton which includes a label, movement, MovementHolder, MovementListener class, and adds the button to a button group

import javax.swing.*;
import java.awt.event.*;

public class MovementRadioButton extends JRadioButton
{
	private int movement;
	private MovementHolder movementHolder;
	 
	// MovementRadioButton constructor, does all the actions described in the header above
	public MovementRadioButton(String label, ButtonGroup bg, MovementHolder movementHolder, int movement) {
		super(label);
		this.addActionListener(new MovementListener());
		this.movement = movement;
		this.movementHolder = movementHolder;
		bg.add(this);
	}
	
	// MovementListener is a nested class that implements the ActionListener class and sets the movementHolder's value to the value of movement
	private class MovementListener  implements ActionListener {
		public void actionPerformed(ActionEvent e)
		{
			movementHolder.setMovement(movement);
		}
	}
}
