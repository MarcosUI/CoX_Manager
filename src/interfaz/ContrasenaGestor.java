
package interfaz;

import excepciones.MyException;
import gestor.GestorBD;
import javax.swing.JOptionPane;
import modelo.Empleado;

/**
 *
 * @author Marcos
 */
public class ContrasenaGestor extends javax.swing.JFrame {

    int intentos = 2;
    Empleado emp;
    
    public ContrasenaGestor(Empleado e) {
        initComponents();
        this.setVisible(true);
        this.emp = e;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelFondoContra = new javax.swing.JPanel();
        botonEntrarGestor = new javax.swing.JButton();
        txtEmpleContra = new javax.swing.JLabel();
        inputContrasena = new javax.swing.JPasswordField();
        txtContrasena = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelFondoContra.setBackground(new java.awt.Color(204, 204, 204));

        botonEntrarGestor.setText("ENTRAR");
        botonEntrarGestor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEntrarGestorActionPerformed(evt);
            }
        });

        txtEmpleContra.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtEmpleContra.setText("EMPLEADO: COD_EMP");

        inputContrasena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputContrasenaActionPerformed(evt);
            }
        });

        txtContrasena.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtContrasena.setText("Introduzca su contraseña:");

        javax.swing.GroupLayout panelFondoContraLayout = new javax.swing.GroupLayout(panelFondoContra);
        panelFondoContra.setLayout(panelFondoContraLayout);
        panelFondoContraLayout.setHorizontalGroup(
            panelFondoContraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFondoContraLayout.createSequentialGroup()
                .addGroup(panelFondoContraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelFondoContraLayout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addComponent(botonEntrarGestor, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelFondoContraLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtEmpleContra))
                    .addGroup(panelFondoContraLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(txtContrasena)
                        .addGap(18, 18, 18)
                        .addComponent(inputContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        panelFondoContraLayout.setVerticalGroup(
            panelFondoContraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFondoContraLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtEmpleContra)
                .addGap(38, 38, 38)
                .addGroup(panelFondoContraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtContrasena))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(botonEntrarGestor, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelFondoContra, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelFondoContra, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inputContrasenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputContrasenaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputContrasenaActionPerformed

    private void botonEntrarGestorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEntrarGestorActionPerformed
        try{
            
            if(!GestorBD.compruebaContrasena(inputContrasena.getText(), String.valueOf(emp.getCodEmpleado()))){
                JOptionPane.showMessageDialog(this, "Contraseña errónea.\nIntentos restantes: " + intentos);
                intentos--;
                inputContrasena.setText("");
            }
            else if (GestorBD.compruebaContrasena(inputContrasena.getText(), String.valueOf(emp.getCodEmpleado()))){
                JOptionPane.showMessageDialog(this, "Contraseña correcta.\nEntrando en usuario " +
                        emp.getCodEmpleado() + ", " + emp.getNombre());
                Gestor gestor = new Gestor(this.emp);
                this.setVisible(false);
            }
            else if(intentos == 0){
                JOptionPane.showMessageDialog(this, "Has superado el límite de intentos\nFichaje cancelado");
                Fichaje f = new Fichaje();
                this.setVisible(false);
            }
        }
        catch (MyException ex){
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_botonEntrarGestorActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonEntrarGestor;
    private javax.swing.JPasswordField inputContrasena;
    private javax.swing.JPanel panelFondoContra;
    private javax.swing.JLabel txtContrasena;
    private javax.swing.JLabel txtEmpleContra;
    // End of variables declaration//GEN-END:variables
}
