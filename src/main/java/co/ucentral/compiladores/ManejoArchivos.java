/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.ucentral.compiladores;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Adolfo
 */
public class ManejoArchivos {

    private String ruta;
    private Scanner scaner;
    private AnalizadorLexico analizador;
    private DefaultTableModel data;
    private DefaultTableModel datatableCuenta;

    public ManejoArchivos() {
        analizador = new AnalizadorLexico();
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public void abrirArchivo() throws FileNotFoundException {
        File file = new File(getRuta());
        scaner = new Scanner(file);

    }

    public void leerRegistros() {

        try {
            while (scaner.hasNext()) {
                analizador.analizarPalabras(scaner.next());
            }
            setData(analizador.getData());
        } catch (Exception e) {

            System.exit(1);
            System.out.println();
        }

    }

    public void leer() {

        try {
            while (scaner.hasNext()) {
                analizador.analizarLinea(scaner.nextLine());
            }
            setDatatableCuenta(analizador.getDatasTablaTotales());
        } catch (Exception e) {

            System.exit(1);
            System.out.println();
        }

    }

    public DefaultTableModel getData() {
        return data;
    }

    public void setData(DefaultTableModel data) {
        this.data = data;
    }

    public DefaultTableModel getDatatableCuenta() {
        return datatableCuenta;
    }

    public void setDatatableCuenta(DefaultTableModel datatableCuenta) {
        this.datatableCuenta = datatableCuenta;
    }

}
