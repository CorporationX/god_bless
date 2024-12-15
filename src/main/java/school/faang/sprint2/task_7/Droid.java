package school.faang.sprint2.task_7;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Droid {
    private String name;
    private static int LETTERS_OFFSET = 26;

    public String encryptMessage(String msg, int key) {
        return encryptingHandler(msg, key, true);
    }

    public String decryptMessage(String msg, int key) {

        return encryptingHandler(msg, key, false);
    }

    private String encryptingHandler(String msg, int key, boolean isEncrypting) {
        DroidMessageEncryptor encryptor = (message, encryptionKey) -> {
            StringBuilder encryptedMessage = new StringBuilder();
            for (char ch : message.toCharArray()) {
                if (Character.isLetter(ch)) {
                    char base = Character.isLowerCase(ch) ? 'a' : 'A';
                    encryptedMessage.append((char) (
                            (ch - base
                                    + (isEncrypting ? encryptionKey : -encryptionKey)
                                    + LETTERS_OFFSET)
                                    % LETTERS_OFFSET + base));
                } else {
                    encryptedMessage.append(ch);
                }
            }
            return encryptedMessage.toString();
        };
        return encryptor.encrypt(msg, key);
    }

    public void sendMessage(Droid droid, String message, int key) {
        String encryptedMessage = droid.encryptMessage(message, key);
        System.out.println("Droid " + droid.getName() + " sends: " + encryptedMessage);
        droid.receiveMessage(this, encryptedMessage, key);
    }

    public void receiveMessage(Droid droid, String message, int key) {
        String decryptedMessage = droid.decryptMessage(message, key);
        System.out.println("Droid " + droid.getName() + " receives: " + decryptedMessage);
    }
}
