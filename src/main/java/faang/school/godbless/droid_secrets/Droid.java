package faang.school.godbless.droid_secrets;

import java.util.ArrayList;
import java.util.List;

public class Droid {

    public void sendEncryptedMessage(Droid recipient, String message, Integer key) {
        DroidMessageEncryptor caesarCipher = (m, k) -> {
            StringBuilder encryptedMessage = new StringBuilder();
            for (char c : message.toCharArray()) {
                encryptedMessage.append((char) (c+key));
            }
            System.out.println("Encrypted message sent: " + encryptedMessage.toString());
            return encryptedMessage.toString();
        };

        recipient.sendMessage(caesarCipher.encrypt(message, key), key);
    }

    public void sendMessage(String message, Integer key) {
        DroidMessageReceiver.receiveEncryptedMessage(message, key);
    }
}
