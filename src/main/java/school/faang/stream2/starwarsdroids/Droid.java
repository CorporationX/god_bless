package school.faang.stream2.starwarsdroids;

import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@RequiredArgsConstructor
public class Droid {
    private final String name;
    private DroidMessageEncryptor encryptor;

    public Droid(String name, DroidMessageEncryptor encryptor) {
        this.name = name;
        this.encryptor = encryptor;
    }

    public String encryptMessage(String message, int key) {
        return this.encryptor.processMessage(message, key);
    }

    public String decryptMessage(String message, int key) {
        return this.encryptMessage(message, -key);
    }

    public void receiveMessage(String message, int key) {
        System.out.println(decryptMessage(message, key));
    }

    public void sendMessage(String message, int key, Droid reciever) {
        String encryptedMessage = this.encryptMessage(message, key);
        reciever.receiveMessage(encryptedMessage, key);
    }
}
