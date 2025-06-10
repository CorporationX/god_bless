package school.faang.bjs2_80109;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Droid {
    private String name;

    public String encryptMessage(String message, int encryptionKey, DroidMessageEncryptor encryptor) {
        return encryptor.handle(message, encryptionKey);
    }

    private String decryptMessage(String encryptedMessage, int encryptionKey) {
        StringBuilder result = new StringBuilder();
        for (char ch : encryptedMessage.toCharArray()) {
            if (Character.isLetter(ch)) {
                char base = Character.isLowerCase(ch) ? 'a' : 'A';
                result.append((char) ((ch - base - encryptionKey) % 26 + base));
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
        String encryptedMessage = encryptMessage(message, encryptionKey,
                (originalMessage, key) -> {
                    StringBuilder result = new StringBuilder();
                    for (char ch : originalMessage.toCharArray()) {
                        if (Character.isLetter(ch)) {
                            char base = Character.isLowerCase(ch) ? 'a' : 'A';
                            result.append((char) ((ch - base + key) % 26 + base));
                        } else {
                            result.append(ch);
                        }
                    }
                    return result.toString();
                });
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
