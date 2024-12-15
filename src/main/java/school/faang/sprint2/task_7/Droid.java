package school.faang.sprint2.task_7;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Droid {
    private String name;
    final int lettersOffset = 26;

    public String encryptMessage(String msg, int key) {
        DroidMessageEncryptor encryptor = (message, encryptionKey) -> {
            StringBuilder encryptedMessage = new StringBuilder();
            for (char ch : message.toCharArray()) {
                if (Character.isLetter(ch)) {
                    char base = Character.isLowerCase(ch) ? 'a' : 'A';
                    encryptedMessage.append((char) ((ch - base + encryptionKey) % 26 + base));
                } else {
                    encryptedMessage.append(ch);
                }
            }
            return encryptedMessage.toString();
        };
        return encryptor.encrypt(msg, key);  // Шифруем сообщение
    }

    public String decryptMessage(String msg, int key) {

        DroidMessageEncryptor encryptor = (message, encryptionKey) -> {
            StringBuilder decryptedMessage = new StringBuilder();
            for (char ch : message.toCharArray()) {
                if (Character.isLetter(ch)) {
                    char base = Character.isLowerCase(ch) ? 'a' : 'A';
                    decryptedMessage.append((char) ((ch - base - encryptionKey + lettersOffset)
                            % lettersOffset + base));
                } else {
                    decryptedMessage.append(ch);
                }
            }
            return decryptedMessage.toString();
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
