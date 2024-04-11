package secretsofthedroids;

public class Droid {

    public String sendEncryptedMessage(String message, int encryptionKey) {
        DroidMessageEncryptor encryptor = getEncryptorOrDecryptor(true);
        return encryptor.encrypt(message, encryptionKey);
    }

    public String receiveEncryptedMessage(String message, int decryptionKey) {
        DroidMessageEncryptor decryptor = getEncryptorOrDecryptor(false);
        return decryptor.encrypt(message, decryptionKey);
    }

    private static DroidMessageEncryptor getEncryptorOrDecryptor(boolean cryptor) {
        return (msg, key) -> {
            StringBuilder builder = new StringBuilder();
            for (char chr : msg.toCharArray()) {
                builder.append((char) (cryptor ? (chr + key) : (chr - key)));
            }
            return builder.toString();
        };
    }
}
