package school.faang.bjs246624;

import lombok.AllArgsConstructor;

import static school.faang.bjs246624.AppStatic.DECRYPTOR;
import static school.faang.bjs246624.AppStatic.ENCRYPTOR;

@AllArgsConstructor
public class Droid {

    private String name;

    public void sendMessage(Droid receiver, String message, Integer key) {
        String encryptedMessage = encryptMessage(message, key);
        System.out.println(name + " отправил зашифрованное сообщение: " + encryptedMessage);
        receiver.receiveMessage(encryptedMessage, key);
    }

    public void receiveMessage(String message, Integer key) {
        String decryptedMessage = decryptMessage(message, key);
        System.out.println(name + " получил расшифрованное сообщение: " + decryptedMessage);
    }

    private String encryptMessage(String message, Integer key) {
        return EncryptorFactory.getEncryptor(ENCRYPTOR).mutate(message, key);
    }

    private String decryptMessage(String message, Integer key) {
        return EncryptorFactory.getEncryptor(DECRYPTOR).mutate(message, key);
    }

}
