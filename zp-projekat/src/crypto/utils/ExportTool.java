package crypto.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.cert.X509Certificate;

import org.bouncycastle.openssl.jcajce.JcaPEMWriter;
import org.bouncycastle.pkcs.PKCS10CertificationRequest;

/**
 * Tool for exporting certificate sign requests and certificates.
 * 
 * @author uros
 */
public class ExportTool {
    
    private static void exportObject(Object obj, String path) throws FileNotFoundException,
            IOException {
        PrintWriter fileReqWr = new PrintWriter(path);
        JcaPEMWriter reqWriter = new JcaPEMWriter(fileReqWr);
        reqWriter.writeObject(obj);
        reqWriter.close();
    }
    
    public static void exportRequest(PKCS10CertificationRequest req, String path) throws
            FileNotFoundException, IOException {
        exportObject(req, path);
    }
    
    public static void exportCert(X509Certificate cert, String path) throws FileNotFoundException,
            IOException {
        exportObject(cert, path);
    }
    
}
