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
    public void importSertificate(String path, String name) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void exportCertificate(String filePath, String filePassword, KeyStore keyPair,
            boolean aesEncrypted, String aesPassword) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
