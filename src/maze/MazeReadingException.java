package maze;

public class MazeReadingException extends Exception 
{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MazeReadingException (String fileName, int line, String error)
	{
		super("Erreur: lors la lecture du labyrinthe: " + fileName  + line + error);
	}
}
