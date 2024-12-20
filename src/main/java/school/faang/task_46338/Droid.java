package school.faang.task_46338;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
public class Droid {
    private final String name;


    public void sendMessage(Droid droid, String message, int key) {
        String encrMessage = encryptMessage(message, key);
        System.out.println(this.name + " отправил зашифрованное сообщение: " + encrMessage);
        droid.receiveMessage(encrMessage, key);
    }

    public void receiveMessage(String encrMessage, int key) {
        String decrMessage = decryptMessage(encrMessage, key);
        System.out.println(this.name + " получил расшифрованное сообщение: " + decrMessage);
    }


    public String encryptMessage(String message, int key) {
        DroidMessageEncryptor encryptor = (msg, encryptorKey) -> {
            StringBuilder encryptedMessage = new StringBuilder();
            for (char c : msg.toCharArray()) {
                if (Character.isLetter(c)) {
                    char base = Character.isLowerCase(c) ? 'a' : 'A';
                    encryptedMessage.append((char) ((c - base + encryptorKey) % 26 + base));
                } else {
                    encryptedMessage.append(c);
                }
            }
            return encryptedMessage.toString();
        };
        return encryptor.encrypt(message, key);
    }


    public String decryptMessage(String message, int key) {
        DroidMessageEncryptor encryptor = (msg, encryptorKey) -> {
            StringBuilder encryptedMessage = new StringBuilder();
            for (char c : message.toCharArray()) {
                if (Character.isLetter(c)) {
                    char base = Character.isLowerCase(c) ? 'a' : 'A';
                    encryptedMessage.append((char) ((c - base - encryptorKey + 26) % 26 + base));
                } else {
                    encryptedMessage.append(c);
                }
            }
            return encryptedMessage.toString();
        };
        return encryptor.encrypt(message, key);
    }


}
