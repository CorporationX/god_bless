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
        String encryptedMessage = encryptMessage(inputMessage, encryptionKey, CaesarCipherEncryptor.ENCRYPT);
        System.out.println("Sending " + encryptedMessage + " from " + this.name + " to " + sendDroid.name);
        sendDroid.receiveMessage(encryptedMessage, encryptionKey);
    }

    private void receiveMessage(String encryptedMessage, int encryptionKey) {
        String decryptedMessage = decryptMessage(encryptedMessage, encryptionKey, CaesarCipherEncryptor.DECRYPT);
        System.out.println(this.name + " received and decrypted message: " + decryptedMessage);
    }
}
