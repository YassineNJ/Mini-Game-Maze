package maze;

import java.io.PrintWriter;

public class EBox extends MBox {
	
	public EBox(int x, int y, Maze maze) {
		super(x, y, maze);
		// TODO Auto-generated constructor stub
	}

	public final String getBoxSymbol()
	{
		return "E";
	}

	@Override
	public void printbox(PrintWriter pw) {
		// TODO Auto-generated method stub
		pw.print('E');
		
	}

	
}
