package crypto.utils;

import java.io.IOException;
import java.math.BigInteger;
import java.security.PrivateKey;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Date;
import java.util.Enumeration;

import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.pkcs.Attribute;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.Extension;
import org.bouncycastle.asn1.x509.Extensions;
import org.bouncycastle.asn1.x509.KeyUsage;
import org.bouncycastle.cert.CertIOException;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.cert.X509v3CertificateBuilder;
import org.bouncycastle.cert.jcajce.JcaX509CertificateConverter;
import org.bouncycastle.cert.jcajce.JcaX509CertificateHolder;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.util.PrivateKeyFactory;
import org.bouncycastle.operator.ContentSigner;
import org.bouncycastle.operator.DefaultDigestAlgorithmIdentifierFinder;
import org.bouncycastle.operator.DefaultSignatureAlgorithmIdentifierFinder;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.operator.bc.BcRSAContentSignerBuilder;
import org.bouncycastle.pkcs.PKCS10CertificationRequest;

/**
 *
 * @author uros
 */
public class X509Signer {
    
    public static final String ALGO = "SHA1withRSA";
    public static final String BC_PROVIDER = "BC";
    
    public static X509Certificate sign(PKCS10CertificationRequest req, X509Certificate signInfo,
            PrivateKey privateKey, BigInteger serial, Date validStart, Date validEnd) throws
            CertificateEncodingException, CertIOException, IOException, OperatorCreationException,
            CertificateException {  
        // Gets subject and issuer data.
        X509CertificateHolder certHolder = new JcaX509CertificateHolder(signInfo);
        X500Name issuer = certHolder.getIssuer();
        X500Name subjectName = req.getSubject();
        
        // Prepares signed certificate building.
        X509v3CertificateBuilder certBuilder = new X509v3CertificateBuilder(
                issuer /* Issuer */,
                serial /* Serial number */,
                validStart /* Validity start */,
                validEnd /* Validity end */,
                subjectName /* Subject */,
                req.getSubjectPublicKeyInfo() /* Public key info */
        );
        
        // Process extensions, CA signed bit must be 1 and critical.
        Attribute[] extensionsAttribArray =
                req.getAttributes(PKCSObjectIdentifiers.pkcs_9_at_extensionRequest);
        boolean processKeyUsageExtensions = false;
        if ((extensionsAttribArray != null) && (extensionsAttribArray.length > 0)) {
            Attribute extensionsAttrib = extensionsAttribArray[0];
            Extensions extensions = Extensions.getInstance(
                    extensionsAttrib.getAttrValues().getObjectAt(0));
            Enumeration oids = extensions.oids();
            while (oids.hasMoreElements()) {
                ASN1ObjectIdentifier oid = (ASN1ObjectIdentifier) oids.nextElement();
                Extension ext = extensions.getExtension(oid);
                if (ext.getExtnId().equals(Extension.keyUsage)) {  // Key usage extension found!
                    processKeyUsageExtensions = true;
                    KeyUsage keyUsageExt = KeyUsage.fromExtensions(extensions);

                    int keyUsageMask = 0;
                    if (keyUsageExt.hasUsages(KeyUsage.digitalSignature)) {
                        keyUsageMask |= KeyUsage.digitalSignature;
                    }
                    if (keyUsageExt.hasUsages(KeyUsage.nonRepudiation)) {
                        keyUsageMask |= KeyUsage.nonRepudiation;
                    }
                    if (keyUsageExt.hasUsages(KeyUsage.keyEncipherment)) {
                        keyUsageMask |= KeyUsage.keyEncipherment;
                    }
                    if (keyUsageExt.hasUsages(KeyUsage.dataEncipherment)) {
                        keyUsageMask |= KeyUsage.dataEncipherment;
                    }
                    if (keyUsageExt.hasUsages(KeyUsage.keyAgreement)) {
                        keyUsageMask |= KeyUsage.keyAgreement;
                    }
                    keyUsageMask |= KeyUsage.keyCertSign;
                    if (keyUsageExt.hasUsages(KeyUsage.cRLSign)) {
                        keyUsageMask |= KeyUsage.cRLSign;
                    }
                    if (keyUsageExt.hasUsages(KeyUsage.encipherOnly)) {
                        keyUsageMask |= KeyUsage.encipherOnly;
                    }
                    if (keyUsageExt.hasUsages(KeyUsage.decipherOnly)) {
                        keyUsageMask |= KeyUsage.decipherOnly;
                    }
                    KeyUsage keyUsageExtGenerated = new KeyUsage(keyUsageMask);
                    certBuilder.addExtension(
                            new Extension(Extension.keyUsage, true, keyUsageExtGenerated.getEncoded()));
                } else {
                    certBuilder.addExtension(oid, ext.isCritical(), ext.getParsedValue());
                }
            }
        }
        if (!processKeyUsageExtensions) {
            KeyUsage keyUsageExt = new KeyUsage(KeyUsage.keyCertSign);
            certBuilder.addExtension(
                    new Extension(Extension.keyUsage, true, keyUsageExt.getEncoded()));
        }
        
        // Self-signs the certificate.
        AlgorithmIdentifier sigAlgId = new DefaultSignatureAlgorithmIdentifierFinder().find(ALGO);
        AlgorithmIdentifier digAlgId = new DefaultDigestAlgorithmIdentifierFinder().find(sigAlgId);
        AsymmetricKeyParameter privateKeyAsymKeyParam =
                PrivateKeyFactory.createKey(privateKey.getEncoded());
        ContentSigner sigGen =
                new BcRSAContentSignerBuilder(sigAlgId, digAlgId).build(privateKeyAsymKeyParam);
        
        // Builds the certificate
        X509CertificateHolder signedCertHolder = certBuilder.build(sigGen);
        
        // Converts cert holder to x.509 certificate.
        return new JcaX509CertificateConverter().setProvider(BC_PROVIDER)
                .getCertificate(signedCertHolder);
    }
    
}
