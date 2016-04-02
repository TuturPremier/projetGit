package paquet;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;



public class Tableur extends JFrame implements TableModelListener {
	JTable table;
	DefaultTableModel tableur;
	
	

	public Tableur() { 
		tableur = new  DefaultTableModel();
		
		tableur.addColumn("DOSSIER");
		tableur.addColumn("FICHIER");
		tableur.addColumn("CLEF");
		tableur.addColumn("TYPE");
		
		tableur.setRowCount(500);

		table = new JTable(tableur);
		table.setPreferredScrollableViewportSize(new Dimension(840, 500));
		add(new JScrollPane(table), BorderLayout.CENTER);
		tableur.addTableModelListener(this);
		
		javax.swing.table.TableColumnModel lModel = table.getColumnModel();

		lModel.getColumn(0).setMaxWidth(70);
		lModel.getColumn(1).setMaxWidth(350);
		lModel.getColumn(2).setMaxWidth(350);
		lModel.getColumn(3).setMaxWidth(70);
		

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(20, 30);
		
		pack(); 
		setVisible(true); 
		////////////////////////////////////////////////////////////////////
		
		
		
	}

	@Override
	public void tableChanged(TableModelEvent arg0) {
		// TODO Auto-generated method stub
		
		
	}

}
