package crypto;

import java.security.KeyPair;

/**
 * Dummy CertManager implementation for GUI testing.
 * 
 * @author uros
 */
public class CertManagerDummy implements CertManager {

    @Override
    public KeyPair generateKeyPair() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void importKeyPair(String path) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void exportKeyPair(String path) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
