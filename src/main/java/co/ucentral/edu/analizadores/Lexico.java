/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.ucentral.edu.analizadores;

import java.util.ArrayList;
import java.util.Scanner;

import co.ucentral.edu.model.Palabra;
import com.co.ucentral.edu.automatas.AutomataPrograma;

/**
 *
 * @author Adolfo
 */
public class Lexico {

	private Scanner escaner;
	private Scanner escanerSparte;
	private ArrayList<Palabra> listaPalabras = new ArrayList<Palabra>();
	private String tipo;

	public Lexico() {
	}

	public ArrayList<Palabra> analizadorLexico(String texto) {
		escaner = new Scanner(texto);
		int linea = 1;
		String Linea = "";
		while (escaner.hasNext()) {
			Linea = escaner.nextLine();
			// System.out.printf("Texto = %s \t Linea = %d \n" , escaner.nextLine(),linea);
			tablaSimbolos(Linea, linea);
			linea++;
		}

		return listaPalabras;

	}

	public void tablaSimbolos(String linea, int numeroLinea) {
		escanerSparte = new Scanner(linea);

		int i;
		while (escanerSparte.hasNext()) {
			String pal = escanerSparte.next();
			tipo = tipoPalabra(pal);
			Palabra palabra = new Palabra(numeroLinea, tipo, pal);
			listaPalabras.add(palabra);

		}
               new AutomataPrograma(listaPalabras);
	}

	private String tipoPalabra(String palabra) {
		String tipoPal = "";
		Simbolos simbolo = new Simbolos();
		if (simbolo.definiTipo(palabra, simbolo.palabrasReservadas)) {
			tipoPal = "Reservada";
		} else if (simbolo.definiTipo(palabra, simbolo.operadoresMatemáticos)) {
			tipoPal = "MathOperador";
		} else if (simbolo.definiTipo(palabra, simbolo.caracteresEspeciales)) {
			tipoPal = "CaracterEsp";
		} else if (simbolo.definiTipo(palabra, simbolo.operadoresRelComplejos)) {
			tipoPal = "OperadorRelcomplejo";
		} else if (simbolo.definiTipo(palabra, simbolo.operadoresRel)) {
			tipoPal = "OperadorRel";
		} else if (simbolo.validaNumeros(Character.MAX_VALUE)) {
			tipoPal = "Numerico";
		} else {
			tipoPal = "Palabra";
		}
		return tipoPal;

	}

}
