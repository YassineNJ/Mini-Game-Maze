package interfacegraphique;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import maze.Maze;

public class Openitem extends JMenuItem implements ActionListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final LabyrintheApp maze;
	private String filename;
	public Openitem(LabyrintheApp maze)
	{
		super("Ouvrir a partir d'un fichier texte");
		this.maze=maze;
		this.addActionListener(this);
	}

	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		MessageOpen message=new MessageOpen();
		message.setVisible(true);
		
		
		}
   public class MessageOpen extends JFrame // la classe de la fenetre demandant de saisir le chemin du fichier
   {

			/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
			private JPanel contentPane;
			private JButton button;
			private JButton buttonannuler;
			private JTextField textField;
			private MessageOpen message;
			

			
			public MessageOpen() //classe de la fenetre demandant de saisir le chemin du fichier
			{
				this.message=this;
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				setBounds(100, 100, 450, 300);
				contentPane = new JPanel();
				contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
				contentPane.setLayout(null);
				setContentPane(contentPane);
				message.setResizable(false);
				
				JLabel titre = new JLabel("Veuillez saisir le chemin du fichier que vous avez sauvegarde");
				titre.setBounds(60,10,450,50);
				contentPane.add(titre);
				
				
				button = new JButton("OK");
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						filename=textField.getText();
						 
						String regex= "^(?:[a-zA-Z]\\:|\\\\\\\\[\\w\\.]+\\\\[\\w.$]+)\\\\(?:[\\w]+\\\\)*\\w([\\w.])+$";
						if(filename.isEmpty()) {
							
							JOptionPane.showMessageDialog(null, "Veuillez saisir le chemin du fichier", "Attention", JOptionPane.WARNING_MESSAGE);
							
						}
						else if(!filename.matches(regex)){
							JOptionPane.showMessageDialog(null, "Le chemin n'est pas valide \n chemin attendu : C:\\...\\nomdufichier.txt", "Attention", JOptionPane.WARNING_MESSAGE);
							
						}
						else{
						FileReader f = null;
						Maze m=null;
						int n=0;
						String l=null;
						try {
						f = new FileReader(filename);
						
						BufferedReader b = new BufferedReader(f);	
						
						
						l = b.readLine();
							

						n=l.length();		
								
					    m=new Maze(n,n);
						
							
						m.initFromTextFile(filename);
						
							
						
						String[][]t=m.getArrayOfSymbols();
						LabyrintheApp lab=new LabyrintheApp(n);
						lab.getMaze().initFromTabOfStrings(t);
						//reconstituer le labyrinthe pr�c�dent
						for (int i = 0; i <n; i++) {
							for(int j=0;j<n;j++) {
								switch (t[i][j]) {
								case "A":lab.getWindowPanel().getdPanel().getMatricecase()[i][j].setBackground(Color.RED);
								lab.getWindowPanel().getdPanel().getMatricecase()[i][j].setStringcase("A");
								
								break;
								case "D":lab.getWindowPanel().getdPanel().getMatricecase()[i][j].setBackground(Color.green);
								lab.getWindowPanel().getdPanel().getMatricecase()[i][j].setStringcase("D");
								
								break;
								case "E":lab.getWindowPanel().getdPanel().getMatricecase()[i][j].setBackground(Color.WHITE);
								lab.getWindowPanel().getdPanel().getMatricecase()[i][j].setStringcase("E");

								break;
								case "W":lab.getWindowPanel().getdPanel().getMatricecase()[i][j].setBackground(Color.BLACK);
								lab.getWindowPanel().getdPanel().getMatricecase()[i][j].setStringcase("W");
								
								
								break;

								
								}
								
							}
							
						}
						maze.dispose();
						message.dispose();
					
					   
                    }catch (FileNotFoundException e1) {
				    	JOptionPane.showMessageDialog(null, "Fichier introuvable", "Attention", JOptionPane.WARNING_MESSAGE);
				    	
				    	}
					catch(Exception e2) {
						JOptionPane.showMessageDialog(null, "Erreur lors de la lecture du fichier", "Attention", JOptionPane.WARNING_MESSAGE);
						e2.printStackTrace();
					}
					
					    }
				}});
				button.setBounds(100,200,100,50);
				contentPane.add(button);
				buttonannuler = new JButton("Annuler");
				buttonannuler.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						message.dispose();
						
						
				}});
				buttonannuler.setBounds(250,200,100,50);
				contentPane.add(buttonannuler);
				
				textField = new JTextField();
				
				textField.setBounds(120, 120, 200, 20);

				contentPane.add(textField, null);
				
				
			}

			
		
		
	}
   
}
 

