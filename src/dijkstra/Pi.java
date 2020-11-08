package dijkstra;

import java.util.Hashtable;

public class Pi extends Hashtable<PiInterface,Integer> implements PiInterface{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Hashtable<VertexInterface, Integer> tab;
	public Pi() {
	
	tab = new Hashtable<VertexInterface, Integer>();

	}

	@Override
	public void setValue(VertexInterface v, int i) {
		tab.put(v, new Integer(i));
		
	}

	@Override
	public int getValue(VertexInterface pivot) {
		return tab.get(pivot).intValue();
	}
	
	

}
