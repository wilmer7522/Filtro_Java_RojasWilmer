/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author wilmer
 */
public class Ninja {
    private int id;
    private String nombre;
    private int rango_id;
    private String aldea;

    public Ninja(int id, String nombre, int rango_id, String aldea) {
        this.id = id;
        this.nombre = nombre;
        this.rango_id = rango_id;
        this.aldea = aldea;
    }

    public Ninja(String nombre, int rango_id, String aldea) {
        this.nombre = nombre;
        this.rango_id = rango_id;
        this.aldea = aldea;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getRango_id() {
        return rango_id;
    }

    public void setRango_id(int rango_id) {
        this.rango_id = rango_id;
    }

    public String getAldea() {
        return aldea;
    }

    public void setAldea(String aldea) {
        this.aldea = aldea;
    }

   

    @Override
    public String toString() {
        return id + " - " + nombre + " - " + rango_id + " - " + aldea;
    }
    
    
}
