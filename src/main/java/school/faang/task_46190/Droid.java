package school.faang.task_46190;

import lombok.AllArgsConstructor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

@AllArgsConstructor
public class Droid {
    private String name;

    private String encryptMessage(String message, int encryptionKey) throws IOException {
        DroidMessageEncryptor encryptor = (msg, key) -> {
            StringBuilder encryptedMessage = new StringBuilder();
            for (char ch : msg.toCharArray()) {
                if (Character.isLetter(ch)) {
                    char base = Character.isLowerCase(ch) ? 'a' : 'A';
                    encryptedMessage.append((char) ((ch - base + key) % 26 + base));
                } else {
                    encryptedMessage.append(ch);
                }
            }
            return encryptedMessage.toString();
        };
        return encryptor.encrypt(message, encryptionKey);
    }


    private String decryptMessage(String message, int encryptionKey) throws IOException {
        DroidMessageEncryptor decryptor = (msg, key) -> {
            StringBuilder decryptedMessage = new StringBuilder();
            for (char ch : msg.toCharArray()) {
                if (Character.isLetter(ch)) {
                    char base = Character.isLowerCase(ch) ? 'a' : 'A';
                    decryptedMessage.append((char) ((ch - base - key + 26) % 26 + base));
                } else {
                    decryptedMessage.append(ch);
                }
            }
            return decryptedMessage.toString();
        };
        return decryptor.encrypt(message, encryptionKey);
    }

    public void sendMessage(Droid droid, String message, int encryptionKey) throws IOException {
        String encryptResult = encryptMessage(message, encryptionKey);
        System.out.println(String.format("%s send a encrypted message: %s", this.name, encryptResult));
        System.out.println(String.format("%s received a decrypted message: %s", this.name, receiveMessage(encryptResult,
                encryptionKey)));
    }

    private String receiveMessage(String message, int decryptionKey) throws IOException {
        return decryptMessage(message, decryptionKey);
    }

}