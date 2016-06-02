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
    private String afficheDansSalon;
    private final ExecBD e;
    private String expediteur;
    
    public Message(int idMessage, ExecBD e) throws NotCreatedException{
        
        this.e = e;
        String query = 
                "SELECT DISTINCT M.*,C.pseudocollab,nomcollab,prenomcollab "
                + "FROM MESSAGE M,COLLABORATEUR C, ENVOYER E WHERE M.idmessage = "+ idMessage+ " "
                + "AND E.idcollab = C.idcollab AND E.idmessage = " + idMessage;
        
        
        e.query(query);
        
            if (e.hasNext()){
                
                this.expediteur = e.sfetch("pseudocollab")+
                    " ("+ e.sfetch("nomcollab") 
                    + e.sfetch("prenomcollab") + ")";
                    
                this.contenu = e.sfetch("contenu");
                this.dateEnvoi = e.sfetch("dateenvoi");
                this.heureEnvoi = e.sfetch("heureEnvoi");
                this.afficheDansSalon = e.sfetch("affichedanssalon");
            }
            else{
                throw new NotCreatedException("Message");
            }
            
        
    }
    
    /**
     * Inserer un message dans la base de données (ne pas oublier d'incrementer
     * l'arraylist de Salle)
     * @param contenu
     * @param dateEnvoi
     * @param heureEnvoi
     * @param afficheDansSalon
     * @param idSalon
     * @param idCollab
     * @param e 
     */
    public static void envoyerMessage(String contenu, String dateEnvoi, String heureEnvoi,
            String afficheDansSalon, int idSalon, int idCollab ,ExecBD e){
        
        try{
            
            Salle sx = new Salle(idSalon, e);
            
            sx.clear();
            int id = sx.getLastMessage(idSalon);
            id++;
            String query;

            query = "INSERT INTO MESSAGE VALUES("+ id + ",'" + contenu
                    + "','" + dateEnvoi + "','" + heureEnvoi +"','" + afficheDansSalon + "');";
            System.out.print(query);
            e.query(query);

            String query2;
            query2 = "INSERT INTO ENVOYER VALUES("+ idCollab + "," + id + "," + idSalon +");";
            System.out.print(query);
            e.query(query2);
        }catch (NotCreatedException nce){
            System.out.println(nce);
        }
    }
    
    public void effacerAll(int idMessage,ExecBD e){
        String query_tableM = "DELETE FROM MESSAGE M,ENVOYER E WHERE M.idmessage="
                + idMessage + " AND E.idmessage =" + idMessage;
       
        e.query(query_tableM);
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
    public String getContenu() {
        return contenu;
    }

    /**
     * 
     * @param contenu 
     */
    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    /**
     * 
     * @return 
     */
    public String getDateEnvoi() {
        return dateEnvoi;
    }

    /**
     * 
     * @param dateEnvoi 
     */
    public void setDateEnvoi(String dateEnvoi) {
        this.dateEnvoi = dateEnvoi;
    }

    /**
     * 
     * @return 
     */
    public String getHeureEnvoi() {
        return heureEnvoi;
    }

    /**
     * 
     * @param heureEnvoi 
     */
    public void setHeureEnvoi(String heureEnvoi) {
        this.heureEnvoi = heureEnvoi;
    }

    /**
     * 
     * @return 
     */
    public String isAfficheDansSalon() {
        return afficheDansSalon;
    }

    /**
     * 
     * @param afficheDansSalon 
     */
    public void setAfficheDansSalon(String afficheDansSalon) {
        this.afficheDansSalon = afficheDansSalon;
    }
    
    /**
     * 
     * @return 
     */
    public String getExpediteur(){
        return this.expediteur;
    }
    
}
