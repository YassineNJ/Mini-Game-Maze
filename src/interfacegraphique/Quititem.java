package interfacegraphique;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Quititem extends JMenuItem implements ActionListener // item pour quitter qui prévient l'utilisateur s'il veut sauvegarder
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final LabyrintheApp labyrinthe;
	public Quititem(LabyrintheApp l)
	{
		super("Quitter");
		this.labyrinthe=l;
		this.addActionListener(this);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		MessageQuit message =new MessageQuit();
		message.setVisible(true);
		
		
		// TODO Auto-generated method stub
				
	} 
	public class MessageQuit extends JFrame //fenetre demandant si l'utilisateur veut sauvegarder, quitter ou annuler
	{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private JPanel contentPane;
		private JButton buttonsave;
		private JButton buttonannuler;
		private JButton buttonquit;
	
		private MessageQuit message;
		

		
		public MessageQuit() {
			this.message=this;
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 450, 300);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			contentPane.setLayout(null);
			setContentPane(contentPane);
			message.setResizable(false);
			
			JLabel titre = new JLabel("Voulez vous sauvegarder le labyrinthe?");
			titre.setBounds(120,10,450,50);
			contentPane.add(titre);
			
			
			buttonsave = new JButton("Sauvegarder");
			buttonsave.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Saveitem save=new Saveitem(labyrinthe);
					save.actionPerformed(e);
					message.dispose();
					
				}
					
					
					
			});
			buttonsave.setBounds(30,150,130,50);
			contentPane.add(buttonsave);
			buttonquit = new JButton("Quitter");
			buttonquit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					message.dispose();
					labyrinthe.dispose();
					
					
			}});
			buttonquit.setBounds(200,150,100,50);
			contentPane.add(buttonquit);
			
			buttonannuler = new JButton("Annuler");
			buttonannuler.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					message.dispose();
					
					
			}});
			buttonannuler.setBounds(330,150,100,50);
			contentPane.add(buttonannuler);
			
			}

	}
}
