package school.faang.BJS234160;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Droid {
    private String name;
    private static final int ALPHABET_LENGTH = 26;
    private static final char UPPERCASE_BASE = 'A';
    private static final char LOWERCASE_BASE = 'a';

    private static final DroidMessageEncryptor CAESAR_ENCRYPTOR = (msg, k) -> {
        StringBuilder result = new StringBuilder();
        for (char c : msg.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? UPPERCASE_BASE : LOWERCASE_BASE;
                result.append((char) ((c - base + k) % ALPHABET_LENGTH + base));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    };

    public String encryptMessage(DroidMessageEncryptor droidMessageEncryptor, String message, int key) {
        return droidMessageEncryptor.message(message, key);
    }

    public String decryptWithCaesar(String message, int key) {
        return encryptMessage(
                (msg, k) -> encryptMessage((m, l) -> m, msg, -k),
                message,
                key
        );
    }

    public String decryptMessage(DroidMessageEncryptor droidMessageEncryptor, String message, int key) {
        return droidMessageEncryptor.message(message, key);
    }

    public void sendMessage(Droid recipient, String message, int key) {
        String encryptedMessage = CAESAR_ENCRYPTOR.message(message, key);
        recipient.receiveMessage(encryptedMessage);
    }

    public void receiveMessage(String encryptedMessage) {
        System.out.println("Received: " + encryptedMessage);
    }

    public static void main(String[] args) {
        Droid r2d2 = new Droid("R2D2");
        Droid c3po = new Droid("C3PO");
        Droid bb8 = new Droid("BB-8");

        String message1 = "Join the Rebellion!";
        String message2 = "The Death Star is operational!";
        int encryptionKey1 = 3;
        int encryptionKey2 = 7;

        r2d2.sendMessage(c3po, message1, encryptionKey1);

        c3po.sendMessage(r2d2, message2, encryptionKey2);

        bb8.sendMessage(c3po, "The mission is complete.", encryptionKey1);
    }
}
