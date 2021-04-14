// Jacob Conrad, Practice 5, April 13, 2020, The app class creates a frame where a panel and buttons can be placed

import java.awt.BorderLayout;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class App extends JFrame {

	private MovementHolder movementHolder;
	
	// App constructor, creates a frame where a drawingpanel, controlPanel, and buttons are placed
	public App(){
		super("Fly");
		
		this.setSize(1000,900);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);	
		
		movementHolder = new MovementHolder(3);
		
		DrawingPanel drawingPanel = new DrawingPanel(movementHolder);
		
		JPanel controlPanel = new JPanel();
		
		ButtonGroup bg = new ButtonGroup();
		
		MovementRadioButton randomButton = new MovementRadioButton("random", bg, movementHolder, 1);
		MovementRadioButton followButton = new MovementRadioButton("follow", bg, movementHolder, 2);
		MovementRadioButton doNothingButton = new MovementRadioButton("do nothing", bg, movementHolder, 3);

		doNothingButton.setSelected(true);
		
		controlPanel.add(doNothingButton);
		controlPanel.add(followButton);
		controlPanel.add(randomButton);
		
		this.setLayout(new BorderLayout());
		
		this.add(drawingPanel, BorderLayout.CENTER);
		this.add(controlPanel, BorderLayout.SOUTH);
		
		this.setVisible(true);
	}
	
	// App main method, creates App
	public static void main(String[] args) {
		new App();
	}

}