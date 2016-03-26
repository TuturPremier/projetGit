package paquet;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.event.TableModelListener;
import javax.swing.event.TableModelEvent;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.text.DecimalFormat;

public class Tableur extends JFrame implements TableModelListener {
	JTable table;
	DefaultTableModel tableur;

	public Tableur() { 
		tableur = new  DefaultTableModel();
		tableur.addColumn("dossier");
		tableur.addColumn("fichier");
		
		tableur.setRowCount(50);

		table = new JTable(tableur);
		table.setPreferredScrollableViewportSize(new Dimension(300, 200));
		add(new JScrollPane(table), BorderLayout.CENTER);
		tableur.addTableModelListener(this);
		

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(200, 300);
		pack(); 
		setVisible(true); 
		////////////////////////////////////////////////////////////////////
		
		
		
	}

	@Override
	public void tableChanged(TableModelEvent arg0) {
		// TODO Auto-generated method stub
		
		
	}
	
	
	

} 