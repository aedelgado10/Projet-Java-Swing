/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.delgadopereira.projetjavaswing;

import static java.awt.PageAttributes.ColorType.COLOR;
import java.util.ArrayList;

/**
 *
 * @author willem
 */
public class IHM_Chat_Admin extends javax.swing.JFrame {

    Salle s;
    ExecBD e;
    Administrateur a;
    IHM_Admin i;
    /**
     * Creates new form IHM_Chat_Admin
     */
    /**
     * 
     * @param i
     * @param a
     * @param e
     * @param s 
     */
    public IHM_Chat_Admin(IHM_Admin i, Administrateur a,ExecBD e,Salle s) {
        initComponents();
        this.i = i;
        this.a = a;
        this.e = e;
        this.s = s;
        this.controler();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel9 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel78 = new javax.swing.JLabel();
        label_bienvenue = new javax.swing.JLabel();
        label_salles_creees = new javax.swing.JLabel();
        label_prives_z_collab = new javax.swing.JLabel();
        bouton_sortir = new javax.swing.JButton();
        bouton_se_deco = new javax.swing.JButton();
        label_nb_collabs = new javax.swing.JLabel();
        jScrollPane34 = new javax.swing.JScrollPane();
        jTree_collab = new javax.swing.JTree();
        label_titre_salle = new javax.swing.JLabel();
        label_descsalle = new javax.swing.JLabel();
        jScrollPane35 = new javax.swing.JScrollPane();
        nmess_area = new javax.swing.JTextArea();
        envoyer_msg = new javax.swing.JButton();
        jScrollPane36 = new javax.swing.JScrollPane();
        messages_area = new javax.swing.JTextArea();
        nettoyer_messages = new javax.swing.JButton();
        supprimer_collab_dansSalle = new javax.swing.JButton();
        jButton51 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));

        label_bienvenue.setText("Bienvenue (Pseudo)");

        label_salles_creees.setText("Vous avez crée X salles");

        label_prives_z_collab.setText("Vous discutez en privé avec Z collaborateurs");

        bouton_sortir.setText("Sortir");
        bouton_sortir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bouton_sortirActionPerformed(evt);
            }
        });

        bouton_se_deco.setText("Se Déconnecter");
        bouton_se_deco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bouton_se_decoActionPerformed(evt);
            }
        });

        label_nb_collabs.setText("Collaborateurs");

        jScrollPane34.setViewportView(jTree_collab);

        label_titre_salle.setText("Titre de la salle:");

        label_descsalle.setText("\"Description\"");

        nmess_area.setColumns(20);
        nmess_area.setRows(5);
        nmess_area.setText("Ecrivez ici votre message");
        jScrollPane35.setViewportView(nmess_area);

        envoyer_msg.setText("Envoyer");
        envoyer_msg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                envoyer_msgActionPerformed(evt);
            }
        });

        messages_area.setEditable(false);
        messages_area.setColumns(20);
        messages_area.setRows(5);
        messages_area.setText("Bigotes (Fernando Couto) le jj/mm/aaaa à hh/mm:\n*message*");
        jScrollPane36.setViewportView(messages_area);

        nettoyer_messages.setText("Netoyer Messages");
        nettoyer_messages.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nettoyer_messagesActionPerformed(evt);
            }
        });

        supprimer_collab_dansSalle.setText("Suprimer Collaborateur");
        supprimer_collab_dansSalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supprimer_collab_dansSalleActionPerformed(evt);
            }
        });

        jButton51.setText("Droits");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/strias.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel13Layout.createSequentialGroup()
                                        .addComponent(jScrollPane34, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                                        .addGap(0, 2, Short.MAX_VALUE)
                                        .addComponent(jLabel2)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel78)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE))
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jButton51, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(supprimer_collab_dansSalle, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel13Layout.createSequentialGroup()
                                        .addComponent(label_prives_z_collab)
                                        .addGap(86, 86, 86))
                                    .addComponent(label_salles_creees, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel13Layout.createSequentialGroup()
                                        .addComponent(label_bienvenue)
                                        .addGap(203, 203, 203)))
                                .addGap(28, 28, 28)
                                .addComponent(bouton_sortir)
                                .addGap(18, 18, 18)
                                .addComponent(bouton_se_deco))
                            .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel13Layout.createSequentialGroup()
                                    .addComponent(nettoyer_messages, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 280, Short.MAX_VALUE)
                                    .addComponent(envoyer_msg))
                                .addComponent(label_descsalle, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(label_titre_salle, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane36, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane35, javax.swing.GroupLayout.Alignment.LEADING)))
                        .addGap(54, 54, 54))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(label_nb_collabs)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(label_bienvenue)
                                    .addComponent(bouton_sortir)
                                    .addComponent(bouton_se_deco))
                                .addGap(18, 18, 18)
                                .addComponent(label_salles_creees, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(label_prives_z_collab))
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addComponent(label_titre_salle))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel78))
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_nb_collabs, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_descsalle))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane34)
                    .addComponent(jScrollPane36))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane35, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(supprimer_collab_dansSalle)
                        .addGap(9, 9, 9)
                        .addComponent(jButton51)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(envoyer_msg)
                    .addComponent(nettoyer_messages)))
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jMenu1.setText("Fichier");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Salles");
        jMenuBar1.add(jMenu2);

        jMenu3.setText("Collaborateurs");
        jMenuBar1.add(jMenu3);

        jMenu4.setText("Aide");
        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * 
     * @param evt 
     */
    private void bouton_sortirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bouton_sortirActionPerformed
        messages_area.setText(" ");
        this.setVisible(false);
        this.i.setVisible(true);
    }//GEN-LAST:event_bouton_sortirActionPerformed
    /**
     * 
     * @param evt 
     */
    private void nettoyer_messagesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nettoyer_messagesActionPerformed
        
    }//GEN-LAST:event_nettoyer_messagesActionPerformed
    /**
     * 
     * @param evt 
     */
    private void bouton_se_decoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bouton_se_decoActionPerformed
       messages_area.setText(" ");
       this.setVisible(false);
       this.i.setVisible(true);
       a.se_deconnecter(s.getId());
    }//GEN-LAST:event_bouton_se_decoActionPerformed
    /**
     * 
     * @param evt 
     */
    private void envoyer_msgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_envoyer_msgActionPerformed
        messages_area.setText(" ");
        String message = nmess_area.getText();
        

        Message.envoyerMessage(message, "2016/05/04", 
                "09:08","f", this.s.getId(), a.getId(), e);
        
        controler();
    }//GEN-LAST:event_envoyer_msgActionPerformed

    private void supprimer_collab_dansSalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supprimer_collab_dansSalleActionPerformed
        
        Object o = jTree_collab.getLastSelectedPathComponent();
        
        if (o instanceof Collaborateur){
            Collaborateur c = (Collaborateur) o;
            c.supprimer(c.getId());
        
            ArrayList<Collaborateur> c_List = s.collaborateursDansSalle();
            CollabTreeModel modele_listeC = new CollabTreeModel(c_List);
            jTree_collab.setModel(modele_listeC);
            label_titre_salle.setText("Salle: " + s.getTitre());
            label_descsalle.setText("Description de la salle: " + s.getDescription());

        }
        
        controler();
    }//GEN-LAST:event_supprimer_collab_dansSalleActionPerformed

    /**
     * affiche les messages sur le text_area prevu pour les messages
     */
    public void afficher_msgs(){
        s.clear();
        ArrayList<Message> msg = this.s.getMessages(this.s.getId(), this.a.getId());
        
        
        
        messages_area.setText("");
        
        for (int cpt=0;cpt<msg.size();cpt++){
            messages_area.append("\n"+ msg.get(cpt).getExpediteur() + " le " 
                    + msg.get(cpt).getDateEnvoi()+ " à " + msg.get(cpt).getHeureEnvoi() 
                    + ":" + "\n " + msg.get(cpt).getContenu() + "\n");
        }
    }
    
    /**
     * Recharge toutes les informations de l'IHM
     */
    public void controler(){
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
        
        label_prives_z_collab.setText("Il y a " 
                + s.collaborateursDansSalle().size() + " personnes dans la salle (vous inclus)");
        
        label_nb_collabs.setText("Collaborateurs ("+ s.getNbrCollab() + ")");
        
        ArrayList<Collaborateur> c_List = s.collaborateursDansSalle();
        CollabTreeModel modele_listeC = new CollabTreeModel(c_List);
        jTree_collab.setModel(modele_listeC);
        label_titre_salle.setText("Salle: " + s.getTitre());
        label_descsalle.setText("Description de la salle: " + s.getDescription());
        
        afficher_msgs();
        
        
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bouton_se_deco;
    private javax.swing.JButton bouton_sortir;
    private javax.swing.JButton envoyer_msg;
    private javax.swing.JButton jButton51;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane34;
    private javax.swing.JScrollPane jScrollPane35;
    private javax.swing.JScrollPane jScrollPane36;
    private javax.swing.JTree jTree_collab;
    private javax.swing.JLabel label_bienvenue;
    private javax.swing.JLabel label_descsalle;
    private javax.swing.JLabel label_nb_collabs;
    private javax.swing.JLabel label_prives_z_collab;
    private javax.swing.JLabel label_salles_creees;
    private javax.swing.JLabel label_titre_salle;
    private javax.swing.JTextArea messages_area;
    private javax.swing.JButton nettoyer_messages;
    private javax.swing.JTextArea nmess_area;
    private javax.swing.JButton supprimer_collab_dansSalle;
    // End of variables declaration//GEN-END:variables
}