
package dijkstra;


public class Dijkstra {
	

	public static PreviousInterface dijkstra(GraphInterface g, VertexInterface r, ASetInterface a, PiInterface pi, PreviousInterface p)
	{


		a.add(r);

		for (VertexInterface x : g.getallVertices())
		{
			pi.setValue(x, Integer.MAX_VALUE);
		}

		pi.setValue(r,0);		
		VertexInterface pivot = r;
		int piPivot = 0;

		for (int i = 1 ; i<g.getallVertices().size() ; i++)
		{
	
			for (VertexInterface v : g.getSuccessors(pivot))
			{
				if (!a.contains(v))
				{
					int nvPi = piPivot + g.getWeight(pivot, v);
					if (nvPi < pi.getValue(v))
					{
						pi.setValue(v,nvPi);
						p.setPrevious(v, pivot);
					}
				}
			}


			VertexInterface nvPivot = null;
			int pinvPivot = Integer.MAX_VALUE;

			for (VertexInterface v : g.getallVertices())
			{
				
					int piV = pi.getValue(v);
					if (piV < pinvPivot &&!a.contains(v) )
					{
						nvPivot = v;
						pinvPivot = piV;

					}
				
			}	
			if (nvPivot == null)
			{
				return p;
			}				

			piPivot = pinvPivot;

			pivot = nvPivot;
			
			a.add(pivot);		
		}		

		return p;			
			

			
					
		}	
	public static PreviousInterface dijkstra (GraphInterface g, VertexInterface r) {
		return dijkstra(g,r, new ASet(),new Pi(), new Previous());
		
	}

		}

	



	



