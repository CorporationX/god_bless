package school.faang.droids_secret;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Objects;

@AllArgsConstructor
public class Droid {
    private static final Logger logger = LoggerFactory.getLogger(Droid.class);
    private static final String MSG_ERROR = "The message cannot be null or blank";
    private static final String DROID_ERROR = "The droid cannot be null";
    private static final String KEY_ERROR = "The key can be between 1 and 25";
    private static final int ALPHABET_SIZE = 26;
    private static final String ALPHABET_EN = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private final String name;

    public void sendMessage(Droid droid, String message, int key) {
        Objects.requireNonNull(droid, DROID_ERROR);
        checkValidMsg(message);
        checkValidKey(key);
        String encrypt = encryptMessage(message, key);
        logger.info("{}  отправил зашифрованное сообщение: {}", name, encrypt);
        droid.receiveMessage(encrypt, key);
    }

    public void receiveMessage(String message, int key) {
        checkValidMsg(message);
        checkValidKey(key);
        String decrypt = decryptMessage(message, key);
        logger.info("{} получил расшифрованное сообщение: {}", name, decrypt);

    }

    private String encryptMessage(String message, int key) {
        checkValidMsg(message);
        checkValidKey(key);
        DroidMessageEncryptor encryptor = (msg, encryptionKey) -> {
            StringBuilder encryptedMsg = new StringBuilder();
            for (char ch : msg.toCharArray()) {
                if (ALPHABET_EN.indexOf(ch) >= 0) {
                    char base = Character.isLowerCase(ch) ? 'a' : 'A';
                    encryptedMsg.append((char) ((ch - base + encryptionKey + ALPHABET_SIZE) % ALPHABET_SIZE + base));
                } else {
                    encryptedMsg.append(ch);
                }
            }
            return encryptedMsg.toString();
        };
        return encryptor.encrypt(message, key);
    }

    private String decryptMessage(String message, int key) {
        return encryptMessage(message, ALPHABET_SIZE - (key % ALPHABET_SIZE));
    }

    private void checkValidMsg(String msg) {
        Objects.requireNonNull(msg, MSG_ERROR);
        if (msg.isBlank()) {
            logger.error(MSG_ERROR);
            throw new IllegalArgumentException(MSG_ERROR);
        }
    }

    private void checkValidKey(int key) {
        if (key < 0 || key % ALPHABET_SIZE == 0) {
            logger.error(KEY_ERROR);
            throw new IllegalArgumentException(KEY_ERROR);
        }
    }
}
