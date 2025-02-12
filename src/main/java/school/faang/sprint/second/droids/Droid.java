package school.faang.sprint.second.droids;

import lombok.Data;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class Droid {
    private static final String REGEX = "[a-zA-z]+";
    @NonNull
    private String name;

    public Droid(@NonNull String name) {
        validateNameNotBlank(name);
        this.name = name;
    }

    public void sendMessage(@NonNull Droid droid, @NonNull String message, int encryptionKey) {
        validateMessageNotBlank(message);
        validateEncryptKey(encryptionKey);

        String encryptedMessage = encryptMessage(message, encryptionKey);
        log.info("{} отправил зашифрованное сообщение: {}", getName(), encryptedMessage);
        droid.receiveMessage(encryptedMessage, encryptionKey);
    }

    private String encryptMessage(@NonNull String message, int encryptionKey) {
        DroidMessageEncryptor droidMessageEncoder = (msg, key) -> {
            String[] splitMessage = msg.split("");
            StringBuilder encryptedMessage = new StringBuilder();

            for (String letter : splitMessage) {
                if (letter.matches(REGEX)) {
                    encryptedMessage.append(encryptLetter(letter, key));
                } else {
                    encryptedMessage.append(letter);
                }
            }

            return encryptedMessage.toString();
        };

        return droidMessageEncoder.encrypt(message, encryptionKey);
    }

    private String decryptMessage(@NonNull String message, int encryptionKey) {
        DroidMessageEncryptor droidMessageDecoder = (msg, key) -> {
            String[] splitMessage = msg.split("");
            StringBuilder encryptedMessage = new StringBuilder();

            for (String letter : splitMessage) {
                if (letter.matches(REGEX)) {
                    encryptedMessage.append(decryptLetter(letter, key));
                } else {
                    encryptedMessage.append(letter);
                }
            }

            return encryptedMessage.toString();
        };

        return droidMessageDecoder.encrypt(message, encryptionKey);
    }

    private void receiveMessage(@NonNull String message, int encryptionKey) {
        String decryptedMessage = decryptMessage(message, encryptionKey);
        log.info("{} получил расшифрованное сообщение: {}", getName(), decryptedMessage);
    }

    private String encryptLetter(String letter, int nextIndex) {
        char next = letter.charAt(0);
        for (int i = 0; i < nextIndex; i++) {
            if (next == 122) {
                next = 'a';
            } else if (next == 90) {
                next = 'A';
            } else {
                ++next;
            }
        }
        return String.valueOf(next);
    }

    private String decryptLetter(String letter, int previousIndex) {
        char next = letter.charAt(0);
        for (int i = 0; i < previousIndex; i++) {
            if (next == 97) {
                next = 'z';
            } else if (next == 65) {
                next = 'Z';
            } else {
                --next;
            }
        }
        return String.valueOf(next);
    }

    private void validateNameNotBlank(@NonNull String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Droid name cannot be blank");
        }
    }

    private void validateMessageNotBlank(@NonNull String message) {
        if (message.isBlank()) {
            throw new IllegalArgumentException("Droid message cannot be blank");
        }
    }

    private void validateEncryptKey(int encryptKey) {
        if (encryptKey < 0) {
            throw new IllegalArgumentException("Droid encrypt key cannot be negative");
        }
    }
}
