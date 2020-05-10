/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.ucentral.edu.model;

/**
 *
 * @author rosemberg
 */
public class Palabra {
    private int linea;
    private String tipo;
    private String palabra;
    private String estado;

    public Palabra(int linea, String tipo, String palabra) {
        this.linea = linea;
        this.tipo = tipo;
        this.palabra = palabra;
    }

    public Palabra() {
    }

    public Palabra(String estado) {
        this.estado = estado;
    }
    
    

    public int getLinea() {
        return linea;
    }

    public void setLinea(int linea) {
        this.linea = linea;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
    
}
