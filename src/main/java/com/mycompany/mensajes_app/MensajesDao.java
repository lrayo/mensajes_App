/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mensajes_app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Luis Rayo
 */
public class MensajesDao {
    
    //Metodos Crear, leer, borrar y actualizar
    
    //----------------------------CREAR-------------------------------------
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
    
    //__________________________LEER___________________________________
    
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
     
     //----------------------------------------------BORRAR----------------------------------------------------------------
     
      public static void borrarMensajeDB(int id_mensaje) {
          
           Conexion db_connect = new Conexion();
          
           try (Connection conexion = db_connect.get_connection()) {
                   PreparedStatement ps = null;
                   
                   try {
                       String query = "DELETE FROM mensajes WHERE id_mensaje = ?";
                       ps = conexion.prepareStatement(query);
                       ps.setInt(1, id_mensaje);
                       ps.executeUpdate();
                       System.out.println("El mensaje ha sido borrado");
                            
               } catch (SQLException e) {
                       System.out.println("No se pudo borrar el mensaje");
                       System.out.println(e);
               }
                          
        }catch (Exception ex) {
                  
                  System.out.println(ex);
            }
    }
      
      
      //-----------------------------------------MODIFICAR--------------------------------------------------------------------
       public static void actualizarMensajeDB(Mensajes mensaje) {
        
            Conexion db_connect = new Conexion();
           
             try (Connection conexion = db_connect.get_connection()) {
                   PreparedStatement ps = null;
                   
                   try {
                       String query = "UPDATE mensajes SET mensaje = ? WHERE id_mensaje = ?";
                       ps = conexion.prepareStatement(query);
                       ps.setString(1, mensaje.getMensaje());
                       ps.setInt(2, mensaje.getId_mensaje());
                       ps.executeUpdate();
                       System.out.println("Se ha actualizado correctamente");
                            
               } catch (SQLException e) {
                       System.out.println("No se pudo actualizar el mensaje");
                       System.out.println(e);
               }
                          
        }catch (Exception ex) {
                  
                  System.out.println(ex);
            }
           
           
           
           
           
    }
    
}
