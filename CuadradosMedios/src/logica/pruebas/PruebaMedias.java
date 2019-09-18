package logica.pruebas;

import java.util.Arrays;
/**
 * 
 * @author pedro
 *
 */
public class PruebaMedias {

	private double promedio;
	private static final double Z = 1.96; 
	
	private double limiteInferior;
	private double limiteSuperior;
	
	private double min;
	private double max;

	private Object[] niNormalizados;
	
	public boolean calcularPrueba(Object[] ri) {
		this.niNormalizados = new Object[ri.length];
		calcularNiNormalizados(ri);
		calcularPromedio(niNormalizados);
		 this.limiteInferior=(double) ((0.5)-(Z*(1/(Math.sqrt(niNormalizados.length*12)))));
	     this.limiteSuperior=(double) ((0.5)+(Z*(1/Math.sqrt(niNormalizados.length*12))));
	     return (this.promedio>this.limiteInferior)&&(this.promedio<this.limiteSuperior);
	}
	
	public void calcularNiNormalizados(Object[] ri) {
		calcularMinMax(ri);
		for (int i = 0; i < ri.length; i++) {
			niNormalizados[i] = ((double)ri[i]-this.min)/(this.max-this.min);
		}
	}

	private void calcularPromedio(Object[] normalizados) {
		// TODO Auto-generated method 
		for (int i = 0; i < normalizados.length; i++) {
			this.promedio += (double)normalizados[i];
		}
		this.promedio = this.promedio/normalizados.length;
	}

	private void calcularMinMax(Object[] ri) {
		Object[] listAux = ri;
		Arrays.sort(listAux);
		this.min = (double)listAux[0];
		this.max = (double) listAux[listAux.length-1];
	}
	
}
