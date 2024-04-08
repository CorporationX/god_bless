package faang.school.godbless.DroidSecrets;

public class Droid {
    public String sendEncryptedMessage(String message, int encryptionKey) {
        DroidMessageEncryptor encoder = (mess, key) -> {
            StringBuilder coded = new StringBuilder();
            for (char ch : mess.toCharArray()) {
                coded.append(Character.valueOf((char) (ch + key)));
            }
            return coded.toString();
        };
        return encoder.encrypt(message, encryptionKey);
    }

    public String receiveEncryptedMessage(String encryptedMessage, int encryptionKey) {
        DroidMessageEncryptor decoder = (mess, key) -> {
            StringBuilder decoded = new StringBuilder();
            for (char ch : mess.toCharArray()) {
                decoded.append(Character.valueOf((char) (ch - key)));
            }
            return decoded.toString();
        };
        return decoder.encrypt(encryptedMessage, encryptionKey);
    }
}
