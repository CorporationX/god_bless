package faang.school.godbless.BJS2_20965;

public class Droid {
    public static String sendEncryptedMessage(String message, int encryptionKey) {
        DroidMessageEncryptor encryptor = (string, key) -> {
            StringBuilder res = new StringBuilder();
            for (char letter : string.toCharArray()) {
                int code = letter + key % 26;
                if (Character.isLetter(letter)) {
                    res.append((char) getLetterCodeEncrypt(code));
                } else if(Character.isDigit(letter)){
                    res.append((char) getNumberCodeEncrypt(code));
                } else {
                    res.append(letter);
                }
            }
            return res.toString();
        };
        return encryptor.messageEncryption(message, encryptionKey);
    }

    public static String receiveEncryptedMessage(String encryptedMessage, int encriptionKey) {
        DroidMessageEncryptor decryptor = (string, key) -> {
            StringBuilder res = new StringBuilder();
            for (char letter : string.toCharArray()) {
                int code = letter - key % 26;
                if (Character.isLetter(letter)) {
                    res.append((char) getLetterCodeDecrypt(code));
                } else if(Character.isDigit(letter)){
                    res.append((char) getNumberCodeDecrypt(code));
                } else{
                    res.append(letter);
                }
            }
            return res.toString();
        };
        return decryptor.messageEncryption(encryptedMessage, encriptionKey);
    }

    private static int getLetterCodeEncrypt(int code) {
        if ('a' <= code && code <= 'z' || 'A' <= code && code <= 'Z') {
            return code;
        }
        return code - 26;
    }

    private static int getNumberCodeEncrypt(int code) {
        if (code <= '9') {
            return code;
        }
        return code - 10;
    }

    private static int getLetterCodeDecrypt(int code) {
        if ('a' <= code && code <= 'z' || 'A' <= code && code <= 'Z') {
            return code;
        }
        return code + 26;
    }

    private static int getNumberCodeDecrypt(int code) {
        if (code >= '0') {
            return code;
        }
        return code + 10;
    }
}
