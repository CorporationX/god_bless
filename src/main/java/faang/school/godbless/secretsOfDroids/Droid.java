package faang.school.godbless.secretsOfDroids;

public class Droid {
    public String sendEncryptedMessage(String message, int encryptionKey) {
        DroidMessageEncryptor encryptor = (msg, key) -> {
            StringBuilder encrypted = new StringBuilder();
            for (char c : msg.toCharArray()) {
                if (Character.isLetter(c)) {
                    char base = Character.isUpperCase(c) ? 'A' : 'a';
                    int offset = (c - base + key) % 26;
                    encrypted.append((char) (base + offset));
                } else {
                    encrypted.append(c);
                }
            }
            return encrypted.toString();
        };

        String encryptedMessage = encryptor.encrypt(message, encryptionKey);
        System.out.println("Encrypted message --> " + encryptedMessage);
        return encryptor.encrypt(message, encryptionKey);
    }

    public void receiveEncryptedMessage(String encryptedMessage, int decryptionKey) {
        DroidMessageEncryptor decryptor = (msg, key) -> {
            StringBuilder decrypted = new StringBuilder();
            for (char c : msg.toCharArray()) {
                if (Character.isLetter(c)) {
                    char base = Character.isUpperCase(c) ? 'A' : 'a';
                    int offset = (c - base - key + 26) % 26;
                    decrypted.append((char) (base + offset));
                } else {
                    decrypted.append(c);
                }
            }
            return decrypted.toString();
        };

        String decryptedMessage = decryptor.encrypt(encryptedMessage, decryptionKey);
        System.out.println("Decrypted message --> " + decryptedMessage);
    }

}