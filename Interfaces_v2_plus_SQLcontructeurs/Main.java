/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.delgadopereira.projetjavaswing;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;
import javax.swing.JFrame;
import java.sql.*;

/**
 *
 * @author Delgado Pereira
 */
public class Main {
    
    public void chargerControleur(){
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            System.out.println("Registro exitoso");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    
    public static void main(String args[]) {
        
        Rectangle tailleFen = new Rectangle(800,600);
        Dimension defScreenSize = Toolkit.getDefaultToolkit().getScreenSize();   
        IHM_Main fenetrePrincipale = new IHM_Main();
        
        fenetrePrincipale.setBounds(tailleFen);
        fenetrePrincipale.setVisible(true);
        fenetrePrincipale.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetrePrincipale.
                setLocation((defScreenSize.width-tailleFen.x)/5,
                        (defScreenSize.height-tailleFen.y)/8);
        
        
        
        
        
    }
}

