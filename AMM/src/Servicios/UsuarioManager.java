package Servicios;

/**
 *
 * @author nyath
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Clases.ConexionBD;
import Clases.Usuario;
import java.sql.Timestamp;

public class UsuarioManager {
    public boolean insertUsuario(Usuario user){
        String sql = "INSERT INTO usuario (id_tipoUsua, nombre_usuario, contrasena_usuario, id_tipoDocu, documento_usuario, nombres, apellidos, telefono_usuario, correo_usuario, user_crea) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection cx = ConexionBD.getConnection();
                PreparedStatement stat = cx.prepareStatement(sql)){
            stat.setInt(1, user.getTipo_user());
            stat.setString(2, user.getUser());
            stat.setString(3, user.getPassword());
            stat.setInt(4, user.getTipo_docu());
            stat.setString(5, user.getDocumento());
            stat.setString(6, user.getNombres());
            stat.setString(7, user.getApellidos());
            stat.setString(8, user.getTelefono());
            stat.setString(9, user.getEmail());
            stat.setString(10, user.getUser_crea());
            
            int filas_afec = stat.executeUpdate();
            return filas_afec > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public Usuario buscarUsuario (String codigo_b) {
        Connection cx = ConexionBD.getConnection();
        Usuario us = null;
        
        if(cx != null) {
            String sql = "SELECT * FROM usuario WHERE id_usuario = ?";
            
            try {
                PreparedStatement stat = cx.prepareStatement(sql);
                stat.setString(1, codigo_b);
                ResultSet rs = stat.executeQuery();
                
                if(rs.next()) {
                    String id_usuario = rs.getString("id_usuario");
                    int id_tipoUsua = rs.getInt("id_tipoUsua");
                    String nombre_usuario = rs.getString("nombre_usuario");
                    String contrasena_usuario = rs.getString("contrasena_usuario");
                    int id_tipoDocu = rs.getInt("id_tipoDocu");
                    String documento_usuario = rs.getString("documento_usuario");
                    String nombres = rs.getString("nombres");
                    String apellidos = rs.getString("apellidos");
                    String telefono_usuario = rs.getString("telefono_usuario");
                    String correo_usuario = rs.getString("correo_usuario");
                    String user_crea = rs.getString("user_crea");
                    Timestamp creado_el = rs.getTimestamp("creado_el");
                    String user_modifica = rs.getString("user_modifica");
                    Timestamp modificado_el = rs.getTimestamp("modificado_el");
                    
                    us = new Usuario(id_tipoUsua, nombre_usuario, contrasena_usuario, id_tipoDocu, documento_usuario, id_usuario, nombres, apellidos, telefono_usuario, correo_usuario, user_crea, creado_el, user_modifica, modificado_el);
                }
                
                cx.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        return us;
    }
    
    public boolean modificarUsuario (Usuario usuario) {
        String sql = "UPDATE usuario SET id_tipoUsua = ?, nombre_usuario = ?, contrasena_usuario = ?, id_tipoDocu = ?, documento_usuario = ?, nombres = ?, apellidos = ?, telefono_usuario = ?, correo_usuario = ?, user_modifica = ?, modificado_el = ? WHERE id_usuario = ?";
        
        try (Connection cx = ConexionBD.getConnection();
                PreparedStatement stat = cx.prepareStatement(sql)){
            
            stat.setInt(1, usuario.getTipo_user());
            stat.setString(2, usuario.getUser());
            stat.setString(3, usuario.getPassword());
            stat.setInt(4, usuario.getTipo_docu());
            stat.setString(5, usuario.getDocumento());
            stat.setString(6, usuario.getNombres());
            stat.setString(7, usuario.getApellidos());
            stat.setString(8, usuario.getTelefono());
            stat.setString(9, usuario.getEmail());
            stat.setString(10, usuario.getUser_modifica());
            stat.setTimestamp(11, usuario.getModificado_el());
            stat.setString(12, usuario.getCodigo());
            
            int filas_afec = stat.executeUpdate();
            return filas_afec > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean eliminarUsuario (String codigo) {
        String sql = "DELETE FROM usuario WHERE id_usuario = ?";
        
        try (Connection cx = ConexionBD.getConnection();
                PreparedStatement stat = cx.prepareStatement(sql)){
            
            stat.setString(1, codigo);
            
            int filas_afec = stat.executeUpdate();            
            return filas_afec > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
