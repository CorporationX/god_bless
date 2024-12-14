package school.faang.task_46271;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Droid {
    private final String name;

    private String encryptMessage(String message, int key) {

        DroidMessageEncryptor encryptor = (messageEncrypt, keyEncrypt) -> {
            StringBuilder encryptedMessage = new StringBuilder();
            for (char ch : messageEncrypt.toCharArray()) {
                if (Character.isLetter(ch)) {
                    char base = Character.isLowerCase(ch) ? 'a' : 'A';
                    encryptedMessage.append((char) ((ch - base + keyEncrypt) % 26 + base));
                } else {
                    encryptedMessage.append(ch);
                }
            }
            return encryptedMessage.toString();
        };
        return encryptor.encryptor(message, key);
    }

    private String decryptMessage(String message, int key) {

        DroidMessageEncryptor descriptor = (messageDescriptor, keyDescriptor) -> {
            StringBuilder decryptedMessage = new StringBuilder();
            for (char ch : messageDescriptor.toCharArray()) {
                if (Character.isLetter(ch)) {
                    char base = Character.isLowerCase(ch) ? 'a' : 'A';
                    decryptedMessage.append((char) ((ch - base - keyDescriptor + 26) % 26 + base));
                } else {
                    decryptedMessage.append(ch);
                }
            }
            return decryptedMessage.toString();
        };
        return descriptor.encryptor(message, key);
    }

    public void sendMessage(String message, int key, Droid droid) {
        try {
            System.out.println(this.getName() + " отправил зашифрованное сообщение: "
                    + encryptMessage(message, key));
            receiveMessage(encryptMessage(message, key), key, droid);

        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }

    }

    public void receiveMessage(String encryptMessage, int key, Droid droid) {
        System.out.println(droid.getName() + " получил расшифрованное сообщение: "
                + decryptMessage(encryptMessage, key));
    }

}
