package faang.school.godbless.secrets_of_droids;

public class Droid {

    public String sendEncryptedMessage(String message, int encryptionKey) {

        DroidMessageEncryptor df = (msg, shift) -> {
            StringBuilder s = new StringBuilder();
            int len = msg.length();
            for (int x = 0; x < len; x++) {
                s.append((char) (msg.charAt(x) + shift));
            }
            return s.toString();
        };
        return df.encryption(message, encryptionKey);
    }

    public String receiveEncryptedMessage(String encryptedMsg, int encryptionKey) {
        DroidMessageEncryptor df = (msg, shift) -> {
            StringBuilder s = new StringBuilder();
            int len = msg.length();
            for (int x = 0; x < len; x++) {
                s.append((char) (msg.charAt(x) - shift));
            }
            return s.toString();
        };

        return df.encryption(encryptedMsg, encryptionKey);
    }
}

