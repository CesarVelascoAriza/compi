/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.ucentral.edu.analizadores;

import co.ucentral.edu.model.Palabra;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Adolfo
 */
public class AnalizadorMientras {

    List<Integer> linea;
    boolean instruccio;
    private String operador;

    public AnalizadorMientras() {
       linea= new ArrayList<Integer>();
        instruccio = false;
        operador ="";
    }

    public void extraerEjecucion() {

    }

    public void extraerEjecucion(ArrayList<Palabra> listaPalabras) {
        boolean condicion= false;
        for (Palabra listaPalabra : listaPalabras) {
            if (listaPalabra.getPalabra().equals("mientras")) {
                System.err.println(listaPalabra.getPalabra());
                instruccio = true;
                condicion = true;
            }else if(listaPalabra.getPalabra().equals("haga")){
                condicion= false ;
            }
            else if (listaPalabra.getPalabra().equals("fmientras")) {
                instruccio = false;
                System.err.println(listaPalabra.getPalabra());
            }
            if(instruccio){
                analizarInstruccion(listaPalabra.getPalabra(),condicion);
                linea.add(listaPalabra.getLinea());
            }
            
        }
        
    }

    private void analizarInstruccion(String palabra, boolean condicion) {
        
        if(!palabra.equals("mientras") && !palabra.equals("haga")
                && !palabra.equals("fmientras") && condicion){
            if(Character.isDigit(palabra.charAt(0))){
                int ntero = Integer.parseInt(palabra) ;
                System.out.println("entero" + ntero);
            }
         
            this.operador += " " + palabra; 
        }
        
    }

    private void analizarInsCondicion(){
        
    }
}
