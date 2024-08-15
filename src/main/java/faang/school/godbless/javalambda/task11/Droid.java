package faang.school.godbless.javalambda.task11;

public class Droid {
    private static final int UPPERCASE_A = 65;
    private static final int UPPERCASE_Z = 90;
    private static final int LOWERCASE_A = 97;
    private static final int LOWERCASE_Z = 122;

    public String sendEncryptedMessage(String message, Integer encryptionKey) {
        ShiftChar shiftChar = (symbol, key, minInterval, maxInterval) -> {
            if (symbol + key >= maxInterval) {
                symbol = (char) (symbol + key - maxInterval + minInterval);
            } else {
                symbol = (char) (symbol + key);
            }
            return symbol;
        };
        DroidMessageEncryptor droidMessageEncryptor = (str, key) -> encryptionMessage(str, key, shiftChar);
        return droidMessageEncryptor.encryption(message, encryptionKey);
    }

    public String receiveEncryptedMessage(String message, Integer encryptionKey) {
        ShiftChar shiftChar = (symbol, key, minInterval, maxInterval) -> {
            if (symbol - key < minInterval) {
                symbol = (char) (maxInterval - (minInterval - (symbol - key)));
            } else {
                symbol = (char) (symbol - key);
            }
            return symbol;
        };
        DroidMessageEncryptor droidMessageEncryptor = (str, key) -> encryptionMessage(str, key, shiftChar);
        return droidMessageEncryptor.encryption(message, encryptionKey);
    }

    private String encryptionMessage(String message, Integer encryptionKey, ShiftChar shiftChar) {
        char[] arrayChars = message.toCharArray();
        for (int i = 0; i < arrayChars.length; i++) {
            char symbol = arrayChars[i];
            if (symbol >= UPPERCASE_A && symbol <= UPPERCASE_Z) {
                arrayChars[i] = shiftChar.shift(symbol, encryptionKey % 25, UPPERCASE_A, UPPERCASE_Z);
            } else if (symbol >= LOWERCASE_A && symbol <= LOWERCASE_Z) {
                arrayChars[i] = shiftChar.shift(symbol, encryptionKey % 25, LOWERCASE_A, LOWERCASE_Z);
            }
        }
        return new String(arrayChars);
    }
}


