/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author nyath
 */
public class Coordinador extends Usuario{

    public Coordinador() {
        super("2");
    }
    
    public Coordinador(int codigo, String nombres, String apellidos, String contacto, String tipo_ident, String ident, String user, String password) {
        super(codigo, nombres, apellidos, contacto, tipo_ident, ident, user, password, "2");
    }
    
    
}
