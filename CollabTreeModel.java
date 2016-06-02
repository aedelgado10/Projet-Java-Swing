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
public class CollabTreeModel implements TreeModel{
    
    ArrayList<Collaborateur> c;
    
    /**
     * 
     * @param l 
     */
    public CollabTreeModel(ArrayList<Collaborateur> l){
        this.c = l;
    }
    
    /**
     * s
     * @return 
     */
    @Override
    public Object getRoot(){
        return "Collaborateurs";
    }
    
    /**
     * 
     * @param collab
     * @param nb
     * @return 
     */
    @Override
    public Object getChild(Object collab,int nb){
        if (collab instanceof String){
            return c.get(nb);
        }
        else{
            return "/";
        }
    }
    
    /**
     * 
     * @param collab
     * @return 
     */
    @Override
    public int getChildCount(Object collab){
        if (collab instanceof String){
            return c.size();
        }
        else{
            return 0;
        }
    }

    /**
     * 
     * @param node
     * @return 
     */
    @Override
    public boolean isLeaf(Object node) {
        return node instanceof Collaborateur;
    }

    /**
     * 
     * @param path
     * @param newValue 
     */
    @Override
    public void valueForPathChanged(TreePath path, Object newValue) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * 
     * @param parent
     * @param child
     * @return 
     */
    @Override
    public int getIndexOfChild(Object parent, Object child) {
        
        for(int i=0;i<c.size();i++){
            if (child.equals(c.get(i))){
                return c.get(i).getId();
            }
        }
        return 0;
    }

    /**
     * 
     * @param l 
     */
    @Override
    public void addTreeModelListener(TreeModelListener l) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * 
     * @param l 
     */
    @Override
    public void removeTreeModelListener(TreeModelListener l) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
