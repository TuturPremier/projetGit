package paquet;

import java.io.File;

import javax.swing.JFileChooser;

public class Lanceur {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
		//recupChemin[0]=recupChemin[0]+"/test";
		
		Rechercher finder = new Rechercher();
		finder.findFiles(recupChemin[0]);

	}

}
