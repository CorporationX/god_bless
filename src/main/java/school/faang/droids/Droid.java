package school.faang.droids;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public record Droid(String name) {

    private static final DroidMessageEncryptor ENCRYPTOR = ((message, key) -> {
        char[] messageChars = message.toCharArray();
        for (int i = 0; i < messageChars.length; i++) {
            int unicode = messageChars[i];
            if (unicode != 32) {
                messageChars[i] = (char) (unicode + key);
            }
        }
        return String.copyValueOf(messageChars);
    });

    private String encryptMessage(String message, int key) {
        return ENCRYPTOR.translate(message, key);
    }

    private String decryptMessage(String message, int key) {
        return encryptMessage(message, -key);
    }

    public void sendMessage(Droid receiver, String message, int key) {
        String encryptedMessage = encryptMessage(message, key);
        log.info("{} send message to {}: {}", this.name, receiver.name(), encryptedMessage);
        receiver.receiveMessage(encryptedMessage, key);
    }

    public void receiveMessage(String message, int key) {
        log.info("{} receive message: {}", this.name, decryptMessage(message, key));
    }
}
