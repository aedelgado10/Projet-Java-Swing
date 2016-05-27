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
public class Message {

    private int id;
    private String contenu;
    private String dateEnvoi;
    private String heureEnvoi;
    private boolean afficheDansSalon;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public String getDateEnvoi() {
        return dateEnvoi;
    }

    public void setDateEnvoi(String dateEnvoi) {
        this.dateEnvoi = dateEnvoi;
    }

    public String getHeureEnvoi() {
        return heureEnvoi;
    }

    public void setHeureEnvoi(String heureEnvoi) {
        this.heureEnvoi = heureEnvoi;
    }

    public boolean isAfficheDansSalon() {
        return afficheDansSalon;
    }

    public void setAfficheDansSalon(boolean afficheDansSalon) {
        this.afficheDansSalon = afficheDansSalon;
    }
   
    
    
}
