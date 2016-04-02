package paquet;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
				tableur.setValueAt(cleff, aligneur, 2);


				try {
					String[] commande = {"./interpreteur.sh", cleff};

					Process p = Runtime.getRuntime().exec(commande);

					AfficheurFlux fluxSortie = new AfficheurFlux(p.getInputStream());

					AfficheurFlux fluxErreur = new AfficheurFlux(p.getErrorStream());


					new Thread(fluxSortie).start();
					new Thread(fluxErreur).start();


					p.waitFor();
					
					
				} catch (IOException e) {
					e.printStackTrace();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				File f= new File("ObjectType");
				try {
					FileReader fr= new FileReader(f);
					try {
						int c =fr.read();
						
						if(c==98){
							tableur.setValueAt("blob", aligneur, 3);
						}
						else if(c==99){
							tableur.setValueAt("commit", aligneur, 3);
						}
						else if(c==116){
							tableur.setValueAt("tree", aligneur, 3);
						}
						
						fr.close();
						
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				


				
				aligneur++;
			}

		}
	}


}
