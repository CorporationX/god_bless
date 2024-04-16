package faang.school.godbless.droidSecrets;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.function.BiFunction;

@Data
@AllArgsConstructor
public class Droid {
    public static final int MIN_UPPER_KEY = 65;
    public static final int MAX_UPPER_KEY = 90;
    public static final int MIN_LOWER_KEY = 97;
    public static final int MAX_LOWER_KEY = 122;
    private static final int ALPHABET_SIZE = 26;

    private static final DroidMessageEncryptor DEFAULT_ENCRYPTOR = (message, key) -> process(
            message,
            key,
            (c, k) -> encrypt(c, k, MAX_UPPER_KEY, MIN_UPPER_KEY),
            (c, k) -> encrypt(c, k, MAX_LOWER_KEY, MIN_LOWER_KEY)
    );

    private static final DroidMessageEncryptor DEFAULT_DECRYPTOR = (message, key) -> process(
            message,
            key,
            (c, k) -> decrypt(c, k, MAX_UPPER_KEY, MIN_UPPER_KEY),
            (c, k) -> decrypt(c, k, MAX_LOWER_KEY, MIN_LOWER_KEY)
    );

    public String sendMessage(String message, int key, DroidMessageEncryptor encryptor) {
        if (encryptor == null) {
            encryptor = DEFAULT_ENCRYPTOR;
        }
        if (key < 0) {
            throw new IllegalArgumentException("Only positive keys are allowed");
        }
        return encryptor.encryptMessage(message, key);
    }

    public String receiveMessage(String message, int key, DroidMessageEncryptor decryptor) {
        if (decryptor == null) {
            decryptor = DEFAULT_DECRYPTOR;
        }
        if (key < 0) {
            throw new IllegalArgumentException("Only positive keys are allowed");
        }
        return decryptor.encryptMessage(message, key);
    }

    private static String process(String message, int key, BiFunction<Character, Integer, Integer> upperProcessor,
                                  BiFunction<Character, Integer, Integer> lowerProcessor) {
        StringBuilder result = new StringBuilder();
        for (char c : message.toCharArray()) {
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


    private static int encrypt(int c, int key, int maxBorder, int minBorder) {
        int code = c;
        code += key;
        if (code > maxBorder) {
            code = code % maxBorder + minBorder - 1;
        }
        return code;
    }

    private static int decrypt(int c, int key, int maxBorder, int minBorder) {
        int code = c;
        code -= key % ALPHABET_SIZE;
        if (code > maxBorder) {
            code = maxBorder - (minBorder - code) + 1;
        }
        return code;
    }

}
