package faang.school.godbless.lambda.droids;

public class Droid {
    public String sendEncryptedMessage(String message, int key) {
        System.out.println("message: " + message);
        DroidMessageEncryptor encryptor = (m, k) -> {
            StringBuilder encrypted = new StringBuilder();
            for (char symbol : m.toCharArray()) {
                encrypted.append((char) (symbol + k));
            }
            return encrypted.toString();
        };

        String encryptedMessage = encryptor.encrypt(message, key);
        System.out.println("Encrypted message: " + encryptedMessage);
        return encryptedMessage;
    }

    public String receiveEncryptedMessage(String encryptedMessage, int key) {
        DroidMessageEncryptor decryptor = (m, k) -> {
            StringBuilder decrypted = new StringBuilder();
            for (char symbol : m.toCharArray()) {
                decrypted.append((char) (symbol - k));
            }
            return decrypted.toString();
        };

        String decryptedMessage = decryptor.encrypt(encryptedMessage, key);
        System.out.println("Decrypted message: " + decryptedMessage);
        return decryptedMessage;
    }
}
