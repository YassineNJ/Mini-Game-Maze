package interfacegraphique;
import javax.swing.* ;

import java.awt.* ;

public class BoxesPanel extends JPanel
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final LabyrintheApp labyrinthe ;
	private BoxButton[][] matricecases;
	
	
	
	public BoxButton[][] getMatricecase() {
		return matricecases;
	}



	public void setMatricecase(BoxButton[][] matricecase) {
		this.matricecases = matricecase;
	}



	public LabyrintheApp getMaze() {
		return labyrinthe;
	}
	



	public BoxesPanel(LabyrintheApp maze)
	{
		this.labyrinthe = maze ;
		
		
		this.matricecases=new BoxButton[maze.getsize()][maze.getsize()];
		
		
		GridLayout gl=new GridLayout(maze.getsize(),maze.getsize());
		setLayout(gl);
		gl.setHgap(1);
		gl.setVgap(1);
		
		
		setBackground(Color.WHITE) ;
		setPreferredSize(new Dimension(700,700)); 

		for(int i=0;i<maze.getsize(); i++)
		{ for(int j=0;j<maze.getsize();j++) {
			BoxButton c=new BoxButton(maze,i,j);
			
			add(c);
			this.matricecases[i][j]=c; 
			
			

			
		}
		
		}
			
			
		}
		
		
	}
	


