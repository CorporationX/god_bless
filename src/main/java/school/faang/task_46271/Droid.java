package school.faang.task_46271;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Droid {
    private static final int ALPHABET_SIZE = 26;
    private final String name;

    private String encryptMessage(String message, int key) {

        DroidMessageEncryptor encryptor = (messageEncrypt, keyEncrypt) -> {
            StringBuilder encryptedMessage = new StringBuilder();
            for (char ch : messageEncrypt.toCharArray()) {
                if (Character.isLetter(ch)) {
                    char base = Character.isLowerCase(ch) ? 'a' : 'A';
                    encryptedMessage.append((char) ((ch - base + keyEncrypt) % ALPHABET_SIZE + base));
                } else {
                    encryptedMessage.append(ch);
                }
            }
            return encryptedMessage.toString();
        };
        return encryptor.encrypt(message, key);
    }

    private String decryptMessage(String message, int key) {

        DroidMessageEncryptor descriptor = (messageDescriptor, keyDescriptor) -> {
            StringBuilder decryptedMessage = new StringBuilder();
            for (char ch : messageDescriptor.toCharArray()) {
                if (Character.isLetter(ch)) {
                    char base = Character.isLowerCase(ch) ? 'a' : 'A';
                    decryptedMessage.append((char) ((ch - base - keyDescriptor + ALPHABET_SIZE)
                            % ALPHABET_SIZE + base));
                } else {
                    decryptedMessage.append(ch);
                }
            }
            return decryptedMessage.toString();
        };
        return descriptor.encrypt(message, key);
    }

    public void sendMessage(String message, int key, Droid droid) throws IllegalAccessException {
        if ((message == null) || (droid == null)) {
            throw new IllegalAccessException("Message or droid is null!!!");
        }
        System.out.println(this.getName() + " отправил зашифрованное сообщение: "
                    + encryptMessage(message, key));
        receiveMessage(encryptMessage(message, key), key, droid);

    }

    public void receiveMessage(String encryptMessage, int key, Droid droid) {
        System.out.println(droid.getName() + " получил расшифрованное сообщение: "
                + decryptMessage(encryptMessage, key));
    }

}
