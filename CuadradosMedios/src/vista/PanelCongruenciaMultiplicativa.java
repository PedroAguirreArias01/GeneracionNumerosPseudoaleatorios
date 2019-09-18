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
public class PanelCongruenciaMultiplicativa extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable congruencial;
	private DefaultTableModel defaultTableModel;
	private JTextField Xo;
	private JTextField t;
	private JTextField d;

	public PanelCongruenciaMultiplicativa(Controller controller) {
		// TODO Auto-generated constructor stub
		this.setLayout(new BorderLayout());
		
		JPanel panelContentTable = new JPanel();
		panelContentTable.setOpaque(false);
		panelContentTable.setLayout(new GridLayout(1, 1));
		this.add(panelContentTable, BorderLayout.CENTER);
		
		congruencial = new JTable();
		
		JScrollPane scrollPane = new JScrollPane(congruencial);
		panelContentTable.add(scrollPane);
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1, 4));
		panel.setBorder(BorderFactory.createTitledBorder("Metodo Congruencia Multiplicativo"));
		this.add(panel, BorderLayout.NORTH);
		
		JLabel semiJLabel = new JLabel("Xo");
		panel.add(semiJLabel);
		this.Xo = new JTextField();
		panel.add(Xo);
		
		JLabel semiJLabel1 = new JLabel("t");
		panel.add(semiJLabel1);
		this.t = new JTextField();
		panel.add(t);
		
		JLabel semiJLabel2 = new JLabel("d");
		panel.add(semiJLabel2);
		this.d = new JTextField();
		panel.add(d);
		
		JButton jButton = new JButton("Calcular");
		jButton.addActionListener(controller);
		jButton.setActionCommand(Acciones.CAL_CONG_MULTI.name());
		panel.add(jButton);
	}
	
	public void vectores(Object i[], Object xi[],Object ri[]) {
		defaultTableModel = new DefaultTableModel();
		congruencial.setModel(defaultTableModel);
		this.defaultTableModel.addColumn("#", i);
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
	
	public int dataT() {
		if (t.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Debe Agregar una entrada t");
		}else {
			return Integer.valueOf(t.getText());
		}
		return 0;
	}
	
	public int dataD() {
		if (d.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Debe Agregar un valor d");
		}else {
			return Integer.valueOf(d.getText());
		}
		return 0;
	}
	
	
}
