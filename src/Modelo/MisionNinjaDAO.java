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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
    
    
    public List<String> obtenerMisiones(){
        String sql = "select * from misionNinja";
        List<String> listaMisiones = new ArrayList<>();
        
        try (
                Connection conexionInterna = conectar(); 
                PreparedStatement solicitud = conexionInterna.prepareStatement(sql);
                ResultSet resultado = solicitud.executeQuery();) {
            while (resultado.next()) {
                listaMisiones.add(resultado.getInt("id") +
                        " - " + resultado.getDate("fechaInicio") + " - " + 
                        resultado.getDate("fechaFin") + " - " +
                        resultado.getInt("ninja_id") + " - " +
                        resultado.getInt("mision_id")
                );
            }
        }catch(SQLException e){
            e.printStackTrace();
    }
        return listaMisiones;
        
    }
    
    
    
    
    
    
    //Asignar Mision 
    public void insertarMision(MisionNinja misionNinja) {
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
    
    
    //Mostrar misiones por ID
    //
    public void buscarMisionId(int ninja_id){
        String sql = "select  n.id as id, m.descipcion as mision, n.nombre as ninja from mision m join misionNinja mn on m.id =  mn.mision_id join ninja n on n.id = mn.ninja_id where n.id = ?";
        
        
        try(Connection conexionInterna = conectar();
                PreparedStatement solicitud = conexionInterna.prepareStatement(sql)){
           
            solicitud.setInt(1, ninja_id);
            
            try(ResultSet resultado = solicitud.executeQuery()){
            if (resultado.next()){
                System.out.println(resultado.getInt("id") +
                        " - " + resultado.getString("mision") + " - " + 
                        resultado.getString("ninja"));
            }else{
                System.out.println("No se pudo encontro el usuario con el id " + ninja_id);
            }
        }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    //Buscar Mision finalizada
    public void buscarMisionIdFechaFin(int ninja_id){
        String sql = "select m.descipcion as mision, n.nombre as ninja,mn.fechaInicio as Fecha_Inicio, mn.fechaFin as Fecha_Fin_Mision from mision m join misionNinja mn on m.id =  mn.mision_id join ninja n on n.id = mn.ninja_id where  n.id = ? and mn.fechaFin is not null; ";
        
        
        try(Connection conexionInterna = conectar();
                PreparedStatement solicitud = conexionInterna.prepareStatement(sql)){
           
            solicitud.setInt(1, ninja_id);
            
            try(ResultSet resultado = solicitud.executeQuery()){
                
                boolean resultadosfecha = false;
                
            while (resultado.next()){
                resultadosfecha = true;
                System.out.println(resultado.getString("mision") + " - " + 
                        resultado.getString("ninja")+ " - " + "Fecha Inicio: " +
                        resultado.getDate("Fecha_Inicio")+ " - " + " Fecha Fin: " +
                   resultado.getDate("Fecha_Fin_Mision"));
            }if (!resultadosfecha){
                System.out.println("No se pudo encontro el usuario con el id " + ninja_id);
            }
        }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    
    
    //finalizar Mision ninja
    
    public void finMision(int id){
        String sql = "update misionNija set fechaFin = curdate() where id=?";
        
        try(Connection conexionInterna = conectar();
                PreparedStatement solicitud = conexionInterna.prepareStatement(sql)){
            
            solicitud.setInt(1, id);
            
            int filas = solicitud.executeUpdate();
            if (filas > 0){
                System.out.println("Usuario actualizado exitosamente");
            }else{
                System.out.println("No se pudo actualizar el usuario con el id " + id);
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    
}
