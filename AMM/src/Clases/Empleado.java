/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author nyath
 */
public class Empleado extends Usuario {
    private int horas_trab;
    private String equipo[];

    public Empleado() {
        super("3");
    }
    
    public Empleado(int codigo, String nombres, String apellidos, String contacto, String tipo_ident, String ident, String user, String password, int horas_trab, String equipo[]) {
        super(codigo, nombres, apellidos, contacto, tipo_ident, ident, user, password, "3");
        this.horas_trab = horas_trab;
        this.equipo = equipo;
    }

    public int getHoras_trab() {
        return horas_trab;
    }

    public void setHoras_trab(int horas_trab) {
        this.horas_trab = horas_trab;
    }

    public String[] getEquipo() {
        return equipo;
    }

    public void setEquipo(String[] equipo) {
        this.equipo = equipo;
    }    
}

