package interfacegraphique;



import javax.swing.* ;

import maze.Maze;

public class LabyrintheApp extends JFrame
{
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private  WindowPanel    windowPanel ; 
   private int size;
   private Maze maze;
  
   
   public LabyrintheApp(int size)
   {
	
      super("Labyrinthe Yassine NAJI-Hana OULMQADEM") ; 
      this.size=size;
      this.maze=new Maze(this.getsize(),this.getsize());
      String[][] t= new String[size][size];
		for(int k=0;k<size;k++) {
			for(int l=0;l<size;l++) {
				t[k][l]="E";
			}
		}
	  this.maze.initFromTabOfStrings(t);
      
      
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ; 
      setJMenuBar(new Labyrinthemenubar(this));
      setContentPane(windowPanel = new WindowPanel(this)) ;
      

      pack() ;          
      
      setVisible(true) ;  
   
  	} 
   

   

public Maze getMaze() {
	return maze;
}



public void setMaze(Maze m) {
	this.maze = m;
}



public int getsize() {
	return size;
}


public void setsize(int size) {
	this.size = size;
}



public WindowPanel getWindowPanel() {
	return windowPanel;
}
   

}