package crypto.utils;

import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/**
 * Tool for wrapping private key and certificate to a key store.
 * 
 * @author uros
 */
public class KeyAndCertToKeyStore {
    
    public static KeyStore wrap(PrivateKey key, X509Certificate cert, String alias, String password)
            throws KeyStoreException, IOException, NoSuchAlgorithmException, CertificateException {
        KeyStore keyStore = KeyStore.getInstance(crypto.CertManagerImpl.KEYSTORE_TYPE);
        keyStore.load(null, null);
        Certificate[] chain = new Certificate[1];
        chain[0] = cert;
        keyStore.setKeyEntry(alias, key, password.toCharArray(), chain);
        return keyStore;
    }
    
}
