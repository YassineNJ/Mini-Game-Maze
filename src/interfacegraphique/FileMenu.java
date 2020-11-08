package interfacegraphique;
import javax.swing.*;
public class FileMenu extends JMenu  //Menu fichier 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	public FileMenu(LabyrintheApp maze) {
		super("Fichier");
		add(new Newitem(maze));
		add(new Saveitem(maze));
		add(new Openitem(maze));
		add(new Quititem(maze));
		
      }
	}
