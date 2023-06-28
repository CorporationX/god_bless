package faang.school.godbless.secondSprint.DroidSecrets;

public class Droid {
    private String message;
    private int key;

    public void sendEncryptedMessage(Droid droid, String message, int key) {
        DroidMessageEncryptor messageEncryptor = (m, k) -> {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < m.length(); i++) {
                char letter = m.charAt(i);
                if (Character.isLowerCase(letter)) {
                    letter = (char) ((letter + k - 'a') % 26 + 'a');
                } else if (Character.isUpperCase(letter)) {
                    letter = (char) ((letter + k - 'A') % 26 + 'A');
                }
                stringBuilder.append(letter);
            }
            return stringBuilder.toString();
        };

        String encryptedMessage = messageEncryptor.encrypt(message, key);
        droid.takeEncryptedMessage(encryptedMessage, key);
    }

    public void takeEncryptedMessage(String encryptedMessage, int encryptionKey) {
        message = encryptedMessage;
        key = encryptionKey;
    }

    public String getMessage() {
        return message;
    }

    public int getKey() {
        return key;
    }
}
