/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import configuracion.Config;
import excepciones.MyException;
import gestor.GestorBD;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Empleado;
import modelo.Lote;
import modelo.Maquina;

/**
 *
 * @author Marcos
 */
public class VistaEncargado extends javax.swing.JFrame {

    Empleado empleado;
    Lote lote;
    Maquina maquina;
    int emple2;
    int emple3;
    String horaInicial;
    String codErrorRegistrado = "";
    
    public VistaEncargado(Empleado emp, Lote lote, Maquina maq, int emp2, int emp3, String horaIni) {
        initComponents();
        this.setVisible(true);
        
        this.empleado = emp;
        this.lote = lote;
        this.maquina = maq;
        this.emple2 = emp2;
        this.emple3 = emp3;
        this.horaInicial = horaIni;
        
        textoEncarEmple.setText("EMPLEADO: " + empleado.getCodEmpleado());
        texoEncarLote.setText("LOTE: " + lote.getCodLote());
        textoEncarMaquina.setText("MAQUINA: " + maquina.getCodMaquina());
        encarFecha.setText(GestorBD.fecha());
        this.setTitle(String.valueOf(empleado.getCodEmpleado()));
        txtAvisoEncargado.setText(txtAvisoEncargado.getText() + " " + GestorBD.fecha());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        botonEncarSalir = new javax.swing.JButton();
        botonEncarListaError = new javax.swing.JButton();
        textoEncarMaquina = new javax.swing.JLabel();
        texoEncarLote = new javax.swing.JLabel();
        textoEncarEmple = new javax.swing.JLabel();
        panelEncarSuperior = new javax.swing.JPanel();
        encarFecha = new javax.swing.JLabel();
        nomEncarEmpresa = new javax.swing.JLabel();
        botonEncarRegError = new javax.swing.JButton();
        botonEncarNuevoLote = new javax.swing.JButton();
        btnEstadoLotes = new javax.swing.JButton();
        txtAvisoEncargado = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(650, 400));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        botonEncarSalir.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        botonEncarSalir.setText("SALIR");
        botonEncarSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEncarSalirActionPerformed(evt);
            }
        });
        jPanel1.add(botonEncarSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 200, 150, 57));

        botonEncarListaError.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        botonEncarListaError.setText("LISTA DE ERRORES");
        botonEncarListaError.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEncarListaErrorActionPerformed(evt);
            }
        });
        jPanel1.add(botonEncarListaError, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 250, 160, 60));

        textoEncarMaquina.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        textoEncarMaquina.setText("MAQUINA: COD_MAQUINA");
        jPanel1.add(textoEncarMaquina, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 120, -1, 40));

        texoEncarLote.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        texoEncarLote.setText("LOTE: COD_LOTE");
        jPanel1.add(texoEncarLote, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 120, 170, 40));

        textoEncarEmple.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        textoEncarEmple.setText("EMPLEADO: COD_EMP");
        jPanel1.add(textoEncarEmple, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, 40));

        panelEncarSuperior.setBackground(new java.awt.Color(0, 102, 204));

        encarFecha.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        encarFecha.setForeground(new java.awt.Color(240, 240, 240));
        encarFecha.setText("Fecha");

        nomEncarEmpresa.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        nomEncarEmpresa.setForeground(new java.awt.Color(240, 240, 240));
        nomEncarEmpresa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icono_CoX.png"))); // NOI18N
        nomEncarEmpresa.setText("CoX Manager");

        javax.swing.GroupLayout panelEncarSuperiorLayout = new javax.swing.GroupLayout(panelEncarSuperior);
        panelEncarSuperior.setLayout(panelEncarSuperiorLayout);
        panelEncarSuperiorLayout.setHorizontalGroup(
            panelEncarSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelEncarSuperiorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nomEncarEmpresa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 217, Short.MAX_VALUE)
                .addComponent(encarFecha)
                .addGap(59, 59, 59))
        );
        panelEncarSuperiorLayout.setVerticalGroup(
            panelEncarSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEncarSuperiorLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(panelEncarSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomEncarEmpresa)
                    .addComponent(encarFecha))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(panelEncarSuperior, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 100));

        botonEncarRegError.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        botonEncarRegError.setText("REGISTRAR ERROR");
        botonEncarRegError.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEncarRegErrorActionPerformed(evt);
            }
        });
        jPanel1.add(botonEncarRegError, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 170, 160, 57));

        botonEncarNuevoLote.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        botonEncarNuevoLote.setText("NUEVO LOTE");
        botonEncarNuevoLote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEncarNuevoLoteActionPerformed(evt);
            }
        });
        jPanel1.add(botonEncarNuevoLote, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 150, 57));

        btnEstadoLotes.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnEstadoLotes.setText("ESTADO DE LOTE");
        btnEstadoLotes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEstadoLotesActionPerformed(evt);
            }
        });
        jPanel1.add(btnEstadoLotes, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 150, 60));

        txtAvisoEncargado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtAvisoEncargado.setText("Al finalizar el fichaje se generará un archivo con el registro de lotes manipulados a dia:");
        jPanel1.add(txtAvisoEncargado, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 630, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonEncarSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEncarSalirActionPerformed
         String fichados = "";
        try {
            if(this.codErrorRegistrado.equals("")){
                GestorBD.registrarFichajeSinError(this.empleado.getCodEmpleado(),this.lote.getCodLote(),this.maquina.getCodMaquina(),
                                        this.horaInicial);
                fichados += this.empleado.getCodEmpleado();
                if(this.emple2 != 0){
                    GestorBD.registrarFichajeSinError(this.emple2,this.lote.getCodLote(),this.maquina.getCodMaquina(),
                                        this.horaInicial);
                    fichados += ", " + this.emple2;
                    if(this.emple3 != 0){
                        GestorBD.registrarFichajeSinError(this.emple3,this.lote.getCodLote(),this.maquina.getCodMaquina(),
                                        this.horaInicial);
                        fichados += ", " + this.emple3;
                    }
                }
                
            }
            else{
                GestorBD.registrarFichajeConError(this.empleado.getCodEmpleado(),this.lote.getCodLote(),this.maquina.getCodMaquina(),
                                        this.horaInicial,this.codErrorRegistrado);
                fichados += this.empleado.getCodEmpleado();
                if(this.emple2 != 0){
                    GestorBD.registrarFichajeConError(this.emple2,this.lote.getCodLote(),this.maquina.getCodMaquina(),
                                        this.horaInicial,this.codErrorRegistrado);
                    fichados += ", " + this.emple2;
                    if(this.emple3 != 0){
                        GestorBD.registrarFichajeConError(this.emple3,this.lote.getCodLote(),this.maquina.getCodMaquina(),
                                        this.horaInicial,this.codErrorRegistrado);
                        fichados += ", " + this.emple3;
                    }
                }
                fichados += "\nCon error: " + this.codErrorRegistrado;
            }
            if (maquina.getCodMaquina() == 7){
                fichados += "\n Lote " + lote.getCodLote() + " terminado. Registrado como \"NO ACTIVO\" en Base de Datos.";
            }
            // Genera el fichero de registro de lotes manipulados del dia
            String nomFich = ficheroLotesDia();
            JOptionPane.showMessageDialog(this, "Archivo " + nomFich + " generado en\n "
                + Config.rutaFichDiario);
            
            JOptionPane.showMessageDialog(this, "Registrado el fichaje para: " + fichados);
            Fichaje f = new Fichaje();
            this.setVisible(false);
        } 
        catch (MyException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_botonEncarSalirActionPerformed

    private void botonEncarListaErrorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEncarListaErrorActionPerformed
        ListaErrores lE = new ListaErrores(this);
        this.setVisible(false);
    }//GEN-LAST:event_botonEncarListaErrorActionPerformed

    private void botonEncarRegErrorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEncarRegErrorActionPerformed
        if(codErrorRegistrado.equals("")){
            RegistroErrores re = new RegistroErrores(this);
        this.setVisible(false);
        }
        else{
            JOptionPane.showMessageDialog(this, "Ya se ha registrado un error.\nCodigo: "+this.codErrorRegistrado);
        }
    }//GEN-LAST:event_botonEncarRegErrorActionPerformed

    private void botonEncarNuevoLoteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEncarNuevoLoteActionPerformed
        RegistroLote  rL = new RegistroLote(this);
        this.setVisible(false);
    }//GEN-LAST:event_botonEncarNuevoLoteActionPerformed

    private void btnEstadoLotesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEstadoLotesActionPerformed
        EstadoLote eL = new EstadoLote(this);
        this.setVisible(false);
    }//GEN-LAST:event_btnEstadoLotesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonEncarListaError;
    private javax.swing.JButton botonEncarNuevoLote;
    private javax.swing.JButton botonEncarRegError;
    private javax.swing.JButton botonEncarSalir;
    private javax.swing.JButton btnEstadoLotes;
    private javax.swing.JLabel encarFecha;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel nomEncarEmpresa;
    private javax.swing.JPanel panelEncarSuperior;
    private javax.swing.JLabel texoEncarLote;
    private javax.swing.JLabel textoEncarEmple;
    private javax.swing.JLabel textoEncarMaquina;
    private javax.swing.JLabel txtAvisoEncargado;
    // End of variables declaration//GEN-END:variables

    public String getCodEmpEncar(){
        return String.valueOf(this.empleado.getCodEmpleado());
    }
    
    public String getCodLoteEncar(){
        return String.valueOf(this.lote.getCodLote());
    }

    public String getCodMaqEncar(){
        return String.valueOf(this.maquina.getCodMaquina());
    }
    
    public String getNomMaqEncar(){
        return String.valueOf(this.maquina.getNombreMaquina());
    }
    
    public void volver(){
        this.setVisible(true);
    }

    public void setCodErrorRegistrado(String codErrorRegistrado) {
        this.codErrorRegistrado = codErrorRegistrado;
    }
    
    private static String ficheroLotesDia() throws MyException{
        String rutaCarpeta = Config.rutaFichDiario;
        File directorio = new File(rutaCarpeta);
        
        String nombreArchivo = "lotes" + GestorBD.fechaGuiones();
        if(directorio.exists() && directorio.isDirectory()){
            File[] numArchivos = directorio.listFiles();
            nombreArchivo += String.valueOf(numArchivos.length);
        }
        File archivo = new File(rutaCarpeta + "\\" + nombreArchivo + ".txt");
        
        ArrayList<String> lineasFichero = new ArrayList<>();
        try {
            archivo.createNewFile();
            GestorBD.consultaLotesDiarios(lineasFichero);
            for (String linea : lineasFichero) {
                System.out.println(linea);
            }
            
            OutputStream os = new FileOutputStream(archivo);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
            bw.write("------------------ ");
            bw.write("Registro de actividad ");
            bw.write(GestorBD.fecha());
            bw.write(" ------------------\n\n");
            
            for (String linea : lineasFichero) {
                bw.write(linea);
                bw.write("\n");
            }
            bw.write("\n---------------------------------------------------------------------");
            bw.close();
            return archivo.getName();
            
        } catch (MyException ex) {
            throw ex;
        } catch (FileNotFoundException ex) {
            throw new MyException("Error creando el fichero " + nombreArchivo + ".txt");
        } catch (IOException ex) {
            throw new MyException("Error escribiendo en el fichero" + nombreArchivo + ".txt");
        }
    }
    
}
