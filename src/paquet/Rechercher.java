package paquet;


import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;



public class Rechercher extends Tableur {

	public Rechercher(){
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


				try {
					String[] commande = {"./interpreteur.sh", cleff};
					
					Process p = Runtime.getRuntime().exec(commande);
					
					AfficheurFlux fluxSortie = new AfficheurFlux(p.getInputStream());
					
					AfficheurFlux fluxErreur = new AfficheurFlux(p.getErrorStream());
					

					new Thread(fluxSortie).start();
					new Thread(fluxErreur).start();
					
					
					int truc=p.waitFor();
					System.out.println("aaaaa"+p);
					tableur.setValueAt(truc, aligneur, 2);
				} catch (IOException e) {
					e.printStackTrace();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}


				
				aligneur++;
			}

		}
	}


}
