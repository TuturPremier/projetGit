package paquet;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Lanceur {
	public static void main(String[] args) {
		JFileChooser dialogue = new JFileChooser(new File("Users"));
		String chemin = null;
		File fichier;
		String[] recupChemin = null;

		if (dialogue.showOpenDialog(null)== JFileChooser.APPROVE_OPTION) {
			fichier = dialogue.getSelectedFile();
			chemin = fichier.getPath();
			recupChemin = chemin.split("clique ici");
			//System.out.println(fichier.getPath());
			
		}
		recupChemin[0]=recupChemin[0]+"/.git/objects";
		
		
		Rechercher finder = new Rechercher();
		finder.findFiles(recupChemin[0]);
	}
}
///   copier-coller ce chemin     Users/theodelorme/projetGit/.git/objects
