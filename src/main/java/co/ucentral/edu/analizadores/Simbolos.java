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
        "var", "inicio" ,"fprogram","entero", "real", "verdadero", "falso", "cadena" ,"y"
    ,"o", "no", "mientras", "haga", "fmientras","si", "sin", "fsi"};
    
    public String[] operadoresMatemáticos={"*" , "+" , "-" , "/" , "^" , "="};
    
    public String[] caracteresEspeciales={"@" , "." , ";" , "," , "{" , "}" , "(" , ")" ,"\""};
    
    public String[] operadoresRelComplejos= {">=" , "<=" , "<>" , "=="};
    
    public String[] operadoresRel= {">" , "<" };
    
    public boolean validaNumeros(String caracter){
        try
        {
            Integer.parseInt(caracter);
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }
    
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

    public boolean esletra(Character caracter){
        if(Character.isLetter(caracter))
            return true;
        return false;
    }

}
