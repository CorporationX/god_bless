package Droid_Secrets;

public class Droid {
    private final DroidMessageEncryptor sendEncrypted = (mes, key) -> {
        char[] chars = mes.toCharArray();
        StringBuilder encryptedMessage = new StringBuilder();
        for (char c : chars) {
            if (c < 'a' || c > 'z') {
                encryptedMessage.append(c);
                continue;
            }
            int charValue = c - 'a';
            int reducedKey = key % 26;
            int encryptedValue = (charValue + reducedKey) % 26;
            char encryptedChar = (char) (encryptedValue + 'a');
            encryptedMessage.append(encryptedChar);
        }
        return encryptedMessage.toString();
    };

    private final DroidMessageEncryptor receiveEncrypted = (mes, key) -> {
        char[] chars = mes.toCharArray();
        StringBuilder decryptedMessage = new StringBuilder();
        for (char c : chars) {
            if (c < 'a' || c > 'z') {
                decryptedMessage.append(c);
                continue;
            }
            int charValue = c - 'a';
            int decryptedValue = (charValue - key + 26) % 26;
            char decryptedChar = (char) (decryptedValue + 'a');
            decryptedMessage.append(decryptedChar);
        }
        return decryptedMessage.toString();
    };

    public DroidMessageEncryptor getSendEncrypted() {
        return sendEncrypted;
    }

    public DroidMessageEncryptor getReceiveEncrypted() {
        return receiveEncrypted;
    }

    public String sendOrReceiveMessage(String message, int encryptionKey, DroidMessageEncryptor droidMessageEncryptor) {
        return droidMessageEncryptor.encryptMessage(message, encryptionKey);
    }
}
