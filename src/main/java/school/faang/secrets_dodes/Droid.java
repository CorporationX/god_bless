package school.faang.secrets_dodes;

public class Droid {

    public Droid(String s) {
    }

    public void sendMessage(Droid c3po, String message1, int encryptionKey1) {

        String encryptedMessage = encryptMessage(message1, encryptionKey1);

        c3po.receiveMessage(encryptedMessage);
    }

    public void receiveMessage(String encryptedMessage) {
        int encryptionKey = 3;
        String decryptedMessage = decryptMessage(encryptedMessage, encryptionKey);

        System.out.println("Received and decrypted message: " + decryptedMessage);
    }

    private String decryptMessage(String encryptedMessage, int encryptionKey) {
        StringBuilder decrypted = new StringBuilder();
        for (char c : encryptedMessage.toCharArray()) {
            decrypted.append((char) (c - encryptionKey));
        }
        return decrypted.toString();
    }

    private String encryptMessage(String message, int encryptionKey) {
        StringBuilder encrypted = new StringBuilder();
        for (char c : message.toCharArray()) {
            encrypted.append((char) (c + encryptionKey));
        }
        return encrypted.toString();
    }
}
