package paquet;
import java.io.File;

import javax.swing.JOptionPane;

public class Rechercher extends Tableur {
	

	public Rechercher() {
		super();
	}

	public  void findFiles(String directoryPath) {
		File directory = new File(directoryPath);
		File[] sousfichiers = directory.listFiles();

		int aligneur=0;

		for(int i=0 ; i<sousfichiers.length; i++){
			File[] interfichier = sousfichiers[i].listFiles();
			for(int j=0 ; j<interfichier.length; j++){
				tableur.setValueAt(sousfichiers[i].getName(), aligneur, 0);
				tableur.setValueAt(interfichier[j].getName(), aligneur, 1);
				aligneur++;

			}
		}
	}
}
