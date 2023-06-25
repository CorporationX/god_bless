package Droid_Secrets;

public class Droid {
    public String sendEncryptedMessage(String message, int encryptionKey) {
        DroidMessageEncryptor droidMessageEncryptor = (mes, key) -> {
            StringBuilder encryptedMessage = new StringBuilder();
            for (int i = 0; i < mes.length(); i++) {
                char oldChar = mes.charAt(i);
                char newChar = (char) ((int) oldChar + key);
                encryptedMessage.append(newChar);
            }
            return encryptedMessage.toString();
        };
        return droidMessageEncryptor.encryptMessage(message, encryptionKey);
    }

    public String receiveEncryptedMessage(String encryptedMessage, int encryptionKey) {
        DroidMessageEncryptor droidMessageEncryptor = (mes, key) -> {
            StringBuilder decryptedMessage = new StringBuilder();
            for (int i = 0; i < mes.length(); i++) {
                char oldChar = mes.charAt(i);
                char newChar = (char) ((int) oldChar - key);
                decryptedMessage.append(newChar);
            }
            return decryptedMessage.toString();
        };
        return droidMessageEncryptor.encryptMessage(encryptedMessage, encryptionKey);
    }
}
