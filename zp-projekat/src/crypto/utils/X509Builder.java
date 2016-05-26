package crypto.utils;

import java.io.IOException;
import java.math.BigInteger;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Date;
import org.bouncycastle.asn1.x509.Extension;

/**
 * Interface for generating x.509 certificates step by step.
 * 
 * @author uros
 */
public interface X509Builder {
    
    // Sets the algorithm.
    public void setAlgorithm(int algorithm);
    
    // Sets the version of certificate.
    public void setVersion(int version);
    
    // Sets the start of certificate validity.
    public void setValidTimeframeStart(Date start);
    
    // Sets the end of certificate vaidity.
    public void setValidTimeframeEnd(Date end);
    
    // Sets the common name.
    public void setCommonName(String commonName);
    
    // Sets the organizational unit.
    public void setOrganizationalUnit(String organizationalUnit);
    
    // Sets the organization.
    public void setOrganization(String organization);
    
    // Sets the locality.
    public void setLocality(String locality);
    
    // Sets the state.
    public void setState(String state);
    
    // Sets the country name (abbreviation)
    public void setCountryName(String countryName);
    
    // Sets the email
    public void setEmail(String email);
    
    // Sets the serial number
    public void setSerialNumber(BigInteger serial);
    
    // Adds certificate extension.
    public void addExtension(Extension extension);
    
    // Builds the X.509 certificate object.
    public X509Certificate build(PrivateKey privateKey, PublicKey publicKey) throws Exception;
    
}
