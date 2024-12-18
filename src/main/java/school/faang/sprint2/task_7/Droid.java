package school.faang.sprint2.task_7;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class Droid {
    private String name;
    private static final int LETTERS_OFFSET = 26;

    private String encryptingHandler(String msg, int key) {
        DroidMessageEncryptor encryptor = (message, encryptionKey) -> {
            StringBuilder encryptedMessage = new StringBuilder();
            for (char ch : message.toCharArray()) {
                if (Character.isLetter(ch)) {
                    char base = Character.isLowerCase(ch) ? 'a' : 'A';
                    encryptedMessage.append((char) (
                            (ch - base + encryptionKey + LETTERS_OFFSET) % LETTERS_OFFSET + base));
                } else {
                    encryptedMessage.append(ch);
                }
            }
            return encryptedMessage.toString();
        };
        return encryptor.encrypt(msg, key);
    }

    public void sendMessage(Droid droid, String message, int key) {
        String encryptedMessage = droid.encryptingHandler(message, key);
        System.out.println("Droid " + droid.getName() + " sends: " + encryptedMessage);
        droid.receiveMessage(this, encryptedMessage, key);
    }

    public void receiveMessage(Droid droid, String message, int key) {
        String decryptedMessage = droid.encryptingHandler(message, -key);
        System.out.println("Droid " + droid.getName() + " receives: " + decryptedMessage);
    }
}
