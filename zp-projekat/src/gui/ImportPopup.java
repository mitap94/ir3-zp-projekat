/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import crypto.exceptions.FileToolNotInitializedException;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.IOException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Mita
 */
public class ImportPopup extends javax.swing.JFrame {

    /**
     * Creates new form ImportPopup
     */
    public ImportPopup(MainWindow parent) {
        this.parentFrame = parent;
        initComponents();
        myInitComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT
     * modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        statusBarTextField = new javax.swing.JTextField();
        chooseFilePanel = new javax.swing.JPanel();
        importButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        chooseFileButton = new javax.swing.JButton();
        fileNameTextField = new javax.swing.JTextField();
        passwordField = new javax.swing.JPasswordField();
        passwordLabel = new javax.swing.JLabel();
        fileNameLabel = new javax.swing.JLabel();
        aesEncryptedCheckBox = new javax.swing.JCheckBox();
        aesEncryptedLabel = new javax.swing.JLabel();
        aesPasswordLabel = new javax.swing.JLabel();
        aesPasswordField = new javax.swing.JPasswordField();
        chooseFileLabel = new javax.swing.JLabel();
        entryNameLabel = new javax.swing.JLabel();
        entryNameTextField = new javax.swing.JTextField();
        sameEntryNameCheckBox = new javax.swing.JCheckBox();
        oldEntryPasswordLabel = new javax.swing.JLabel();
        oldEntryPasswordField = new javax.swing.JPasswordField();
        newEntryPasswordLabel = new javax.swing.JLabel();
        newEntryPasswordField = new javax.swing.JPasswordField();
        sameEntryPasswordCheckBox = new javax.swing.JCheckBox();
        chooseFileSeparator1 = new javax.swing.JSeparator();
        changeFileSeparator2 = new javax.swing.JSeparator();
        changeFileSeparator3 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Import");
        setResizable(false);

        statusBarTextField.setEditable(false);
        statusBarTextField.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        statusBarTextField.setForeground(new java.awt.Color(255, 0, 0));
        statusBarTextField.setBorder(null);
        statusBarTextField.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        statusBarTextField.setMinimumSize(new java.awt.Dimension(800, 17));
        statusBarTextField.setName(""); // NOI18N
        statusBarTextField.setPreferredSize(new java.awt.Dimension(800, 17));

        chooseFilePanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        importButton.setText("Import");
        importButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        chooseFileButton.setText("Choose File...");
        chooseFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseFileButtonActionPerformed(evt);
            }
        });

        passwordLabel.setLabelFor(passwordField);
        passwordLabel.setText("File password:");

        fileNameLabel.setLabelFor(fileNameTextField);
        fileNameLabel.setText("File path:");

        aesEncryptedCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aesEncryptedCheckBoxActionPerformed(evt);
            }
        });

        aesEncryptedLabel.setLabelFor(aesEncryptedCheckBox);
        aesEncryptedLabel.setText("AES encrypted:");

        aesPasswordLabel.setLabelFor(aesPasswordField);
        aesPasswordLabel.setText("AES password:");

        aesPasswordField.setEnabled(false);

        chooseFileLabel.setText("Choose an existing file for importing:");

        entryNameLabel.setLabelFor(entryNameTextField);
        entryNameLabel.setText("Entry name:");

        sameEntryNameCheckBox.setText("Use same");
        sameEntryNameCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sameEntryNameCheckBoxActionPerformed(evt);
            }
        });

        oldEntryPasswordLabel.setLabelFor(oldEntryPasswordField);
        oldEntryPasswordLabel.setText("Entry password:");

        newEntryPasswordLabel.setLabelFor(newEntryPasswordField);
        newEntryPasswordLabel.setText("New password:");
        newEntryPasswordLabel.setToolTipText("");

        sameEntryPasswordCheckBox.setText("Use same");
        sameEntryPasswordCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sameEntryPasswordCheckBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout chooseFilePanelLayout = new javax.swing.GroupLayout(chooseFilePanel);
        chooseFilePanel.setLayout(chooseFilePanelLayout);
        chooseFilePanelLayout.setHorizontalGroup(
            chooseFilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, chooseFilePanelLayout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addComponent(importButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cancelButton)
                .addGap(99, 99, 99))
            .addGroup(chooseFilePanelLayout.createSequentialGroup()
                .addGroup(chooseFilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chooseFileSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(changeFileSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(changeFileSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(chooseFilePanelLayout.createSequentialGroup()
                        .addGroup(chooseFilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(newEntryPasswordLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(oldEntryPasswordLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(entryNameLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(aesPasswordLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(aesEncryptedLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(passwordLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(fileNameLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(chooseFilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(newEntryPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(oldEntryPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(entryNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(aesPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(aesEncryptedCheckBox)
                            .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fileNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addGroup(chooseFilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(sameEntryPasswordCheckBox)
                            .addComponent(sameEntryNameCheckBox)))
                    .addGroup(chooseFilePanelLayout.createSequentialGroup()
                        .addGap(313, 313, 313)
                        .addComponent(chooseFileButton))
                    .addGroup(chooseFilePanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(chooseFileLabel)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        chooseFilePanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {aesPasswordField, entryNameTextField, newEntryPasswordField, oldEntryPasswordField});

        chooseFilePanelLayout.setVerticalGroup(
            chooseFilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(chooseFilePanelLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(chooseFileLabel)
                .addGap(18, 18, 18)
                .addGroup(chooseFilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(fileNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fileNameLabel)
                    .addComponent(chooseFileButton))
                .addGap(18, 18, 18)
                .addGroup(chooseFilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordLabel)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(chooseFileSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                .addGroup(chooseFilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(aesEncryptedLabel)
                    .addComponent(aesEncryptedCheckBox))
                .addGap(18, 18, 18)
                .addGroup(chooseFilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aesPasswordLabel)
                    .addComponent(aesPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(changeFileSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(chooseFilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(entryNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(entryNameLabel)
                    .addComponent(sameEntryNameCheckBox))
                .addGap(10, 10, 10)
                .addComponent(changeFileSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(chooseFilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(oldEntryPasswordLabel)
                    .addComponent(oldEntryPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(chooseFilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newEntryPasswordLabel)
                    .addComponent(newEntryPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sameEntryPasswordCheckBox))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(chooseFilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(importButton)
                    .addComponent(cancelButton))
                .addContainerGap())
        );

        chooseFilePanelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {aesPasswordField, entryNameTextField, newEntryPasswordField, oldEntryPasswordField});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(statusBarTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(chooseFilePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(chooseFilePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(statusBarTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        parentFrame.setEnabled(true);
        dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void importButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_importButtonActionPerformed
        // TODO(mitap94): pokri sve use cese-ove kako u popup window i main window
        // 
        String filePath = fileNameTextField.getText();
        String filePassword = new String(passwordField.getPassword());
        
        String aesPassword = null;
        boolean aesEncrypted = aesEncryptedCheckBox.isSelected();
        if (aesEncrypted) {
            aesPassword = new String(aesPasswordField.getPassword());
        }
        
        String entryName = null;
        boolean sameEntryName = sameEntryNameCheckBox.isSelected();
        if (!sameEntryName) {
            entryName = entryNameTextField.getText();
        }
        
        String oldEntryPassword = new String(oldEntryPasswordField.getPassword());
        String newEntryPassword = null;
        boolean sameEntryPassword = sameEntryPasswordCheckBox.isSelected();
        if (sameEntryPassword) {
            newEntryPassword = oldEntryPassword;
        }
        else {
            newEntryPassword = new String(newEntryPasswordField.getPassword());
        }
        
        try {
            String alias = parentFrame.manager.importCertificate(filePath, filePassword,
                    aesEncrypted, aesPassword, sameEntryName, entryName, oldEntryPassword, 
                    newEntryPassword);
            parentFrame.updateList(alias);
                    
            parentFrame.setEnabled(true);
            this.dispose();
            
        } catch (KeyStoreException ex) {
            
        } catch (IOException ex) {
            
        } catch (NoSuchAlgorithmException ex) {
            
        } catch (CertificateException ex) {
            
        } catch (UnrecoverableKeyException ex) {
            
        } catch (FileToolNotInitializedException ex) {
            
        }
    }//GEN-LAST:event_importButtonActionPerformed

    private void chooseFileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseFileButtonActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
            "PCKS#12", "p12");
        fileChooser.setFileFilter(filter);

        File workingDirectory = new File(System.getProperty("user.dir"));
        fileChooser.setCurrentDirectory(workingDirectory);

        int returnVal = fileChooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            fileNameTextField.setText(fileChooser.getSelectedFile().getAbsolutePath());
        }
    }//GEN-LAST:event_chooseFileButtonActionPerformed

    private void sameEntryNameCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sameEntryNameCheckBoxActionPerformed
       if (sameEntryNameCheckBox.isSelected()) {
           entryNameTextField.setText("");
           entryNameTextField.setEnabled(false);
       }
       else {
           entryNameTextField.setEnabled(true);
       }
    }//GEN-LAST:event_sameEntryNameCheckBoxActionPerformed

    private void aesEncryptedCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aesEncryptedCheckBoxActionPerformed
        if (aesEncryptedCheckBox.isSelected()) {
            aesPasswordField.setEnabled(true);
        }
        else {
            aesPasswordField.setText("");
            aesPasswordField.setEnabled(false);
        }
    }//GEN-LAST:event_aesEncryptedCheckBoxActionPerformed

    private void sameEntryPasswordCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sameEntryPasswordCheckBoxActionPerformed
        if (sameEntryPasswordCheckBox.isSelected()) {
            newEntryPasswordField.setText("");
            newEntryPasswordField.setEnabled(false);
        }
        else {
            newEntryPasswordField.setEnabled(true);
        }
    }//GEN-LAST:event_sameEntryPasswordCheckBoxActionPerformed

    public void myInitComponents() {
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frameSize = this.getSize();
        leftCornerAnchor = new Point((int) (screenSize.width / 2 - frameSize.width / 2),
                (int) (screenSize.height / 2 - frameSize.height / 2));
        setLocation(leftCornerAnchor);

        WindowListener exitListener;
        exitListener = new WindowAdapter() {
            
            @Override
            public void windowClosing(WindowEvent e) {
                parentFrame.setEnabled(true);
                dispose();
            }
        };
        
        this.addWindowListener(exitListener);
        
        initFileNameListener();
    }
    
    public void initFileNameListener() {
         fileNameTextField.getDocument().addDocumentListener(new DocumentListener() {
        
        @Override
        public void changedUpdate(DocumentEvent e) {
            warn();
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            warn();
        }
        
        @Override
        public void insertUpdate(DocumentEvent e) {
            warn();
        }

        public void warn() {
            if (!fileNameTextField.getText().trim().isEmpty()) {
                File file = new File(fileNameTextField.getText());
                boolean fileExists = file.exists() && file.isFile();
                if (!fileExists) {
                    statusBarTextField.setForeground(Errors.COLOR);
                    statusBarTextField.setText(Errors.INVALID_FILE_NAME);
                }
                else {
                    statusBarTextField.setText("");
                }
            }
            else {
                statusBarTextField.setText("");
            }
        }});
     }

    private Dimension screenSize;
    private Dimension frameSize;
    private Point leftCornerAnchor;

    private final MainWindow parentFrame;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox aesEncryptedCheckBox;
    private javax.swing.JLabel aesEncryptedLabel;
    private javax.swing.JPasswordField aesPasswordField;
    private javax.swing.JLabel aesPasswordLabel;
    private javax.swing.JButton cancelButton;
    private javax.swing.JSeparator changeFileSeparator2;
    private javax.swing.JSeparator changeFileSeparator3;
    private javax.swing.JButton chooseFileButton;
    private javax.swing.JLabel chooseFileLabel;
    private javax.swing.JPanel chooseFilePanel;
    private javax.swing.JSeparator chooseFileSeparator1;
    private javax.swing.JLabel entryNameLabel;
    private javax.swing.JTextField entryNameTextField;
    private javax.swing.JLabel fileNameLabel;
    private javax.swing.JTextField fileNameTextField;
    private javax.swing.JButton importButton;
    private javax.swing.JPasswordField newEntryPasswordField;
    private javax.swing.JLabel newEntryPasswordLabel;
    private javax.swing.JPasswordField oldEntryPasswordField;
    private javax.swing.JLabel oldEntryPasswordLabel;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JCheckBox sameEntryNameCheckBox;
    private javax.swing.JCheckBox sameEntryPasswordCheckBox;
    private javax.swing.JTextField statusBarTextField;
    // End of variables declaration//GEN-END:variables
}
