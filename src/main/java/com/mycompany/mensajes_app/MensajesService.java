/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mensajes_app;

import java.util.Scanner;

/**
 *
 * @author Luis Rayo
 */
public class MensajesService {
    
    //------------------------------CREER-------------------------------------
    
     public static void CrearMensaje() {
         Scanner sc = new Scanner(System.in);
         
         System.out.println("Escribe tu mensaje");
         String mensaje = sc.nextLine();
         
         System.out.println("Tu nombre");
         String nombre = sc.nextLine();
         
         Mensajes registro = new Mensajes();
         registro.setMensaje(mensaje);
         registro.setAutor_mensaje(nombre);
         
         //Aca se envia a dao
         MensajesDao.crearMensajeDB(registro );
    }
     
   //-----------------------------------LEER------------------------------------------------------- 
      
       public static void listarMensaje() {
           
            //llamar metodo leermensajesdb
            MensajesDao.leerMensajeDB();
    }
       
       //----------------------------------------BORRAR---------------------------------------------------
       
        public static void borrarMensaje() {
             Scanner sc = new Scanner(System.in);
         
            System.out.println("Indica el id del mensaje a borrar");
            int id_mensaje = sc.nextInt();
            
            MensajesDao.borrarMensajeDB(id_mensaje);
    }
        
        
        //-----------------------------------MODIFICAR--------------------------------------------------------
         public static void editarMensaje() {
         Scanner sc = new Scanner(System.in);
         
            System.out.println("Escribe tu nuevo mensaje");
            String mensaje = sc.nextLine();
            
            System.out.println("Indica el Id del mensaje a editar");
            int id_mensaje = sc.nextInt();
            
            Mensajes actualizacion = new Mensajes();
            actualizacion.setId_mensaje(id_mensaje);
            actualizacion.setMensaje(mensaje);
            
            MensajesDao.actualizarMensajeDB(actualizacion);
             
             
    }
        
    
}
