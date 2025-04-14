package amm;

import Clases.*;
import Servicios.*;
import Utils.*;
import javax.swing.JOptionPane;

/**
 *
 * @author nyath
 */
public class AMM {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ClienteManager cl_manager = new ClienteManager();
        EquipoTrabajoManager eq_manager = new EquipoTrabajoManager();
        ServicioManager serv_manager = new ServicioManager();
        UsuarioManager user_manager = new UsuarioManager();
        VariosManager tipos_manager = new VariosManager();
        
        Object[] opciones = {"Opción 1", "Opción 2", "Cancelar"};
        int seleccion = JOptionPane.showOptionDialog(null,"Elige una opción","Menú",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,
            opciones,
            opciones[0]
        );

        System.out.println("Seleccionaste: " + seleccion);  // Índice de la opción elegida
        
        
    }    
}
