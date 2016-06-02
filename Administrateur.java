/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.delgadopereira.projetjavaswing;

/**
 *
 * @author willem
 * @author Delgado
 */
public class Administrateur extends Collaborateur {
    
    private int idAdmin;
    
    /**
     * 
     * @param idcollab
     * @param idadmin
     * @param pseudo
     * @param e
     * @throws NotCreatedException 
     */
    public Administrateur(int idcollab,int idadmin,String pseudo,ExecBD e) 
            throws NotCreatedException{
        super(idcollab,pseudo,e);
        this.idAdmin = idadmin;
    } 
    
    /**
     * 
     * @return idAmin
     */
    public int getIdAdmin() {
        return idAdmin;
    }

    /**
     * 
     * @param idAdmin 
     */
    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }
    
    /**
     * 
     * @param e
     * @return -1 = erreur | int
     */
    public int getNbrSallesCrees(ExecBD e){
      
        
        String query = "SELECT COUNT(idsalle) as sallescreees FROM CREER" 
        + " WHERE idadmin=" + this.idAdmin;
        e.query(query);
        
        System.out.println(query);
        
        if (e.hasNext()){
            return e.ifetch("sallescreees");
        }else{
            return 0;
        }
    }
    
    // cette fonction s'utilise avec fetch_salles du Super : Collaborateur
    /**
     * 
     * @return 
     */
    public String getSallesCrees(){
        String query = "SELECT idsalle FROM CREER WHERE idadmin=" + this.idAdmin;
        return query;
    }
    
    /**
     * 
     * @param s
     * @param e 
     */
    public void creerSalle(Salle s, ExecBD e){
        String query = "INSERT INTO Salle VALUES("+ s.getId() +",'" + s.getType() 
                + "','" + s.getDescription() + "','"
                + s.getTitre() + "','" + s.getDateCreation() + "')"; 
        
        e.query(query);
    }
    
    
}
