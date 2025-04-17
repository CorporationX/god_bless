package school.faang.secretsofdroids;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@Getter
public class Droid {
    private final String name;

    public void sendMessage(String message, int key, Droid receiver) {
        String encryptedMessage = encryptMessage(message, key);
        log.info(String.format("Message: \"%s\" was encrypted and sent (droid %s -> droid: %s).",
                message,
                this.getName(),
                receiver.getName()));
        log.info(String.format("encrypted message: [%s]", encryptedMessage));
        receiveMessage(encryptedMessage, key);
    }

    public void receiveMessage(String encryptedMessage, int key) {
        System.out.printf("Received message %s\n\n", decryptMessage(encryptedMessage, key));
    }

    private String encryptMessage(String message, int key) {
        return DroidMessageEncryptor.caesar().process(message, key);
    }

    private String decryptMessage(String message, int key) {
        return DroidMessageEncryptor.caesar().process(message, -key);
    }
}
