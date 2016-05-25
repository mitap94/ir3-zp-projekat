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
    public static final String KEY_SIZE_FORMAT = "Velicina kljuca mora biti u decimalnom formatu.";
    public static final String KEY_SIZE_TOO_SMALL = "Kljuc mora biti bar 512 bita.";
    public static final String NO_KEY_NAME_SPECIFIED = "Morate dati ime kljucu!";
    public static final String NO_FILE_PATH_SPECIFIED = "Morate uneti putanju do fajla!";
    public static final String INVALID_FILE_PATH = "Netacna putanja do fajla!";
    public static final String NO_PASSWORD_SPECIFIED = "Morate uneti sifru!";
    public static final String INVALID_PASSWORD = "Uneli ste pogresnu sifru!";
    public static final String CERTIFICATE_CORRUPTION = "Korupcija sertifikata unutar keystore-a!";
    
    public static final String CRITICAL_ERROR = "Critical error! The application will" +
            "close!";
    
    public static final int NO_SUCH_ALGORITHM = 1;
    public static final int KEY_STORE_EXCEPTION = 2;
}
