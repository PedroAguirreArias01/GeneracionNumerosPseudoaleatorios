package logica;

/**
 * 
 * @author pedro
 *
 */
public class CongruenciaLineal {

	//entradas
	private int Xo;
	private int k;
	private int c;
	private int g;
	
	//parametros
	private int a;
	private int m; 
	
	//vectores 
	private Object[] No;
	private Object[] xi;
	private Object[] Ri;
	
	public CongruenciaLineal() {
		// TODO Auto-generated constructor stub
	}

	public void init(int xo, int k, int c, int g) {
		this.Xo = xo;
		this.k = k;
		this.c = c;
		this.g = g;
		this.a = 1+2*k;
		this.m = (int) Math.pow(2, g);

		this.No = new Object[m];
		this.xi = new Object[m];
		this.Ri = new Object[m];
	}
	
	public void calXi() {
		int auxXi = (a*Xo+c)%m;
		this.xi[0] = auxXi;
		for (int i = 1; i < m; i++) {
			auxXi = (a*auxXi+c)%m;
			this.xi[i] = auxXi;
		} 
	}
	
	public void calculateRi() {
		calXi();
		for (int i = 0; i < this.xi.length; i++) {	
			this.Ri[i]= (double)((int)this.xi[i])/(m-1);
			System.out.println("Xi"+(double)((int)this.xi[i])/(m-1));
			this.No[i] = i;
		}
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getM() {
		return m;
	}

	public void setM(int m) {
		this.m = m;
	}

	public Object[] getNo() {
		return No;
	}

	public void setNo(Object[] no) {
		No = no;
	}

	public Object[] getXi() {
		return xi;
	}

	public void setXi(Object[] xi) {
		this.xi = xi;
	}

	public Object[] getRi() {
		return Ri;
	}

	public void setRi(Object[] ri) {
		Ri = ri;
	}

}
