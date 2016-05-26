package crypto.utils;

import java.math.BigInteger;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.X509Certificate;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x500.X500NameBuilder;
import org.bouncycastle.asn1.x500.style.BCStyle;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.Extension;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.cert.X509v3CertificateBuilder;
import org.bouncycastle.cert.jcajce.JcaX509CertificateConverter;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.util.PrivateKeyFactory;
import org.bouncycastle.operator.ContentSigner;
import org.bouncycastle.operator.DefaultDigestAlgorithmIdentifierFinder;
import org.bouncycastle.operator.DefaultSignatureAlgorithmIdentifierFinder;
import org.bouncycastle.operator.bc.BcRSAContentSignerBuilder;

/**
 * x.509 certificate builder, uses Bouncy Castle
 * 
 * @author uros
 */
public class BouncyCastleX509Builder implements X509Builder {
    
    public static final String ALGO = "SHA1withRSA";
    public static final String BC_PROVIDER = "BC";
    
    private String commonName;
    private String orgUnit;
    private String organization;
    private String locality;
    private String state;
    private String country;
    private String email;
    private BigInteger serial;
    private Date start, end;
    
    List<Extension> extensions;
    
    public BouncyCastleX509Builder() {
        extensions = new LinkedList<>();
    }
    
    @Override
    public void setAlgorithm(int algorithm) {  // Wil always be RSA/SHA-1, param ignored.
        
    }

    @Override
    public void setVersion(int version) {  // Will always be v3, param ignored.

    }

    @Override
    public void setValidTimeframeStart(Date start) {
        this.start = start;
    }

    @Override
    public void setValidTimeframeEnd(Date end) {
        this.end = end;
    }

    @Override
    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    @Override
    public void setOrganizationalUnit(String organizationalUnit) {
        orgUnit = organizationalUnit;
    }

    @Override
    public void setOrganization(String organization) {
        this.organization = organization;
    }

    @Override
    public void setLocality(String locality) {
        this.locality = locality;
    }

    @Override
    public void setState(String state) {
        this.state = state;
    }

    @Override
    public void setCountryName(String countryName) {
        this.country = countryName;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public void setSerialNumber(BigInteger serial) {
        this.serial = serial;
    }
    
    @Override
    public void addExtension(Extension extension) {
        extensions.add(extension);
    }

    @Override
    public X509Certificate build(PrivateKey privateKey, PublicKey publicKey) throws Exception {
        // Builds the x.500 name.
        X500NameBuilder nameBuilder = new X500NameBuilder(X500Name.getDefaultStyle());
        nameBuilder.addRDN(BCStyle.CN, commonName);
        nameBuilder.addRDN(BCStyle.OU, orgUnit);
        nameBuilder.addRDN(BCStyle.O, organization);
        nameBuilder.addRDN(BCStyle.L, locality);
        nameBuilder.addRDN(BCStyle.ST, state);
        nameBuilder.addRDN(BCStyle.C, country);
        nameBuilder.addRDN(BCStyle.E, email);
        X500Name name = nameBuilder.build();
        
        // Builds the actual certificate.
        SubjectPublicKeyInfo publicKeyInfo = SubjectPublicKeyInfo.getInstance(
                ASN1Sequence.getInstance(publicKey.getEncoded()));
        X509v3CertificateBuilder certBuilder = new X509v3CertificateBuilder(
                name /* Issuer */,
                serial /* Serial number */,
                start /* Validity start date */,
                end /* Validity end date */,
                name /* Certificate subject */,
                publicKeyInfo /* Public key info */
        );
        
        // Self-signs the certificate.
        AlgorithmIdentifier sigAlgId = new DefaultSignatureAlgorithmIdentifierFinder().find(ALGO);
        AlgorithmIdentifier digAlgId = new DefaultDigestAlgorithmIdentifierFinder().find(sigAlgId);
        AsymmetricKeyParameter privateKeyAsymKeyParam =
                PrivateKeyFactory.createKey(privateKey.getEncoded());
        ContentSigner sigGen =
                new BcRSAContentSignerBuilder(sigAlgId, digAlgId).build(privateKeyAsymKeyParam);
        
        // Adds extensions to the certificate.
        for (Extension ext : extensions) {
            certBuilder.addExtension(ext);
        }
        
        // Builds the certificate.
        X509CertificateHolder certHolder = certBuilder.build(sigGen);
        
        // Converts cert holder to x.509 certificate.
        return new JcaX509CertificateConverter().setProvider(BC_PROVIDER)
                .getCertificate(certHolder);
    }
        
}
