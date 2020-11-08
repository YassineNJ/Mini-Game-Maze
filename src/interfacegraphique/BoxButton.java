package interfacegraphique;

import javax.swing.*; 
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.*;


public class BoxButton extends JButton implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final LabyrintheApp labyrinthe;
	private String stringcase;
	private BoxButton c;
	private int i,j;
	

	
	
	
	
	public String getScase() {
		return stringcase;
	}



	public void setStringcase(String scase) {
		this.stringcase = scase;
	}
	 
	
	
		
		
		



	public BoxButton(LabyrintheApp maze, int i, int j ) {

		super("");
		
		
		this.i=i;
		this.j=j;
		this.stringcase="E";
		
		this.labyrinthe=maze;
		this.c=this;
		
		this.addActionListener(this);
		this.setPreferredSize(new Dimension(50,50));
		
		
		


		c.setBackground(Color.WHITE);

	
		}

	public void actionPerformed(ActionEvent e) {
		
		ChoiceMessage m=null;
		m = new ChoiceMessage();
		m.setVisible(true);
	}
	

	public class ChoiceMessage extends JFrame // fenetre demandant le choix du type de la case
	{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private JPanel contentPane;
		private JButton buttonok;
		private JButton buttonannuler;
		private JTextField textField;
		private ChoiceMessage message;
		

		
		public ChoiceMessage() {
			this.message=this;
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 450, 300);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			contentPane.setLayout(null);
			setContentPane(contentPane);
			message.setResizable(false);
			
			JLabel titre = new JLabel("Veuillez saisir le type de la case:");
			titre.setBounds(120,10,450,50);
			contentPane.add(titre);
			JLabel titre1 = new JLabel(" D :depart,  A :Arrivee,  E: Accessible,  W :Non Accessible.");
			titre1.setBounds(70,40,450,50);
			contentPane.add(titre1);
			
			
			buttonok = new JButton("OK");
			buttonok.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					
					
					stringcase=textField.getText().trim().toUpperCase();
					if(stringcase.equals("A")|| stringcase.equals("D")|| stringcase.equals("E")||stringcase.equals("W"))
					{labyrinthe.getMaze().setBoxes(i, j, stringcase);}
					
					
					switch(stringcase) {
					
					
					case "A":c.setBackground(Color.RED);break;
					case "D":c.setBackground(Color.green);break;
					case "W":c.setBackground(Color.BLACK);break;
					case "E":c.setBackground(Color.WHITE);break;
					default:
						Component fenetre = null;
						JOptionPane.showMessageDialog(fenetre, "Veuillez choisir une lettre parmi: A, D, E, W", "Attention", JOptionPane.WARNING_MESSAGE);
					}
					if(stringcase.equals("A")|| stringcase.equals("D")|| stringcase.equals("E")||stringcase.equals("W"))
						message.dispose();
				    }
			});
			buttonok.setBounds(100,200,100,50);
			contentPane.add(buttonok);
			buttonannuler = new JButton("Annuler");
			buttonannuler.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					message.dispose();
					
					
			}});
			buttonannuler.setBounds(250,200,100,50);
			contentPane.add(buttonannuler);
			
			textField = new JTextField();
			
			textField.setBounds(200, 120, 50, 20);

			contentPane.add(textField, null);
			
			
		}

	
	}


}
