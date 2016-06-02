/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.delgadopereira.projetjavaswing;

import java.util.ArrayList;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

/**
 *
 * @author Delgado Pereira
 */
public class AffichageSallesModele implements TreeModel{

    ArrayList<Object> o = new ArrayList<>();
    int nprivees;
    int npubliques;
    
    ArrayList<Salle> privees,publiques;
    /**
     * 
     * @param prives
     * @param publiques 
     */
    public AffichageSallesModele(ArrayList<Salle> prives,ArrayList<Salle> publiques){
        String s = "Chats privées";
        this.publiques =  publiques;
        this.privees = prives;
        
        o.add(s);
        
        if (!privees.isEmpty()){
            o.addAll(privees);
            nprivees = privees.size();
        }
        else{
            nprivees = 0;
        }
        
        s = "Chats groupés";
        o.add(s);
        if (!this.publiques.isEmpty()){
            npubliques = this.publiques.size();
            o.addAll(publiques);
        }
        else{
            npubliques = 0;
        }
    }
    
    /**
     * 
     * @return 
     */
    @Override
    public Object getRoot() {
        return "Salles";
    }

    /**
     * 
     * @param salle
     * @param i
     * @return 
     */
    @Override
    public Object getChild(Object salle, int i) {
        
        if (salle instanceof String){
            return o.get(i);
        }
        else{
            return (Salle)o.get(i);
        }
    }

    /**
     * 
     * @param parent
     * @return 
     */
    @Override
    public int getChildCount(Object parent) {
        String sous_titre;
        if (parent instanceof String){
            sous_titre = (String) parent;
            if (sous_titre.equals("Chats privées")){
                return nprivees;
            }
            else if (sous_titre.equals("Chats groupés")){
                return npubliques;
            }
            else{
                return o.size();
            }
        }
        else if (parent instanceof Salle){
            return 0;
        }
        
        return 0;
    }

    /**
     * 
     * @param node
     * @return 
     */
    @Override
    public boolean isLeaf(Object node) {
        if (node instanceof Salle){
            return true;
        }
        else if (node instanceof String){
            return false;
        }
        
        return false;
    }

    /**
     * 
     * @param path
     * @param newValue 
     */
    @Override
    public void valueForPathChanged(TreePath path, Object newValue) {
        
    }

    /**
     * 
     * @param parent
     * @param child
     * @return 
     */
    @Override
    public int getIndexOfChild(Object parent, Object child) {
        if (parent instanceof Salle){
            Salle sx = (Salle) parent;
            
            return sx.getId();
        }
        else{
            return 0;
        }
    }

    /**
     * 
     * @param l 
     */
    @Override
    public void addTreeModelListener(TreeModelListener l) {
        }

    /**
     * 
     * @param l 
     */
    @Override
    public void removeTreeModelListener(TreeModelListener l) {
        }
    
}
