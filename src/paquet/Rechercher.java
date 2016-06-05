package paquet;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.zip.InflaterInputStream;

import javax.swing.JOptionPane;;

public class Rechercher extends Tableur {
	public Rechercher(){
		super();
	}
	public  void rechercheFichier(String directoryPath) throws IOException {
		File directory = new File(directoryPath);
		File[] fichier = directory.listFiles();

		int aligneur=0;

		for(int i=0 ; i<fichier.length; i++){//ICI LE -1 POUR NE PAS PRENDRE LE PACK
			File[] interfichier = fichier[i].listFiles();//interfichier liste les sous fichiers de fichier
			tableur.setValueAt(fichier[i].getName(), aligneur, 0);
			
			
			if(fichier[i].getName().equals("pack")){
				
			}

			for(int j=0 ; j<interfichier.length; j++){


				File file= new File(interfichier[j].getPath());

				tableur.setValueAt(interfichier[j].getName(), aligneur, 1);
				tableur.setValueAt(file, aligneur, 2);//permet de stocker le chemin (utile pour la partie information)

				//decompression et remplisage de la table (colone 2 et 3)
				/////////////////////////////////////////////////////////////////////
				FileInputStream fichier1 = new FileInputStream(file);

				InflaterInputStream decompresser = new InflaterInputStream(fichier1);

				ArrayList<Byte> LectureFichier = new ArrayList();
				int caract;

				try {
					while((caract = decompresser.read()) != -1){
						LectureFichier.add( (byte)caract );
					}
				}
				catch(IOException e) {
					throw new IOException("fichier "+file.getName()+" : "+e.getMessage());
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

				String[] z=content.toString().split(" ");//permet de recuper le premier mot qui correspont au type

				/////////////////////////////////////////////////////////////////
				tableur.setValueAt(z[0], aligneur, 3);


				aligneur++;
			}

		}

		table.addMouseListener(new MouseAdapter() {

			//decompression egalement par rapport à la colonne 2 

			public void mouseClicked(MouseEvent event) { 
				int ligne=event.getY()/20;

				File file=(File) tableur.getValueAt( ligne, 2);


				FileInputStream fichier1 = null;
				try {
					fichier1 = new FileInputStream(file);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				InflaterInputStream decompresser = new InflaterInputStream(fichier1);

				ArrayList<Byte> LectureFichier = new ArrayList();
				int caract;

				try {
					while((caract = decompresser.read()) != -1){
						LectureFichier.add( (byte)caract );
					}
				}
				catch(IOException e) {
					try {
						throw new IOException("fichier "+file.getName()+" : "+e.getMessage());
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
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

				////FENETRE POP UP/////

				JOptionPane jop1;
				jop1 = new JOptionPane();
				jop1.showMessageDialog(null, content, "<<<Information>>>", JOptionPane.PLAIN_MESSAGE);

			} });

	}

}
