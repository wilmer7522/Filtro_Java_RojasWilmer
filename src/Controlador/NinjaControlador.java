/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.NinjaDAO;
import Vista.NinjaVista;
import java.util.Scanner;
import Modelo.Ninja;
import java.util.List;

/**
 *
 * @author wilmer
 */
public class NinjaControlador {

    private NinjaDAO ninjaDAO;
    private NinjaVista ninjaVista;
    private Scanner leer;

    public NinjaControlador(NinjaDAO ninjaDAO, NinjaVista ninjaVista) {
        this.ninjaDAO = ninjaDAO;
        this.ninjaVista = ninjaVista;
        this.leer = new Scanner(System.in);
    }

    public void iniciar() {

        boolean regresar = true;
        while (regresar) {
            System.out.println("Menu principal ");
            System.out.println("1. Crear Ninja");
            System.out.println("2. listar Ninjas");
            System.out.println("3. Misiones Ninja");
            System.out.println("4. Eliminar Ninja");
            System.out.println("5. Buscar Ninja por ID");
            System.out.println("6. Salir del Programa");
            System.out.println(":");
            int opcion = leer.nextInt();
            switch (opcion) {
                case 1:
                    Ninja nuevoNinja = ninjaVista.agregarNinja();
                    ninjaDAO.insertar(nuevoNinja);
                    System.out.println("Usuario Agregado!");
                    break;
                    
                case 2:
                    System.out.println("Lista de Ninjas y Habilidades ");
                    List<String> listaNinjas = ninjaDAO.obtenerNinjas();
                    for (String ninja : listaNinjas) {
                        System.out.println(ninja);
                    }
                    break;
                    
                    case 3:
                        
                        System.out.println("Lista de Misiones ");
                    List<String> listaMisiones = ninjaDAO.obtenerMisiones();
                    for (String ninja :  listaMisiones) {
                        System.out.println(ninja);
                    }
                    break;
                        
                   /* System.out.println("ingresar Datos de usuario a actualizar");
                    System.out.println("Ingrese ID a actualizar ");
                    int idAct = leer.nextInt();
                    leer.nextLine();
                        System.out.println("ingrese el Nombre del Ninja");
                    String nombre = leer.nextLine();
                    System.out.println("Rango ");
                    int rangoAct = leer.nextInt();
                    leer.nextLine();
                    System.out.println("Ingrese Aldea ");
                    String aldeaAct = leer.nextLine();
                    
                    ninjaDAO.actualizarNinja(idAct, nombre, rangoAct, aldeaAct);

                    listaNinjas = ninjaDAO.obtenerNinjas();
                    System.out.println("##################");

                    for (String ninja : listaNinjas) {
                        System.out.println(ninja);
                    }
                    break;*/

            }
        }
    }
}
