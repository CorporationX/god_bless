package school.faang.task_46179;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DroidMessageSystem {
    private final DroidMessageEncryptor messageEncryptor = new DroidMessageEncryptor();

    public void sendMessage(
            int key,
            String message,
            Droid sender, Droid recipient) {
        String encryptedMessage = messageEncryptor.encrypt(key, message);

        // Droid1 sent an encrypted message: Rovvy N|ysn2!
        log.info(
                "{} sent an encrypted message: {}",
                sender.getName(),
                encryptedMessage
        );

        String decryptedMessage = receiveMessage(key, encryptedMessage);

        // Droid2 received an encrypted message: Hello Droid2!
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
