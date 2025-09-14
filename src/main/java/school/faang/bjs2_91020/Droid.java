package school.faang.bjs2_91020;

public class Droid {
    private static final int MIN_UPPER = 65;
    private static final int MAX_UPPER = 90;
    private static final int MIN_LOWER = 97;
    private static final int MAX_LOWER = 122;
    private static final int ALPHABET_SIZE = 26;

    private static final DroidMessageEncryptor DEFAULT_ENCRYPTOR = (msg, key) -> {
        StringBuilder result = new StringBuilder();
        for (char c : msg.toCharArray()) {
            if (Character.isUpperCase(c)) {
                result.append((char) encryptChar(c, key, MIN_UPPER, MAX_UPPER));
            } else if (Character.isLowerCase(c)) {
                result.append((char) encryptChar(c, key, MIN_LOWER, MAX_LOWER));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    };

    private static final DroidMessageEncryptor DEFAULT_DECRYPTOR = (msg, key) -> {
        StringBuilder result = new StringBuilder();
        for (char c : msg.toCharArray()) {
            if (Character.isUpperCase(c)) {
                result.append((char) decryptChar(c, key, MIN_UPPER, MAX_UPPER));
            } else if (Character.isLowerCase(c)) {
                result.append((char) decryptChar(c, key, MIN_LOWER, MAX_LOWER));
            } else {
                result.append(c);
            }
        }
        return result.toString();
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

    private static int encryptChar(char c, int key, int min, int max) {
        int shift = key % ALPHABET_SIZE;
        int code = c + shift;
        if (code > max) {
            code = min + (code - max - 1) % ALPHABET_SIZE;
        }
        return code;
    }

    private static int decryptChar(char c, int key, int min, int max) {
        int shift = key % ALPHABET_SIZE;
        int code = c - shift;
        if (code < min) {
            code = max - (min - code - 1) % ALPHABET_SIZE;
        }
        return code;
    }
}

