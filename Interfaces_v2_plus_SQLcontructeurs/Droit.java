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
public class Droit {

    private int id;
    private String description;
    private boolean ecriture;
    private boolean lecture;
    private boolean changerDescSalon;
    
    public Droit(int idCollab, int idSalle){
        String query;
        query = "SELECT D.* FROM Collaborateur C, Salle S, Droits D, "
                + "AVOIR_DROITS_DANS_SALLE ADDS WHERE ADDS.idDroit = "
                + "D.idDroit AND ADDS.idCollab = C.idCollab AND ADDS.idSalle = "
                + "S.idSalle AND C.idCollab ='"+ idCollab +"' AND "
                + "S.idSalle ='" + idSalle + "'";
    }
    
    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    private void setDescription(String description) {
        this.description = description;
    }

    public boolean isEcriture() {
        return ecriture;
    }

    private void setEcriture(boolean ecriture) {
        this.ecriture = ecriture;
    }

    public boolean isLecture() {
        return lecture;
    }

    private void setLecture(boolean lecture) {
        this.lecture = lecture;
    }

    public boolean isChangerDescSalon() {
        return changerDescSalon;
    }

    private void setChangerDescSalon(boolean changerDescSalon) {
        this.changerDescSalon = changerDescSalon;
    }
   
    
}
