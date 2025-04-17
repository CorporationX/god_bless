package school.faang.stream2.drioidssecrets;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
public class Droid {
    private final String name;
    @Setter
    private DroidMessageEncryptor encryptor = ((message, key) -> {
        return message;//no encryption for now
    });

    private String encryptMessage(String message, int key) {
        return encryptor.doCryptography(message, key);
    }

    private String decryptMessage(String encrypted, int key) {
        return encryptor.doCryptography(encrypted, -key);
    }


    public void sendMessage(Droid recipient, String message, int encryptionKey) {
        String encryptedMessage = encryptMessage(message, encryptionKey);
        recipient.receiveMessage(encryptedMessage, encryptionKey);
        System.out.printf("%s отправил зашифрованное сообщение: %s\n", this.getName(), encryptedMessage);
    }

    public void receiveMessage(String message, int decryptionKey) {
        String decryptedMessage = decryptMessage(message, decryptionKey);
        System.out.printf("%s получил расшифрованное сообщение: %s\n", this.getName(), decryptedMessage);
    }
}
