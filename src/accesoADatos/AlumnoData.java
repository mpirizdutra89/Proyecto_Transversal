package accesoADatos;

import accesoADatos.Conexion;
import entidades.Alumno;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.Date;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nicolas
 */
public class AlumnoData {

    private Alumno alumno;
    private static Connection conec = null;

    public AlumnoData() {
        conec=null;
        conec = Conexion.getConexion();
    }

    public boolean guardarAlumno(Alumno alumno) {
        String query = "INSERT INTO alumno (dni, apellido,nombre,fechaNacimiento,estado) VALUES (?,?,?,?,?)";

        boolean res = false;

        try {
            PreparedStatement ps = conec.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, alumno.getDni());
            ps.setString(2, alumno.getApellido());
            ps.setString(3, alumno.getNombre());
            ps.setDate(4, Date.valueOf(alumno.getFechaNacimiento()));
            ps.setBoolean(5, alumno.getEstado());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                alumno.setIdAlumno(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Alumno guardado con exito");
                res = true;
            }
            ps.close();
            rs.close();
        } catch (SQLException  | NullPointerException ex) {
            Conexion.msjError.add("Alumnos: guardarAlumno ->" + ex.getMessage());
        }

        //ver donde cerrrar la coneccion puede ser en el main o vista o cuando ce cierra un jFrame interno
        return res;
    }

    public Alumno buscarAlumno(int id) {
        alumno = null;
        PreparedStatement ps = null;
        String consulta = "SELECT dni,apellido,nombre,fechaNacimiento,estado FROM alumno WHERE  idAlumno= ? and estado=1";

        try {
            ps = conec.prepareStatement(consulta);
            ps.setInt(1, id);
            ResultSet res = ps.executeQuery();
            if (res.next()) {
                alumno = new Alumno();
                alumno.setIdAlumno(id);
                alumno.setDni(res.getInt("dni"));
                alumno.setApellido(res.getString("apellido"));
                alumno.setNombre(res.getString("nombre"));
                alumno.setFechaNacimiento(res.getDate("fechaNacimiento").toLocalDate());
                alumno.setEstado(res.getBoolean("estado"));
            } else {
                JOptionPane.showMessageDialog(null, "No existe el alumno");
            }
            ps.close();
            res.close();
        } catch (SQLException  | NullPointerException ex) {
            Conexion.msjError.add("Alumnos: BuscarAlumno ->" + ex.getMessage());
        }

        return alumno;
    }

    public Alumno buscarAlumnoPorDni(int dni) {

        String sql = "SELECT idAlumno, dni, apellido, nombre, fechaNacimiento FROM alumno WHERE dni = ? AND estado =1";

        Alumno alumno = null;

        try {
            PreparedStatement ps = conec.prepareStatement(sql);
            ps.setInt(1, dni);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {

                alumno = new Alumno();

                alumno.setIdAlumno(rs.getInt("idAlumno"));
                alumno.setDni(rs.getInt("dni"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
                alumno.setEstado(true);

            } else {
                JOptionPane.showMessageDialog(null, "No existe ese alumno");
            }
            ps.close();
            rs.close();
        } catch (SQLException  | NullPointerException ex) {
            Conexion.msjError.add("Alumnos: BuscarAlumnoPorDni ->" + ex.getMessage());
        }
        return alumno;
    }

    public void modificarAlumno(Alumno alumno) {
        String sql = "UPDATE alumno SET dni = ?, apellido = ?, nombre = ?, "
                + "fechaNacimiento = ?, estado = ? WHERE idAlumno = ?";


        try {
            PreparedStatement ps = conec.prepareStatement(sql);
            ps.setInt(1, alumno.getDni());
            ps.setString(2, alumno.getApellido());
            ps.setString(3, alumno.getNombre());
            ps.setDate(4, Date.valueOf(alumno.getFechaNacimiento()));
            ps.setBoolean(5, alumno.getEstado());
            ps.setInt(6, alumno.getIdAlumno());
            int resultado = ps.executeUpdate();
            if (resultado == 1) {
                JOptionPane.showMessageDialog(null, "Alumno modificado con exito");
            }
            ps.close();
        } catch (SQLException | NullPointerException ex) {
            Conexion.msjError.add("Alumnos: modificarAlumno ->" + ex.getMessage());
        }

    }

    public List<Alumno> listarAlumnos() {

        String sql = "SELECT * FROM alumno WHERE estado = 1";

        ArrayList<Alumno> alumnos = new ArrayList<>();

        try {
            PreparedStatement ps = conec.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Alumno alumno = new Alumno();

                alumno.setIdAlumno(rs.getInt("idAlumno"));
                alumno.setDni(rs.getInt("dni"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
                alumno.setEstado(true);
                alumnos.add(alumno);
            }
            ps.close();
            rs.close();
        } catch (SQLException  | NullPointerException ex) {
            Conexion.msjError.add("Alumnos: listarAlumnos ->" + ex.getMessage());
        }
        return alumnos;
    }

    public void eliminarAlumno(int id) {
        PreparedStatement ps;
        String consulta = "UPDATE alumno SET estado = 0 WHERE idAlumno = ?";

        try {
            ps = conec.prepareStatement(consulta);
            ps.setInt(1, id);
            int borrado = ps.executeUpdate();
            if (borrado == 1) {
                JOptionPane.showMessageDialog(null, "Alumno Borrado!!");
            }
            ps.close();
        } catch (SQLException  | NullPointerException ex) {
            Conexion.msjError.add("Alumnos: eliminarAlumno ->" + ex.getMessage());
        }
    }

}
