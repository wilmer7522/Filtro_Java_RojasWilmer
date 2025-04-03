/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import Modelo.MisionNinja;
import java.time.LocalDate;
import java.util.Date;
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
    
}
