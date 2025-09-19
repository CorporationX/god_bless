package school.faang.bjs2_90990;

public class Droid {
    private static final int ALPHABET_SIZE = 26;
    private static final int MIN_UPPER_KEY = 65;
    private static final int MAX_UPPER_KEY = 90;
    private static final int MIN_LOWER_KEY = 97;
    private static final int MAX_LOWER_KEY = 122;

    private static final DroidMessageEncryptor DEFAULT_ENCRYPTOR = (msg, key) -> {
        StringBuilder result = new StringBuilder();
        for (char charFromString : msg.toCharArray()) {
            if ((charFromString >= MIN_UPPER_KEY && charFromString <= MAX_UPPER_KEY)
                    || (charFromString >= MIN_LOWER_KEY && charFromString <= MAX_LOWER_KEY)) {
                if (Character.isUpperCase(charFromString)) {
                    int code = charFromString;
                    code += key;
                    if (code > MAX_UPPER_KEY) {
                        code = code % MAX_UPPER_KEY + MIN_UPPER_KEY - 1;
                    }
                    result.append((char) code);
                } else {
                    int code = charFromString;
                    code += key;
                    if (code > MAX_LOWER_KEY) {
                        code = code % MAX_LOWER_KEY + MIN_LOWER_KEY - 1;
                    }
                    result.append((char) code);
                }
            } else {
                result.append(charFromString);
            }
        }
        return result.toString();
    };

    private static final DroidMessageEncryptor DEFAULT_DECRYPTOR = (msg, key) -> {
        StringBuilder result = new StringBuilder();
        for (char charFromString : msg.toCharArray()) {
            if ((charFromString >= MIN_UPPER_KEY && charFromString <= MAX_UPPER_KEY)
                    || (charFromString >= MIN_LOWER_KEY && charFromString <= MAX_LOWER_KEY)) {
                if (Character.isUpperCase(charFromString)) {
                    int code = charFromString;
                    code -= key % ALPHABET_SIZE;
                    if (code < MIN_UPPER_KEY) {
                        code = MAX_UPPER_KEY - (MIN_UPPER_KEY - code) + 1;
                    }
                    result.append((char) code);
                } else {
                    int code = charFromString;
                    code -= key % ALPHABET_SIZE;
                    if (code < MIN_LOWER_KEY) {
                        code = MAX_LOWER_KEY - (MIN_LOWER_KEY - code) + 1;
                    }
                    result.append((char) code);
                }
            } else {
                result.append(charFromString);
            }
        }
        return result.toString();
    };

    public void sendMessage(String message, int key, Droid droid) {
        String encryptedMessage = encryptMessage(message, key);
        droid.receiveMessage(encryptedMessage, key);
    }

    public void receiveMessage(String message, int key) {
        String decryptedMessage = decryptMessage(message, key);
        System.out.println(decryptedMessage);
    }

    public String decryptMessage(String message, int key) {
        return DEFAULT_DECRYPTOR.encrypt(message, key);
    }

    public String encryptMessage(String message, int key) {
        return DEFAULT_ENCRYPTOR.encrypt(message, key);
    }
}
