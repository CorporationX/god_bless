package school.faang.bjs2_71714;

public class Droid {
    private final DroidMessageEncryptor droidMessageEncryptor = (message1, key1) -> {
        StringBuilder changedMessage = new StringBuilder();
        int ALPHABET_LENGTH = 26;
        for (char a : message1.toCharArray()) {
            if (Character.isLetter(a)) {
                char base = Character.isLowerCase(a) ? 'a' : 'A';
                changedMessage.append((char) ((a - base + key1) % ALPHABET_LENGTH + base));
            } else {
                changedMessage.append(a);
            }
        }
        return changedMessage.toString();
    };

    public String encryptMessage(String message, int key) {
        return droidMessageEncryptor.encryption(message, key);
    }

    public String decryptMessage(String message, int key) {
        return droidMessageEncryptor.encryption(message, -1 * key);
    }

    public void sendMessage(Droid droid, String message, int key) {
        String encryptedMessage = encryptMessage(message, key);
        System.out.printf("Sent message: %s", encryptedMessage + '\n');
        droid.receiveMessage(encryptedMessage, key);
    }

    public void receiveMessage(String message, int key) {
        String decryptedMessage = decryptMessage(message, key);
        System.out.printf("Received message: %s", decryptedMessage + '\n');
    }
}
