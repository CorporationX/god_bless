package faang.school.godbless.droid_secrets;

public class DroidMessageReceiver {

    public String receiveEncryptedMessage(String encryptedMessage, int encryptionKey) {
        DroidMessageEncryptor descriptor = (msg, key) -> {
            StringBuilder decryptedMessage = new StringBuilder();

            for (char c : msg.toCharArray()) {
                decryptedMessage.append((char) (c - key));
            }

            return decryptedMessage.toString();
        };

        return descriptor.encrypt(encryptedMessage, encryptionKey);
    }
}
