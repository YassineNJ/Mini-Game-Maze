package interfacegraphique;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.EmptyBorder;
public class DimensionButton extends JButton implements ActionListener // boutton pour modifier les dimensions
{
	
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		private LabyrintheApp labyrinthe;
		public DimensionButton(LabyrintheApp labyrinthe) {
			super("Modifier les dimensions");
			this.labyrinthe=labyrinthe;
			this.addActionListener(this);
			
			
		
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			
			Messagedimensions m = new Messagedimensions();
			m.setVisible(true);
		}
		

		public class Messagedimensions extends JFrame // fenetre demandant de saisir les dimensions du nouveau labyrinthe
		{

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			private JPanel contentPane;
			private JButton button;
			private JButton buttonannuler;
			private JTextField textField;
			public Messagedimensions() {
				
					
					setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					setBounds(100, 100, 450, 300);
					contentPane = new JPanel();
					contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
					contentPane.setLayout(null);
					setContentPane(contentPane);
					
					
					JLabel titre = new JLabel("Veuillez saisir le nombre de cases du cote ");
					titre.setBounds(100,40,450,50);
					contentPane.add(titre);
					
					
					
					button = new JButton("OK");
					button.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							new LabyrintheApp(Integer.parseInt(textField.getText()));
						    labyrinthe.dispose();
							dispose();
							}
					});
					button.setBounds(100,180,100,50);
					contentPane.add(button);
					buttonannuler = new JButton("Annuler");
					buttonannuler.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
						dispose();
							
							
					}});
					buttonannuler.setBounds(250,180,100,50);
					contentPane.add(buttonannuler);
					
					textField = new JTextField();
					
					textField.setBounds(200, 120, 50, 20);

					contentPane.add(textField);
					
					
				}
				
		}

	}
	
	
	