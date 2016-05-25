package crypto;

import java.security.KeyPair;
import java.security.KeyStore;

/**
 * Dummy CertManager implementation for GUI testing.
 * 
 * @author uros
 */
public class CertManagerDummy implements CertManager {

    @Override
    public void init() {
        
    }

    @Override
    public KeyPair generateKeyPair(int keySize) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void importKeyPair(String path, String name) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void exportKeyPair(String filePath, String filePassword, String alias,
            String aliasPassword, KeyStore keyPair, boolean aesEncrypted, String aesPassword) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
