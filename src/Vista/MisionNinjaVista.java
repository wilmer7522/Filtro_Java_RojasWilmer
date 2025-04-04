/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import Modelo.MisionNinja;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author wilmer
 */
public class MisionNinjaVista {
    
    
     //agregar mision
    public MisionNinja agregarMision() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Datos para nuevo usuario");
        
        System.out.println("Fecha Inicio:");
        String fecha = sc.nextLine();
        LocalDate fechaInicio = LocalDate.parse(fecha);
        
        System.out.println("Ninja ID");
        int ninja = sc.nextInt();
        sc.nextLine();
        
        System.out.println("Mision ID");
        int mision = sc.nextInt();
        
        return new MisionNinja(fechaInicio, ninja, mision);
    }
    
    
    //listar misiones completadas
    

public void imprimirMisiones(List<MisionNinja> misiones, String archivo){
    try(BufferedWriter buffer = new BufferedWriter(new FileWriter(archivo))){
        for (MisionNinja mn : misiones){
            buffer.write("Ninja: "+mn.getNinja());
           buffer.newLine();
            buffer.write("Mision: " +mn.getDescripcion());
            buffer.newLine();
            buffer.write("Fecha Inicio: " +mn.getFechaInicio().toString());
           buffer.newLine();
            buffer.write("Fecha Finalicazion: " +mn.getFechaFin().toString());
            buffer.newLine();
            buffer.write("###############################");
            buffer.newLine();
            
        }
        
        System.out.println("Archivo generado con Exito a " + archivo);
    }catch (IOException e){
        System.out.println("Error al generar Archivo.");
        e.printStackTrace();
    }
}

   
}

    

