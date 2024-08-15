package faang.school.godbless.javalambda.task11;

public class Droid {
    public String sendEncryptedMessage(String message, Integer encryptionKey) {
        ShiftChar shiftChar = (symbol, key, minChar, maxChar) -> {
            if (symbol + key >= maxChar) {
                symbol = (char) (minChar - maxChar + symbol + key);
            } else {
                symbol = (char) (symbol + key);
            }
            return symbol;
        };
        DroidMessageEncryptor droidMessageEncryptor = (str, key) -> encryptionMessage(str, key, shiftChar);
        return droidMessageEncryptor.encryption(message, encryptionKey);
    }

    public String receiveEncryptedMessage(String message, Integer encryptionKey) {
        ShiftChar shiftChar = (symbol, key, minChar, maxChar) -> {
            if (symbol - key < minChar) {
                symbol = (char) (maxChar - minChar + symbol - key);
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
            if (symbol >= 'A' && symbol <= 'Z') {
                arrayChars[i] = shiftChar.shift(symbol, encryptionKey % 25, 'A', 'Z');
            } else if (symbol >= 'a' && symbol <= 'z') {
                arrayChars[i] = shiftChar.shift(symbol, encryptionKey % 25, 'a', 'z');
            }
        }
        return new String(arrayChars);
    }
}


