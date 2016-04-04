package paquet;

import java.awt.BorderLayout; 
import java.awt.Graphics; 
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel; 

class GlobalConsoleFrame extends JFrame 
{ 
	private JMenuBar menuBar = new JMenuBar();
	private JMenu test1 = new JMenu("Fichier");
	private JMenuItem item1 = new JMenuItem("Ouvrir");
	private JMenuItem item2 = new JMenuItem("Quitter");
	
	GlobalConsoleFrame() 
	{ 
		this.test1.add(item1);
	this.test1.add(item2);

	item1.addActionListener(new ActionListener(){
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

			Rechercher finder = new Rechercher();
			finder.rechercheFichier(recupChemin[0]);


			
			

		}        
	});
	item2.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent arg0) {
			System.exit(0);

		}        
	});

	this.menuBar.add(test1);

	this.setJMenuBar(menuBar);
		
		
		
		
		setSize(860, 560); 
		setLocation(300, 100);
		setTitle("Test"); 
		setContentPane(new AfficheImage("FondFenetre.png")); 
		getContentPane().setLayout(new BorderLayout()); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true); 
	} 
} 

class AfficheImage extends JPanel 
{ 
	Image eau; 

	AfficheImage(String s) 
	{ 
		eau = getToolkit().getImage(s); 
	} 

	public void paintComponent(Graphics g) 
	{ 
		super.paintComponent(g); 
		g.drawImage(eau, 0, 0, getWidth(), getHeight(), this); 
	} 
} 

