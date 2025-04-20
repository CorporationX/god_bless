package school.faang.sprinttwo.secretsofthedroids;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Droid {
    private String name;

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

    public void sendMessage(Droid droid, String message, int key) {
        String encryptedMessage = droid.encryptMessage(message, key);
        System.out.printf("%s отправил зашифрованное сообщение: %s%n", this.name, encryptedMessage);
        receiveMessage(droid, encryptedMessage, key);
    }

    public void receiveMessage(Droid droid, String encryptedMessage, int key) {
        String decryptedMessage = droid.decryptMessage(encryptedMessage, key);
        System.out.printf("%s отправил зашифрованное сообщение: %s%n", droid.name, decryptedMessage);
    }
}