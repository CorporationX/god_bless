package school.faang.lambda.droids;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public record Droid(String name) {

    private static final DroidMessageEncryptor TRANSFORMER = ((message, key) -> {
        char[] charMsg = message.toCharArray();
        for (int i = 0; i < charMsg.length; i++) {
            charMsg[i] = (char) (charMsg[i] + key);
        }
        return String.copyValueOf(charMsg);
    });

    public void sendMessage(String message, int key, Droid receiver) {
        String encryptedMsg = encryptMessage(message, key);
        log.info("Droid {} sent message to Droid {}: {}", this.name, receiver.name(), encryptedMsg);
        receiver.receiveMessage(encryptedMsg, key);
    }

    public void receiveMessage(String message, int key) {
        log.info("Droid {} received message: {}", this.name, decryptMessage(message, key));
    }

    private String encryptMessage(String message, int key) {
        return TRANSFORMER.transform(message, key);
    }

    private String decryptMessage(String message, int key) {
        return TRANSFORMER.transform(message, -key);
    }
}
