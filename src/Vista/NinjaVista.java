/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import Modelo.Ninja;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author wilmer
 */
public class NinjaVista {

    //agregar
    public Ninja agregarNinja() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Datos para nuevo usuario");
        
        System.out.println("Nombre:");
        String nombre = sc.nextLine();
        
        System.out.println("Rango");
        int rango = sc.nextInt();
        sc.nextLine();
        System.out.println("ALdea");
        
        String aldea = sc.nextLine();
        
        return new Ninja(nombre, rango, aldea);
    }

    //Listar
    public void mostrarNinjas(List<Ninja> ninjas) {
        System.out.println("Lista de Ninjas:");
        for (Ninja N : ninjas) {
            System.out.println(N);
        }

    }
    
    
  
    
}
