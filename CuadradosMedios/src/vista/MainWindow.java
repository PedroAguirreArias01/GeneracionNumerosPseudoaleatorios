package vista;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import controller.Controller;
/**
 * 
 * @author pedro
 *
 */
public class MainWindow extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PanelTableCuadrado panelTableCuadrado;
	private PanelCongruencias panelCongruencias;
	private PanelDisNormal panelDisNormal;
	private PanelDisUniforme panelDisUniforme;
	private PanelCongruenciaMultiplicativa panelMultiplicativa;
	
	public MainWindow(Controller controller) {
		
		this.setJMenuBar(new MenuBar(controller));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Pseudoaleatorios");
		this.setSize(getMaximumSize());
		this.setLayout(new BorderLayout());
		
		panelTableCuadrado = new PanelTableCuadrado(controller);
		panelCongruencias = new PanelCongruencias(controller);
		panelDisNormal = new PanelDisNormal(controller);
		panelDisUniforme = new PanelDisUniforme(controller);
		panelMultiplicativa = new PanelCongruenciaMultiplicativa(controller);
		
		this.setVisible(true);
	}
	
	public void showPanelCuadradosMedios() {
		this.add(panelTableCuadrado, BorderLayout.CENTER);
		panelTableCuadrado.setVisible(true);
		panelDisNormal.setVisible(false);
		panelDisUniforme.setVisible(false);
		panelCongruencias.setVisible(false);
		panelMultiplicativa.setVisible(false);
		this.revalidate();
	}
	
	public void showPanelDisNormal() {
		this.add(panelDisNormal, BorderLayout.CENTER);
		panelTableCuadrado.setVisible(false);
		panelDisNormal.setVisible(true);
		panelDisUniforme.setVisible(false);
		panelCongruencias.setVisible(false);
		panelMultiplicativa.setVisible(false);
		this.revalidate();
	}
	
	public void showPanelDisuniforme() {
		this.add(panelDisUniforme, BorderLayout.CENTER);
		panelTableCuadrado.setVisible(false);
		panelDisNormal.setVisible(false);
		panelDisUniforme.setVisible(true);
		panelCongruencias.setVisible(false);
		panelMultiplicativa.setVisible(false);
		this.revalidate();
	}
	
	public void showPanelCongruencias() {
		this.add(panelCongruencias, BorderLayout.CENTER);
		panelTableCuadrado.setVisible(false);
		panelDisNormal.setVisible(false);
		panelDisUniforme.setVisible(false);
		panelCongruencias.setVisible(true);
		panelMultiplicativa.setVisible(false);
		this.revalidate();
	}
	
	public void showPanelMultiplicativo() {
		this.add(panelMultiplicativa, BorderLayout.CENTER);
		this.panelMultiplicativa.setVisible(true);
		panelTableCuadrado.setVisible(false);
		panelDisNormal.setVisible(false);
		panelDisUniforme.setVisible(false);
		panelCongruencias.setVisible(false);
		this.revalidate();
	}
	
	public void vectores(Object xi[], Object xi2[],Object largo[], Object extrae[], Object ri[], Object ni[], Object no[]) {
		this.panelTableCuadrado.vectores(xi, xi2, largo, extrae, ri, ni, no);
	}
	
	public int semilla() {
		return panelTableCuadrado.semilla();
	}
	
	public int caracteres() {
		return panelTableCuadrado.caracteres();
	}
	
	public int min() {
		return panelTableCuadrado.min();
	}

	public int max() {
		return panelTableCuadrado.max();
	}

	public int iteraciones() {
		return panelTableCuadrado.iteraciones();
	}
	
	public void addDataCongruencia(Object no[], Object xi[],Object ri[]) {
		this.panelCongruencias.vectores(no, xi, ri);
	}
	
	public int dataXi() {
		return panelCongruencias.dataXo();
	}
	
	public int dataK() {
		return panelCongruencias.dataK();
	}
	
	public int dataC() {
		return panelCongruencias.dataC();
	}

	public int dataG() {
		return panelCongruencias.dataG();
	}
	
	//----------------------distribucion normal
	
	public void addDataDsNormal(Object no[], Object ni[],Object intervalos[], Object frecuencia[]) {
		panelDisNormal.vectores(no, ni, intervalos, frecuencia);
	}
	
	public double dataMedia() {
		return panelDisNormal.dataMedia();
	}
	
	public double dataDesviacion() {
		return panelDisNormal.dataDesviacion();
	}
	
	public int dataIteraciones() {
		return panelDisNormal.dataIteraciones();
	}

	public int dataIntervalos() {
		return panelDisNormal.dataIntervalos();
	}
	
	//------------------------congruencia multiplicativa
	public void addConMultipli(Object i[], Object xi[],Object ri[]) {
		panelMultiplicativa.vectores(i, xi, ri);
	}
	
	public int dataXo() {
		return panelMultiplicativa.dataXo();
	}
	
	public int dataT() {
		return panelMultiplicativa.dataT();
	}
	
	public int dataD() {
		return panelMultiplicativa.dataD();
	}
	
	//-------------------Dis. uniforme
	
	public void addDisUniforme(Object xi[], Object ri[],Object ni[],Object no[], Object interInicial[], Object interfinal[], Object freObtenida[], Object freEsper[]) {
		panelDisUniforme.vectores(xi, ri, ni, no, interInicial, interfinal, freObtenida, freEsper);
	}
	
	public int cantidadNumeros() {
		return panelDisUniforme.cantidadNumeros();
	}
	
	public int interInicial() {
		return panelDisUniforme.interInicial();
	}
	
	public int interFinal() {
		return panelDisUniforme.interFinal();
	}
	
	public int numIntervalos() {
		return panelDisUniforme.numIntervalos();
	}

}
