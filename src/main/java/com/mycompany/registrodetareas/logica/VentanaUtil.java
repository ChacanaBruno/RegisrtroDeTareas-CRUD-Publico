/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.registrodetareas.logica;

import java.awt.Window;
import com.mycompany.registrodetareas.igu.Principal;

public class VentanaUtil {

    public static void mostrarMenuPrincipal(Window ventanaActual) {
        ventanaActual.dispose();
        
        // Busca y muestra la instancia existente de Principal si está abierta
        for (Window window : Window.getWindows()) {
            if (window instanceof Principal) {
                window.setVisible(true);
                return;
            }
        }
        
        // Si no se encontró una instancia abierta, crea una nueva
        Principal principal = new Principal();
        principal.setVisible(true);
        principal.setLocationRelativeTo(null);
    }
}

