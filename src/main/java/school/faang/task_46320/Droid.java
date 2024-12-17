package school.faang.task_46320;

public class Droid {
    private final String name;

    public Droid(String name) {
        this.name = name;
    }

    public String encryptMessage(String message, int key, DroidMessageEncryptor encryptor) {
        return encryptor.encrypt(message, key);
    }

    public String decryptMessage(String encryptedMessage, int key, DroidMessageEncryptor decrypt) {
        return decrypt.encrypt(encryptedMessage, -key);
    }

    public void sendMessage(Droid recipient, String message, int key) {
        DroidMessageEncryptor encryptor = (msg, k) -> {
            StringBuilder encrypted = new StringBuilder();
            for (char c : msg.toCharArray()) {
                if (Character.isLetter(c)) {
                    char base = Character.isUpperCase(c) ? 'A' : 'a';
                    encrypted.append((char) ((c - base + k) % 26 + base));
                } else {
                    encrypted.append(c);
                }
            }
            return encrypted.toString();
        };

        String encryptedMessage = encryptMessage(message, key, encryptor);
        System.out.println(this.name + " отправил зашифрованное сообщение: " + encryptedMessage);
        recipient.receiveMessage(encryptedMessage, key);
    }

    public void receiveMessage(String encryptedMessage, int key) {
        DroidMessageEncryptor decrypt = (msg, k) -> {
            StringBuilder decrypted = new StringBuilder();
            for (char c : msg.toCharArray()) {
                if (Character.isLetter(c)) {
                    char base = Character.isUpperCase(c) ? 'A' : 'a';
                    decrypted.append((char) ((c - base + k + 26) % 26 + base));
                } else {
                    decrypted.append(c);
                }
            }
            return decrypted.toString();
        };

        String decryptedMessage = decryptMessage(encryptedMessage, key, decrypt);
        System.out.println(this.name + " получил расшифрованное сообщение: " + decryptedMessage);
    }
}
