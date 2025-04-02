/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lib;

import Controlador.NinjaControlador;
import Modelo.NinjaDAO;
import Vista.NinjaVista;

/**
 *
 * @author wilmer
 */
public class main {
    
    public static void main(String[] args) {
        
        NinjaDAO ninjaDAO = new NinjaDAO();
    NinjaVista ninjaVista = new NinjaVista();
    NinjaControlador ninjaControlador = new NinjaControlador(ninjaDAO, ninjaVista);
    
    ninjaControlador.iniciar();
        
    }
    
    
    
    
    
            
    
    
    
}
