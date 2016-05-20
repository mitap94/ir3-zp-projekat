package crypto;

import java.security.KeyPair;

/**
 * Class for public/private key pair and additional information.
 * 
 * @author uros
 */
public class KeyContainer {
    
    private String keyName;
    private KeyPair keys;
    private int keySize;
    private boolean signed;

    public KeyContainer(String keyName, KeyPair keys, int keySize, boolean signed) {
        this.keyName = keyName;
        this.keys = keys;
        this.keySize = keySize;
        this.signed = signed;
    }
    
    public KeyContainer(String keyName, KeyPair keys, int keySize) {
        this.keyName = keyName;
        this.keys = keys;
        this.keySize = keySize;
        this.signed = false;
    }

    public String getKeyName() {
        return keyName;
    }

    public void setKeyName(String keyName) {
        this.keyName = keyName;
    }

    public KeyPair getKeys() {
        return keys;
    }

    public void setKeys(KeyPair keys) {
        this.keys = keys;
    }

    public int getKeySize() {
        return keySize;
    }

    public void setKeySize(int keySize) {
        this.keySize = keySize;
    }

    public boolean isSigned() {
        return signed;
    }

    public void setSigned(boolean signed) {
        this.signed = signed;
    }
        
}
