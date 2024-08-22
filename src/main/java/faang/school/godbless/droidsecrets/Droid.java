package faang.school.godbless.droidsecrets;

public class Droid {
    public String sendEncryptedMessage(String message, int encryptionKey) {
        DroidMessageEncryptor encryptor = (msg, key) -> {
            StringBuilder encrypted = new StringBuilder();
            for (char c : message.toCharArray()) {
                if (Character.isLetter(c)) {
                    char base = Character.isLowerCase(c) ? 'a' : 'A';
                    c = (char) ((c - base + key) % 26 + base);
                }
                encrypted.append(c);
            }
            return encrypted.toString();
        };
        return encryptor.encrypt(message, encryptionKey);
    }

    public String receiveEncryptedMessage(String encryptedMessage, int encryptionKey) {
        DroidMessageEncryptor decryptor = (msg, key) -> {
            StringBuilder decrypted = new StringBuilder();
            for (char c : msg.toCharArray()) {
                if (Character.isLetter(c)) {
                    char base = Character.isLowerCase(c) ? 'a' : 'A';
                    c = (char) ((c - base - key + 26) % 26 + base);
                }
                decrypted.append(c);
            }
            return decrypted.toString();
        };
        return decryptor.encrypt(encryptedMessage, encryptionKey);
    }
}