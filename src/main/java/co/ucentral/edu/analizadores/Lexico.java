/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.ucentral.edu.analizadores;

import java.util.Scanner;
import co.ucentral.edu.model.Palabra;
import com.ucentral.compiladores.scorte.JFSegundoCorte;
import java.util.ArrayList;
import javax.swing.JTabbedPane;
import co.ucentral.edu.analizadores.Simbolos;

/**
 *
 * @author Adolfo
 */
public class Lexico {
    
    private Scanner escaner; 
    private Scanner escanerSparte;
    ArrayList<Palabra> listaPalabras= new ArrayList<Palabra>();    
    
    public Lexico() {
    }

    public ArrayList<Palabra> analizadorLexico(String texto){
        escaner = new Scanner(texto);
        int linea =1;
        while(escaner.hasNext()){
            //System.out.printf("Texto = %s \t Linea = %d \n" , escaner.nextLine(),linea);
            tablaSimbolos(escaner.nextLine(), linea);
            linea++;
        }
        return listaPalabras;
    }
    public void tablaSimbolos(String linea, int numeroLinea){
        escanerSparte = new Scanner(linea);
        String tipo;
        int i;
        while (escanerSparte.hasNext()) { 
            String pal=escanerSparte.next();
            tipo = tipoPalabra(pal);
            Palabra palabra=new Palabra(numeroLinea, tipo, pal);
            listaPalabras.add(palabra);
        }
        
    }

    private String tipoPalabra(String palabra) {
        String tipoPal="";
        Simbolos simbolo=new Simbolos();
        if(simbolo.definiTipo(palabra, simbolo.palabrasReservadas))
        {
            tipoPal="Reservada";
        }
        else if(simbolo.definiTipo(palabra, simbolo.operadoresMatemáticos))
        {
            tipoPal="MathOperador";
        }
        else if(simbolo.definiTipo(palabra, simbolo.caracteresEspeciales))
        {
            tipoPal="CaracterEsp";
        }
        else if(simbolo.definiTipo(palabra, simbolo.operadoresRelComplejos))
        {
            tipoPal="OperadorRelcomplejo";
        }
        else if(simbolo.definiTipo(palabra, simbolo.operadoresRel))
        {
            tipoPal="OperadorRel";
        }
        else if(simbolo.validaNumeros(Character.MAX_VALUE))
        {
            tipoPal="Numerico";
        }
        else
        {
            tipoPal="Palabra";
        }
        return tipoPal;
    }
    
}
