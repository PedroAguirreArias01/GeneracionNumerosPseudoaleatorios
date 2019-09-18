package logica;

import java.util.Arrays;

import org.apache.commons.math3.distribution.NormalDistribution;

/**
 * 
 * @author pedro
 *
 */
public class DisNormal {

	private NormalDistribution disNormal;
	private int iteraciones;
	private int numIntervalos;
	private Object[] Ni;
	private Object[] intervalos;
	private Object[] frecuencia;
	private Object[] No;
	
	private double min;
	private double max;
	
	public DisNormal() {
		// TODO Auto-generated constructor stub
	}
	
	public void init(double media, double desviacion, int iteraciones, int intervalos) {
		this.iteraciones = iteraciones;
		this.numIntervalos = intervalos;
		this.disNormal = new NormalDistribution(media, desviacion);
		this.Ni = new Object[iteraciones];
		this.intervalos = new Object[numIntervalos];
		this.frecuencia = new Object[numIntervalos];
		this.No = new Object[numIntervalos];
	}
	
	public void obtenerNi() {
		for (int i = 0; i < this.iteraciones; i++) {
			this.Ni[i] = disNormal.sample();
			System.out.println(disNormal.sample());
		}
		minMax();
		calcularInervalos();
	}
	
	public void minMax() {
		Object aux[] = this.Ni;
		Arrays.sort(aux);
		this.min = (double) aux[0];
		this.max = (double) aux[aux.length-1];
		System.err.println("Min: "+this.min);
		System.err.println("max: "+this.max);
	}
	
	public void calcularInervalos() {
		this.intervalos[0] = this.min;
		double aux = this.min;
		System.out.println(aux);
		for (int i = 1; i < numIntervalos; i++) {
			aux = aux+(this.max-this.min)/numIntervalos;
			this.intervalos[i] = aux;
			System.out.println(aux);
		}
		calculateFrecuenci();
	}
	
	public void calculateFrecuenci() {
		Arrays.sort(intervalos);
		Arrays.sort(Ni);
		int auxCont = 1;
		for (int i = 0; i < intervalos.length; i++) {
			int contador = 0;
			this.No[i] = i;
			for (int j = 0; j < Ni.length; j++) {
				if ((double)Ni[j] >= (double)intervalos[i] && (double)Ni[j] <= (double)intervalos[auxCont]) {
					contador++;
				}
			}
			auxCont++;
			if (auxCont == intervalos.length) {
				auxCont = intervalos.length-1;
			}
			System.out.println(contador);
			frecuencia[i] = contador;
		}
	}

	public Object[] getNi() {
		return Ni;
	}

	public void setNi(Object[] ni) {
		Ni = ni;
	}

	public Object[] getIntervalos() {
		return intervalos;
	}

	public void setIntervalos(Object[] intervalos) {
		this.intervalos = intervalos;
	}

	public Object[] getFrecuencia() {
		return frecuencia;
	}

	public void setFrecuencia(Object[] frecuencia) {
		this.frecuencia = frecuencia;
	}

	public Object[] getNo() {
		return No;
	}

	public void setNo(Object[] no) {
		No = no;
	}
	
}
