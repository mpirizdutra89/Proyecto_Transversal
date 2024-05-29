package vistas;

import accesoADatos.AlumnoData;
import entidades.Alumno;
import java.beans.PropertyVetoException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Ferrando Carlos
 */
public class vistaFormularioAlumno extends javax.swing.JInternalFrame {

    /*Instancias de alumno y alumnoData*/
    private AlumnoData alumData = new AlumnoData();
    private Alumno alumnoActual = null;

    /**
     * Creates new form FormularioAlumnoView
     */
    public vistaFormularioAlumno() {
        initComponents();
    }
    
    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLtitulo = new javax.swing.JLabel();
        jLdni = new javax.swing.JLabel();
        jLapellido = new javax.swing.JLabel();
        jLnombre = new javax.swing.JLabel();
        jLestado = new javax.swing.JLabel();
        jLfechaNac = new javax.swing.JLabel();
        jTextdni = new javax.swing.JTextField();
        jTextapellido = new javax.swing.JTextField();
        jTextnombre = new javax.swing.JTextField();
        jCheckestado = new javax.swing.JCheckBox();
        jCfechaNac = new com.toedter.calendar.JDateChooser();
        jBbuscar = new javax.swing.JButton();
        jBsalir = new javax.swing.JButton();
        jBeliminar = new javax.swing.JButton();
        jBguardar = new javax.swing.JButton();
        jBnuevo = new javax.swing.JButton();

        setTitle("Alumnos ");

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));

        jLtitulo.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLtitulo.setText("Sistema de Alumnos");

        jLdni.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLdni.setText("Documento:");

        jLapellido.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLapellido.setText("Apellido:");

        jLnombre.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLnombre.setText("Nombre:");

        jLestado.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLestado.setText("Estado:");

        jLfechaNac.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLfechaNac.setText("Fecha de Nacimiento:");

        jTextdni.setBackground(new java.awt.Color(204, 204, 204));
        jTextdni.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jTextdni.setForeground(new java.awt.Color(0, 0, 0));

        jTextapellido.setBackground(new java.awt.Color(204, 204, 204));
        jTextapellido.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jTextapellido.setForeground(new java.awt.Color(0, 0, 0));

        jTextnombre.setBackground(new java.awt.Color(204, 204, 204));
        jTextnombre.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jTextnombre.setForeground(new java.awt.Color(0, 0, 0));

        jCheckestado.setBackground(new java.awt.Color(102, 102, 255));
        jCheckestado.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        jCheckestado.setForeground(new java.awt.Color(0, 0, 0));

        jCfechaNac.setBackground(new java.awt.Color(204, 204, 204));
        jCfechaNac.setForeground(new java.awt.Color(204, 204, 204));

        jBbuscar.setBackground(new java.awt.Color(0, 102, 0));
        jBbuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/lupa.png"))); // NOI18N
        jBbuscar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBbuscar.setMargin(new java.awt.Insets(5, 14, 5, 14));
        jBbuscar.setMaximumSize(new java.awt.Dimension(70, 40));
        jBbuscar.setMinimumSize(new java.awt.Dimension(70, 40));
        jBbuscar.setPreferredSize(new java.awt.Dimension(70, 40));
        jBbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBbuscarActionPerformed(evt);
            }
        });

        jBsalir.setBackground(new java.awt.Color(153, 0, 0));
        jBsalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/cerrar-sesion.png"))); // NOI18N
        jBsalir.setMargin(new java.awt.Insets(5, 14, 5, 14));
        jBsalir.setMaximumSize(new java.awt.Dimension(70, 40));
        jBsalir.setMinimumSize(new java.awt.Dimension(70, 40));
        jBsalir.setPreferredSize(new java.awt.Dimension(70, 40));
        jBsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBsalirActionPerformed(evt);
            }
        });

        jBeliminar.setBackground(new java.awt.Color(153, 0, 0));
        jBeliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/basura.png"))); // NOI18N
        jBeliminar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBeliminar.setMargin(new java.awt.Insets(5, 14, 5, 14));
        jBeliminar.setMaximumSize(new java.awt.Dimension(70, 40));
        jBeliminar.setMinimumSize(new java.awt.Dimension(70, 40));
        jBeliminar.setPreferredSize(new java.awt.Dimension(70, 40));
        jBeliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBeliminarActionPerformed(evt);
            }
        });

        jBguardar.setBackground(new java.awt.Color(0, 102, 0));
        jBguardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/guardar-el-archivo.png"))); // NOI18N
        jBguardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBguardar.setMargin(new java.awt.Insets(5, 14, 5, 14));
        jBguardar.setMaximumSize(new java.awt.Dimension(70, 40));
        jBguardar.setMinimumSize(new java.awt.Dimension(70, 40));
        jBguardar.setPreferredSize(new java.awt.Dimension(70, 40));
        jBguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBguardarActionPerformed(evt);
            }
        });

        jBnuevo.setBackground(new java.awt.Color(0, 102, 0));
        jBnuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/nueva-cuenta.png"))); // NOI18N
        jBnuevo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBnuevo.setMargin(new java.awt.Insets(5, 14, 5, 14));
        jBnuevo.setMaximumSize(new java.awt.Dimension(70, 40));
        jBnuevo.setMinimumSize(new java.awt.Dimension(70, 40));
        jBnuevo.setPreferredSize(new java.awt.Dimension(70, 40));
        jBnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBnuevoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLestado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLfechaNac, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLnombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLapellido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLdni, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jBnuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextdni)
                            .addComponent(jTextapellido)
                            .addComponent(jTextnombre, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jBguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jBeliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jCheckestado, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jCfechaNac, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 143, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLtitulo)
                .addGap(138, 138, 138))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLtitulo)
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLdni, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextdni, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jBbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLapellido, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextapellido, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addComponent(jLestado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jCheckestado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLfechaNac, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCfechaNac, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBeliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBnuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        jTextdni.getAccessibleContext().setAccessibleParent(jLdni);
        jTextapellido.getAccessibleContext().setAccessibleParent(jLapellido);
        jTextnombre.getAccessibleContext().setAccessibleParent(jLnombre);
        jCheckestado.getAccessibleContext().setAccessibleParent(jLestado);
        jBbuscar.getAccessibleContext().setAccessibleName("jBbuscar");
        jBsalir.getAccessibleContext().setAccessibleName("jBsalir");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBbuscarActionPerformed
        try {

            Integer dni = Integer.parseInt(jTextdni.getText());
            alumnoActual = alumData.buscarAlumnoPorDni(dni);

            if (alumnoActual != null) {
                jTextapellido.setText(alumnoActual.getApellido());
                jTextnombre.setText(alumnoActual.getNombre());
                jCheckestado.setSelected(alumnoActual.getEstado());
                LocalDate lc = alumnoActual.getFechaNacimiento();
                java.util.Date date = java.util.Date.from(lc.atStartOfDay(ZoneId.systemDefault()).toInstant());
                jCfechaNac.setDate(date);

            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Debe ingresar un número válido");
        }
    }//GEN-LAST:event_jBbuscarActionPerformed

    private void jBsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBsalirActionPerformed
        dispose();
    }//GEN-LAST:event_jBsalirActionPerformed

    private void jBeliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBeliminarActionPerformed
        if (alumnoActual != null) {
            alumData.eliminarAlumno(alumnoActual.getIdAlumno());
            alumnoActual = null;
            limpiarCampos();
        } else {
            JOptionPane.showMessageDialog(null, "No hay un alumno seleccionado");
        }
    }//GEN-LAST:event_jBeliminarActionPerformed

    private void jBguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBguardarActionPerformed
        try {
            Integer dni = Integer.parseInt(jTextdni.getText());
            String nombre = jTextnombre.getText();
            String apellido = jTextapellido.getText();

            if (nombre.isEmpty() || apellido.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No pueden haber campos vacios");
                return;
            }
            java.util.Date sfecha = jCfechaNac.getDate();
            LocalDate fechaNac = sfecha.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            Boolean estado = jCheckestado.isSelected();

            if (alumnoActual == null) {
                alumnoActual = new Alumno(dni, apellido, nombre, fechaNac, estado);
                alumData.guardarAlumno(alumnoActual);
            } else {
                alumnoActual.setDni(dni);
                alumnoActual.setApellido(apellido);
                alumnoActual.setNombre(nombre);
                alumnoActual.setFechaNacimiento(fechaNac);
                alumData.modificarAlumno(alumnoActual);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Debe ingresar un DNI válido");
        }
    }//GEN-LAST:event_jBguardarActionPerformed

    private void jBnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBnuevoActionPerformed
        limpiarCampos();
        alumnoActual = null;
    }//GEN-LAST:event_jBnuevoActionPerformed
    private void limpiarCampos() {

        jTextdni.setText("");
        jTextapellido.setText("");
        jTextnombre.setText("");
        jCheckestado.setSelected(true);
        jCfechaNac.setDate(new Date());

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBbuscar;
    private javax.swing.JButton jBeliminar;
    private javax.swing.JButton jBguardar;
    private javax.swing.JButton jBnuevo;
    private javax.swing.JButton jBsalir;
    private com.toedter.calendar.JDateChooser jCfechaNac;
    private javax.swing.JCheckBox jCheckestado;
    private javax.swing.JLabel jLapellido;
    private javax.swing.JLabel jLdni;
    private javax.swing.JLabel jLestado;
    private javax.swing.JLabel jLfechaNac;
    private javax.swing.JLabel jLnombre;
    private javax.swing.JLabel jLtitulo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextapellido;
    private javax.swing.JTextField jTextdni;
    private javax.swing.JTextField jTextnombre;
    // End of variables declaration//GEN-END:variables
}
