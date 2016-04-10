package paquet;

import java.io.*;

import javax.swing.JOptionPane;

public class APropos {
	public APropos(){
		String chaine="";
		String fichier ="README.md";

		//lecture du fichier texte	
		try{
			InputStream ips=new FileInputStream(fichier); 
			InputStreamReader ipsr=new InputStreamReader(ips);
			BufferedReader br=new BufferedReader(ipsr);
			String ligne;
			while ((ligne=br.readLine())!=null){
				chaine+=ligne+"\n";
			}
			br.close(); 
		}		
		catch (Exception e){
			System.out.println(e.toString());
		}	
		
		JOptionPane jop1;
		//Boîte du message d'information
		jop1 = new JOptionPane();
		jop1.showMessageDialog(null,chaine, "AIDE", JOptionPane.PLAIN_MESSAGE);
	}

}
