package school.faang.task_46238;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public class Droid {
    private static final int NUMBER_OF_LETTERS_IN_ALPHABET = 26;
    private final String name;

    public Droid(String name) {
        validateName(name);
        this.name = name;
    }

    private static void validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Имя дроида не может быть null или пустым!");
        }
    }

    public void sendMessage(Droid receiver, String message, int key) {
        if (receiver == null || message == null || message.isBlank()) {
            throw new IllegalArgumentException("Некорректные значения входных параметров!");
        }

        var encryptedMessage = encryptMessage(message, key);

        log.info("Дроид {} отправил зашифрованное сообщение {}", this.getName(), encryptedMessage);
        receiver.receiveMessage(encryptedMessage, key);
    }

    public void receiveMessage(String encryptedMessage, int key) {
        if (encryptedMessage == null || encryptedMessage.isBlank()) {
            throw new IllegalArgumentException("Некорректные значения входных параметров!");
        }

        var decryptedMessage = decryptMessage(encryptedMessage, key);

        log.info("Дроид {} получил расшифрованное сообщение {}", this.getName(), decryptedMessage);
    }

    public static String encryptMessage(String message, int key) {
        if (message == null || message.isBlank()) {
            throw new IllegalArgumentException("Некорректные значения входных параметров!");
        }

        DroidMessageEncryptor encryptor = ((inputMessage, encryptionKey) -> {
            var encryptedMessage = new StringBuilder();
            for (char symbol : inputMessage.toCharArray()) {
                if (Character.isLetter(symbol)) {
                    var base = Character.isUpperCase(symbol) ? 'A' : 'a';
                    encryptedMessage.append(
                        (char) ((symbol - base + encryptionKey) % NUMBER_OF_LETTERS_IN_ALPHABET + base)
                    );
                } else {
                    encryptedMessage.append(symbol);
                }
            }
            return encryptedMessage.toString();
        });
        return encryptor.encrypt(message, key);
    }

    public static String decryptMessage(String message, int key) {
        if (message == null || message.isBlank()) {
            throw new IllegalArgumentException("Некорректные значения входных параметров!");
        }

        DroidMessageEncryptor encryptor = ((inputMessage, encryptionKey) -> {
            var encryptedMessage = new StringBuilder();
            for (char symbol : message.toCharArray()) {
                if (Character.isLetter(symbol)) {
                    var base = Character.isUpperCase(symbol) ? 'A' : 'a';
                    encryptedMessage.append(
                        (char) ((symbol - base - key + NUMBER_OF_LETTERS_IN_ALPHABET)
                            % NUMBER_OF_LETTERS_IN_ALPHABET + base)
                    );
                } else {
                    encryptedMessage.append(symbol);
                }
            }
            return encryptedMessage.toString();
        });
        return encryptor.encrypt(message, key);
    }
}
