/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.delgadopereira.projetjavaswing;

import java.util.ArrayList;

/**
 *
 * @author Delgado Pereira
 */
public class IHM {
    
    /**
     * 
     * @param userType
     * @param pseudo
     * @param mdp
     * @param e
     * @param iMain 
     */
    public static void charger(int[] userType,
            String pseudo,String mdp,ExecBD e,IHM_Main iMain){
        
        switch(userType[0]){
            case 1:
                try{
                    Administrateur a = new Administrateur(userType[1],userType[2],pseudo, e);
                    IHM_Admin iAdmin = new IHM_Admin(iMain,a,e);
                    iMain.setVisible(false);
                    iAdmin.setVisible(true);
                    iAdmin.controler();
                }catch (NotCreatedException nce){
                    System.out.println(nce);
                }
                break;
             default:
                //will : client
                try{
                    Collaborateur c = new Collaborateur(userType[1],pseudo, e);
                    IHM_Client iClient = new IHM_Client(iMain,c,e);
                    iMain.setVisible(false);
                    iClient.setVisible(true);
                    iClient.controler();  
                }catch (NotCreatedException nce){
                    System.out.println(nce);
                }
                
                
                
                break;
       }
        
    }
    
}
