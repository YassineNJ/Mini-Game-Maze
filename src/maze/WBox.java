package maze;

import java.io.PrintWriter;

public class WBox extends MBox {

	public WBox(int x, int y, Maze maze) {
		super(x, y, maze);
		
	}
	@Override
	public final boolean accessible() {
		return false; 
	}

	

	public final String getBoxSymbol()
	{
		return "W";
	}
	@Override
	public void printbox(PrintWriter pw) {
		
		pw.print('W');
		
	}
}

	


