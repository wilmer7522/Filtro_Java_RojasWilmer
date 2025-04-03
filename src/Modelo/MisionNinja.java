/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.time.LocalDate;

/**
 *
 * @author wilmer
 */
public class MisionNinja {
    private int id;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private int ninja_id;
    private int mision_id;

    public MisionNinja(int id, LocalDate fechaInicio, LocalDate fechaFin, int ninja_id, int mision_id) {
        this.id = id;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.ninja_id = ninja_id;
        this.mision_id = mision_id;
    }

    public MisionNinja(LocalDate fechaInicio, LocalDate fechaFin, int ninja_id, int mision_id) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.ninja_id = ninja_id;
        this.mision_id = mision_id;
    }

    public MisionNinja(LocalDate fechaInicio, int ninja_id, int mision_id) {
        this.fechaInicio = fechaInicio;
        this.ninja_id = ninja_id;
        this.mision_id = mision_id;
    }

    public MisionNinja(int id, LocalDate fechaFin, int ninja_id, int mision_id) {
        this.id = id;
        this.fechaFin = fechaFin;
        this.ninja_id = ninja_id;
        this.mision_id = mision_id;
    }
    
    
    
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public int getNinja_id() {
        return ninja_id;
    }

    public void setNinja_id(int ninja_id) {
        this.ninja_id = ninja_id;
    }

    public int getMision_id() {
        return mision_id;
    }

    public void setMision_id(int mision_id) {
        this.mision_id = mision_id;
    }

    @Override
    public String toString() {
        return id + " - " + fechaInicio + " - " + fechaFin + " - " + ninja_id + " - " + mision_id;
    }
    
    
    
    
}
