package vistas;

import entidades.Alumno;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;

/**
 *
 * @author Nicolas
 */
public class VistaMenuPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form VistaMenuPrincipal
     */
    public VistaMenuPrincipal() {
        initComponents();

    }
    
    @Override
    public Image getIconImage(){
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("recursos/ulp_logo_1.png"));
        return retValue;
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDpEscritorio = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuAlumno = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMmateria = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMmanejoInscripciones = new javax.swing.JMenuItem();
        jMmanipulacionNotas = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMConsultaMateria = new javax.swing.JMenuItem();
        jMenuSalir = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ULP Gestion");
        setIconImage(getIconImage());

        javax.swing.GroupLayout jDpEscritorioLayout = new javax.swing.GroupLayout(jDpEscritorio);
        jDpEscritorio.setLayout(jDpEscritorioLayout);
        jDpEscritorioLayout.setHorizontalGroup(
            jDpEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 699, Short.MAX_VALUE)
        );
        jDpEscritorioLayout.setVerticalGroup(
            jDpEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 684, Short.MAX_VALUE)
        );

        jMenu1.setText("Alumno");

        jMenuAlumno.setText("Formulario Alumno");
        jMenuAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuAlumnoActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuAlumno);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Materia");

        jMmateria.setText("Formulario Materia");
        jMmateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMmateriaActionPerformed(evt);
            }
        });
        jMenu2.add(jMmateria);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Administracion");

        jMmanejoInscripciones.setText("Manejo Inscipciones");
        jMmanejoInscripciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMmanejoInscripcionesActionPerformed(evt);
            }
        });
        jMenu3.add(jMmanejoInscripciones);

        jMmanipulacionNotas.setText("Manipulacion Notas");
        jMmanipulacionNotas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMmanipulacionNotasActionPerformed(evt);
            }
        });
        jMenu3.add(jMmanipulacionNotas);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Consultas");

        jMConsultaMateria.setText("Alumno por Materia");
        jMConsultaMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMConsultaMateriaActionPerformed(evt);
            }
        });
        jMenu4.add(jMConsultaMateria);

        jMenuBar1.add(jMenu4);

        jMenuSalir.setText("Salir");
        jMenuSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuSalirMouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenuSalir);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDpEscritorio, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDpEscritorio, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuAlumnoActionPerformed
        
        vistaFormularioAlumno vfa = new vistaFormularioAlumno();
        cargarVistasInternas(vfa);
    }//GEN-LAST:event_jMenuAlumnoActionPerformed

    private void jMmateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMmateriaActionPerformed
     FormularioMateria fm=new FormularioMateria();
        cargarVistasInternas(fm);
    }//GEN-LAST:event_jMmateriaActionPerformed

    private void jMmanejoInscripcionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMmanejoInscripcionesActionPerformed

        vistaFormularioInscripcion vfi = new vistaFormularioInscripcion();

        cargarVistasInternas(vfi);


    }//GEN-LAST:event_jMmanejoInscripcionesActionPerformed

    private void jMmanipulacionNotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMmanipulacionNotasActionPerformed
        
        vistaFormularioActualizarNotas vfan = new vistaFormularioActualizarNotas();
        
        cargarVistasInternas(vfan);
    }//GEN-LAST:event_jMmanipulacionNotasActionPerformed

    private void jMConsultaMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMConsultaMateriaActionPerformed
        vistaFormularioConsultasAlumno vfca=new vistaFormularioConsultasAlumno();
        cargarVistasInternas(vfca);
    }//GEN-LAST:event_jMConsultaMateriaActionPerformed

    private void jMenuSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuSalirMouseClicked

        librerias.FuncionesComunes.closeAll();
    }//GEN-LAST:event_jMenuSalirMouseClicked

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
            java.util.logging.Logger.getLogger(VistaMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                if (verificarConexion()) {
                    new VistaMenuPrincipal().setVisible(true);
                }

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDpEscritorio;
    private javax.swing.JMenuItem jMConsultaMateria;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuItem jMenuAlumno;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuSalir;
    private javax.swing.JMenuItem jMmanejoInscripciones;
    private javax.swing.JMenuItem jMmanipulacionNotas;
    private javax.swing.JMenuItem jMmateria;
    // End of variables declaration//GEN-END:variables

    private void cargarVistasInternas(JInternalFrame view) {
        jDpEscritorio.removeAll();
        jDpEscritorio.repaint();
        view.setVisible(true);
        int w = jDpEscritorio.getWidth();
        int h = jDpEscritorio.getHeight();
        int x = (w - view.getWidth()) / 2;
        int y = (h - view.getHeight()) / 2;
        view.setLocation(x, y);

        jDpEscritorio.add(view);

        jDpEscritorio.moveToFront(view);

    }

    private static boolean verificarConexion() {
        boolean res = true;

        if (!accesoADatos.Conexion.VerificarConexion()) {

            librerias.FuncionesComunes.vistaDialogo("No se pudo iniciar el sistema. Revise que la base de datos este en linea y vuelva a iniciar el sistema.", 0);
            res = false;
            librerias.FuncionesComunes.closeAll();

        }
        return res;

    }

}
