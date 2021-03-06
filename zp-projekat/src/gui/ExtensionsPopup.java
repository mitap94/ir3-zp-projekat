/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.Extension;
import org.bouncycastle.asn1.x509.GeneralName;
import org.bouncycastle.asn1.x509.GeneralNames;
import org.bouncycastle.asn1.x509.GeneralNamesBuilder;

/**
 *
 * @author Mita
 */
public class ExtensionsPopup extends javax.swing.JFrame {

    /**
     * Creates new form ExportPopup
     */
    public ExtensionsPopup(MainWindow parent, ExtensionsGUI extensions) {
        this.parentFrame = parent;
        this.extensions = extensions;

        initComponents();
        myInitComponents();

        loadExtensions();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT
     * modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        extensionsPanel = new javax.swing.JPanel();
        chooseExtensionsLabel = new javax.swing.JLabel();
        okButton = new javax.swing.JButton();
        basicConstraintsCheckBox = new javax.swing.JCheckBox();
        issuerAltNameCheckBox = new javax.swing.JCheckBox();
        keyUsageCheckBox = new javax.swing.JCheckBox();
        extensionsSeparator1 = new javax.swing.JSeparator();
        basicConstraintsPanel = new javax.swing.JPanel();
        basicConstraintsLabel = new javax.swing.JLabel();
        basicConstraintsCriticalCheckBox = new javax.swing.JCheckBox();
        basicConstraintsCACheckBox = new javax.swing.JCheckBox();
        depthOfCertificateChainTextField = new javax.swing.JTextField();
        depthOfCertChainLabel = new javax.swing.JLabel();
        extensionsSeparator2 = new javax.swing.JSeparator();
        keyUsagePanel = new javax.swing.JPanel();
        keyUsageLabel = new javax.swing.JLabel();
        keyUsageCriticalCheckBox = new javax.swing.JCheckBox();
        digitalSignatureCheckBox = new javax.swing.JCheckBox();
        nonRepudiationCheckBox = new javax.swing.JCheckBox();
        keyEnciphermentCheckBox = new javax.swing.JCheckBox();
        dataEnciphermentCheckBox = new javax.swing.JCheckBox();
        keyAgreementCheckBox = new javax.swing.JCheckBox();
        keyCertSignCheckBox = new javax.swing.JCheckBox();
        cRLSignCheckBox = new javax.swing.JCheckBox();
        encipherOnlyCheckBox = new javax.swing.JCheckBox();
        decipherOnlyCheckBox = new javax.swing.JCheckBox();
        extensionsSeparator3 = new javax.swing.JSeparator();
        issuerAltNamePanel = new javax.swing.JPanel();
        issuerAltNameLabel = new javax.swing.JLabel();
        issuerAltNameCriticalCheckBox = new javax.swing.JCheckBox();
        issuerAltNameScrollPanel = new javax.swing.JScrollPane();
        issuerAltNameTextArea = new javax.swing.JTextArea();
        issuerAltNameComboBox = new javax.swing.JComboBox<>();
        clearIssuerAltNameButton = new javax.swing.JButton();
        addIssuerAltNameButton = new javax.swing.JButton();
        issuerAltNameTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Extensions");
        setAlwaysOnTop(true);
        setResizable(false);

        extensionsPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        chooseExtensionsLabel.setText("Choose the extensions you want in your certificate:");

        okButton.setText("OK");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        basicConstraintsCheckBox.setText("Basic Constraints");
        basicConstraintsCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                basicConstraintsCheckBoxActionPerformed(evt);
            }
        });

        issuerAltNameCheckBox.setText("Issuer Alternative Name");
        issuerAltNameCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                issuerAltNameCheckBoxActionPerformed(evt);
            }
        });

        keyUsageCheckBox.setText("Key Usage");
        keyUsageCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keyUsageCheckBoxActionPerformed(evt);
            }
        });

        basicConstraintsLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        basicConstraintsLabel.setText("Basic Constraints:");

        basicConstraintsCriticalCheckBox.setText("Critical Extension");

        basicConstraintsCACheckBox.setText("CA");
        basicConstraintsCACheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                basicConstraintsCACheckBoxActionPerformed(evt);
            }
        });

        depthOfCertChainLabel.setText("Depth of certificate chain:");

        javax.swing.GroupLayout basicConstraintsPanelLayout = new javax.swing.GroupLayout(basicConstraintsPanel);
        basicConstraintsPanel.setLayout(basicConstraintsPanelLayout);
        basicConstraintsPanelLayout.setHorizontalGroup(
            basicConstraintsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(basicConstraintsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(basicConstraintsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(basicConstraintsLabel)
                    .addGroup(basicConstraintsPanelLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(basicConstraintsCACheckBox)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(basicConstraintsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(basicConstraintsCriticalCheckBox)
                    .addGroup(basicConstraintsPanelLayout.createSequentialGroup()
                        .addComponent(depthOfCertChainLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(depthOfCertificateChainTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        basicConstraintsPanelLayout.setVerticalGroup(
            basicConstraintsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(basicConstraintsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(basicConstraintsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(basicConstraintsLabel)
                    .addComponent(basicConstraintsCriticalCheckBox))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(basicConstraintsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(basicConstraintsCACheckBox)
                    .addComponent(depthOfCertificateChainTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(depthOfCertChainLabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        keyUsageLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        keyUsageLabel.setText("Key Usage:");

        keyUsageCriticalCheckBox.setText("Critical Extension");

        digitalSignatureCheckBox.setText("Digital signature");

        nonRepudiationCheckBox.setText("Non repudiation");

        keyEnciphermentCheckBox.setText("Key encipherment");

        dataEnciphermentCheckBox.setText("Data encipherment");

        keyAgreementCheckBox.setText("Key agreement");

        keyCertSignCheckBox.setText("keyCertSign");

        cRLSignCheckBox.setText("cRLSign");

        encipherOnlyCheckBox.setText("Encipher only");

        decipherOnlyCheckBox.setText("Decipher only");

        javax.swing.GroupLayout keyUsagePanelLayout = new javax.swing.GroupLayout(keyUsagePanel);
        keyUsagePanel.setLayout(keyUsagePanelLayout);
        keyUsagePanelLayout.setHorizontalGroup(
            keyUsagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(keyUsagePanelLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(keyUsagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(keyUsagePanelLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(keyUsagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(digitalSignatureCheckBox)
                            .addComponent(dataEnciphermentCheckBox)
                            .addComponent(cRLSignCheckBox))
                        .addGap(18, 18, 18)
                        .addGroup(keyUsagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nonRepudiationCheckBox)
                            .addComponent(keyAgreementCheckBox)
                            .addComponent(encipherOnlyCheckBox))
                        .addGap(18, 18, 18)
                        .addGroup(keyUsagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(keyEnciphermentCheckBox)
                            .addComponent(keyCertSignCheckBox)
                            .addComponent(decipherOnlyCheckBox)))
                    .addGroup(keyUsagePanelLayout.createSequentialGroup()
                        .addComponent(keyUsageLabel)
                        .addGap(18, 18, 18)
                        .addComponent(keyUsageCriticalCheckBox)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        keyUsagePanelLayout.setVerticalGroup(
            keyUsagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(keyUsagePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(keyUsagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(keyUsageLabel)
                    .addComponent(keyUsageCriticalCheckBox))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(keyUsagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(digitalSignatureCheckBox)
                    .addComponent(nonRepudiationCheckBox)
                    .addComponent(keyEnciphermentCheckBox))
                .addGap(11, 11, 11)
                .addGroup(keyUsagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(dataEnciphermentCheckBox)
                    .addComponent(keyAgreementCheckBox)
                    .addComponent(keyCertSignCheckBox))
                .addGap(11, 11, 11)
                .addGroup(keyUsagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(cRLSignCheckBox)
                    .addComponent(encipherOnlyCheckBox)
                    .addComponent(decipherOnlyCheckBox))
                .addContainerGap())
        );

        issuerAltNameLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        issuerAltNameLabel.setText("Issuer Alternative Name:");

        issuerAltNameCriticalCheckBox.setText("Critical Extension");

        issuerAltNameTextArea.setEditable(false);
        issuerAltNameTextArea.setColumns(20);
        issuerAltNameTextArea.setRows(5);
        issuerAltNameScrollPanel.setViewportView(issuerAltNameTextArea);

        issuerAltNameComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Other Name", "RFC822 Name", "DNS Name", "x400 Address", "Directory Name", "EDI Party Name", "URI", "IP Address", "Registered ID" }));

        clearIssuerAltNameButton.setText("Clear");
        clearIssuerAltNameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearIssuerAltNameButtonActionPerformed(evt);
            }
        });

        addIssuerAltNameButton.setText("Add");
        addIssuerAltNameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addIssuerAltNameButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout issuerAltNamePanelLayout = new javax.swing.GroupLayout(issuerAltNamePanel);
        issuerAltNamePanel.setLayout(issuerAltNamePanelLayout);
        issuerAltNamePanelLayout.setHorizontalGroup(
            issuerAltNamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, issuerAltNamePanelLayout.createSequentialGroup()
                .addGroup(issuerAltNamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(issuerAltNamePanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(issuerAltNamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(issuerAltNameComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(issuerAltNameLabel, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(18, 18, 18)
                        .addGroup(issuerAltNamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(issuerAltNameCriticalCheckBox)
                            .addGroup(issuerAltNamePanelLayout.createSequentialGroup()
                                .addComponent(issuerAltNameTextField)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(addIssuerAltNameButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(clearIssuerAltNameButton))))
                    .addGroup(issuerAltNamePanelLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(issuerAltNameScrollPanel)))
                .addGap(20, 20, 20))
        );

        issuerAltNamePanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {addIssuerAltNameButton, clearIssuerAltNameButton});

        issuerAltNamePanelLayout.setVerticalGroup(
            issuerAltNamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(issuerAltNamePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(issuerAltNamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(issuerAltNameLabel)
                    .addComponent(issuerAltNameCriticalCheckBox))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(issuerAltNamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(issuerAltNameComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clearIssuerAltNameButton)
                    .addComponent(addIssuerAltNameButton)
                    .addComponent(issuerAltNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(issuerAltNameScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        issuerAltNamePanelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {addIssuerAltNameButton, clearIssuerAltNameButton, issuerAltNameComboBox, issuerAltNameTextField});

        javax.swing.GroupLayout extensionsPanelLayout = new javax.swing.GroupLayout(extensionsPanel);
        extensionsPanel.setLayout(extensionsPanelLayout);
        extensionsPanelLayout.setHorizontalGroup(
            extensionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, extensionsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(extensionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(extensionsSeparator3)
                    .addComponent(keyUsagePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(extensionsSeparator2)
                    .addComponent(basicConstraintsPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(extensionsSeparator1)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, extensionsPanelLayout.createSequentialGroup()
                        .addGroup(extensionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chooseExtensionsLabel)
                            .addGroup(extensionsPanelLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(basicConstraintsCheckBox)
                                .addGap(18, 18, 18)
                                .addComponent(keyUsageCheckBox)
                                .addGap(18, 18, 18)
                                .addComponent(issuerAltNameCheckBox)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(issuerAltNamePanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, extensionsPanelLayout.createSequentialGroup()
                .addGap(207, 207, 207)
                .addComponent(okButton)
                .addGap(206, 206, 206))
        );
        extensionsPanelLayout.setVerticalGroup(
            extensionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(extensionsPanelLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(chooseExtensionsLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(extensionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(basicConstraintsCheckBox)
                    .addComponent(keyUsageCheckBox)
                    .addComponent(issuerAltNameCheckBox))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(extensionsSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(basicConstraintsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(extensionsSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(keyUsagePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(extensionsSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(issuerAltNamePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(okButton)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(extensionsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(extensionsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        saveExtensions();
        dispose();
    }//GEN-LAST:event_okButtonActionPerformed

    private void basicConstraintsCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_basicConstraintsCheckBoxActionPerformed
        if (basicConstraintsCheckBox.isSelected()) {
            basicConstraintsPanel.setVisible(true);
            extensionsSeparator2.setVisible(true);
        } else {
            basicConstraintsPanel.setVisible(false);
            extensionsSeparator2.setVisible(false);
        }
    }//GEN-LAST:event_basicConstraintsCheckBoxActionPerformed

    private void keyUsageCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keyUsageCheckBoxActionPerformed
        if (keyUsageCheckBox.isSelected()) {
            keyUsagePanel.setVisible(true);
            extensionsSeparator3.setVisible(true);
        } else {
            keyUsagePanel.setVisible(false);
            extensionsSeparator3.setVisible(false);
        }
    }//GEN-LAST:event_keyUsageCheckBoxActionPerformed

    private void issuerAltNameCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_issuerAltNameCheckBoxActionPerformed
        if (issuerAltNameCheckBox.isSelected()) {
            issuerAltNamePanel.setVisible(true);
        } else {
            issuerAltNamePanel.setVisible(false);
        }
    }//GEN-LAST:event_issuerAltNameCheckBoxActionPerformed

    private void basicConstraintsCACheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_basicConstraintsCACheckBoxActionPerformed
        if (basicConstraintsCACheckBox.isSelected()) {
            depthOfCertChainLabel.setVisible(true);
            depthOfCertificateChainTextField.setVisible(true);

        } else {
            depthOfCertChainLabel.setVisible(false);
            depthOfCertificateChainTextField.setVisible(false);
        }
    }//GEN-LAST:event_basicConstraintsCACheckBoxActionPerformed

    private void clearIssuerAltNameButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearIssuerAltNameButtonActionPerformed
        issuerAltNameTextArea.setText("");
        generalNamesBuilder = new GeneralNamesBuilder();
    }//GEN-LAST:event_clearIssuerAltNameButtonActionPerformed

    private void addIssuerAltNameButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addIssuerAltNameButtonActionPerformed
        String extension = issuerAltNameTextField.getText();
        issuerAltNameTextField.setText("");
        if (!extension.isEmpty()) {
            String extName = (String) issuerAltNameComboBox.getSelectedItem();
            try {
                switch (extName) {
                    case "Other Name":
                        generalNamesBuilder.addName(new GeneralName(GeneralName.otherName, extension));
                        break;
                    case "RFC822 Name":
                        generalNamesBuilder.addName(new GeneralName(GeneralName.rfc822Name, extension));
                        break;
                    case "DNS Name":
                        generalNamesBuilder.addName(new GeneralName(GeneralName.dNSName, extension));
                        break;
                    case "x400 Address":
                        generalNamesBuilder.addName(new GeneralName(GeneralName.x400Address, extension));
                        break;
                    case "Directory Name":
                        generalNamesBuilder.addName(new GeneralName(GeneralName.directoryName,
                                new X500Name(extension)));
                        break;
                    case "EDI Party Name":
                        generalNamesBuilder.addName(new GeneralName(GeneralName.ediPartyName, extension));
                        break;
                    case "URI":
                        generalNamesBuilder.addName(new GeneralName(GeneralName.uniformResourceIdentifier, extension));
                        break;
                    case "IP Address":
                        generalNamesBuilder.addName(new GeneralName(GeneralName.iPAddress, extension));
                        break;
                    case "Registered ID":
                        generalNamesBuilder.addName(new GeneralName(GeneralName.registeredID, extension));
                        break;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, Errors.EXTENSION_INVALID_FORMAT, "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            issuerAltNameTextArea.append(extName + ": " + extension + "\n");
        }
    }//GEN-LAST:event_addIssuerAltNameButtonActionPerformed

    private void myInitComponents() {
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frameSize = this.getSize();
        leftCornerAnchor = new Point((int) (screenSize.width / 2 - frameSize.width / 2),
                (int) (screenSize.height / 2 - frameSize.height / 2));
        setLocation(leftCornerAnchor);

        generalNamesBuilder = new GeneralNamesBuilder();

        basicConstraintsPanel.setVisible(false);
        keyUsagePanel.setVisible(false);
        issuerAltNamePanel.setVisible(false);
        depthOfCertChainLabel.setVisible(false);
        depthOfCertificateChainTextField.setVisible(false);
        depthOfCertificateChainTextField.setText("0");
        extensionsSeparator2.setVisible(false);
        extensionsSeparator3.setVisible(false);
    }

    private void loadExtensions() {
        if (extensions.extensions[0]) {
            basicConstraintsCheckBox.setSelected(true);
            basicConstraintsPanel.setVisible(true);
            if (extensions.critical[0]) {
                basicConstraintsCriticalCheckBox.setSelected(true);
            }
            if (extensions.basicConstrCA) {
                basicConstraintsCACheckBox.setSelected(true);
                depthOfCertChainLabel.setVisible(true);
                depthOfCertificateChainTextField.setVisible(true);
                depthOfCertificateChainTextField.setText(extensions.basicConstrDepthOfCertChain);
            }
        }
        if (extensions.extensions[1]) {
            keyUsageCheckBox.setSelected(true);
            keyUsagePanel.setVisible(true);
            if (extensions.critical[1]) {
                keyUsageCriticalCheckBox.setSelected(true);
            }

            if (extensions.keyUsage[0]) {
                digitalSignatureCheckBox.setSelected(true);
            }
            if (extensions.keyUsage[1]) {
                nonRepudiationCheckBox.setSelected(true);
            }
            if (extensions.keyUsage[2]) {
                keyEnciphermentCheckBox.setSelected(true);
            }
            if (extensions.keyUsage[3]) {
                dataEnciphermentCheckBox.setSelected(true);
            }
            if (extensions.keyUsage[4]) {
                keyAgreementCheckBox.setSelected(true);
            }
            if (extensions.keyUsage[5]) {
                keyCertSignCheckBox.setSelected(true);
            }
            if (extensions.keyUsage[6]) {
                cRLSignCheckBox.setSelected(true);
            }
            if (extensions.keyUsage[7]) {
                encipherOnlyCheckBox.setSelected(true);
            }
            if (extensions.keyUsage[8]) {
                decipherOnlyCheckBox.setSelected(true);
            }
        }
        if (extensions.extensions[2]) {
            issuerAltNameCheckBox.setSelected(true);
            issuerAltNamePanel.setVisible(true);
            if (extensions.critical[2]) {
                issuerAltNameCriticalCheckBox.setSelected(true);
            }

            issuerAltNameTextArea.setText(extensions.issuerAltNamesString);

        }
        if (extensions.extensions[0]) {
            extensionsSeparator2.setVisible(true);
        }
        if (extensions.extensions[1]) {
            extensionsSeparator3.setVisible(true);
        }
    }

    private void saveExtensions() {
        extensions.clearAll();

        if (basicConstraintsCheckBox.isSelected()) {
            extensions.extensions[0] = true;
            if (basicConstraintsCriticalCheckBox.isSelected()) {
                extensions.critical[0] = true;
            }
            if (basicConstraintsCACheckBox.isSelected()) {
                extensions.basicConstrCA = true;
                try {
                    Integer.parseInt(depthOfCertificateChainTextField.getText());
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, Errors.INVALID_NUMBER_FORMAT
                            + " " + Errors.INVALID_DEPTH, "Error", JOptionPane.ERROR_MESSAGE);
                    parentFrame.setStatus(Errors.INVALID_NUMBER_FORMAT + " " + Errors.INVALID_DEPTH,
                            Errors.COLOR);
                    return;
                }
                extensions.basicConstrDepthOfCertChain = depthOfCertificateChainTextField.getText();
            }
        }

        if (keyUsageCheckBox.isSelected()) {
            extensions.extensions[1] = true;
            if (keyUsageCriticalCheckBox.isSelected()) {
                extensions.critical[1] = true;
            }

            if (digitalSignatureCheckBox.isSelected()) {
                extensions.keyUsage[0] = true;
            }
            if (nonRepudiationCheckBox.isSelected()) {
                extensions.keyUsage[1] = true;
            }
            if (keyEnciphermentCheckBox.isSelected()) {
                extensions.keyUsage[2] = true;
            }
            if (dataEnciphermentCheckBox.isSelected()) {
                extensions.keyUsage[3] = true;
            }
            if (keyAgreementCheckBox.isSelected()) {
                extensions.keyUsage[4] = true;
            }
            if (keyCertSignCheckBox.isSelected()) {
                extensions.keyUsage[5] = true;
            }
            if (cRLSignCheckBox.isSelected()) {
                extensions.keyUsage[6] = true;
            }
            if (encipherOnlyCheckBox.isSelected()) {
                extensions.keyUsage[7] = true;
            }
            if (decipherOnlyCheckBox.isSelected()) {
                extensions.keyUsage[8] = true;
            }
        }

        if (issuerAltNameCheckBox.isSelected()) {
            extensions.extensions[2] = true;
            if (issuerAltNameCriticalCheckBox.isSelected()) {
                extensions.critical[2] = true;
            }

            if (!"".equals(issuerAltNameTextArea.getText())) {
                GeneralNames generalNames = generalNamesBuilder.build();
                try {
                    extensions.issuerAltNames = new Extension(Extension.issuerAlternativeName,
                            issuerAltNameCriticalCheckBox.isSelected(), generalNames.getEncoded());
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this, Errors.EXTENSIONS_ERROR, "Error",
                            JOptionPane.ERROR_MESSAGE);
                    parentFrame.setStatus(Errors.EXTENSIONS_ERROR, Errors.COLOR);
                }
            }
            extensions.issuerAltNamesString = issuerAltNameTextArea.getText();
        }
    }

    private Dimension screenSize;
    private Dimension frameSize;
    private Point leftCornerAnchor;

    private final MainWindow parentFrame;
    private final ExtensionsGUI extensions;

    private GeneralNamesBuilder generalNamesBuilder;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addIssuerAltNameButton;
    private javax.swing.JCheckBox basicConstraintsCACheckBox;
    private javax.swing.JCheckBox basicConstraintsCheckBox;
    private javax.swing.JCheckBox basicConstraintsCriticalCheckBox;
    private javax.swing.JLabel basicConstraintsLabel;
    private javax.swing.JPanel basicConstraintsPanel;
    private javax.swing.JCheckBox cRLSignCheckBox;
    private javax.swing.JLabel chooseExtensionsLabel;
    private javax.swing.JButton clearIssuerAltNameButton;
    private javax.swing.JCheckBox dataEnciphermentCheckBox;
    private javax.swing.JCheckBox decipherOnlyCheckBox;
    private javax.swing.JLabel depthOfCertChainLabel;
    private javax.swing.JTextField depthOfCertificateChainTextField;
    private javax.swing.JCheckBox digitalSignatureCheckBox;
    private javax.swing.JCheckBox encipherOnlyCheckBox;
    private javax.swing.JPanel extensionsPanel;
    private javax.swing.JSeparator extensionsSeparator1;
    private javax.swing.JSeparator extensionsSeparator2;
    private javax.swing.JSeparator extensionsSeparator3;
    private javax.swing.JCheckBox issuerAltNameCheckBox;
    private javax.swing.JComboBox<String> issuerAltNameComboBox;
    private javax.swing.JCheckBox issuerAltNameCriticalCheckBox;
    private javax.swing.JLabel issuerAltNameLabel;
    private javax.swing.JPanel issuerAltNamePanel;
    private javax.swing.JScrollPane issuerAltNameScrollPanel;
    private javax.swing.JTextArea issuerAltNameTextArea;
    private javax.swing.JTextField issuerAltNameTextField;
    private javax.swing.JCheckBox keyAgreementCheckBox;
    private javax.swing.JCheckBox keyCertSignCheckBox;
    private javax.swing.JCheckBox keyEnciphermentCheckBox;
    private javax.swing.JCheckBox keyUsageCheckBox;
    private javax.swing.JCheckBox keyUsageCriticalCheckBox;
    private javax.swing.JLabel keyUsageLabel;
    private javax.swing.JPanel keyUsagePanel;
    private javax.swing.JCheckBox nonRepudiationCheckBox;
    private javax.swing.JButton okButton;
    // End of variables declaration//GEN-END:variables
}
