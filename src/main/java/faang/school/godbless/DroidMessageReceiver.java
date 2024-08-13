package faang.school.godbless;

public class DroidMessageReceiver {
    public void receiveEncryptedMessage(String encryptedMessage, int encryptionKey) {
        DroidMessageEncryptor decryptor = (msg, key) -> {
            StringBuilder decryptedMessage = new StringBuilder();
            for (char c : msg.toCharArray()) {
                if (Character.isLetter(c)) {
                    char base = Character.isUpperCase(c) ? 'A' : 'a';
                    c = (char) ((c - base - key + 26) % 26 + base);
                }
                decryptedMessage.append(c);
            }
            return decryptedMessage.toString();
        };

        String decryptedMessage = decryptor.encrypt(encryptedMessage, encryptionKey);

        System.out.println("Received message: " + decryptedMessage);
    }
}
