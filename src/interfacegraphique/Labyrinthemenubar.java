package interfacegraphique;
 import javax.swing.*;

 public class Labyrinthemenubar extends JMenuBar
 {
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Labyrinthemenubar(LabyrintheApp maze) 
	 {
	
		 
		super();
		add(new FileMenu(maze));
		
		
	}

}
