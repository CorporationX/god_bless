package school.faang.droidsecrets;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Droid {

    private String name;

    public void sendMessage(Droid recipient, String message, int key) {
        String encryptedMessage = encryptMessage(message, key);
        System.out.println(name + " Отправил зашифрованное сообщение: " + encryptedMessage);
        System.out.println(recipient.name + " Получил расшифрованное " + "сообщение: " + decryptMessage(encryptedMessage, key));
    }

    public String encryptMessage(String message, int key) {
        DroidMessageEncryptor encryptor = (msg, encryptionKey) -> {
            StringBuilder encryptedMessage = new StringBuilder();
            for (char ch : msg.toCharArray()) {
                if (Character.isLetter(ch)) {
                    char base = Character.isLowerCase(ch) ? 'a' : 'A';
                    encryptedMessage.append((char) ((ch - base + encryptionKey) % 26 + base));
                } else {
                    encryptedMessage.append(ch);
                }
            }
            return encryptedMessage.toString();
        };
        return encryptor.encrypt(message, key);
    }

    public String decryptMessage(String encryptedMessage, int key) {
        DroidMessageEncryptor decryptor = (msg, decryptionKey) -> {
            StringBuilder decryptedMessage = new StringBuilder();
            for (char ch : msg.toCharArray()) {
                if (Character.isLetter(ch)) {
                    char base = Character.isLowerCase(ch) ? 'a' : 'A';
                    decryptedMessage.append((char) ((ch - base - decryptionKey + 26) % 26 + base));
                } else {
                    decryptedMessage.append(ch);
                }
            }
            return decryptedMessage.toString();
        };
        return decryptor.encrypt(encryptedMessage, key);
    }

}

