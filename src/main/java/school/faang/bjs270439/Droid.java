package school.faang.bjs270439;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Droid {

    private String name;
    private static final int ALPHABET_LENGTH = 26;

    private static final DroidMessageEncryptor encryptor = (msg, key) -> {
        StringBuilder encryptedMessage = new StringBuilder();
        for (char ch : msg.toCharArray()) {
            if (Character.isLetter(ch)) {
                char base = Character.isLowerCase(ch) ? 'a' : 'A';
                encryptedMessage.append((char) ((ch - base + key) % ALPHABET_LENGTH + base));
            } else {
                encryptedMessage.append(ch);
            }
        }
        return encryptedMessage.toString();
    };

    public String encryptMessage(String message, int key) {
        return encryptor.encrypt(message, key);
    }

    public String decryptMessage(String encryptedMessage, int key) {
        return encryptor.encrypt(encryptedMessage, ALPHABET_LENGTH - key);
    }

    public void sendMessage(Droid droid, String message, int key) {
        System.out.println(name + " sent encrypted message: " + encryptMessage(message, key));
        droid.receiveMessage(encryptMessage(message, key), key);
    }

    public void receiveMessage(String encryptedMessage, int key) {
        System.out.println(name + " received decrypted message: " + decryptMessage(encryptedMessage, key));
    }
}