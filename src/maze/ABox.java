package maze;

import java.io.PrintWriter;

public class ABox extends MBox {

	public ABox(int x, int y, Maze m) {
		super(x, y, m);
		
	}
	

	public final String getBoxSymbol()
	{
		return "A";
	}


	@Override
	public void printbox(PrintWriter pw) {
		// TODO Auto-generated method stub
		pw.print('A');
		
	}
	
}
