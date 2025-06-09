package school.faang.bjs2_80062_droid_encrypt;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Slf4j
public class Droid {
    @Getter
    private final String name;
    private final DroidMessageEncryptor encryptor = (input, key) -> {
        StringBuilder result = new StringBuilder();

        int shift = key % 26;

        for (char c : input.toCharArray()) {
            if (Character.isUpperCase(c)) {
                char shifted = (char) ('A' + (c - 'A' + shift + 26) % 26);
                result.append(shifted);
            } else if (Character.isLowerCase(c)) {
                char shifted = (char) ('a' + (c - 'a' + shift + 26) % 26);
                result.append(shifted);
            } else {
                result.append(c);
            }
        }

        return result.toString();
    };

    private String encryptMessage(String message, int key) {
        return encryptor.doCrypto(message, key);
    }

    private String decryptMessage(String message, int key) {
        return encryptor.doCrypto(message, -key);
    }

    public void sendMessage(Droid recipient, String message, int key) {
        log.info("Sending message '{}' to droid {}", message, recipient.getName());
        recipient.receiveMessage(encryptMessage(message, key), key);
    }

    public void receiveMessage(String message, int key) {
        log.info("Received encrypted message '{}'", message);
        String decryptedMessage = decryptMessage(message, key);
        log.info("Decrypted message '{}'", decryptedMessage);
    }
}
