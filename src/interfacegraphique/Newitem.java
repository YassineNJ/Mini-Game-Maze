package interfacegraphique;

import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener;
import javax.swing.*;
public class Newitem extends JMenuItem implements ActionListener// item pour creer un nouveau labyrinthe
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final LabyrintheApp maze;
	public Newitem(LabyrintheApp maze)
	{
		super("Nouveau labyrinthe");
		this.maze=maze;
		this.addActionListener(this);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		maze.dispose();
		new LabyrintheApp(maze.getsize());
		// TODO Auto-generated method stub
				
	}
	
	

}
