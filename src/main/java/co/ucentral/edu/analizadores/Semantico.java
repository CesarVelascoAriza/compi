/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.ucentral.edu.analizadores;

import co.ucentral.edu.analizadores.Simbolos;
import co.ucentral.edu.model.Palabra;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author rosemberg
 */

/**
 * public String[] palabrasReservadas={"prog","haga","lea","escriba",
        "var", "inicio" ,"fprogram","entero", "real", "verdadero", "falso", "cadena" ,"y"
    ,"o", "no", "mientras", "haga", "fmientras","si", "sin", "fsi"};
    
    public String[] operadoresMatemáticos={"*" , "+" , "-" , "/" , "^" , "="};
    
    public String[] caracteresEspeciales={"@" , "." , ";" , "," , "{" , "}" , "(" , ")" ,"\""};
    
    public String[] operadoresRelComplejos= {">=" , "<=" , "<>" , "=="};
    
    public String[] operadoresRel= {">" , "<" };
 * @author rosemberg
 */
public class Semantico {
    Simbolos simbolo= new Simbolos();
    
    public String[] iniciaProg={ simbolo.palabrasReservadas[0], simbolo.palabrasReservadas[0]+" IDENTIFICADOR "};
    public String[] asignaVar={simbolo.palabrasReservadas[4]+" IDENTIFICADOR "+ simbolo.palabrasReservadas[7],
                               simbolo.palabrasReservadas[4]+" IDENTIFICADOR "+ simbolo.palabrasReservadas[8],
                               simbolo.palabrasReservadas[4]+" IDENTIFICADOR "+ simbolo.palabrasReservadas[9],
                               simbolo.palabrasReservadas[4]+" IDENTIFICADOR "+ simbolo.palabrasReservadas[10],
                               simbolo.palabrasReservadas[4]+" IDENTIFICADOR "+ simbolo.palabrasReservadas[11],
                            };
    public String[] indicarEscriba={simbolo.palabrasReservadas[3]+simbolo.caracteresEspeciales[6]+simbolo.caracteresEspeciales[8]+" LISTIDENTIFICADOR "+simbolo.caracteresEspeciales[8]+simbolo.caracteresEspeciales[7],
                                    simbolo.palabrasReservadas[3]+simbolo.caracteresEspeciales[6]+" IDENTIFICADOR "+simbolo.caracteresEspeciales[7]};
    //public String[] indicarEscribaVar={"RESERVADA CARACTERESP IDENTIFICADOR CARACTERESP"};
    public String[] indicarLea={simbolo.palabrasReservadas[2]+simbolo.caracteresEspeciales[6]+" IDENTIFICADOR "+simbolo.caracteresEspeciales[7]};
    
    
    public void analizadorEscriba(String linea)
    {
       System.out.println(linea);
    }

    void analizadorLea(String linea) 
    {
        System.out.println(linea);
    }
    
    
}
