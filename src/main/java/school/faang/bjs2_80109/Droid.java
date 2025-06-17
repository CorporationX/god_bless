package school.faang.bjs2_80109;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
public class Droid {
    public static final Integer ALPHABET_LENGTH = 26;

    private String name;

    private static final DroidMessageEncryptor CAESAR_ENCRYPTOR = (originalMessage, key) -> {
        StringBuilder result = new StringBuilder();
        for (char ch : originalMessage.toCharArray()) {
            if (Character.isLetter(ch)) {
                char base = Character.isLowerCase(ch) ? 'a' : 'A';
                result.append((char) ((ch - base + key) % ALPHABET_LENGTH + base));
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    };

    private String encryptMessage(String message, int encryptionKey, DroidMessageEncryptor encryptor) {
        return encryptor.encrypt(message, encryptionKey);
    }

    private String encryptMessage(String message, int encryptionKey) {
        return encryptMessage(message, encryptionKey, CAESAR_ENCRYPTOR);
    }

    private String decryptMessage(String encryptedMessage, int encryptionKey) {
        StringBuilder result = new StringBuilder();
        for (char ch : encryptedMessage.toCharArray()) {
            if (Character.isLetter(ch)) {
                char base = Character.isLowerCase(ch) ? 'a' : 'A';
                result.append((char) ((ch - base - encryptionKey) % ALPHABET_LENGTH + base));
            } else {
                result.append(ch);
            }
        }
        return result.toString();

    }

    public void sendMessage(
            Droid receiver,
            String message,
            int encryptionKey
    ) {
        //По условию задачи нужно через лямду и она не передается через аргументы в sendMessage
        String encryptedMessage = encryptMessage(message, encryptionKey);
        System.out.println(name + " отправил зашифрованное сообщение: " + encryptedMessage);
        receiver.receiveMessage(encryptedMessage, encryptionKey);
    }

    private void receiveMessage(
            String encryptedMessage,
            int encryptionKey
    ) {
        String decryptedMessage = decryptMessage(encryptedMessage, encryptionKey);
        System.out.println(name + " получил расшифрованное сообщение: " + decryptedMessage);
    }
}
