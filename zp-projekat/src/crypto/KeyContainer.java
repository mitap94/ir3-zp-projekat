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
    private boolean signed;

    public KeyContainer(String keyName, KeyPair keys, boolean signed) {
        this.keyName = keyName;
        this.keys = keys;
        this.signed = signed;
    }
    
    public KeyContainer(String keyName, KeyPair keys) {
        this.keyName = keyName;
        this.keys = keys;
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

    public boolean isSigned() {
        return signed;
    }

    public void setSigned(boolean signed) {
        this.signed = signed;
    }
        
}
