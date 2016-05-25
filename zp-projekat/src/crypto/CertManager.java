package crypto;

import java.security.KeyPair;
import java.security.KeyStore;

/**
 *
 * @author Mita
 */
public interface CertManager {
    
    void init();  // Initializes the CertManager implementation.
    KeyPair generateKeyPair(int keySize);  // Generates private-public key pair. Key size in bits.
    void importSertificate(String filePath, String filePassword, boolean aesEncrypted,
            String aesPassword, String alias, String password); 
            // Imports certificate from file at path.
    void exportCertificate(String filePath, String filePassword, KeyStore certificate,
            boolean aesEncrypted, String aesPassword); // Exports certificate to file at path.    
}
