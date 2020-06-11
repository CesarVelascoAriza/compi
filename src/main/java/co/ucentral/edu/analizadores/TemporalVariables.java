package co.ucentral.edu.analizadores;

public class TemporalVariables {

	private String variable;
	private String tipo;
	
	
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
	
	public int tipoVariableEntero() {
		if(getTipo().equals("entero")) {
		 return	1;
		}
		return 1;
	}
	public boolean esVariableEntero() {
		if(getTipo().equals("entero")) {
		 return true;	 
		}
		return false;
	}
	
}
