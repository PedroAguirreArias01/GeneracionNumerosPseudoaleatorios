package test;

import controller.Controller;
import logica.CongruenciaMultiplicativa;
import logica.DisUniforme;
/**
 * 
 * @author pedro
 *
 */
public class Run {

	public static void main(String[] args) {
		new Controller();
//
//		CuadradoMedio cuadradoMedio = new CuadradoMedio();
//		cuadradoMedio.init(1234, 4, 8, 10, 14);
//		cuadradoMedio.calculate();
//		for (Object string : cuadradoMedio.getExtrae()) {
//			System.out.println(string);
//		}
//		String aux = "12345678";
//		System.out.println(aux.substring(2, 4+2));
		
//		CongruenciaLineal congruenciaLineal = new CongruenciaLineal();
//		congruenciaLineal.init(1, 2, 7, 5);
//		congruenciaLineal.calculateRi();
		
//		DisNormal disNormal = new DisNormal();
//		disNormal.init(35, 1.5, 40, 10);
//		disNormal.obtenerNi();
//		
//		CongruenciaMultiplicativa congruenciaMultiplicativa = new CongruenciaMultiplicativa();
//		congruenciaMultiplicativa.init(5, 2, 48);
//		congruenciaMultiplicativa.calculteXi();
//		congruenciaMultiplicativa.calculateRi();
		
		DisUniforme disUniforme = new DisUniforme();
		disUniforme.init(15, 7, 15, 8);
		disUniforme.calcular();
	}

}
