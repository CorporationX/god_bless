package school.faang.task_46278;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Droid {
    private static final int ALPHABET_LENGTH = 26;
    private String name;

    public String encryptMessage(String message, Integer key) {
        if (message == null) {
            throw new IllegalArgumentException("Сообщение не может быть null");
        }
        if (key == null) {
            throw new IllegalArgumentException("Ключ не может быть null");
        }

        DroidMessageEncryptor encryptor = (msg, encryptionKey) -> {
            StringBuilder encryptedMessage = new StringBuilder();
            for (char c : msg.toCharArray()) {
                if (Character.isLetter(c)) {
                    char base = Character.isUpperCase(c) ? 'A' : 'a';
                    encryptedMessage.append((char) ((c - base + encryptionKey) % ALPHABET_LENGTH + base));
                } else {
                    encryptedMessage.append(c);
                }
            }
            return encryptedMessage.toString();
        };

        return encryptor.encrypt(message, key);
    }

    public String decryptMessage(String message, Integer key) {
        if (message == null) {
            throw new IllegalArgumentException("Сообщение не может быть null");
        }
        if (key == null) {
            throw new IllegalArgumentException("Ключ не может быть null");
        }

        DroidMessageEncryptor decrypt = (msg, encryptionKey) -> {
            StringBuilder decryptedMessage = new StringBuilder();
            for (char c : msg.toCharArray()) {
                if (Character.isLetter(c)) {
                    char base = Character.isUpperCase(c) ? 'A' : 'a';
                    decryptedMessage.append((char)
                            ((c - base - encryptionKey + ALPHABET_LENGTH) % ALPHABET_LENGTH + base));
                } else {
                    decryptedMessage.append(c);
                }
            }
            return decryptedMessage.toString();
        };
        return decrypt.encrypt(message, key);
    }

    public void sendMessage(Droid receiver, String message, Integer key) {
        if (receiver == null) {
            throw new IllegalArgumentException("Получатель не может быть null");
        }
        if (message == null) {
            throw new IllegalArgumentException("Сообщение не может быть null");
        }
        if (key == null) {
            throw new IllegalArgumentException("Ключ не может быть null");
        }

        String encryptedMessage = encryptMessage(message, key);
        System.out.println(this.name + " выслал зашифрованное сообщение: " + encryptedMessage);
        receiver.receiveMessage(encryptedMessage, key);
    }

    public void receiveMessage(String message, Integer key) {
        if (message == null) {
            throw new IllegalArgumentException("Сообщение не может быть null");
        }
        if (key == null) {
            throw new IllegalArgumentException("Ключ не может быть null");
        }

        String decryptedMessage = decryptMessage(message, key);
        System.out.println(this.name + " получил расшифрованное сообщение: " + decryptedMessage);
    }
}
