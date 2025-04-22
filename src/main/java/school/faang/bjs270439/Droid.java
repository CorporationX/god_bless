package school.faang.bjs270439;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Droid {

    private String name;
    private final DroidMessageEncryptor encryptor = (msg, encryptionKey) -> {
        StringBuilder encryptedMessage = new StringBuilder();
        for (char ch : msg.toCharArray()) {
            if (Character.isLetter(ch)) {
                char base = Character.isLowerCase(ch) ? 'a' : 'A';
                encryptedMessage.append((char) ((ch - base + encryptionKey) % 26 + base));
            } else {
                encryptedMessage.append(ch);
            }
        }
        return encryptedMessage.toString();
    };

    private final DroidMessageEncryptor decryptor = (msg, decryptionKey) -> {
        StringBuilder decryptedMessage = new StringBuilder();
        for (char ch : msg.toCharArray()) {
            if (Character.isLetter(ch)) {
                char base = Character.isLowerCase(ch) ? 'a' : 'A';
                decryptedMessage.append((char) ((ch - base - decryptionKey + 26) % 26 + base));
            } else {
                decryptedMessage.append(ch);
            }
        }
        return decryptedMessage.toString();
    };

    public String encryptMessage(String message, int key) {
        return encryptor.encrypt(message, key);
    }

    public String decryptMessage(String encryptedMessage, int key) {
        return decryptor.encrypt(encryptedMessage, key);
    }

    public void sendMessage(Droid droid, String message, int key) {
        System.out.println(name + " sent encrypted message: " + encryptMessage(message, key));
        droid.receiveMessage(encryptMessage(message, key), key);
    }

    public void receiveMessage(String encryptedMessage, int key) {
        System.out.println(name + " received decrypted message: " + decryptMessage(encryptedMessage, key));
    }
}