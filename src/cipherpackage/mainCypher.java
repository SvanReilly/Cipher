package cipherpackage;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;


public class mainCypher {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub

        try {
            // Generar clave AES de 128 bits
            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
            keyGen.init(128);
            SecretKey secretKey = keyGen.generateKey();

            // Convertir la clave en un array de bytes
            byte[] keyBytes = secretKey.getEncoded();

            // Crear una clave cifrada a partir del array de bytes
            Key key = new javax.crypto.spec.SecretKeySpec(keyBytes, "AES");

            // Crear un mensaje original
            String mensajeOriginal = "¡Este mensaje es un mensaje del pasado enviado al futuro para que se reproduzca en tu presente, este es el presente!";

            // Cifrar el mensaje original
            String mensajeCifrado = cifrarMensaje(mensajeOriginal, key);

            // Descifrar el mensaje cifrado
            String mensajeDescifrado = descifrarMensaje(mensajeCifrado, key);

            // Imprimir los mensajes
            System.out.println("Mensaje original: " + mensajeOriginal);
            System.out.println("Mensaje cifrado: " + mensajeCifrado);
            System.out.println("Mensaje descifrado: " + mensajeDescifrado);
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		
	}

	
	
	
	
    public static String cifrarMensaje(String mensaje, Key clave) throws Exception {
        Cipher cifrador = Cipher.getInstance("AES");
        cifrador.init(Cipher.ENCRYPT_MODE, clave);
        byte[] bytesCifrados = cifrador.doFinal(mensaje.getBytes());
        return Base64.getEncoder().encodeToString(bytesCifrados);
    }
    
    public static String descifrarMensaje(String mensajeCifrado, Key clave) throws Exception {
        Cipher cifrador = Cipher.getInstance("AES");
        cifrador.init(Cipher.DECRYPT_MODE, clave);
        byte[] bytesDescifrados = cifrador.doFinal(Base64.getDecoder().decode(mensajeCifrado));
        return new String(bytesDescifrados);
    }
}
