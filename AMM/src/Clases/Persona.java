/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author nyath
 */
public class Persona {
    //atributos
    private int codigo;
    private String nombres;
    private String apellidos;
    private String contacto;
    
    //constructores
    public Persona (){}
    
    /*
    Constructor completo
    */
    public Persona (int codigo, String nombres, String apellidos, String contacto) {
        this.codigo = codigo;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.contacto = contacto;
    }
    
    //metodos
    public int getCodigo() { //regresa el valor de codigo
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }    
}
