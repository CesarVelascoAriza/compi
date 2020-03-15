/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.ucentral.compiladores;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Adolfo
 */
public class AnalizadorLexico {

    private List<Preservadas> palabraReservada;
    private int palabrasIsMinuscula;
    private int palabrasIsMayusculas;
    private int caracteresIsMinuscula;
    private int caracteresIsMayusculas;
    private int espaciosBlanco;
    private int operadoresMatematicos;
    private int operadoresDeRelacion;
    private int otrosOperadores;
    private PalabrasReservadas reservada;
    private String[][] data;

    public AnalizadorLexico() {
        reservada = new PalabrasReservadas();
        palabraReservada = new ArrayList<>();
    }

    public int getPalabrasIsMinuscula() {
        return palabrasIsMinuscula;
    }

    public void setPalabrasIsMinuscula(int palabrasIsMinuscula) {
        this.palabrasIsMinuscula = palabrasIsMinuscula;
    }

    public int getPalabrasIsMayusculas() {
        return palabrasIsMayusculas;
    }

    public void setPalabrasIsMayusculas(int palabrasIsMayusculas) {
        this.palabrasIsMayusculas = palabrasIsMayusculas;
    }

    public int getEspaciosBlanco() {
        return espaciosBlanco;
    }

    public void setEspaciosBlanco(int espaciosBlanco) {
        this.espaciosBlanco = espaciosBlanco;
    }

    public int getOperadoresMatematicos() {
        return operadoresMatematicos;
    }

    public void setOperadoresMatematicos(int operadoresMatematicos) {
        this.operadoresMatematicos = operadoresMatematicos;
    }

    public int getOperadoresDeRelacion() {
        return operadoresDeRelacion;
    }

    public void setOperadoresDeRelacion(int operadoresDeRelacion) {
        this.operadoresDeRelacion = operadoresDeRelacion;
    }

    public void analizarPalabras(String palabra) {
        if (palabra.length() == 2) {
            opeladoresRelacionComplejos(palabra);
            System.out.println(palabra);
        }
        if (palabra.length() > 2) {

            Preservadas p = new Preservadas();
            p.setPalabra(palabra);
            p.setIspalabraReservada(reservada.isPalabraReservada(palabra));
            p.setCantidad(1);
            p.toString();
            palabraReservada.add(p);
            System.out.println(palabra);
            if (palabra.equals(palabra.toUpperCase())) {
                palabrasIsMayusculas++;
            }
            if (palabra.equals(palabra.toLowerCase())) {
                palabrasIsMinuscula++;
            }
        }
        if (palabra.length() == 1) {
            operadoresRelacion(palabra.charAt(0));
            analizarOperadoresMatematicos(palabra.charAt(0));
            caracterEspeciales(palabra.charAt(0));
        }
    }

    public void analizarOperadoresMatematicos(Character caracter) {
        if (caracter.equals('*')) {
            operadoresMatematicos++;
        }
        if (caracter.equals('-')) {
            operadoresMatematicos++;
        }
        if (caracter.equals('+')) {
            operadoresMatematicos++;
        }
        if (caracter.equals('/')) {
            operadoresMatematicos++;
        }
        if (caracter.equals('^')) {
            operadoresMatematicos++;
        }

    }

    public void caracterEspeciales(Character caracter) {
        if (caracter.equals('@')) {
            otrosOperadores++;
        }
        if (caracter.equals('.')) {
            otrosOperadores++;
        }
        if (caracter.equals(';')) {
            otrosOperadores++;
        }
        if (caracter.equals(',')) {
            otrosOperadores++;
        }
        if (caracter.equals('{')) {
            otrosOperadores++;
        }
        if (caracter.equals('}')) {
            otrosOperadores++;
        }
        if (caracter.equals('(')) {
            otrosOperadores++;
        }
        if (caracter.equals(')')) {
            otrosOperadores++;
        }
    }

    public void opeladoresRelacionComplejos(String string) {
        if (string.trim().equals(">=")) {
            operadoresDeRelacion++;
        }
        if (string.trim().equals("<=")) {
            operadoresDeRelacion++;
        }
        if (string.trim().equals("<>")) {
            operadoresDeRelacion++;
        }
    }

    public void operadoresRelacion(Character caracter) {
        if (caracter.equals('>')) {
            operadoresDeRelacion++;
        }
        if (caracter.equals('<')) {
            operadoresDeRelacion++;
        }
    }

    public void analizarCaracter(Character caracter) {
        if (Character.isLowerCase(caracter)) {
            caracteresIsMinuscula++;
        }
        if (Character.isUpperCase(caracter)) {
            caracteresIsMayusculas++;
        }
        if (Character.isSpaceChar(caracter)) {
            espaciosBlanco++;

        }

    }

    public DefaultTableModel getData() {
        String[] columnas = {"Palabra", "Es Reservada", "Cantidad"};
        DefaultTableModel datam = new DefaultTableModel(0, 0);
        String[][] data = new String[getPalabraReservada().size()][3];
        String[] row = new String[3];

        for (int column = 0; column < columnas.length; column++) {
            datam.addColumn(columnas[column]);
        }
        for (int i = 0; i < palabraReservada.size(); i++) {
            row[0] = palabraReservada.get(i).getPalabra();
            row[1] = String.valueOf(palabraReservada.get(i).isIspalabraReservada());
            row[2] = String.valueOf(palabraReservada.get(i).getCantidad());

            datam.addRow(row);
        }
        return datam;
    }

    public List<Preservadas> getPalabraReservada() {
        return palabraReservada;
    }

    public void setPalabraReservada(List<Preservadas> palabraReservada) {
        this.palabraReservada = palabraReservada;
    }

    public void analizarLinea(String linea) {
        for (int i = 0; i < linea.length(); i++) {
            analizarCaracter(linea.charAt(i));
        }
        System.err.println("Cantidad de Caracteres minusculas " + palabrasIsMinuscula);
        System.err.println("Cantidad de Caracteres Mayusculas " + palabrasIsMayusculas);
        System.err.println("Cantidad de palabras spacios en blanco " + espaciosBlanco);
        System.err.println("Cantidad de operadores Matematicos  " + operadoresMatematicos);
        System.err.println("Cantidad de Simbolos especiales operadores de relacion  " + operadoresDeRelacion);

    }

    public DefaultTableModel getDatasTablaTotales() {

        DefaultTableModel datam = new DefaultTableModel(
                new Object[][]{
                    {"Cantidad de Palabras minusculas", palabrasIsMinuscula},
                    {"Cantidad de Palabras Mayusculas", palabrasIsMayusculas},
                    {"Cantidad de Caracteres minusculas", caracteresIsMinuscula},
                    {"Cantidad de Caracteres Mayusculas", caracteresIsMayusculas},
                    {"Cantidad de spacios en blanco", espaciosBlanco},
                    {"Cantidad de operadores Matematicos", operadoresMatematicos},
                    {"Cantidad de Simbolos especiales operadores de relacion", operadoresDeRelacion},
                    {"Cantidad de Simbolos especiales", otrosOperadores},
                    {"Cantidad de Lienas", operadoresDeRelacion}
                },
                new String[]{
                    "Descripcíon", "cantidad"
                });

        return datam;

    }
}
