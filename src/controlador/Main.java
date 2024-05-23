package controlador;

import accesoADatos.Conexion;
import accesoADatos.AlumnoData;
import accesoADatos.InscripcionData;
import accesoADatos.MateriaData;
import entidades.Alumno;
import entidades.Inscripcion;
import entidades.Materia;
import java.time.LocalDate;
import java.time.Month;

/**
 *
 * @author Nicolas
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        AlumnoData aldata = new AlumnoData();
        MateriaData matdata = new MateriaData();
        InscripcionData inscdata = new InscripcionData();

//        Alumno agus = new Alumno(5,111222,"Rodrigo","Lucero",LocalDate.of(2000, 11, 5),true);
//        aldata.modificarAlumno(agus);
//        System.out.println("Lista de alumnos");
//        for(Alumno a:aldata.listarAlumnos()){
//            System.out.println("DNI: " + a.getDni());
//            System.out.println("Apellido: " + a.getApellido());
//            System.out.println("Nombre: " + a.getNombre());
//            System.out.println("Fecha de Nac: " + a.getFechaNacimiento());
//            System.out.println("\n");   
//        }
        /*
        Se Crean 4 alumnos
        Alumno alumno1 = new Alumno(12345678, "Perez", "Juan", LocalDate.of(2000,01,15), true);
        Alumno alumno2 = new Alumno(87654321, "Garcia", "Maria", LocalDate.of(1999,05,21), false);
        Alumno alumno3 = new Alumno(11223344, "Lopez", "Carlos", LocalDate.of(1980,05,19), true);
        Alumno alumno4 = new Alumno(55667788, "Martinez", "Ana", LocalDate.of(1998,12,30), true);
        //Se guardan los alumnos en la BD
        aldata.guardarAlumno(alumno1);
        aldata.guardarAlumno(alumno2);
        aldata.guardarAlumno(alumno3);
        aldata.guardarAlumno(alumno4);
         
        //buscar alumno por id
        Alumno encontrado = aldata.buscarAlumno(2);
        if (encontrado != null) {
            System.out.printf("DNI ---------------- %d\n", encontrado.getDni());
            System.out.printf("Nombre ------------- %s\n", encontrado.getNombre());
            System.out.printf("Apellido ----------- %s\n", encontrado.getApellido());
        }
        //Borrado lógico del alumno
        aldata.eliminarAlumno(5);
        //Se modifica nombre y estado del alumno
        Alumno alumno2 = new Alumno(3,87654321, "Garcia", "Mariana", LocalDate.of(1999,05,21), true);
        aldata.modificarAlumno(alumno2);
         */
        //Prueba: guardarInscripcion()
        // Alumno alu1 = aldata.buscarAlumno(5);
        //Materia mat = matdata.buscarMateria(2);
        // Inscripcion insc = new Inscripcion(alu1,mat,9);
//        
//        inscdata.guardarInscripcion(insc);
        //Prueba: actualizarNota()
//        inscdata.actualizarNota(5, 2, 10);
        
        /*Materia m1 = new Materia("Geografía", 2, true);
        Materia m2 = new Materia("Matemática", 6, false);
        Materia m3 = new Materia("Biología", 1, true);
        Materia m4 = new Materia("Contabilidad", 3, false);
        Materia m5 = new Materia("Sociología", 2, false);*/
        
        //Se guardan materias en la BD
        //matdata.guardarMateria(m1);
        //matdata.guardarMateria(m2);
        //matdata.guardarMateria(m3);
        //matdata.guardarMateria(m4);
        //matdata.guardarMateria(m5);
        
        //Buscar y modificar materias
        //Materia matbuscada = matdata.buscarMateria(1);
        //System.out.println(matbuscada);
        //Materia m4 = new Materia(4,"Contabilidad",5,true);
        //matdata.modificarMateria(m4);
        //Eliminar materia -logico
        //matdata.eliminarMateria(1);
        
        for (Materia materia : matdata.listarMaterias()) {
            System.out.print("ID: "+materia.getIdMateria());
            System.out.print("-------");
            System.out.print("Nombre: "+materia.getNombre());
            System.out.print("-------");
            System.out.print("Año: "+ materia.getAño());
            System.out.print("-------");
            System.out.print("Estado: "+materia.isEstado());
            System.out.println("");     
        }
        Conexion.mostrarErrores();

    }

}
