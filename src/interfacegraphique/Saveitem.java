package interfacegraphique;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
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

public class Saveitem extends JMenuItem implements ActionListener//Item de sauvegarde
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final LabyrintheApp maze;
	private String filename;
	public Saveitem(LabyrintheApp l)
	{
		super("Sauvegrader dans un fichier texte");
		this.maze=l;
		this.addActionListener(this);
	}
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		MessageSave message= new MessageSave();
		message.setVisible(true);
	}
	public class MessageSave extends JFrame //fenetre demandant de saisir le chemin du fichier 
	{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private JPanel contentPane;
		private JButton button;
		private JButton buttonannuler;
		private JTextField textField;
		private MessageSave message;
		

		
		public MessageSave() //classe qui définit la fenetre demandant de saisir le chemin du fichier
		{
			this.message=this;
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 450, 300);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			contentPane.setLayout(null);
			setContentPane(contentPane);
			message.setResizable(false);
			
			JLabel titre = new JLabel("Veuillez saisir le chemin du fichier");
			titre.setBounds(120,10,450,50);
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
						JOptionPane.showMessageDialog(null, "Le chemin n'est pas valide \n chemin attendu : C:\\...\\nomdufichier.txt ", "Attention", JOptionPane.WARNING_MESSAGE);
						
					}
					else{
						try {
					
						
						maze.getMaze().saveToTextFile(filename);
						JOptionPane.showMessageDialog(null, "Fichier sauvegarde", "", JOptionPane.WARNING_MESSAGE);
						message.dispose();
						
						
					    } catch (FileNotFoundException e1) {
					    	JOptionPane.showMessageDialog(null, "Fichier introuvable", "Attention", JOptionPane.WARNING_MESSAGE);
					    	}
						catch(Exception e2) {
							JOptionPane.showMessageDialog(null, "Erreur lors de la sauvegarde du fichier", "Attention", JOptionPane.WARNING_MESSAGE);
							e2.printStackTrace();
						}
					
					}
				}
					
					
			});
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

