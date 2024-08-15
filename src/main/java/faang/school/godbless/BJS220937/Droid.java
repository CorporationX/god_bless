package faang.school.godbless.BJS220937;

public class Droid {
    public String sendEncryptedMessage(String message, int key) {
        DroidMessageEncryptor encryptor = (msg, k) -> {
            StringBuilder encrypted = new StringBuilder();
            for (char c : message.toCharArray()) {
                if (Character.isLetter(c)) {
                    char base = Character.isUpperCase(c) ? 'A' : 'a';
                    c = (char) ((c - base + k) % 26 + base);
                }
                encrypted.append(c);
            }
            return encrypted.toString();
        };
        return encryptor.encrypt(message, key);
    }

    public String receiveEncryptedMessage(String message, int key) {
        DroidMessageEncryptor encryptor = (msg, k) -> {
            StringBuilder encrypted = new StringBuilder();
            for (char c : message.toCharArray()) {
                if (Character.isLetter(c)) {
                    char base = Character.isUpperCase(c) ? 'A' : 'a';
                    c = (char) ((c - base - k + 26) % 26 + base);
                }
                encrypted.append(c);
            }
            return encrypted.toString();
        };
        return encryptor.encrypt(message, key);
    }
}
