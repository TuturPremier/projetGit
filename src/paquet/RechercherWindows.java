package paquet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.zip.InflaterInputStream;;

public class RechercherWindows extends Tableur {
	public RechercherWindows(){
		super();
	}
	public  void rechercheFichier(String directoryPath) throws IOException {
		File directory = new File(directoryPath);
		File[] fichier = directory.listFiles();

		int aligneur=0;

		for(int i=0 ; i<fichier.length; i++){
			File[] interfichier = fichier[i].listFiles();
			tableur.setValueAt(fichier[i].getName(), aligneur, 0);



			for(int j=0 ; j<interfichier.length; j++){
				String cleff;

				cleff=fichier[i].getName()+interfichier[j].getName();
				File chacha= new File(interfichier[j].getPath());

				tableur.setValueAt(interfichier[j].getName(), aligneur, 1);
				tableur.setValueAt(cleff, aligneur, 2);

				
				/////////////////////////////////////////////////////////////////////
				FileInputStream fichier1 = new FileInputStream(chacha);

				InflaterInputStream decompresser = new InflaterInputStream(fichier1);

				ArrayList<Byte> LectureFichier = new ArrayList();
				int caract;

				try {
					while((caract = decompresser.read()) != -1){
						LectureFichier.add( (byte)caract );
					}
				}
				catch(IOException e) {
					throw new IOException("fichier "+chacha.getName()+" : "+e.getMessage());
				}

				Byte[] coder=LectureFichier.toArray(new Byte[0]); 
				StringBuilder content = new StringBuilder();

				int i1 = 0;
				char c;
				while(i1 < coder.length) {

					c = (char)coder[i1].byteValue();
					content.append(c);
					i1++;
				}
				String[] z=content.toString().split(" ");
				
				/////////////////////////////////////////////////////////////////
				tableur.setValueAt(z[0], aligneur, 3);


				aligneur++;
			}

		}
		
	}

}
