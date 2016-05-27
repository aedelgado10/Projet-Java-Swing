/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.delgadopereira.projetjavaswing;

/**
 *
 * @author willem
 */
public class Administrateur extends Collaborateur {
    
    private int idAdmin;
    
    public Administrateur(String pseudo, String mdp){
        super(pseudo,mdp);
        String query;
        query = "SELECT Administrateur.idAdmin FROM Administrateur ,"
                + "Collaborateur, ETRE WHERE ETRE.idCollab = Collaborateur.idCollab"
                + " AND ETRE.idAdmin = Administrateur.idAdmin AND"
                + " Collaborateur.pseudoCollab='"+ pseudo +"'";
    } 
    
    public int getIdAdmin() {
        return idAdmin;
    }

    private void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }
    
    
}
