package school.faang.droidssecret;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@AllArgsConstructor
@Getter
public class Droid {

    private static final Logger logger = LoggerFactory.getLogger(Droid.class);
    private static final int ALPHABET_SIZE = 26;

    private final String name;

    public void sendMessage(Droid droid, String inputMessage, int key) {
        if (droid == null || inputMessage == null) {
            throw new NullPointerException("Требуемое значение не передано!");
        }
        String outputMessage = encryptMessage(inputMessage, key);
        logger.info("Дроид {} отправил сообщение: {}", this.name, outputMessage);
        receiveMessage(droid, outputMessage, key);
    }

    private void receiveMessage(Droid droid, String inputMessage, int key) {
        logger.info("Дроид {} получил сообщение: {}", droid.getName(), decryptMessage(inputMessage, key));
    }

    private String encryptMessage(String inputMessage, int key) {
        DroidMessageEncryptor droidMessageEncryptor = (message, encryptionKey) -> {
            StringBuilder encryptedMessage = new StringBuilder();
            for (int i = 0; i < message.length(); i++) {
                char inputSymbol = message.charAt(i);
                if (Character.isLetter(inputSymbol)) {
                    char base = Character.isLowerCase(inputSymbol) ? 'a' : 'A';
                    encryptedMessage.append((char) ((inputSymbol - base + encryptionKey) % ALPHABET_SIZE + base));
                } else {
                    encryptedMessage.append(inputSymbol);
                }
            }
            return encryptedMessage.toString();
        };
        return droidMessageEncryptor.encrypt(inputMessage, key);
    }

    private String decryptMessage(String inputMessage, int key) {
        DroidMessageEncryptor droidMessageEncryptor = (message, decryptionKey) -> {
            StringBuilder encryptedMessage = new StringBuilder();
            for (int i = 0; i < message.length(); i++) {
                char inputSymbol = message.charAt(i);
                if (Character.isLetter(inputSymbol)) {
                    char base = Character.isLowerCase(inputSymbol) ? 'a' : 'A';
                    encryptedMessage.append((char) ((inputSymbol - base - decryptionKey + ALPHABET_SIZE)
                            % ALPHABET_SIZE + base));
                } else {
                    encryptedMessage.append(inputSymbol);
                }
            }
            return encryptedMessage.toString();
        };
        return droidMessageEncryptor.encrypt(inputMessage, key);
    }
}
