package interfacegraphique;

import javax.swing.* ;
import java.awt.*;

public class WindowPanel extends JPanel

{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final BoxesPanel dPanel ;
    private final ButtonsPanel bPanel ;
    
	public WindowPanel(LabyrintheApp dApp)
	{
		setLayout(new BorderLayout()) ;
		
		add(dPanel = new BoxesPanel (dApp), BorderLayout.CENTER) ;
		add(bPanel = new ButtonsPanel (dApp), BorderLayout.SOUTH) ;
	}

	public BoxesPanel getdPanel() {
		return dPanel;
		
	}

	public ButtonsPanel getbPanel() {
		return bPanel;
	}
	
	
}