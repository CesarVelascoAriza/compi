/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucentral.compiladores.scorte;

import co.ucentral.edu.analizadores.AnalizadorMientras;
import co.ucentral.edu.analizadores.Lexico;
import co.ucentral.edu.analizadores.Semantico;
import co.ucentral.edu.model.Palabra;
import co.ucentral.edu.model.Variables;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author Adolfo
 */
public class FrameSCorte extends javax.swing.JFrame {

     private Lexico lexico;
     private Semantico semantico;
     ArrayList<Palabra> listaPalabras;
     private boolean okSintactico;
     private AnalizadorMientras mientras;
    public FrameSCorte() {
        initComponents();
        lexico = new Lexico();
        semantico = new Semantico();
        listaPalabras = new ArrayList<>();
        mientras = new AnalizadorMientras();
    }

    public void settAreaRanalisis(JTextArea tAreaRanalisis) {
        this.tAreaRanalisis = tAreaRanalisis;
    }

    public JTextArea gettAreaRanalisis() {
        return tAreaRanalisis;
    }

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelArchivo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txfRutaArchivo = new javax.swing.JTextField();
        btnArchivo = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btnLimpiar = new javax.swing.JButton();
        btnAnalizar = new javax.swing.JButton();
        btnEjecutar = new javax.swing.JButton();
        jPanelTexArea = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tAareaImpresion = new javax.swing.JTextArea();
        jPanelTabla = new javax.swing.JPanel();
        tablaSimbolos = new javax.swing.JScrollPane();
        tbSimbolos = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tAreaRanalisis = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Compilador Compi 3");

        jLabel1.setText("Ruta del archivo");

        txfRutaArchivo.setEnabled(false);

        btnArchivo.setText("Seleccionar Archivo");
        btnArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArchivoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelArchivoLayout = new javax.swing.GroupLayout(jPanelArchivo);
        jPanelArchivo.setLayout(jPanelArchivoLayout);
        jPanelArchivoLayout.setHorizontalGroup(
            jPanelArchivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelArchivoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txfRutaArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnArchivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelArchivoLayout.setVerticalGroup(
            jPanelArchivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelArchivoLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanelArchivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txfRutaArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnArchivo))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        btnAnalizar.setText("Analizar");
        btnAnalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnalizarActionPerformed(evt);
            }
        });

        btnEjecutar.setText("Ejecutar");
        btnEjecutar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEjecutarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(btnLimpiar)
                .addGap(44, 44, 44)
                .addComponent(btnAnalizar)
                .addGap(43, 43, 43)
                .addComponent(btnEjecutar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLimpiar)
                    .addComponent(btnAnalizar)
                    .addComponent(btnEjecutar))
                .addContainerGap())
        );

        tAareaImpresion.setColumns(20);
        tAareaImpresion.setRows(5);
        jScrollPane1.setViewportView(tAareaImpresion);

        javax.swing.GroupLayout jPanelTexAreaLayout = new javax.swing.GroupLayout(jPanelTexArea);
        jPanelTexArea.setLayout(jPanelTexAreaLayout);
        jPanelTexAreaLayout.setHorizontalGroup(
            jPanelTexAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTexAreaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelTexAreaLayout.setVerticalGroup(
            jPanelTexAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTexAreaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                .addGap(7, 7, 7))
        );

        jPanelTabla.setMaximumSize(new java.awt.Dimension(327679, 32767));

        tbSimbolos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "Palabra", "Liena", "Tipo"
            }
        ));
        tablaSimbolos.setViewportView(tbSimbolos);

        javax.swing.GroupLayout jPanelTablaLayout = new javax.swing.GroupLayout(jPanelTabla);
        jPanelTabla.setLayout(jPanelTablaLayout);
        jPanelTablaLayout.setHorizontalGroup(
            jPanelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTablaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tablaSimbolos, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelTablaLayout.setVerticalGroup(
            jPanelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTablaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tablaSimbolos, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                .addContainerGap())
        );

        tAreaRanalisis.setColumns(20);
        tAreaRanalisis.setRows(5);
        jScrollPane3.setViewportView(tAreaRanalisis);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelTabla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelArchivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanelTexArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(20, 20, 20)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelTexArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                .addComponent(jPanelTabla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(220, 220, 220)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(277, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEjecutarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEjecutarActionPerformed
        ArrayList<Variables> variables = semantico.getListaVar();
        ArrayList<Palabra> palabra = new ArrayList<Palabra>();
        Palabra p= new Palabra();
        if(!okSintactico)
        {
            tAreaRanalisis.setText(tAreaRanalisis.getText() +"\n" + "Fallas en Analizador Sintactico: No se puede iniciar el analizador Semántico");
        }
        else
        {
            int linea=1;
            String strlinea=tAareaImpresion.getText();
            String analizaLinea = "";
            ArrayList<String> listLinea = new ArrayList();
            listLinea = semantico.getArray(strlinea);
            
            while(listLinea.size()>=linea)
            {
                analizaLinea = listLinea.get(linea);
                palabra = semantico.tablaSimbolos(analizaLinea, linea);
                
                p=palabra.get(0);
                
                if(!p.getTipo().equals("IDENTIFICADOR"))
                {
                    switch(p.getPalabra())
                    {
                        case "variable":
                        case "var":
                           //strlinea=lexico.traeLinea(p.getLinea());
                           semantico.analizadorVariable(analizaLinea,linea);
                           linea++;
                        break;
                        case "escriba":
                           //strlinea=lexico.traeLinea(p.getLinea());
                           semantico.analizadorEscriba(analizaLinea,linea); 
                           tAreaRanalisis.setText(tAreaRanalisis.getText() +"\n" + semantico.gettAEscriba());
                           linea++;
                        break;

                        case "lea":
                            //strlinea=lexico.traeLinea(p.getLinea());
                            semantico.analizadorLea(analizaLinea,linea);
                            linea++;
                        break;
                        case "si":
                        case "sin":
                        case "fsi":
                            //strlinea=lexico.traeLinea(p.getLinea());
                            semantico.analizadorSi(analizaLinea,linea);
                            
                        break;
                        case "para":
                            //strlinea=lexico.traeLinea(p.getLinea());
                            semantico.analizadorPara(analizaLinea,linea);
                        break;
                        case "inicio":
                        case "prog":
                        case "fprogram":
                            linea++;
                        break;
                    }
                }
                else
                {
                    for(Variables v : variables)
                    {
                        if(p.getPalabra().equals(v.getIdentificador()))
                        {
                            System.out.println(p.getPalabra() + " Vamos a asignarle un valor");
                            linea++;
                        }
                    }
                }
            }
        }  
        
    }//GEN-LAST:event_btnEjecutarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        tAreaRanalisis.setText("");
        txfRutaArchivo.setText("");
        tAareaImpresion.setText("");
        tbSimbolos.setModel(new javax.swing.table.DefaultTableModel(
                        new Object[][] {
                             null,null,null
                        },
                        new String[]{
                            "Nombre", "Linea", "Tipo"
                        }
                ));
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnAnalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnalizarActionPerformed
       try {
            if (!tAareaImpresion.getText().isEmpty()) {
//                ArrayList<Palabra> listaPalabras = new ArrayList<>();
                listaPalabras = lexico.analizadorLexico(tAareaImpresion.getText());
                tAreaRanalisis.setText(lexico.getMensaje());
                if (!lexico.getAutomata().getErrorSintactico().isEmpty()) {
                    for (int i = 0; i < lexico.getAutomata().getErrorSintactico().size(); i++) {
                        tAreaRanalisis.setText(lexico.getAutomata().getErrorSintactico().get(i).getDescripcion() + "\n");
                    }
                } else {

                    tAreaRanalisis.setText(tAreaRanalisis.getText() + "\n" + lexico.getAutomata().getMensaje());
                    okSintactico=true;
                }

                String mostrarTabla[][] = new String[listaPalabras.size()][3];
                for (int i = 0; i < listaPalabras.size(); i++) {
                    mostrarTabla[i][0] = listaPalabras.get(i).getPalabra();
                    mostrarTabla[i][1] = String.valueOf(listaPalabras.get(i).getLinea());
                    mostrarTabla[i][2] = listaPalabras.get(i).getTipo();
                }

                tbSimbolos.setModel(new javax.swing.table.DefaultTableModel(
                        mostrarTabla,
                        new String[]{
                            "Nombre", "Linea", "Tipo"
                        }
                ));
            } else {
                JOptionPane.showMessageDialog(null, "No se ha seleccionado Ningun archivo","Text area vacia",JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en el analisís","Vacias",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAnalizarActionPerformed

    private void btnArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArchivoActionPerformed
       String aux = "";
        try {

            JFileChooser fl = new JFileChooser();
            fl.showOpenDialog(this);
            File archivo = fl.getSelectedFile();
            if (archivo != null) {
                txfRutaArchivo.setText(archivo.getAbsolutePath());
                FileReader freader = new FileReader(archivo);
                BufferedReader br = new BufferedReader(freader);
                while ((aux = br.readLine()) != null) {
                    System.out.println("br = " + aux);
                    tAareaImpresion.setText(tAareaImpresion.getText() + aux + "\n");

                }
            }

        } catch (Exception e) {
            System.err.println("");

        }
    }//GEN-LAST:event_btnArchivoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrameSCorte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameSCorte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameSCorte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameSCorte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameSCorte().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnalizar;
    private javax.swing.JButton btnArchivo;
    private javax.swing.JButton btnEjecutar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelArchivo;
    private javax.swing.JPanel jPanelTabla;
    private javax.swing.JPanel jPanelTexArea;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea tAareaImpresion;
    private javax.swing.JTextArea tAreaRanalisis;
    private javax.swing.JScrollPane tablaSimbolos;
    private javax.swing.JTable tbSimbolos;
    private javax.swing.JTextField txfRutaArchivo;
    // End of variables declaration//GEN-END:variables
}
