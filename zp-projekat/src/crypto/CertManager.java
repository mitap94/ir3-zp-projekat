package crypto;

import java.security.KeyPair;

/**
 *
 * @author Mita
 */
public interface CertManager {
    
    KeyPair generateKeyPair();  // Generates private-public key pair.
    void importKeyPair(String path);  // Imports key pair from file specified by path.
    void exportKeyPair(String path);  // Exports key pair to file specified by path.
    
}
