package faang.school.godbless.modul2.droid;

public class Droid {
    public String sendEncryptedMessage(String message, int encryptionKey) {
        DroidMessageEncryptor encryptedMessage = getEncryptionMechanism(true);
        return encryptedMessage.encrypt(message, encryptionKey);
    }

    public String receiveEncryptedMessage(String encryptedMessage, int encryptionKey) {
        DroidMessageEncryptor decryptedMessage = getEncryptionMechanism(false);
        return decryptedMessage.encrypt(encryptedMessage, encryptionKey);
    }

    private DroidMessageEncryptor getEncryptionMechanism(boolean isEncrypted) {
        return (message, key) -> message.chars()
                .mapToObj(ch -> (char) (isEncrypted ? ch + key : ch - key))
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();
    }
}
