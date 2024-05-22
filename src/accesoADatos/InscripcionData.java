package accesoADatos;

import java.sql.Connection;
import entidades.Inscripcion;
import accesoADatos.Conexion;
import entidades.Alumno;
import entidades.Materia;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.Date;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.mariadb.jdbc.Statement;


/**
 *
 * @author agus1
 */
public class InscripcionData {

    private static Inscripcion inscripcion;

    private MateriaData mateData;
    private AlumnoData alumData;
    private static Connection conec = null;

    public InscripcionData() {
        conec = Conexion.getConexion();
    }
    
    public void guardarInscripciones(Inscripcion insc){
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        
        String sql = "INSERT INTO inscripcion (idAlumno, idMateria, nota) "
                + "VALUES (?,?,?)";
        try{
        ps = conec.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1, insc.getAlumno().getIdAlumno());
        ps.setInt(2, insc.getMateria().getIdMateria());
        ps.setDouble(3, insc.getNota());
        ps.executeUpdate(sql);
        rs = ps.getGeneratedKeys();
        if(rs.next()){
            insc.setIdInscripcion(rs.getInt(1));
            JOptionPane.showMessageDialog(null, "Inscripcion Registrada");
        }
        
            ps.close();
            rs.close();
            
        }catch(SQLException ex){
        Conexion.msjError.add("IncripcionData:  guardarInscripcion() ->" + ex.getMessage());
        }
    }
    
    public ArrayList<Inscripcion> obtenerInscripciones(){
        ArrayList<Inscripcion> listaInsc = new ArrayList<>();
        ResultSet rs = null;
        PreparedStatement ps = null;
        
        String query = "SELECT * FROM inscripcion ";
        
        try {
            ps = conec.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
                
                Inscripcion insc = new Inscripcion();
                insc.setIdInscripcion(rs.getInt("idInscripto"));
                Alumno al = alumData.buscarAlumno(rs.getInt("idAlumno"));
                Materia mat = mateData.buscarMateria(rs.getInt("idMateria"));
                insc.setAlumno(al);
                insc.setMateria(mat);
                insc.setNota(rs.getDouble("nota"));
                
                listaInsc.add(insc);
                
            }
            ps.close();
            rs.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(InscripcionData.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listaInsc;
    
    }
    
    public ArrayList<Inscripcion> obtenerInscripcionesPorAlumno(int idAlumno){
        ArrayList<Inscripcion> listaInsc = new ArrayList<>();
        ResultSet rs = null;
        PreparedStatement ps = null;
        
        String query = "SELECT * FROM inscripcion WHERE idAlumno = ? ";
        
        try {
            ps = conec.prepareStatement(query);
            ps.setInt(1, idAlumno);
            rs = ps.executeQuery();
            while(rs.next()){
                
                Inscripcion insc = new Inscripcion();
                insc.setIdInscripcion(rs.getInt("idInscripto"));
                Alumno al = alumData.buscarAlumno(rs.getInt("idAlumno"));
                Materia mat = mateData.buscarMateria(rs.getInt("idMateria"));
                insc.setAlumno(al);
                insc.setMateria(mat);
                insc.setNota(rs.getDouble("nota"));
                
                listaInsc.add(insc);
                
            }
            ps.close();
            rs.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(InscripcionData.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listaInsc;
    
    }
    
    public ArrayList<Materia> obtenerMateriasCursadas(int idAlumno){
        ArrayList<Materia> materiasC = new ArrayList<>();
        ResultSet rs = null;
        PreparedStatement ps = null;
        
        String query = "SELECT inscripcion.idMateria, nombre, año FROM inscripcion,materia"
                + "WHERE inscripcion.idMateria = materia.idMateria"
                + "AND inscripcion.idAlumno = ?";
        
        try {
            ps = conec.prepareStatement(query);
            ps.setInt(1, idAlumno);
            rs = ps.executeQuery();
            while(rs.next()){
            
                Materia materia = new Materia();
                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setNombre(rs.getString("nombre"));
                materia.setAño(rs.getInt("año"));
                
                materiasC.add(materia);   
            }
            ps.close();
            rs.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(InscripcionData.class.getName()).log(Level.SEVERE, null, ex);
        }
       return materiasC;
    }
    
    
    
    
    /*
    obtenerMateriasCursadas
    obtenerInscripcionesPorAlumno
    obtenerInscripciones
    guardarInscripciones
    obtenerMateriasNoCursadas
    borrarInscripcionMateriaALumno
    actualizarNota
    obtenerAlumnoXMAteria
    */
    
    

    //Los ultimos 4 metodos Martin Piriz
    public ArrayList<Materia> obtenerMateriasNoCursadas() {
        ArrayList<Materia> lista = new ArrayList<>();
        ResultSet res = null;
        PreparedStatement ps = null;

        inscripcion = null;
        String consulta = "select * from materia where idMateria NOT IN (SELECT M.idMateria FROM materia M,inscripcion I WHERE M.idMateria=I.idMateria and estado=1) and estado=1;";
        try {
            ps = conec.prepareStatement(consulta);

            res = ps.executeQuery();
            if (res.next()) {
                int idMateria = res.getInt("idMateria");
                String nombre = res.getString("nombre");
                int year = res.getInt("año");
                boolean estado = res.getBoolean("estado");

                lista.add(new Materia(idMateria, nombre, year, estado));

            }
            ps.close();
            res.close();

        } catch (SQLException ex) {
            Conexion.msjError.add("IncripcionData:  obtenerMateriasNoCursadas() ->" + ex.getMessage());
        }

        return lista;
    }

    public boolean borrarInscripcionMateriaALumno(int idAlumno, int idMateria) {
        String query = "DELETE FROM inscripcion WHERE idAlumno=? and idMateria=?";

        boolean res = false;

        try {
            PreparedStatement ps = conec.prepareStatement(query);
            ps.setInt(1, idAlumno);
            ps.setInt(2, idMateria);
            int borrado = ps.executeUpdate();

            if (borrado == 1) {
                res = true;
            }
            ps.close();

        } catch (SQLException ex) {

            Conexion.msjError.add("IncripcionData: borrarInscripcionMateriaALumno() ->" + ex.getMessage());
        }

        return res;
    }

    public boolean actualizarNota(int idAlumno, int idMateria, double nota) {
        String query = "UPDATE inscripcion SET nota=? WHERE idAlumno=? and idMateria=?";

        boolean res = false;

        try {
            PreparedStatement ps = conec.prepareStatement(query);
            ps.setDouble(1, nota);
            ps.setInt(2, idAlumno);
            ps.setInt(3, idMateria);
            int actualizar = ps.executeUpdate();

            if (actualizar == 1) {
                res = true;
            }
            ps.close();

        } catch (SQLException ex) {

            Conexion.msjError.add("MateriaData: actualizarNota() ->" + ex.getMessage());
        }

        return res;
    }

    public ArrayList<Alumno> obtenerAlumnoXMAteria(int idMateria) {
        ArrayList<Alumno> lista = new ArrayList<>();
        ResultSet res = null;
        PreparedStatement ps = null;

        inscripcion = null;
        String consulta = "SELECT A.idAlumno,dni,apellido, nombre, fechaNacimiento, estado FROM inscripcion I,alumno A WHERE A.idAlumno=I.idAlumno and  idMateria=?";

        try {
            ps = conec.prepareStatement(consulta);
            ps.setInt(1, idMateria);
            res = ps.executeQuery();
            if (res.next()) {
                int idAlumno = res.getInt("idMateria");
                int dni = res.getInt("dni");
                String apellido = res.getString("apellido");
                String nombre = res.getString("nombre");
                LocalDate fechaNacimiento = res.getDate("fechaNacimiento").toLocalDate();
                boolean estado = res.getBoolean("estado");

                lista.add(new Alumno(idAlumno, dni, apellido, nombre, fechaNacimiento, estado));

            }
            ps.close();
            res.close();

        } catch (SQLException ex) {
            Conexion.msjError.add("IncripcionData:  obtenerAlumnoXMAteria(int idMateria) ->" + ex.getMessage());
        }

        return lista;
    }

    //fin de la clase
}
