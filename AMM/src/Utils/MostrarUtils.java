package Utils;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author nyath
 */
public class MostrarUtils {
    public int mostrarOpciones (Object[] opciones, String texto_interno, String titulo) {
        int selection = JOptionPane.showOptionDialog(null, texto_interno, titulo, JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);        
        return selection;        
    }
    
    public void mostrarTabla (String[] nombre_columnas, Object[][] datos, int horizontal, int vertical, String nombre_tabla){
        // Crear JTable y JScrollPane
        JTable tabla = new JTable(datos, nombre_columnas);
        JScrollPane scrollPane = new JScrollPane(tabla);
        scrollPane.setPreferredSize(new java.awt.Dimension(horizontal, vertical));

        // Mostrar tabla en JOptionPane
        JOptionPane.showMessageDialog(null, scrollPane, nombre_tabla, JOptionPane.INFORMATION_MESSAGE);
    }
    
    public String mostrarCombo (Object[] lista, String texto_interno){
        //crear combobox
        JComboBox<Object> combo = new JComboBox<>(lista);
        //mostrar el combobox
        int resultado = JOptionPane.showConfirmDialog(null, combo, texto_interno, JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        // Obtener selección si se presionó OK
        if (resultado == JOptionPane.OK_OPTION) {
            String seleccion = (String) combo.getSelectedItem();

            return seleccion;
        } else {
            JOptionPane.showMessageDialog(null, "Cancelaste la selección.");
            return null;
        }
    }
}
