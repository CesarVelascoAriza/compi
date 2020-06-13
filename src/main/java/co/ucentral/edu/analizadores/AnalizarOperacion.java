/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.ucentral.edu.analizadores;

import java.util.ArrayList;
import java.util.List;

import co.ucentral.edu.model.Palabra;
import co.ucentral.edu.model.Variables;

/**
 *
 * @author Adolfo
 */
public class AnalizarOperacion {

	private String linea;
	private Semantico semantico;
	private String operacion;

	public AnalizarOperacion() {

	}

	public String getLinea() {
		return linea;
	}

	public void setLinea(String linea) {
		this.linea = linea;
	}

	public Semantico getSemantico() {
		return semantico;
	}

	public void setSemantico(Semantico semantico) {
		this.semantico = semantico;
	}

	public String getOperacion() {
		return operacion;
	}

	public void setOperacion(String operacion) {
		this.operacion = operacion;
	}

	public void analizarLineaEjecucion(String analizaLinea) {
		List<String> varOper = new ArrayList<String>();
		String varibleAsignacion = "";
		String temp = "";
		ArrayList<Variables> variables = semantico.getListaVar();
		Variables variable = new Variables();
		Palabra p = new Palabra();
		for (int i = 0; i < analizaLinea.length(); i++) {
			if (Character.isLetterOrDigit(analizaLinea.charAt(i))) {
				temp += analizaLinea.charAt(i);
			}

			if (analizaLinea.charAt(i) == ('*')) {
				varOper.add(temp.trim());
				setOperacion("*");
				temp = "";
			}
			if (analizaLinea.charAt(i) == ('=')) {
				varibleAsignacion += temp;
				temp = "";
			}
			if (analizaLinea.charAt(i) == ('+')) {
				varOper.add(temp.trim());
				setOperacion("+");
				temp = "";
			}
			if (analizaLinea.charAt(i) == ('-')) {
				varOper.add(temp.trim());
				setOperacion("-");
				temp = "";
			}
			if (analizaLinea.charAt(i) == ('/')) {
				varOper.add(temp.trim());
				setOperacion("/");
				temp = "";
			}
			if (i == analizaLinea.length() - 1) {
				varOper.add(temp.trim());
				temp = "";
			}

		}
		int resultado = 1;
		double res=1;
		int index = 0;
		
		for (int i = 0; i < varOper.size(); i++) {
			for (int j = 0; j < variables.size(); j++) {
				if(varOper.get(i).contains(variables.get(j).getIdentificador()) ) {

					if ("entero".equals(variables.get(j).getTipo())) {

						if (getOperacion().equals("*"))
							resultado *= Integer.parseInt(variables.get(j).getValor());
						if (getOperacion().equals("+")) {
							resultado=0;
							resultado += Integer.parseInt(variables.get(j).getValor());
							}
						if (getOperacion().equals("-"))
							resultado -= Integer.parseInt(variables.get(j).getValor());
						if (getOperacion().equals("/"))
							resultado /= Integer.parseInt(variables.get(j).getValor());
					}
					if ("real".equals(variables.get(j).getTipo())) {

						if (getOperacion().equals("*"))
							res *= Integer.parseInt(variables.get(j).getValor());
						if (getOperacion().equals("+")) {
							res=0;
							res += Integer.parseInt(variables.get(j).getValor());
						}
						if (getOperacion().equals("-"))
							res -= Integer.parseInt(variables.get(j).getValor());
						if (getOperacion().equals("/"))
							res /= Integer.parseInt(variables.get(j).getValor());
					}
				
					
				}
				
			}
		}
		
		
		
		for (Variables v : variables) {
			if(v.getIdentificador().equals(varibleAsignacion)) {
				if(v.getTipo().equals("entero"))
					v.setValor(String.valueOf(resultado) );
				if(v.getTipo().equals("real"))
					v.setValor(String.valueOf(res) );
			}
		}
	}

}
