package faang.school.godbless.alexbulgakoff.functionalinterfaceslambdas.droidsecrets;

import lombok.Getter;
import lombok.ToString;

/**
 * @author Alexander Bulgakov
 */
@Getter
@ToString
public class Droid {

    private String message;
    private int key;

    String sendEncryptedMessage(String message, int key) {
        StringBuilder encryptionMessage = new StringBuilder();

        DroidMessageEncryptor encryption = ((message1, key1) -> {
            char[] charArray = message.toCharArray();
            for (char letter : charArray) {
                encryptionMessage.append((char) (letter + key));
            }
            return encryptionMessage.toString();
        });

        return encryption.encryptor(message, key);
    }

    String receiveEncryptedMessage(String message, int key) {
        StringBuilder dencryptionMessage = new StringBuilder();

        DroidMessageEncryptor dencryption = ((message1, key1) -> {
            char[] charArray = message.toCharArray();
            for (char letter : charArray) {
                dencryptionMessage.append((char) (letter - key));
            }
            return dencryptionMessage.toString();
        });

        return dencryption.encryptor(message, key);
    }
}
