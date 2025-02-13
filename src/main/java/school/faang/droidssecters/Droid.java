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
    private static final int ALPHABET_SIZE = 26;

    @NonNull
    private final String name;

    public String encryptMessage(String message, int encryptionKey) {
        return processMessage(message, encryptionKey, true);
    }

    public String decryptMessage(String message, int encryptionKey) {
        return processMessage(message, encryptionKey, false);
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

    private String processMessage(String message, int key, boolean isEncrypt) {
        if (message != null && !message.trim().isEmpty()) {
            DroidMessageEncryptor droidMessageEncryptor = (originalMessage, encryptionKey, isEncryption) -> {
                StringBuilder result = new StringBuilder();
                for (int i = 0; i < originalMessage.length(); i++) {
                    char ch = originalMessage.charAt(i);
                    if (Character.isLetter(ch)) {
                        char base = Character.isLowerCase(ch) ? 'a' : 'A';
                        int offset = ch - base;
                        int adjusted = (offset + (isEncryption ? key : -key) + ALPHABET_SIZE) % ALPHABET_SIZE;
                        result.append((char) (adjusted + base));
                    } else {
                        result.append(ch);
                    }
                }
                return result.toString();
            };
            return droidMessageEncryptor.encrypt(message, key, isEncrypt);
        } else {
            log.warn("Сообщение не может быть пустым");
            return "";
        }
    }
}