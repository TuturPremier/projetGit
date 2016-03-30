package paquet;

import java.io.File;

public class Rechercher extends Tableur {
	public Rechercher() {
		super();
	}

	public  void findFiles(String directoryPath) {
		File directory = new File(directoryPath);
		File[] fichier = directory.listFiles();

		int aligneur=0;

		for(int i=0 ; i<fichier.length; i++){
			File[] interfichier = fichier[i].listFiles();
			tableur.setValueAt(fichier[i].getName(), aligneur, 0);
			
			
			
			for(int j=0 ; j<interfichier.length; j++){
				String cleff;
				
				cleff=fichier[i].getName()+interfichier[j].getName();
				
				tableur.setValueAt(interfichier[j].getName(), aligneur, 1);
				tableur.setValueAt(cleff, aligneur, 2);
				aligneur++;
			}

		}
	}
}


