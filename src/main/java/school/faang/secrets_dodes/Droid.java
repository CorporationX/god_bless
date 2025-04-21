package school.faang.secrets_dodes;

import lombok.AllArgsConstructor;
import school.faang.functional_interface.DroidMessageEncryptor;

@AllArgsConstructor
public class Droid {

    private String name;

    private static final DroidMessageEncryptor ENCRYPTOR = (msg, key) -> {
        StringBuilder encrypted = new StringBuilder();
        for (char c : msg.toCharArray()) {
            encrypted.append((char) (c + key));
        }
        return encrypted.toString();
    };

    public void sendMessage(Droid a, String message, int encryptionKey) {

        String encryptedMessage = encryptMessage(message, encryptionKey);

        a.receiveMessage(encryptedMessage, encryptionKey);
    }

    public void receiveMessage(String encryptedMessage, int encryptionKey) {
        String decryptedMessage = decryptMessage(encryptedMessage, encryptionKey);

        System.out.println("Received and decrypted message: " + decryptedMessage);
    }

    private String decryptMessage(String encryptedMessage, int encryptionKey) {
        return ENCRYPTOR.encrypt(encryptedMessage, -encryptionKey);
    }

    private String encryptMessage(String message, int encryptionKey) {
        return ENCRYPTOR.encrypt(message, encryptionKey);
    }
}
