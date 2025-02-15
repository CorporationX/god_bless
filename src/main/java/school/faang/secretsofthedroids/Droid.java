package school.faang.secretsofthedroids;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString

public class Droid {

    private static final int ALPHABET_CHARACTERS = 26;

    private String name;

    public void sendMessage(Droid droid, String message, int incryptionkey) {
        String secretMessage = encryptMessage(message, incryptionkey);
        System.out.println(this.name + " отправил зашифрованное сообщение: " + secretMessage);
        receiveMessage(secretMessage, incryptionkey, droid);
    }

    public void receiveMessage(String message, int incryptionkey, Droid droid) {
        String unsecretMessage = decryptMessage(message, incryptionkey);
        System.out.println(droid.getName() + " получил расшифрованное сообщение: " + unsecretMessage);
    }

    public String encryptMessage(String message, int key) {
        DroidMessageEncryptor encryptor = (msg, encryptionKey) -> {
            StringBuilder encryptedMessage = new StringBuilder();
            for (char ch : msg.toCharArray()) {
                if (Character.isLetter(ch)) {
                    char base = Character.isLowerCase(ch) ? 'a' : 'A';
                    encryptedMessage.append((char) ((ch - base + encryptionKey)
                            % ALPHABET_CHARACTERS + base));
                } else {
                    encryptedMessage.append(ch);
                }
            }
            return encryptedMessage.toString();
        };
        return encryptor.encrypt(message, key);  // Шифруем сообщение
    }


    public String decryptMessage(String encryptedMessage, int key) {
        DroidMessageEncryptor decryptor = (msg, decryptionKey) -> {
            StringBuilder decryptedMessage = new StringBuilder();
            for (char ch : msg.toCharArray()) {
                if (Character.isLetter(ch)) {
                    char base = Character.isLowerCase(ch) ? 'a' : 'A';
                    decryptedMessage.append((char) ((ch - base - decryptionKey
                            + ALPHABET_CHARACTERS) % ALPHABET_CHARACTERS + base));
                } else {
                    decryptedMessage.append(ch);
                }
            }
            return decryptedMessage.toString();
        };
        return decryptor.encrypt(encryptedMessage, key);  // Расшифровываем сообщение
    }

}