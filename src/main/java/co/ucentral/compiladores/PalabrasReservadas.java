/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.ucentral.compiladores;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Adolfo
 */
public class PalabrasReservadas {

    private List<String> listaPalabras;

    public PalabrasReservadas() {
        listaPalabras = new ArrayList<>();
        listaPalabras.add("entero");
        listaPalabras.add("real");
        listaPalabras.add("si");
        listaPalabras.add("sin");
        listaPalabras.add("para");
        listaPalabras.add("prog");
        listaPalabras.add("real");
        listaPalabras.add("cadena");
        listaPalabras.add("fprogram");
        listaPalabras.add("mientras");
        listaPalabras.add("haga");
        listaPalabras.add("fsi");
        listaPalabras.add("lea");
        listaPalabras.add("escriba");
        listaPalabras.add("variables");
        listaPalabras.add("inicio");
        listaPalabras.add("fmientras");

    }

    public boolean isPalabraReservada(String palabra) {
        boolean reservada = false;
        for (String listaPalabra : listaPalabras) {
            if (palabra.equals(listaPalabra)) {
                reservada = true;
            }

        }
        return reservada;
    }

}
