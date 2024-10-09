package bjs2_33397;

public class Droid {
    public String encryptMessage(String message, int encryptKey) {
        DroidMessageEncryptor droidMessageEncryptor = (msg, key) -> {
            StringBuilder encryptedMessage = new StringBuilder();
            for (char c : msg.toCharArray()) {
                if (Character.isLetter(c)) {
                    char base = Character.isLowerCase(c) ? 'a' : 'A';
                    encryptedMessage.append((char) ((c - base + key) % 26 + base));
                } else {
                    encryptedMessage.append(c);
                }
            }
            return encryptedMessage.toString();
        };
        return droidMessageEncryptor.encrypt(message, encryptKey);
    }

    public String decryptMessage(String message, int decryptKey) {
        DroidMessageEncryptor droidMessageDecryptor = (msg, key) -> {
            StringBuilder encryptedMessage = new StringBuilder();
            for (char c : msg.toCharArray()) {
                if (Character.isLetter(c)) {
                    char base = Character.isLowerCase(c) ? 'a' : 'A';
                    encryptedMessage.append((char) ((c - base - key) % 26 + base));
                } else {
                    encryptedMessage.append(c);
                }
            }
            return encryptedMessage.toString();
        };
        return droidMessageDecryptor.encrypt(message, decryptKey);
    }

    public String sendMessage(String message, int encryptKey) {
        return encryptMessage(message, encryptKey);
    }

    public String receiveMessage(String message, int decryptKey) {
        return decryptMessage(message, decryptKey);
    }
}
