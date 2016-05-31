package gui;

import crypto.KeyContainer;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.Base64;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JPopupMenu;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.text.DefaultEditorKit;
import org.bouncycastle.asn1.x509.GeneralName;

/**
 *
 * @author Mita
 */
public class GuiUtil {
    
    public static String getExtensionsToStr(X509Certificate certificate) {
        StringBuilder extToStringBuilder = new StringBuilder();
        Set criticalExtensions = certificate.getCriticalExtensionOIDs();

        try {
            // Basic constrains
            extToStringBuilder.append("Basic constraints:\n");
            if ((criticalExtensions != null) && (criticalExtensions.contains("2.5.29.19")))
                extToStringBuilder.append("* Critical\n");
            int basicConstraints = certificate.getBasicConstraints();
            if (basicConstraints == -1) {
                extToStringBuilder.append("* Not CA\n");
            } else {
                extToStringBuilder.append("* CA: " + basicConstraints + '\n');
            }

            // Key usage
            extToStringBuilder.append("--------------------------\n");
            extToStringBuilder.append("Key usage:\n");
            if ((criticalExtensions != null) && (criticalExtensions.contains("2.5.29.15")))
                extToStringBuilder.append("* Critical\n");

            boolean[] keyUsageBits = certificate.getKeyUsage();
            if (keyUsageBits != null) {
                for (int i = 0; i < keyUsageBits.length; i++) {
                    if (keyUsageBits[i]) {
                        switch (i) {
                            case 0:
                                extToStringBuilder.append("* Digital signature\n");
                                break;
                            case 1:
                                extToStringBuilder.append("* Non repudiation\n");
                                break;
                            case 2:
                                extToStringBuilder.append("* Key encipherment\n");
                                break;
                            case 3:
                                extToStringBuilder.append("* Data encipherment\n");
                                break;
                            case 4:
                                extToStringBuilder.append("* Key agreement\n");
                                break;
                            case 5:
                                extToStringBuilder.append("* Key cert sign\n");
                                break;
                            case 6:
                                extToStringBuilder.append("* cRL sign\n");
                                break;
                            case 7:
                                extToStringBuilder.append("* Encipher only\n");
                                break;
                            case 8:
                                extToStringBuilder.append("* Decipher only\n");
                                break;
                        }
                    }
                }
            }

            // Alternative issuer names.
            extToStringBuilder.append("--------------------------\n");
            extToStringBuilder.append("Alternative issuer names:\n");
            if ((criticalExtensions != null) && (criticalExtensions.contains("2.5.29.18")))
                extToStringBuilder.append("* Critical\n");

            LinkedList issuerAltList = new LinkedList();
            Collection c = null;

            try {
                c = certificate.getIssuerAlternativeNames();

                if (c != null) {
                    Iterator i = c.iterator();

                    while (i.hasNext()) {
                        List list = (List) i.next();
                        int type = ((Integer) list.get(0)).intValue();
                        String stringValue = (String) list.get(1);

                        switch (type) {
                            case GeneralName.otherName:
                                extToStringBuilder.append("* General name: " + stringValue + "\n");
                                break;
                            case GeneralName.rfc822Name:
                                extToStringBuilder.append("* RFC822 name: " + stringValue + "\n");
                                break;
                            case GeneralName.dNSName:
                                extToStringBuilder.append("* DNS name: " + stringValue + "\n");
                                break;
                            case GeneralName.x400Address:
                                extToStringBuilder.append("* x400 Address name: " + stringValue + "\n");
                                break;
                            case GeneralName.directoryName:
                                extToStringBuilder.append("* Directory name: " + stringValue + "\n");
                                break;
                            case GeneralName.ediPartyName:
                                extToStringBuilder.append("* Edit party name: " + stringValue + "\n");
                                break;
                            case GeneralName.uniformResourceIdentifier:
                                extToStringBuilder.append("* Uniform resource identifier: " + stringValue + "\n");
                                break;
                            case GeneralName.iPAddress:
                                extToStringBuilder.append("* IP address: " + stringValue + "\n");
                                break;
                            case GeneralName.registeredID:
                                extToStringBuilder.append("* Registered ID: " + stringValue + "\n");
                                break;
                        }
                    }
                }
            } catch (CertificateParsingException e) { }
        } catch (Exception e) {
            return "No extensions!";
        }

        return extToStringBuilder.toString();
    }
    
    
    public static void attachPopupMenu(JTextField textField) {
        JPopupMenu popupMenu = new JPopupMenu();

        if (textField.isEditable()) {
            Action cut = new DefaultEditorKit.CutAction();

            cut.putValue(Action.NAME, "Cut");
            cut.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("control X"));
            popupMenu.add(cut);
            // popupMenu.add(new JSeparator());
        }

        Action copy = new DefaultEditorKit.CopyAction();
    
        
        copy.putValue(Action.NAME, "Copy");
        copy.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("control C"));
        popupMenu.add(copy);
        // popupMenu.add(new JSeparator());

        if (textField.isEditable()) {
            Action paste = new DefaultEditorKit.PasteAction();

            paste.putValue(Action.NAME, "Paste");
            paste.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("control V"));
            popupMenu.add(paste);
        }

        textField.setComponentPopupMenu(popupMenu);
    }

    public static class MyAction extends AbstractAction {

        public MyAction(JTextField textField, KeyContainer keyContainer, int type) {
            this.textField = textField;
            this.keyContainer = keyContainer;
            this.type = type;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            StringSelection stringSelection;
            if (type == 1) {
                stringSelection = new StringSelection(Base64.getEncoder()
                        .encodeToString(keyContainer.getKeys().getPrivate().getEncoded()));
            } else {
                stringSelection = new StringSelection(Base64.getEncoder()
                        .encodeToString(keyContainer.getKeys().getPublic().getEncoded()));
            }
            Clipboard clipBoard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipBoard.setContents(stringSelection, null);
        }

        private JTextField textField;
        private KeyContainer keyContainer;
        int type;
    }
    
    public static void attachPopupMenu(JTextArea textArea) {
        JPopupMenu popupMenu = new JPopupMenu();

        if (textArea.isEditable()) {
            Action cut = new DefaultEditorKit.CutAction();

            cut.putValue(Action.NAME, "Cut");
            cut.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("control X"));
            popupMenu.add(cut);
            // popupMenu.add(new JSeparator());
        }

        Action copy = new DefaultEditorKit.CopyAction();

        copy.putValue(Action.NAME, "Copy");
        copy.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("control C"));
        popupMenu.add(copy);
        // popupMenu.add(new JSeparator());

        if (textArea.isEditable()) {
            Action paste = new DefaultEditorKit.PasteAction();

            paste.putValue(Action.NAME, "Paste");
            paste.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("control V"));
            popupMenu.add(paste);
        }

        textArea.setComponentPopupMenu(popupMenu);
    }
    
    public static void attachPopupMenuSpecial(JTextField textField,
            KeyContainer keyContainer, int type) {
        JPopupMenu popupMenu = new JPopupMenu();

        Action copy = new MyAction(textField, keyContainer, type);

        copy.putValue(Action.NAME, "Copy");
        copy.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("control C"));
        popupMenu.add(copy);

        textField.setComponentPopupMenu(popupMenu);
    }

    public static final String SELECT = "Select";
}
