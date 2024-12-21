package faang.school.godbless.sprint_2.task_46369;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Droid {

    private final String name;

    private static final char A = 64;
    private static final char Z = 90;
    private static final char a = 97;
    private static final char z = 122;

    private static final DroidMessageEncryptor MESSAGE_ENCRYPTOR = (message, encryptionKey) -> {
        checkMessageAndEncryptorKey(message, encryptionKey);

        StringBuilder encryptedMessage = new StringBuilder();
        for (char c : message.toCharArray()) {
            if ((c >= A && c <= Z) || (c >= a && c <= z)) {
                encryptedMessage.append((char) (c + encryptionKey));
            } else {
                encryptedMessage.append(c);
            }
        }
        return encryptedMessage.toString();
    };

    private static final DroidMessageEncryptor MESSAGE_DECRYPTOR = (message, encryptionKey) -> {
        checkMessageAndEncryptorKey(message, encryptionKey);

        StringBuilder encryptedMessage = new StringBuilder();
        for (char c : message.toCharArray()) {
            if ((c >= (A + encryptionKey) && c <= (Z + encryptionKey))
                    || (c >= (a + encryptionKey) && c <= (z + encryptionKey))) {
                encryptedMessage.append((char) (c - encryptionKey));
            } else {
                encryptedMessage.append(c);
            }
        }
        return encryptedMessage.toString();
    };

    public void sendMessage(Droid droid, String message, int encryptionKey) {
        checkMessageAndEncryptorKey(message, encryptionKey);

        String newMessage = MESSAGE_ENCRYPTOR.processMessage(message, encryptionKey);
        System.out.println(this.getName() + " отправил зашифрованное сообщение: " + newMessage);
        droid.receiveMessage(newMessage, encryptionKey);
    }

    public void receiveMessage(String message, int encryptionKey) {
        checkMessageAndEncryptorKey(message, encryptionKey);

        System.out.println(this.getName() + " получил расшифрованное сообщение: "
                + MESSAGE_DECRYPTOR.processMessage(message, encryptionKey));
    }

    private static void checkMessageAndEncryptorKey(String message, int encryptionKey) {
        if (message == null) {
            throw new IllegalArgumentException("Message cannot be null");
        }
        if (encryptionKey < 0) {
            throw new IllegalArgumentException("Encryption key cannot be less than 0");
        }
    }
}
