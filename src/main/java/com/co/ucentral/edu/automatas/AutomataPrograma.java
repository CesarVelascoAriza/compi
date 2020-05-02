/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ucentral.edu.automatas;

import com.co.ucentral.edu.error.ErrorSintactico;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Adolfo
 */
public class AutomataPrograma {
    
    private int count;
    private String cadena;
    private ErrorSintactico error;
    private List<ErrorSintactico> errorSintactico;

    public AutomataPrograma(String cadena) {
        this.cadena = cadena;
        error = new ErrorSintactico();
        errorSintactico = new ArrayList<>();
    }
    
    public void inicio(){
         count = 0;
        estadoCero();
    }
    
    public void estadoCero(){
        if(cadena.equals("prog")){
            count ++;
            estadoUno();
        }
        error.setError(1);
        error.setDescripcion("Falta Incio del Programa");
        errorSintactico.add(error);
    }

    private void estadoUno() {
        if(cadena.equals("variables")){
            count ++;
            estadoDos();   
        }
        if(cadena.equals("var")){
            count ++;
            estadoDos();   
        }
        error.setError(2);
        error.setDescripcion("Falta declaracion de varibles");
        errorSintactico.add(error);
        
    }

    private void estadoDos() {
        estadoTres();
    }

    private void estadoTres() {
       
    }
    
    
    
}
