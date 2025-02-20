package school.faang.droidssecrets;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public record Droid(String name) {

    private String encryptDecryptMessage(String message, int encryptionKey) {
        DroidMessageEncryptor droidMessageEncryptor = (msg, key) -> message.chars()
                .mapToObj(letter -> {
                    if (Character.isUpperCase(letter)) {
                        return (char) (((letter - 'A' + key + 26) % 26) + 'A');
                    } else if (Character.isLowerCase(letter)) {
                        return (char) (((letter - 'a' + key + 26) % 26) + 'a');
                    } else {
                        return (char) letter;
                    }
                })
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();
        return droidMessageEncryptor.processMessage(message, encryptionKey);
    }

    public void sendMessage(Droid droidRecipient, String message, int encryptionKey) {
        log.info("Send message for {}", droidRecipient.name());
        String encryptedMessage = encryptDecryptMessage(message, encryptionKey);
        log.info("EncryptedMessage {}", encryptedMessage);
        droidRecipient.receiveMessage(encryptedMessage, encryptionKey);
    }

    private void receiveMessage(String encryptedMessage, int encryptionKey) {
        String decryptedMessage = encryptDecryptMessage(encryptedMessage, -encryptionKey);
        log.info("DecryptedMessage {}", decryptedMessage);
    }
}
