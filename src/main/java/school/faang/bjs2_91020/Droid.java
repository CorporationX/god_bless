package school.faang.bjs2_91020;

public class Droid {
    private static final int MIN_UPPER = 65;
    private static final int MAX_UPPER = 90;
    private static final int MIN_LOWER = 97;
    private static final int MAX_LOWER = 122;
    private static final int ALPHABET_SIZE = 26;

    private static final DroidMessageEncryptor DEFAULT_ENCRYPTOR = (msg, key) -> {
        return processCharacters(msg, key, true);
    };

    private static final DroidMessageEncryptor DEFAULT_DECRYPTOR = (msg, key) -> {
        return processCharacters(msg, key, false);
    };

    public String encryptMessage(String message, int key) {
        return processMessage(message, key, DEFAULT_ENCRYPTOR);
    }

    public String decryptMessage(String message, int key) {
        return processMessage(message, key, DEFAULT_DECRYPTOR);
    }

    public void sendMessage(String message, int key, Droid receiver) {
        String encrypted = encryptMessage(message, key);
        receiver.receiveMessage(encrypted, key);
    }

    public void receiveMessage(String encryptedMessage, int key) {
        String decrypted = decryptMessage(encryptedMessage, key);
        System.out.println("Received: " + decrypted);
    }

    private String processMessage(String message, int key, DroidMessageEncryptor processor) {
        if (key < 0) {
            throw new IllegalArgumentException("Key must be positive");
        }
        return processor.process(message, key);
    }

    private static String processCharacters(String message, int key, boolean encrypt) {
        StringBuilder result = new StringBuilder();
        int direction = encrypt ? 1 : -1;

        for (char c : message.toCharArray()) {
            if (Character.isUpperCase(c)) {
                result.append((char) processChar(c, key, MIN_UPPER, MAX_UPPER, direction));
            } else if (Character.isLowerCase(c)) {
                result.append((char) processChar(c, key, MIN_LOWER, MAX_LOWER, direction));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    private static int processChar(char c, int key, int min, int max, int direction) {
        int shift = key % ALPHABET_SIZE;
        int code = c + (direction * shift);

        if (direction > 0 && code > max) {
            code = min + (code - max - 1) % ALPHABET_SIZE;
        } else if (direction < 0 && code < min) {
            code = max - (min - code - 1) % ALPHABET_SIZE;
        }

        return code;
    }
}

