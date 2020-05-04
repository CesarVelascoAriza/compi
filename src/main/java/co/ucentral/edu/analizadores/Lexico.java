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
            String [] signos = {"=" , "(" , ")" , "\""};
            if(pal.contains(signos[0]) || pal.contains(signos[1]) || pal.contains(signos[2]) || pal.contains(signos[3] ))
            {
                String newStr = separar(signos,pal);
                Scanner escanNewStr = new Scanner(newStr);
                while(escanNewStr.hasNext())
                {
                    String newPal=escanNewStr.next();
                    tipo = tipoPalabra(newPal);
                    Palabra palabra=new Palabra(numeroLinea, tipo, newPal);
                    listaPalabras.add(palabra);
                }
                
            }
            else
            {
                tipo = tipoPalabra(pal);
                Palabra palabra=new Palabra(numeroLinea, tipo, pal);
                listaPalabras.add(palabra);
            }
        }
        
    }

    private String tipoPalabra(String palabra) {
        String tipoPal="";
        Simbolos simbolo=new Simbolos();
        if(simbolo.definiTipo(palabra, simbolo.palabrasReservadas))
        {
            tipoPal="RESERVADA";
        }
        else if(simbolo.definiTipo(palabra, simbolo.operadoresMatemáticos))
        {
            tipoPal="MATHOPERADOR";
        }
        else if(simbolo.definiTipo(palabra, simbolo.caracteresEspeciales))
        {
            tipoPal="CARACTERESP";
        }
        else if(simbolo.definiTipo(palabra, simbolo.operadoresRelComplejos))
        {
            tipoPal="OPERADORRELCOMPLEJO";
        }
        else if(simbolo.definiTipo(palabra, simbolo.operadoresRel))
        {
            tipoPal="OPERADORREL";
        }
        else if(simbolo.validaNumeros(palabra))
        {
            tipoPal="NUMERICO";
        }
        else
        {
            tipoPal="IDENTIFICADOR";
        }
        return tipoPal;
    }

    private String separar(String[] signos, String pal) {
        String newPal = pal;
        //String [] signos = {"=" , "(" , ")" , "\""};
        if(pal.contains(signos[0])){ newPal= newPal.replace("=", " = ");}
        if(pal.contains(signos[1])){ newPal= newPal.replace("(", " ( ");}
        if(pal.contains(signos[2])){ newPal= newPal.replace(")", " ) ");}
        if(pal.contains(signos[3])){ newPal= newPal.replace("\"", " \" ");}
        
        return newPal;
    }
    
}
