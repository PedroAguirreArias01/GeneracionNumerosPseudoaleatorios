package logica.pruebas;

import javax.swing.JOptionPane;

public class PruebaChiCuadrado {

	private Object[] chi2;
	private TablaChiCuadrada tablaChiCuadrada;
	private double chi2Calculado;
	private double chi2Tabla;
	
	public PruebaChiCuadrado() {
		// TODO Auto-generated constructor stub
		this.tablaChiCuadrada = new TablaChiCuadrada();
	}
	
	public boolean calculoChi2(Object[] freObtenda, Object[] freEsperada) {
		this.chi2 = new Object[freObtenda.length];
		for (int i = 0; i < freEsperada.length; i++) {
			this.chi2[i] = Math.pow(((double)freObtenda[i]-(double)freEsperada[i]), 2)/(double)freEsperada[i];
		}
		for (int i = 0; i < chi2.length; i++) {
			chi2Calculado += (double)chi2[i];
		}
		System.out.println("vaalor Calculado chi2: "+this.chi2Calculado);
		String probabilidad = JOptionPane.showInputDialog("Por favor inserte la probabilidad");
		this.chi2Tabla = this.tablaChiCuadrada.chiInverso((float) Double.parseDouble(probabilidad), freEsperada.length);
		System.out.println("Valor Tabla Chi2: "+ this.chi2Tabla);
		if (this.chi2Tabla>this.chi2Calculado) {
			System.out.println("cumple");
			return true;
		}else {
			System.err.println("no cumple");
			return false;
		}
	}
	
	public Object[] getChi2() {
		return chi2;
	}
	
}
