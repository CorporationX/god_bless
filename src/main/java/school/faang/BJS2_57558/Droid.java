package school.faang.BJS2_57558;

import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Getter
@ToString
public class Droid {

    private final String name;

    public Droid(@NonNull String name) {
        this.name = name;
    }

    public String encryptMessage(String message, int key) {
        return processCipher(message, key);
    }

    public String decryptMessage(String message, int key) {
        key = -key;
        return processCipher(message, key);
    }

    public String processCipher(String message, int key) {
        DroidMessageEncryptor droidMessage = (msg, encryptor) -> {
            StringBuilder sb = new StringBuilder();
            for (char c : message.toCharArray()) {
                if (Character.isLetter(c)) {
                    char base = Character.isUpperCase(c) ? 'A' : 'a';
                    char encrypted = (char) ((c - base + key + 26) % 26 + base);
                    sb.append(encrypted);
                } else {
                    sb.append(c);
                }
            }
            return sb.toString();
        };
        return droidMessage.handleMessage(message, key);
    }

    public void sendMessage(Droid recipientDroid, String message, int key) {
        String encryptMessage = encryptMessage(message, key);
        System.out.printf("%s отправил зашифрованное сообщение: %s\n", this.getName(), encryptMessage);
        String original = receiveMessage(encryptMessage, key);
        System.out.printf("%s получил расшифрованное сообщение: %s\n", recipientDroid.getName(), original);
    }

    public String receiveMessage(String encryptMessage, int key) {
        String originalMessage = decryptMessage(encryptMessage, key);
        return originalMessage;
    }
}
