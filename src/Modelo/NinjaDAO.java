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
    
    
    
    
    
  
    
}
