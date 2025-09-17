package school.faang.m2_1_functional_interfaces.droidssecrets;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
public class Droid {

    private final String name;
    private String lastReceivedMessage;

    public void sendMessage(Droid recipient, String message, int encryptionKey) {
        String encryptedMessage = encryptMessage(message, encryptionKey);
        recipient.receiveMessage(encryptedMessage, encryptionKey);
    }

    public void receiveMessage(String encryptedMessage, int encryptionKey) {
        String decryptedMessage = decryptMessage(encryptedMessage, encryptionKey);
        this.lastReceivedMessage = decryptedMessage;
        System.out.println(decryptedMessage);
    }

    private String encryptMessage(String message, int encryptionKey) {

        String encryptedMessage = takeCipher(message, encryptionKey, caesarCipher);
        System.out.println("Зашифрованное сообщение: " + encryptedMessage);
        return encryptedMessage;
    }

    private String decryptMessage(String encryptedMessage, int encryptionKey) {
        return takeCipher(encryptedMessage, -encryptionKey, caesarCipher);
    }

    private DroidMessageEncryptor caesarCipher = (message, key) -> {
        int effectiveKey = key % 26;
        if (effectiveKey < 0) {
            effectiveKey += 26;
        }

        StringBuilder result = new StringBuilder(message.length());

        for (char c : message.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                char shifted = (char) (base + (c - base + effectiveKey) % 26);
                result.append(shifted);
            } else {
                result.append(c);
            }
        }

        return result.toString();
    };

    private String takeCipher(String message, int encryptionKey, DroidMessageEncryptor encryptor) {
        return encryptor.encrypt(message, encryptionKey);
    }
}
