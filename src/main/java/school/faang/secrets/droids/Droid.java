package school.faang.secrets.droids;


public record Droid(String name) {
    private static final int ALPHABET_LENGTH = 26;

    private static final DroidMessageEncryptor ENCRYPTOR = (msg, encryptionKey) -> {
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

    String encryptMessage(String message, int key) {
        return ENCRYPTOR.encrypt(message, key);
    }

    String decryptMessage(String encryptedMessage, int key) {
        return ENCRYPTOR.encrypt(encryptedMessage, ALPHABET_LENGTH - key);
    }

    void sendMessage(Droid droid, String message, int encryptionKey) {
        String encryptedMessage = encryptMessage(message, encryptionKey);
        System.out.println(this.name + " отправил зашифрованное сообщение: " + encryptedMessage);
        System.out.print(droid.name + " получил расшифрованное сообщение: ");
        receiveMessage(encryptedMessage, encryptionKey);
    }

    void receiveMessage(String encryptedMessage, int encryptionKey) {
        String decryptedMessage = decryptMessage(encryptedMessage, encryptionKey);
        System.out.println(decryptedMessage);
    }
}
