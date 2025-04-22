package school.faang.droid_secret;

public class Droid {
    public String encryptMessage(String message, int key) {
        DroidMessageEncryptor encryptor = (msg, k) -> {
            StringBuilder result = new StringBuilder();
            for (char c : msg.toCharArray()) {
                if (Character.isLetter(c)) {
                    char base = Character.isLowerCase(c) ? 'a' : 'A';
                    c = (char) (((c - base + k) % 26) + base);
                }
                result.append(c);
            }
            return result.toString();
        };
        return encryptor.processMessage(message, key);
    }

    public String decryptMessage(String message, int key) {
        return encryptMessage(message, 26 - (key % 26));
    }

    public void sendMessage(String message, int key, Droid recipient) {
        String encryptedMessage = encryptMessage(message, key);
        System.out.println("Отправлено зашифрованное сообщение: " + encryptedMessage);
        recipient.receiveMessage(encryptedMessage, key);
    }

    public void receiveMessage(String encryptedMessage, int key) {
        String decryptedMessage = decryptMessage(encryptedMessage, key);
        System.out.println("Расшифрованное сообщение: " + decryptedMessage);
    }
}
