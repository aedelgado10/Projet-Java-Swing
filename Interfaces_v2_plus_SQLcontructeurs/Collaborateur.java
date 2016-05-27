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
public class Collaborateur {

    private int id;
    private String nom;
    private String prenom;
    private String pseudo;
    private String mail;
    private String mdp;
    private ArrayList<Droit> d;
    
    public Collaborateur(String pseudo,String mdp){
        String query;
        query = "SELECT idCollab,nomCollab,prenomCollab,mailCollab FROM "
                + "Collaborateur WHERE pseudoColl"
                + "ab='" + pseudo + "' AND mdpCollab='" + mdp + "'";
    }
    
    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    private void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    private void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getPseudo() {
        return pseudo;
    }

    private void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getMail() {
        return mail;
    }

    private void setMail(String mail) {
        this.mail = mail;
    }
    
    public String getMdp() {
        return mdp;
    }

    private void setMdp(String mdp) {
        this.mail = mdp;
    }

   
    
    
}
