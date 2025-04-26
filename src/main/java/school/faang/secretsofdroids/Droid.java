package school.faang.secretsofdroids;

public class Droid {
    private String name;
    private DroidMessageEncryptor encryptor;

    public Droid(String name) {
        this.name = name;
        this.encryptor = (message, key) -> {
            StringBuilder encrypted = new StringBuilder();
            for (char c : message.toCharArray()) {
                if (Character.isLetter(c)) {
                    char base = Character.isLowerCase(c) ? 'a' : 'A';
                    int originalPosition = c - base;
                    int newPosition = (originalPosition + key) % 26;
                    if (newPosition < 0) {
                        newPosition += 26;
                    }
                    c = (char) (base + newPosition);
                }
                encrypted.append(c);
            }
            return encrypted.toString();
        };
    }

    public String encryptMessage(String message, int key) {
        return encryptor.encrypt(message, key);
    }

    public String decryptMessage(String encryptedMessage, int key) {
        return encryptor.encrypt(encryptedMessage, -key);
    }

    public void sendMessage(Droid recipient, String message, int key) {
        String encrypted = encryptMessage(message, key);
        System.out.println(name + " отправил зашифрованное сообщение: " + encrypted);
        recipient.receiveMessage(encrypted, key);
    }

    public void receiveMessage(String encryptedMessage, int key) {
        String decrypted = decryptMessage(encryptedMessage, key);
        System.out.println(name + " получил расшифрованное сообщение: " + decrypted);
    }
}
