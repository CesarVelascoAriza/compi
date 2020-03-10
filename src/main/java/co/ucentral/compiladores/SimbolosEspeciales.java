/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3;

/**
 *
 * @author Sala_09
 */
public class SimbolosEspeciales {
    
    private int simbolosEspeciales;
    
    public void cuentaSimbolosEspeciales(String string) {
        if (string.equals(",")) {
            simbolosEspeciales++;
        }
        if (string.equals(";")) {
            simbolosEspeciales++;
        }
        if (string.equals(".")) {
            simbolosEspeciales++;
        }
    }
    
}
