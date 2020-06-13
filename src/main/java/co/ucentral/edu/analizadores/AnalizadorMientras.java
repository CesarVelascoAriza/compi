package co.ucentral.edu.analizadores;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

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
	private int variableAsignable;
	private Semantico semantico;
	private int line;
	private String textoAraAnalisi;
	private TemporalVariables temp; 

	public AnalizadorMientras() {
		pila = new StackCoposition();
		condicion = new ArrayList<String>();
		tempcondicion = "";
		variables = new ArrayList<TemporalVariables>();
		cuerpoMientras = false;
		cuerpoM = "";
		variableAsignable = 0;
		textoAraAnalisi = "";
		temp =new TemporalVariables();

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
					cuerpoM += palabra;
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
			cuerpoM += palabra.trim() + "\n";
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
		 
		for (String string : condicion) {
			temp = valorVariables(string);
			if (temp != null) {
				System.out.println(temp.getVariable());
				System.out.println(temp.getValorentero());
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
		int i = 0;
		do {
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

			System.out.println(i++);
			analizarCuerpo();
			if ((var1 = analisarCuerpoOperaciones(cuerpoM)) != 0 && var1 != -1) {

			} else {
				break;
			}

		} while (co);

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

	private void analizarCuerpo() {
		TemporalVariables temp = null;
		ArrayList<String> listLinea = new ArrayList();
		listLinea = semantico.getArray(cuerpoM);
		for (String string : listLinea) {
			if (string.contains("escriba")) {
				System.out.println("Mierda escriba");
				String mensaje = extraerMensajeEscriba(string);
				JOptionPane.showMessageDialog(null, mensaje);
			} else if (string.contains("lea")) {
				String variable = extraerAsignacionImput(string);
				temp=valorVariables(variable);
				if(temp != null) {
					String entero= JOptionPane.showInputDialog(null,"Valor para variable " +temp.getVariable() );
					temp.setValorInput(entero, temp);
				}
				
				
			} else if (string.contains("if")) {

			} else {
				analisarCuerpoOperaciones(string);
			}
		}

	}

	private String extraerAsignacionImput(String string) {
		String variable = "";
		boolean almacenamensaje = false;
		for (int i = 0; i < string.length(); i++) {

			if (string.charAt(i) == '(') {
				System.out.println();
				almacenamensaje = true;

			}
			if (string.charAt(i) == ')') {
				System.out.println();
				almacenamensaje = false;

			}
			if (almacenamensaje) {
				if (Character.isLetterOrDigit(string.charAt(i)))
					variable += string.charAt(i);
			}

		}
		return variable;
	}

	private String extraerMensajeEscriba(String string) {
		String mensaje = "";
		String mensajetemp="";
		boolean almacenamensaje = false;
		boolean variablestemporales= false;
		TemporalVariables temp= null;
		for (int i = 0; i < string.length(); i++) {

			if (string.charAt(i) == '\"') {
				System.out.println();
				if (!almacenamensaje) {
					almacenamensaje = true;
				} else {
					almacenamensaje = false;
				}

			}
			if (almacenamensaje) {
				
					mensaje += string.charAt(i);
			}

		}
		if(mensaje.contains("+")) {
			Scanner s= new Scanner(mensaje);
			while(s.hasNext()) {
				
				System.out.println(s.next());
				temp = valorVariables(s.next().trim());
				if(temp != null) {
					if(temp.getTipo().equals("entero")) {
						mensajetemp +=temp.getValorentero();	
					}
					if(temp.getTipo().equals("cadena"))
						mensajetemp +=temp.getCadena();
					if(temp.getTipo().equals("real"))
						mensajetemp += " " +temp.getValorReal();
					
				}
				
			}
			
		}
		System.out.println(mensajetemp );
		mensaje += mensajetemp;
		return mensaje;
	}

	private int analisarCuerpoOperaciones(String lineaCuerpo) {
		String p = "";
		String digito = "";
		String operacion = "";
		List<String> palabraReservada1 = new ArrayList<String>();
		boolean operacionescribir;
		String mesaje = "";
		int var1 = -1;// variable que se declara para la asignacion
		int var2 = -1;// variable para primer valor
		int var3 = -1;// variable para el segundo valor
		int var4 = -1;// variable para el tercer valor en caso de que lo tenga
		int var5 = -9;// variable para numeros que esten en el cuerpo a ejecutar
		int resultado = 0;
		String vasiginacion = null;
		String varuno = null;
		// System.out.println("ANALIZAR CUERPO");

		for (int i = 0; i < lineaCuerpo.length(); i++) {

			if (Character.isLetterOrDigit(lineaCuerpo.charAt(i)))
				p += lineaCuerpo.charAt(i);

			if (lineaCuerpo.charAt(i) == '=') {
				// System.out.println("entra a la condicion de asignacion : " + p);
				vasiginacion = p;
				var1 = variablesEstado(p, -1);
				if (var1 == -1) {
					var1 = 0;
				}
				// System.out.println("valor de la variable : " + var1);
				p = "";
			}
			if (lineaCuerpo.charAt(i) == '+') {
				// System.out.println("entra a la condicion de suma : " + p);
				varuno = p;
				var2 = variablesEstado(p, -1);
				if (var2 == -1) {
					var2 = 0;
				}
				if (varuno.equals(variableAsignable)) {
					var1 = var2;
				}
				operacion = "SUMA";
				// var2+=var2;
				// System.out.println("valor de la suma : " + var2);
				p = "";
			}
			if (lineaCuerpo.charAt(i) == '*') {
				// System.out.println("entra a la condicion de suma : " + p);
				var3 = variablesEstado(p, -1);
				if (var3 == -1) {
					var3 = 0;
				}
				operacion = "MULTIPLICACION";
				// System.out.println("valor de la suma : " + var2);
				p = "";
			}
			if (lineaCuerpo.charAt(i) == '-') {

				// System.out.println("entra a la condicion de suma : " + p);
				var4 = variablesEstado(p, -1);
				if (var4 == -1) {
					var4 = 0;
				}
				operacion = "RESTA";
				System.out.println("valor de la suma   : " + var4);
				p = "";
			}
			if (lineaCuerpo.charAt(i) == '\\') {
				operacion = "DIVICION";
				var5 = variablesEstado(p, -1);
				if (var5 == -1) {
					var5 = 0;
				}
				System.out.println("=" + p);
				p = "";

			}
			if (lineaCuerpo.charAt(i) == '(') {
				System.out.println("=" + p);
				palabraReservada1.add(p);
				p = "";

			}
			if (lineaCuerpo.charAt(i) == ')') {
				System.out.println("=" + p);
				p = "";
			}

			if (Character.isDigit(lineaCuerpo.charAt(i))) {
				var5 = variablesEstado(p, -1);
				if (var5 == -1) {
					digito += p;
					p = "";
				}
			}

		}
		// System.out.println(vasiginacion);
		// System.out.println(variablesEstado(vasiginacion, tipoOeracion(operacion,
		// var1,Integer.parseInt(digito))));
		// System.out.println("P: " + var1 + " " + var2 + " " + var3 + " " + var4 + " "
		// + var5 + " digito: " + digito);
		System.out.println(palabraReservada1);

		if (var1 != -1) {
			resultado = variablesEstado(vasiginacion, tipoOeracion(operacion, var1, Integer.parseInt(digito)));
		}
		if (var2 != -1) {
			resultado = variablesEstado(vasiginacion, tipoOeracion(operacion, var2, Integer.parseInt(digito)));
		}
		if (var3 != -1) {
			resultado = variablesEstado(vasiginacion, tipoOeracion(operacion, var3, Integer.parseInt(digito)));
		}
		if (var4 != -1) {
			resultado = variablesEstado(vasiginacion, tipoOeracion(operacion, var4, Integer.parseInt(digito)));
		}
		if (var5 != -1) {
			resultado = variablesEstado(vasiginacion, tipoOeracion(operacion, var5, Integer.parseInt(digito)));
		}
		// resultado = variablesEstado(vasiginacion, tipoOeracion(operacion,
		// var1,Integer.parseInt(digito)));
		return resultado;

	}

	private int variablesEstado(String s, int valor) {
		
		temp = valorVariables(s);
		if (temp != null && valor == -1) {
			// System.out.println("Valor a retornar");
			return temp.getValorentero();
		} else if (temp != null && valor != -1) {
			// System.out.println("Valor varible " + temp.getVariable());
			temp.setValorentero(valor);
			return temp.getValorentero();
		} else {
			return -1;
		}
	}

	private int tipoOeracion(String operacion, int var1, int var2) {
		int resultado = 0;
		if (operacion.equals("SUMA")) {
			resultado = var1 + var2;
		}
		if (operacion.equals("RESTA")) {
			resultado = var1 - var2;
		}
		if (operacion.equals("MULTIPLICACION")) {
			resultado = var1 * var2;
		}
		if (operacion.equals("DIVICION")) {
			resultado = var1 / var2;
		}
		return resultado;
	}

	public Semantico getSemantico() {
		return semantico;
	}

	public void setSemantico(Semantico semantico) {
		this.semantico = semantico;
	}

	public String getTextoAraAnalisi() {
		return textoAraAnalisi;
	}

	public void setTextoAraAnalisi(String textoAraAnalisi) {
		this.textoAraAnalisi = textoAraAnalisi;
	}

}
