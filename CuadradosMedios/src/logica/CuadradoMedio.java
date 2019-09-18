package logica;

/**
 * 
 * @author pedro
 *
 */
public class CuadradoMedio {

	private int semilla;
	private int caracteresTomados;
	private CuadradoMedio cuadradoMedio;
	private Object[] Ri;
	private Object[] Ni;
	private Object Xicuadrado[];
	private Object Xi[];
	private Object largo[];
	private Object extrae[];
	private Object[] No;
	private int min;
	private int max;
	private int totalNumeros;
	
	private int contador;
	private int auxCont;
	private int xiConte;
	
	public CuadradoMedio() {
		super();
	}
	
	public void init(int semilla, int caracteresTomados, int min, int max, int totalNumeros) {
		this.semilla = semilla;
		this.caracteresTomados = caracteresTomados;
		this.Ri = new Object[totalNumeros];
		this.Ni = new Object[totalNumeros];
		this.Xicuadrado = new Object[totalNumeros]; 
		this.Xi = new Object[totalNumeros];
		this.extrae = new Object[totalNumeros];
		this.largo = new Object[totalNumeros];
		this.No = new Object[totalNumeros];
		this.min = min;
		this.max = max;
		this.totalNumeros = totalNumeros;
	}
	
	public int elevarCuadrado(int semilla) {
		this.Xi[xiConte] = semilla;
		this.Xicuadrado[contador] = (int) Math.pow(semilla, 2);
		this.contador++;
		xiConte++;
		return (int) Math.pow(semilla, 2);
	}
	
	public int largo(int semilla) {
		this.largo[auxCont] = String.valueOf(semilla).length();
		auxCont++;
		return String.valueOf(semilla).length();
	}
	
	public int extrae(int semilla) {
		int semillaAux = elevarCuadrado(semilla);
		int largo = largo(semillaAux);
		if (largo == 8) {
			System.out.println(semillaAux+"semilla Aux");
			String result = String.valueOf(semillaAux).substring(2, 6);
			return Integer.valueOf(result);
		}
		if (largo%2==0) {
//			if (largo == 8) {
//				System.out.println(semillaAux+"semilla Aux");
//				String result = String.valueOf(semillaAux).substring(2, 6);
//				return Integer.valueOf(result);
//			}else {
				int posInicial = (largo-caracteresTomados)/2;
				String result = String.valueOf(semillaAux).substring(posInicial, posInicial+caracteresTomados);
				return Integer.valueOf(result);
//			}
		}else {
			int posInicial = (int) (((largo-caracteresTomados)/2)+1.5);
			System.err.println(posInicial);
			String result = String.valueOf(semillaAux).substring(posInicial, posInicial+caracteresTomados);
			return Integer.valueOf(result);
		}
	}
	
	public void calculate() {
		int extrae = extrae(this.semilla);
		this.extrae[0] = extrae;//toma extrae
		this.Ri[0] = (double)extrae/10000;
		for (int i = 1; i < totalNumeros; i++) {
			extrae = extrae(extrae);
			this.extrae[i] = extrae;
			this.Ri[i]= (double)extrae/10000;
		}
		calculateNi();
	}
	
	public void calculateNi() {
		for (int i = 0; i < Ri.length; i++) {
			this.Ni[i] = min+((max-min)*((double) Ri[i]));
			this.No[i] = i;
		}
	}

	public int getSemilla() {
		return semilla;
	}
	
	public void setSemilla(int semilla) {
		this.semilla = semilla;
	}
	
	public int getCaracteresTomados() {
		return caracteresTomados;
	}
	
	public void setCaracteresTomados(int caracteresTomados) {
		this.caracteresTomados = caracteresTomados;
	}

	public CuadradoMedio getCuadradoMedio() {
		return cuadradoMedio;
	}

	public Object[] getRi() {
		return Ri;
	}

	public Object[] getNi() {
		return Ni;
	}

	public Object[] getXicuadrado() {
		return Xicuadrado;
	}

	public Object[] getXi() {
		return Xi;
	}

	public Object[] getLargo() {
		return largo;
	}

	public Object[] getExtrae() {
		return extrae;
	}

	public int getMin() {
		return min;
	}

	public int getMax() {
		return max;
	}

	public int getTotalNumeros() {
		return totalNumeros;
	}

	public int getContador() {
		return contador;
	}

	public Object[] getNo() {
		return No;
	}

}
