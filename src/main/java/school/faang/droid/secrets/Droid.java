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
        String encryptMessage = encryptMessage(message, key);
        log.info("{}  отправил зашифрованное сообщение {}: {}", this.name, droidReceiver.getName(), encryptMessage);
        return encryptMessage;
    }

    public String receiveMessage(String message, int key) {
        String decryptMessage = decryptMessage(message, key);
        log.info("{}  получил расшифрованное сообщение: {}", this.name, decryptMessage);
        return decryptMessage;
    }

    private String encryptMessage(String message, int key) {
        DroidMessageEncryptor encryptor = ((msg, k) -> {
            StringBuilder result = new StringBuilder();
            for (char ch : msg.toCharArray()) {
                if (Character.isLetter(ch)) {
                    char base = Character.isUpperCase(ch) ? 'A' : 'a';
                    result.append((char) ((ch - base + k) % ALPHABET_SIZE + base));
                } else {
                    result.append(ch);
                }
            }
            return result.toString();
        });
        return encryptor.encrypt(message, key);
    }

    private String decryptMessage(String message, int key) {
        DroidMessageEncryptor decryptor = ((msg, k) -> {
            StringBuilder result = new StringBuilder();
            for (char ch : msg.toCharArray()) {
                if (Character.isLetter(ch)) {
                    char base = Character.isUpperCase(ch) ? 'A' : 'a';
                    result.append((char) ((ch - base - k + ALPHABET_SIZE) % ALPHABET_SIZE + base));
                } else {
                    result.append(ch);
                }
            }
            return result.toString();
        });
        return decryptor.encrypt(message, key);
    }
}
