package Crypto;

import java.security.InvalidKeyException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class cSeguridad {
    
    String llaveSimetrica;
    SecretKeySpec key;
    Cipher cipher;
    
//    public cSeguridad() throws NoSuchAlgorithmException, NoSuchPaddingException
//    {
//        this.llaveSimetrica = "magiaPokemon1234";
//        this.key = new SecretKeySpec(llaveSimetrica.getBytes(), "AES");
//        cipher = Cipher.getInstance("AES");
//    }
//    
//    public cSeguridad(String llave) throws NoSuchAlgorithmException, NoSuchPaddingException
//    {
//        this.llaveSimetrica = llave;
//        this.key = new SecretKeySpec(llaveSimetrica.getBytes(), "AES");
//        cipher = Cipher.getInstance("AES");
//    }
//    
//    public String cifrar(String mensaje)
//    {
//        String mensajeCifrado = null;
//        try
//        {
//           cipher.init(Cipher.ENCRYPT_MODE, key);
//           byte[] campoCifrado = cipher.doFinal(mensaje.getBytes());
//           mensajeCifrado = new String(campoCifrado);
//        }
//        catch(InvalidKeyException | IllegalBlockSizeException | BadPaddingException e)
//        {
//            e.printStackTrace();
//        }
//        return mensajeCifrado;
//    }
//    
//    public String descifrar(String mensaje)
//    {
//        String mensajeDescifrado = null;
//        try
//        {
//            cipher.init(Cipher.DECRYPT_MODE, key);
//            byte[] datosDecifrados = cipher.doFinal(mensaje.getBytes());
//            mensajeDescifrado = new String(datosDecifrados); 
//        }
//        catch(InvalidKeyException | IllegalBlockSizeException | BadPaddingException e)
//        {
//            e.printStackTrace();
//        }
//        return mensajeDescifrado;
//    }
    
    public String cifrarSHA1(String input) throws NoSuchAlgorithmException {
        MessageDigest mDigest = MessageDigest.getInstance("SHA1");
        byte[] result = mDigest.digest(input.getBytes());
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < result.length; i++) {
            sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
        }
         
        return sb.toString();
    }
}
