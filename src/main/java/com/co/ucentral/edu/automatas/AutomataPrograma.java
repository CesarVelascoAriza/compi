/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ucentral.edu.automatas;

import co.ucentral.edu.model.Palabra;
import com.co.ucentral.edu.error.ErrorSintactico;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Adolfo
 */
public class AutomataPrograma {

    private int count;
    private List<Palabra> cadena;
    private ErrorSintactico error;
    private List<ErrorSintactico> errorSintactico;

    public AutomataPrograma(List<Palabra> cadena) {
        this.cadena = cadena;
        error = new ErrorSintactico();
        errorSintactico = new ArrayList<>();
        estadoUno();
    }

    public void estadoUno() {
            if(!cadena.get(count).equals("prog") ){
               count++;
               estadoDos();
            }else{
                error.setError(1);
                error.setDescripcion("falata la palabra prog en la liena "  
                        +cadena.get(count).getLinea());
                errorSintactico.add(error);
            }
        
    }
    public void estadoDos(){
        if(cadena.get(count).getTipo().equals("Palabra")){
           count++;
           estadoTres();
        }else{
            
            error.setError(1);
                error.setDescripcion("falata el identificiador del programa en la liena "  
                        +cadena.get(count).getLinea());
                errorSintactico.add(error);
        } 
        
    }

    private void estadoTres() {
      if(cadena.get(count).getTipo().equals("Reservada"))
      {
          if(cadena.get(count).getPalabra().equals("var")){
              count++;
              estadoCuatro();
          }else if(cadena.get(count).getPalabra().equals("variable")){
               count++;
              estadoCuatro();
          }
          else{
              error.setError(1);
                error.setDescripcion("falta palabra reservada "  
                        +cadena.get(count).getLinea());
                errorSintactico.add(error);
          }
      }
    }

    private void estadoCuatro() {
       if(cadena.get(count).getTipo().equals("Palabra")){
           count++;
           estadoCinco();
       }else{
           error.setError(1);
                error.setDescripcion("falta palabra declaracion "  
                        +cadena.get(count).getLinea());
                errorSintactico.add(error);
       }
    }

    private void estadoCinco() {
        if(cadena.get(count).getTipo().equals("Reservada")){
            count++;
            estadoSeis();
        }else{
               error.setError(1);
                error.setDescripcion("falta palabra reservada "  
                        +cadena.get(count).getLinea());
                errorSintactico.add(error);
            
        }
    }

    private void estadoSeis() {
        count++;
    }
}
