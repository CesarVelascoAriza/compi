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
public class MainClass {

    private static int palabrasIsMinuscula;
    private static int palabrasIsMayusculas;
    private static int espaciosBlanco;
    private static int operadoresMatematicos;
    private static int operadoresDeRelacion;
    private static StringBuilder strinBuilder = new StringBuilder();
    private static List<String> p= new ArrayList<>();
    /*
    (+,-,*,/,^)
     */
    public static void main(String[] args) {

        String prueba = "Prueba dos pruebas Cadena <= + * una < 98q";
        for (int i = 0; i < prueba.length(); i++) {
            Character caracter = prueba.charAt(i);
            analizarCaracter(caracter);
        }
        /*for (String string : p) {
            System.out.println(string);
        }*/
         
        System.err.println("Cantidad de Caracteres minusculas " + palabrasIsMinuscula);
        System.err.println("Cantidad de Caracteres Mayusculas " + palabrasIsMayusculas);
        System.err.println("Cantidad de palabras spacios en blanco " + espaciosBlanco);
        System.err.println("Cantidad de operadores Matematicos  " + operadoresMatematicos);
        System.err.println("Cantidad de Simbolos especiales operadores de relacion  " + operadoresDeRelacion);
        mostrarTablas(p, cargarPalabrasReservadas());
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
        if (palabra.trim().length()>2) {
            p.add(palabra.trim());
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
    public static List<String> cargarPalabrasReservadas(){
        List<String> palabrasReserbadas = new ArrayList<String>();
        palabrasReserbadas.add("entero");
        palabrasReserbadas.add("real");
        palabrasReserbadas.add("si");
        palabrasReserbadas.add("sin");
        palabrasReserbadas.add("para");
        palabrasReserbadas.add("prog");
        palabrasReserbadas.add("real");
        palabrasReserbadas.add("cadena");
        palabrasReserbadas.add("fprogram");
        palabrasReserbadas.add("mientras");
        palabrasReserbadas.add("haga");
        palabrasReserbadas.add("fsi");
        palabrasReserbadas.add("lea");
        palabrasReserbadas.add("escriba");
        palabrasReserbadas.add("variables");
        palabrasReserbadas.add("inicio");
        palabrasReserbadas.add("fmientras");
        
       return palabrasReserbadas;
    }
    public static String[][] mostrarTablas(List<String> palabras, List<String> cargarPalabrasReservadas){
        String[][] string = new String[palabras.size()][3];
        for (int i = 0; i < 5; i++) {
                string[i][0]=palabras.get(i);
                if(palabras.get(i).equals(cargarPalabrasReservadas.get(i)))
                    string[i][1] = "Si";
                else
                    string[i][1] = " No";
                if(palabras.get(i).equals(cargarPalabrasReservadas.get(i)))
                     string[i][2] = "Si";
                else
                    string[i][2] = " No"; 
                
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(string[i][j]);
            }
            System.out.println(" ");
        }
        
        return string;
    }
    
    
    ///simbolos terminales ; separador ,
}
