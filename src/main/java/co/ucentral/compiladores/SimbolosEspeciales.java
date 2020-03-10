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
    public  void analizarPalabrasEntreMayusculasMinusculas(String palabra, int a) {

        if (a < palabra.length()) {
            analizarPa(palabra.charAt(a), a);
            a++;
            analizarPalabrasEntreMayusculasMinusculas(palabra, a);
        }
    }

    public  void analizarPa(Character caracter, int a) {
        if (Character.isLetter(caracter)) {
            if (Character.isLowerCase(caracter)) {
                System.out.println(caracter);
            }
            if (Character.isUpperCase(caracter)) {
                System.out.println(caracter);
            }
        }else if(Character.isDigit(caracter)){
            System.out.println("es digito");
        } else{
                System.out.println("otro caracter");
        } 
    }
}
