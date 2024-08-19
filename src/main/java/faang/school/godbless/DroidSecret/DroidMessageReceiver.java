package faang.school.godbless.DroidSecret;

public class DroidMessageReceiver {
    public String receiveEncryptedMessage(String encryptedMessage, int key) {
        return DroidCrypto.decryptor.decrypt(encryptedMessage, key);
    }
}
