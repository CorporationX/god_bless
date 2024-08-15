package faang.school.godbless.DroidSecrets;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Droid {

    private String name;
    private DroidMessageEncryptor encryptor;
    DroidMessageReceiver droidMessageReceiver;


    public void sendEncryptedMessage(Droid getter, String message, int key) {
        String encryptedMessage = encryptor.encrypt(message, key);
        System.out.println(name + " отправил зашифрованное сообщение \"" +  encryptedMessage +"\" с ключом " + key + ".\nПолучатель: " + getter.getName());
        getter.droidMessageReceiver.receiveEncryptedMessage(encryptedMessage, key);
    }

}
