package interfaz;

import excepciones.MyException;
import gestor.GestorBD;
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
public class Fichaje extends javax.swing.JFrame {

    /**
     * Creates new form Fichaje
     */
    public Fichaje() {
        initComponents();
        this.setVisible(true);
        
        txtEmple2.setVisible(false);
        inputCodEmple2.setVisible(false);
        lineaEmp2.setVisible(false);
        
        txtEmple3.setVisible(false);
        inputCodEmple3.setVisible(false);
        lineaEmp3.setVisible(false);
        
        txtFichajeFecha.setText(GestorBD.fecha());
        this.setTitle("CoX Manager");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoBotones = new javax.swing.ButtonGroup();
        panelFondo = new javax.swing.JPanel();
        fichajePanelSuperior = new javax.swing.JPanel();
        txtFichajeFecha = new javax.swing.JLabel();
        fichajeNomEmpresa = new javax.swing.JLabel();
        panelBotones = new javax.swing.JPanel();
        botonF1 = new javax.swing.JRadioButton();
        botonF2 = new javax.swing.JRadioButton();
        botonF3 = new javax.swing.JRadioButton();
        inputCodEmple1 = new javax.swing.JTextField();
        inputCodEmple2 = new javax.swing.JTextField();
        inputCodEmple3 = new javax.swing.JTextField();
        inputCodLote = new javax.swing.JTextField();
        inputCodMaquina = new javax.swing.JTextField();
        botonIniciarFichaje = new javax.swing.JButton();
        lineaEmp3 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        txtEmple1 = new javax.swing.JLabel();
        txtEmple2 = new javax.swing.JLabel();
        txtEmple3 = new javax.swing.JLabel();
        txtLote = new javax.swing.JLabel();
        txtMaquina = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        lineaEmp2 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(631, 400));
        setResizable(false);

        panelFondo.setBackground(new java.awt.Color(204, 204, 204));
        panelFondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fichajePanelSuperior.setBackground(new java.awt.Color(0, 102, 204));

        txtFichajeFecha.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtFichajeFecha.setForeground(new java.awt.Color(240, 240, 240));
        txtFichajeFecha.setText("Fecha");

        fichajeNomEmpresa.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        fichajeNomEmpresa.setForeground(new java.awt.Color(240, 240, 240));
        fichajeNomEmpresa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icono_CoX.png"))); // NOI18N
        fichajeNomEmpresa.setText("CoX Manager");

        javax.swing.GroupLayout fichajePanelSuperiorLayout = new javax.swing.GroupLayout(fichajePanelSuperior);
        fichajePanelSuperior.setLayout(fichajePanelSuperiorLayout);
        fichajePanelSuperiorLayout.setHorizontalGroup(
            fichajePanelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fichajePanelSuperiorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(fichajeNomEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                .addComponent(txtFichajeFecha)
                .addGap(54, 54, 54))
        );
        fichajePanelSuperiorLayout.setVerticalGroup(
            fichajePanelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fichajePanelSuperiorLayout.createSequentialGroup()
                .addGroup(fichajePanelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(fichajePanelSuperiorLayout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(txtFichajeFecha))
                    .addGroup(fichajePanelSuperiorLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(fichajeNomEmpresa)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelFondo.add(fichajePanelSuperior, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 100));

        panelBotones.setBackground(new java.awt.Color(102, 102, 102));

        grupoBotones.add(botonF1);
        botonF1.setSelected(true);
        botonF1.setText("F1");
        botonF1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonF1ActionPerformed(evt);
            }
        });

        grupoBotones.add(botonF2);
        botonF2.setText("F2");
        botonF2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonF2ActionPerformed(evt);
            }
        });

        grupoBotones.add(botonF3);
        botonF3.setText("F3");
        botonF3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonF3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBotonesLayout = new javax.swing.GroupLayout(panelBotones);
        panelBotones.setLayout(panelBotonesLayout);
        panelBotonesLayout.setHorizontalGroup(
            panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotonesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(botonF1)
                .addGap(164, 164, 164)
                .addComponent(botonF2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 163, Short.MAX_VALUE)
                .addComponent(botonF3)
                .addContainerGap())
        );
        panelBotonesLayout.setVerticalGroup(
            panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotonesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonF1)
                    .addComponent(botonF2)
                    .addComponent(botonF3))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        panelFondo.add(panelBotones, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 450, 40));

        inputCodEmple1.setBorder(null);
        panelFondo.add(inputCodEmple1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, 120, 20));

        inputCodEmple2.setBorder(null);
        panelFondo.add(inputCodEmple2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 210, 120, 20));

        inputCodEmple3.setToolTipText("");
        inputCodEmple3.setBorder(null);
        inputCodEmple3.setName(""); // NOI18N
        panelFondo.add(inputCodEmple3, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 210, 120, 20));

        inputCodLote.setBorder(null);
        panelFondo.add(inputCodLote, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 270, 120, 20));

        inputCodMaquina.setBorder(null);
        panelFondo.add(inputCodMaquina, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 330, 120, 20));

        botonIniciarFichaje.setText("Iniciar Fichaje");
        botonIniciarFichaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonIniciarFichajeActionPerformed(evt);
            }
        });
        panelFondo.add(botonIniciarFichaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 280, 140, 60));

        lineaEmp3.setForeground(new java.awt.Color(0, 0, 0));
        panelFondo.add(lineaEmp3, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 230, 120, 10));

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        panelFondo.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 350, 120, 30));

        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));
        panelFondo.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 290, 120, 10));

        txtEmple1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtEmple1.setText("Empleado 1");
        panelFondo.add(txtEmple1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, -1, -1));

        txtEmple2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtEmple2.setText("Empleado 2");
        panelFondo.add(txtEmple2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 180, -1, -1));

        txtEmple3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtEmple3.setText("Empleado 3");
        panelFondo.add(txtEmple3, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 180, -1, -1));

        txtLote.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtLote.setText("Lote");
        panelFondo.add(txtLote, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, -1, -1));

        txtMaquina.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtMaquina.setText("Maquina");
        panelFondo.add(txtMaquina, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 310, -1, -1));

        jSeparator4.setForeground(new java.awt.Color(0, 0, 0));
        panelFondo.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 230, 120, 10));

        lineaEmp2.setForeground(new java.awt.Color(0, 0, 0));
        panelFondo.add(lineaEmp2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 230, 120, 10));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelFondo, javax.swing.GroupLayout.PREFERRED_SIZE, 631, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelFondo, javax.swing.GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonIniciarFichajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonIniciarFichajeActionPerformed
        int botonSeleccionado;
        if (botonF1.isSelected()) {
            botonSeleccionado = 1;
        } else if (botonF2.isSelected()) {
            botonSeleccionado = 2;
        } else {
            botonSeleccionado = 3;
        }

        try {
            //Comprueba si el COD_EMP introducido es de gestor
            if(inputCodEmple1.getText().charAt(0) == '3'){
                iniciarFichajeGestor(botonSeleccionado);
            }
            else{
                iniciarFichaje(botonSeleccionado);
            }
        } catch (MyException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        } 


    }//GEN-LAST:event_botonIniciarFichajeActionPerformed

    private void botonF1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonF1ActionPerformed
        // TODO add your handling code here:
        txtEmple2.setVisible(false);
        inputCodEmple2.setVisible(false);
        lineaEmp2.setVisible(false);
        
        txtEmple3.setVisible(false);
        inputCodEmple3.setVisible(false);
        lineaEmp3.setVisible(false);
    }//GEN-LAST:event_botonF1ActionPerformed

    private void botonF2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonF2ActionPerformed
        // TODO add your handling code here:
        txtEmple2.setVisible(true);
        inputCodEmple2.setVisible(true);
        lineaEmp2.setVisible(true);
        
        txtEmple3.setVisible(false);
        inputCodEmple3.setVisible(false);
        lineaEmp3.setVisible(false);
    }//GEN-LAST:event_botonF2ActionPerformed

    private void botonF3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonF3ActionPerformed
        // TODO add your handling code here:
        txtEmple2.setVisible(true);
        inputCodEmple2.setVisible(true);
        lineaEmp2.setVisible(true);
        
        txtEmple3.setVisible(true);
        inputCodEmple3.setVisible(true);
        lineaEmp3.setVisible(true);
    }//GEN-LAST:event_botonF3ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton botonF1;
    private javax.swing.JRadioButton botonF2;
    private javax.swing.JRadioButton botonF3;
    private javax.swing.JButton botonIniciarFichaje;
    private javax.swing.JLabel fichajeNomEmpresa;
    private javax.swing.JPanel fichajePanelSuperior;
    private javax.swing.ButtonGroup grupoBotones;
    private javax.swing.JTextField inputCodEmple1;
    private javax.swing.JTextField inputCodEmple2;
    private javax.swing.JTextField inputCodEmple3;
    private javax.swing.JTextField inputCodLote;
    private javax.swing.JTextField inputCodMaquina;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator lineaEmp2;
    private javax.swing.JSeparator lineaEmp3;
    private javax.swing.JPanel panelBotones;
    private javax.swing.JPanel panelFondo;
    private javax.swing.JLabel txtEmple1;
    private javax.swing.JLabel txtEmple2;
    private javax.swing.JLabel txtEmple3;
    private javax.swing.JLabel txtFichajeFecha;
    private javax.swing.JLabel txtLote;
    private javax.swing.JLabel txtMaquina;
    // End of variables declaration//GEN-END:variables

    private void iniciarFichaje(int botonSelec) throws MyException {

        Empleado e = GestorBD.existeEmpleado(inputCodEmple1.getText());
        Lote l = GestorBD.existeLote(inputCodLote.getText());
        Maquina m = GestorBD.existeMaquina(inputCodMaquina.getText());

        if (e == null) {
            JOptionPane.showMessageDialog(this, "El codigo de empleado 1 no existe.");
        } 
        else if (l == null) {
            JOptionPane.showMessageDialog(this, "El codigo de lote introducido no existe.");
        }
        else if (!l.getActivo()){
            JOptionPane.showMessageDialog(this, "El lote introducido no está activo.");
        }
        else if (m == null) {
            JOptionPane.showMessageDialog(this, "El codigo de maquina introducido no existe.");
        } 
        else if (m.getNumOperMaquina() != botonSelec) {
            JOptionPane.showMessageDialog(this, "La maquina introducida requiere "
                    + m.getNumOperMaquina() + " operarios.");
        }
        else {
            
            switch (botonSelec) {
                case 2:
                    if (GestorBD.existeEmpleado(inputCodEmple2.getText()) == null) {
                        JOptionPane.showMessageDialog(this, "El codigo de empleado 2 no existe.");
                    } else {
                        if (inputCodEmple1.getText().charAt(0) == '2') {
                            Encargado encarg = new Encargado(e, l, m,
                                    Integer.parseInt(inputCodEmple2.getText()), 0, GestorBD.horaActual());
                            this.setVisible(false);
                        } 
                        else if (inputCodEmple2.getText().charAt(0) == '3') {
                            JOptionPane.showMessageDialog(this, "El fichaje de equipo no es compatible con códigos de gestor");
                        } 
                        else {
                            Operario oper = new Operario(e, l, m,
                                    Integer.parseInt(inputCodEmple2.getText()), 0, GestorBD.horaActual());
                            this.setVisible(false);
                        }
                    }
                    break;

                case 3:
                    if (GestorBD.existeEmpleado(inputCodEmple2.getText()) == null) {
                        JOptionPane.showMessageDialog(this, "El codigo de empleado 2 no existe.");
                    } 
                    else if (GestorBD.existeEmpleado(inputCodEmple3.getText()) == null) {
                        JOptionPane.showMessageDialog(this, "El codigo de empleado 3 no existe.");
                    } 
                    else if (inputCodEmple2.getText().charAt(0) == '3' || inputCodEmple3.getText().charAt(0) == '3') {
                        JOptionPane.showMessageDialog(this, "El fichaje de equipo no es compatible con códigos de gestor");
                    } 
                    else {
                        if (inputCodEmple1.getText().charAt(0) == '2') {
                            Encargado encarg = new Encargado(e, l, m, Integer.parseInt(inputCodEmple2.getText()),
                                    Integer.parseInt(inputCodEmple3.getText()), GestorBD.horaActual());
                            this.setVisible(false);
                        } else {
                            Operario oper = new Operario(e, l, m, Integer.parseInt(inputCodEmple2.getText()),
                                    Integer.parseInt(inputCodEmple3.getText()), GestorBD.horaActual());
                            this.setVisible(false);
                        }
                    }
                    break;

                default:
                    if (inputCodEmple1.getText().charAt(0) == '2') {
                        Encargado encarg = new Encargado(e, l, m, 0, 0, GestorBD.horaActual());
                        this.setVisible(false);
                    } else {
                        Operario oper = new Operario(e, l, m, 0, 0, GestorBD.horaActual());
                        this.setVisible(false);
                    }
                    break;
            }
        }
    }

    private void iniciarFichajeGestor(int botonSelec) throws MyException {

        Empleado e = GestorBD.existeEmpleado(inputCodEmple1.getText());

        if (e == null) {
            JOptionPane.showMessageDialog(this, "El codigo de empleado 1 no existe.");
        } else {

            if (botonSelec != 1) {
                JOptionPane.showMessageDialog(this, "Un gestor no puede hacer fichaje múltiple.");
            }
            else if(!inputCodLote.getText().equals("") ||!inputCodMaquina.getText().equals("")){
                JOptionPane.showMessageDialog(this, "Un gestor no puede fichar en máquina ni con lote.");
            }
            else {
                ContrasenaGestor gestor = new ContrasenaGestor(e);
                this.setVisible(false);
            }
        }
    }
}
