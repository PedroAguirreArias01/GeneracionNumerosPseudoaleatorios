package vista;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import controller.Acciones;
import controller.Controller;
/**
 * 
 * @author pedro
 *
 */
public class MenuBar extends JMenuBar{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MenuBar(Controller controller) {
		// TODO Auto-generated constructor stub
		JMenu menu = new JMenu("Cuadrados Medios");
		this.add(menu);
		
		JMenuItem itemCudrados = new JMenuItem("Cuadrados Medios");
		itemCudrados.addActionListener(controller);
		itemCudrados.setActionCommand(Acciones.CUADRADOS_MEDIOS.name());
		menu.add(itemCudrados);
		
		JMenu menuDisUniF = new JMenu("Dis. Uniforme");
		this.add(menuDisUniF);
		
		JMenuItem itemuNiforme = new JMenuItem("Dis. Uniforme");
		itemuNiforme.addActionListener(controller);
		itemuNiforme.setActionCommand(Acciones.DIS_UNIFORME.name());
		menuDisUniF.add(itemuNiforme);
		
		JMenu menuDisNormal = new JMenu("Ditribucion. Normal");
		this.add(menuDisNormal);
		
		JMenuItem itemuNormal = new JMenuItem("Dis. Normal");
		itemuNormal.addActionListener(controller);
		itemuNormal.setActionCommand(Acciones.DIS_NORMAL.name());
		menuDisNormal.add(itemuNormal);
		
		JMenu menuCongru = new JMenu("Ditribucion. Congruencial");
		this.add(menuCongru);
		
		JMenuItem itemCongruencias = new JMenuItem("Congruencia Lineal");
		itemCongruencias.addActionListener(controller);
		itemCongruencias.setActionCommand(Acciones.CONGRUENCIAS.name());
		menuCongru.add(itemCongruencias);
		
		JMenuItem itemCongruenciasM = new JMenuItem("Congruencia Multiplicativa");
		itemCongruenciasM.addActionListener(controller);
		itemCongruenciasM.setActionCommand(Acciones.CONGRUENCIA_MUULTIPLICATIVA.name());
		menuCongru.add(itemCongruenciasM);
	}
	
}
