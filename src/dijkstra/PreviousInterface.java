package dijkstra;

import java.util.ArrayList;

public interface PreviousInterface {
	
	
	public VertexInterface getPrevious(VertexInterface v);
	public void setPrevious(VertexInterface s, VertexInterface pivot);
	public ArrayList<VertexInterface> getshotestPathTo(VertexInterface vertex);
	
	
	
	

}

