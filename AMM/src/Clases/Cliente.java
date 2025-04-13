/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.sql.Timestamp;

/**
 *
 * @author nyath
 */
public class Cliente extends Persona {
    //atributos
    private String observaciones;
        
    //constructores
    public Cliente() {
    }

    public Cliente(String observaciones, String nombres, String apellidos, String telefono, String email, String user_crea) {
        super(nombres, apellidos, telefono, email, user_crea);
        this.observaciones = observaciones;
    }

    public Cliente(String observaciones, String nombres, String apellidos, String telefono, String email, String user_modifica, Timestamp modificado_el) {
        super(nombres, apellidos, telefono, email, user_modifica, modificado_el);
        this.observaciones = observaciones;
    }

    public Cliente(String observaciones, String codigo, String nombres, String apellidos, String telefono, String email, String user_crea, Timestamp creado_el, String user_modifica, Timestamp modificado_el) {
        super(codigo, nombres, apellidos, telefono, email, user_crea, creado_el, user_modifica, modificado_el);
        this.observaciones = observaciones;
    }
    
    //getters y settes

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    
}
