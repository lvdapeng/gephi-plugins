/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.polinode.polinodeexporter;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.prefs.Preferences;
import org.openide.util.NbPreferences;

import org.gephi.project.api.ProjectInformation;
import org.gephi.project.api.ProjectMetaData;

/**
 *
 * @author stephenrogers
 */
public class PolinodeExporterSettingsPanel extends javax.swing.JPanel {

    private PolinodeExporter exporter;
    private String realPrivateKey;

    /**
     * Creates new form PolinodeExporterSettingsPanel
     */
    public PolinodeExporterSettingsPanel() {
        initComponents();
    }

    public void setup(PolinodeExporter exporter) {
        this.exporter = exporter;
        
        Preferences prefs = NbPreferences.forModule(PolinodeExporterSettingsPanel.class);
        polinodePublicKey.setText(prefs.get("polinodePublicKey", ""));
        realPrivateKey = prefs.get("polinodePrivateKey", "");
        if( realPrivateKey.length()==0 )
            polinodePrivateKey.setText("");
        else
            polinodePrivateKey.setText("XXXXXXXX-XXXX-XXXX-XXXX-XXXXXXXX"+realPrivateKey.substring(realPrivateKey.length()-4, realPrivateKey.length()));

        String title = null;
        String description = null;
        ProjectMetaData projectMetaData = exporter.getWorkspace().getLookup().lookup(ProjectMetaData.class);
        if( projectMetaData!=null ) {
            title = projectMetaData.getTitle();
            description = projectMetaData.getDescription();
        }
        if( title==null ) {
            ProjectInformation projectInformation = exporter.getWorkspace().getLookup().lookup(ProjectInformation.class);
            if( projectInformation!=null ) {
                title = projectInformation.getName();
                if( title.length()==0 )
                    title = projectInformation.getFileName();
            }
        }

        networkName.setText(title==null ? "" : title);
        networkDescription.setText(description==null ? "" : description);
        
        isNetworkPrivate.setSelected(prefs.get("isNetworkPrivate", "No").equals("Yes"));
    }

    public void unsetup(boolean update) {
        Preferences props = NbPreferences.forModule(PolinodeExporterSettingsPanel.class);
        if (update) {
            try {
                props.put("polinodePublicKey", polinodePublicKey.getText());
                if( !polinodePrivateKey.getText().substring(0, 8).equals("XXXXXXXX") ) {
                    realPrivateKey = polinodePrivateKey.getText();
                    props.put("polinodePrivateKey", polinodePrivateKey.getText());
                }
                props.put("isNetworkPrivate", isNetworkPrivate.isSelected() ? "Yes" : "No");
            } catch (Exception e) {
                Logger.getLogger(PolinodeExporter.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }
    
    public String getNetworkName() {
        return networkName.getText();
    }
            
    public String getNetworkDescription() {
        return networkDescription.getText();
    }
            
    public String getPolinodePublicKey() {
        return polinodePublicKey.getText();
    }

    public String getPolinodePrivateKey() {
        return realPrivateKey;
    }

    public boolean getIsNetworkPrivate()
    {
        return isNetworkPrivate.isSelected();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        networkName = new javax.swing.JTextField();
        networkDescription = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        polinodePublicKey = new javax.swing.JTextField();
        polinodePrivateKey = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        isNetworkPrivate = new javax.swing.JCheckBox();

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(PolinodeExporterSettingsPanel.class, "PolinodeExporterSettingsPanel.jLabel1.text")); // NOI18N

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        org.openide.awt.Mnemonics.setLocalizedText(jLabel2, org.openide.util.NbBundle.getMessage(PolinodeExporterSettingsPanel.class, "PolinodeExporterSettingsPanel.jLabel2.text")); // NOI18N

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        org.openide.awt.Mnemonics.setLocalizedText(jLabel3, org.openide.util.NbBundle.getMessage(PolinodeExporterSettingsPanel.class, "PolinodeExporterSettingsPanel.jLabel3.text")); // NOI18N

        networkName.setText(org.openide.util.NbBundle.getMessage(PolinodeExporterSettingsPanel.class, "PolinodeExporterSettingsPanel.networkName.text")); // NOI18N

        networkDescription.setText(org.openide.util.NbBundle.getMessage(PolinodeExporterSettingsPanel.class, "PolinodeExporterSettingsPanel.networkDescription.text")); // NOI18N

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(jLabel4, org.openide.util.NbBundle.getMessage(PolinodeExporterSettingsPanel.class, "PolinodeExporterSettingsPanel.jLabel4.text")); // NOI18N

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        org.openide.awt.Mnemonics.setLocalizedText(jLabel5, org.openide.util.NbBundle.getMessage(PolinodeExporterSettingsPanel.class, "PolinodeExporterSettingsPanel.jLabel5.text")); // NOI18N

        polinodePublicKey.setFont(new java.awt.Font("Monospaced", 0, 13)); // NOI18N
        polinodePublicKey.setText(org.openide.util.NbBundle.getMessage(PolinodeExporterSettingsPanel.class, "PolinodeExporterSettingsPanel.polinodePublicKey.text")); // NOI18N

        polinodePrivateKey.setFont(new java.awt.Font("Monospaced", 0, 13)); // NOI18N
        polinodePrivateKey.setText(org.openide.util.NbBundle.getMessage(PolinodeExporterSettingsPanel.class, "PolinodeExporterSettingsPanel.polinodePrivateKey.text")); // NOI18N

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        org.openide.awt.Mnemonics.setLocalizedText(jLabel6, org.openide.util.NbBundle.getMessage(PolinodeExporterSettingsPanel.class, "PolinodeExporterSettingsPanel.jLabel6.text")); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 91, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(polinodePrivateKey, javax.swing.GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE)
                            .addComponent(polinodePublicKey))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(polinodePublicKey, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(polinodePrivateKey, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        org.openide.awt.Mnemonics.setLocalizedText(isNetworkPrivate, org.openide.util.NbBundle.getMessage(PolinodeExporterSettingsPanel.class, "PolinodeExporterSettingsPanel.isNetworkPrivate.text")); // NOI18N
        isNetworkPrivate.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        isNetworkPrivate.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        isNetworkPrivate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                isNetworkPrivateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(isNetworkPrivate, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(networkDescription, javax.swing.GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE)
                            .addComponent(networkName))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(networkName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(networkDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(isNetworkPrivate)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(260, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(221, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(38, 38, 38)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void isNetworkPrivateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_isNetworkPrivateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_isNetworkPrivateActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox isNetworkPrivate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField networkDescription;
    private javax.swing.JTextField networkName;
    private javax.swing.JTextField polinodePrivateKey;
    private javax.swing.JTextField polinodePublicKey;
    // End of variables declaration//GEN-END:variables
}
