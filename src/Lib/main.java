/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lib;

import Controlador.NinjaControlador;
import Controlador.MisionNinjaControlador;
import Modelo.MisionNinjaDAO;
import Modelo.NinjaDAO;
import Vista.MisionNinjaVista;
import Vista.NinjaVista;

/**
 *
 * @author wilmer
 */
public class main {
    
    public static void main(String[] args) {
        
        NinjaDAO ninjaDAO = new NinjaDAO();
    NinjaVista ninjaVista = new NinjaVista();
    MisionNinjaDAO misionNinjaDAO = new MisionNinjaDAO();
    MisionNinjaVista misionNinjaVista = new MisionNinjaVista();
    MisionNinjaControlador misionNinjaControlador = new MisionNinjaControlador(misionNinjaDAO, misionNinjaVista);
    
    
   NinjaControlador ninjaControlador = new NinjaControlador(ninjaDAO, ninjaVista, misionNinjaControlador);
    
    ninjaControlador.iniciar();
        
    }
    
    
    
    
    
            
    
    
    
}
