package faang.school.godbless.droid_secrets;

public class Droid {
    public String sendEncryptedMessage(String message, int key) {
        DroidMessageEncryptor encryptor = (messageLambda, keyLambda) -> {
            StringBuilder encrypted = new StringBuilder();
            for (char c : message.toCharArray()) {
                if (!Character.isAlphabetic(c)) {
                    encrypted.append(c);
                    continue;
                }
                int current = Character.isUpperCase(c) ? 'A' : 'a';
                char shifted = (char) (current + ((c + key - current) % 26));
                encrypted.append(shifted);
            }
            return encrypted.toString();
        };

        return encryptor.encrypt(message, key);
    }

    public String receiveEncryptedMessage(String message, int key) {
        DroidMessageEncryptor decryptor = (encryptedMessage, key1) -> {
            StringBuilder encrypted = new StringBuilder();
            for (char c : message.toCharArray()) {
                if (!Character.isAlphabetic(c)) {
                    encrypted.append(c);
                    continue;
                }
                int current = Character.isUpperCase(c) ? 'A' : 'a';
                char shifted = (char) (current + ((c - key - current + 26) % 26));
                encrypted.append(shifted);
            }
            return encrypted.toString();
        };

        return decryptor.encrypt(message, key);
    }

    public static void main(String[] args) {
        Droid droid = new Droid();
        String encrypt = droid.sendEncryptedMessage("Hello, world!", 30);
        System.out.println(encrypt);
        String decrypt = droid.receiveEncryptedMessage(encrypt, 30);
        System.out.println(decrypt);

    }
}