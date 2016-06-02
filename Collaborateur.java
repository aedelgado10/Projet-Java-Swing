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
public class Collaborateur{

    private int id;
    private String nom;
    private String prenom;
    private String pseudo;
    private String mail;
    private ArrayList<Droit> d;
    public Etat etat; 
    private final ExecBD e;
    
    /**
     * 
     * @param idcollab
     * @param pseudo
     * @param e
     * @throws NotCreatedException 
     */
    public Collaborateur(int idcollab,String pseudo,ExecBD e) 
            throws NotCreatedException{
        this.e = e;
        this.pseudo = pseudo;
        this.id = idcollab;
        
        this.etat = new Enligne();
        String query;
        query = "SELECT nomcollab,prenomcollab,mailcollab FROM "
                + "Collaborateur WHERE idcollab = "+ idcollab;
        
        e.query(query);
        
        if (e.hasNext()){
            this.prenom = e.sfetch("prenomcollab");
            this.mail = e.sfetch("mailcollab");
            this.nom = e.sfetch("nomcollab");
        }
        else{
            throw new NotCreatedException("Collaborateur");
        }
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
    public String getNom() {
        return nom;
    }

    /**
     * 
     * @param nom 
     */
    private void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * 
     * @return 
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * 
     * @param prenom 
     */
    private void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * 
     * @return 
     */
    public String getPseudo() {
        return pseudo;
    }

    /**
     * 
     * @param pseudo 
     */
    private void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    /**
     * 
     * @return 
     */
    public String getMail() {
        return mail;
    }

    /**
     * 
     * @param mail 
     */
    private void setMail(String mail) {
        this.mail = mail;
    }

    /**
     * 
     * @return 
     */
    public Etat getEtat() {
        return etat;
    }

    /**
     * 
     * @param etat 
     */
    public void setEtat(Etat etat) {
        this.etat = etat;
    }
    
    /**
     * 
     * @return 
     */
    public String getSallesDuCollab(){
        String query = "SELECT idsalle FROM AVOIR_DROITS_DANS_SALLE WHERE"
                + " idcollab =" + this.getId();
        return query;
    }
    
    /**
     * 
     * @return 
     */
    public String getSallesDuCollabPublic(){
        String query = "SELECT S.idsalle,S.type FROM SALLE S, AVOIR_DROITS_DANS_SALLE A" 
                + " WHERE S.idsalle = A.idsalle AND A.idcollab = "+ this.getId() 
                + " AND type = 'Public'";
        return query;
    } 
    
    /**
     * 
     * @return 
     */
    public String getSallesDuCollabPrivate(){
        String query = "SELECT S.idsalle, S.type FROM SALLE S, AVOIR_DROITS_DANS_SALLE A" 
                + " WHERE S.idsalle = A.idsalle AND A.idcollab = "+ this.getId() 
                + " AND S.type = 'Private'";
        return query;
    } 
    
    /**
     * Récupère la liste des salles d'un utilisateur pour une table
     * @param query
     * @return idsalle 
     */
    public ArrayList<Integer> fetch_salle(String query){
        
        ArrayList<Integer> a = new ArrayList<>();
        
        e.query(query);
        
        System.out.println(query);
        while (e.hasNext()){
            Integer ids = e.ifetch("idsalle");
            System.out.println("idsalle:" + ids);
            a.add(ids); 
        }
        
        if (a.isEmpty())
            return null;
        return a;
    }
    
    /**
     * se connecter à une salle
     * @param idsalle 
     */
    public void se_connecter(int idsalle){
        etat = new Enligne();
        this.etat.update(this.id, idsalle, e);
    }
    
    /**
     * 
     * @param et
     * @param idsalle 
     */
    public void changer_statut(Etat et,int idsalle){
        this.etat = et;
        this.etat.update(this.id, idsalle, e);
    }
    
    /**
     * quitter une salle
     * @param idsalle 
     */
    public void se_deconnecter(int idsalle){
        this.etat.disconnect(this.id, idsalle, e);
    }
      
    
    /**
     * 
     * @return
     * @throws NotCreatedException 
     */
    public ArrayList<Collaborateur> getPeople() throws NotCreatedException{
        
        
        ArrayList<Collaborateur> c_List = new ArrayList<>();
        String query = "SELECT idcollab,pseudocollab FROM COLLABORATEUR "
                + "EXCEPT "
                + "SELECT idcollab,pseudocollab FROM COLLABORATEUR "
                + "WHERE idcollab =" + this.getId();
        
        e.query(query);
        Collaborateur c;
        int idC;
        String pseudoC;
        ArrayList<Integer> ids = new ArrayList<>();
        ArrayList<String> pseudos = new ArrayList<>();
        
        while (e.hasNext()){
            idC = e.ifetch("idcollab");
            pseudoC = e.sfetch("pseudocollab");
            ids.add(idC);
            pseudos.add(pseudoC);
        }
        
        for (int i=0;i<ids.size();i++){
            c = new Collaborateur(ids.get(i),pseudos.get(i),e);
            c.setEtat(new Horsligne());
            c_List.add(c);
        }
        
        return c_List;
    }
    
    /**
     * 
     * @return 
     */
    @Override
    public String toString(){
        
        return this.getPseudo() + " ("+ this.getPrenom() + " "+ this.getNom() 
                + ")";
    }
    
    public void supprimer(int idCollab){
        
        String query = "DELETE FROM COLLABORATEUR WHERE idcollab = " + idCollab;
        System.out.println(query);
        e.query(query);
    }
}
