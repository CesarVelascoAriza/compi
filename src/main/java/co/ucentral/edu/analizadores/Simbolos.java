/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.ucentral.edu.analizadores;

/**
 *
 * @author Adolfo
 */
public class Simbolos {
    
    public String[] palabrasReservadas={"prog","haga","lea","escriba",
        "variables","var", "inicio" ,"fprogram" };
    
    public String[] operadoresMatemáticos={"*" , "+" , "-" , "/" , "^"};
    
    public String[] caracteresEspeciales={"@" , "." , ";" , "," , "{" , "}" , "(" , ")" };
    
    public String[] operadoresRelComplejos= {">=" , "<=" , "<>"};
    
    public String[] operadoresRel= {">" , "<" };
    
    
    public boolean analizarOperadoresMatematicos(Character caracter) {
        if (caracter.equals('*')) {
             return true;
        }
        if (caracter.equals('-')) {
            return true;
        }
        if (caracter.equals('+')) {
            return true;
        }
        if (caracter.equals('/')) {
            return true;
        }
        if (caracter.equals('^')) {
            return true;
        }
        return false;
    }

    public boolean caracterEspeciales(Character caracter) {
        if (caracter.equals('@')) {
            return true;
        }
        if (caracter.equals('.')) {
            return true;
        }
        if (caracter.equals(';')) {
            return true;
        }
        if (caracter.equals(',')) {
            return true;
        }
        if (caracter.equals('{')) {
            return true;
        }
        if (caracter.equals('}')) {
            return true;
        }
        if (caracter.equals('(')) {
            return true;
        }
        if (caracter.equals(')')) {
            return true;
        }
        return false;
    }

    public boolean opeladoresRelacionComplejos(String string) {
        if (string.trim().equals(">=")) {
            return true;
        }
        if (string.trim().equals("<=")) {
            return true;
        }
        if (string.trim().equals("<>")) {
            return true;
        }
        return false;
    }

    public boolean operadoresRelacion(Character caracter) {
        if (caracter.equals('>')) {
            return true;
        }
        if (caracter.equals('<')) {
            return true;
        }
        return false;
    }
    public boolean validaNumeros(Character caracter){
        if(Character.isDigit(caracter) )
        {
            return  true;
        }else{
            return  false;
        }
    }
    
//    public boolean palabrasReservadas(String palabra, String [] tipo){
//        boolean ispalabra=false;
//        for (String palabrasReservada : palabrasReservadas) {
//            if(palabrasReservada.equals(palabra)){
//                ispalabra= true;
//                break;
//            }
//        }
//        return ispalabra;
//    }
    
    
    public boolean definiTipo(String palabra, String [] tipo){
        boolean ispalabra=false;
        for (String palabrasReservada : tipo) {
            if(palabrasReservada.equals(palabra)){
                ispalabra= true;
                break;
            }
        }
        return ispalabra;
    }
}
