package crypto;

import java.security.KeyPair;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.Enumeration;

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
    public Enumeration<String> getCerts() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public boolean isCaSigned(String certAlias) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public PrivateKey getPrivateKey(String alias, String entryPassword) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Certificate[] getCertificateChain(String alias) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void storeKeyCertificate(PrivateKey key, X509Certificate cert, String alias,
            String password) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    
    
    @Override
    public String importCertificate(String filePath, String filePassword, boolean aesEncrypted,
            String aesPassword, boolean preserveAlias, String alias, String passwordInFile,
            String password) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void exportCertificate(String filePath, String filePassword, KeyStore certificate,
            boolean aesEncrypted, String aesPassword) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public void saveStore() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
