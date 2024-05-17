package controlador;

import accesoADatos.Conexion;
import accesoADatos.AlumnoData;
import entidades.Alumno;
import java.time.LocalDate;


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
        Alumno agus = new Alumno(5,111222,"Rodrigo","Lucero",LocalDate.of(2000, 11, 5),true);
        aldata.modificarAlumno(agus);
        
        
        //aldata.listarAlumnos();
        
        
        
        //
        Conexion.mostrarErrores();
        
    }
    
}
