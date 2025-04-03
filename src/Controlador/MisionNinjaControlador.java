/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.MisionNinja;
import Modelo.MisionNinjaDAO;
import Vista.MisionNinjaVista;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author wilmer
 */
public class MisionNinjaControlador {
    
    private MisionNinjaDAO misionNinjaDAO;
    private MisionNinjaVista misionNinjaVista;
    private Scanner leer;
    
    
    public MisionNinjaControlador(MisionNinjaDAO misionNinjaDAO, MisionNinjaVista misionNinjaVista){
        this.misionNinjaDAO = misionNinjaDAO;
        this.misionNinjaVista = misionNinjaVista;
        this.leer = new Scanner(System.in);
    }
    
    
    public void iniciarMision(){
        
        System.out.println("Ingrese el ID del Ninja a buscar mision ");
                    int idBuscar = leer.nextInt();
                    
                    int buscarId = idBuscar;
                    misionNinjaDAO.buscarMisionId(buscarId);
                    
        
        
    }
    
    
    public void misionNinjaFechaFin(){
        System.out.println("Ingrese el ID del Ninja a buscar mision fnalizada");
                    int idBuscarMision = leer.nextInt();
                    
                    int buscarIdMision = idBuscarMision;
                    misionNinjaDAO.buscarMisionIdFechaFin(buscarIdMision);
    }
    
    public void crearMision(){
        
       
        MisionNinja nuevaMision = misionNinjaVista.agregarMision();
        misionNinjaDAO.insertarMision(nuevaMision);
            System.out.println("Mision Asignada Exitosamente");
    }
    
    
    public void finalizarMision(){
        List<String> listaMisiones = misionNinjaDAO.obtenerMisiones();
        for (String misiones : listaMisiones){
            System.out.println(misiones);
        }
        
        
        System.out.println("Ingrese el ID de la Mision a finalizar");
        int id = leer.nextInt();
        
        misionNinjaDAO.finMision(id);
        
        
    }
}
