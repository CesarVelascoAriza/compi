/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.ucentral.edu.analizadores;

import java.util.Scanner;

/**
 *
 * @author Adolfo
 */
public class Lexico {
    
    private Scanner escaner; 
    private Scanner escanerSparte;
    private String cadena;
    public Lexico() {
    }

    public void analizadorLexico(String texto){
        escaner = new Scanner(texto);
        int linea =1;
        String Linea="";
        while(escaner.hasNext()){
            Linea = escaner.nextLine();
            //System.out.printf("Texto = %s \t Linea = %d \n" , escaner.nextLine(),linea);
            tablaSimbolos(Linea, linea);
            linea++;
        }
        System.out.println("Linea = " + Linea);
    }
    public void tablaSimbolos(String linea, int numeroLinea){
        escanerSparte = new Scanner(linea);
        String tipo = "22";
        while (escanerSparte.hasNext()) {
            System.out.printf("palabra = %s \t linea = %d \t tipo = %s \n",
                    escanerSparte.next(), numeroLinea, tipo);
            
        }
        
    }
    
}
