package school.faang.sprint_2.task_46215;

public class DroidMessageManager {
    private static final int RU_ALPHABET_LETTERS = 33;

    public String encryptMessage(String message, int encryptionKey) {
        DroidMessageEncryptor encryptor = ((msg, key) -> {
            StringBuilder encryptedMessage = new StringBuilder();

            for (char ch : msg.toCharArray()) {
                if (Character.isLetter(ch)) {
                    char base = Character.isLowerCase(ch) ? 'а' : 'А';
                    encryptedMessage.append((char) ((ch - base + encryptionKey) % RU_ALPHABET_LETTERS + base));
                } else {
                    encryptedMessage.append(ch);
                }
            }
            return encryptedMessage.toString();
        });
        return encryptor.encrypt(message, encryptionKey);
    }

    public String decryptMessage(String message, int encryptionKey) {
        DroidMessageEncryptor decryptor = ((msg, key) -> {
            StringBuilder decryptedMessage = new StringBuilder();

            for (char ch : msg.toCharArray()) {
                if (Character.isLetter(ch)) {
                    char base = Character.isLowerCase(ch) ? 'а' : 'А';
                    decryptedMessage.append((char) ((ch - base - encryptionKey + RU_ALPHABET_LETTERS)
                            % RU_ALPHABET_LETTERS + base));
                } else {
                    decryptedMessage.append(ch);
                }
            }
            return decryptedMessage.toString();
        });
        return decryptor.encrypt(message, encryptionKey);
    }
}
