/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.delgadopereira.projetjavaswing;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Delgado Pereira
 * @author Elmoumin Keraghel
 */
public class ExecBD {
    
    private final ConnexionBD connexion;
    private ResultSet resReq;
    
    private Connection c;
    
    /**
     * 
     * @throws BDDNotConnectedException 
     */
    public ExecBD() throws BDDNotConnectedException{
        connexion = new ConnexionBD();
        
        if (connexion.chargerDriver()){
            this.c = connexion.connecter();
        }
        else{
            throw new BDDNotConnectedException();
        }
        
        this.resReq = null;
    }
    
/**
 * 
 * @param q 
 */
    public void query(String q){
        
        try{
            Statement s = c.createStatement();
            this.resReq = s.executeQuery(q);
        }
        catch(SQLException ex){
            System.out.println(ex);
        }
    }
    
    /**
     * 
     * @param cName
     * @return String | null si il n'y plus rien
     */
    public String sfetch(String cName){
        
        if ((this.resReq == null) || (cName.equals(""))){
            return null;
        }
        
        try{
                return resReq.getString(cName);
        }catch (SQLException ex){
            System.out.println(ex);
        }
        
        return null;
    }
    
    /**
     * récupère une valeur entière de la base de données
     * @param cName
     * @return 
     */
    public Integer ifetch(String cName){
        
        if ((this.resReq == null) || (cName.equals(""))){
            return null;
        }
        
        try{
                return resReq.getInt(cName);
        }catch (SQLException ex){
            System.out.println(ex);
        }
        
        return null;
    }
    
    /**
     * 
     * @return true s'il y a encore une ligne résultat à lire
     */
    public boolean hasNext(){
        try{
            return resReq.next();        
        }catch(SQLException e){
            System.out.println(e);
        }

        return false;
    }
    
}
