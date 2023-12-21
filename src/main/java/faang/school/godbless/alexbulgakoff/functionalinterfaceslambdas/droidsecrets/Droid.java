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
        DroidMessageEncryptor droidMessageEncryptor = (m, k) -> new String("");

        return droidMessageEncryptor.encryptor(message, key);
    }

    String receiveEncryptedMessage(String message, int key) {
        return "Hi";
    }
}
