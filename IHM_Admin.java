/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.delgadopereira.projetjavaswing;

import java.util.ArrayList;
import javax.swing.tree.DefaultTreeCellRenderer;

import javax.swing.tree.TreeSelectionModel;

/**
 *
 * @author willem,Andrés
 * 
 */
public class IHM_Admin extends javax.swing.JFrame {
   

    private final IHM_Main ihm_Maitre;
    Administrateur a; // Les infos de l'admin
    ExecBD e;
    /**
     * Creates new form IHM_Admin
     * @param i
     * @param a
     * @param e 
     */
    public IHM_Admin(IHM_Main i,Administrateur a,ExecBD e) {
        initComponents();
        this.a = a;
        ihm_Maitre = i;
        this.e = e;
    }
    
    /**
     * Cette méthode prend le relais
     */
    public void controler(){
        ArrayList<Collaborateur> c_List;
        ArrayList<Integer> salles_privees =
                a.fetch_salle(a.getSallesDuCollabPrivate());
        
        ArrayList<Integer> salles_publiques = 
                a.fetch_salle(a.getSallesDuCollabPublic());
        try{
            c_List = a.getPeople();
        }catch(NotCreatedException nce){
            System.err.println(nce);
            c_List = new ArrayList<>(1);
        }
        
        
        label_bienvenue.
                setText("Bienvenue "+
                        a.getPseudo() 
                        + "("+ a.getPrenom() 
                        + " " + a.getNom()+ ")");
        
        
        String salle_t = "salle";
        
        if (a.getNbrSallesCrees(this.e) > 1){
            salle_t = "salles";
        }
        label_salles_creees.setText("Vous avez créé "
               + a.getNbrSallesCrees(this.e) +" " + salle_t) ;
        
        label_prives_z_collab.setText("Vous discutez en privé avec " 
                + salles_privees.size() + " people");
        
        label_nb_collabs.setText("Collaborateurs ("+ c_List.size() + ")");
        
        
       /*CollaborateurListCellRenderer c_List_Renderer = 
                new CollaborateurListCellRenderer();*/
        
      
        //that's great.
        CollabTreeModel modele_listeC = new CollabTreeModel(c_List);
        jTree_collab.setModel(modele_listeC);
        
        DefaultTreeCellRenderer cellRenderer = (DefaultTreeCellRenderer) jTree_collab.getCellRenderer();

        //that doesn't work guys..
        /*ImageIcon i = new ImageIcon("absent.png");
        cellRenderer.setLeafIcon(i);
        jTree_collab.setCellRenderer((TreeCellRenderer) cellRenderer);*/
        
        
        ArrayList<Salle> privees = new ArrayList<>();
        ArrayList<Salle> publiques = new ArrayList<>();
        
        Salle sx;
        
        for (int i=0;i<salles_privees.size();i++){
            
            try{
                sx = new Salle(salles_privees.get(i), e);
                privees.add(sx);
            }catch(NotCreatedException nce){
                System.out.println("Salles privées"+ nce);
            }
        }
        
        for (int i=0;i<salles_publiques.size();i++){
            try{
                sx = new Salle(salles_publiques.get(i), e);
                publiques.add(sx);
            }catch (NotCreatedException nce){
                System.out.println("Salles publiques"+ nce);
            }
        }
        
        AffichageSallesModele smodele 
                = new AffichageSallesModele(privees,publiques);
        
        jTree_salles.setModel(smodele);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu4 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel78 = new javax.swing.JLabel();
        label_bienvenue = new javax.swing.JLabel();
        label_salles_creees = new javax.swing.JLabel();
        label_prives_z_collab = new javax.swing.JLabel();
        label_nb_collabs = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        jButton48 = new javax.swing.JButton();
        jButton49 = new javax.swing.JButton();
        supprimer_collab = new javax.swing.JButton();
        jButton50 = new javax.swing.JButton();
        joindre_salle = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        se_deconnecter_bouton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTree_collab = new javax.swing.JTree();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTree_salles = new javax.swing.JTree();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();

        jMenu4.setText("jMenu4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));

        label_bienvenue.setText("Bienvenue (Pseudo)");

        label_salles_creees.setText("Vous avez crée X salles");

        label_prives_z_collab.setText("Vous discutez en privé avec Z collaborateurs");

        label_nb_collabs.setText("Collaborateurs");

        jLabel84.setText("Salles crées:");

        jButton48.setText("Effacer");
        jButton48.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton48ActionPerformed(evt);
            }
        });

        jButton49.setText("Créer");
        jButton49.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton49ActionPerformed(evt);
            }
        });

        supprimer_collab.setText("Suprimer Collaborateur");
        supprimer_collab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supprimer_collabActionPerformed(evt);
            }
        });

        jButton50.setText("Inviter");

        joindre_salle.setText("Joindre");
        joindre_salle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                joindre_salleActionPerformed(evt);
            }
        });

        jButton2.setText("Nettoyer Messages");

        se_deconnecter_bouton.setText("Se Déconnecter");
        se_deconnecter_bouton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                se_deconnecter_boutonActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(jTree_collab);

        jScrollPane2.setViewportView(jTree_salles);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/strias.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1)
                            .addComponent(supprimer_collab, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton50, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                                            .addComponent(label_bienvenue)
                                            .addGap(203, 203, 203))
                                        .addGroup(jPanel13Layout.createSequentialGroup()
                                            .addGap(45, 45, 45)
                                            .addComponent(jLabel84))
                                        .addComponent(label_salles_creees, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label_prives_z_collab)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel78)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel13Layout.createSequentialGroup()
                                        .addComponent(jButton49, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(joindre_salle)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButton48)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(jPanel13Layout.createSequentialGroup()
                                        .addGap(352, 352, 352)
                                        .addComponent(se_deconnecter_bouton, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)))
                                .addContainerGap(71, Short.MAX_VALUE))
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 521, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(label_nb_collabs)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(jLabel78))
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1))
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label_nb_collabs, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(label_bienvenue)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(label_salles_creees, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(label_prives_z_collab)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel84)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                        .addComponent(supprimer_collab)
                        .addGap(17, 17, 17))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton48)
                    .addComponent(jButton49)
                    .addComponent(jButton50)
                    .addComponent(joindre_salle)
                    .addComponent(jButton2))
                .addGap(8, 8, 8)
                .addComponent(se_deconnecter_bouton))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jMenu1.setText("Fichier");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Salles");
        jMenuBar1.add(jMenu2);

        jMenu3.setText("Collaborateurs");
        jMenuBar1.add(jMenu3);

        jMenu5.setText("Aide");
        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * 
     * @param evt 
     */
    private void se_deconnecter_boutonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_se_deconnecter_boutonActionPerformed
        this.setVisible(false);
        this.ihm_Maitre.setVisible(true);
    }//GEN-LAST:event_se_deconnecter_boutonActionPerformed

   /**
     * 
     * @param evt 
     */
    private void joindre_salleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_joindre_salleActionPerformed
        jTree_salles.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);

        Object noeud = (Object) jTree_salles.getLastSelectedPathComponent();

        try{
            if (noeud instanceof Salle){
                IHM_Admin i = this;
                this.a.se_connecter(((Salle) noeud).getId());
                IHM_Chat_Admin ca = new IHM_Chat_Admin(i,a,e,(Salle)noeud);
                ca.setVisible(true);
                this.setVisible(false);
            }
        }catch(Exception ex){
            System.out.println("Selection eronée dans l'arbre des salles" + ex);
        }
    }//GEN-LAST:event_joindre_salleActionPerformed

    private void supprimer_collabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supprimer_collabActionPerformed

    }//GEN-LAST:event_supprimer_collabActionPerformed

    /**
     * 
     * @param evt 
     */
    private void jButton49ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton49ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton49ActionPerformed

    private void jButton48ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton48ActionPerformed

    }//GEN-LAST:event_jButton48ActionPerformed

   
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton48;
    private javax.swing.JButton jButton49;
    private javax.swing.JButton jButton50;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTree jTree_collab;
    private javax.swing.JTree jTree_salles;
    private javax.swing.JButton joindre_salle;
    private javax.swing.JLabel label_bienvenue;
    private javax.swing.JLabel label_nb_collabs;
    private javax.swing.JLabel label_prives_z_collab;
    private javax.swing.JLabel label_salles_creees;
    private javax.swing.JButton se_deconnecter_bouton;
    private javax.swing.JButton supprimer_collab;
    // End of variables declaration//GEN-END:variables
}