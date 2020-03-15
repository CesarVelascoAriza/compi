/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.ucentral.compiladores;

/**
 *
 * @author Adolfo
 */
public class AnalizadorLexico {

    private Preservadas palabraReservada;
    private int palabrasIsMinuscula;
    private int palabrasIsMayusculas;
    private int espaciosBlanco;
    private int operadoresMatematicos;
    private int operadoresDeRelacion;

    public Preservadas getPalabraReservada() {
        return palabraReservada;
    }

    public void setPalabraReservada(Preservadas palabraReservada) {
        this.palabraReservada = palabraReservada;
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
            System.out.println(palabra);
        }
        if (palabra.length() == 1) {
            operadoresRelacion(palabra.charAt(0));
            analizarOperadoresMatematicos(palabra.charAt(0));
            System.out.println("catidad de operadores " + this.getOperadoresMatematicos());
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

    public  void analizarCaracter(Character caracter) {
        if (Character.isLowerCase(caracter)) {
            palabrasIsMinuscula++;
        }
        if (Character.isUpperCase(caracter)) {
            palabrasIsMayusculas++;
        }
        if (Character.isSpaceChar(caracter)) {
            espaciosBlanco++;

        }

    }
}
