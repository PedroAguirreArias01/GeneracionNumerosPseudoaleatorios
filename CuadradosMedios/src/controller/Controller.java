package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import logica.CongruenciaLineal;
import logica.CongruenciaMultiplicativa;
import logica.CuadradoMedio;
import logica.DisNormal;
import logica.DisUniforme;
import vista.MainWindow;
/**
 * 
 * @author pedro
 *
 */
public class Controller implements ActionListener{


	private MainWindow mainWindow;
	private CuadradoMedio cuadradoMedio;
	private CongruenciaLineal congruenciaLineal; 
	private DisNormal disNormal;
	
	public Controller() {
		// TODO Auto-generated constructor stub
		this.mainWindow = new MainWindow(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (Acciones.valueOf(e.getActionCommand())) {
		case CUADRADOS_MEDIOS:
			mainWindow.showPanelCuadradosMedios();
			break;
		case CAL_CUDRADO:
			this.cuadradoMedio = new CuadradoMedio();
			cuadradoMedio.init(mainWindow.semilla(), mainWindow.caracteres(), mainWindow.min(), mainWindow.max(), mainWindow.iteraciones());
			cuadradoMedio.calculate();
			mainWindow.vectores(cuadradoMedio.getXi(), cuadradoMedio.getXicuadrado(), cuadradoMedio.getLargo(), cuadradoMedio.getExtrae(), cuadradoMedio.getRi(), cuadradoMedio.getNi(), cuadradoMedio.getNo());
			break;
			case CONGRUENCIAS:
				mainWindow.showPanelCongruencias();
				break;
			case CAL_CONGRUENCIAS:
				this.congruenciaLineal = new CongruenciaLineal();
				this.congruenciaLineal.init(mainWindow.dataXi(), mainWindow.dataK(), mainWindow.dataC(), mainWindow.dataG());
				this.congruenciaLineal.calculateRi();
				mainWindow.addDataCongruencia(congruenciaLineal.getNo(), congruenciaLineal.getXi(), congruenciaLineal.getRi());
				break;
			case DIS_NORMAL:
				mainWindow.showPanelDisNormal();
				break;
			case CAL_DIS_NORMAL:
				this.disNormal = new DisNormal();
				disNormal.init(mainWindow.dataMedia(), mainWindow.dataDesviacion(), mainWindow.dataIteraciones(), mainWindow.dataIntervalos());
				disNormal.obtenerNi();
				mainWindow.addDataDsNormal(disNormal.getNo(), disNormal.getNi(), disNormal.getIntervalos(), disNormal.getFrecuencia());
				break;
			case DIS_UNIFORME: 
				mainWindow.showPanelDisuniforme();
				break;
			case CONGRUENCIA_MUULTIPLICATIVA:
				mainWindow.showPanelMultiplicativo();
				break;
			case CAL_CONG_MULTI:
				CongruenciaMultiplicativa congruenciaMultiplicativa = new CongruenciaMultiplicativa();
				congruenciaMultiplicativa.init(mainWindow.dataXo(), mainWindow.dataT(), mainWindow.dataD());
				congruenciaMultiplicativa.calculteXi();
				congruenciaMultiplicativa.calculateRi();
				mainWindow.addConMultipli(congruenciaMultiplicativa.getI(), congruenciaMultiplicativa.getXi(), congruenciaMultiplicativa.getRi());
				break;
			case CAL_DIS_UNIFORME:
				DisUniforme disUniforme = new DisUniforme();
				disUniforme.init(mainWindow.cantidadNumeros(), mainWindow.interInicial(), mainWindow.interFinal(), mainWindow.numIntervalos());
				disUniforme.calcular();
				mainWindow.addDisUniforme(disUniforme.getXi(), disUniforme.getRi(), disUniforme.getNi(), disUniforme.getNo(), disUniforme.getListIntervaloInicial(), disUniforme.getListIntervaloFinal(), disUniforme.getFreObtenida(), disUniforme.getFreEsperada());
				break; 
		default:
			break;
		}
		
	}
}
