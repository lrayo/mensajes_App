/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mensajes_app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Luis Rayo
 */
public class MensajesDao {
    
    //Metodos Crear, leer, borrar y actualizar
    public static void crearMensajeDB(Mensajes mensaje) {
        //Crear conexion a base de datos
        Conexion db_connect = new Conexion();
        
        try (Connection conexion = db_connect.get_connection()) {
            
            PreparedStatement ps = null;
            try {
                String query = "INSERT INTO mensajes (mensaje, autor_mensaje) VALUES (?, ?)";
                ps = conexion.prepareStatement(query);
                ps.setString(1, mensaje.getMensaje());
                ps.setString(2, mensaje.getAutor_mensaje());
                ps.executeUpdate();
                System.out.println("Mensaje creado");
            } catch (Exception ex) {
                System.out.println(ex);
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
        
    }
    
    //______________________________________________________________
    
     public static void leerMensajeDB() {
        
        Conexion db_connect = new Conexion();
            
            PreparedStatement ps = null;
            ResultSet rs = null;
            
        
              try (Connection conexion = db_connect.get_connection()) {
                  String query = "SELECT * FROM mensajes";
                  ps = conexion.prepareStatement(query);
                  rs = ps.executeQuery();
                  
                  while (rs.next()) {                      
                      System.out.println("ID: " + rs.getInt("id_mensaje") + "\n" +
                              "Mensaje: " + rs.getString("mensaje") + "\n" +
                             "Autor : " + rs.getString("autor_mensaje") + "\n" +
                              "Fecha: " + rs.getString("fecha_mensaje")+"\n"  );
                  }
           
        }catch (Exception ex) {
                  System.out.println("No se pudieron traer los mensajes");
                  System.out.println(ex);
            }
    }
     
     //--------------------------------------------------------------------------------------------------------------
     
      public static void borrarMensajeDB(int id_mensaje) {
        
    }
      
       public static void actualizarMensajeDB(Mensajes mensaje) {
        
    }
    
}
