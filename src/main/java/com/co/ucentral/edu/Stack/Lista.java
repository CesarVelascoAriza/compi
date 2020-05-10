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
class NodoLista {

    Object datos;
    NodoLista siguienteNodo;

     NodoLista(Object objeto) {
        this(objeto, null);
    }

    NodoLista(Object datos, NodoLista siguienteNodo) {
        this.datos = datos;
        this.siguienteNodo = siguienteNodo;
    }

    Object obtenerObjeto() {
        return datos;
    }

    NodoLista obtenerSiguiente() {
        return siguienteNodo;
    }
}

public class Lista {

    private NodoLista primerNodo;
    private NodoLista ultimoNodo;
    private String nombre;

    public Lista() {
    }

    public Lista(String nombrelista) {
        this.nombre = nombrelista;
        primerNodo = ultimoNodo = null;
         
    }

    public void insertarAlfrente(Object elementoInsertar) {
        if (estaVacia()) {
            primerNodo = ultimoNodo = new NodoLista(elementoInsertar);
        } else {
            primerNodo = new NodoLista(elementoInsertar, primerNodo);
        }

    }

    public void insertarAlfinal(Object elementoInsertar) {
        if (estaVacia()) {
            primerNodo = ultimoNodo = new NodoLista(elementoInsertar);
        } else {
            ultimoNodo = ultimoNodo.siguienteNodo = new NodoLista(elementoInsertar);
        }

    }

    public Object eliminarDelFrente() throws ExceptionListaVacia {
        if (estaVacia()) {
            throw new ExceptionListaVacia(nombre);
        }
        Object elementoElimonado = primerNodo.datos;
        if (primerNodo == ultimoNodo) {
            primerNodo = ultimoNodo = null;
        } else {
            primerNodo = primerNodo.siguienteNodo;
        }
        return elementoElimonado;
    }

    public Object eliminarDelFinal() throws ExceptionListaVacia {
        if (estaVacia()) {
            throw new ExceptionListaVacia(nombre);
        }
        Object elementoElimonado = ultimoNodo.datos;
        if (primerNodo == ultimoNodo) {
            primerNodo = ultimoNodo = null;
        } else {
            NodoLista actual = primerNodo;
            while (actual.siguienteNodo != ultimoNodo) {
                actual = actual.siguienteNodo;
            }
            ultimoNodo = actual;
            actual.siguienteNodo = null;

        }

        return elementoElimonado;
    }

    public boolean estaVacia() {
        return primerNodo == null;
    }

    public void imprimir() {
        if (estaVacia()) {
            System.out.printf("%s vacia \n ", nombre);
            return;
        }
        System.out.printf("la %s es  ", nombre);
        NodoLista actual = primerNodo;
        while (actual != null) {
            System.out.printf("%s  ", actual.datos);
            actual = actual.siguienteNodo;

        }
        System.out.println("\n");
    }
}
