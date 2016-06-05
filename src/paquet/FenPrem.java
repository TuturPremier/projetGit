package paquet;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class FenPrem extends JFrame {

	private JMenuBar menuBar = new JMenuBar();
	private JMenu JFichier = new JMenu("Fichier");

	private JMenu JOuvrir = new JMenu("Ouvrir sous");
	private JMenu JPropos = new JMenu("A propos");
	private JMenuItem IOuvrir = new JMenuItem("Ouvrir");
	private JMenuItem IQuitter = new JMenuItem("Quitter");
	private JMenuItem IPropos = new JMenuItem("?");

	public FenPrem() {
		// TODO Auto-generated constructor stub


		JFichier.add(IOuvrir);
		menuBar.add(JFichier);
		JPropos.add(IPropos);
		menuBar.add(JPropos);
		setJMenuBar(menuBar);


		this.JFichier.add(IQuitter);




		IOuvrir.addActionListener(new ActionListener(){

			//permet l'ouverture d'un fichier mais avec Windows car méthode differente

			public void actionPerformed(ActionEvent arg0) {

				JFileChooser dialogue = new JFileChooser(new File("Users"));
				dialogue.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				File fichier = null;
				if (dialogue.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					fichier = dialogue.getSelectedFile();

				}
				setVisible(false);

				Rechercher finder = new Rechercher();
				try {
					File objDir = new File(new File(fichier, ".git"), "objects");
					if (objDir.exists() && objDir.isDirectory()) {
						finder.rechercheFichier(objDir.getAbsolutePath());
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}        
		});


		IQuitter.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);

			}        
		});

		IPropos.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				new APropos();

			}        
		});

		setSize(860, 560); 
		setLocation(300, 100);
		setTitle("Projet Git"); 
		setContentPane(new AfficheImage("FondFenetre.png")); 
		getContentPane().setLayout(new BorderLayout()); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true); 
	} 
}

class AfficheImage extends JPanel 
{ 
	Image fond; 

	AfficheImage(String s) 
	{ 
		fond = getToolkit().getImage(s); 
	} 

	public void paintComponent(Graphics g) 
	{ 
		super.paintComponent(g); 
		g.drawImage(fond, 0, 0, getWidth(), getHeight(), this); 
	} 
} 
