package dijkstra;


import java.util.ArrayList;
import java.util.Hashtable;

public class Previous extends Hashtable<VertexInterface,VertexInterface > implements PreviousInterface {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final Hashtable<VertexInterface, VertexInterface> tab;
	public Previous() {
		tab = new Hashtable<VertexInterface, VertexInterface>();
	}
	

	@Override
	public void setPrevious(VertexInterface v, VertexInterface pivot) {
		tab.put(v, pivot);
	
	
		
	}

	@Override
	public VertexInterface getPrevious(VertexInterface v) {
		return tab.get(v);
		
	}


	@Override
	public ArrayList<VertexInterface> getshotestPathTo(VertexInterface vertex) {
		
		ArrayList<VertexInterface> path = new ArrayList<VertexInterface>();

		while (vertex != null)
		{
			path.add(vertex);
			vertex = getPrevious(vertex);
		}

		return path;
	}


	
	
		
		
		
	}


