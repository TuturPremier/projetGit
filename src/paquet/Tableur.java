package paquet;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class Tableur extends JFrame{
	
	JTable table;
	DefaultTableModel tableur;
	private JMenuBar menuBar = new JMenuBar();
	private JMenu JFichier = new JMenu("Fichier");
	private JMenu JOuvrir = new JMenu("Ouvrir sous");
	private JMenuItem IOuvrir = new JMenuItem("Ouvrir");
	private JMenuItem IQuitter = new JMenuItem("Quitter");
	
	private JMenu JPropos = new JMenu("A propos");
	private JMenuItem IPropos = new JMenuItem("?");

	public Tableur() { 
		tableur = new  DefaultTableModel();


		tableur.addColumn("DOSSIER");
		tableur.addColumn("FICHIER");
		tableur.addColumn("CLEF");
		tableur.addColumn("TYPE");

		tableur.setRowCount(500);

		table = new JTable(tableur);
		table.setPreferredScrollableViewportSize(new Dimension(840, 500));
		add(new JScrollPane(table), BorderLayout.CENTER);

		




		javax.swing.table.TableColumnModel lModel = table.getColumnModel();
		table.setRowHeight( 20 );

		lModel.getColumn(0).setMaxWidth(70);
		lModel.getColumn(1).setMaxWidth(350);
		lModel.getColumn(2).setMaxWidth(350);
		lModel.getColumn(3).setMaxWidth(70);




		JFichier.add(IOuvrir);
		menuBar.add(JFichier);
		JPropos.add(IPropos);
		menuBar.add(JPropos);
		setJMenuBar(menuBar);
		
		
		this.JFichier.add(IQuitter);

		
		
		IOuvrir.addActionListener(new ActionListener(){
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
				try {
					finder.rechercheFichier(recupChemin[0]);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}        
		});
		
		
		IPropos.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				new APropos();

			}        
		});
		
		
		IQuitter.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);

			}        
		});

		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(300, 120);

		pack(); 
		setVisible(true); 
		////////////////////////////////////////////////////////////////////

	}


	
}
