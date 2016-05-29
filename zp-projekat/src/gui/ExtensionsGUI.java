package gui;

import org.bouncycastle.asn1.x509.Extension;

/**
 *
 * @author Mita
 */
public class ExtensionsGUI {
    
    public ExtensionsGUI() {
        extensions = new boolean[3];
        critical = new boolean[3];
        keyUsage = new boolean[9];
        basicConstrCA = false;
        basicConstrDepthOfCertChain = "";
        issuerAltNamesString = "";
        issuerAltNames = null;
    }
    
    public void clearAll() {
        // TODO(mitap94): Clear issuerAltNames
        extensions = new boolean[3];
        critical = new boolean[3];
        keyUsage = new boolean[9];
        basicConstrCA = false;
        basicConstrDepthOfCertChain = "";
        issuerAltNamesString = "";
        issuerAltNames = null;
    }
    
    public boolean extensions[];
    public boolean critical[];
    
    public boolean basicConstrCA;
    public String basicConstrDepthOfCertChain;
    
    public boolean keyUsage[];
    
    public String issuerAltNamesString;
    public Extension issuerAltNames;
}
