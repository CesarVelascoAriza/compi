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
public class PalabrasReservadas {
    
    private String palabraReservada;
    private List<String> listaPalabras;
    
    
    public PalabrasReservadas(){
        listaPalabras = new ArrayList<>();
        listaPalabras.add("");
        listaPalabras.add("");
        listaPalabras.add("");
        listaPalabras.add("");
        listaPalabras.add("");
        listaPalabras.add("");
        listaPalabras.add("");
        listaPalabras.add("");
        listaPalabras.add("");
        listaPalabras.add("");
        listaPalabras.add("");
        listaPalabras.add("");
        listaPalabras.add("");
        listaPalabras.add("");
        listaPalabras.add("");
        
    }
    
    
    public void setPalabrasReservada(String palabra){
        this.palabraReservada = palabra;
    }
    public String getPalabrasReservada(){
        return this.palabraReservada;
    }
    
    
}
