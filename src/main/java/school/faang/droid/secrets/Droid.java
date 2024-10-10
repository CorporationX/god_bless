package school.faang.droid.secrets;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@AllArgsConstructor
public class Droid {
    private static final int ALPHABET_SIZE = 26;

    private String name;

    public String sendMessage(Droid droidReceiver, String message, int key) {
        String encryptedMessage = processMessage(message, key, true);
        log.info("{}  отправил зашифрованное сообщение {}: {}", this.name, droidReceiver.getName(), encryptedMessage);
        return encryptedMessage;
    }

    public String receiveMessage(String message, int key) {
        String decryptedMessage = processMessage(message, key, false);
        log.info("{}  получил расшифрованное сообщение: {}", this.name, decryptedMessage);
        return decryptedMessage;
    }

    private String processMessage(String message, int key, boolean encrypt) {
        DroidMessageEncryptor encryptor = (msg, k) -> {
            StringBuilder result = new StringBuilder();
            for (char ch : msg.toCharArray()) {
                if (Character.isLetter(ch)) {
                    char base = Character.isUpperCase(ch) ? 'A' : 'a';
                    int newCharPosition = encrypt
                            ? (ch - base + k) % ALPHABET_SIZE
                            : (ch - base - k + ALPHABET_SIZE) % ALPHABET_SIZE;
                    result.append((char) (newCharPosition + base));
                } else {
                    result.append(ch);
                }
            }
            return result.toString();
        };
        return encryptor.encrypt(message, key);
    }
}
