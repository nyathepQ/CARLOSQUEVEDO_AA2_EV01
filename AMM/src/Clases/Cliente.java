/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

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

    public Cliente(int codigo, String nombres, String apellidos, String contacto, String observaciones) {
        super(codigo, nombres, apellidos, contacto);
        this.observaciones = observaciones;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }    
}
