package logica.pruebas;

import java.util.Arrays;

/**
 * 
 * @author pedro
 *
 */

public class PruebaVarianza {

	public TablaChiCuadrada tablaChi2;
    public Object[] niNormalizados;
    public Object[] niSinNormalizar;
    private double alfa;
    private double alfaMed;
    private double varianza;
    private double promedio;
    private int n ;
    private double acpder ;
    private double chiInvAlfa ;
    private double chiInvAcpder;
    private double limiteSuperior ;
    private double limiteInferior ;
    private double max ;
    private double min;
	
    public PruebaVarianza() {
    	
     }
    
    /**
     * valores ni no normalizados y el porcentaje de acepatacion
     * @param ni
     * @param aceptacion
     * @return
     */
    public boolean init(Object[] ni, double aceptacion) {
    	this.n =ni.length;
    	calcularMinMax();
    	normalizarDatos();
    	calcularPromedio();
    	tablaChi2 = new TablaChiCuadrada();
    	this.alfa =((100-aceptacion)/2);
    	this.alfaMed= (alfa)/100;
    	this.varianza = calculoVarianza();
        this.acpder =1-alfaMed;
        this.chiInvAlfa =tablaChi2.chiInverso((float) alfaMed, n);
        this.chiInvAcpder= tablaChi2.chiInverso((float) acpder, n);
        this.limiteSuperior = chiInvAcpder /(12*(n-1));
        this.limiteInferior = chiInvAlfa /(12*(n-1));
        return (varianza<limiteInferior&&varianza>limiteSuperior);  
    }
    
    public void calcularMinMax() {
    	Object[] listAux = niSinNormalizar;
		Arrays.sort(listAux);
		this.min = (double)listAux[0];
		this.max = (double) listAux[listAux.length-1];
    }
    
    public void normalizarDatos() {
		for (int i = 0; i < niSinNormalizar.length; i++) {
			niNormalizados[i] = ((double)niSinNormalizar[i]-this.min)/(this.max-this.min);
		}
    }
    
    private void calcularPromedio() {
		for (int i = 0; i < niNormalizados.length; i++) {
			this.promedio += (double)niNormalizados[i];
		}
		this.promedio = this.promedio/niNormalizados.length;
	}
    
    public double calculoVarianza() {
    	double suma = 0; 
        for (int i = 0; i < niNormalizados.length; i++) {
            suma += (float) Math.pow(((double)niNormalizados[i]-this.promedio),2);
        }
        return (suma)/(niNormalizados.length-1);
    }
    
}
