package school.faang.secretsofthedroids;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Droid {

    private String name;

    public void sendMessage(Droid droid, String message, int incryptionkey) {
        String secretMessage = encryptMessage(message, incryptionkey);
        System.out.println(" отправил зашифрованное сообщение: " + secretMessage);
        receiveMessage(secretMessage, incryptionkey, droid);
    }

    public void receiveMessage(String message, int incryptionkey, Droid droid) {
        String unsecretMessage = decryptMessage(message, incryptionkey);
        System.out.println(droid + "получил расшифрованное сообщение: " + unsecretMessage);
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
        return encryptor.encrypt(message, key);  // Шифруем сообщение
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
        return decryptor.encrypt(encryptedMessage, key);  // Расшифровываем сообщение
    }
}