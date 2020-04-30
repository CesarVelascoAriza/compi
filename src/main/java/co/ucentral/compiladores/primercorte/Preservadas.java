/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.ucentral.compiladores.primercorte;

import java.util.Formatter;

/**
 *
 * @author Sala_09
 */
public class Preservadas {

    private String palabra;
    private boolean ispalabraReservada;
    private int cantidad;

    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    public boolean isIspalabraReservada() {
        return ispalabraReservada;
    }

    public void setIspalabraReservada(boolean ispalabraReservada) {
        this.ispalabraReservada = ispalabraReservada;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String toString() {

        return String.format(" %s \t  %s \t  %s \n ", getPalabra(), isIspalabraReservada(), getCantidad());

    }

}
