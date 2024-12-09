package school.faang.sprint_2.task_46196;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Droid {
    private String name;

    private String encryptMessage(String message, int key) {
        DroidMessageEncryptor encryptor = (msg, keyForEncryption) -> {
            StringBuilder stringBuilder = new StringBuilder();
            for (byte charByte : msg.getBytes()) {
                stringBuilder.append((char) (charByte + keyForEncryption));
            }
            return stringBuilder.toString();
        };
        return encryptor.encrypt(message, key);
    }

    private String decryptMessage(String message, int key) {
        DroidMessageEncryptor decrypt = (msg, keyForEncryption) -> {
            StringBuilder stringBuilder = new StringBuilder();
            for (byte charByte : msg.getBytes()) {
                stringBuilder.append((char) (charByte - keyForEncryption));
            }
            return stringBuilder.toString();
        };
        return decrypt.encrypt(message, key);
    }

    public void sendMessage(String message, int key, Droid recipientDroid) {
        String encryptedMessage = encryptMessage(message, key);
        System.out.println(name + " отправил зашифрованное сообщение: " + message);
        recipientDroid.receiveMessage(encryptedMessage, key);
    }

    public void receiveMessage(String message, int key) {
        String decryptedMessage = decryptMessage(message, key);
        System.out.println(name + " получил расшифрованное сообщение: " + decryptedMessage);
    }
}
