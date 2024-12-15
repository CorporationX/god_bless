package school.faang.sprint2.task_46340;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Droid {
    private String name;

    private String encryptMessage(String message, int key, DroidMessageEncryptor encryptor) {
        return encryptor.encrypt(message, key);
    }

    private String decryptMessage(String message, int key, DroidMessageEncryptor encryptor) {
        key = -key + 26;
        return encryptor.encrypt(message, key);
    }

    private void receiveMessage(String message, int key, DroidMessageEncryptor encryptor) {
        message = decryptMessage(message, key, encryptor);
        System.out.println(name + " получил расшифрованное сообщение: " + message);
    }

    public void sendMessage(Droid receiver, String message, int key, DroidMessageEncryptor encryptor) {
        message = encryptMessage(message, key, encryptor);
        System.out.println(name + " отправил зашифрованное сообщение: " + message);
        receiver.receiveMessage(message, key, encryptor);
    }
}
