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
public class Variables {
    private String identificador;
    private String tipo;
    private String valor;

    public Variables(String identificador, String tipo, String valor) {
        this.identificador = identificador;
        this.tipo = tipo;
        this.valor = valor;
    }

    public Variables() {
    }
    
    

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
    
    
    
}
