package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
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

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import controller.Acciones;
import controller.Controller;
/**
 * 
 * @author pedro
 *
 */
public class PanelDisNormal extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable disNormal;
	private DefaultTableModel defaultTableModel;
	private JTextField media;
	private JTextField desviacion;
	private JTextField iteraciones;
	private JTextField intervalos;
	private DefaultCategoryDataset dataset;
	private JPanel panelContent;
	

	public PanelDisNormal(Controller controller) {
		// TODO Auto-generated constructor stub
		this.setLayout(new BorderLayout());
		
		JPanel panelContentTable = new JPanel();
		panelContentTable.setOpaque(false);
		panelContentTable.setLayout(new GridLayout(1, 1));
		this.add(panelContentTable, BorderLayout.CENTER);
		
		disNormal = new JTable();
		
		JScrollPane scrollPane = new JScrollPane(disNormal);
		panelContentTable.add(scrollPane);
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1, 4, 5, 5));
		panel.setBorder(BorderFactory.createTitledBorder("Metodo Distribución Normal"));
		this.add(panel, BorderLayout.NORTH);
		
		JLabel semiJLabel = new JLabel("Media de los datos");
		panel.add(semiJLabel);
		this.media = new JTextField();
		panel.add(media);
		
		JLabel semiJLabel1 = new JLabel("Desviación de los datos");
		panel.add(semiJLabel1);
		this.desviacion = new JTextField();
		panel.add(desviacion);
		
		JLabel semiJLabel2 = new JLabel("Número de iteraciones");
		panel.add(semiJLabel2);
		this.iteraciones = new JTextField();
		panel.add(iteraciones);
		
		JLabel semiJLabel3 = new JLabel("Número de intervalos");
		panel.add(semiJLabel3);
		this.intervalos = new JTextField();
		panel.add(intervalos);
		
		JButton jButton = new JButton("Calcular");
		jButton.addActionListener(controller);
		jButton.setActionCommand(Acciones.CAL_DIS_NORMAL.name());
		panel.add(jButton);
		
		
	}
	
	public void vectores(Object no[], Object ni[],Object intervalos[], Object frecuencia[]) {
		defaultTableModel = new DefaultTableModel();
		disNormal.setModel(defaultTableModel);
		this.defaultTableModel.addColumn("Valores Ni Normalizados ", ni);
		this.defaultTableModel.addColumn("#", no);
		this.defaultTableModel.addColumn("Intervalos", intervalos);
		this.defaultTableModel.addColumn("Frecuencias", frecuencia);
		//grafica
		dataset = new DefaultCategoryDataset();
		for (int i = 0; i < frecuencia.length; i++) {
			dataset.setValue((int)frecuencia[i],String.valueOf(i), String.valueOf(intervalos[i]));
		}
		 JFreeChart chart=ChartFactory.createBarChart(
			        "Distribución normal estandar", //Chart Title
			        "Valores", // Category axis
			        "Frecuencia", // Value axis
			        dataset,
			        PlotOrientation.VERTICAL,
			        true,true,false
			       );

			    ChartPanel chartPanel =new ChartPanel(chart);
			    this.add(chartPanel, BorderLayout.EAST);
			    this.revalidate();
	}
	
	public double dataMedia() {
		if (media.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Debe agregar la media");
		}else {
			return Double.valueOf(media.getText());
		}
		return 0;
	}
	
	public double dataDesviacion() {
		if (desviacion.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Debe Agregar una desviación");
		}else {
			return Double.valueOf(desviacion.getText());
		}
		return 0;
	}
	
	public int dataIteraciones() {
		if (this.iteraciones.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Debe Agregar el número de Iteraciones");
		}else {
			return Integer.valueOf(this.iteraciones.getText());
		}
		return 0;
	}
	
	public int dataIntervalos() {
		if (intervalos.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Debe agregar un número de intervalos");
		}else {
			System.out.println("Intervalos: "+intervalos.getText());
			return Integer.valueOf(intervalos.getText());
		}
		return 0;
	}


}
