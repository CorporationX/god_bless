package school.faang.module2.droid;

import lombok.Getter;

public class Droid {

    private static final DroidMessageEncryptor DEFAULT_ENCRYPTOR = new CaesarCipher();
    @Getter
    private String decryptedMessage;

    public void sendMessage(String message, int key, Droid receiver) {
        String encryptedMessage = encryptMessage(message, key, DEFAULT_ENCRYPTOR);
        receiver.receiveMessage(encryptedMessage, key);
    }

    public void receiveMessage(String encryptedMessage, int key) {
        this.decryptedMessage = decryptMessage(encryptedMessage, key, DEFAULT_ENCRYPTOR);
    }

    private String encryptMessage(String message, int key, DroidMessageEncryptor encryptor) {
        return encryptor.crypt(message, key);
    }

    private String decryptMessage(String message, int key, DroidMessageEncryptor encryptor) {
        return encryptor.crypt(message, -key);
    }
}
