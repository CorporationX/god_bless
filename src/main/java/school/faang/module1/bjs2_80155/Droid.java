package school.faang.module1.bjs2_80155;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@AllArgsConstructor
public class Droid {

    private String name;

    private static final int ALPHABET_SIZE = 26;

    private static final DroidMessageEncryptor ENCRYPTOR = Droid::transform;
    private static final DroidMessageEncryptor DECRYPTOR = (msg, offset) -> transform(msg, -offset);

    private String encryptMessage(String message, int key) {
        return ENCRYPTOR.transformMessage(message, key);
    }

    private String decryptMessage(String message, int key) {
        return DECRYPTOR.transformMessage(message, key);
    }

    private static String transform(String msg, int offset) {
        StringBuilder result = new StringBuilder();
        for (char currentCharacter : msg.toCharArray()) {
            if (Character.isLetter(currentCharacter)) {
                char baseChar = Character.isUpperCase(currentCharacter) ? 'A' : 'a';
                int originalAlphabetPosition = currentCharacter - baseChar;
                int newAlphabetPosition = (originalAlphabetPosition + offset) % ALPHABET_SIZE;
                if (newAlphabetPosition < 0) {
                    newAlphabetPosition += ALPHABET_SIZE;
                }
                char newCharacter = (char) (baseChar + newAlphabetPosition);
                result.append(newCharacter);
            } else {
                result.append(currentCharacter);
            }
        }
        return result.toString();
    }

    public void sendMessage(String message, int key, Droid recipient) {
        validateSendMessageParams(message, key, recipient);
        String encryptedMessage = encryptMessage(message, key);
        log.info("{} отправил {} зашифрованное сообщение: {}", name, recipient.getName(), encryptedMessage);
        recipient.receiveMessage(encryptedMessage, key);
    }

    private void receiveMessage(String message, int key) {
        String receivedMessage = decryptMessage(message, key);
        log.info("{} получил расшифрованное сообщение: {}", name, receivedMessage);
    }

    private void validateSendMessageParams(String message, int key, Droid recipient) {
        if (message == null || message.isEmpty()) {
            throw new IllegalArgumentException("Сообщение не может быть пустым или null");
        }
        if (key <= 0) {
            throw new IllegalArgumentException("Ключ шифрования должен быть положительным числом");
        }
        if (recipient == null) {
            throw new IllegalArgumentException("Получатель не может быть null");
        }
    }
}