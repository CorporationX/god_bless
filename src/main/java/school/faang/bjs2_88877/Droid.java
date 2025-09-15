package school.faang.bjs2_88877;

import lombok.AllArgsConstructor;

import java.util.function.BiFunction;

@AllArgsConstructor
public class Droid {
    private String name;

    private static final int MIN_UPPER_KEY = 'A';
    private static final int MAX_UPPER_KEY = 'Z';
    private static final int MIN_LOWER_KEY = 'a';
    private static final int MAX_LOWER_KEY = 'z';
    private static final int ROTATION_CORRECTION = 1;

    public String encryptMessage(String message, int key) {
        return ENCRYPTOR.processMessage(message, key);
    }

    public String decryptMessage(String message, int key) {
        return DECRYPTOR.processMessage(message, key);
    }

    public void sendMessage(Droid recipient, String message, int key) {
        String encryptedMessage = encryptMessage(message, key);
        System.out.println(name + " отправил зашифрованное сообщение: " + encryptedMessage);
        recipient.receiveMessage(encryptedMessage, key);
    }

    public void receiveMessage(String encryptedMessage, int key) {
        String decryptedMessage = decryptMessage(encryptedMessage, key);
        System.out.println(name + " получил расшифрованное сообщение: " + decryptedMessage);
    }

    private static final DroidMessageEncryptor ENCRYPTOR = (message, key) -> process(
            message,
            key,
            (c, k) -> encrypt(c, k, MIN_UPPER_KEY, MAX_UPPER_KEY),
            (c, k) -> encrypt(c, k, MIN_LOWER_KEY, MAX_LOWER_KEY)
    );

    private static final DroidMessageEncryptor DECRYPTOR = (message, key) -> process(
            message,
            key,
            (c, k) -> decrypt(c, k, MIN_UPPER_KEY, MAX_UPPER_KEY),
            (c, k) -> decrypt(c, k, MIN_LOWER_KEY, MAX_LOWER_KEY)
    );

    private static String process(String message, int key,
                                  BiFunction<Character, Integer, Character> upperProcessor,
                                  BiFunction<Character, Integer, Character> lowerProcessor) {
        StringBuilder result = new StringBuilder();
        for (char ch : message.toCharArray()) {
            if (ch >= 'A' && ch <= 'Z') {
                result.append(upperProcessor.apply(ch, key));
            } else if (ch >= 'a' && ch <= 'z') {
                result.append(lowerProcessor.apply(ch, key));
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }

    private static char encrypt(char ch, int key, int minChar, int maxChar) {
        int alphabetSize = maxChar - minChar + ROTATION_CORRECTION;
        int code = ch - minChar;
        code = (code + key % alphabetSize + alphabetSize) % alphabetSize;
        return (char) (code + minChar);
    }

    private static char decrypt(char ch, int key, int minChar, int maxChar) {
        int alphabetSize = maxChar - minChar + ROTATION_CORRECTION;
        int code = ch - minChar;
        code = (code - key % alphabetSize + alphabetSize) % alphabetSize;
        return (char) (code + minChar);
    }
}