package crypto;

import java.io.File;
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
    private static String KEYSTORE_TYPE = "pkcs12";
    
    private String keyStoreFilePath, keyStorePassword;
    private KeyStore keyStore;
    
    public CertManagerImpl(String keyStoreFilePath, String keyStorePassword) {
        this.keyStoreFilePath = keyStoreFilePath;
        this.keyStorePassword = keyStorePassword; 
    }
    
    @Override
    public void init() {
        // Initiastaticlizes the key store.
        try {
            keyStore = KeyStore.getInstance(KEYSTORE_TYPE);
        } catch (KeyStoreException e) {
            System.err.println(Errors.KEY_STORE_ERROR + " " + e.toString());
            System.exit(Errors.KEY_STORE_ERROR_CODE);
        }
        
        // Loads the key store object (creates a key store file if it doesn't exist).
        File file = new File(keyStoreFilePath);
        boolean fileExists = file.exists() && file.isFile();
        
        if (fileExists) {
            try {
                loadKeyStoreFromFile();
            } catch (IOException e) {
                System.err.println(Errors.KEY_STORE_FILE_ERROR + " " + e.toString());
                System.exit(Errors.KEY_STORE_FILE_ERROR_CODE);
            }
        } else {
            try {
                createNewKeyStore();
            } catch (IOException e) {
                System.err.println(Errors.KEY_STORE_FILE_ERROR + " " + e.toString());
                System.exit(Errors.KEY_STORE_FILE_ERROR_CODE);
            }
        }
    }
    
    private void loadKeyStoreFromFile() throws FileNotFoundException, IOException {
        FileInputStream inputStream = new FileInputStream(keyStoreFilePath);
        try {
            keyStore.load(inputStream, keyStorePassword.toCharArray());
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
        FileOutputStream outputStream = new FileOutputStream(keyStoreFilePath);
        try {
            keyStore.load(null, keyStorePassword.toCharArray());
            keyStore.store(outputStream, keyStorePassword.toCharArray());
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
    public void exportKeyPair(String filePath, String filePassword, String alias,
            String aliasPassword, KeyStore keyPair, boolean aesEncrypted, String aesPassword) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
