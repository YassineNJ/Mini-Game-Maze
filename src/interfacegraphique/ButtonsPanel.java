package interfacegraphique;

import java.awt.*;
import javax.swing.* ;

public class ButtonsPanel extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ButtonsPanel(LabyrintheApp maze){
		setLayout(new GridLayout(1,2)) ;
		
		add(new DimensionButton(maze));
		add(new RunButton(maze)) ;
		
	}
	
}
