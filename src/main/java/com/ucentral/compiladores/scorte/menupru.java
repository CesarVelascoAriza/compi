/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucentral.compiladores.scorte;

import co.ucentral.compiladores.primercorte.AnalizadorLexico;
import co.ucentral.edu.analizadores.Lexico;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class menupru extends JFrame implements ActionListener {

    private MenuBar menuBar;
    private Menu menuArc;
    private Menu menuEdi;
    private Menu menuAna;
    private Menu menuEje;
    private Menu menuAyu;
    private MenuItem menuArcAbr;
    private MenuItem menuArcGua;
    private MenuItem menuArcSal;
    private MenuItem menuEdiCop;
    private MenuItem menuEdiCor;
    private MenuItem menuEdiPeg;
    private MenuItem menuEdiSel;
    private MenuItem menuAnaCom;
    private MenuItem menuEjeCor;
    private MenuItem menuAyuAyu;
    private MenuItem menuAyuAce;

    private JPanel status;
    private JPanel panelpp;

    private JLabel statusMsg1;
    private JLabel statusMsg2;

    private JScrollPane parea1;
    private JScrollPane parea2;

    private JTextArea area1;
    private JTextArea area2;

    private JFileChooser chooser;
    private File selFile;

    private String[][] simbolos;
    private String[] var;
    private int[] tipo;
    private String[][] valor;
    private char[] oprd;
    private int contd;
    private int contt;
    private boolean valid;

    boolean essalvar = true;
    String nombre = " ";

    public menupru() {
        setSize(new Dimension(640, 480));
        getContentPane().setLayout(new BorderLayout());
        setBackground(Color.black);
        //Barra de menu
        menuBar = new MenuBar();

        //Menu Archivos
        menuArc = new Menu();
        menuArcSal = new MenuItem();
        menuArcAbr = new MenuItem();
        menuArcGua = new MenuItem();
        menuArc.setLabel("Archivo");
        menuArcAbr.setLabel("Abrir");
        menuArcGua.setLabel("Guardar");
        menuArcSal.setLabel("Salir");
        menuArcSal.addActionListener(this);
        menuArcAbr.addActionListener(this);
        menuArcGua.addActionListener(this);
        menuArc.add(menuArcAbr);
        menuArc.add(menuArcGua);
        menuArc.add(menuArcSal);
        menuArc.insertSeparator(2);

        //menu Editor
        menuEdi = new Menu();
        menuEdiCop = new MenuItem();
        menuEdiCor = new MenuItem();
        menuEdiPeg = new MenuItem();
        menuEdiSel = new MenuItem();
        menuEdi.setLabel("Editar");
        menuEdiCop.setLabel("Copiar");
        menuEdiCor.setLabel("Cortar");
        menuEdiPeg.setLabel("Pegar");
        menuEdiSel.setLabel("Seleccionar Todo");
        menuEdiCop.addActionListener(this);
        menuEdiCor.addActionListener(this);
        menuEdiPeg.addActionListener(this);
        menuEdiSel.addActionListener(this);
        menuEdi.add(menuEdiCop);
        menuEdi.add(menuEdiCor);
        menuEdi.add(menuEdiPeg);
        menuEdi.add(menuEdiSel);

        //menu Analizar
        menuAna = new Menu();
        menuAnaCom = new MenuItem();
        menuAna.setLabel("Analizar");
        menuAnaCom.setLabel("Compilar");
        menuAnaCom.addActionListener(this);
        menuAna.add(menuAnaCom);

        //menu Ejecutar
        menuEje = new Menu();
        menuEjeCor = new MenuItem();
        menuEje.setLabel("Ejecutar");
        menuEjeCor.setLabel("Correr");
        menuEjeCor.addActionListener(this);
        menuEje.add(menuEjeCor);

        //menu Ayuda
        menuAyu = new Menu();
        menuAyuAyu = new MenuItem();
        menuAyuAce = new MenuItem();
        menuAyu.setLabel("Ayuda");
        menuAyuAyu.setLabel("Ayuda");
        menuAyuAce.setLabel("Acerca de...");
        menuAyuAyu.addActionListener(this);
        menuAyuAce.addActionListener(this);
        menuAyu.add(menuAyuAyu);
        menuAyu.add(menuAyuAce);

        //Agregar los elementos creados
        menuBar.add(menuArc);
        menuBar.add(menuEdi);
        menuBar.add(menuAna);
        menuBar.add(menuEje);
        menuBar.add(menuAyu);

        //Panel de control
        status = new JPanel();
        status.setLayout(new BorderLayout());
        statusMsg1 = new JLabel("Estado: ");
        statusMsg2 = new JLabel();
        status.add(statusMsg1, BorderLayout.WEST);
        status.add(statusMsg2, BorderLayout.CENTER);
        getContentPane().add(status, BorderLayout.SOUTH);

        //Creacion area de textos
        area1 = new JTextArea();
        area2 = new JTextArea();
        area2.setEditable(false);

        //Creacion de las barras Scroll
        parea1 = new JScrollPane(area1, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        parea2 = new JScrollPane(area2, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        //Panel de principal
        panelpp = new JPanel();
        panelpp.setLayout(new GridLayout(1, 1));
        panelpp.add(parea1);
        panelpp.add(parea2);

        getContentPane().add(panelpp, BorderLayout.CENTER);

        setTitle("Editor Pre - Compilador");
        setMenuBar(menuBar);
        setVisible(true);

        addWindowListener(new WindowAdapter() {
            public void WindowClosing(WindowEvent e) {
                System.exit(0);
            }
        }
        );
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == menuArcAbr) {
            cargarDatos();
        }
        if (e.getSource() == menuArcSal) {
            dispose();
        }
        if (e.getSource() == menuArcGua) {
            guardarDatos();
        }
        if (e.getSource() == menuEdiCop) {
            area1.copy();
        }
        if (e.getSource() == menuEdiCor) {
            area1.cut();
        }
        if (e.getSource() == menuEdiPeg) {
            area1.paste();
        }
        if (e.getSource() == menuEdiSel) {
            area1.selectAll();
        }
        if (e.getSource() == menuAnaCom) {
            statusMsg2.setText("Analizando");
            analizar();
            statusMsg2.setText("Analizado");
            menuArcGua.setEnabled(true);
            essalvar = false;
        }
        if (e.getSource() == menuAyuAyu) {
            ayuAyuda();
        }
        if (e.getSource() == menuAyuAce) {
            ayuAcerca();
        }
        if (e.getSource() == menuEjeCor) {
            ejeCor();
        }
    }

    public void ejeCor() {
        JOptionPane.showMessageDialog(null, "Funcion no instalada espere posteriores entregas");
    }

    public void ayuAyuda() {
        JOptionPane.showMessageDialog(null, "Dirijase al manual de referencia");
    }

    public void ayuAcerca() {
        JOptionPane.showMessageDialog(null, "Version Beta 1.0 \n\tElaborado por:\nEl desarrollador");
    }

    public void cargarDatos() {
        chooser = new JFileChooser();
        int sel = chooser.showOpenDialog(area1);
        if (sel == chooser.APPROVE_OPTION) {
            selFile = chooser.getSelectedFile();
            statusMsg2.setText("abriendo " + selFile.getAbsolutePath());
            String linea;
            try {
                FileReader fr = new FileReader(selFile.getAbsolutePath());
                BufferedReader entArch = new BufferedReader(fr);
                linea = entArch.readLine();
                area1.setText("");
                area2.setText("");
                while (linea != null) {
                    area1.setText(area1.getText() + linea + "\n");
                    linea = entArch.readLine();
                }
                entArch.close();
            } catch (IOException e) {
            }
        }
    }

    public void guardarDatos() {
        String Text = "";
        try {
            JFileChooser fc = new JFileChooser(System.getProperty("user.dir"));
            fc.showSaveDialog(this);
            File Guardar = fc.getSelectedFile();
            if (Guardar != null) {
                nombre = fc.getSelectedFile().getName();
                FileWriter Guardx = new FileWriter(Guardar);
                Guardx.write(area1.getText());
                Guardx.close();
            }
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
    }

    public void analizar() {
        
    }

    
}
