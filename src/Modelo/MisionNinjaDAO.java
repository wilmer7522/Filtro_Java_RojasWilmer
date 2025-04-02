/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 *
 * @author wilmer
 */
public class MisionNinjaDAO {
    
    private String URL = "jdbc:mysql://bj0vtgdngc2dmtlcjknw-mysql.services.clever-cloud.com:3306/bj0vtgdngc2dmtlcjknw";

    private String USUARIO = "udvxdvaerhvxgxu9";
    private String PASSWORD = "7Q6tNNTHkj8DtAsx2InP";

    //Metodo para conectar a la BBDD
    private Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, PASSWORD);
    }
    
    
    
    
    
    
    
    //Asignar Mision 
    public void insertar(MisionNinja misionNinja) {
        String sql = "insert into misionNinja (fechaInicio, ninja_id, mision_id) values (?,?,?)";
        try (
                Connection conexionInterna = conectar(); PreparedStatement solicitud = conexionInterna.prepareStatement(sql)) {
            //Asignar valores a las incognitas
            solicitud.setDate(1, java.sql.Date.valueOf(misionNinja.getFechaInicio()));
            solicitud.setInt(2, misionNinja.getNinja_id());
            solicitud.setInt(3, misionNinja.getMision_id());
            //Ejecucion de la solicitud
            solicitud.executeUpdate();
            System.out.println("Ninja ingresado de manera exitosa");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
