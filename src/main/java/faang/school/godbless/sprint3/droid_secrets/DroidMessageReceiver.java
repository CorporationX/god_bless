package faang.school.godbless.sprint3.droid_secrets;

import java.io.Console;

public class DroidMessageReceiver {
    public String receiveEncryptedMessage(String message, int key) {
        DroidMessageEncryptor encryptor = CaesarCipher::decrypt;
        String decryptedMessage = encryptor.encryptMessage(message, key);
        System.out.println(decryptedMessage);
        return decryptedMessage;
    }
}
