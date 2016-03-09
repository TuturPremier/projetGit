/**
* Exemple : lister les fichiers dans tous les sous-dossiers
* @param args
*/

public class lancement {
	public static void main(String[] args) {
		  String pathToExplore = "/home/tdelorme/Desktop/toto";
		  Repertoire repertoire = new Repertoire(pathToExplore, true);
		  Long start = System.currentTimeMillis();
		  repertoire.list();
		  
		}
}

