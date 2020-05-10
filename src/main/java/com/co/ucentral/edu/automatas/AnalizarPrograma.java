/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ucentral.edu.automatas;

import co.ucentral.edu.model.Palabra;
import com.co.ucentral.edu.Stack.StackCoposition;
import com.co.ucentral.edu.error.ErrorSintactico;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Adolfo
 */
public class AnalizarPrograma {

    private StackCoposition pila;
    private List<Palabra> cadena;
    private ErrorSintactico error;
    private List<ErrorSintactico> errorSintactico;
    private List<String> ident;

    public AnalizarPrograma(List<Palabra> cadena) {
        this.cadena = cadena;
        error = new ErrorSintactico();
        errorSintactico = new ArrayList<>();
        ident = new ArrayList<>();
        pila = new StackCoposition();
        if (validarPrograma()) {
            System.out.println("la cadena esta bien");
        } else {
            System.err.println("la cadena fallo");
        }
    }

    public boolean validarPrograma() {
        /*try {*/
        for (Palabra palabra : cadena) {
            switch (palabra.getTipo()) {
                case "RESERVADA":
                    if (!valiarReservadas(palabra)) {
                        return false;
                    }
                    break;
                case "IDENTIFICADOR":
                    if(!validaToken())
                        return false;
                    break;
                case "CARACTERESP":

                    break;
                case "MATHOPERADOR":

                    break;
                default:
                    break;
            }
        }
        return true;
        /*} catch (Exception e) {
            return false;
            }*/
    }

    public boolean analisisCaracateresEsp() {
        return false;
    }

    public boolean validaComillas(Palabra p, boolean bolean) {
        if (bolean) {
            if (pila.pop() != "\"") {
                return false;
            }
        }
        return false;
    }

    private boolean valiarReservadas(Palabra palabra) {
        switch (palabra.getPalabra()) {
            case "prog":
                pila.push(palabra.getPalabra());
                pila.imprimir();
                break;
            case "var":
                pila.push(palabra.getPalabra());
                pila.imprimir();
                break;
            case "variable":
                pila.push(palabra.getPalabra());
                pila.imprimir();
                break;
            case "fprogram":
                pila.push(palabra.getPalabra());
                pila.imprimir();
                break;
            case "inicio":
                pila.push(palabra.getPalabra());
                pila.imprimir();

                break;
            case "escriba":
                pila.push(palabra.getPalabra());
                pila.imprimir();
                break;
            case "lea":
                pila.push(palabra.getPalabra());
                pila.imprimir();
                break;
            default:
                error.setError(0);
                error.setDescripcion("Falata palabra reservada " + palabra.getTipo() + " "
                        + palabra.getPalabra() + " " + palabra.getLinea());
                errorSintactico.add(error);
                break;
        }

        return true;

    }

    private boolean validaToken() {
       
        
        return true;
        
    }
}
