/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.cafe;

import cafe.Dashboard;
import com.formdev.flatlaf.FlatLightLaf;

/**
 *
 * @author jonathan
 */
public class Cafe {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FlatLightLaf.setup();
        new Dashboard().setVisible(true);
    }
    
}
