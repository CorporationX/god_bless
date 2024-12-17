package school.faang.task_46190;

import lombok.AllArgsConstructor;

import java.io.IOException;

@AllArgsConstructor
public class Droid {
    private String name;
    private static final int NUMBER_OF_LETTERS = 26;
    private static final char BASE = 'a';

    private String encryptMessage(String message, int encryptionKey) throws IOException {
        DroidMessageEncryptor encryptor = (msg, key) -> {
            StringBuilder encryptedMessage = new StringBuilder();
            for (char c : msg.toLowerCase().toCharArray()) {
                if (Character.isLetter(c)) {
                    encryptedMessage.append((char) ((c - BASE + key) % NUMBER_OF_LETTERS + BASE));
                } else {
                    encryptedMessage.append(c);
                }
            }
            return encryptedMessage.toString();
        };
        return encryptor.encrypt(message, encryptionKey);
    }


    private String decryptMessage(String message, int decryptionKey) throws IOException {
        DroidMessageDecryptor decryptor = (msg, key) -> {
            StringBuilder decryptedMessage = new StringBuilder();
            for (char c : msg.toCharArray()) {
                if (Character.isLetter(c)) {
                    decryptedMessage.append((char) ((c - BASE - key + NUMBER_OF_LETTERS) % NUMBER_OF_LETTERS + BASE));
                } else {
                    decryptedMessage.append(c);
                }
            }
            return decryptedMessage.toString();
        };
        return decryptor.decrypt(message, decryptionKey);
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