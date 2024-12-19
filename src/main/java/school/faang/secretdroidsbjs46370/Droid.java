package school.faang.secretdroidsbjs46370;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Droid {
    private static final int ALPHABET_LENGTH = 26;
    private String name;

    public String encryptMessage(String message, int key) {
        return processMessage(message, key);
    }

    public String decryptMessage(String message, int key) {
        return processMessage(message, -key);
    }

    private String processMessage(String message, int key) {
        StringBuilder result = new StringBuilder();

        for (char ch : message.toCharArray()) {
            if (Character.isLetter(ch)) {
                char base = Character.isLowerCase(ch) ? 'a' : 'A';
                result.append((char) (((ch - base + key + ALPHABET_LENGTH) % ALPHABET_LENGTH) + base));
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }

    public void sendMessage(Droid recipient, String message, int key) {
        String encryptedMessage = encryptMessage(message, key);
        System.out.println(name + " sent an encrypted message: " + encryptedMessage);
        recipient.receiveMessage(encryptedMessage, key);
    }

    public void receiveMessage(String encryptedMessage, int key) {
        String decryptedMessage = decryptMessage(encryptedMessage, key);
        System.out.println(name + " take decrypted message: " + decryptedMessage);
    }
}
