/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.delgadopereira.projetjavaswing;
import java.sql.*;
/**
 * Cette classe se connecte seulement
 * @author Elmoumin Keraghel
 */
public class ConnexionBD{
    
    private static final String HOST = "localhost";
    private static final String BASE = "messageriestri";
    private static final String USER = "stri";
    private static final String PASS = "messstri2016";
    
    private final String dsn = "jdbc:postgresql://"+ HOST + "/" + BASE;
    
    /**
     * 
     * @return 
     */
    public boolean chargerDriver(){
        try {
            Class.forName("org.postgresql.Driver").newInstance();
            return true;
        }catch (ClassNotFoundException 
                | InstantiationException 
                | IllegalAccessException e){
            System.out.println(e);
            return false;
       }
    }
    /**
     * 
     * @return 
     */
    public Connection connecter(){
        
        Connection con;
        
        try {
            con = DriverManager.getConnection(this.dsn,USER,PASS);
            System.out.println(this.dsn);
            return con;
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
        }
        
        return null;
    }
}