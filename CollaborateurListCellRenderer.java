/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.delgadopereira.projetjavaswing;

import java.awt.Component;/*
import java.awt.Font;
import java.awt.Image;*/
import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;

/**
 *
 * @author willem
 * @completed by Andrés
 */
public class CollaborateurListCellRenderer extends DefaultTreeCellRenderer{
    private final ImageIcon online = new ImageIcon("imgs/connected_icon.png");
    private final ImageIcon offline = new ImageIcon("imgs/deconnecte.png");
    private final ImageIcon away = new ImageIcon("imgs/absent.png");
    private final ImageIcon open = new ImageIcon("imgs/maletin.png");
    
    public CollaborateurListCellRenderer(){
        super();
    }
    
    /**
     * 
     * @param tree
     * @param value
     * @param sel
     * @param expanded
     * @param leaf
     * @param row
     * @param hasFocus
     * @return 
     */
    @Override
    public Component getTreeCellRendererComponent( JTree tree,Object value,boolean sel,boolean expanded,boolean leaf,int row,boolean hasFocus){
        
        /*if(value instanceof Collaborateur){
           Collaborateur c = (Collaborateur)value; 
           if( c.etat instanceof Enligne ){
               Image online_i = online.getImage().getScaledInstance(30,-1,Image.SCALE_DEFAULT);
               setIcon(new ImageIcon(online_i));
           }
           else if (c.etat instanceof Absent){
               Image away_i = online.getImage().getScaledInstance(30,-1,Image.SCALE_DEFAULT);
               setIcon(new ImageIcon(away_i));
               setFont(new Font(Font.SANS_SERIF,Font.BOLD,14));
           }
           else{
               Image offline_i = offline.getImage().getScaledInstance(30,-1,Image.SCALE_DEFAULT);
               setIcon(new ImageIcon(offline_i));
               setIcon(offline);        
           }
       }
        else{
            setIcon(open);
        }
        */
        return this;
    }

    
    
    
    
}
