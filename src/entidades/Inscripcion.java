
package entidades;

/**
 *
 * @author Ariel Zurita
 */
public class Inscripcion {
    private int idInscripcion;
    private Alumno alumno;
    private Materia materia;
    private double nota;

    
    
    

    
    public Inscripcion(int idInscripcion, Alumno alumno, Materia materia, double nota) {
        this.idInscripcion = idInscripcion;
        this.alumno = alumno;
        this.materia = materia;
        this.nota = nota;
    }

    
    
    
    public Inscripcion(Alumno alumno, Materia materia, double nota) {
        this.alumno = alumno;
        this.materia = materia;
        this.nota = nota;
        
    }
    
    
    
    public Inscripcion() {
    }

    
    
    
    public int getIdInscripcion() {
        return idInscripcion;
    }

    public void setIdInscripcion(int idInscripcion) {
        this.idInscripcion = idInscripcion;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    
    
    
    
    
    public double getNota0() {
        return nota;
    }

    public double getNota1() {
        return nota;
    }

    public double getNota2() {
        return nota;
    }

    public double getNota3() {
        return nota;
    }

    public double getNota4() {
        return nota;
    }

    public double getNota5() {
        return nota;
    }

    public double getNota6() {
        return nota;
    }
    
    public double getNota7() {
        return nota;
    }

    public double getNota8() {
        return nota;
    }

    public double getNota9() {
        return nota;
    }

    public double getNota10() {
        return nota;
    }
}

