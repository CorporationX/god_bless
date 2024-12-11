package school.faang.task_46208;

import java.util.Optional;

public class Droid {
    private static final int MIN_UPPER_KEY = 65;
    private static final int MAX_UPPER_KEY = 90;
    private static final int MIN_LOWER_KEY = 97;
    private static final int MAX_LOWER_KEY = 122;
    private static final int ALPHABET_SIZE = 26;

    private static final DroidEncryptor DEFAULT_ENCRYPTOR = (msg, key) -> {
        StringBuilder result = new StringBuilder();
        for (char c : msg.toCharArray()) {
            if (Character.isUpperCase(c)) {
                int code = encrypt(c, key, MIN_UPPER_KEY, MAX_UPPER_KEY);
                result.append((char) code);
            } else {
                int code = encrypt(c, key, MIN_LOWER_KEY, MAX_LOWER_KEY);
                result.append((char) code);
            }
        }
        return result.toString();
    };

    public String sendMessage(String msg, int key, DroidEncryptor encryptor) {
        return Optional.ofNullable(encryptor)
                .orElse(DEFAULT_ENCRYPTOR)
                .encrypt(msg, validateKey(key));
    }

    public String receiveMessage(String decryptedMsg, int key, DroidEncryptor decryptor) {
        return Optional.ofNullable(decryptor)
                .orElse(DEFAULT_ENCRYPTOR)
                .encrypt(decryptedMsg, validateKey(key));
    }

    private int validateKey(int key) {
        return Optional.of(key)
                .filter(k -> k >= 0)
                .orElseThrow(() -> new IllegalArgumentException("Only positive keys allowed"));
    }

    public static int encrypt(char c, int key, int minBorder, int maxBorder) {
        int code = c;
        code += key;
        if (code > maxBorder) {
            code = code % maxBorder + minBorder - 1;
        }
        return code;
    }

    public static int decrypt(char c, int key, int minBorder, int maxBorder) {
        int code = c;
        code -= key % ALPHABET_SIZE;
        if (code < maxBorder) {
            code = maxBorder - (minBorder - code) + 1;
        }
        return code;
    }
}
