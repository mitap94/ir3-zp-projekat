package crypto;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.KeyPair;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

/**
 *
 * @author Mita
 */
public interface CertManager {
    
    // Initializes the CertManager implementation.
    //
    // Exceptions:
    // KeyStoreException: problems with initilizating the key/certificate store.
    // FileNotFoundException: directory in which the key store file should be created doesn't exist.
    // IOException: problems with reading the existing, or creating a new key/cert store file.
    // CertificateException: problems with reading/writing certificates from the store.
    // NoSuchAlgorithmException: same as CertificateException problems.
    // KeyStoreException: problems with KeyStore operations.
    void init() throws KeyStoreException, FileNotFoundException, IOException, CertificateException,
            NoSuchAlgorithmException, KeyStoreException;
    
    // Generates private-public key pair. Key size in bits.
    //
    // Exceptions:
    // NoSuchAlgorithmException: RSA algorithm not available for key generation.
    KeyPair generateKeyPair(int keySize) throws NoSuchAlgorithmException;
    
    // Imports certificate from file at path.
    //
    // filePath: path to file
    // filePassword: password used for opening the PKCS #12 archive
    // aesEncrypted: indicates whether the file is AES encrypted.
    // aesPassword: AES password used for decryption (ignored if aesEnrypted is false)
    // alias: alias to be used for storing into the application permanent store
    // passwordInFile: password used to access the entry in the PKCS #12 file
    // password: password used to store the entry into the application permanent store.
    //
    // Exceptions:
    // KeyStoreException: problems with KeyStore operations.
    // IOException: problems with reading the file.
    // NoSuchAlgorithmException: KeyStore problems.
    // CertificateException: problems with importing certificates.
    // Unrecoverable key exception: cannot extract the key from file (e.g. empty file)
    void importSertificate(String filePath, String filePassword, boolean aesEncrypted,
            String aesPassword, String alias, String passwordInFile, String password) throws
                KeyStoreException, IOException, NoSuchAlgorithmException, CertificateException,
                UnrecoverableKeyException; 

    // Exports certificate to file at path.
    //
    // filePath: path to file
    // filePassword: password used for creating the PKCS #12 archive
    // certificate: private key and certficiated wrapped in a KeyStore object
    // aesEncrypted: indicates whether the PKCS #12 archive should be AES encrypted
    // aesPassword: AES password used for encryption (ignored if aesEncrypted is false)
    //
    // Exceptions:
    // KeyStoreException: problems with KeyStore operations.
    // IOException: problems with file.
    // NoSuchAlgorithmException: same as KeyStoreException.
    // CertificateException: problems with certificates.
    void exportCertificate(String filePath, String filePassword, KeyStore certificate,
            boolean aesEncrypted, String aesPassword) throws KeyStoreException, IOException,
                NoSuchAlgorithmException, CertificateException;
    
    // Saves key/certificate store to permanent storage.
    void saveStore();
}
