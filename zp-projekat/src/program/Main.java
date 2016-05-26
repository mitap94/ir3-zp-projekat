package program;

import gui.Errors;
import gui.PopupWindow;
import javax.swing.JOptionPane;

import static java.lang.System.exit;
import java.security.Security;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

/**
 *
 * @author Mita
 */
public class Main {

    public static void main(String argv[]) {
        Security.addProvider(new BouncyCastleProvider());
        if (Security.getProvider("BC") == null) {
            JOptionPane.showMessageDialog(null,
            "Bouncy Castle provider is NOT available!",
            "Bouncy Castle Error",
            JOptionPane.ERROR_MESSAGE);
            exit(Errors.BOUNCY_CASTLE_NOT_AVAILABLE);
        }
        
        PopupWindow popupWindow = new PopupWindow();
        popupWindow.setVisible(true);
    }
}
