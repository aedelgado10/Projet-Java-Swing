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
    private final ExecBD e;
    
    /**
     * 
     * @param idCollab
     * @param idSalle
     * @param e 
     */
    public Droit(int idCollab, int idSalle, ExecBD e){
        this.e = e;
        String query;
        query = "SELECT D.* FROM Collaborateur C, Salle S, Droits D, "
                + "AVOIR_DROITS_DANS_SALLE ADDS WHERE ADDS.idDroit = "
                + "D.idDroit AND ADDS.idCollab = C.idCollab AND ADDS.idSalle = "
                + "S.idSalle AND C.idCollab ='"+ idCollab +"' AND "
                + "S.idSalle ='" + idSalle + "'";
    }
    
    /**
     * 
     * @return 
     */
    public int getId() {
        return id;
    }

    /**
     * 
     * @param id 
     */
    private void setId(int id) {
        this.id = id;
    }

    /**
     * 
     * @return 
     */
    public String getDescription() {
        return description;
    }

    /**
     * 
     * @param description 
     */
    private void setDescription(String description) {
        this.description = description;
    }

    /**
     * 
     * @return 
     */
    public boolean isEcriture() {
        return ecriture;
    }

    /**
     * 
     * @param ecriture 
     */
    private void setEcriture(boolean ecriture) {
        this.ecriture = ecriture;
    }

    /**
     * 
     * @return 
     */
    public boolean isLecture() {
        return lecture;
    }

    /**
     * 
     * @param lecture 
     */
    private void setLecture(boolean lecture) {
        this.lecture = lecture;
    }

    /**
     * 
     * @return 
     */
    public boolean isChangerDescSalon() {
        return changerDescSalon;
    }

    /**
     * 
     * @param changerDescSalon 
     */
    private void setChangerDescSalon(boolean changerDescSalon) {
        this.changerDescSalon = changerDescSalon;
    }
   
    
}
