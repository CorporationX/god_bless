package school.faang.encryption;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class Droid {
    private final String name;

    public void sendMessage(Droid receiver, String message, int key) {
        String encryptedMessage = encryptMessage(message, key);
        log.info("{} sent encrypted message {}:", name, encryptedMessage);
        receiver.receiveMessage(encryptedMessage, key);
    }

    public void receiveMessage(String message, int key) {
        String decryptedMessage = decryptMessage(message, key);
        log.info("{} received a decrypted message {}:", name, decryptedMessage);
    }

    private String encryptMessage(String message, int key) {
        DroidMessageEncryptor encryptor = (mgs, encryptKey) -> {
            StringBuilder encrypted = new StringBuilder();
            for (char ch : mgs.toCharArray()) {
                if (Character.isLetter(ch)) {
                    char base = Character.isLowerCase(ch) ? 'a' : 'A';
                    encrypted.append((char) ((ch - base + key) % 26 + base));
                } else {
                    encrypted.append(ch);
                }
            }
            return encrypted.toString();
        };
        return encryptor.encrypt(message, key);
    }

    private String decryptMessage(String message, int key) {
        DroidMessageEncryptor decryptor = (mgs, decryptKey) -> {
            StringBuilder decrypted = new StringBuilder();
            for (char ch : mgs.toCharArray()) {
                if (Character.isLetter(ch)) {
                    char base = Character.isLowerCase(ch) ? 'a' : 'A';
                    decrypted.append((char) ((ch - base - key + 26) % 26 + base));
                } else {
                    decrypted.append(ch);
                }
            }
            return decrypted.toString();
        };
        return decryptor.encrypt(message, key);
    }
}