package secretsOfDroids;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Droid {
    private String name;

    public String encryptMessage(String message, int key) {
        DroidMessageEncryptor encryptor = (msg, k) -> {
            StringBuilder sb = new StringBuilder();
            for (char c : msg.toCharArray()) {
                if (Character.isLetter(c)) {
                    char base = Character.isUpperCase(c) ? 'A' : 'a';
                    sb.append((char) ((c - base + k) % 26 + base));
                } else {
                    sb.append(c);
                }
            }
            return sb.toString();
        };
        return encryptor.encrypt(message, key);
    }

    public String decryptMessage(String message, int key) {
        DroidMessageEncryptor encryptor = (msg, k) -> {
            StringBuilder sb = new StringBuilder();
            for (char c : msg.toCharArray()) {
                if (Character.isLetter(c)) {
                    char base = Character.isUpperCase(c) ? 'A' : 'a';
                    sb.append((char) ((c - base - k + 26) % 26 + base));
                } else {
                    sb.append(c);
                }
            }
            return sb.toString();
        };
        return encryptor.encrypt(message, key);
    }

    public void sendMessage(Droid receiver, String message, int encryptionKey) {
        String encryptedMessage = encryptMessage(message, encryptionKey);
        System.out.println(this.name + " отправил зашифрованное сообщение: " + encryptedMessage);
        receiver.receiveMessage(encryptedMessage, encryptionKey);
    }

    public void receiveMessage(String encryptedMessage, int encryptionKey) {
        String decryptedMessage = decryptMessage(encryptedMessage, encryptionKey);
        System.out.println(this.name + " получил расшифрованное сообщение: " + decryptedMessage);
    }
}

