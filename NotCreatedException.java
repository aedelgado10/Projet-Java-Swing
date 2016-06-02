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
public class NotCreatedException extends Exception{
    
    String entite;
    
    public NotCreatedException(String entiteNonCree){
        this.entite = entiteNonCree;
    }
    
    /**
     * 
     * @return 
     */
    @Override
    public String toString(){
        return this.entite + " n'a pas été créé";
    }
}
