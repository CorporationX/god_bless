package school.faang.droidssecters;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Getter
@ToString
@Slf4j
public class Droid {
    private static final String EMPTY_MESSAGE_WARN = "Сообщение не может быть пустым!";

    @NonNull
    private final String name;

    public String encryptMessage(String message, int encryptionKey) {
        DroidMessageEncryptor droidMessageEncryptor = (message1, encryptionKey1) -> {
            StringBuilder encrypted = new StringBuilder();
            for (int i = 0; i < message1.length(); i++) {
                char ch = message1.charAt(i);
                if (Character.isLetter(ch)) {
                    char base = Character.isLowerCase(ch) ? 'a' : 'A';
                    ch = (char) ((ch - base + encryptionKey1) % 26 + base);
                }
                encrypted.append(ch);
            }
            return encrypted.toString();
        };
        return droidMessageEncryptor.encrypt(message, encryptionKey);
    }

    public String decryptMessage(String message, int encryptionKey) {
        DroidMessageEncryptor droidMessageEncryptor = (message1, encryptionKey1) -> {
            StringBuilder decoded = new StringBuilder();
            for (int i = 0; i < message1.length(); i++) {
                char ch = message1.charAt(i);
                if (Character.isLetter(ch)) {
                    char base = Character.isUpperCase(ch) ? 'A' : 'a';
                    char newCh = (char) ((ch - base - encryptionKey1 + 26) % 26 + base);
                    decoded.append(newCh);
                } else {
                    decoded.append(ch);
                }
            }
            return decoded.toString();
        };
        return droidMessageEncryptor.encrypt(message, encryptionKey);
    }

    public void sendMessage(
            @NonNull String message,
            int encryptionKey,
            @NonNull Droid droid
    ) {
        if (isMessageEmpty(message)) {
            return;
        }

        String encryptedMessage = encryptMessage(message, encryptionKey);
        log.info("{} отправил зашифрованное сообщение: {}", this.getName(), encryptedMessage);
        droid.receiveMessage(encryptedMessage, encryptionKey);
    }

    public void receiveMessage(
            @NonNull String encryptedMessage,
            int encryptionKey
    ) {
        if (isMessageEmpty(encryptedMessage)) {
            return;
        }

        String message = decryptMessage(encryptedMessage, encryptionKey);
        log.info("{} получил расшифрованное сообщение: {}", this.getName(), message);
    }

    private boolean isMessageEmpty(String message) {
        if (message.trim().isEmpty()) {
            log.warn(EMPTY_MESSAGE_WARN);
            return true;
        }
        return false;
    }
}
