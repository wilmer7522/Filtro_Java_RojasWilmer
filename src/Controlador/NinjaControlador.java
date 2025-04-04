/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.MisionNinja;
import Modelo.MisionNinjaDAO;
import Modelo.NinjaDAO;
import Vista.NinjaVista;
import java.util.Scanner;
import Modelo.Ninja;
import Vista.MisionNinjaVista;
import java.util.List;

/**
 *
 * @author wilmer
 */
public class NinjaControlador {

    private NinjaDAO ninjaDAO;
    private NinjaVista ninjaVista;
    private MisionNinjaDAO misionNinjaDAO;
    private MisionNinjaVista misionNinjaVista;
    private MisionNinjaControlador misionNinjaControlador;
    private Scanner leer;

    public NinjaControlador(NinjaDAO ninjaDAO, NinjaVista ninjaVista, MisionNinjaControlador misionNinjaControlador, MisionNinjaDAO misionNinjaDAO, MisionNinjaVista misionNinjaVista) {
        this.ninjaDAO = ninjaDAO;
        this.ninjaVista = ninjaVista;
        this.misionNinjaDAO = misionNinjaDAO;
        this.misionNinjaVista = misionNinjaVista;
        this.misionNinjaControlador = misionNinjaControlador;
        this.leer = new Scanner(System.in);
    }

    public void iniciar() {

        boolean regresar = true;
        while (regresar) {
            System.out.println("Menu principal ");
            System.out.println("1. Crear Ninja");
            System.out.println("2. listar Ninjas");
            System.out.println("3. Misiones Ninja");
            System.out.println("4. Ver misiones Completadas de Ninja");
            System.out.println("5. Asignar Mision a Ninja");
            System.out.println("6. Finalizar Mision");
            System.out.println("7. Mostrar Misiones Completadas");
            System.out.println("8. Salir");
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
                        
                        misionNinjaControlador.iniciarMision();
                    break;
                    
                    
                    case 4:
                        
                        misionNinjaControlador.misionNinjaFechaFin();
                        break;
                        
                    case 5:
                        misionNinjaControlador.crearMision();
                        break;
                        
                    case 6:
                        misionNinjaControlador.finalizarMision();
                        break;
                        
                    case 7:
                        List<MisionNinja> listaMisiones = misionNinjaDAO.obtenerMsionesCompletas();
                        misionNinjaVista.imprimirMisiones(listaMisiones, "misiones_Completadas.txt");
                        
                    case 8:
                        System.out.println("Saliendo...");
                    regresar = false;
                    break;
                        
                        
                   

            }
        }
    }
}
