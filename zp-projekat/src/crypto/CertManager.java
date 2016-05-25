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
    void importSertificate(String path, String name);  // Imports key pair from file specified by path.
    void exportCertificate(String filePath, String filePassword, KeyStore keyPair,
            boolean aesEncrypted, String aesPassword);
            // Exports key pair (certificate) to file specified by path.
    
}
