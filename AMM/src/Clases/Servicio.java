/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author nyath
 */
public class Servicio {
    private String id_servicio;
    private String cliente;
    private String direccion;
    private String equipo;
    private LocalDate fecha;
    private LocalTime hora;
    private String tipo_limp;
    private int habitaciones;
    private int baños;
    private int pasillos;
    private int pago;
    private String medio_pago;
    private String observaciones;
    
    public Servicio(){
        
    }

    public Servicio(String id_servicio, String cliente, String direccion, String equipo, LocalDate fecha, LocalTime hora, String tipo_limp, int habitaciones, int baños, int pasillos, int pago, String medio_pago, String observaciones) {
        this.id_servicio = id_servicio;
        this.cliente = cliente;
        this.direccion = direccion;
        this.equipo = equipo;
        this.fecha = fecha;
        this.hora = hora;
        this.tipo_limp = tipo_limp;
        this.habitaciones = habitaciones;
        this.baños = baños;
        this.pasillos = pasillos;
        this.pago = pago;
        this.medio_pago = medio_pago;
        this.observaciones = observaciones;
    }

    public String getId_servicio() {
        return id_servicio;
    }

    public void setId_servicio(String id_servicio) {
        this.id_servicio = id_servicio;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public String getTipo_limp() {
        return tipo_limp;
    }

    public void setTipo_limp(String tipo_limp) {
        this.tipo_limp = tipo_limp;
    }

    public int getHabitaciones() {
        return habitaciones;
    }

    public void setHabitaciones(int habitaciones) {
        this.habitaciones = habitaciones;
    }

    public int getBaños() {
        return baños;
    }

    public void setBaños(int baños) {
        this.baños = baños;
    }

    public int getPasillos() {
        return pasillos;
    }

    public void setPasillos(int pasillos) {
        this.pasillos = pasillos;
    }

    public int getPago() {
        return pago;
    }

    public void setPago(int pago) {
        this.pago = pago;
    }

    public String getMedio_pago() {
        return medio_pago;
    }

    public void setMedio_pago(String medio_pago) {
        this.medio_pago = medio_pago;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    
    
    
}
