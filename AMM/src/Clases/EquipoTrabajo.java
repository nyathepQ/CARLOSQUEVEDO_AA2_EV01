/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author nyath
 */
public class EquipoTrabajo {
    private String id_servicio;
    private String nombre_equipo;
    private String lider;
    private String miembro1;
    private String miembro2;
    
    public EquipoTrabajo () {
        
    }
    
    public EquipoTrabajo (String id_servicio, String nombre_equipo, String lider, String miembro1, String miembro2){
        this.id_servicio = id_servicio;
        this.nombre_equipo = nombre_equipo;
        this.lider = lider;
        this.miembro1 = miembro1;
        this.miembro2 = miembro2;
    }

    public String getId_servicio() {
        return id_servicio;
    }

    public void setId_servicio(String id_servicio) {
        this.id_servicio = id_servicio;
    }

    public String getNombre_equipo() {
        return nombre_equipo;
    }

    public void setNombre_equipo(String nombre_equipo) {
        this.nombre_equipo = nombre_equipo;
    }

    public String getLider() {
        return lider;
    }

    public void setLider(String lider) {
        this.lider = lider;
    }

    public String getMiembro1() {
        return miembro1;
    }

    public void setMiembro1(String miembro1) {
        this.miembro1 = miembro1;
    }

    public String getMiembro2() {
        return miembro2;
    }

    public void setMiembro2(String miembro2) {
        this.miembro2 = miembro2;
    }
    
}
