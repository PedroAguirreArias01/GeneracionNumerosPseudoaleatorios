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
public class PanelTableCuadrado extends JPanel{
	
	private JTable cuadrosMedios;
	private DefaultTableModel defaultTableModel;
	private JTextField semilla;
	private JTextField numeroExtraer;
	private JTextField min;
	private JTextField max;
	private JTextField iteraciones;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public PanelTableCuadrado(Controller controller) {
		// TODO Auto-generated constructor stub
		this.setLayout(new BorderLayout());
		
		JPanel panelContentTable = new JPanel();
		panelContentTable.setOpaque(false);
		panelContentTable.setLayout(new GridLayout(1, 1));
		this.add(panelContentTable, BorderLayout.CENTER);
		
		
		//defaultTableModel.setColumnIdentifiers(headTable);
		
		cuadrosMedios = new JTable();
		
		JScrollPane scrollPane = new JScrollPane(cuadrosMedios);
		panelContentTable.add(scrollPane);
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1, 6));
		panel.setBorder(BorderFactory.createTitledBorder("Cuadrados Medios"));
		this.add(panel, BorderLayout.NORTH);
		
		JLabel semiJLabel = new JLabel("Semilla");
		panel.add(semiJLabel);
		this.semilla = new JTextField();
		panel.add(semilla);
		
		JLabel semiJLabel1 = new JLabel("# digitos a extraer");
		panel.add(semiJLabel1);
		this.numeroExtraer = new JTextField();
		panel.add(numeroExtraer);
		
		JLabel semiJLabel2 = new JLabel("Intervalo inicial");
		panel.add(semiJLabel2);
		this.min = new JTextField();
		panel.add(min);
		
		JLabel semiJLabel3 = new JLabel("Intervalo final");
		panel.add(semiJLabel3);
		this.max = new JTextField();
		panel.add(max);
		
		JLabel semiJLabel4 = new JLabel("# Iteraciones");
		panel.add(semiJLabel4);
		this.iteraciones = new JTextField();
		panel.add(iteraciones);
		
		JButton jButton = new JButton("Calcular");
		jButton.addActionListener(controller);
		jButton.setActionCommand(Acciones.CAL_CUDRADO.name());
		panel.add(jButton);
	}
	
	public void vectores(Object xi[], Object xi2[],Object largo[], Object extrae[], Object ri[], Object ni[], Object no[]) {
		defaultTableModel = new DefaultTableModel();
		cuadrosMedios.setModel(defaultTableModel);
		this.defaultTableModel.addColumn("#", no);
		this.defaultTableModel.addColumn("Xi", xi);
		this.defaultTableModel.addColumn("Xi^2", xi2);
		this.defaultTableModel.addColumn("Largo", largo);
		this.defaultTableModel.addColumn("Extrae", extrae);
		this.defaultTableModel.addColumn("Ri", ri);
		this.defaultTableModel.addColumn("Ni", ni);
	}
	
	public int semilla() {
		if (semilla.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Debe Agregar Una semilla");
		}else {
			return Integer.valueOf(semilla.getText());
		}
		return 0;
	}
	
	public int caracteres() {
		if (numeroExtraer.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Debe Agregar los digitos a extraer");
		}else {
			return Integer.valueOf(numeroExtraer.getText());
		}
		return 0;
	}
	
	public int min() {
		if (min.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Debe Agregar el minimo del intervalo");
		}else {
			return Integer.valueOf(min.getText());
		}
		return 0;
	}
	
	public int max() {
		if (max.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Debe Agregar el Maximo del intervalo");
		}else {
			return Integer.valueOf(max.getText());
		}
		return 0;
	}

	public int iteraciones() {
		if (iteraciones.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Debe Agregar el numero de iteraciones");
		}else {
			return Integer.valueOf(iteraciones.getText());
		}
		return 0;
	}
	
}
