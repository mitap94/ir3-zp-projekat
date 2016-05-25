package crypto;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;

import crypto.utils.KeyStoreFileTool;
import java.security.Key;
import java.security.cert.Certificate;
import java.util.Enumeration;

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
    public void importSertificate(String filePath, String filePassword, boolean aesEncrypted,
            String aesPassword, String alias, String passwordInFile, String password) {
        KeyStoreFileTool fileTool = new KeyStoreFileTool(filePath, aesEncrypted, aesPassword,
                KeyStoreFileTool.IO_INPUT);
        boolean fileToolInitialized = fileTool.init();

        if (fileToolInitialized) {
            InputStream inputStream = fileTool.getInputStream();
            try {
                // Opens the given file and extracts private key and certificate.
                KeyStore certificateStore = KeyStore.getInstance(KEYSTORE_TYPE);
                certificateStore.load(inputStream, filePassword.toCharArray());
                Enumeration<String> aliases = certificateStore.aliases();
                String aliasInFile = (String) aliases.nextElement();  // Gets the entry's alias.
                Key keyFromFile = certificateStore.getKey(aliasInFile,
                        passwordInFile.toCharArray());  // Extracts the private key from file.
                Certificate[] certFromFile = certificateStore.getCertificateChain(aliasInFile);
                
                // Stores the imported private key and assigned certificate to permanent store.
                keyStore.setKeyEntry(alias, keyFromFile, password.toCharArray(), certFromFile);
            } catch (Exception e) {  // TODO(popovicu): don't crash the program.
                System.err.println(Errors.KEY_STORE_FILE_ERROR + " " + e.toString());
                System.exit(Errors.KEY_STORE_FILE_ERROR_CODE);
            }
        }

        fileTool.close();
    }

    @Override
    public void exportCertificate(String filePath, String filePassword, KeyStore certificate,
            boolean aesEncrypted, String aesPassword) {
        KeyStoreFileTool fileTool = new KeyStoreFileTool(filePath, aesEncrypted, aesPassword,
            KeyStoreFileTool.IO_OUTPUT);
        boolean fileToolInitialized = fileTool.init();
        
        if (fileToolInitialized) {
            OutputStream outputStream = fileTool.getOutputStream();
            try {
                certificate.store(outputStream, filePassword.toCharArray());
            } catch (Exception e) {  // TODO(popovicu): don't crash the program.
                System.err.println(Errors.KEY_STORE_FILE_ERROR + " " + e.toString());
                System.exit(Errors.KEY_STORE_FILE_ERROR_CODE);
            }
        }
        
        fileTool.close();
    }

    @Override
    public void saveStore() {
        FileOutputStream outputStream = null;
        
        try {
            outputStream = new FileOutputStream(keyStoreFilePath);
            keyStore.store(outputStream, keyStorePassword.toCharArray());
            outputStream.close();
        } catch (CertificateException | NoSuchAlgorithmException | KeyStoreException e) {
            System.err.println(Errors.KEY_STORE_ERROR + " " + e.toString());
            System.exit(Errors.KEY_STORE_ERROR_CODE);
        } catch (IOException e) {  // TODO(popovicu): Better error reports.
            System.err.println(Errors.KEY_STORE_ERROR + " " + e.toString());
            System.exit(Errors.KEY_STORE_ERROR_CODE);
        }
    }
    
}
