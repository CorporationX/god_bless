package faang.school.godbless.sprint2.secretsOfDroids;

public class Droid {
    public String sendEncryptedMessage(String message, int encryptionKey) {
        DroidMessageEncryptor droidMessageEncryptor = (mg, key) -> {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < mg.length(); i++) {
                result.append((char)(mg.charAt(i) + key));
            }
            return result.toString();
        };
        return droidMessageEncryptor.encrypt(message, encryptionKey);
    }

    public String receiveEncryptedMessage(String message, int encryptionKey) {
        if (message.isEmpty()) {
            throw new IllegalArgumentException("Строка не может быть пустой");
        }
        DroidMessageEncryptor droidMessageEncryptor = (mg, key) -> {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < mg.length(); i++) {
                result.append((char)(mg.charAt(i) - key));
            }
            return result.toString();
        };
        return droidMessageEncryptor.encrypt(message, encryptionKey);
    }
}
