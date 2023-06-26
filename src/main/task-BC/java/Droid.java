public class Droid {
    public String sendEncryptedMessage(String message, int cipherKey) {
        DroidMessageEncryptor droidMessageEncryptor = (msg, key) -> {
            StringBuilder encrypted = new StringBuilder();
            for (char c : msg.toCharArray()) {
                if (Character.isLetter(c)) {
                    char base = Character.isUpperCase(c) ? 'A' : 'a';
                    c = (char) (((c - base + key) % 26) + base);
                }
                encrypted.append(c);
            }
            return encrypted.toString();
        };
        return droidMessageEncryptor.messageCoder(message, cipherKey);
    }

    public String receiveEncryptedMessage(String message, int cipherKey) {
        DroidMessageEncryptor droidMessageEncryptor = (msg, key) -> {
            StringBuilder encrypted = new StringBuilder();
            for (char c : msg.toCharArray()) {
                if (Character.isLetter(c)) {
                    char base = Character.isUpperCase(c) ? 'A' : 'a';
                    c = (char) (((c - base - key) % 26) + base);
                }
                encrypted.append(c);
            }
            return encrypted.toString();
        };
        return droidMessageEncryptor.messageCoder(message, cipherKey);
    }
}
