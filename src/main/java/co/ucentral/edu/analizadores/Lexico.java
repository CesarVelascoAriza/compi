/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.ucentral.edu.analizadores;

import co.ucentral.compiladores.primercorte.PalabrasReservadas;
import java.util.Scanner;

/**
 *
 * @author Adolfo
 */
public class Lexico {

    private PalabrasReservadas reservadas;
    private Scanner scaner;
    public Lexico() {
        reservadas  = new PalabrasReservadas();
        
    }
    
    public void analizarTextoLexico(String linea){
        for (int i = 0; i < linea.length(); i++) {
            Character caracter = linea.charAt(i);
            if(!Character.isSpaceChar(caracter)){
                System.err.println("Imprime Linea : " + caracter ); 
            }
        }
 
       
    }
    
}
