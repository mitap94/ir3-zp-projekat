package crypto;

import java.security.KeyPair;
import java.security.KeyStore;

/**
 *
 * @author Mita
 */
public interface CertManager {
    
    // Initializes the CertManager implementation.
    void init();
    
    // Generates private-public key pair. Key size in bits.
    KeyPair generateKeyPair(int keySize);
    
    // Imports certificate from file at path.
    //
    // filePath: path to file
    // filePassword: password used for opening the PKCS #12 archive
    // aesEncrypted: indicates whether the file is AES encrypted.
    // aesPassword: AES password used for decryption (ignored if aesEnrypted is false)
    // alias: alias to be used for storing into the application permanent store
    // passwordInFile: password used to access the entry in the PKCS #12 file
    // password: password used to store the entry into the application permanent store.
    void importSertificate(String filePath, String filePassword, boolean aesEncrypted,
            String aesPassword, String alias, String passwordInFile, String password); 

    // Exports certificate to file at path.
    //
    // filePath: path to file
    // filePassword: password used for creating the PKCS #12 archive
    // certificate: private key and certficiated wrapped in a KeyStore object
    // aesEncrypted: indicates whether the PKCS #12 archive should be AES encrypted
    // aesPassword: AES password used for encryption (ignored if aesEncrypted is false)
    void exportCertificate(String filePath, String filePassword, KeyStore certificate,
            boolean aesEncrypted, String aesPassword);    
}
