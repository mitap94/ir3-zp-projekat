package gui;

import java.awt.Color;

/**
 * Error constants for GUI.
 * 
 * @author uros
 */
public class Errors {
    public static final Color COLOR = Color.red;
    
    public static final String INVALID_NUMBER_FORMAT = "Neispravan format broja.";
    public static final String INVALID_KEY_SIZE_FORMAT = "Velicina kljuca mora biti u decimalnom formatu.";
    public static final String KEY_SIZE_TOO_SMALL = "Kljuc mora biti bar 512 bita.";
    public static final String NO_KEY_NAME_SPECIFIED = "Morate dati ime kljucu!";
    public static final String NO_KEY_SIZE_SPECIFIED = "Morate zadati duzinu kljuca!";
    public static final String NO_SERIAL_NUMBER_SPECIFIED = "Morate uneti serijski broj!";
    public static final String INVALID_SERIAL_NUMBER_FORMAT = "Serijski broj mora biti u " +
            "decimalnom formatu!";
    public static final String NO_DATE_SPECIFIED = "Unesite datum vazenja sertifikata!";
    public static final String NO_COMMON_NAME_SPECIFIED = "Unesite common name!";
    public static final String NO_ORGANIZATION_NAME_SPECIFIED = "Unesite ime organizacije!";
    public static final String NO_ORGANIZATIONAL_UNIT_NAME_SPECIFIED = "Unesite OU ime!";
    public static final String NO_COUNTRY_SPECIFIED = "Unesite ime drzave!";
    public static final String NO_STATE_SPECIFIED = "Unesite state name!";
    public static final String NO_LOCALITY_SPECIFIED = "Unesite locality!";
    public static final String NO_EMAIL_SPECIFIED = "Unesite email!";
    public static final String INVALID_EMAIL_ADDRESS = "Unesite validnu email adresu!";
    public static final String INVALID_DATE_FORMAT = "Unesite datum u ispravnom formatu!";
    public static final String INVALID_DATE_ORDER = "Datum isteka ne moze biti pre datuma " 
            + "pocetka validnosti!";
    public static final String INVALID_FILE_NAME = "Nepostojeci fajl!";
    public static final String NO_KEYS_GENERATED = "Morate generisati kljuceve!";
    public static final String NOTHING_SELECTED = "Morate selektovati par kljuceva za " 
            + "eksportovanje!";
    public static final String CANNOT_OVER_WRITE = "Nije dozvoljeno eksporotovanje u " +
            "postojeci fajl!";
    public static final String SAVE_EXTENSIONS = "Sacuvajte ekstenzije pre nastavljanja!";
    
    public static final String NO_FILE_PATH_SPECIFIED = "Morate uneti putanju do fajla!";
    public static final String INVALID_FILE_PATH = "Netacna putanja do fajla!";
    public static final String NO_PASSWORD_SPECIFIED = "Morate uneti sifru!";
    public static final String INVALID_PASSWORD = "Neuspesno otvaranje!";
    public static final String CERTIFICATE_CORRUPTION = "Korupcija sertifikata unutar keystore-a!";
    public static final String CANNOT_SAVE = "Nemoguce sacuvati podatke na disk!";
    public static final String KEY_STORE_NOT_LOADED = "Keystore nije ucitan!";
    public static final String CANT_LOAD_CERTIFICATES = "Nije moguce ucitati sertifikate!";
    public static final String BUILD_ERROR = "Greska pri pravljenju sertifikata! Pokusajte opet.";
    
    public static final String CRITICAL_ERROR = "Critical error! The application will" +
            "close!";
    
    public static final int NO_SUCH_ALGORITHM = 1;
    public static final int KEY_STORE_EXCEPTION = 2;
    public static final int BOUNCY_CASTLE_NOT_AVAILABLE = 3;
}
