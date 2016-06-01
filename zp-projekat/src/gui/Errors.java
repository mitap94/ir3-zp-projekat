package gui;

import java.awt.Color;

/**
 * Error constants for GUI.
 * 
 * @author uros
 */
public class Errors {
    public static final Color COLOR = Color.red;
    
    public static final String INVALID_NUMBER_FORMAT = "Illegal number format!";
    public static final String INVALID_KEY_SIZE_FORMAT = "Key size must be in decimal format!";
    public static final String KEY_SIZE_TOO_SMALL = "Key size must be at least 512 bits!";
    public static final String NO_KEY_NAME_SPECIFIED = "Specify the key name!";
    public static final String NO_KEY_SIZE_SPECIFIED = "No key size specified!";
    public static final String NO_SERIAL_NUMBER_SPECIFIED = "Enter the serial number!";
    public static final String INVALID_SERIAL_NUMBER_FORMAT = "Serial number must be in decimal "
            + "format!";
    public static final String NO_DATE_SPECIFIED = "Specify the validity date!";
    public static final String NO_COMMON_NAME_SPECIFIED = "Enter your common name!";
    public static final String NO_ORGANIZATION_NAME_SPECIFIED = "Enter your organization!";
    public static final String NO_ORGANIZATIONAL_UNIT_NAME_SPECIFIED = "Enter you organizational "
            + "unit!";
    public static final String NO_COUNTRY_SPECIFIED = "Enter your country!";
    public static final String NO_STATE_SPECIFIED = "Enter your state name!";
    public static final String NO_LOCALITY_SPECIFIED = "Enter you locality!";
    public static final String NO_EMAIL_SPECIFIED = "Enter your email!";
    public static final String INVALID_EMAIL_ADDRESS = "Invalid email address!";
    public static final String INVALID_DATE_FORMAT = "Invalid date format!";
    public static final String INVALID_DATE_ORDER = "Invalid date order!";
    public static final String INVALID_FILE_NAME = "File doesn't exist!";
    public static final String NO_KEYS_GENERATED = "You must generate the keys!";
    public static final String NOTHING_SELECTED = "You must select a key pair for exporting!";
    public static final String CANNOT_OVER_WRITE = "Exporting to an existing file is not allowed!";
    public static final String SAVE_EXTENSIONS = "Save the extensions before continuing!";
    public static final String NO_AES_PASSWORD = "You must enter AES encryption password!";
    public static final String NO_ENTRY_NAME = "You must specify an entry name!";
    public static final String NO_OLD_PASSWORD = "You must specify the old entry password!";
    public static final String NO_NEW_PASSWORD = "You must specify the new entry password!";
    public static final String UNRECOVERABLE_KEY = "Cannot extract key!";
    public static final String FILE_TOOL_PROBLEM = "Cannot open encrypted file!";
    public static final String NO_ENTRY_SELECTED = "You must select an entry from the list!";
    public static final String CSR_ERROR = "Unable to create CSR, try again!";
    public static final String ENCODING_ERROR = "Unable to extract certificate info!";
    public static final String INVALID_DEPTH = "Depth of chain must be in decimal format!";
    public static final String EXTENSIONS_ERROR = "Unable to create extensions!";
    public static final String EXTENSION_INVALID_FORMAT = "Invalid extension format!";
    
    public static final String NO_FILE_PATH_SPECIFIED = "You must specify a file path!";
    public static final String INVALID_FILE_PATH = "Invalid file path!";
    public static final String NO_PASSWORD_SPECIFIED = "You must enter a password!";
    public static final String CANNOT_OPEN = "Cannot open the file!";
    public static final String CERTIFICATE_CORRUPTION = "Certificate corruption!!";
    public static final String CANNOT_SAVE = "Cannot save keystore to disk!";
    public static final String KEY_STORE_NOT_LOADED = "Keystore not loaded!";
    public static final String CANT_LOAD_CERTIFICATES = "Cannot load certificates!";
    public static final String BUILD_ERROR = "Error building certificate! Try again.";
    public static final String SIGNING_ERROR = "Unable to sign the certificate!";
    public static final String NO_ALIAS_SPECIFIED = "You must specify the alias of the new "
            + "certificate!";
    public static final String CSR_WRITE_ERROR = "Unable to preview CSR!";
    public static final String CSR_EXPORT_ERROR = "Unable to export CSR!";
    public static final String CERTIFICATE_PREVIEW_ERROR = "Unable to preview certificate!";
    public static final String CERTIFICATE_EXPORT_ERROR = "Unable to export certificate!";
    
    public static final String CRITICAL_ERROR = "Critical error! The application will" +
            "close!";
    
    public static final int NO_SUCH_ALGORITHM = 1;
    public static final int KEY_STORE_EXCEPTION = 2;
    public static final int BOUNCY_CASTLE_NOT_AVAILABLE = 3;
}
