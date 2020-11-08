package maze;

import java.io.PrintWriter;

public class DBox extends MBox {

	public DBox(int x, int y, Maze m) {
		super(x, y, m);
		
	}
	

	public final String getBoxSymbol()
	{
		return "D";
	}


	@Override
	public void printbox(PrintWriter pw) {
		pw.print('D');
	}
	
	
}
