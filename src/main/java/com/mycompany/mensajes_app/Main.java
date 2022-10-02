/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mensajes_app;

import java.sql.Connection;
import java.util.Scanner;

/**
 *
 * @author Luis Rayo
 */
public class Main {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int opcion = 0;
        
        do {            
            
            System.out.println("-----------------------");
             System.out.println("Aplicacion de mensaje \n" + 
                    "1. Crear mensajes\n" +
                    "2. Listar mensajes\n"+
                    "3. Editar mensajes\n" +
                   "4. Eliminar mensaje\n" +
                    "5. Salir");
             //Leemos la opcion del usuario
             opcion = sc.nextInt();
             
             switch (opcion) {
                case 1:
                        MensajesService.CrearMensaje();
                    break;
                case 2:
                        MensajesService.listarMensaje();
                    break;
                case 3:
                        MensajesService.editarMensaje();
                    break;
                case 4:
                        MensajesService.borrarMensaje();
                    break;
                
                default:
                    throw new AssertionError();
            }
            
        } while (opcion != 5);
        
        
    }
    
}
