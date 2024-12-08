package school.faang.task_46179;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DroidMessageSystem {
    private final DroidMessageEncryptor messageEncryptor = new DroidMessageEncryptor();

    public void sendMessage(
            int key,
            String message,
            Droid sender, Droid recipient
    ) {
        String encryptedMessage = messageEncryptor.encrypt(key, message);

        log.info(
                "{} sent an encrypted message: {}",
                sender.getName(),
                encryptedMessage
        );

        String decryptedMessage = receiveMessage(key, encryptedMessage);
        log.info(
                "{} received an encrypted message: {}",
                recipient.getName(),
                decryptedMessage
        );
    }

    private String receiveMessage(int key, String message) {
        return messageEncryptor.decrypt(key, message);
    }
}
