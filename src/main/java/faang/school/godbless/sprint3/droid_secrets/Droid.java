package faang.school.godbless.sprint3.droid_secrets;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Droid {
    private String message;

    public void sendEncryptedMessage(Droid droid, String message, int key) {
        DroidMessageEncryptor encryptor = CaesarCipher::crypt;
        String encryptedString = encryptor.encryptMessage(message, key);
        droid.setMessage(encryptedString);
    }
}
