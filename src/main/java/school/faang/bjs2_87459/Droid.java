package school.faang.bjs2_87459;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Droid {
    private String name;

    private String encryptMessage(String message, int key) {
        DroidMessageEncryptor encryptor = (msg, encryptionKey) -> {
            StringBuilder encryptedMessage = new StringBuilder();
            for (char ch : msg.toCharArray()) {
                if (Character.isLetter(ch)) {
                    char base = Character.isLowerCase(ch) ? 'a' : 'A';
                    char encryptedChar = (char) ((ch - base + encryptionKey + 26) % 26 + base);
                    encryptedMessage.append(encryptedChar);
                } else {
                    encryptedMessage.append(ch);
                }
            }
            return encryptedMessage.toString();
        };
        return encryptor.encrypt(message, key);
    }

    private String decryptMessage(String encryptedMessage, int key) {
        return encryptMessage(encryptedMessage, -key);
    }

    public void sendMessage(Droid receiver, String message, int key) {
        String encryptedMessage = encryptMessage(message, key);
        System.out.println(name + " отправил зашифрованное сообщение: " + encryptedMessage);

        String decryptedMessage = receiver.decryptMessage(encryptedMessage, key);
        System.out.println(receiver.getName() + " получил расшифрованное сообщение: " + decryptedMessage);
    }
}
