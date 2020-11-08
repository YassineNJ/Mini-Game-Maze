package interfacegraphique;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import dijkstra.VertexInterface;
import maze.ABox;
import maze.DBox;
public class RunButton extends JButton implements ActionListener //Boutton affichant le plus court chemin
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final LabyrintheApp labyrinthe;
	public RunButton(LabyrintheApp l) {
		super("RESOUDRE");
		this.labyrinthe=l;
		this.addActionListener(this);
		}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		DBox d =labyrinthe.getMaze().getDeparture();
		ABox a=labyrinthe.getMaze().getArrival();
		
		if(labyrinthe.getMaze().departureBoxesCounter()==0) {
			Component fenetre = null;
			JOptionPane.showMessageDialog(fenetre, "Case de depart non indiquee", "Attention", JOptionPane.WARNING_MESSAGE);
			
		}
		else if(labyrinthe.getMaze().departureBoxesCounter()>1) {
			Component fenetre = null;
			JOptionPane.showMessageDialog(fenetre, "Plusieurs cases de depart", "Attention", JOptionPane.WARNING_MESSAGE);
		}
		else if(labyrinthe.getMaze().arrivalBoxesCounter()==0) {
			Component fenetre = null;
			JOptionPane.showMessageDialog(fenetre, "Case d'arrivee non indiquee", "Attention", JOptionPane.WARNING_MESSAGE);
			
		}
		else if(labyrinthe.getMaze().arrivalBoxesCounter()>1) {
			Component fenetre = null;
			JOptionPane.showMessageDialog(fenetre, "Plusieurs cases d'arrivees", "Attention", JOptionPane.WARNING_MESSAGE);
			
		}
		
		else{
			ArrayList<VertexInterface> path=null;
			path = labyrinthe.getMaze().ShortestPath();
		if(path.size()<3 && labyrinthe.getMaze().arrivalBoxesCounter()==1&&labyrinthe.getMaze().departureBoxesCounter()==1) {
			Component fenetre = null;
			JOptionPane.showMessageDialog(fenetre, "Labyrinthe non resolvable", "Attention", JOptionPane.WARNING_MESSAGE);
			}
		if(path.size()>2 && labyrinthe.getMaze().arrivalBoxesCounter()==1 && labyrinthe.getMaze().departureBoxesCounter()==1) {
		
		for(int i=0;i<labyrinthe.getsize();i++) 
		{
			for(int j=0;j<labyrinthe.getsize();j++) {
				
					if(path.contains(labyrinthe.getMaze().getBoxes()[i][j]) && labyrinthe.getMaze().getBoxes()[i][j]!=d && labyrinthe.getMaze().getBoxes()[i][j]!=a) {
					labyrinthe.getWindowPanel().getdPanel().getMatricecase()[i][j].setBackground(Color.BLUE);
					}
				
				
			}
		}
		}
		}
		
	}
	
		
}	
	
		

