package school.faang.bjs46298;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
public class Droid {
    private Set<String> receivedMessages;
    private DroidMessageEncryptor encryptor;
    private DroidMessageEncryptor decryptor;

    public String encryptMessage(String original, int key) {
        return encryptor.encrypt(original, key);
    }

    public String decryptMessage(String original, int key) {
        return decryptor.encrypt(original, key);
    }

    public void sendMessage(Droid address, String message, int key) {
        address.receiveMessage(encryptor.encrypt(message, key), key);
    }

    public void receiveMessage(String message, int key) {
        receivedMessages.add(decryptor.encrypt(message, key));
    }

    Droid(Set<String> messages) {
        this.receivedMessages = messages;
    }
}
