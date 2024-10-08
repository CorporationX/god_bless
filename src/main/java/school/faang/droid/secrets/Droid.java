package school.faang.droid.secrets;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Droid {
    private String name;
    private DroidMessageEncryptor encryptor;
    private DroidMessageEncryptor decryptor;

    public String encryptMessage(String message, int key) {
        return encryptor.encrypt(message, key);
    }

    public String decryptMessage(String message, int key) {
        return decryptor.encrypt(message, key);
    }

    public void sendMessage(String message, int key, Droid droid) {
        String encryptedMessage = droid.encryptMessage(message, key);
        System.out.println(name + " отправил зашифрованное сообщение: " + encryptedMessage);
        droid.receiveMessage(encryptedMessage, key);
    }

    public void receiveMessage(String message, int key) {
        String decryptedMessage = decryptMessage(message, key);
        System.out.println(name + " получил расшифрованное сообщение: " + decryptedMessage);
    }
}
