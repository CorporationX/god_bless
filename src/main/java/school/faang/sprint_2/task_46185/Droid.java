package school.faang.sprint_2.task_46185;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Droid {
    private String name;

    public String encryptMessage(String message, int key) {
        MessageEncryptor encryptor = (msg, encryptionKey) -> {
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
        MessageDecryptor decryptor = (msg, decryptionKey) -> {
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
        return decryptor.decrypt(encryptedMessage, key);
    }

    public void sendMessage(Droid receiver, String message, int key) {
        String encryptedMessage = encryptMessage(message, key);
        System.out.println(this.name + " отправил зашифрованное сообщение: " + encryptedMessage);
        receiver.receiveMessage(encryptedMessage, key);
    }

    public void receiveMessage(String encryptedMessage, int key) {
        String decryptedMessage = decryptMessage(encryptedMessage, key);
        System.out.println(this.name + " получил расшифрованное сообщение: " + decryptedMessage);
    }
}
