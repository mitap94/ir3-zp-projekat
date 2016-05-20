package crypto;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;

/**
 * CertManager interface implementation.
 * 
 * @author uros
 */
public class CertManagerImpl implements CertManager {
    
    private static String ENCRYPTION_ALGORITHM = "RSA";
    private static String KEYSTORE_FILE = "my_keystore";
    private static String KEYSTORE_TYPE = "pkcs12";
    private static String KEYSTORE_PASSWORD = "pista";
    
    private KeyStore keyStore;
    
    public CertManagerImpl() {
        // Initializes the key store.
        try {
            keyStore = KeyStore.getInstance(KEYSTORE_TYPE);
        } catch (KeyStoreException e) {
            System.err.println(Errors.KEY_STORE_ERROR + " " + e.toString());
            System.exit(Errors.KEY_STORE_ERROR_CODE);
        }
        
        // Loads the key store from file, or creates a new key store file, if file doesn't exist.
        try {
            loadKeyStoreFromFile();
        } catch (FileNotFoundException e) {  // Key store file not found.
            try { // Attempts to create the key store file.
                createNewKeyStore();
                loadKeyStoreFromFile();
            } catch (FileNotFoundException eNested) {  // Key store file still not found, error.
                System.err.println(Errors.KEY_STORE_FILE_ERROR + " " + eNested.toString());
                System.exit(Errors.KEY_STORE_FILE_ERROR_CODE);
            } catch (IOException eNested) {  // Key Store file cannot be opened, error.
                System.err.println(Errors.KEY_STORE_FILE_ERROR + " " + eNested.toString());
                System.exit(Errors.KEY_STORE_FILE_ERROR_CODE);
            }
        } catch (IOException e) {  // Key store file cannot be opened, error.
            System.err.println(Errors.KEY_STORE_FILE_ERROR + " " + e.toString());
            System.exit(Errors.KEY_STORE_FILE_ERROR_CODE);
        }
    }
    
    private void loadKeyStoreFromFile() throws FileNotFoundException, IOException {
        FileInputStream inputStream = new FileInputStream(KEYSTORE_FILE);
        try {
            keyStore.load(inputStream, KEYSTORE_PASSWORD.toCharArray());
        } catch (CertificateException | NoSuchAlgorithmException e) {
            System.err.println(Errors.KEY_STORE_ERROR + " " + e.toString());
            System.exit(Errors.KEY_STORE_ERROR_CODE);
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }
    
    private void createNewKeyStore() throws FileNotFoundException, IOException {
        FileOutputStream outputStream = new FileOutputStream(KEYSTORE_FILE);
        try {
            keyStore.load(null, KEYSTORE_PASSWORD.toCharArray());
            keyStore.store(outputStream, KEYSTORE_PASSWORD.toCharArray());
        }
        catch (CertificateException | NoSuchAlgorithmException | KeyStoreException e) {
            System.err.println(Errors.KEY_STORE_ERROR + " " + e.toString());
            System.exit(Errors.KEY_STORE_ERROR_CODE);
        } finally {
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }
    
    @Override
    public KeyPair generateKeyPair(int keySize) {
        KeyPair generatedKeyPair = null;
        
        try {
            SecureRandom randomGenerator = new SecureRandom();
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance(ENCRYPTION_ALGORITHM);
            keyGen.initialize(keySize, randomGenerator);
            generatedKeyPair = keyGen.generateKeyPair();
        } catch (NoSuchAlgorithmException e) { }
        
        return generatedKeyPair;
    }

    @Override
    public void importKeyPair(String path, String name) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void exportKeyPair(String path) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
