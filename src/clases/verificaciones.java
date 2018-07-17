package clases;
import com.sun.glass.events.KeyEvent;
import static java.awt.event.KeyEvent.VK_PERIOD;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import static org.apache.commons.codec.binary.Base64.decodeBase64;
import static org.apache.commons.codec.binary.Base64.encodeBase64;
/**
 *
 * @author User
 */
public class verificaciones {
    
    public boolean vnumeros (char key){
        boolean verificado =false;
         if ( Character.isDigit(key)){
             verificado=true; 
         };
         return verificado;
    }
    
    public boolean vletras (char key){
        boolean verificado =false;
         if ( Character.isLetter(key)){
             verificado=true; 
         };
         return verificado;
    }
    public boolean vletrasynumeros (char key){
        boolean verificado =false;
         if ( Character.isLetterOrDigit(key)){
             verificado=true; 
         };
         return verificado;
    }
    
    public boolean vcorreoevent (char key){
        boolean verificado =false;
         if ( Character.isLetterOrDigit(key) || key == '@' || key == '_' || key == '.'){
             verificado=true; 
         };
         return verificado;
    }
    
    public boolean vletrase (char key){
        boolean verificado =false;
         if ( Character.isLetter(key)|| key == '.'){
             verificado=true; 
         };
         return verificado;
    }
    
    public boolean vcorreo (String key){
        boolean verificado =false;
           Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
 
        // El email a validar
       
        Matcher mather = pattern.matcher(key);
        if (mather.find() == true) {
            verificado = true;
        }
        
         return verificado;
    }
    
    // Definición del tipo de algoritmo a utilizar (AES, DES, RSA)
    private final static String alg = "AES";
    // Definición del modo de cifrado a utilizar
    private final static String cI = "AES/CBC/PKCS5Padding";
    
    public static String decrypt(String key, String iv, String encrypted) throws Exception {
            Cipher cipher = Cipher.getInstance(cI);
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes(), alg);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(iv.getBytes());
            byte[] enc = decodeBase64(encrypted);
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, ivParameterSpec);
            byte[] decrypted = cipher.doFinal(enc);
            return new String(decrypted);
    }
    
    public static String encrypt(String key, String iv, String cleartext) throws Exception {
            Cipher cipher = Cipher.getInstance(cI);
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes(), alg);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(iv.getBytes());
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, ivParameterSpec);
            byte[] encrypted = cipher.doFinal(cleartext.getBytes());
            return new String(encodeBase64(encrypted));
    }
}
