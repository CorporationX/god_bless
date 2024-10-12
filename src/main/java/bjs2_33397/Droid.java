package bjs2_33397;

import java.util.function.Consumer;

public class Droid {
    public String encryptMessage(String message, int encryptKey) {
        DroidMessageEncryptor droidMessageEncryptor = getDroidMessageEncryptor();
        TriFunction encryptor = (c, base, key) -> (char) ((c - base + key) % 26 + base);
        return droidMessageEncryptor.encrypt(message, encryptKey, encryptor);
    }

    public String decryptMessage(String message, int decryptKey) {
        DroidMessageEncryptor droidMessageDecryptor = getDroidMessageEncryptor();
        TriFunction decryptor = (c, base, key) -> (char) ((c - base - key + 26) % 26 + base);
        return droidMessageDecryptor.encrypt(message, decryptKey, decryptor);
    }

    public DroidMessageEncryptor getDroidMessageEncryptor() {
        DroidMessageEncryptor droidMessageEncryptor = (msg, key, triFunction) -> {
            StringBuilder encryptedMessage = new StringBuilder();
            for (char c : msg.toCharArray()) {
                if (Character.isLetter(c)) {
                    char base = Character.isLowerCase(c) ? 'a' : 'A';
                    encryptedMessage.append(triFunction.apply(c, base, key));
                } else {
                    encryptedMessage.append(c);
                }
            }
            return encryptedMessage.toString();
        };

        return droidMessageEncryptor;
    }

    public String sendMessage(String message, int encryptKey) {
        return encryptMessage(message, encryptKey);
    }

    public String receiveMessage(String message, int decryptKey) {
        return decryptMessage(message, decryptKey);
    }
}
