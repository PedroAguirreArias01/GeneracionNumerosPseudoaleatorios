package logica;

import java.util.Arrays;
import java.util.Random;
/**
 * 
 * @author pedro
 *
 */
public class DisUniforme {

	private int cantNumeros;
	private int intervaloInicial;
	private int intervaloFinal;
	
	//vectores
	private Object[] Ri;
	private Object[] Ni;
	private Object[] listIntervaloInicial;
	private Object[] listIntervaloFinal;
	private Object[] freObtenida;
	private Object[] freEsperada;
	
	private Object[] No;
	private Object[] xi;
	
	private double min;
	private double max;
	private int numeroIntervalos;
	
	public DisUniforme() {
		// TODO Auto-generated constructor stub
	}
	
	public void init(int cantNumeros, int intervaloInicial, int intervaloFinal, int numeroIntervalos) {
		this.cantNumeros = cantNumeros;
		this.intervaloInicial = intervaloInicial;
		this.intervaloFinal = intervaloFinal;
		this.Ri = new Object[cantNumeros];
		this.numeroIntervalos = numeroIntervalos;
		this.listIntervaloInicial = new Object[numeroIntervalos];
		this.listIntervaloFinal = new Object[numeroIntervalos];
		this.freObtenida = new Object[numeroIntervalos];
		this.freEsperada = new Object[numeroIntervalos];
		this.xi = new Object[cantNumeros];
		this.No = new Object[numeroIntervalos];
		this.Ni = new Object[cantNumeros];
	}
	
	public void calcularRi() {
        Random random = new Random();
		for (int i = 0; i < cantNumeros; i++) {
			this.Ri[i] = random.nextDouble();
			this.xi[i] = i;
		}
	}
	
	public void calcularNi() {
        for (int i = 0; i < cantNumeros; i++) {
            this.Ni[i] = intervaloInicial + (intervaloFinal - intervaloInicial) * (double)Ri[i];
        }
	}
	
	public void calculoIntervaloInicialFinal() {
		double auxIntervaloInicial = this.min;
		double auxIntervaloFinal = 0;
		this.listIntervaloInicial[0] = auxIntervaloInicial;
		auxIntervaloFinal = auxIntervaloInicial+(this.max -this.min)/numeroIntervalos;
		this.listIntervaloFinal[0] = auxIntervaloFinal;
		for (int i = 1; i < numeroIntervalos; i++) {
			System.out.println("jajajaja");
			auxIntervaloInicial = auxIntervaloFinal;
			this.listIntervaloInicial[i] = auxIntervaloInicial;
			auxIntervaloFinal = auxIntervaloInicial+(this.max -this.min)/numeroIntervalos;
			this.listIntervaloFinal[i] = auxIntervaloFinal;
		}
	}
	
	public void calculoMInMax() {
		Object[] listAux = Ni;
		Arrays.sort(listAux);
		this.min = (double) listAux[0];
		this.max = (double)listAux[listAux.length-1];
	}
	
	public void calculoFrecuenciaObtenida() {
		Arrays.sort(listIntervaloFinal);
		Arrays.sort(Ni);
		int auxCont = 1;
		for (int i = 0; i < listIntervaloFinal.length; i++) {
			int contador = 0;
			for (int j = 0; j < Ni.length; j++) {
				if ((double)Ni[j] >= (double)listIntervaloFinal[i] && (double)Ni[j] <= (double)listIntervaloFinal[auxCont]) {
					contador++;
				}
			}
			auxCont++;
			if (auxCont == listIntervaloFinal.length) {
				auxCont = listIntervaloFinal.length-1;
			}
			System.out.println(contador);
			this.freObtenida[i] = contador;
		}
		int tootalFrecuencia = 0;
		for (int j = 0; j < freObtenida.length; j++) {
			tootalFrecuencia += (int)freObtenida[j];
		}
		System.out.println("Frecue: "+tootalFrecuencia);
	}
	
	public void calculoFrecuenciaEsperada() {
		for (int i = 0; i < numeroIntervalos; i++) {
			this.freEsperada[i] = (double)cantNumeros/numeroIntervalos;
			this.No[i] = i;
		}
	}
	
	public void calcular() {
		calcularRi();
		calcularNi();
		calculoMInMax();
		calculoIntervaloInicialFinal();
		calculoFrecuenciaEsperada();
		calculoFrecuenciaObtenida();
	}

	public int getCantNumeros() {
		return cantNumeros;
	}

	public int getIntervaloInicial() {
		return intervaloInicial;
	}

	public int getIntervaloFinal() {
		return intervaloFinal;
	}

	public Object[] getRi() {
		return Ri;
	}

	public Object[] getNi() {
		return Ni;
	}

	public Object[] getListIntervaloInicial() {
		return listIntervaloInicial;
	}

	public Object[] getListIntervaloFinal() {
		return listIntervaloFinal;
	}

	public Object[] getFreObtenida() {
		return freObtenida;
	}

	public Object[] getFreEsperada() {
		return freEsperada;
	}

	public double getMin() {
		return min;
	}

	public double getMax() {
		return max;
	}

	public int getNumeroIntervalos() {
		return numeroIntervalos;
	}

	public Object[] getNo() {
		return No;
	}

	public Object[] getXi() {
		return xi;
	}
	
}
