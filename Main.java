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

/**
 *
 * @author Delgado Pereira
 */
public class Main {
   
    /**
     * 
     * @param service
     * @param e
     * @return 
     */
    private static IHM_Main initMain(boolean service,ExecBD e){
        
        Rectangle tailleFen = new Rectangle(800,600);
        Dimension defScreenSize = Toolkit.getDefaultToolkit().getScreenSize();   
        IHM_Main fenetrePrincipale = new IHM_Main(service,e);
        
        fenetrePrincipale.setBounds(tailleFen);
        fenetrePrincipale.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetrePrincipale.
                setLocation((defScreenSize.width-tailleFen.x)/5,
                        (defScreenSize.height-tailleFen.y)/8);
        
        return fenetrePrincipale;
    }

    /**
     * 
     * @param args 
     */
    public static void main(String args[]) {
       
        ExecBD execReq;
        boolean etatService;
        IHM_Main f;
       
        try {
            
            execReq = new ExecBD(); // Création de la connexion vers la base
            etatService = true;     // Connexion OK = poursuite
            f = initMain(etatService,execReq); 
                                    //la fenetre principale peut se connecter
            
        }catch(BDDNotConnectedException ex){
            
            System.out.println(ex);
            etatService = false;
            f = initMain(etatService,null);
        }

        f.setVisible(true);
    }
    
    /**
     * transforme un mdp en char[] vers un String
     * @param c
     * @return 
     */
    public static String charToString(char[] c){
        String s = new String();
        
        for(int i=0;i<c.length;i++){
            s += c[i];
        }
        
        return s;
    }
}

