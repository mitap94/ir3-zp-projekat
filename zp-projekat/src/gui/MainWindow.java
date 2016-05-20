package gui;

import java.awt.*;

/**
 *
 * @author Mita
 */
public class MainWindow extends javax.swing.JFrame {

    /**
     * Creates new form MainWindow
     */
    public MainWindow() {
        initComponents();
        myInitComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabsPanel = new javax.swing.JTabbedPane();
        certificateTab = new javax.swing.JPanel();
        keysTab = new javax.swing.JPanel();
        generatedKeysListScrollPanel = new javax.swing.JScrollPane();
        generatedKeysList = new javax.swing.JList<>();
        generatedKeysLabel = new javax.swing.JLabel();
        importExportPanel = new javax.swing.JPanel();
        importButton = new javax.swing.JButton();
        exportButton = new javax.swing.JButton();
        keyGenerationPanel = new javax.swing.JPanel();
        saveKeyButton = new javax.swing.JButton();
        publicKeyTextField = new javax.swing.JTextField();
        generateKeysButton = new javax.swing.JButton();
        privateKeyTextField = new javax.swing.JTextField();
        publicKeyLabel = new javax.swing.JLabel();
        keyNameLabel = new javax.swing.JLabel();
        keyNameTextField = new javax.swing.JTextField();
        privateKeyLabel = new javax.swing.JLabel();
        keyGenerationLabel = new javax.swing.JLabel();
        statusBarTextField = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CertManager x.509");
        setLocation(new java.awt.Point(0, 0));
        setName("Window"); // NOI18N
        setPreferredSize(new java.awt.Dimension(800, 600));

        tabsPanel.setName("tabsPanel"); // NOI18N

        javax.swing.GroupLayout certificateTabLayout = new javax.swing.GroupLayout(certificateTab);
        certificateTab.setLayout(certificateTabLayout);
        certificateTabLayout.setHorizontalGroup(
            certificateTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 810, Short.MAX_VALUE)
        );
        certificateTabLayout.setVerticalGroup(
            certificateTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 535, Short.MAX_VALUE)
        );

        tabsPanel.addTab("Certificate", certificateTab);

        generatedKeysList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        generatedKeysList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        generatedKeysList.setAutoscrolls(false);
        generatedKeysListScrollPanel.setViewportView(generatedKeysList);

        generatedKeysLabel.setText("Generated keys");

        importButton.setText("Import");

        exportButton.setText("Export");

        javax.swing.GroupLayout importExportPanelLayout = new javax.swing.GroupLayout(importExportPanel);
        importExportPanel.setLayout(importExportPanelLayout);
        importExportPanelLayout.setHorizontalGroup(
            importExportPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(importExportPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(importButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addComponent(exportButton)
                .addContainerGap())
        );
        importExportPanelLayout.setVerticalGroup(
            importExportPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(importExportPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(importExportPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(exportButton)
                    .addComponent(importButton))
                .addContainerGap())
        );

        keyGenerationPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        saveKeyButton.setText("Save Key Pair");

        publicKeyTextField.setEnabled(false);
        publicKeyTextField.setPreferredSize(new java.awt.Dimension(6, 20));
        publicKeyTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                publicKeyTextFieldActionPerformed(evt);
            }
        });

        generateKeysButton.setText("Generate Key Pair");
        generateKeysButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateKeysButtonActionPerformed(evt);
            }
        });

        privateKeyTextField.setEnabled(false);

        publicKeyLabel.setText("Public key:");

        keyNameLabel.setText("Key name:");

        keyNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keyNameTextFieldActionPerformed(evt);
            }
        });

        privateKeyLabel.setText("Private key:");

        javax.swing.GroupLayout keyGenerationPanelLayout = new javax.swing.GroupLayout(keyGenerationPanel);
        keyGenerationPanel.setLayout(keyGenerationPanelLayout);
        keyGenerationPanelLayout.setHorizontalGroup(
            keyGenerationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(keyGenerationPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(keyGenerationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, keyGenerationPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(saveKeyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(keyGenerationPanelLayout.createSequentialGroup()
                        .addComponent(privateKeyLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(privateKeyTextField))
                    .addGroup(keyGenerationPanelLayout.createSequentialGroup()
                        .addGroup(keyGenerationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(keyNameLabel)
                            .addComponent(publicKeyLabel))
                        .addGroup(keyGenerationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(keyGenerationPanelLayout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addGroup(keyGenerationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(publicKeyTextField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(keyGenerationPanelLayout.createSequentialGroup()
                                        .addComponent(generateKeysButton)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(keyGenerationPanelLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(keyNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 305, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        keyGenerationPanelLayout.setVerticalGroup(
            keyGenerationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(keyGenerationPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(keyGenerationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(keyNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(keyNameLabel))
                .addGap(18, 18, 18)
                .addComponent(generateKeysButton)
                .addGap(18, 18, 18)
                .addGroup(keyGenerationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(publicKeyTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(publicKeyLabel))
                .addGap(18, 18, 18)
                .addGroup(keyGenerationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(privateKeyTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(privateKeyLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                .addComponent(saveKeyButton)
                .addContainerGap())
        );

        keyGenerationLabel.setText("Key Generation");

        javax.swing.GroupLayout keysTabLayout = new javax.swing.GroupLayout(keysTab);
        keysTab.setLayout(keysTabLayout);
        keysTabLayout.setHorizontalGroup(
            keysTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, keysTabLayout.createSequentialGroup()
                .addGroup(keysTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(keysTabLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(keyGenerationPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18))
                    .addGroup(keysTabLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(keyGenerationLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(keysTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(importExportPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(generatedKeysListScrollPanel)
                    .addComponent(generatedKeysLabel))
                .addContainerGap())
        );
        keysTabLayout.setVerticalGroup(
            keysTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(keysTabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(keysTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(generatedKeysLabel)
                    .addComponent(keyGenerationLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(keysTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(generatedKeysListScrollPanel)
                    .addGroup(keysTabLayout.createSequentialGroup()
                        .addComponent(keyGenerationPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 82, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(importExportPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
        );

        tabsPanel.addTab("Keys", keysTab);

        statusBarTextField.setEditable(false);
        statusBarTextField.setBackground(new java.awt.Color(240, 240, 240));
        statusBarTextField.setBorder(null);

        jMenu1.setMnemonic('f');
        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setMnemonic('e');
        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        jMenu3.setMnemonic('v');
        jMenu3.setText("View");
        jMenu3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabsPanel)
            .addComponent(statusBarTextField)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tabsPanel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(statusBarTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void keyNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keyNameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_keyNameTextFieldActionPerformed

    private void generateKeysButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateKeysButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_generateKeysButtonActionPerformed

    private void publicKeyTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_publicKeyTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_publicKeyTextFieldActionPerformed
    
    public void myInitComponents() {
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frameSize = this.getSize();
        leftCornerAnchor = new Point((int)(screenSize.width/2 - frameSize.width/2), (int)(screenSize.height/2 - frameSize.height/2));
        setLocation(leftCornerAnchor);
    }
    
    Dimension screenSize;
    Dimension frameSize;
    Point leftCornerAnchor;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel certificateTab;
    private javax.swing.JButton exportButton;
    private javax.swing.JButton generateKeysButton;
    private javax.swing.JLabel generatedKeysLabel;
    private javax.swing.JList<String> generatedKeysList;
    private javax.swing.JScrollPane generatedKeysListScrollPanel;
    private javax.swing.JButton importButton;
    private javax.swing.JPanel importExportPanel;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel keyGenerationLabel;
    private javax.swing.JPanel keyGenerationPanel;
    private javax.swing.JLabel keyNameLabel;
    private javax.swing.JTextField keyNameTextField;
    private javax.swing.JPanel keysTab;
    private javax.swing.JLabel privateKeyLabel;
    private javax.swing.JTextField privateKeyTextField;
    private javax.swing.JLabel publicKeyLabel;
    private javax.swing.JTextField publicKeyTextField;
    private javax.swing.JButton saveKeyButton;
    private javax.swing.JTextField statusBarTextField;
    private javax.swing.JTabbedPane tabsPanel;
    // End of variables declaration//GEN-END:variables
}
