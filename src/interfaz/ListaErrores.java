/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import excepciones.MyException;
import gestor.GestorBD;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Marcos
 */
public class ListaErrores extends javax.swing.JFrame {

    VistaEncargado e;
    VistaGestor gestor;
    DefaultTableModel dtm;
    
    public ListaErrores(VistaEncargado encar) {
        initComponents();
        this.setVisible(true);
        this.e = encar;
        listaFecha.setText(GestorBD.fecha());
        
        dtm = (DefaultTableModel) tablaErrores.getModel();
        dtm.addTableModelListener(tablaErrores);
    }
    
    public ListaErrores(VistaGestor g) {
        initComponents();
        this.setVisible(true);
        this.gestor = g;
        listaFecha.setText(GestorBD.fecha());
        
        dtm = (DefaultTableModel) tablaErrores.getModel();
        dtm.addTableModelListener(tablaErrores);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelFondoLista = new javax.swing.JPanel();
        panelListaSuperior = new javax.swing.JPanel();
        listaFecha = new javax.swing.JLabel();
        nomListaEmpresa = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaErrores = new javax.swing.JTable();
        botonListaSalir = new javax.swing.JButton();
        inputFechaInicialErrores = new com.toedter.calendar.JDateChooser();
        inputFechaFinalErrores = new com.toedter.calendar.JDateChooser();
        txtFechaInicialErrores = new javax.swing.JLabel();
        botonGenerarListaErrores = new javax.swing.JButton();
        txtFechaFinalErrores = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(651, 400));
        setResizable(false);

        panelFondoLista.setPreferredSize(new java.awt.Dimension(682, 400));

        panelListaSuperior.setBackground(new java.awt.Color(0, 102, 204));

        listaFecha.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        listaFecha.setForeground(new java.awt.Color(240, 240, 240));
        listaFecha.setText("Fecha");

        nomListaEmpresa.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        nomListaEmpresa.setForeground(new java.awt.Color(240, 240, 240));
        nomListaEmpresa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icono_CoX.png"))); // NOI18N
        nomListaEmpresa.setText("CoX Manager");

        javax.swing.GroupLayout panelListaSuperiorLayout = new javax.swing.GroupLayout(panelListaSuperior);
        panelListaSuperior.setLayout(panelListaSuperiorLayout);
        panelListaSuperiorLayout.setHorizontalGroup(
            panelListaSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelListaSuperiorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nomListaEmpresa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(listaFecha)
                .addGap(50, 50, 50))
        );
        panelListaSuperiorLayout.setVerticalGroup(
            panelListaSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelListaSuperiorLayout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(panelListaSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomListaEmpresa)
                    .addComponent(listaFecha)))
        );

        tablaErrores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "COD_ERROR", "DIA", "HORA", "CANTIDAD AFECTADA", "DESCRIPCION"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaErrores.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tablaErrores);
        if (tablaErrores.getColumnModel().getColumnCount() > 0) {
            tablaErrores.getColumnModel().getColumn(0).setResizable(false);
            tablaErrores.getColumnModel().getColumn(0).setPreferredWidth(10);
            tablaErrores.getColumnModel().getColumn(1).setResizable(false);
            tablaErrores.getColumnModel().getColumn(1).setPreferredWidth(10);
            tablaErrores.getColumnModel().getColumn(2).setResizable(false);
            tablaErrores.getColumnModel().getColumn(2).setPreferredWidth(10);
            tablaErrores.getColumnModel().getColumn(3).setResizable(false);
            tablaErrores.getColumnModel().getColumn(3).setPreferredWidth(10);
            tablaErrores.getColumnModel().getColumn(4).setResizable(false);
            tablaErrores.getColumnModel().getColumn(4).setPreferredWidth(150);
        }

        botonListaSalir.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        botonListaSalir.setText("SALIR");
        botonListaSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonListaSalirActionPerformed(evt);
            }
        });

        inputFechaInicialErrores.setDateFormatString("dd/MM/yyyy");

        inputFechaFinalErrores.setDateFormatString("dd/MM/yyyy");

        txtFechaInicialErrores.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtFechaInicialErrores.setText("Fecha Inicial:");

        botonGenerarListaErrores.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        botonGenerarListaErrores.setText("CARGAR DATOS");
        botonGenerarListaErrores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGenerarListaErroresActionPerformed(evt);
            }
        });

        txtFechaFinalErrores.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtFechaFinalErrores.setText("Fecha Final:");

        javax.swing.GroupLayout panelFondoListaLayout = new javax.swing.GroupLayout(panelFondoLista);
        panelFondoLista.setLayout(panelFondoListaLayout);
        panelFondoListaLayout.setHorizontalGroup(
            panelFondoListaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelListaSuperior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFondoListaLayout.createSequentialGroup()
                .addGroup(panelFondoListaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelFondoListaLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(txtFechaInicialErrores)
                        .addGap(18, 18, 18)
                        .addComponent(inputFechaInicialErrores, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(102, 102, 102)
                        .addComponent(txtFechaFinalErrores)
                        .addGap(18, 18, 18)
                        .addComponent(inputFechaFinalErrores, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelFondoListaLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(panelFondoListaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelFondoListaLayout.createSequentialGroup()
                                .addComponent(botonGenerarListaErrores)
                                .addGap(192, 192, 192)
                                .addComponent(botonListaSalir))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(49, 49, 49))
        );
        panelFondoListaLayout.setVerticalGroup(
            panelFondoListaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFondoListaLayout.createSequentialGroup()
                .addComponent(panelListaSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(panelFondoListaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inputFechaInicialErrores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputFechaFinalErrores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFechaInicialErrores)
                    .addComponent(txtFechaFinalErrores))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelFondoListaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(botonGenerarListaErrores, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelFondoListaLayout.createSequentialGroup()
                        .addComponent(botonListaSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(1, 1, 1)))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelFondoLista, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 673, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelFondoLista, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonGenerarListaErroresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGenerarListaErroresActionPerformed
        try {
            cargarTabla();
        } catch (MyException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_botonGenerarListaErroresActionPerformed

    private void botonListaSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonListaSalirActionPerformed
        this.setVisible(false);
        if (e != null){
            e.volver();
        }
        else if(gestor != null){
            gestor.volver();
        }
    }//GEN-LAST:event_botonListaSalirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonGenerarListaErrores;
    private javax.swing.JButton botonListaSalir;
    private com.toedter.calendar.JDateChooser inputFechaFinalErrores;
    private com.toedter.calendar.JDateChooser inputFechaInicialErrores;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel listaFecha;
    private javax.swing.JLabel nomListaEmpresa;
    private javax.swing.JPanel panelFondoLista;
    private javax.swing.JPanel panelListaSuperior;
    private javax.swing.JTable tablaErrores;
    private javax.swing.JLabel txtFechaFinalErrores;
    private javax.swing.JLabel txtFechaInicialErrores;
    // End of variables declaration//GEN-END:variables

    private void cargarTabla() throws MyException {
        dtm.setRowCount(0);
        String fechaIni = ((JTextField) inputFechaInicialErrores.getDateEditor().getUiComponent()).getText();
        String fechaFin = ((JTextField) inputFechaFinalErrores.getDateEditor().getUiComponent()).getText();
        
        if (fechaIni.equals("") || fechaFin.equals("")) {
            throw new MyException("Hay que seleccionar ambas fechas");
        }
        comparaFechas(fechaIni, fechaFin);
        
        ArrayList<modelo.Error> errores = GestorBD.consultaListaErrores(fechaIni, fechaFin);
        borraDuplicados(errores);
        
        for (modelo.Error e : errores) {
            
            dtm.addRow(e.toArray());
            
        }
    }
    
    private static void comparaFechas(String fechaIni, String fechaFin) throws MyException{
        DateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date fecha1 = formato.parse(fechaIni);
            Date fecha2 = formato.parse(fechaFin);
            
            if(fecha1.compareTo(fecha2) > 0){
                throw new MyException("La fecha inicial no puede ser posterior a la fecha final.");
            }
        } catch (ParseException ex) {
           throw new MyException("Error recuperando las fechas.\n" + ex.getMessage());
        }
        
    }
    
    private static void borraDuplicados(ArrayList<modelo.Error> e){
        String codErrAux = "";
        ArrayList<modelo.Error> erroresBorrar = new ArrayList<>();
        for (modelo.Error error : e) {
            if(!error.getCodError().equals(codErrAux)){
                codErrAux = error.getCodError();
            }
            else{
                erroresBorrar.add(error);
            }
        }
        for (modelo.Error error : erroresBorrar) {
            e.remove(error);
        }
    }
}
