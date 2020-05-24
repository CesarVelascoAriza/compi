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

        "variable","var", "inicio" ,"fprogram","entero", "real","booleano", "verdadero", "falso", "cadena" ,"y"

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
    
    public String tipoPalabra(String palabra) {
        String tipoPal="";
        if(definiTipo(palabra, palabrasReservadas))
        {
            tipoPal="RESERVADA";
        }
        else if(definiTipo(palabra, operadoresMatemáticos))
        {
            tipoPal="MATHOPERADOR";
        }
        else if(definiTipo(palabra, caracteresEspeciales))
        {
            tipoPal="CARACTERESP";
        }
        else if(definiTipo(palabra, operadoresRelComplejos))
        {
            tipoPal="OPERADORRELCOMPLEJO";
        }
        else if(definiTipo(palabra, operadoresRel))
        {
            tipoPal="OPERADORREL";
        }
        else if(validaNumeros(palabra))
        {
            tipoPal="NUMERICO";
        }
        else
        {
            tipoPal="IDENTIFICADOR";
        }
        return tipoPal;
    }

    public String separar(String[] signos, String pal) {
        String newPal = pal;
        
        switch(signos[0])
        {
            case "=" :
                //String [] signos = {"=" , "(" , ")" , "\"" , "+" , "-" , "*" , "/" , "^"};
                if(pal.contains(signos[0])){ newPal= newPal.replace("=", " = ");}
                if(pal.contains(signos[1])){ newPal= newPal.replace("(", " ( ");}
                if(pal.contains(signos[2])){ newPal= newPal.replace(")", " ) ");}
                if(pal.contains(signos[3])){ newPal= newPal.replace("\"", " \" ");}
                if(pal.contains(signos[4])){ newPal= newPal.replace("+", " + ");}
                if(pal.contains(signos[5])){ newPal= newPal.replace("-", " - ");}
                if(pal.contains(signos[6])){ newPal= newPal.replace("*", " * ");}
                if(pal.contains(signos[7])){ newPal= newPal.replace("/", " / ");}
                if(pal.contains(signos[8])){ newPal= newPal.replace("^", " ^ ");}
                break;
            case ">=" :
                //String [] signosCompl = { ">=" , "<=" , "<>" , "==" , "(" , ")" , "\"" };
                if(pal.contains(signos[0])){ newPal= newPal.replace(">=", " >= ");}
                if(pal.contains(signos[1])){ newPal= newPal.replace("<=", " <= ");}
                if(pal.contains(signos[2])){ newPal= newPal.replace("<>", " <> ");}
                if(pal.contains(signos[3])){ newPal= newPal.replace("==", " == ");}
                if(pal.contains(signos[4])){ newPal= newPal.replace("(", " ( ");}
                if(pal.contains(signos[5])){ newPal= newPal.replace(")", " ) ");}
                if(pal.contains(signos[6])){ newPal= newPal.replace("\"", " \" ");}
                break;
                    
        }
        
        return newPal;
    }
    
}
