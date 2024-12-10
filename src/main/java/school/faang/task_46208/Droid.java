package school.faang.task_46208;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Droid {

    private final String droid;

    public void sendMessage(String message, int key, Droid droid) {
        String encripted = encryptMessage(message, key);
        System.out.println("Sending encripted message: " + encripted);
        droid.receiveMessage(encripted, key);

    }

    public void receiveMessage(String message, int key) {
        String dencripted = decryptMessage(message, key);
        System.out.println("Droid: " + dencripted);
    }

    private String encryptMessage(String message, int key) {
        DroidMessageEncryptor encryptor = (msg, encryptionKey) -> {
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
        return encryptor.encrypt(message, key);
    }

    private String decryptMessage(String message, int key) {
        DroidMessageEncryptor decryptor = (msg, decryptionKey) -> {
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
        return decryptor.encrypt(message, key);
    }
}
