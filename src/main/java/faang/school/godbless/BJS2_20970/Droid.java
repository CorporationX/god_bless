package faang.school.godbless.BJS2_20970;


public class Droid {
    private final static int MAX_UPPER_CODE = 90;
    private final static int MIN_UPPER_CODE = 65;
    private final static int MAX_LOWER_CODE = 122;
    private final static int MIN_LOWER_CODE = 97;

    public String sendEncryptedMessage(String message, int key) {
        StringBuilder result = new StringBuilder();
        DroidMessageEncryptor droidMessageEncryptor = (msg, encryptKey) -> {
            for (char c : message.toCharArray()) {
                if (Character.isAlphabetic(c)) {
                    if (Character.isUpperCase(c)) {
                        int code = encrypt(c, key, MIN_UPPER_CODE, MAX_UPPER_CODE);
                        result.append((char) code);
                    } else {
                        int code = encrypt(c, key, MIN_LOWER_CODE, MAX_LOWER_CODE);
                        result.append((char) code);
                    }
                } else {
                    result.append(c);
                }
            }
            return result.toString();
        };
        return droidMessageEncryptor.encrypt(message, key);
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
        code -= key % 26;
        if (code < minBorder) {
            code = maxBorder - (minBorder - code) + 1;
        }
        return code;
    }

    public String receiveEncryptedMessage(String message, int key) {
        StringBuilder result = new StringBuilder();
        for (char c : message.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                if (Character.isUpperCase(c)) {
                    int code = decrypt(c, key, MIN_UPPER_CODE, MAX_UPPER_CODE);
                    result.append((char) code);
                } else if (Character.isLowerCase(c)) {
                    int code = decrypt(c, key, MIN_LOWER_CODE, MAX_LOWER_CODE);
                    result.append((char) code);
                }
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

}
