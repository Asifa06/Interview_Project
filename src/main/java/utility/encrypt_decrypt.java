package utility;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import java.io.FileOutputStream;
import java.util.Base64;
import java.util.Properties;
import java.util.Scanner;

public class encrypt_decrypt {

    private static final String ALGORITHM = "AES";
    public static String secretKey = System.getenv("encryptionKey");
    
    public static void main(String[] args) {
    	 if (secretKey == null || secretKey.length() != 16) {
             throw new IllegalArgumentException("AES secret key not set properly in environment variables.");
         }
        Scanner scanner = new Scanner(System.in);

        try {
            // Prompt user for password
            System.out.print("Enter the password: ");
            String password = scanner.nextLine();
            
            // Use a fixed secret key (you can choose to store this securely somewhere)
              // Secret key for AES encryption (128-bit key)
            
            // Encrypt the password
            String encryptedPassword = encrypt(password, secretKey);
            System.out.println("Encrypted Password: " + encryptedPassword);
            
            // Store the encrypted password in the properties file
//            Properties properties = new Properties();
//            properties.setProperty("password", encryptedPassword);
//            try (FileOutputStream fileOut = new FileOutputStream("src/test/resources/Configuration/configuration.properties")) {
//                properties.store(fileOut, "Credentials File");
//                System.out.println("Password encrypted and stored successfully!");
//            }

            // If you want to decrypt the password later:
            String decryptedPassword = decrypt(encryptedPassword, secretKey);
            System.out.println("Decrypted Password: " + decryptedPassword);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }

    // Method to encrypt the password
    public static String encrypt(String password, String key) throws Exception {
        SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedBytes = cipher.doFinal(password.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    // Method to decrypt the password
    public static String decrypt(String encryptedPassword, String key) throws Exception {
        SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedPassword));
        return new String(decryptedBytes);
    }

    // Example: Generate a simple AES key (This should be securely stored and used)
    public static String generateKey() throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance(ALGORITHM);
        keyGenerator.init(128); // 128-bit key
        SecretKey secretKey = keyGenerator.generateKey();
        return Base64.getEncoder().encodeToString(secretKey.getEncoded());
    }
}
