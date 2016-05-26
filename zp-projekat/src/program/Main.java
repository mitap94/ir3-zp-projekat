package program;

import gui.Errors;
import gui.PopupWindow;
import static java.lang.System.exit;
import java.security.Security;

/**
 *
 * @author Mita
 */
public class Main {

    public static void main(String argv[]) {
        Security.addProvider(new BouncyCastleProvider());
        if (Security.getProvider("BC") == null) {
            System.out.println("Bouncy Castle provider is NOT available");
            exit(Errors.BOUNCY_CASTLE_NOT_AVAILABLE);
        } else {
            System.out.println("Bouncy Castle provider is available");
        }
        PopupWindow popupWindow = new PopupWindow();
        popupWindow.setVisible(true);
    }
}
