package school.faang.task_46221;

import lombok.Getter;

@Getter
public class Droid {
    private final String name;

    public Droid(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("name не может быть пустым");
        }
        this.name = name;
    }

    public String encryptMessage(String message, int key) {
        DroidMessageCryptoEngine encryptor = (msg, encryptionKey) -> {
            StringBuilder encryptedMessage = new StringBuilder();
            for (char ch : msg.toCharArray()) {
                if (Character.isLetter(ch)) {
                    char base = Character.isLowerCase(ch) ? 'a' : 'A';
                    encryptedMessage.append(
                            (char) ((ch - base + encryptionKey) % 26 + base));
                } else {
                    encryptedMessage.append(ch);
                }
            }
            return encryptedMessage.toString();
        };
        return encryptor.encryptOrDecrypt(message, key);
    }

    public String decryptMessage(String encryptedMessage, int key) {
        DroidMessageCryptoEngine decryptor = (msg, decryptionKey) -> {
            StringBuilder decryptedMessage = new StringBuilder();
            for (char ch : msg.toCharArray()) {
                if (Character.isLetter(ch)) {
                    char base = Character.isLowerCase(ch) ? 'a' : 'A';
                    decryptedMessage.append(
                            (char) ((ch - base - decryptionKey + 26) % 26 + base));
                } else {
                    decryptedMessage.append(ch);
                }
            }
            return decryptedMessage.toString();
        };
        return decryptor.encryptOrDecrypt(encryptedMessage, key);
    }

    public void sendMessage(Droid receiver,
                            String message,
                            int key,
                            String senderDroidName) {
        if (receiver == null) {
            throw new IllegalArgumentException("receiver не может быть null");
        }
        if (message == null || message.isEmpty()) {
            throw new IllegalArgumentException("message не может быть пустым");
        }
        if (senderDroidName == null || senderDroidName.isEmpty()) {
            throw new IllegalArgumentException("senderDroidName не может быть пустым");
        }
        String encryptedMessage = encryptMessage(message, key);
        System.out.printf("%s отправил зашифрованное сообщение: %s%n",
                senderDroidName, encryptedMessage);
        receiver.receiveMessage(encryptedMessage, key, receiver.getName());
    }

    public void receiveMessage(String encryptedMessage, int key, String receiverDroidName) {
        if (encryptedMessage == null || encryptedMessage.isEmpty()) {
            throw new IllegalArgumentException("encryptedMessage не может быть пустым");
        }
        if (receiverDroidName == null || receiverDroidName.isEmpty()) {
            throw new IllegalArgumentException("receiverDroidName не может быть пустым");
        }
        String decryptedMessage = decryptMessage(encryptedMessage, key);
        System.out.printf("%s получил расшифрованное сообщение: %s%n",
                receiverDroidName, decryptedMessage);
    }
}
