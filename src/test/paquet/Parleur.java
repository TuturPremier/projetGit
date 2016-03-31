package paquet;


import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

class AfficheurFlux implements Runnable {

	private final InputStream inputStream;

	AfficheurFlux(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	private BufferedReader getBufferedReader(InputStream is) {
		return new BufferedReader(new InputStreamReader(is));
	}

	@Override
	public void run() {
		BufferedReader br = getBufferedReader(inputStream);
		String ligne = "";
		try {
			while ((ligne = br.readLine()) != null) {
				System.out.println(ligne);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

public class Parleur extends Tableur {

	public Parleur(){
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
					String[] commande = {"./interpreteur.sh", "827e"};
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


				tableur.setValueAt(cleff, aligneur, 2);
				aligneur++;
			}

		}
	}


}
