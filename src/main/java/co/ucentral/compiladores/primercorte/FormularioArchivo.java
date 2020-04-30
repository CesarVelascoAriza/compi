/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.ucentral.compiladores.primercorte;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;

/**
 *
 * @author Adolfo
 */
public class FormularioArchivo extends JFrame {

    private JButton examinar;
    private JLabel rutaArchivo;
    private JPanel JpanelArchivo;
    private JPanel jPaneltabla;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JTable jTableDatos;
    private JTable jTableDatosCuentas;
    private JTextField jTextFieldMuestraRuta;
    private JPanel panelTablaContadores;
    private JButton analizar;
    private ManejadorFormulario manager;
    private JButton limpiar;

    public FormularioArchivo() {
        initComponentes();
    }

    public void initComponentes() {

        JpanelArchivo = new JPanel();
        rutaArchivo = new JLabel();
        jTextFieldMuestraRuta = new JTextField();
        examinar = new JButton();
        jPaneltabla = new JPanel();
        jScrollPane1 = new JScrollPane();
        jScrollPane2 = new JScrollPane();
        jTableDatos = new JTable();
        panelTablaContadores = new JPanel();
        jTableDatosCuentas = new JTable();
        analizar = new JButton("Analizar");
        manager = new ManejadorFormulario();
        limpiar = new JButton();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        this.setTitle("PROGRAMA 1");
        JpanelArchivo.setBorder(BorderFactory.createTitledBorder("Archivo"));

        rutaArchivo.setText("Ruta Archivo");

        examinar.setText("Examinar");
        limpiar.setText("Limpiar");
        analizar.setEnabled(false);
        GroupLayout jPanel1Layout = new GroupLayout(JpanelArchivo);
        JpanelArchivo.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(rutaArchivo, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldMuestraRuta)
                        .addGap(18, 18, 18)
                        .addComponent(examinar, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(analizar, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(limpiar, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39))
        );
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(rutaArchivo)
                                .addComponent(jTextFieldMuestraRuta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(examinar)
                                .addComponent(analizar)
                                .addComponent(limpiar))
                        .addContainerGap(31, Short.MAX_VALUE))
        );
        jTableDatos.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                    {null, null, null, null}},
                new String[]{
                    "Palabra", "Es Reservada", "Cantidad"
                }
        ));
        jPaneltabla.setBorder(BorderFactory.createTitledBorder("Tabla"));

        jScrollPane1.setViewportView(jTableDatos);

        GroupLayout jPanel2Layout = new GroupLayout(jPaneltabla);
        jPaneltabla.setLayout(jPanel2Layout);

        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 872, Short.MAX_VALUE)
                                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)
                                .addContainerGap())
        );

        panelTablaContadores.setBorder(BorderFactory.createTitledBorder("Contadores"));

        jTableDatosCuentas.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                    {null, null}},
                new String[]{
                    "Descripcíon", "cantidad"
                }
        ));

        jScrollPane2.setViewportView(jTableDatosCuentas);

        GroupLayout panel3Layaut = new GroupLayout(panelTablaContadores);
        panelTablaContadores.setLayout(panel3Layaut);

        panel3Layaut.setHorizontalGroup(
                panel3Layaut.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel3Layaut.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 976, Short.MAX_VALUE)
                                .addContainerGap())
        );
        panel3Layaut.setVerticalGroup(
                panel3Layaut.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel3Layaut.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                                .addContainerGap())
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(JpanelArchivo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPaneltabla, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(panelTablaContadores, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        )
                        .addContainerGap())
        );
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(JpanelArchivo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPaneltabla, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelTablaContadores, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
        );
        analizar.addActionListener(manager);
        examinar.addActionListener(manager);
        limpiar.addActionListener(manager);
        pack();
    }

   

    private class ManejadorFormulario implements ActionListener {

        private JFileChooser filechooser;
        private ManejoArchivos archivo;

        public ManejadorFormulario() {
            filechooser = new JFileChooser();
            archivo = new ManejoArchivos();
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == analizar) {
                
                    archivo.setRuta(jTextFieldMuestraRuta.getText());
                    try {
                        archivo.abrirArchivo();
                        archivo.leerRegistros();
                        jTableDatos.setModel(archivo.getData());
                        archivo.abrirArchivo();
                        archivo.leer();
                        jTableDatosCuentas.setModel(archivo.getDatatableCuenta());
                    } catch (FileNotFoundException ex) {

                    }
                
            }
            if (e.getSource() == examinar) {
                int selection = filechooser.showOpenDialog(JpanelArchivo);
                if (selection == JFileChooser.APPROVE_OPTION) {
                    File file = filechooser.getSelectedFile();
                    jTextFieldMuestraRuta.setText(file.getAbsolutePath());
                    jTextFieldMuestraRuta.setEditable(false);
                    analizar.setEnabled(true);
                }
            }
            if (e.getSource() == limpiar) {
                jTextFieldMuestraRuta.setText("");
                jTextFieldMuestraRuta.setEditable(true);
                analizar.setEnabled(false);
                jTableDatos.setModel(new javax.swing.table.DefaultTableModel(
                        new Object[][]{
                            {null, null, null, null}},
                        new String[]{
                            "Palabra", "Es Reservada", "Cantidad"
                        }
                ));
                jTableDatosCuentas.setModel(new javax.swing.table.DefaultTableModel(
                        new Object[][]{
                            {null, null}},
                        new String[]{
                            "Descripcíon", "cantidad"
                        }
                ));
            }
        }

    }
}
