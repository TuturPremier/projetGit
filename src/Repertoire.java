
import java.io.File;


public class Repertoire extends Tableur{
 
    private String initialpath = "";
    private Boolean recursivePath = false;
    public int filecount = 0;
    public int dircount = 0;
    

    public Repertoire(String path, Boolean subFolder) {
        super();
        this.initialpath = path;
        this.recursivePath = subFolder;
        new Tableur(); 
    }
 
    public void list() {
        this.listDirectory(this.initialpath);
    }
 
    private void listDirectory(String dir) {
        File file = new File(dir);
        File[] files = file.listFiles();
        if (files != null) {
            for (int i = 0; i < files.length; i++) {
                if (files[i].isDirectory() == true) {
                    //System.out.println("Dossier: " + files[i].getName());
                    tableur.setValueAt(files[i].getName(), i, this.dircount);
                    this.dircount++;
                } else {
                    //System.out.println("  Fichier: " + files[i].getName());
                    tableur.setValueAt(files[i].getName(), i, this.dircount);
                    this.filecount++;
                }
                if (files[i].isDirectory() == true && this.recursivePath == true) {
                    this.listDirectory(files[i].getAbsolutePath());
                }
            }
        }
    } 
    
}