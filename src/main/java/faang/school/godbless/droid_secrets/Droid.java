package faang.school.godbless.droid_secrets;

public class Droid {

    public String sendEncryptedMessage(Droid droid, String message, int encryptionKey) {
        DroidMessageEncryptor encryptor = (msg, key) -> {
            StringBuilder encryptedMessage = new StringBuilder();

            for (char c : msg.toCharArray()) {
                encryptedMessage.append((char) (c + key));
            }

            return encryptedMessage.toString();
        };

        return encryptor.encrypt(message, encryptionKey);
    }
}
