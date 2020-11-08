package dijkstra;
import java.util.HashSet;


public class ASet implements ASetInterface{
	/**
	 * 
	 */
	
	private HashSet<VertexInterface> tab;
	public ASet() {
		
		tab = new HashSet<VertexInterface>();
	}
	public boolean contains(VertexInterface v) {
		return tab.contains(v);
		
	}
	@Override
	public void add(VertexInterface v) {
	 tab.add(v);
		
	}
	
	
	

}
