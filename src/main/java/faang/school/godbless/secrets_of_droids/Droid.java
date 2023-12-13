package faang.school.godbless.secrets_of_droids;

public class Droid {

    public String sendEncryptedMessage(String message, int encryptionKey) {

        DroidMessageEncryptor encrypt = (msg, shift) -> {
            StringBuilder encryptedMsg = new StringBuilder();
            int len = msg.length();
            for (int x = 0; x < len; x++) {
                encryptedMsg.append((char) (msg.charAt(x) + shift));
            }
            return encryptedMsg.toString();
        };
        return encrypt.encryption(message, encryptionKey);
    }

    public String receiveEncryptedMessage(String encryptedMsg, int encryptionKey) {
        DroidMessageEncryptor unEncrypt = (msg, shift) -> {
            StringBuilder unEncryptedMsg = new StringBuilder();
            int len = msg.length();
            for (int x = 0; x < len; x++) {
                unEncryptedMsg.append((char) (msg.charAt(x) - shift));
            }
            return unEncryptedMsg.toString();
        };

        return unEncrypt.encryption(encryptedMsg, encryptionKey);
    }
}

