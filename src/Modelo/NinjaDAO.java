/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author wilmer
 */
public class NinjaDAO {
    
     private String URL = "jdbc:mysql://bj0vtgdngc2dmtlcjknw-mysql.services.clever-cloud.com:3306/bj0vtgdngc2dmtlcjknw";

    private String USUARIO = "udvxdvaerhvxgxu9";
    private String PASSWORD = "7Q6tNNTHkj8DtAsx2InP";

    //Metodo para conectar a la BBDD
    private Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, PASSWORD);
    }
    
    
    public void insertar(Ninja ninja) {
        String sql = "insert into ninja (nombre, rango_id, aldea) values (?,?,?)";
        try (
                Connection conexionInterna = conectar(); PreparedStatement solicitud = conexionInterna.prepareStatement(sql)) {
            //Asignar valores a las incognitas
            solicitud.setString(1, ninja.getNombre());
            solicitud.setInt(2, ninja.getRango_id());
            solicitud.setString(3, ninja.getAldea());
            //Ejecucion de la solicitud
            solicitud.executeUpdate();
            System.out.println("Ninja ingresado de manera exitosa");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    
    
    
    
    //Leer ninjas
    //
    public List<String> obtenerNinjas() {
        String sql = "select n.nombre as ninja, h.nombre as habilidad from ninja n join  habilidad h on n.id = h.ninja_id";
        List<String> listaNinjas = new ArrayList<>();
        try (
                Connection conexionInterna = conectar(); 
                PreparedStatement solicitud = conexionInterna.prepareStatement(sql);
                ResultSet resultado = solicitud.executeQuery();) {
            while (resultado.next()) {
                
                
                listaNinjas.add(resultado.getString("ninja") + " - " +
                        resultado.getString("habilidad"));
                
                
                
               
                
            }
        }catch(SQLException e){
            e.printStackTrace();
    }
        return listaNinjas;
    
    }
    
    
    
    
    
   /* 
    //listar misiones
     public List<String> obtenerMisiones() {
        String sql = "select m.descipcion as mision, n.nombre as ninja from mision m join misionNinja mn on m.id =  mn.mision_id join ninja n on n.id = mn.ninja_id where mn.ninja_id = ?";
        List<String> listaNinjas = new ArrayList<>();
        try (
                Connection conexionInterna = conectar(); 
                PreparedStatement solicitud = conexionInterna.prepareStatement(sql);
                ResultSet resultado = solicitud.executeQuery();) {
            while (resultado.next()) {
                
                
                listaNinjas.add(resultado.getString("mision") + " - " +
                        resultado.getString("ninja"));
                
                
                
               
                
            }
        }catch(SQLException e){
            e.printStackTrace();
    }
        return listaNinjas;
    
    }
    
    
    //Actualizar (update)
    public void actualizarNinja(int id, String nombre, int rango_id, String aldea){
        String sql = "update ninja set nombre= ?, rango_id=?, aldea=? where id=?";
        
        try(Connection conexionInterna = conectar();
                PreparedStatement solicitud = conexionInterna.prepareStatement(sql)){
            solicitud.setString(1, nombre);
            solicitud.setInt(2, rango_id);
            solicitud.setString(3, aldea);
            solicitud.setInt(4, id);
            
            int filas = solicitud.executeUpdate();
            if (filas > 0){
                System.out.println("Ninja actualizado exitosamente");
            }else{
                System.out.println("No se pudo actualizar el Ninja con el id " + id);
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }*/
    
    
}
