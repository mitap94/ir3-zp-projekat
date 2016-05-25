package crypto.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.SecureRandom;
import java.security.spec.KeySpec;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * Provides input/output streams for storing keys/certificates, optionally AES encrypted.
 * 
 * @author uros
 */
public class KeyStoreFileTool {
    
    public static final int IO_INPUT = 1;
    public static final int IO_OUTPUT = 2;
    
    public static final String AES_KEY_DERIVATION_ALGORITHM = "PBKDF2WithHmacSHA1";
    public static final String AES_KEY_DERIVATION_SALT = "abcdef";  // Placeholder
    public static final int AES_KEY_DERIVATION_ITERATIONS = 65536;
    public static final int AES_KEY_LENGTH = 128;
    public static final String AES_KEY_ALGORITHM = "AES";
    public static final String AES_CBC_MODE = "AES/CBC/PKCS5Padding";
    
    private String fileName;
    private boolean aesEncrypted;
    private String aesPassword;
    private int io;
    
    private FileInputStream fileInputStream;
    private FileOutputStream fileOutputStream;
    private CipherInputStream inputCipherStream;
    private CipherOutputStream outputCipherStream;
    private InputStream inputStream;
    private OutputStream outputStream;
    
    public KeyStoreFileTool(String fileName, boolean aesEncrypted, String aesPassword, int io) {
        this.fileName = fileName;
        this.aesEncrypted = aesEncrypted;
        this.aesPassword = aesPassword;
        this.io = io;
    }
    
    public boolean init() {
        try {
            SecretKey derivedKey = null;
            
            if (aesEncrypted) {  // Derives AES key from password if stream is encrypted.
                SecretKeyFactory factory = SecretKeyFactory.getInstance(
                        AES_KEY_DERIVATION_ALGORITHM);
                KeySpec spec = new PBEKeySpec(
                        aesPassword.toCharArray(),
                        AES_KEY_DERIVATION_SALT.getBytes(),
                        AES_KEY_DERIVATION_ITERATIONS,
                        AES_KEY_LENGTH);
                SecretKey tempSecretKey = factory.generateSecret(spec);
                derivedKey = new SecretKeySpec(tempSecretKey.getEncoded(), AES_KEY_ALGORITHM);
            }
            
            if (io == IO_INPUT) {  // Prepares the tool to generate input stream.
                fileInputStream = new FileInputStream(fileName);
                
                if (aesEncrypted) {
                    Cipher cipher = Cipher.getInstance(AES_CBC_MODE);
                    
                    // Reads IV from the beginning of the file.
                    byte[] ivRead = new byte[cipher.getBlockSize()];
                    fileInputStream.read(ivRead);
                    
                    cipher.init(Cipher.DECRYPT_MODE, derivedKey, new IvParameterSpec(ivRead));
                    inputCipherStream = new CipherInputStream(fileInputStream, cipher);
                    inputStream = inputCipherStream;
                } else {
                    inputStream = fileInputStream;
                }
            } else if (io == IO_OUTPUT) {  // Prepares the tool to generate output stream.
                fileOutputStream = new FileOutputStream(fileName);
                
                if (aesEncrypted) {
                    Cipher cipher = Cipher.getInstance(AES_CBC_MODE);
                    SecureRandom random = new SecureRandom();
                    
                    // Writes IV to the beginning of the file.
                    byte[] ivBytes = new byte[cipher.getBlockSize()];
                    random.nextBytes(ivBytes);
                    IvParameterSpec iv = new IvParameterSpec(ivBytes);
                    cipher.init(Cipher.ENCRYPT_MODE, derivedKey, iv);
                    fileOutputStream.write(iv.getIV());
                    
                    outputCipherStream = new CipherOutputStream(fileOutputStream, cipher);
                    outputStream = outputCipherStream;
                } else {
                    outputStream = fileOutputStream;
                }
            }
        } catch (Exception e) {
            return false;
        }

        return true;
    }
    
    public InputStream getInputStream() {
        return inputStream;
    }
    
    public OutputStream getOutputStream() {
        return outputStream;
    }
    
    public boolean close() {
        try {
            if (io == IO_INPUT) {
                if (aesEncrypted) {
                    inputCipherStream.close();
                }
                fileInputStream.close();
            } else if (io == IO_OUTPUT) {
                if (aesEncrypted) {
                    outputCipherStream.close();
                }
                fileOutputStream.close();
            }
        } catch (Exception e) {
            return false;
        }
        
        return true;
    }
}
