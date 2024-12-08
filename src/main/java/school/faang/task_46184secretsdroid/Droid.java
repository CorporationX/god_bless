package school.faang.task_46184secretsdroid;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Droid {
    private String name;

    private String encryptMessage(String message, int key, DroidMessageEncryptor encryptor) {
        return encryptor.execute(message, key);
    }

    private String decryptMessage(String message, int key, DroidMessageEncryptor decryptor) {
        return decryptor.execute(message, key);
    }

    public void sendMessage(Droid sendDroid, String inputMessage, int encryptionKey) {
        String encryptedMessage = encryptMessage(inputMessage, encryptionKey, CaesarCipherEncryptor.encrypt);
        System.out.println("Sending " + encryptedMessage + " to " + sendDroid.name);
        sendDroid.receiveMessage(encryptedMessage, encryptionKey);
    }

    public void receiveMessage(String encryptedMessage, int encryptionKey) {
        String decryptedMessage = decryptMessage(encryptedMessage, encryptionKey, CaesarCipherEncryptor.decrypt);
        System.out.println("Received and decrypted message: " + decryptedMessage);
    }
}
