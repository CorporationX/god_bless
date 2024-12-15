package school.faang.moduleone.sprinttwo.task_43531;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Droid {
    private static final DroidMessageEncryptor DEFAULT_ENCRYPTOR = Droid::encryptDefault;
    private String name;
    private DroidMessageEncryptor encryptor;

    public Droid(String name) {
        this.name = name;
        this.encryptor = DEFAULT_ENCRYPTOR;
    }

    public String sendMessage(Droid droid, String message, int encryptionKey) {
        String encryptedMessage = encryptMessage(message, encryptionKey, encryptor);
        send(droid, encryptedMessage);
        return encryptedMessage;
    }

    private void send(Droid droid, String encryptedMessage) {
        System.out.printf("Message [%s] for droid %s has just been sent\n", encryptedMessage, droid.getName());
    }

    public String receiveMessage(String encryptedMessage, int key) {
        String decryptedMessage = decryptMessage(encryptedMessage, key, encryptor);
        System.out.printf("Message [%s] has just been received by droid %s \n", decryptedMessage, this.name);
        return decryptedMessage;
    }

    private String encryptMessage(String message, int key, DroidMessageEncryptor encryptor) {
        if (encryptor == null) {
            encryptor = DEFAULT_ENCRYPTOR;
        }
        return encryptor.encrypt(message, key);
    }

    private String decryptMessage(String encryptedMessage, int encryptionKey, DroidMessageEncryptor encryptor) {
        return encryptMessage(encryptedMessage, (26 - encryptionKey), encryptor);
    }

    private static String encryptDefault(String message, int encryptionKey) {
        return message;
    }
}
