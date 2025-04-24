package school.faang.bjs2_70458;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class Droid {

    private final String name;
    private final DroidMessageEncryptor encryptor = this::encryptMessage;
    private final DroidMessageEncryptor decryptor = this::decryptMessage;

    public void sendMessage(Droid receiver, String message, int key) {
        String encryptedMessage = encryptor.process(message, key);
        log.info("{} отправил зашифрованное сообщение: {}\n", name, encryptedMessage);
        receiver.receiveMessage(encryptedMessage, key);
    }

    public void receiveMessage(String message, int key) {
        String decryptedMessage = decryptor.process(message, key);
        log.info("{} получил расшифрованное сообщение: {}\n", name, decryptedMessage);
    }

    
    public String encryptMessage(String message, int encryptionKey) {
        StringBuilder encryptedMessage = new StringBuilder();
        for (char character : message.toCharArray()) {
            char encryptedAsciiChar = character;
            if (Character.isLetter(character)) {
                int encryptedChar = character + encryptionKey;
                if (Character.isUpperCase(character)) {
                    if (encryptedChar > 90) {
                        encryptedChar = (encryptedChar % 90) + 64;
                    }
                } else {
                    if (encryptedChar > 122) {
                        encryptedChar = (encryptedChar % 122) + 96;
                    }
                }
                encryptedAsciiChar = (char) encryptedChar;
            }
            encryptedMessage.append(encryptedAsciiChar);
        }
        return encryptedMessage.toString();
    }

    public String decryptMessage(String message, int decipherKey) {
        StringBuilder decryptedMessage = new StringBuilder();
        for (char character : message.toCharArray()) {
            char encryptedAsciiChar = character;
            if (Character.isLetter(character)) {
                int decryptedChar = character - decipherKey;
                if (Character.isUpperCase(character)) {
                    if (decryptedChar < 65) {
                        decryptedChar = 91 - (65 - decryptedChar);
                    }
                } else {
                    if (decryptedChar < 97) {
                        decryptedChar = 122 - (97 - decryptedChar);
                    }
                }
                encryptedAsciiChar = (char) decryptedChar;
            }
            decryptedMessage.append(encryptedAsciiChar);
        }
        return decryptedMessage.toString();
    }
}
