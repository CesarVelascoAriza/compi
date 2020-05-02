/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.ucentral.edu.analizadores;

import java.util.Scanner;
import co.ucentral.edu.model.Palabra;
import com.ucentral.compiladores.scorte.JFSegundoCorte;
import java.util.ArrayList;
import javax.swing.JTabbedPane;

/**
 *
 * @author Adolfo
 */
public class Lexico {
    
    private Scanner escaner; 
    private Scanner escanerSparte;
    ArrayList<Palabra> listaPalabras= new ArrayList<Palabra>();    
    
    public Lexico() {
    }

    public ArrayList<Palabra> analizadorLexico(String texto){
        escaner = new Scanner(texto);
        int linea =1;
        while(escaner.hasNext()){
            //System.out.printf("Texto = %s \t Linea = %d \n" , escaner.nextLine(),linea);
            tablaSimbolos(escaner.nextLine(), linea);
            linea++;
        }
        return listaPalabras;
    }
    public void tablaSimbolos(String linea, int numeroLinea){
        escanerSparte = new Scanner(linea);
        String tipo = "22";
        int i;
        while (escanerSparte.hasNext()) { 
            String pal=escanerSparte.next();
            Palabra palabra=new Palabra(numeroLinea, tipo, pal);
            listaPalabras.add(palabra);
        }
        
    }
    
}
