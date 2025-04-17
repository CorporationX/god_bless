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
        StringBuilder result = new StringBuilder();
        for (char c : message.toCharArray()) {
            char e = (char) ((int) c + key);
            char u = (key >= 0) ? c : e;
            result.append(Character.isAlphabetic(u) ? e : c);
        }
        return result.toString();
    });

    private String encryptMessage(String message, int key) {
        return encryptor.doCryptography(message, key);
    }

    private String decryptMessage(String encrypted, int key) {
        return encryptor.doCryptography(encrypted, -key);
    }

    public void sendMessage(Droid recipient, String message, int encryptionKey) {
        String encryptedMessage = encryptMessage(message, encryptionKey);
        System.out.printf("%s отправил зашифрованное сообщение: %s\n", this.getName(), encryptedMessage);
        recipient.receiveMessage(encryptedMessage, encryptionKey);
    }

    public void receiveMessage(String message, int decryptionKey) {
        String decryptedMessage = decryptMessage(message, decryptionKey);
        System.out.printf("%s получил расшифрованное сообщение: %s\n", this.getName(), decryptedMessage);
    }
}
