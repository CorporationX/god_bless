package faang.school.godbless.DroidSecrets;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DroidMessageReceiver {

    private DroidMessageDecryptor decryptor;

    public void receiveEncryptedMessage(String encryptedMessage, int key) {
        System.out.println(decryptor.decrypt(encryptedMessage, key));
    }

}
