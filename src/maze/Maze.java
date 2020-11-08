package maze;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import dijkstra.Dijkstra;
import dijkstra.GraphInterface;
import dijkstra.PreviousInterface;
import dijkstra.VertexInterface;



public class Maze implements GraphInterface {
	
	private int hauteur;
	private int largeur; 
	private MBox[][] boxes;
	
	
	public Maze(int h, int lr) {
		
		this.hauteur = h;
		this.largeur = lr;
		boxes = new MBox[h][lr];
		
		
		
	}
	
	public final ArrayList<VertexInterface> getallVertices()
	{
		ArrayList<VertexInterface> Vertices = new ArrayList<VertexInterface>();

		for (int y = 0 ; y < hauteur ; y++)
		{
			MBox[] l = boxes[y];
			for (int c = 0 ; c < largeur ; c++)
				Vertices.add(l[c]);
			}
		return Vertices;
	}
	public ArrayList<VertexInterface> getSuccessors(VertexInterface v){
		ArrayList<VertexInterface> successors = new ArrayList<VertexInterface>();
		MBox mbox = (MBox)v ; 

		
		if (mbox.getY() > 0) 
		{ 
			MBox nbr = boxes[mbox.getY()-1][mbox.getX()];
			if (nbr.accessible())
				successors.add(nbr);
		}

		if (mbox.getY() < hauteur-1) 
		{ 
			MBox nbr = boxes[mbox.getY()+1][mbox.getX()];
			if (nbr.accessible())
				successors.add(nbr);
		}

		if (mbox.getX() > 0) 
		{ 
			MBox nbr = boxes[mbox.getY()][mbox.getX()-1];
			if (nbr.accessible())
				successors.add(nbr);
		}

		if (mbox.getX() < largeur-1) 
		{ 
			MBox nbr = boxes[mbox.getY()][mbox.getX()+1];
			if (nbr.accessible())
				successors.add(nbr);
		}	
		return successors;
	}

	
	public int size() {
		return hauteur * largeur;
	}

	public int getWeight(VertexInterface v, VertexInterface s) {
		if(v.equals(s))
			return 0;
		return 1;
	}
	public int getHauteur() {
		return hauteur;
	}
	public void setHauteur(int hauteur) {
		this.hauteur = hauteur;
	}
	public int getLargeur() {
		return largeur;
	}
	public void setLargeur(int largeur) {
		this.largeur = largeur;
	}
	
	public MBox[][] getBoxes() {
		return boxes;
	}
	public void setBoxes(MBox[][] boxes) {
		this.boxes = boxes;
	}
	public DBox getDeparture(){
		DBox depart=null;
		
		for(int i=0;i<hauteur;i++) 
			for(int j=0;j<largeur;j++) 
				if(this.getBoxes()[i][j].getBoxSymbol()=="D") 
					depart= (DBox) this.getBoxes()[i][j];
		return depart;
		
	}
	public ABox getArrival() {
		ABox arrivee=null;
		
		for(int i=0;i<hauteur;i++) 
			for(int j=0;j<largeur;j++) 
				if(this.getBoxes()[i][j].getBoxSymbol()=="A") 
					arrivee =(ABox) this.getBoxes()[i][j];
					
				
		return arrivee;
		
	}
	public int departureBoxesCounter() //conteur de cases de depart dans le labyrinthe 
	{
		int k =0;
		for(int i=0;i<hauteur;i++) 
			for(int j=0;j<largeur;j++) 
				if(this.getBoxes()[i][j].getBoxSymbol()=="D") 
					k++;
				
					
		return k;
		
	}
	public int arrivalBoxesCounter() //conteur de cases d'arrivee dans le labyrinthe
	{
		int k =0;
		for(int i=0;i<hauteur;i++) 
			for(int j=0;j<largeur;j++) 
				if(this.getBoxes()[i][j].getBoxSymbol()=="A") 
					k++;
		return k;
		
	}
	public ArrayList<VertexInterface> ShortestPath() {

	     
		
		DBox r = this.getDeparture();
		
		PreviousInterface p=Dijkstra.dijkstra(this,r);
		ArrayList<VertexInterface> path=p.getshotestPathTo(this.getArrival());
		
		return path;
		
		
	}
	public void initFromTabOfStrings(String[][] s) //Initialise boxes a partir d'un tableau de String
	{
		for(int i=0;i<hauteur;i++) {
			for(int j=0;j<hauteur;j++) {
				switch (s[i][j]) {
				case "D" :
					boxes[i][j] = new DBox(j, i, this); break;
				case "A" :
					boxes[i][j] = new ABox(j, i, this); break;
				case "W" :
					boxes[i][j] = new WBox(j, i, this); break;
				case "E" :
					boxes[i][j] = new EBox(j, i, this); break;  
				}
				
			}
			
			
		}
		
	}

	public final void initFromTextFile(String file) throws MazeReadingException, FileNotFoundException, IOException, Exception// initialise boxes a partir d'un fichier texte

	{			  
		FileReader fMaze = new FileReader(file);
		BufferedReader bMaze = new BufferedReader(fMaze);	

		try {
			for (int y = 0; y <hauteur ; y++) 
			{				  
				String ligne = bMaze.readLine();

				if (ligne == null)
					throw new MazeReadingException(file, y, "ajoutez des lignes");
				if (ligne.length() < largeur)
					throw new MazeReadingException(file, y, "ligne trop courte");
				if (ligne.length() > largeur)
					throw new MazeReadingException(file, y, "ligne trop longue");
				else {

				for (int x = 0 ; x < largeur ; x++)
				{
					switch (ligne.charAt(x)) 
					{
					case 'D' :
						boxes[y][x] = new DBox(x, y, this); break;
					case 'A' :
						boxes[y][x] = new ABox(x, y, this); break;
					case 'W' :
						boxes[y][x] = new WBox(x, y, this); break;
					case 'E' :
						boxes[y][x] = new EBox(x, y, this); break;         	
					default :
						throw new MazeReadingException(file, y, "caractere inconnu " + boxes[y][x] );
					}
				} 
				}
			}

		} catch(Exception e){e.printStackTrace();}finally {
			try{if (fMaze != null)
			{	
				fMaze.close();
			}

			if (bMaze != null)
			{
				bMaze.close();		
			}
			}catch(Exception e) {e.printStackTrace();}
		}
	}
	
	
	public final void saveToTextFile(String file) throws FileNotFoundException, IOException, Exception, MazeReadingException //sauvegarder dans un fichier texte
	
	{		
		

		PrintWriter pw = new PrintWriter(file);
		
		for (int i = 0 ; i <hauteur ; i++)			
		{
			MBox[] line = boxes[i] ;
			for (int j = 0 ; j < largeur ; j++)
			{			    	 
				line[j].printbox(pw);
			} 
			pw.println();		
			
		}
		
		
		pw.close();
}
	
	
	
	
	public String[][] getArrayOfSymbols()// Renvoie une table contenant les symboles des cases
	{
		String[][] t=new String[hauteur][largeur];
		for(int i=0;i<hauteur;i++) {
			for(int j=0;j<hauteur;j++) {
				t[i][j]=boxes[i][j].getBoxSymbol();
				} 
		} 
		return t;
			
		
	}
	
	
	public void setBoxes(int i,int j, String s) //  modifier le type de la case definit par (i,j)
	{
		switch (s) {
		case "D" :
			boxes[i][j] = new DBox(j, i, this); break;
		case "A" :
			boxes[i][j] = new ABox(j, i, this); break;
		case "W" :
			boxes[i][j] = new WBox(j, i, this); break;
		case "E" :
			boxes[i][j] = new EBox(j, i, this); break;  
		}
		
		}

	}

		


	
	
	
	
	
	
	
	

