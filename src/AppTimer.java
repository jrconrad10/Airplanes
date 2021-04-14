// Jacob Conrad, Practice 5, April 13, 2020, The AppTimer class extends Timer and includes a nested Listener class with an actionPerformed method that runs based on timer ticks

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JToggleButton;
import javax.swing.Timer;

public class AppTimer extends Timer {
	
	private JToggleButton button;
	private DrawingPanel panel;

	// Apptimer constructor
	public AppTimer(DrawingPanel panel, JToggleButton button, MovementHolder movementHolder) {
		super(100, null);
		this.addActionListener(new Listener());
		this.button = button;
		this.panel = panel;
	}
	
	// The Listener class includes an actionPerformed method that runs based on timer ticks
	public class Listener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e)
		{
			panel.move(1, 0);
			panel.repaint();
		}
	}
}