package school.faang.secretsdroids;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

@Slf4j
@Getter
@Setter
public class Droid {
    private final String name;
    private String receivedMessage;

    private static final int MIN_VALUE_UPPER_ALPHABET = 65;
    private static final int MAX_VALUE_UPPER_ALPHABET = 90;

    private static final int MIN_VALUE_LOWER_ALPHABET = 97;
    private static final int MAX_VALUE_LOWER_ALPHABET = 122;

    private static final int SIZE_ALPHABET = 26;


    public Droid(String name) {
        this.name = name;
    }

    private String encryptMessage(String message, int key) {

        DroidMessageEncryptor encryptor = (messageForEncryptor, keyEncryptor) -> {
            StringBuilder encryptorMessage = new StringBuilder();
            char[] messageChar = messageForEncryptor.toCharArray();
            for (int i = 0; i < messageForEncryptor.length(); i++) {
                char character = messageChar[i];
                if (!Character.isLetter(character)) {
                    encryptorMessage.append(character);
                } else {
                    if (Character.isLowerCase(character)
                            && character + keyEncryptor > MAX_VALUE_LOWER_ALPHABET) {
                        int different = character + keyEncryptor - MAX_VALUE_LOWER_ALPHABET;
                        messageChar[i] = (char) (MIN_VALUE_LOWER_ALPHABET + different - 1);
                    } else if (Character.isUpperCase(character)
                            && character + keyEncryptor > MAX_VALUE_UPPER_ALPHABET) {
                        int different = character + keyEncryptor - MAX_VALUE_UPPER_ALPHABET;
                        messageChar[i] = (char) (MIN_VALUE_UPPER_ALPHABET + different - 1);
                    } else {
                        char tmp = messageChar[i];
                        messageChar[i] = (char) (tmp + keyEncryptor);
                    }
                    encryptorMessage.append(messageChar[i]);
                }
            }
            return encryptorMessage.toString();
        };
        return encryptor.makeEncrypting(message, key);
    }

    private String decryptMessage(String encryptMessage, int key) {
        StringBuilder messageAfterDecrypt = new StringBuilder();

        char[] messageChar = encryptMessage.toCharArray();
        for (int i = 0; i < encryptMessage.length(); i++) {
            char character = messageChar[i];
            if (!Character.isLetter(character)) {
                messageAfterDecrypt.append(character);
            } else {
                if (Character.isLowerCase(character) && character - key < MIN_VALUE_LOWER_ALPHABET) {
                    messageChar[i] = (char) (character - key + SIZE_ALPHABET);
                } else if (Character.isUpperCase(character) && character - key < MIN_VALUE_UPPER_ALPHABET) {
                    messageChar[i] = (char) (character - key + SIZE_ALPHABET);
                } else {
                    char tmp = messageChar[i];
                    messageChar[i] = (char) (tmp - key);
                }
                messageAfterDecrypt.append(messageChar[i]);
            }
        }
        return messageAfterDecrypt.toString();
    }

    void sendMessage(Droid droid, String message, int key) {
        int newKey = key % SIZE_ALPHABET;
        validMessage(message);
        validDroid(droid);
        String messageAfterEncryptor = encryptMessage(message, newKey);
        String receivedMessage = droid.receiveMessage(messageAfterEncryptor, newKey);
        droid.setReceivedMessage(receivedMessage);
        log.info("{} отправил зашифрованное сообщение: {}", this.name, messageAfterEncryptor);
        log.info("{} получил расшифрованное сообщение: {}", droid.name, receivedMessage);

    }

    private String receiveMessage(String encryptMessage, int key) {
        return decryptMessage(encryptMessage, key);
    }

    private void validMessage(String message) {
        if (message == null || message.isBlank()) {
            throw new IllegalArgumentException("Сообщение не может быть пустым");
        }
    }

    private void validDroid(Droid droid) {
        Objects.requireNonNull(droid, "Дроид не может быть null");
    }
}