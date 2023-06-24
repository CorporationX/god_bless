package faang.school.godbless.Droid.Secrets;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Droid {

    private String message;
    private int key;

    public String sendEncryptedMessage(DroidMessageEncryptor encryptor) {
        return encryptor.encrypt(message, key);
    }

    public void receiveEncryptedMessage(String encryptedMessage, int key, DroidMessageEncryptor encryptor) {
        System.out.println(encryptor.encrypt(encryptedMessage, 0 - key));
    }
}
