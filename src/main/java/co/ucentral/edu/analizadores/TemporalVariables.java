package co.ucentral.edu.analizadores;

public class TemporalVariables {

	private String variable;
	private String tipo;
	private int valorentero;
	private double valorReal;
	private String cadena;
	private boolean valorBoleano;
	private String valor;

	public TemporalVariables() {

		this.valorentero = 0;
		this.valorReal = 0.0;
		this.cadena = "";
		this.valorBoleano = false;

	}

	public String getVariable() {
		return variable;
	}

	public void setVariable(String variable) {
		this.variable = variable;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getValorentero() {
		return valorentero;
	}

	public void setValorentero(int valorentero) {
		this.valorentero = valorentero;
	}

	public double getValorReal() {
		return valorReal;
	}

	public void setValorReal(double valorReal) {
		this.valorReal = valorReal;
	}

	public String getCadena() {
		return cadena;
	}

	public void setCadena(String cadena) {
		this.cadena = cadena;
	}

	public boolean isValorBoleano() {
		return valorBoleano;
	}

	public void setValorBoleano(boolean valorBoleano) {
		this.valorBoleano = valorBoleano;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}
	public void setValorInput(String valor, TemporalVariables temp) {
		if(temp.getTipo().equals("entero")) {
			temp.setValorentero(Integer.parseInt(valor));
			this.valorentero=Integer.parseInt(valor);
		}
		if(temp.getTipo().equals("cadena"))
			this.valor=valor;
		if(temp.getTipo().equals("real"))
			this.valorReal=Double.parseDouble(valor);
	}
	
}
