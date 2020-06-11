package co.ucentral.edu.analizadores;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.co.ucentral.edu.Stack.StackCoposition;

public class AnalizadorMientras {

	private StackCoposition pila;
	private List<String> condicion;
	private String tempcondicion;
	private boolean empizaCondicion;
	private boolean empizavarible;
	private List<TemporalVariables> variables;
	private boolean cuerpoMientras;
	private String cuerpoM;

	public AnalizadorMientras() {
		pila = new StackCoposition();
		condicion = new ArrayList<String>();
		tempcondicion = "";
		variables = new ArrayList<TemporalVariables>();
		cuerpoMientras = false;
		cuerpoM = "";
	}

	public void analizarCondicion() {
		pila.imprimir();
		System.out.println("Condicion");
		convertirCondicio();
		ejecucionTemp();
	}

	public String analizarLinea(String linea) {
		String palabra = "";
		boolean con = false;
		TemporalVariables variables = new TemporalVariables();
		for (int i = 0; i < linea.length(); i++) {
			palabra += linea.charAt(i);
			if (Character.isWhitespace(linea.charAt(i))) {
				// System.out.println(palabra);
				pila.push(palabra.trim());
				if (palabra.trim().equals("var"))
					empizavarible = true;
				if (palabra.trim().equals("variable")) {
					empizavarible = true;
				}

				if (empizavarible && !palabra.trim().equals("var") && !palabra.trim().equals("variable")) {
					variables.setVariable(palabra.trim());
				}
				if (palabra.trim().equals("mientras"))
					empizaCondicion = true;

				if (empizaCondicion && !palabra.trim().equals("mientras")) {
					tempcondicion += palabra.trim();
					condicion.add(palabra.trim());
				}
				if (cuerpoMientras) {
					cuerpoM += palabra.trim();
				}
				palabra = "";

			}
		}
		if (empizavarible) {
			variables.setTipo(palabra);
			this.variables.add(variables);
			empizavarible = false;
		}

		if (palabra.equals("haga")) {
			empizaCondicion = false;
			cuerpoMientras = true;
		}

		if (!palabra.equals("haga") && cuerpoMientras && !palabra.equalsIgnoreCase("fmientras")) {
			cuerpoM += palabra.trim();
		}
		if (palabra.equalsIgnoreCase("fmientras"))
			cuerpoMientras = false;
		pila.push(palabra);
		return palabra;
	}

	private void convertirCondicio() {
		System.out.println(tempcondicion);
		int var1 = 0;
		int var2 = 0;
		String compardor = null;
		TemporalVariables temp = null;
		for (String string : condicion) {
			temp = valorVariables(string);
			if (temp != null) {
				if (temp.esVariableEntero()) {
					var1 = temp.tipoVariableEntero();
					// System.out.println(var1);
				}
			} else {
				if (Character.isDigit(string.charAt(0))) {
					var2 = Integer.parseInt(string);
				}
				if (tipocoparador(string)) {
					compardor = estadoComparador(string);
				}
			}
		}
		ejecutarMientras(var1, compardor, var2);
	}

	private String estadoComparador(String string) {
		if (string.contains("<")) {
			return "menorQue";
		} else if (string.contains("<=")) {
			return "menorIgual";
		} else if (string.contains("==")) {
			return "igual";
		} else if (string.contains(">=")) {
			return "mayorIgual";
		} else if (string.contains(">")) {
			return "mayor";
		}
		return null;
	}

	private void ejecutarMientras(int var1, String compardor, int var2) {
		System.out.println("Ejecutar mientras");
		System.out.println(var1);
		System.out.println(var2);
		System.out.println(compardor);
		boolean co = true;
		analisarCuerpo(cuerpoM);
		while (co) {
			if (compardor.equals("menorQue")) {
				co = var1 < var2;
			} else if (compardor.equals("menorIgual")) {
				co = var1 <= var2;
			} else if (compardor.equals("igual")) {
				co = var1 == var2;
			} else if (compardor.equals("mayorIgual")) {
				co = var1 >= var2;
			} else if (compardor.equals("mayor")) {
				co = var1 > var2;
			}

			var1++;
		}

	}

	private boolean tipocoparador(String tipo) {
		if (tipo.contains("<")) {
			return true;
		} else if (tipo.contains("<=")) {
			return true;
		} else if (tipo.contains("==")) {
			return true;
		} else if (tipo.contains(">=")) {
			return true;
		} else if (tipo.contains(">")) {
			return true;
		}
		return false;
	}

	private TemporalVariables valorVariables(String v) {
		for (TemporalVariables var : variables) {
			if (var.getVariable().equals(v)) {
				return var;
			}

		}
		return null;
	}

	private void ejecucionTemp() {

	}

	private void analisarCuerpo(String lineaCuerpo) {
		String p = "";
		int var1 = 9;
		int var2 = 9;
		int var3 = 9;
		if (lineaCuerpo.contains("lea")) {

		} else if (lineaCuerpo.contains("escriba")) {

		} else {
			for (int i = 0; i < lineaCuerpo.length(); i++) {

				System.out.printf(" %s ", lineaCuerpo.charAt(i));
				if (lineaCuerpo.charAt(i) == '=') {
					System.out.println("=" + p);
					p = "";
				}
				if (lineaCuerpo.charAt(i) == '+') {
					System.out.println("+" + p);
					p = "";
				}
				if (lineaCuerpo.charAt(i) == '*') {
					System.out.println("*" + p);
					p = "";
				}
				if (lineaCuerpo.charAt(i) == '-') {

					System.out.println("-" + p);
					p = "";
				}
				if (lineaCuerpo.contains("==")) {
					System.out.println("=" +p);
					p="";
				}
				if (lineaCuerpo.charAt(i) == '(') {
					System.out.println("=" +p);
					p="";
				}
				if (lineaCuerpo.charAt(i) == ')') {
					System.out.println("=" +p);
					p="";
				}
				if (lineaCuerpo.charAt(i) == '\"') {
					System.out.println("=" +p);
					p="";
				}
				p += lineaCuerpo.charAt(i);

			}
			System.out.println("P: " + p);
		}
	}

	private void ejecutarCuerpo() {

	}

	private void sepacionesCaracteres(String caracter) {

	}
}
