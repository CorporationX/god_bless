package secretsofthedroids;

public class Droid {

    public String sendEncryptedMessage(String message, int encryptionKey) {
        DroidMessageEncryptor encryptor = (msg, key) -> {
            StringBuilder builder = new StringBuilder();
            for (char chr : msg.toCharArray()) {
                builder.append((char) (chr + key));
            }
            return builder.toString();
        };
        return encryptor.encrypt(message, encryptionKey);
    }

    public String receiveEncryptedMessage(String message, int decryptionKey) {
        DroidMessageEncryptor decryptor = (msg, key) -> {
            StringBuilder builder = new StringBuilder();
            for (char chr : msg.toCharArray()) {
                builder.append((char) (chr - key));
            }
            return builder.toString();
        };
        return decryptor.encrypt(message, decryptionKey);
    }
}
