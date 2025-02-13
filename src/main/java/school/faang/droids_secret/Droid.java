package school.faang.droids_secret;

import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

@Data
public class Droid {
    private static final Logger logger = LoggerFactory.getLogger(Droid.class);
    private static final String MSG_ERROR = "The message cannot be null or blank";
    private static final String DROID_ERROR = "The droid cannot be null";
    private static final String KEY_ERROR = "The key can be between 1 and 25";
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
                if (Character.isLetter(ch)) {
                    char base = Character.isLowerCase(ch) ? 'a' : 'A';
                    encryptedMsg.append((char) ((ch - base + encryptionKey) % 26 + base));
                } else {
                    encryptedMsg.append(ch);
                }
            }
            return encryptedMsg.toString();
        };
        return encryptor.encrypt(message, key);
    }

    private String decryptMessage(String message, int key) {
        checkValidMsg(message);
        checkValidKey(key);
        DroidMessageEncryptor decryptor = (msg, decryptionKey) -> {
            StringBuilder decryptedMsg = new StringBuilder();
            for (char ch : msg.toCharArray()) {
                if (Character.isLetter(ch)) {
                    char base = Character.isLowerCase(ch) ? 'a' : 'A';
                    decryptedMsg.append((char) ((ch - base - decryptionKey + 26) % 26 + base));
                } else {
                    decryptedMsg.append(ch);
                }
            }
            return decryptedMsg.toString();
        };
        return decryptor.encrypt(message, key);

    }

    private void checkValidMsg(String msg) {
        Objects.requireNonNull(msg, MSG_ERROR);
        if (msg.isBlank()) {
            logger.error(MSG_ERROR);
            throw new IllegalArgumentException(MSG_ERROR);
        }
    }

    private void checkValidKey(int key) {
        if (key < 1 || key > 25) {
            logger.error(KEY_ERROR);
            throw new IllegalArgumentException(KEY_ERROR);
        }
    }
}
