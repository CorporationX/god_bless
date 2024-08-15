package faang.school.godbless.BJS2_20990;

public class Droid {

    public String sendEncryptedMessage(String message, int encryptionKey) {
        DroidMessageEncryptor encryptor = (string, key)  -> {
            StringBuilder result = new StringBuilder();
            for (char symbol : string.toCharArray()) {
                result.append(sendEncryptedSymbol(symbol, encryptionKey));
            }
            return result.toString();
        };
        return encryptor.encryptMessage(message, encryptionKey);
    }

    private char sendEncryptedSymbol(char symbol, int key) {
        int code = symbol + key % 26;
        if (Character.isLetter(symbol)) {
            return (char) (getLetterCodeEncryptor(code));
        } else if (Character.isDigit(symbol)) {
            return (char) (getNumberCodeEncryptor(code));
        } else {
            return symbol;
        }
    }

    private int getLetterCodeEncryptor(int code) {
        if (code >= 'A' && code <= 'Z' || code >= 'a' && code <= 'z') {
            return code;
        }
        return code - 26;
    }

    private int getNumberCodeEncryptor(int code) {
        return code <= '9' ? code : code - 10;
    }

    public String receiveEncryptedMessage(String message, int encryptionKey) {
        DroidMessageEncryptor decryptor = (string, key) -> {
            StringBuilder result = new StringBuilder();
            for (char letter : string.toCharArray()) {
                result.append(receiveEncryptedSymbol(letter, encryptionKey));
            }
            return result.toString();
        };
        return decryptor.encryptMessage(message, encryptionKey);
    }

    private char receiveEncryptedSymbol(char symbol, int key) {
        int code = symbol - key % 26;
        if (Character.isLetter(symbol)) {
            return (char) (getLetterCodeDecryptor(code));
        } else if (Character.isDigit(symbol)) {
            return (char) (getNumberCodeDecryptor(code));
        } else {
            return symbol;
        }
    }

    private int getLetterCodeDecryptor(int code) {
        if (code >= 'A' && code <= 'Z' || code >= 'a' && code <= 'z') {
            return code;
        }
        return code + 26;
    }

    private int getNumberCodeDecryptor(int code) {
        return code >= '0' ? code : code + 10;
    }
}
