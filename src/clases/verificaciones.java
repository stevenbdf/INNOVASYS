package clases;

import com.toedter.calendar.JDateChooser;
import static java.lang.Integer.parseInt;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Calendar;
import java.util.GregorianCalendar;
import static org.apache.commons.codec.binary.Base64.decodeBase64;
import static org.apache.commons.codec.binary.Base64.encodeBase64;
/**
 *
 * @author User
 *  sebas
 */
public class verificaciones {
    
    public boolean vnumeros (char key){
        boolean verificado =false; 
         if ( Character.isDigit(key)){
             verificado=true; 
         };
         return verificado;
    }
    
    
    public boolean vprecio (char key){
        boolean verificado =false;
         if ( Character.isDigit(key)|| key==('.')){
             verificado=true; 
         };
         return verificado;
    }
    
    public boolean vletras (char key){
        boolean verificado =false;
         if ( Character.isLetter(key) || key==(' ')){
             verificado=true; 
         };
         return verificado;
    }
    public boolean vletrasynumeros (char key){
        boolean verificado =false;
         if ( Character.isLetterOrDigit(key) || key==(' ')){
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
    
    SimpleDateFormat Formato = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat Formato2 = new SimpleDateFormat("yyyyMMdd");
    SimpleDateFormat Formato3 = new SimpleDateFormat("yyyyMMdd");
    
    public static java.util.Date sumarFechasDias(java.util.Date fch, int dias) {
        Calendar cal = new GregorianCalendar();
        cal.setTimeInMillis(fch.getTime());
        cal.add(Calendar.DATE, dias);
        return new java.util.Date (cal.getTimeInMillis());
    }
    
    public String getFecha(JDateChooser jd) {
        if (jd.getDate() != null) {
            return Formato.format(jd.getDate());
        } else {
            return null;
        }
    }
    public String getFecha3(JDateChooser jd) {
        if (jd.getDate() != null) {
            
            return Formato3.format(jd.getDate());
        } else {
            return null;
        }
    }
    public String getFecha2(JDateChooser jd) {
        if (jd.getDate() != null) {
            
            return Formato2.format(sumarFechasDias(jd.getDate(),1));
        } else {
            return null;
        }
    }
    public boolean vfecham(String fechaE,int anos){
        boolean verificado =false;
        SimpleDateFormat formato_del_Texto = new SimpleDateFormat("yyyy-MM-dd");
        Date fechas = null;
        try {
            fechas = formato_del_Texto.parse(fechaE);
        } catch (ParseException ex) {
            Logger.getLogger(verificaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String[] arrayf = fechaE.split("-");
        int ano= parseInt(arrayf[0]);
        if (ano>=anos) {
            verificado=true;
        }
        return verificado;
    }
    
    public boolean vfechamax(String fechaE){
        boolean verificado =false;
        SimpleDateFormat formato_del_Texto = new SimpleDateFormat("yyyy-MM-dd");
        Date fechas = null;
        try {
            fechas = formato_del_Texto.parse(fechaE);
        } catch (ParseException ex) {
            Logger.getLogger(verificaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        Calendar calendario = Calendar.getInstance();
        String[] arrayf = fechaE.split("-");
        int ano= parseInt(arrayf[0]);
        int anoactual= (calendario.get(Calendar.YEAR));
        int mes= parseInt(arrayf[1]);
        int mesactual= (calendario.get(Calendar.MONTH)+1);
        int dia= parseInt (arrayf[2]);
        int diaactual= (calendario.get(Calendar.DAY_OF_MONTH));
        
        if ((ano<=anoactual)&&(mes<=mesactual)&&(dia<=diaactual)) {
            verificado=true;
        }
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
        

        
        
        public java.util.Date StringADate(String fecha) {
        SimpleDateFormat formato_del_Texto = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaE = null;
        try {
            fechaE = formato_del_Texto.parse(fecha);
            return fechaE;
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return null;
        }
    }
}
