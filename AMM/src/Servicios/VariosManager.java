package Servicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Clases.ConexionBD;
import Clases.Varios;
import java.sql.Timestamp;

/**
 *
 * @author nyath
 */
public class VariosManager {
    
    //tipo_documento
    public boolean insertTipoDocu (Varios tipo_docu) {
        String sql = "INSERT INTO tipo_documento (nombre_tipo, user_crea) VALUES (?, ?)";
        
        try (Connection cx = ConexionBD.getConnection();
            PreparedStatement stat = cx.prepareStatement(sql)){
            
            stat.setString(1, tipo_docu.getNombre());
            stat.setString(2, tipo_docu.getUser_crea());
            
            int filas_afec = stat.executeUpdate();
            return filas_afec > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public Varios buscarTipoDocu (int codigo_b) {
        Connection cx = ConexionBD.getConnection();
        Varios vr = null;
        
        if(cx != null) {
            String sql = "SELECT * FROM tipo_documento WHERE id_tipoDocu = ?";
            
            try {
                PreparedStatement stat = cx.prepareStatement(sql);
                stat.setInt(1, codigo_b);
                ResultSet rs = stat.executeQuery();
                
                if(rs.next()) {
                    int codigo = rs.getInt("id_tipoDocu");
                    String nombre = rs.getString("nombre_tipo");
                    String user_crea = rs.getString("user_crea");
                    Timestamp creado_el = rs.getTimestamp("creado_el");
                    String user_modifica = rs.getString("user_modifica");
                    Timestamp modificado_el = rs.getTimestamp("modificado_el");
                    
                    vr = new Varios(codigo, nombre, user_crea, creado_el, user_modifica, modificado_el);
                }
                
                cx.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        return vr;
    }
    
    public boolean modificarTipoDocu (Varios tipo_docu){
        String sql = "UPDATE tipo_documento SET nombre_tipo = ?, user_modifica = ?, modificado_el = ? WHERE id_tipoDocu = ?";
        
        try (Connection cx = ConexionBD.getConnection();
                PreparedStatement stat = cx.prepareStatement(sql)){
            
            stat.setString(1, tipo_docu.getNombre());
            stat.setString(2, tipo_docu.getUser_modifica());
            stat.setTimestamp(3, tipo_docu.getModificado_el());
            stat.setInt(4, tipo_docu.getCodigo());
            
            int filas_afec = stat.executeUpdate();
            return filas_afec > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean eliminarTipoDocu (int codigo) {
        String sql = "DELETE FROM tipo_documento WHERE id_tipoDocu = ?";
        
        try (Connection cx = ConexionBD.getConnection();
                PreparedStatement stat = cx.prepareStatement(sql)){
            
            stat.setInt(1, codigo);
            int filas_afec = stat.executeUpdate();
            
            return filas_afec > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    //tipo_limpieza
    public boolean insertTipoLimp (Varios tipo_limp) {
        String sql = "INSERT INTO tipo_limpieza (nombre_tipo, user_crea) VALUES (?, ?)";
        
        try (Connection cx = ConexionBD.getConnection();
            PreparedStatement stat = cx.prepareStatement(sql)){
            
            stat.setString(1, tipo_limp.getNombre());
            stat.setString(2, tipo_limp.getUser_crea());
            
            int filas_afec = stat.executeUpdate();
            return filas_afec > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public Varios buscarTipoLimp (String codigo_b) {
        Connection cx = ConexionBD.getConnection();
        Varios vr = null;
        
        if(cx != null) {
            String sql = "SELECT * FROM tipo_limpieza WHERE id_tipoLimp = ?";
            
            try {
                PreparedStatement stat = cx.prepareStatement(sql);
                stat.setString(1, codigo_b);
                ResultSet rs = stat.executeQuery();
                
                if(rs.next()) {
                    int codigo = rs.getInt("id_tipoLimp");
                    String nombre = rs.getString("nombre_tipo");
                    String user_crea = rs.getString("user_crea");
                    Timestamp creado_el = rs.getTimestamp("creado_el");
                    String user_modifica = rs.getString("user_modifica");
                    Timestamp modificado_el = rs.getTimestamp("modificado_el");
                    
                    vr = new Varios(codigo, nombre, user_crea, creado_el, user_modifica, modificado_el);
                }
                
                cx.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        return vr;
    }
    
    public boolean modificarTipoLimp (Varios tipo_limp){
        String sql = "UPDATE tipo_limpieza SET nombre_tipo = ?, user_modifica = ?, modificado_el = ? WHERE id_tipoLimp = ?";
        
        try (Connection cx = ConexionBD.getConnection();
                PreparedStatement stat = cx.prepareStatement(sql)){
            
            stat.setString(1, tipo_limp.getNombre());
            stat.setString(2, tipo_limp.getUser_modifica());
            stat.setTimestamp(3, tipo_limp.getModificado_el());
            stat.setInt(4, tipo_limp.getCodigo());
            
            int filas_afec = stat.executeUpdate();
            return filas_afec > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean eliminarTipoLimp (int codigo) {
        String sql = "DELETE FROM tipo_limpieza WHERE id_tipoLimp = ?";
        
        try (Connection cx = ConexionBD.getConnection();
                PreparedStatement stat = cx.prepareStatement(sql)){
            
            stat.setInt(1, codigo);
            int filas_afec = stat.executeUpdate();
            
            return filas_afec > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    //tipo_usuario
    public Varios buscarTipoUsua (String codigo_b) {
        Connection cx = ConexionBD.getConnection();
        Varios vr = null;
        
        if(cx != null) {
            String sql = "SELECT * FROM tipo_usuario WHERE id_tipoUsua = ?";
            
            try {
                PreparedStatement stat = cx.prepareStatement(sql);
                stat.setString(1, codigo_b);
                ResultSet rs = stat.executeQuery();
                
                if(rs.next()) {
                    int codigo = rs.getInt("id_tipoUsua");
                    String nombre = rs.getString("nombre_tipo");
                    String user_crea = rs.getString("user_crea");
                    Timestamp creado_el = rs.getTimestamp("creado_el");
                    String user_modifica = rs.getString("user_modifica");
                    Timestamp modificado_el = rs.getTimestamp("modificado_el");
                    
                    vr = new Varios(codigo, nombre, user_crea, creado_el, user_modifica, modificado_el);
                }
                
                cx.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        return vr;
    }
}
