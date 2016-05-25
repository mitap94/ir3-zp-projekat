package crypto;

import java.security.KeyPair;

/**
 *
 * @author Mita
 */
public interface CertManager {
    
    void init();  // Initializes the CertManager implementation.
    KeyPair generateKeyPair(int keySize);  // Generates private-public key pair. Key size in bits.
    void importKeyPair(String path, String name);  // Imports key pair from file specified by path.
    void exportKeyPair(String path);  // Exports key pair to file specified by path.
    
}
