package faang.school.godbless.bjs2_5059;


public class Droid {

    public String sendEncryptedMessage(String message, int encryptionKey) {
        DroidMessageEncryptor encryptor = (msg, key) -> {
            StringBuilder sb = new StringBuilder();
            for (char ch : msg.toCharArray()) {
                sb.append((char)(ch + key));
            }
            return sb.toString();
        };
        return encryptor.encrypt(message, encryptionKey);
    }

    public String receiveEncryptedMessage(String encryptedMsg, int encryptionKey) {
        DroidMessageEncryptor encryptor = (msg, key) -> {
            StringBuilder sb = new StringBuilder();
            for (char ch : msg.toCharArray()) {
                sb.append((char)(ch - key));
            }
            return sb.toString();
        };
        return encryptor.encrypt(encryptedMsg, encryptionKey);
    }

}
