package paquet;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;

public class Info {
	public Info(String ligne, String type){
		String resultat= new String();
		
		try {
			String[] commande = {"./informateur.sh", ligne};

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
		
		File f= new File("RecupCommande");
		try {
			FileReader fr= new FileReader(f);
			try {
				int c =fr.read();
				
				
				while (c != -1)
			    {
					resultat=resultat+(char) c;
			        //System.out.print ((char) c);
			        c = fr.read();
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
		
		
		
		
		
		
		
		JOptionPane jop1;
		//Boîte du message d'information
		jop1 = new JOptionPane();
		jop1.showMessageDialog(null, resultat, "Information>>>"+type, JOptionPane.PLAIN_MESSAGE);
	}

}
