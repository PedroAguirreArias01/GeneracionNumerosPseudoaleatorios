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
public class PanelDisUniforme extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable disUniforme;
	private DefaultTableModel defaultTableModel;
	private JTextField cantidadNumeros;
	private JTextField intervaloInicial;
	private JTextField intervaloFinal;
	private JTextField numeroIntervalos;

	public PanelDisUniforme(Controller controller) {
		// TODO Auto-generated constructor stub
		this.setLayout(new BorderLayout());

		JPanel panelContentTable = new JPanel();
		panelContentTable.setOpaque(false);
		panelContentTable.setLayout(new GridLayout(1, 1));
		this.add(panelContentTable, BorderLayout.CENTER);

		disUniforme = new JTable();

		JScrollPane scrollPane = new JScrollPane(disUniforme);
		panelContentTable.add(scrollPane);

		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1, 5));
		panel.setBorder(BorderFactory.createTitledBorder("Distribución. Uniforme"));
		this.add(panel, BorderLayout.CENTER);

		JLabel semiJLabel = new JLabel("Cantidad números");
		panel.add(semiJLabel);
		this.cantidadNumeros = new JTextField();
		panel.add(cantidadNumeros);

		JLabel semiJLabel1 = new JLabel("Intervalo inicial");
		panel.add(semiJLabel1);
		this.intervaloInicial = new JTextField();
		panel.add(intervaloInicial);

		JLabel semiJLabel2 = new JLabel("Intervalo final");
		panel.add(semiJLabel2);
		this.intervaloFinal = new JTextField();
		panel.add(intervaloFinal);

		JLabel semiJLabel3 = new JLabel("numero de intervalos");
		panel.add(semiJLabel3);
		this.numeroIntervalos = new JTextField();
		panel.add(numeroIntervalos);
		
		JButton jButton = new JButton("Calcular");
		jButton.addActionListener(controller);
		jButton.setActionCommand(Acciones.CAL_DIS_UNIFORME.name());
		panel.add(jButton);

	}

	public void vectores(Object xi[], Object ri[], Object ni[], Object no[], Object interInicial[], Object interfinal[],
		Object freObtenida[], Object freEsper[]) {
		defaultTableModel = new DefaultTableModel();
		disUniforme.setModel(defaultTableModel);
		this.defaultTableModel.addColumn("#", xi);
		this.defaultTableModel.addColumn("Xi", ri);
		this.defaultTableModel.addColumn("Ni", ni);
		this.defaultTableModel.addColumn("No", no);
		this.defaultTableModel.addColumn("Inter. Inicial", interInicial);
		this.defaultTableModel.addColumn("Inter. Final", interfinal);
		this.defaultTableModel.addColumn("Fre. Obtenida", freObtenida);
		this.defaultTableModel.addColumn("Fre. Esperada", freEsper);
	}

	public int cantidadNumeros() {
		if (cantidadNumeros.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Debe Agregar Una Cantidad de numeros a generar");
		} else {
			return Integer.valueOf(cantidadNumeros.getText());
		}
		return 0;
	}

	public int interInicial() {
		if (intervaloInicial.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Debe Agregar un intevalo inicial");
		} else {
			return Integer.valueOf(intervaloInicial.getText());
		}
		return 0;
	}

	public int interFinal() {
		if (intervaloFinal.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Debe Agregar un intervalo final");
		} else {
			return Integer.valueOf(intervaloFinal.getText());
		}
		return 0;
	}

	public int numIntervalos() {
		if (numeroIntervalos.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Debe Agregar un número de intervalos a generar");
		} else {
			return Integer.valueOf(numeroIntervalos.getText());
		}
		return 0;
	}

}
