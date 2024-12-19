package school.faang.task_46260;

public class Droid {

    private final String name;
    private final int numberOfLetters = 26;

    public Droid(String name) {
        this.name = name;
    }

    public String encryptMessage(String message, int key) {
        if (key == 0 || message == null || message.isEmpty()) {
            throw new IllegalArgumentException("Key cannot be null and message cannot be null or empty");
        }
        DroidMessageEncryptor encryptor = (msg, secretKey) -> {
            StringBuilder encryptedMessage = new StringBuilder();

            for (char ch : msg.toCharArray()) {
                if (Character.isLetter(ch)) {
                    char start = Character.isLowerCase(ch) ? 'a' : 'A';
                    encryptedMessage.append((char) ((ch - start + secretKey) % numberOfLetters + start));
                } else {
                    encryptedMessage.append(ch);
                }
            }
            return encryptedMessage.toString();
        };
        return encryptor.encrypt(message, key);
    }

    public String decryptMessage(String encryptedMessage, int key) {
        if (encryptedMessage == null || encryptedMessage.isEmpty() || key == 0) {
            throw new IllegalArgumentException("Key cannot be null and message cannot be null or empty");
        }
        DroidMessageEncryptor decryptor = (msg, decryptionKey) -> {
            StringBuilder decryptedMessage = new StringBuilder();
            for (char ch : msg.toCharArray()) {
                if (Character.isLetter(ch)) {
                    char start = Character.isLowerCase(ch) ? 'a' : 'A';
                    decryptedMessage.append((char)
                            ((ch - start - decryptionKey + numberOfLetters) % numberOfLetters + start));
                } else {
                    decryptedMessage.append(ch);
                }
            }
            return decryptedMessage.toString();
        };
        return decryptor.encrypt(encryptedMessage, key);
    }

    public void sendMessage(String message, int key, Droid droid) {
        if (message == null || message.isEmpty()) {
            throw new IllegalArgumentException("Message cannot be empty or null!");
        } else {
            message = encryptMessage(message, key);
            System.out.println(this.name + " sent: " + message);
            droid.receiveMessage(message, key);
        }
    }

    public void receiveMessage(String message, int key) {
        message = decryptMessage(message, key);
        System.out.println(this.name + " received: " + message + "\n");
    }
}