package vistas;

import accesoADatos.*;
import entidades.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import static librerias.FuncionesComunes.validarDoubles;
import static librerias.FuncionesComunes.validarNumericos;
import static librerias.FuncionesComunes.vistaDialogoSiNo;

/**
 *
 * @author agus1
 */
public class vistaFormularioActualizarNotas extends javax.swing.JInternalFrame {

    private ArrayList<Alumno> listaAlumnos;
    private ArrayList<Inscripcion> listaInscripcion;
    
    private InscripcionData inscData;
    private AlumnoData aData;
    
    private DefaultTableModel tablaMaterias;
    
    public vistaFormularioActualizarNotas() {
        initComponents();
        aData = new AlumnoData();
        listaAlumnos = (ArrayList<Alumno>) aData.listarAlumnos();
        tablaMaterias = new DefaultTableModel(){

        @Override
        public boolean isCellEditable(int f, int c) {
            if(c == 2){
            return true;
            }
            return false;
        }};
        
        
        inscData = new InscripcionData();
        
        cargarAlumnos();
        armarTabla();
        
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
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jCBseleccionarAlumno = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTMateria = new javax.swing.JTable();
        jBGuardar = new javax.swing.JButton();
        jBSalir = new javax.swing.JButton();

        setBackground(new java.awt.Color(102, 102, 255));
        setBorder(null);
        setTitle("Carga de Notas");

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));

        jLabel11.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel11.setText("CARGA DE NOTAS:");

        jLabel12.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel12.setText("Seleccionar un alumno:");

        jCBseleccionarAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBseleccionarAlumnoActionPerformed(evt);
            }
        });

        jTMateria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTMateria);

        jBGuardar.setBackground(new java.awt.Color(0, 102, 0));
        jBGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/guardar-el-archivo.png"))); // NOI18N
        jBGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBGuardarActionPerformed(evt);
            }
        });

        jBSalir.setBackground(new java.awt.Color(153, 0, 0));
        jBSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/cerrar-sesion.png"))); // NOI18N
        jBSalir.setToolTipText("");
        jBSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jBGuardar)
                                .addGap(125, 125, 125)
                                .addComponent(jBSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(115, 115, 115))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(54, 54, 54)
                                .addComponent(jCBseleccionarAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(165, 165, 165)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCBseleccionarAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBGuardar)
                    .addComponent(jBSalir))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCBseleccionarAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBseleccionarAlumnoActionPerformed
        
        borrarFilas();

        Alumno al = (Alumno) jCBseleccionarAlumno.getSelectedItem();
        listaInscripcion = inscData.obtenerInscripcionesPorAlumno(al.getIdAlumno());

        if(listaInscripcion.isEmpty()) {
            JOptionPane.showMessageDialog(this, "El alumno no está inscrito en ninguna materia.");
            JOptionPane.showMessageDialog(this, "Visite primero el formulario de inscripcion, gracias");
        }else{
            for(Inscripcion insc : listaInscripcion){
                tablaMaterias.addRow(new Object[]{
                    insc.getMateria().getIdMateria(),
                    insc.getMateria().getNombre(),
                    insc.getNota()
                });
            }
        }
    
    }//GEN-LAST:event_jCBseleccionarAlumnoActionPerformed

    private void jBGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBGuardarActionPerformed
            int filaSelec = jTMateria.getSelectedRow();
        if(filaSelec != -1){
            Alumno a = (Alumno) jCBseleccionarAlumno.getSelectedItem();
            int idMat = (Integer) tablaMaterias.getValueAt(filaSelec, 0);
            String notaStr = tablaMaterias.getValueAt(filaSelec, 2).toString();

            double nota = Double.parseDouble(notaStr);

            if (nota > 10) {
                JOptionPane.showMessageDialog(this, "La nota a ingresar no puede ser mayor a 10");
                return;
            }

            if (!vistaDialogoSiNo()) {
                return;
            }

            inscData.actualizarNota(a.getIdAlumno(), idMat, nota);
            borrarFilas();
            JOptionPane.showMessageDialog(this,"Nota actualizada exitosamente");
        }else{
            JOptionPane.showMessageDialog(this,"Seleccione una materia para actualizar nota");
        }
    }//GEN-LAST:event_jBGuardarActionPerformed

    private void jBSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalirActionPerformed
        dispose();
    }//GEN-LAST:event_jBSalirActionPerformed

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
            java.util.logging.Logger.getLogger(vistaFormularioActualizarNotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vistaFormularioActualizarNotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vistaFormularioActualizarNotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vistaFormularioActualizarNotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new vistaFormularioActualizarNotas().setVisible(true);
            }
        });
    }
    
    private void cargarAlumnos(){ //Cargar alumnos al comboBox
     for (Alumno a : listaAlumnos){
     jCBseleccionarAlumno.addItem(a);
     }
    }
    
    private void armarTabla(){
        tablaMaterias.addColumn("Codigo");
        tablaMaterias.addColumn("Materia");
        tablaMaterias.addColumn("Nota");
        jTMateria.setModel(tablaMaterias);
    }
    
    private void borrarFilas(){
        int indice = tablaMaterias.getRowCount();
        for(int i = indice -1; i >= 0; i--){
            tablaMaterias.removeRow(i);
        }
    
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBGuardar;
    private javax.swing.JButton jBSalir;
    private javax.swing.JComboBox<Alumno> jCBseleccionarAlumno;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTMateria;
    // End of variables declaration//GEN-END:variables
}
