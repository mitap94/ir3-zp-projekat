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
    void importKeyPair(String path, String name);  // Imports key pair from file specified by path.
    void exportKeyPair(String filePath, String filePassword, String alias, String aliasPassword,
            KeyStore keyPair, boolean aesEncrypted, String aesPassword);
            // Exports key pair to file specified by path.
    
}
