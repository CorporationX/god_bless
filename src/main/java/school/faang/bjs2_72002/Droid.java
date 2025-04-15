package school.faang.bjs2_72002;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@EqualsAndHashCode
@Getter
@Slf4j
public class Droid {
    private final String name;

    public Droid(String name) {
        this.name = name;
    }

    DroidMessageEncryptor droidMessageEncryptor = (msg, encryptionKey) -> {
        StringBuilder encryptedMessage = new StringBuilder();
        for (char ch : msg.toCharArray()) {
            if (Character.isLetter(ch)) {
                char base = Character.isLowerCase(ch) ? 'a' : 'A';
                encryptedMessage.append((char) ((ch - base + encryptionKey) % 26 + base));
            } else {
                encryptedMessage.append(ch);
            }
        }
        return encryptedMessage.toString();
    };

    DroidMessageEncryptor droidMessageDecryptor = (msg, decryptionKey) -> {
        StringBuilder decryptedMessage = new StringBuilder();
        for (char ch : msg.toCharArray()) {
            if (Character.isLetter(ch)) {
                char base = Character.isLowerCase(ch) ? 'a' : 'A';
                decryptedMessage.append((char) ((ch - base - decryptionKey + 26) % 26 + base));
            } else {
                decryptedMessage.append(ch);
            }
        }
        return decryptedMessage.toString();
    };

    public String encryptMessage(String message, int key) {
        return this.droidMessageEncryptor.encrypt(message, key);
    }

    public String decryptMessage(String message, int key) {
        return this.droidMessageDecryptor.encrypt(message, key);
    }

    public void receiveMessage(String message, int key) {
        log.info("{} received a decrypted message:{}", this.name, decryptMessage(message, key));
    }

    public void sendMessage(Droid droid, String message, int key) {
        String encryptedMessage = encryptMessage(message, key);
        log.info("{} sent an encrypted message:{}", this.name, encryptedMessage);
        droid.receiveMessage(encryptedMessage, key);
    }
}
