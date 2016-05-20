package crypto;

import java.security.KeyPair;

/**
 * CertManager interface implementation.
 * 
 * @author uros
 */
public class CertManagerImpl implements CertManager {
    
    @Override
    public KeyPair generateKeyPair() {
        return null;
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
