package maze;
import java.io.PrintWriter;

import dijkstra.VertexInterface;


public abstract class MBox implements VertexInterface {
	
	private final int x, y;//coordonnees de la case
	private final Maze maze;
	
	public MBox(int x, int y, Maze maze) {
		this.x = x;
		this.y = y;
		this.maze = maze;
	}


	public final int getX() {
		return x;
	}


	public final int getY() {
		return y;
	}
	public Maze getMAZE() {
		return maze;
	}
	
	public String getLabel() {
		return "Case (" + x + "," + y + ")";
	}


	
	public boolean accessible() { 
		return true;
	}
		
	

	public abstract String getBoxSymbol();// retourne  soit A,D ,E ou W selon le type de la case


	public abstract void printbox(PrintWriter pwMaze);


	
}
