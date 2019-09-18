package vista;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controller.Acciones;
import controller.Controller;
/**
 * 
 * @author pedro
 *
 */
public class PanelCongruencias extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable congruencial;
	private DefaultTableModel defaultTableModel;
	private JTextField Xo;
	private JTextField k;
	private JTextField c;
	private JTextField g;
	
	public PanelCongruencias(Controller controller) {
		// TODO Auto-generated constructor stub
		this.setLayout(new BorderLayout());
		
		JPanel panelContentTable = new JPanel();
		panelContentTable.setLayout(new GridLayout(1, 1));
		panelContentTable.setOpaque(false);
		this.add(panelContentTable, BorderLayout.CENTER);
		
		
		//defaultTableModel.setColumnIdentifiers(headTable);
		
		congruencial = new JTable();
		
		JScrollPane scrollPane = new JScrollPane(congruencial);
		panelContentTable.add(scrollPane);
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1, 5));
		panel.setBorder(BorderFactory.createTitledBorder("Metodo Congruencia lineal"));
		this.add(panel, BorderLayout.NORTH);
		
		JLabel semiJLabel = new JLabel("Xo");
		panel.add(semiJLabel);
		this.Xo = new JTextField();
		panel.add(Xo);
		
		JLabel semiJLabel1 = new JLabel("K");
		panel.add(semiJLabel1);
		this.k = new JTextField();
		panel.add(k);
		
		JLabel semiJLabel2 = new JLabel("C");
		panel.add(semiJLabel2);
		this.c = new JTextField();
		panel.add(c);
		
		JLabel semiJLabel3 = new JLabel("G");
		panel.add(semiJLabel3);
		this.g = new JTextField();
		panel.add(g);
		
		JButton jButton = new JButton("Calcular");
		jButton.addActionListener(controller);
		jButton.setActionCommand(Acciones.CAL_CONGRUENCIAS.name());
		panel.add(jButton);
	}
	
	public void vectores(Object no[], Object xi[],Object ri[]) {
		defaultTableModel = new DefaultTableModel();
		congruencial.setModel(defaultTableModel);
		this.defaultTableModel.addColumn("#", no);
		this.defaultTableModel.addColumn("Xi", xi);
		this.defaultTableModel.addColumn("Ri", ri);
	}
	
	public int dataXo() {
		if (Xo.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Debe agregar una entrada Xo");
		}else {
			return Integer.valueOf(Xo.getText());
		}
		return 0;
	}
	
	public int dataK() {
		if (k.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Debe Agregar una entrada K");
		}else {
			return Integer.valueOf(k.getText());
		}
		return 0;
	}
	
	public int dataC() {
		if (c.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Debe Agregar un valor C");
		}else {
			return Integer.valueOf(c.getText());
		}
		return 0;
	}
	
	public int dataG() {
		if (g.getText().equals(" ")) {
			JOptionPane.showMessageDialog(this, "Debe agregar un valor g");
		}else {
			return Integer.valueOf(g.getText());
		}
		return 0;
	}

}
