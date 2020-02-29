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
public class MainClass {

    private static int palabrasIsMinuscula;
    private static int palabrasIsMayusculas;
    private static int espaciosBlanco;
    private static int operadoresMatematicos;
    private static int operadoresDeRelacion;
    private static StringBuilder strinBuilder = new StringBuilder();

    /*
    (+,-,*,/,^)
     */
    public static void main(String[] args) {

        String prueba = "Prueba dos pruebas Cadena <= + * una < 98q";
        for (int i = 0; i < prueba.length(); i++) {
            Character caracter = prueba.charAt(i);
            analizarCaracter(caracter);
        }
        System.err.println("Cantidad de Caracteres minusculas " + palabrasIsMinuscula);
        System.err.println("Cantidad de Caracteres Mayusculas " + palabrasIsMayusculas);
        System.err.println("Cantidad de palabras spacios en blanco " + espaciosBlanco);
        System.err.println("Cantidad de operadores Matematicos  " + operadoresMatematicos);
        System.err.println("Cantidad de Simbolos especiales operadores de relacion  " + operadoresDeRelacion);
    }

    public static void analizarCaracter(Character caracter) {

        strinBuilder.append(caracter);

        analizarOperadoresMatematicos(caracter);
        if (Character.isLowerCase(caracter)) {
            palabrasIsMinuscula++;
        }
        if (Character.isUpperCase(caracter)) {
            palabrasIsMayusculas++;
        }
        if (Character.isSpaceChar(caracter)) {
            espaciosBlanco++;
            analizarPalabras(strinBuilder.toString());
        }

    }

    public static void analizarOperadoresMatematicos(Character caracter) {
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

    public static void analizarPalabras(String palabra) {
        if (palabra.trim().length() == 2) {
            opeladoresRelacionComplejos(palabra);
        }
        // System.out.println("palabras" + palabra);
        strinBuilder.setLength(0);
    }

    public static void analizarCadena(Character caracter) {

    }

    public static void opeladoresRelacionComplejos(String string) {
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

    public static void operadoresRelacion(Character caracter) {
        if (caracter.equals('>')) {
            operadoresDeRelacion++;
        }
        if (caracter.equals('<')) {
            operadoresDeRelacion++;
        }
    }
}
