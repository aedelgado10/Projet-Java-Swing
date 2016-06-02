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
public class Etat {
    
    /**
     * 
     * @param idcollab
     * @param idsalle
     * @param e 
     */
    public void se_connecter(int idcollab,int idsalle,ExecBD e){
        if (this instanceof Enligne){
            String query = "INSERT INTO SE_CONNECTER (idcollab,idsalle) VALUES"+
                    "("+idcollab + "," + idsalle + ",'Online')";
            e.query(query);
        }
    }
    
    /**
     * 
     * @param idcollab
     * @param idsalle
     * @param e 
     */
    public void update(int idcollab,int idsalle,ExecBD e){
        
        String query;
        
        if (this instanceof Absent){
            query = "UPDATE SE_CONNECTER SET etat='Absent' WHERE (idcollab = " +
                    idcollab + " AND idsalle = "+ idsalle + ")";
            
        }
        else{
            query = "UPDATE SE_CONNECTER SET etat='Online' WHERE (idcollab = " +
                    idcollab + " AND idsalle = "+ idsalle + ")";
        }
        
        e.query(query);
    }
    
    /**
     * 
     * @param idcollab
     * @param idsalle
     * @param e 
     */
    public void disconnect(int idcollab, int idsalle, ExecBD e){
        String query;
        
        if(this instanceof Horsligne){
            query = "DELETE FROM SE_CONNECTER WHERE idcollab=" + idcollab +
                    " AND idsalle=" + idsalle;
            e.query(query);
        }
    }
}
