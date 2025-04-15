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
import Clases.Servicio;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class ServicioManager {
    public boolean insertServicio(Servicio service){
        String sql = "INSERT INTO usuario (id_cliente, id_equipo, id_tipoLimp, fecha, hora, tiempo_estimado, tiempo_finalizacion, precio, observacion, user_crea) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection cx = ConexionBD.getConnection();
                PreparedStatement stat = cx.prepareStatement(sql)){
            stat.setInt(1, service.getId_cliente());
            stat.setInt(2, service.getId_equipo());
            stat.setInt(3, service.getId_tipo_limp());
            stat.setDate(4, java.sql.Date.valueOf(service.getFecha()));
            stat.setTime(5, java.sql.Time.valueOf(service.getHora()));
            stat.setTime(6, java.sql.Time.valueOf(service.getTiempo_estimado()));
            stat.setTime(7, java.sql.Time.valueOf(service.getTiempo_finalizacion()));
            stat.setInt(8, service.getPrecio());
            stat.setString(9, service.getObservacion());
            stat.setString(10, service.getUser_crea());
            
            int filas_afec = stat.executeUpdate();
            return filas_afec > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public Servicio buscarServicio (int codigo_b) {
        Connection cx = ConexionBD.getConnection();
        Servicio serv = null;
        
        if(cx != null) {
            String sql = "SELECT * FROM servicio WHERE id_servicio = ?";
            
            try {
                PreparedStatement stat = cx.prepareStatement(sql);
                stat.setInt(1, codigo_b);
                ResultSet rs = stat.executeQuery();
                
                if(rs.next()) {
                    int id_servicio = rs.getInt("id_servicio");
                    int id_cliente = rs.getInt("id_cliente");
                    int id_equipo = rs.getInt("id_equipo");
                    int id_tipoLimp = rs.getInt("id_tipoLimp");
                    LocalDate fecha = rs.getDate("fecha").toLocalDate();
                    LocalTime hora = rs.getTime("hora").toLocalTime();
                    LocalTime tiempo_estimado = rs.getTime("tiempo_estimado").toLocalTime();
                    LocalTime tiempo_finalizacion = rs.getTime("tiempo_finalizacion").toLocalTime();
                    int precio = rs.getInt("precio");
                    String observacion = rs.getString("observacion");
                    String user_crea = rs.getString("user_crea");
                    Timestamp creado_el = rs.getTimestamp("creado_el");
                    String user_modifica = rs.getString("user_modifica");
                    Timestamp modificado_el = rs.getTimestamp("modificado_el");
                    
                    serv = new Servicio(id_servicio, id_cliente, id_equipo, id_tipoLimp, fecha, hora, tiempo_estimado, tiempo_finalizacion, precio, observacion, user_crea, creado_el, user_modifica, modificado_el);
                }
                
                cx.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        return serv;
    }
    
    public static Servicio[] getAllFechaServicio (LocalDate fecha_b) {
        Connection cx = ConexionBD.getConnection();
        List<Servicio> serv = new ArrayList<>();
        
        if(cx != null) {
            String sql = "SELECT * FROM servicio WHERE fecha = ?";
            
            try {
                PreparedStatement stat = cx.prepareStatement(sql);
                stat.setDate(1, java.sql.Date.valueOf(fecha_b));
                ResultSet rs = stat.executeQuery();
                
                if(rs.next()) {
                    int id_servicio = rs.getInt("id_servicio");
                    int id_cliente = rs.getInt("id_cliente");
                    int id_equipo = rs.getInt("id_equipo");
                    int id_tipoLimp = rs.getInt("id_tipoLimp");
                    LocalDate fecha = rs.getDate("fecha").toLocalDate();
                    LocalTime hora = rs.getTime("hora").toLocalTime();
                    LocalTime tiempo_estimado = rs.getTime("tiempo_estimado").toLocalTime();
                    LocalTime tiempo_finalizacion = rs.getTime("tiempo_finalizacion").toLocalTime();
                    int precio = rs.getInt("precio");
                    String observacion = rs.getString("observacion");
                    String user_crea = rs.getString("user_crea");
                    Timestamp creado_el = rs.getTimestamp("creado_el");
                    String user_modifica = rs.getString("user_modifica");
                    Timestamp modificado_el = rs.getTimestamp("modificado_el");
                    
                    Servicio temp = new Servicio(id_servicio, id_cliente, id_equipo, id_tipoLimp, fecha, hora, tiempo_estimado, tiempo_finalizacion, precio, observacion, user_crea, creado_el, user_modifica, modificado_el);
                    
                    serv.add(temp);
                }
                
                cx.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        return serv.toArray(new Servicio[0]);
    }
    
    public boolean modificarServicio (Servicio servicio) {
        String sql = "UPDATE usuario SET id_cliente = ?, id_equipo = ?, id_tipoLimp = ?, fecha = ?, hora = ?, tiempo_estimado = ?, tiempo_finalizacion = ?, precio = ?, observacion = ?, user_modifica = ?, modificado_el = ? WHERE id_servicio = ?";
        
        try (Connection cx = ConexionBD.getConnection();
                PreparedStatement stat = cx.prepareStatement(sql)){
            
            stat.setInt(1, servicio.getId_cliente());
            stat.setInt(2, servicio.getId_equipo());
            stat.setInt(3, servicio.getId_tipo_limp());
            stat.setDate(4, java.sql.Date.valueOf(servicio.getFecha()));
            stat.setTime(5, java.sql.Time.valueOf(servicio.getHora()));
            stat.setTime(6, java.sql.Time.valueOf(servicio.getTiempo_estimado()));
            stat.setTime(7, java.sql.Time.valueOf(servicio.getTiempo_finalizacion()));
            stat.setInt(8, servicio.getPrecio());
            stat.setString(9, servicio.getObservacion());
            stat.setString(10, servicio.getUser_modifica());
            stat.setTimestamp(11, servicio.getModificado_el());
            stat.setInt(12, servicio.getId_servicio());
            
            int filas_afec = stat.executeUpdate();
            return filas_afec > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean eliminarServicio (int codigo_servicio) {
        String sql = "DELETE FROM servicio WHERE id_servicio = ?";
        
        try (Connection cx = ConexionBD.getConnection();
                PreparedStatement stat = cx.prepareStatement(sql)){
            
            stat.setInt(1, codigo_servicio);
            
            int filas_afec = stat.executeUpdate();            
            return filas_afec > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
