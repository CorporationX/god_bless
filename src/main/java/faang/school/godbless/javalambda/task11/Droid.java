package faang.school.godbless.javalambda.task11;

public class Droid {
    private static final int NUMBER_OF_LETTERS = 25;
    public String sendEncryptedMessage(String message, Integer encryptionKey) {
        ShiftChar shiftChar = (symbol, key, startChar) -> {
            symbol += key;
            if (symbol >= startChar + NUMBER_OF_LETTERS) {
                symbol -= NUMBER_OF_LETTERS;
            }
            return symbol;
        };
        DroidMessageEncryptor droidMessageEncryptor = (str, key) -> encryptionMessage(str, key, shiftChar);
        return droidMessageEncryptor.encryption(message, encryptionKey);
    }

    public String receiveEncryptedMessage(String message, Integer encryptionKey) {
        ShiftChar shiftChar = (symbol, key, startChar) -> {
            symbol -= key;
            if (symbol < startChar) {
                symbol += NUMBER_OF_LETTERS;
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
            if (symbol >= 'A' && symbol <= 'Z') {
                arrayChars[i] = shiftChar.shift(symbol, encryptionKey % NUMBER_OF_LETTERS, 'A');
            } else if (symbol >= 'a' && symbol <= 'z') {
                arrayChars[i] = shiftChar.shift(symbol, encryptionKey % NUMBER_OF_LETTERS, 'a');
            }
        }
        return new String(arrayChars);
    }
}


