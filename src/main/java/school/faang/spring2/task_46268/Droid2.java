package school.faang.spring2.task_46268;

import java.util.function.BiFunction;

public class Droid2 {
    private static final int MIN_LOWER_KEY = 97;
    private static final int MAX_LOWER_KEY = 122;
    private static final int MAX_UPPER_KEY = 90;
    private static final int MIN_UPPER_KEY = 65;

    private static final int ALPHABET_SIZE = 26;
    private static final DroidMessageEncryptor DEFAULT_ENCRYPTOR = (msg, key) -> process(
            msg,
            key,
            (c, k) -> encrypt(c, key, MIN_UPPER_KEY, MAX_UPPER_KEY),
            (c, k) -> encrypt(c, key, MIN_LOWER_KEY, MAX_LOWER_KEY)
    );

    private static final DroidMessageEncryptor DEFAULT_DECRYPTOR = (msg, key) -> process(
            msg,
            key,
            (c, k) -> decrypt(c, key, MIN_UPPER_KEY, MAX_UPPER_KEY),
            (c, k) -> decrypt(c, key, MIN_LOWER_KEY, MAX_LOWER_KEY)
    );

    private static String process(String msg, int key,
                                  BiFunction<Character, Integer, Integer> upperProcessor,
                                  BiFunction<Character, Integer, Integer> lowerProcessor) {
        StringBuilder builder = new StringBuilder();
        for (char ch : msg.toCharArray()) {
            if (Character.isLetter(ch)) {
                if (Character.isUpperCase(ch)) {
                    int code = upperProcessor.apply(ch, key);
                    builder.append((char) code);
                } else {
                    int code = lowerProcessor.apply(ch, key);
                    builder.append((char) code);
                }
            } else {
                builder.append(ch);
            }
        }
        return builder.toString();
    }


    public String sendMessage(String message, int key, DroidMessageEncryptor encryptor) {
        if (encryptor == null) {
            encryptor = DEFAULT_ENCRYPTOR;
        }
        if (key < 0) {
            throw new IllegalArgumentException("Only positive key allowed");
        }

        return encryptor.encrypt(message, key);
    }

    public String receiveMessage(String decryptedMsg, int key, DroidMessageEncryptor decryptor) {
        if (decryptor == null) {
            decryptor = DEFAULT_DECRYPTOR;
        }
        if (key < 0) {
            throw new IllegalArgumentException("Only positive key allowed");
        }

        return decryptor.encrypt(decryptedMsg, key);
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
