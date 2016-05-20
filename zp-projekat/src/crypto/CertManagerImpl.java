package crypto;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * CertManager interface implementation.
 * 
 * @author uros
 */
public class CertManagerImpl implements CertManager {
    
    private static String ENCRYPTION_ALGORITHM = "RSA";
    
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
