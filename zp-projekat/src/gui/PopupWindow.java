package gui;

import crypto.CertManager;
import crypto.CertManagerImpl;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import static java.lang.System.exit;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Mita
 */
public class PopupWindow extends javax.swing.JFrame {

    /**
     * Creates new form PopupWindow
     */
    public PopupWindow() {
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
        chooseFileLabel = new javax.swing.JLabel();
        fileNameTextField = new javax.swing.JTextField();
        fileNameLabel = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();
        chooseFileButton = new javax.swing.JButton();
        openKeystoreButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("x.509 CertManager");
        setAlwaysOnTop(true);
        setResizable(false);

        statusBarTextField.setEditable(false);
        statusBarTextField.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        statusBarTextField.setForeground(new java.awt.Color(255, 0, 0));
        statusBarTextField.setBorder(null);
        statusBarTextField.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        statusBarTextField.setMinimumSize(new java.awt.Dimension(800, 17));
        statusBarTextField.setName(""); // NOI18N
        statusBarTextField.setPreferredSize(new java.awt.Dimension(800, 17));
        statusBarTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusBarTextFieldActionPerformed(evt);
            }
        });

        chooseFilePanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        chooseFileLabel.setText("Choose an existing keystore (or create a new one):");

        fileNameTextField.setText("D:\\ir3-zp-projekat\\zp-projekat\\store.p12");

        fileNameLabel.setLabelFor(fileNameTextField);
        fileNameLabel.setText("File path:");

        passwordLabel.setLabelFor(passwordField);
        passwordLabel.setText("Password:");

        passwordField.setText("PISTA");

        chooseFileButton.setText("Choose File...");
        chooseFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseFileButtonActionPerformed(evt);
            }
        });

        openKeystoreButton.setText("Open Keystore");
        openKeystoreButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openKeystoreButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout chooseFilePanelLayout = new javax.swing.GroupLayout(chooseFilePanel);
        chooseFilePanel.setLayout(chooseFilePanelLayout);
        chooseFilePanelLayout.setHorizontalGroup(
            chooseFilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(chooseFilePanelLayout.createSequentialGroup()
                .addGroup(chooseFilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(chooseFilePanelLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(chooseFileLabel))
                    .addGroup(chooseFilePanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(chooseFilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fileNameLabel)
                            .addComponent(passwordLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(chooseFilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(fileNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addGroup(chooseFilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(openKeystoreButton)
                            .addComponent(chooseFileButton))))
                .addContainerGap())
        );

        chooseFilePanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {fileNameTextField, passwordField});

        chooseFilePanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {chooseFileButton, openKeystoreButton});

        chooseFilePanelLayout.setVerticalGroup(
            chooseFilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(chooseFilePanelLayout.createSequentialGroup()
                .addGroup(chooseFilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(chooseFilePanelLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(chooseFileLabel)
                        .addGap(18, 18, 18)
                        .addGroup(chooseFilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(chooseFileButton)
                            .addComponent(fileNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(chooseFilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(passwordLabel)
                            .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(chooseFilePanelLayout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(fileNameLabel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(openKeystoreButton)
                .addContainerGap())
        );

        chooseFilePanelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {fileNameTextField, passwordField});

        chooseFilePanelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {chooseFileButton, openKeystoreButton});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(chooseFilePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(statusBarTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(chooseFilePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(statusBarTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void statusBarTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statusBarTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_statusBarTextFieldActionPerformed

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
    
    private void openKeystoreButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openKeystoreButtonActionPerformed
        String filePath = fileNameTextField.getText().trim();
        if (filePath.isEmpty()) {
            statusBarTextField.setForeground(Errors.COLOR);
            statusBarTextField.setText(Errors.NO_FILE_PATH_SPECIFIED);
            return;
        }
        String password = new String(passwordField.getPassword());
        if (password.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, Errors.INVALID_PASSWORD);
            statusBarTextField.setForeground(Errors.COLOR);
            statusBarTextField.setText(Errors.NO_PASSWORD_SPECIFIED);
            return;
        }
        CertManager manager = new CertManagerImpl(filePath, password);
        try {
            manager.init();
            MainWindow mainWindow = new MainWindow(manager);
            this.setVisible(false);
            mainWindow.setVisible(true);
            
        } catch (KeyStoreException ex) {
            JOptionPane.showMessageDialog(this, Errors.CRITICAL_ERROR);
            exit(Errors.KEY_STORE_EXCEPTION);
        } catch (IOException ex) {
            // TODO(mitap94): proveri koji exception se baca za pogresnu sifru
            JOptionPane.showMessageDialog(this, Errors.INVALID_PASSWORD);
            statusBarTextField.setCaretColor(Errors.COLOR);
            statusBarTextField.setText(ex.getCause().getLocalizedMessage() + " + " + ex.getCause().getClass());
            if (ex.getCause() instanceof UnrecoverableKeyException) {
                statusBarTextField.setForeground(Errors.COLOR);
                statusBarTextField.setText(Errors.INVALID_PASSWORD);
            }
        } catch (CertificateException ex) {
            JOptionPane.showMessageDialog(this, Errors.CERTIFICATE_CORRUPTION);
            statusBarTextField.setForeground(Errors.COLOR);
            statusBarTextField.setText(Errors.CERTIFICATE_CORRUPTION);
        } catch (NoSuchAlgorithmException ex) {
            JOptionPane.showMessageDialog(this, Errors.CRITICAL_ERROR);
            exit(Errors.NO_SUCH_ALGORITHM);
        }
    }//GEN-LAST:event_openKeystoreButtonActionPerformed

     private void myInitComponents() {
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frameSize = this.getSize();
        leftCornerAnchor = new Point((int)(screenSize.width/2 - frameSize.width/2),
                (int)(screenSize.height/2 - frameSize.height/2));
        setLocation(leftCornerAnchor);
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
                    statusBarTextField.setForeground(Messages.COLOR1);
                    statusBarTextField.setText(Messages.NEW_KEYSTORE_CREATION);
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton chooseFileButton;
    private javax.swing.JLabel chooseFileLabel;
    private javax.swing.JPanel chooseFilePanel;
    private javax.swing.JLabel fileNameLabel;
    private javax.swing.JTextField fileNameTextField;
    private javax.swing.JButton openKeystoreButton;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JTextField statusBarTextField;
    // End of variables declaration//GEN-END:variables
}
