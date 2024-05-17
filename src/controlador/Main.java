package controlador;

import accesoADatos.Conexion;
import accesoADatos.AlumnoData;


/**
 *
 * @author Nicolas
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     
        AlumnoData aldata=new AlumnoData();
        
        aldata.listarAlumnos();
        
        
        
        //
        Conexion.mostrarErrores();
        
    }
    
}
