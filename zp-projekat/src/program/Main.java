package program;

import crypto.CertManager;
import crypto.CertManagerImpl;
import gui.MainWindow;
import gui.PopupWindow;
import javax.swing.JOptionPane;

/**
 *
 * @author Mita
 */
public class Main {
     public static void main(String argv[]) {
        
        CertManager manager = new CertManagerImpl("store.p12", "PISTA");
        manager.init();
        PopupWindow popupWindow = new PopupWindow();
        popupWindow.setVisible(true);
        
        // CertManager manager = popupWindow.getCertManager();
        // MainWindow mainWindow = new MainWindow(manager);
        // mainWindow.setVisible(true);
     }
}
