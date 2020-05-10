/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ucentral.edu.Stack;

/**
 *
 * @author Adolfo
 */
public class ExceptionListaVacia extends RuntimeException {

    public ExceptionListaVacia() {
        this("Lista");
    }

    
    public ExceptionListaVacia(String nombre) {
        super(nombre + "esta vacia");
    }

    
    
}
