package co.ucentral.edu.analizadores;

import java.util.ArrayList;
import java.util.List;

import co.ucentral.edu.model.Variables;

public class AnalizadorCondicional {

	private String linea;
	private Semantico semantico;

	public AnalizadorCondicional() {
		this.linea = "";

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

	public boolean analizacondicion() {
		boolean t = false;
		String temp = "";
		List<String> var = new ArrayList<String>();
		String Operador = "";
		ArrayList<Variables> variables = semantico.getListaVar();
		Variables variable = new Variables();
		for (int i = 0; i < linea.length(); i++) {
			temp += linea.charAt(i);
			if (Character.isWhitespace(linea.charAt(i))) {
				var.add(temp.trim());
				temp = "";
			}
			if (Character.isDigit(linea.charAt(i))) {
				var.add(temp.trim());
				temp = "";
			}
			if (linea.contains("==")) {
				Operador = "==";
			}
			if (linea.charAt(i) == '<') {
				Operador = "<";
			}
			if (linea.charAt(i) == '>') {
				Operador = "<";
			}

			if (linea.contains(">=")) {
				Operador = ">=";
			}
			if (linea.contains("<=")) {
				Operador = "<=";
			}
		}
		for (int i = 0; i < var.size(); i++) {
			for (int j = 0; j < variables.size(); j++) {
				if (var.get(i).contains(variables.get(j).getIdentificador())) {
					if (Operador == "==") {
						if (Integer.parseInt(variables.get(j).getValor()) == Integer.parseInt(var.get(var.size() - 2))) {
							t = true;
						}
					}
					if (Operador == "<=") {
						if (Integer.parseInt(variables.get(j).getValor()) <= Integer.parseInt(var.get(var.size() - 2))) {
							t = true;
						}
					}
					if (Operador == ">=") {
						if (Integer.parseInt(variables.get(j).getValor()) >= Integer.parseInt(var.get(var.size() - 2))) {
							t = true;
						}
					}
					if (Operador == "<") {
						if (Integer.parseInt(variables.get(j).getValor()) < Integer.parseInt(var.get(var.size() - 2))) {
							t = true;
						}
					}
					if (Operador == ">") {
						if (Integer.parseInt(variables.get(j).getValor()) > Integer.parseInt(var.get(var.size() - 2))) {
							t = true;
						}
					}

				}

			}
		}

		return t;
	}

}
