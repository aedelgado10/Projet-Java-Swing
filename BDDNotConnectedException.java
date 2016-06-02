/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.delgadopereira.projetjavaswing;

/**
 *
 * @author Delgado Pereira
 */
public class BDDNotConnectedException extends Exception{
    
    /**
     * constructeur
     */
    public BDDNotConnectedException(){
        super();
    }
    
    /**
     * 
     * @return 
     */
    public String ToString(){
        return "Impossible de charger le pilote de "
                + "connexion ou de se connecter à la base";
    }
}
