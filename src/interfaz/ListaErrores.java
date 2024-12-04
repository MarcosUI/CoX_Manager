/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

/**
 *
 * @author Marcos
 */
public class ListaErrores extends javax.swing.JFrame {

    /**
     * Creates new form ListaErrores
     */
    public ListaErrores() {
        initComponents();
        this.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        panelFondoLista = new javax.swing.JPanel();
        panelListaSuperior = new javax.swing.JPanel();
        listaFecha = new javax.swing.JLabel();
        nomListaEmpresa = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaErrores = new javax.swing.JTable();
        botonListaSalir = new javax.swing.JButton();

        jMenu1.setText("jMenu1");

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("jRadioButtonMenuItem1");
        jMenu1.add(jRadioButtonMenuItem1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(651, 392));

        panelListaSuperior.setBackground(new java.awt.Color(0, 102, 204));

        listaFecha.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        listaFecha.setForeground(new java.awt.Color(240, 240, 240));
        listaFecha.setText("Fecha");

        nomListaEmpresa.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        nomListaEmpresa.setForeground(new java.awt.Color(240, 240, 240));
        nomListaEmpresa.setText("CoX Manager");

        javax.swing.GroupLayout panelListaSuperiorLayout = new javax.swing.GroupLayout(panelListaSuperior);
        panelListaSuperior.setLayout(panelListaSuperiorLayout);
        panelListaSuperiorLayout.setHorizontalGroup(
            panelListaSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelListaSuperiorLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(nomListaEmpresa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 329, Short.MAX_VALUE)
                .addComponent(listaFecha)
                .addContainerGap())
        );
        panelListaSuperiorLayout.setVerticalGroup(
            panelListaSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelListaSuperiorLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(panelListaSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomListaEmpresa)
                    .addComponent(listaFecha))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        tablaErrores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "COD_ERROR", "CANTIDAD AFECTADA", "DESCRIPCION"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaErrores);

        botonListaSalir.setText("SALIR");

        javax.swing.GroupLayout panelFondoListaLayout = new javax.swing.GroupLayout(panelFondoLista);
        panelFondoLista.setLayout(panelFondoListaLayout);
        panelFondoListaLayout.setHorizontalGroup(
            panelFondoListaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFondoListaLayout.createSequentialGroup()
                .addGroup(panelFondoListaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelFondoListaLayout.createSequentialGroup()
                        .addGap(254, 254, 254)
                        .addComponent(botonListaSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelListaSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(panelFondoListaLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 562, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelFondoListaLayout.setVerticalGroup(
            panelFondoListaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFondoListaLayout.createSequentialGroup()
                .addComponent(panelListaSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botonListaSalir, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelFondoLista, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelFondoLista, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonListaSalir;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel listaFecha;
    private javax.swing.JLabel nomListaEmpresa;
    private javax.swing.JPanel panelFondoLista;
    private javax.swing.JPanel panelListaSuperior;
    private javax.swing.JTable tablaErrores;
    // End of variables declaration//GEN-END:variables
}