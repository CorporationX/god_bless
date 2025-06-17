package school.faang.secrets_droids;

public class Droid {
    private final String name;

    public Droid(String name) {
        this.name = name;
    }

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

    public String decryptMessage(String message, int key) {
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
        return decryptor.encrypt(message, key);
    }

    public void sendMessage(Droid droid, String message, int key) {
        String messageDecrypt = encryptMessage(message, key);
        System.out.println(this.name + " Отправил зашифрованное сообщение: "
                + messageDecrypt);
        receiveMessage(droid, messageDecrypt, key);
    }

    public void receiveMessage(Droid droid, String message, int key) {
        System.out.println(this.name + " Получил расшифрованное сообщение: " + droid.decryptMessage(message, key));
    }
}
