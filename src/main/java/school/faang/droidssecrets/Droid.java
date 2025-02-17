package school.faang.droidssecrets;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public record Droid(String name) {

    private String encryptMessage(String message, int encryptionKey) {
        DroidMessageEncryptor droidMessageEncryptor = (msg, key) -> {
            StringBuilder encryptedMessage = new StringBuilder();
            for (char letter : message.toCharArray()) {
                if (Character.isUpperCase(letter)) {
                    encryptedMessage.append((char) (((letter - 'A' + key + 26) % 26) + 'A'));
                } else if (Character.isLowerCase(letter)) {
                    encryptedMessage.append((char) (((letter - 'a' + key + 26) % 26) + 'a'));
                } else {
                    encryptedMessage.append(letter);
                }
            }
            log.info("EncryptedMessage {}", encryptedMessage);
            return encryptedMessage.toString();
        };
        return droidMessageEncryptor.processMessage(message, encryptionKey);
    }

    private String decryptMessage(String message, int decryptionKey) {
        DroidMessageEncryptor droidMessageDecryptor = (msg, key) -> {
            StringBuilder decryptedMessage = new StringBuilder();
            for (char letter : message.toCharArray()) {
                if (Character.isUpperCase(letter)) {
                    decryptedMessage.append((char) (((letter - 'A' - key + 26) % 26) + 'A'));
                } else if (Character.isLowerCase(letter)) {
                    decryptedMessage.append((char) (((letter - 'a' - key + 26) % 26) + 'a'));
                } else {
                    decryptedMessage.append(letter);
                }
            }
            log.info("DecryptedMessage {}", decryptedMessage);
            return decryptedMessage.toString();
        };
        return droidMessageDecryptor.processMessage(message, decryptionKey);
    }

    public void sendMessage(Droid droidRecipient, String message, int encryptionKey) {
        log.info("Send message for {}", droidRecipient.name());
        String encryptedMessage = encryptMessage(message, encryptionKey);
        droidRecipient.receiveMessage(encryptedMessage, encryptionKey);
    }

    private void receiveMessage(String encryptedMessage, int encryptionKey) {
        decryptMessage(encryptedMessage, encryptionKey);
    }
}
