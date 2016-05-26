package crypto;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.util.Enumeration;

import crypto.exceptions.FileToolNotInitializedException;
import crypto.utils.KeyStoreFileTool;

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
    public void init() throws KeyStoreException, FileNotFoundException, IOException,
            CertificateException, NoSuchAlgorithmException {
        // Initiastaticlizes the key store.
        keyStore = KeyStore.getInstance(KEYSTORE_TYPE);
        
        // Loads the key store object (creates a key store file if it doesn't exist).
        File file = new File(keyStoreFilePath);
        boolean fileExists = file.exists() && file.isFile();
        
        if (fileExists) {
            loadKeyStoreFromFile();
        } else {
            createNewKeyStore();
        }
    }
    
    private void loadKeyStoreFromFile() throws FileNotFoundException, IOException,
            CertificateException, NoSuchAlgorithmException {
        FileInputStream inputStream = new FileInputStream(keyStoreFilePath);
        keyStore.load(inputStream, keyStorePassword.toCharArray());
        inputStream.close();
    }
    
    private void createNewKeyStore() throws FileNotFoundException, IOException,
            CertificateException, NoSuchAlgorithmException, KeyStoreException {
        FileOutputStream outputStream = new FileOutputStream(keyStoreFilePath);
        keyStore.load(null, keyStorePassword.toCharArray());
        keyStore.store(outputStream, keyStorePassword.toCharArray());
        outputStream.close();
    }
    
    @Override
    public KeyPair generateKeyPair(int keySize) throws NoSuchAlgorithmException {
        KeyPair generatedKeyPair = null;
        
        SecureRandom randomGenerator = new SecureRandom();
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance(ENCRYPTION_ALGORITHM);
        keyGen.initialize(keySize, randomGenerator);
        generatedKeyPair = keyGen.generateKeyPair();
        
        return generatedKeyPair;
    }

    @Override
    public void importSertificate(String filePath, String filePassword, boolean aesEncrypted,
            String aesPassword, String alias, String passwordInFile, String password) throws
                KeyStoreException, IOException, NoSuchAlgorithmException, CertificateException,
                UnrecoverableKeyException, FileToolNotInitializedException {
        KeyStoreFileTool fileTool = new KeyStoreFileTool(filePath, aesEncrypted, aesPassword,
                KeyStoreFileTool.IO_INPUT);
        boolean fileToolInitialized = fileTool.init();

        if (fileToolInitialized) {
            InputStream inputStream = fileTool.getInputStream();

            // Opens the given file and extracts private key and certificate.
            KeyStore certificateStore = KeyStore.getInstance(KEYSTORE_TYPE);
            certificateStore.load(inputStream, filePassword.toCharArray());
            Enumeration<String> aliases = certificateStore.aliases();
            String aliasInFile = (String) aliases.nextElement();  // Gets the entry's alias.
            aliasInFile = (aliasInFile.isEmpty()) ? "" : aliasInFile;
            Key keyFromFile = certificateStore.getKey(aliasInFile,
                    passwordInFile.toCharArray());  // Extracts the private key from file.
            Certificate[] certFromFile = certificateStore.getCertificateChain(aliasInFile);

            // Stores the imported private key and assigned certificate to permanent store.
            keyStore.setKeyEntry(alias, keyFromFile, password.toCharArray(), certFromFile);
        }

        fileTool.close();
    }

    @Override
    public void exportCertificate(String filePath, String filePassword, KeyStore certificate,
            boolean aesEncrypted, String aesPassword) throws KeyStoreException, IOException,
                NoSuchAlgorithmException, CertificateException, FileToolNotInitializedException {
        KeyStoreFileTool fileTool = new KeyStoreFileTool(filePath, aesEncrypted, aesPassword,
            KeyStoreFileTool.IO_OUTPUT);
        boolean fileToolInitialized = fileTool.init();
        
        if (fileToolInitialized) {
            OutputStream outputStream = fileTool.getOutputStream();
            certificate.store(outputStream, filePassword.toCharArray());
        }
        
        fileTool.close();
    }

    @Override
    public void saveStore() throws FileNotFoundException, KeyStoreException, IOException,
            NoSuchAlgorithmException, CertificateException {
        FileOutputStream outputStream = null;
        
        outputStream = new FileOutputStream(keyStoreFilePath);
        keyStore.store(outputStream, keyStorePassword.toCharArray());
        outputStream.close();
    }
    
}
