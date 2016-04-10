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
	private JMenuItem ILinux = new JMenuItem("Linux/Mac OS");
	private JMenuItem IWindows = new JMenuItem("Windows");
	private JMenuItem IQuitter = new JMenuItem("Quitter");
	private JMenuItem IPropos = new JMenuItem("?");

	public FenPrem() {
		// TODO Auto-generated constructor stub
		
		JOuvrir.add(ILinux);
		JOuvrir.add(IWindows);
		JFichier.add(JOuvrir);
		menuBar.add(JFichier);
		JPropos.add(IPropos);
		menuBar.add(JPropos);
		setJMenuBar(menuBar);
		
		
		this.JFichier.add(IQuitter);

		ILinux.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser dialogue = new JFileChooser(new File("Users"));
				String chemin = null;
				File fichier;
				String[] recupChemin = null;

				if (dialogue.showOpenDialog(null)== JFileChooser.APPROVE_OPTION) {
					fichier = dialogue.getSelectedFile();
					chemin = fichier.getPath();
					recupChemin = chemin.split("clique ici");

				}
				setVisible(false);
				recupChemin[0]=recupChemin[0]+"/.git/objects";

				RechercheLinux finder = new RechercheLinux();
				finder.rechercheFichier(recupChemin[0]);

			}        
		});
		
		
		IWindows.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser dialogue = new JFileChooser(new File("."));
				String chemin = null;
				File fichier;
				String[] recupChemin = null;

				if (dialogue.showOpenDialog(null)== JFileChooser.APPROVE_OPTION) {
					fichier = dialogue.getSelectedFile();
					chemin = fichier.getPath();
					recupChemin = chemin.split("clique ici");

				}
				setVisible(false);
				recupChemin[0]=recupChemin[0]+"/.git/objects";

				RechercherWindows finder = new RechercherWindows();
				try {
					finder.rechercheFichier(recupChemin[0]);
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
