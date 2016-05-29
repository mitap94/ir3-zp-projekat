package gui;

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
    }
    
    public void clearAll() {
        // TODO(mitap94): Clear issuerAltNames
        extensions = new boolean[3];
        critical = new boolean[3];
        keyUsage = new boolean[9];
        basicConstrCA = false;
        basicConstrDepthOfCertChain = "";
    }
    
    public boolean extensions[];
    public boolean critical[];
    
    public boolean basicConstrCA;
    public String basicConstrDepthOfCertChain;
    
    public boolean keyUsage[];
    
    // TODO(mitap94): add issuerAltNames
    
}
