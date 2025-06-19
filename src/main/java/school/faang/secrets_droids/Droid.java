package school.faang.secrets_droids;

public class Droid {
    private static final int ALPHABET_SIZE = 26;
    private static final DroidMessageEncryptor encryptor = null;
    private static final DroidMessageEncryptor decryptor = null;
    private final String name;

    public Droid(String name) {
        this.name = name;
    }

    public String encryptMessage(String message, int key) {
        return processMessage(message, key, true);
    }

    public String decryptMessage(String message, int key) {
        return processMessage(message, key, false);
    }

    public void sendMessage(Droid droid, String message, int key) {
        String encryptedMessage = encryptMessage(message, key);
        System.out.println(this.name + " Отправил зашифрованное сообщение: "
                + encryptedMessage);
        receiveMessage(droid, encryptedMessage, key);
    }

    public void receiveMessage(Droid droid, String message, int key) {
        System.out.println(droid.name + " Получил расшифрованное сообщение: " + droid.decryptMessage(message, key));
    }

    private String processMessage(String message, int key, boolean isEncryption) {
        StringBuilder result = new StringBuilder();
        for (char ch : message.toCharArray()) {
            if (Character.isLetter(ch)) {
                char base = Character.isLowerCase(ch) ? 'a' : 'A';
                int shift = isEncryption ? key : (ALPHABET_SIZE - key) % ALPHABET_SIZE;
                result.append((char) ((ch - base + shift) % ALPHABET_SIZE + base));
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }
}
