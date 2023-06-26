package faang.school.godbless.Sprint3.task15;

import java.util.function.BiFunction;

public class Droid {
    private static final int MIN_UPPER_KEY = 65;
    private static final int MAX_UPPER_KEY = 90;
    private static final int MIN_LOWER_KEY = 97;
    private static final int MAX_LOWER_KEY = 122;
    private static final int ALPHABET_SIZE = 26;

    private static final DroidMessageEncryptor DEFAULT_ENCRYPTOR = (msg, key) -> process(
            msg,
            key,
            (c, k) -> encrypt(c, k, MIN_UPPER_KEY, MAX_UPPER_KEY),
            (c, k) -> encrypt(c, k, MIN_LOWER_KEY, MAX_LOWER_KEY)
    );

    private static final DroidMessageEncryptor DEFAULT_DECRYPTOR = (msg, key) -> process(
            msg,
            key,
            (c, k) -> decrypt(c, k, MIN_UPPER_KEY, MIN_UPPER_KEY),
            (c, k) -> decrypt(c, k, MIN_LOWER_KEY, MAX_LOWER_KEY)
    );

    public String sendMessage(String msg, int key, DroidMessageEncryptor encryptor) {
        if (encryptor == null) {
            encryptor = DEFAULT_ENCRYPTOR;
        }
        if (key < 0) {
            throw new IllegalArgumentException("Key cannot be negative");
        }
        return encryptor.encrypt(msg, key);
    }

    public String receiverMessage(String decryptedMsg, int key, DroidMessageEncryptor decryptor) {
        if (decryptor == null) {
            decryptor = DEFAULT_DECRYPTOR;
        }
        if (key < 0) {
            throw new IllegalArgumentException("Key cannot be negative");
        }
        return decryptor.encrypt(decryptedMsg, key);
    }

    private static String process(String msg, int key,
                                  BiFunction<Character, Integer, Integer> upperProcessor,
                                  BiFunction<Character, Integer, Integer> lowerProcessor) {
        StringBuilder result = new StringBuilder();
        for (char c : msg.toCharArray()) {
            if (Character.isUpperCase(c)) {
                int code = upperProcessor.apply(c, key);
                result.append((char) code);
            } else {
                int code = lowerProcessor.apply(c, key);
                result.append((char) code);
            }
        }
        return result.toString();
    }

    private static int encrypt(char c, int key, int minBorder, int maxBorder) {
        int code = c;
        code += key;
        if (code > maxBorder) {
            code = code % maxBorder + minBorder - 1;
        }
        return code;
    }

    private static int decrypt(char c, int key, int minBorder, int maxBorder) {
        int code = c;
        code -= key % ALPHABET_SIZE;
        if (code < minBorder) {
            code = maxBorder - (minBorder - code) + 1;
        }
        return code;
    }
}

