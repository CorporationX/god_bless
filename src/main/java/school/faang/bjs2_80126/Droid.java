package school.faang.bjs2_80126;

public class Droid {
    public String encryptMessage(String message, int key) {
        DroidMessageEncryptor encryptor = (msg, encryptionKey) -> {
            StringBuilder encryptedMessage = new StringBuilder();
            for (char c : msg.toCharArray()) {
                if (Character.isLetter(c)) {
                    char base = Character.isLowerCase(c) ? 'a' : 'A';
                    encryptedMessage.append((char) ((c - base + encryptionKey) % 26 + base));
                } else {
                    encryptedMessage.append(c);
                }
            }
            return encryptedMessage.toString();
        };
        return encryptor.encrypt(message, key);
    }

    public String decryptMessage(String encryptedMessage, int key) {
        DroidMessageEncryptor decryptor = (msg, decryptionKey) -> {
            StringBuilder decryptedMessage = new StringBuilder();
            for (char c : msg.toCharArray()) {
                if (Character.isLetter(c)) {
                    char base = Character.isLowerCase(c) ? 'a' : 'A';
                    decryptedMessage.append((char) ((c - base - decryptionKey + 26) % 26 + base));
                } else {
                    decryptedMessage.append(c);
                }
            }
            return decryptedMessage.toString();
        };
        return decryptor.encrypt(encryptedMessage, key);
    }

    public void sendMessage(String message, int key, Droid receiver) {
        String encrypted = encryptMessage(message, key);
        System.out.println("Зашифрованное сообщение: " + encrypted);
        receiver.receiveMessage(encrypted, key);
    }

    public void receiveMessage(String message, int key) {
        String decrypted = decryptMessage(message, key);
        System.out.println("Received message: " + decrypted);
    }
}