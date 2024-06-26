package accesoADatos;

import java.sql.Statement;
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
        alumData = new AlumnoData();
        mateData = new MateriaData();
    }
    
    public void guardarInscripcion(Inscripcion insc){
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        
        String sql = "INSERT INTO inscripcion (idAlumno, idMateria, nota) "
                + " VALUES (?,?,?)";
        try{
        ps = conec.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1, insc.getAlumno().getIdAlumno());
        ps.setInt(2, insc.getMateria().getIdMateria());
        ps.setDouble(3, insc.getNota());
        ps.executeUpdate();
        rs = ps.getGeneratedKeys();
        if(rs.next()){
            insc.setIdInscripcion(rs.getInt(1));
            //JOptionPane.showMessageDialog(null, "Inscripcion Registrada");
        }
        
            ps.close();
            rs.close();
            
        }catch(SQLException | NullPointerException ex){
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
            
        } catch (SQLException | NullPointerException ex) {
            Logger.getLogger(InscripcionData.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listaInsc;
    
    }
    
    public ArrayList<Inscripcion> obtenerInscripcionesPorAlumno(int idAlumno){
        ArrayList<Inscripcion> listaInsc = new ArrayList<>();
        ResultSet rs = null;
        PreparedStatement ps = null;
        
        String query = "SELECT idInscripto,idAlumno, m.idMateria, m.nombre, nota "
                     + "FROM inscripcion i JOIN materia m "
                     + "ON (i.idMateria = m.idMateria) "
                     + "WHERE idAlumno = ?";
        
        try {
            ps = conec.prepareStatement(query);
            ps.setInt(1, idAlumno);
            rs = ps.executeQuery();
            while(rs.next()){
                
                Inscripcion insc = new Inscripcion();
                insc.setIdInscripcion(rs.getInt("idInscripto"));
                Alumno al = alumData.buscarAlumno(rs.getInt("idAlumno"));
                Materia mat = mateData.buscarMateria(rs.getInt("idMateria"));
                mat.setNombre(rs.getString("nombre"));
                
                insc.setAlumno(al);
                insc.setMateria(mat);
                insc.setNota(rs.getDouble("nota"));
                
                listaInsc.add(insc);
                
            }
            ps.close();
            rs.close();
            
        } catch (SQLException | NullPointerException ex) {
            Logger.getLogger(InscripcionData.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listaInsc;
    
    }
    
    public ArrayList<Materia> obtenerMateriasCursadas(int idAlumno){
        ArrayList<Materia> materiasC = new ArrayList<>();
        ResultSet rs = null;
        PreparedStatement ps = null;
        
        String query = " SELECT inscripcion.idMateria, nombre, año FROM inscripcion,materia "
                + " WHERE inscripcion.idMateria = materia.idMateria "
                + " AND inscripcion.idAlumno = ? ";
        
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
            
        } catch (SQLException | NullPointerException ex) {
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
    public ArrayList<Materia> obtenerMateriasNoCursadas( int idAlumno) {
        ArrayList<Materia> lista = new ArrayList<>();
        ResultSet res = null;
        PreparedStatement ps = null;

        inscripcion = null;
        String consulta = "select * from materia where idMateria NOT IN (SELECT M.idMateria FROM materia M,inscripcion I WHERE M.idMateria=I.idMateria and  idAlumno=? and  estado=1) and estado=1;";
        try {
            ps = conec.prepareStatement(consulta);
            ps.setInt(1, idAlumno);

            res = ps.executeQuery();
            while (res.next()) {
                int idMateria = res.getInt("idMateria");
                String nombre = res.getString("nombre");
                int year = res.getInt("año");
                boolean estado = res.getBoolean("estado");

                lista.add(new Materia(idMateria, nombre, year, estado));

            }
           
            ps.close();
            res.close();

        } catch (SQLException | NullPointerException ex) {
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

        } catch (SQLException | NullPointerException ex) {

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

        } catch (SQLException | NullPointerException ex) {

            Conexion.msjError.add("MateriaData: actualizarNota() ->" + ex.getMessage());
        }

        return res;
    }

    public ArrayList<Alumno> obtenerAlumnoXMAteria(int idMateria) {
        ArrayList<Alumno> lista = new ArrayList<>();
        ResultSet res = null;
        PreparedStatement ps = null;

        inscripcion = null;
        String consulta = "SELECT A.idAlumno, A.dni, A.apellido, A.nombre, A.fechaNacimiento, A.estado FROM inscripcion I,alumno A WHERE A.idAlumno=I.idAlumno AND  I.idMateria=?";

        try {
            ps = conec.prepareStatement(consulta);
            ps.setInt(1, idMateria);
            res = ps.executeQuery();
            while (res.next()) {
                Alumno alumno = new Alumno();
                alumno.setIdAlumno(res.getInt("idAlumno"));
                alumno.setDni(res.getInt("dni"));
                alumno.setApellido(res.getString("apellido"));
                alumno.setNombre(res.getString("nombre"));
                alumno.setFechaNacimiento(res.getDate("fechaNacimiento").toLocalDate());
                alumno.setEstado(res.getBoolean("estado"));

                lista.add(alumno);

            }
            ps.close();
            res.close();

        } catch (SQLException | NullPointerException ex) {
            Conexion.msjError.add("IncripcionData:  obtenerAlumnoXMAteria(int idMateria) ->" + ex.getMessage());
        }

        return lista;
    }

    //fin de la clase
}
