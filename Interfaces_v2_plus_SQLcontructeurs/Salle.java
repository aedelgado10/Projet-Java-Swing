/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.delgadopereira.projetjavaswing;

import java.util.ArrayList;

/**
 *
 * @author willem
 */
public class Salle {

    private int id;
    private String type;
    private String description;
    private String titre;
    private String dateCreation;
    private ArrayList<Message> m;
    private ArrayList<Collaborateur> c;
    
    public Salle(int idCollab){
        String query;
        query = "SELECT S.* FROM Collaborateur C, Salle S, "
                + "Administrateur A, Affecter Af WHERE S.idSalle = Af.idSalle "
                + "AND Af.idCollab = C.idCollab AND A.idAdmin = Af.idAdmin AND "
                + "C.idCollab ='"+ idCollab +"'";
         
        /*String query2;
        query2 = "SELECT descriptionDroit,ecriture,lecture,changerDescSalon FROM"
                + "Droits, Collaborateur, AVOIR_DROITS_DANS_SALLE ADDS WHERE"
                + " ADDS.idCollab = Collaborateur.idCollab AND "
                + "ADDS.idDroit = Droits.idDroit";*/
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(String dateCreation) {
        this.dateCreation = dateCreation;
    }
  
    
    
}
