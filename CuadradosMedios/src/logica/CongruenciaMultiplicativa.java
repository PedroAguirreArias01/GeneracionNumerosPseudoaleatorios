package logica;

/**
 * 
 * @author pedro
 *
 */
public class CongruenciaMultiplicativa {

	private int Xo;
	private int t;
	private int d;
	
	//parametros
	private int a;
	private int m;
	
	//vectores
	private Object[] i;
	private Object[] xi;
	private Object[] Ri;
	
	
	public CongruenciaMultiplicativa() {
		// TODO Auto-generated constructor stub
	}
	
	public void init(int xo, int t, int d) {
		this.Xo = xo;
		this.t = t;
		this.d = d;
		this.a = 8*t+3;
		this.m = 2*d;
		this.i = new Object[m];
		this.xi = new Object[m];
		this.Ri = new Object[m];
	}
	
	public void calculteXi() {
		int auxXi = (this.a*this.Xo)%this.m;
		this.xi[0] = auxXi; 
		System.out.println("xi: "+auxXi);
		for (int i = 1; i < m; i++) {
			auxXi = (this.a*auxXi)%this.m;
			this.xi[i] = (this.a*auxXi)%this.m;
			System.out.println("xi: "+auxXi);
		}
	}
	
	public void calculateRi() {
		for (int i = 0; i < xi.length; i++) {
			this.i[i] = i;
			this.Ri[i] = (double) ((int)this.xi[i])/(this.m-1);
			System.out.println("Ri: "+this.Ri[i]);
		}
	}

	public int getXo() {
		return Xo;
	}

	public int getT() {
		return t;
	}

	public int getD() {
		return d;
	}

	public int getA() {
		return a;
	}

	public int getM() {
		return m;
	}

	public Object[] getI() {
		return i;
	}

	public Object[] getXi() {
		return xi;
	}

	public Object[] getRi() {
		return Ri;
	}
	
}
