/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author nyath
 */
public class Usuario extends Persona{
    private String tipo_ident;
    private String ident;
    private String user ;
    private String password;
    private final String permisos;
    
    public Usuario(String permisos){
        this.permisos = permisos;
    }
    
    public Usuario(int codigo, String nombres, String apellidos, String contacto, String tipo_ident, String ident, String user, String password, String permisos) {
        super(codigo, nombres, apellidos, contacto);
        this.tipo_ident = tipo_ident;
        this.ident = ident;
        this.user = user;
        this.password = password;
        this.permisos = permisos;
    }

    public String getTipo_ident() {
        return tipo_ident;
    }

    public void setTipo_ident(String tipo_ident) {
        this.tipo_ident = tipo_ident;
    }

    public String getIdent() {
        return ident;
    }

    public void setIdent(String ident) {
        this.ident = ident;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPermisos() {
        return permisos;
    }   
}