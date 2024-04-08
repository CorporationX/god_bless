package faang.school.godbless.bjs2_5059;


public class Droid {

    public String sendEncryptedMessage(String message, int encryptionKey) {
        DroidMessageEncryptor encryptor = getEncryptorDecryptor(true);
        return encryptor.encrypt(message, encryptionKey);
    }

    public String receiveEncryptedMessage(String encryptedMsg, int encryptionKey) {
        DroidMessageEncryptor decryptor = getEncryptorDecryptor(false);
        return decryptor.encrypt(encryptedMsg, encryptionKey);
    }

    private DroidMessageEncryptor getEncryptorDecryptor(boolean isEncryptor) {
        return (msg, key) -> {
            StringBuilder sb = new StringBuilder();
            for (char ch : msg.toCharArray()) {
                sb.append((char)(isEncryptor ? ch + key : ch - key));
            }
            return sb.toString();
        };
    }
}
