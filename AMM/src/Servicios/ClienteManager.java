package Servicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Clases.ConexionBD;
import Clases.Cliente;
import java.sql.Timestamp;

/**
 *
 * @author nyath
 */
public class ClienteManager {
    
    public boolean insertCliente(Cliente cliente){
        String sql = "INSERT INTO cliente (nombre_cliente, apellido_cliente, direccion_cliente, telefono_cliente, correo_cliente, observacion_cliente, user_crea) VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection cx = ConexionBD.getConnection();
                PreparedStatement stat = cx.prepareStatement(sql)){
            stat.setString(1, cliente.getNombres());
            stat.setString(2, cliente.getApellidos());
            stat.setString(3, cliente.getDireccion());
            stat.setString(4, cliente.getTelefono());
            stat.setString(5, cliente.getEmail());
            stat.setString(6, cliente.getObservaciones());
            stat.setString(7, cliente.getUser_crea());
            
            int filas_afec = stat.executeUpdate();
            return filas_afec > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public Cliente buscarCliente (int codigo_b) {
        Connection cx = ConexionBD.getConnection();
        Cliente cl = null;
        
        if(cx != null) {
            String sql = "SELECT * FROM cliente WHERE id_cliente = ?";
            
            try {
                PreparedStatement stat = cx.prepareStatement(sql);
                stat.setInt(1, codigo_b);
                ResultSet rs = stat.executeQuery();
                
                if(rs.next()) {
                    int codigo = rs.getInt("id_cliente");
                    String nombre = rs.getString("nombre_cliente");
                    String apellido = rs.getString("apellido_cliente");
                    String direccion = rs.getString("direccion_cliente");
                    String telefono = rs.getString("telefono_cliente");
                    String correo = rs.getString("correo_cliente");
                    String observacion = rs.getString("observacion_cliente");
                    String user_crea = rs.getString("user_crea");
                    Timestamp creado_el = rs.getTimestamp("creado_el");
                    String user_modifica = rs.getString("user_modifica");
                    Timestamp modificado_el = rs.getTimestamp("modificado_el");
                    
                    String codigotxt = String.valueOf(codigo);
                    
                    cl = new Cliente(direccion, observacion, codigotxt, nombre, apellido, telefono, correo, user_crea, creado_el, user_modifica, modificado_el);
                }
                
                cx.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        return cl;
    }
    
    public boolean modificarCliente (Cliente cliente) {
        String sql = "UPDATE cliente SET nombre_cliente = ?, apellido_cliente = ?, direccion_cliente = ?, telefono_cliente = ?, correo_cliente = ?, observacion_cliente = ?, user_modifica = ?, modificado_el = ? WHERE id_cliente = ?";
        
        try (Connection cx = ConexionBD.getConnection();
                PreparedStatement stat = cx.prepareStatement(sql)){
            
            stat.setString(1, cliente.getNombres());
            stat.setString(2, cliente.getApellidos());
            stat.setString(3, cliente.getDireccion());
            stat.setString(4, cliente.getTelefono());
            stat.setString(5, cliente.getEmail());
            stat.setString(6, cliente.getObservaciones());
            stat.setString(7, cliente.getUser_modifica());
            stat.setTimestamp(8, cliente.getModificado_el());
            
            String cod_cliente = cliente.getCodigo(); //sacar string del codigo
            
            stat.setInt(9, Integer.valueOf(cod_cliente)); //codigo transformado a int(id_cliente es int en bd)
            
            int filas_afec = stat.executeUpdate();
            return filas_afec > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean eliminarCliente (int codigo) {
        String sql = "DELETE FROM cliente WHERE id_cliente = ?";
        
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
}
