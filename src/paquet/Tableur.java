package paquet;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

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
	private JMenu test1 = new JMenu("Fichier");
	private JMenuItem item1 = new JMenuItem("Ouvrir");
	private JMenuItem item2 = new JMenuItem("Quitter");

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
		
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent event) { 
				int ligne=event.getY()/20;
				System.out.println(ligne);
				String a=(String) tableur.getValueAt( ligne, 2);
				Info p=new Info(a);
				
				
				
			} });
		
		
		
        
		javax.swing.table.TableColumnModel lModel = table.getColumnModel();
		table.setRowHeight( 20 );

		lModel.getColumn(0).setMaxWidth(70);
		lModel.getColumn(1).setMaxWidth(350);
		lModel.getColumn(2).setMaxWidth(350);
		lModel.getColumn(3).setMaxWidth(70);
		
		

		
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
				recupChemin[0]=recupChemin[0]+"/.git/objects";

				Rechercher finder = new Rechercher();
				finder.rechercheFichier(recupChemin[0]);
				
				
				setVisible(false);

			}        
		});
		item1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				setDefaultCloseOperation(0);

			}        
		});
		
		this.menuBar.add(test1);

		this.setJMenuBar(menuBar);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(20, 30);
		
		pack(); 
		setVisible(true); 
		////////////////////////////////////////////////////////////////////
			
	}


	

}
