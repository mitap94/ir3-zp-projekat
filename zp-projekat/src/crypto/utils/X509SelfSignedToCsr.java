package crypto.utils;

import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.Set;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.x509.Extension;
import org.bouncycastle.asn1.x509.ExtensionsGenerator;
import org.bouncycastle.operator.ContentSigner;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.operator.jcajce.JcaContentSignerBuilder;
import org.bouncycastle.pkcs.PKCS10CertificationRequest;
import org.bouncycastle.pkcs.PKCS10CertificationRequestBuilder;
import org.bouncycastle.pkcs.jcajce.JcaPKCS10CertificationRequestBuilder;

/**
 * Generator for PKCS #10 CSR requests from x.509 self-signed certificates.
 * 
 * @author uros
 */
public class X509SelfSignedToCsr {
    
    public static final String ALGO = "SHA1withRSA";
    
    public static PKCS10CertificationRequest convert(X509Certificate cert, PrivateKey key) throws
            OperatorCreationException {
        // Takes care of extensions first.
        ExtensionsGenerator extGen = new ExtensionsGenerator();
        
        // Critical extensions first.
        Set<String> criticalExtensions = cert.getCriticalExtensionOIDs();
        for (String critExt : criticalExtensions) {
            extGen.addExtension(new Extension(
                    new ASN1ObjectIdentifier(critExt), true, cert.getExtensionValue(critExt)));
        }
        
        // Non-critical extensions.
        Set<String> nonCriticalExtensions = cert.getNonCriticalExtensionOIDs();
        for (String nonCritExt : nonCriticalExtensions) {
            extGen.addExtension(new Extension(
                    new ASN1ObjectIdentifier(nonCritExt), false, cert
                            .getExtensionValue(nonCritExt)));
        }
        
        // Builds the request.
        PKCS10CertificationRequestBuilder builder = new JcaPKCS10CertificationRequestBuilder(
                cert.getSubjectX500Principal(), cert.getPublicKey());
        builder.addAttribute(PKCSObjectIdentifiers.pkcs_9_at_extensionRequest, extGen.generate());
        JcaContentSignerBuilder csBuilder = new JcaContentSignerBuilder(ALGO);
        ContentSigner signer = csBuilder.build(key);
        return builder.build(signer);
    }
    
}
