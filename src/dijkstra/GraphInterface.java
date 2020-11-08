package dijkstra;

import java.util.ArrayList;

public interface GraphInterface {
    public int size();

	
	public int getWeight(VertexInterface pivot, VertexInterface s);
	public ArrayList<VertexInterface> getSuccessors(VertexInterface s);
	


	public ArrayList<VertexInterface> getallVertices();


	


	

}

