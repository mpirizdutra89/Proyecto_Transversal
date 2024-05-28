package accesoADatos;

import java.sql.*;
import entidades.Materia;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * @author Ferrando Carlos
 */
public class MateriaData {

    private static Connection con = null;

    public MateriaData() {
        con = Conexion.getConexion();
    }
    /*METODO PARA GUARDAR MATERIAS*/
    public void guardarMateria(Materia materia) {

        String sql = "INSERT INTO materia( nombre, año, estado) "
                + "VALUES (?,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, materia.getNombre());
            ps.setInt(2, materia.getAño());
            ps.setBoolean(3, materia.isEstado());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                materia.setIdMateria(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Materia guardada!!");
            }
            ps.close();
            rs.close();
        } catch (SQLException | NullPointerException ex) {
            Conexion.msjError.add("Materias: guardarMateria ->" + ex.getMessage());
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla materia");
        }
    }
    /*METODO PARA BUSCAR MATERIAS*/
    public Materia buscarMateria(int id) {

        Materia materia = null;

        String sql = "SELECT idMateria, nombre, año, estado FROM materia "
                + "WHERE idMateria = ? and estado = 1 ";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                materia = new Materia();
                materia.setIdMateria(id);
                materia.setNombre(rs.getString("nombre"));
                materia.setAño(rs.getInt("año"));
                materia.setEstado(true);
            } else {
                JOptionPane.showMessageDialog(null, "No existe esa materia");
            }
            ps.close();
            rs.close();
        } catch (SQLException | NullPointerException ex) {
            Conexion.msjError.add("Materias: buscarMateria ->" + ex.getMessage());
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla materia");
        }

        return materia;
    }
    /*METODO PARA MODIFICAR MATERIAS*/
    public void modificarMateria(Materia materia) {

        String sql = "UPDATE materia SET nombre = ?, año = ?, estado = ? WHERE idMateria = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, materia.getNombre());
            ps.setInt(2, materia.getAño());
            ps.setBoolean(3, materia.isEstado());
            ps.setInt(4, materia.getIdMateria());
            int exito = ps.executeUpdate();

            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Materia modificada!!");
            }

            ps.close();
        } catch (SQLException | NullPointerException ex) {
            Conexion.msjError.add("Materias: modificarMateria ->" + ex.getMessage());
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla materia");
        }

    }
    /*METODO PARA ELIMINAR MATERIAS*/
    public void eliminarMateria(int id) {
        String sql = "UPDATE materia SET estado = 0 WHERE idMateria = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            int exito = ps.executeUpdate();

            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Materia eliminada!!");
            }

            ps.close();
        } catch (SQLException | NullPointerException ex) {
            Conexion.msjError.add("Materias: eliminarMateria ->" + ex.getMessage());
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla materia");
        }

    }
    /*METODO PARA LISTAR MATERIAS*/
    public List<Materia> listarMaterias() {

        String sql = "SELECT idMateria, nombre, año FROM materia "
                + "WHERE estado = 1";
        ArrayList<Materia> materias = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {                
                Materia materia = new Materia();
                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setNombre(rs.getString("nombre"));
                materia.setAño(rs.getInt("año"));
                materia.setEstado(true);
                
                materias.add(materia);
            }
            ps.close();
            rs.close();
        } catch (SQLException | NullPointerException ex) {
            Conexion.msjError.add("Materias: listarMaterias ->" + ex.getMessage());
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla materia");
        }
        return materias;
    }
}
