package school.faang.bjs2_80117;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Droid {
    private static final int ALPHABET_LETTERS_COUNT = 26;

    private String encryptMessage(String message, int key) {
        return applyCaesarCipher(message, key);
    }

    private String decryptMessage(String message, int key) {
        return applyCaesarCipher(message, ALPHABET_LETTERS_COUNT - key);
    }

    private String applyCaesarCipher(String message, int key) {
        DroidMessageEncryptor caesarCipher = (originalMessage, encryptKey) -> {
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < message.length(); i++) {
                char symbol = message.charAt(i);

                if (Character.isLetter(symbol)) {
                    char base = Character.isUpperCase(symbol) ? 'A' : 'a';
                    symbol = (char) ((symbol - base + key) % ALPHABET_LETTERS_COUNT + base);
                }
                result.append(symbol);
            }
            return result.toString();
        };

        return caesarCipher.encrypt(message, key);
    }

    public void sendMessage(Droid receiver, String message, int key) {
        String encryptedMessage = encryptMessage(message, key);
        log.info("Отправлено зашифрованное сообщение: {}", encryptedMessage);
        receiver.receiveMessage(encryptedMessage, key);
    }

    public void receiveMessage(String message, int key) {
        String decryptedMessage = decryptMessage(message, key);
        log.info("Получено расшифрованное сообщение: {}", decryptedMessage);
    }
}
