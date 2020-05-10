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
public class StackCoposition {

    private Lista listaPila;

    public StackCoposition() {
        listaPila = new Lista("pila");
    }

    public void push(Object objeto) {
        listaPila.insertarAlfrente(objeto);
    }

    public Object pop() throws ExceptionListaVacia {
        return listaPila.eliminarDelFrente();
    }

    public boolean estaVacia() {
        return listaPila.estaVacia();
    }

    public void imprimir() {
        listaPila.imprimir();
    }
}
