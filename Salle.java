/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.delgadopereira.projetjavaswing;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * /*query = "SELECT S.* FROM Collaborateur C, Salle S, "
                + "Administrateur A, Affecter Af WHERE S.idSalle = Af.idSalle "
                + "AND Af.idCollab = C.idCollab AND A.idAdmin = Af.idAdmin AND "
                + "C.idCollab ='"+ idCollab +"'";
 *
 * @author willem
 */
public class Salle {

    private int id;
    private String type;
    private String description;
    private String titre;
    private String dateCreation;
    private final ArrayList<Message> m;
    private final ExecBD e;
    
    /**
     * 
     * @param idSalle
     * @param e
     * @throws NotCreatedException 
     */
    public Salle(int idSalle,ExecBD e) throws NotCreatedException{
        this.e = e;
        String query;
        
        query = "SELECT DISTINCT S.* FROM SALLE S WHERE idsalle = "+ idSalle;
        e.query(query);
        
        if (e.hasNext()){
            this.id = idSalle;
            this.dateCreation = e.sfetch("datecreasalle");
            this.description = e.sfetch("descrsalle");
            this.titre = e.sfetch("titresalle");
        }
        else{
            throw new NotCreatedException("Salle");
        }
        
        this.m = new ArrayList<>();
    }
    
    /**
     * 
     * @param idsalle
     * @param idcollab
     * @return 
     */
    public ArrayList<Message> getMessages(int idsalle,int idcollab){
        Message courant;
        
        String query = "SELECT DISTINCT M.* FROM ENVOYER E, MESSAGE M, SALLE S"
                + " WHERE S.idsalle = "
                + idsalle + " AND E.idcollab = "
                + idcollab + " ORDER BY idmessage ASC";
        
        System.out.println(query);
        e.query(query);
        ArrayList<Integer> idmlist = new ArrayList<>();
        
        while (e.hasNext()){
            int idmessage = e.ifetch("idmessage");
            idmlist.add(idmessage);
        }

        for(int i=0;i<idmlist.size();i++){
            try {
                courant = new Message(idmlist.get(i),e);
                this.addMessageToHistorique(courant);
            } catch (NotCreatedException ex) {
                Logger.getLogger(Salle.class.getName()).log(Level.SEVERE, null, ex);
            }
                
        }  
        
        return this.m;
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
    public void setId(int id) {
        this.id = id;
    }
    /**
     * 
     * @return 
     */
    public String getType() {
        return type;
    }
    /**
     * 
     * @param type 
     */
    public void setType(String type) {
        this.type = type;
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
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 
     * @return 
     */
    public String getTitre() {
        return titre;
    }

    /**
     * 
     * @param titre 
     */
    public void setTitre(String titre) {
        this.titre = titre;
    }

    /**
     * 
     * @return 
     */
    public String getDateCreation() {
        return dateCreation;
    }

    /**
     * 
     * @param dateCreation 
     */
    public void setDateCreation(String dateCreation) {
        this.dateCreation = dateCreation;
    }
    
    /**
     * 
     * @return 
     */
    public int getNbrCollab(){
        int nbcollab;
        String query = "SELECT COUNT(idcollab) AS nbcollab FROM COLLABORATEUR";
        e.query(query);
        
        if (e.hasNext()){
            nbcollab= e.ifetch("nbcollab");
        }else{
            return -1;
        }
        return nbcollab;
    }
    
    /**
     * Après ajout du Message à la base de données (dans la classe message), 
     * incrémentation de cette Arraylist
     * @param m 
     */
    public void addMessageToHistorique(Message m){
        this.m.add(m);
    }
    
    /**
     * récuperation des collaborateurs dans la salle
     * @return 
     */
    public ArrayList<Collaborateur> collaborateursDansSalle(){
        String query = "SELECT DISTINCT C.idCollab,C.pseudocollab "
                + "FROM affecter A,Collaborateur C "
                + "WHERE A.idSalle =" + this.id ;
        
        ArrayList<Collaborateur> a = new ArrayList<>();
        ArrayList<Integer> ids = new ArrayList<>();
        ArrayList<String> pseudos = new ArrayList<>();
        
        Collaborateur c;
        
        e.query(query);
        
        while (e.hasNext()){
            Integer idc = e.ifetch("idCollab");
            String pseudo = e.sfetch("pseudocollab");
            ids.add(idc);
            pseudos.add(pseudo);
        }
        
        try{
            for (int i=0;i<ids.size();i++){
                c = new Collaborateur(ids.get(i), pseudos.get(i), e);
                a.add(c);
            }
        }catch (NotCreatedException nce){
            System.out.print(nce);
        }
        return a;
    }
    
    /**
     * 
     * @param idsalle
     * @return 
     */
    public int getLastMessage(int idsalle){
        String query = "SELECT DISTINCT M.idmessage FROM MESSAGE M, SALLE S "
                + "WHERE S.idsalle = "+ idsalle + " ORDER BY idmessage DESC";
        System.out.println(query);
        e.query(query);
        
        if (e.hasNext()){
            return e.ifetch("idmessage");
        }else{
            return 0;
        }
    }
    
    /**
     * 
     * @return 
     */
    @Override
    public String toString(){
        
        try{
            
            Message n = new Message(this.getLastMessage(this.getId()), e);
            
            return this.getTitre()+ " \"" + this.description + "\" "
                + "Dernier message le "+ n.getDateEnvoi() 
                    + " à "+ n.getHeureEnvoi();
            
        }catch(NotCreatedException nce){
            return nce.toString();
        }
    }
    
    /**
     * clear de l'arraylist m (historique)
     */
    public void clear(){
        m.clear();
    }
    
}
