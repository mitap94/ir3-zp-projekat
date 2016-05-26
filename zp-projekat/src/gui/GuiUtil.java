package gui;

import crypto.KeyContainer;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.util.Base64;
import javax.swing.AbstractAction;

import javax.swing.Action;
import javax.swing.JPopupMenu;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.text.DefaultEditorKit;

/**
 *
 * @author Mita
 */
public class GuiUtil {

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

    public static void attachPopupMenuSpecial(JTextField textField,
            KeyContainer keyContainer, int type) {
        JPopupMenu popupMenu = new JPopupMenu();

        Action copy = new MyAction(textField, keyContainer, type);

        copy.putValue(Action.NAME, "Copy");
        copy.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("control C"));
        popupMenu.add(copy);

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



    public static final String SELECT = "Select";
}
