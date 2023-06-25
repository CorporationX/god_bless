package faang.school.godbless;

public class Droid {
    private String message;
    private int key;

    public String getMessage() {
        return message;
    }

    public int getKey() {
        return key;
    }

    public String sendEncryptedMessage(String message, int encryptionKey){
        DroidMessageEncryptor encryptor = (msg, key) -> {
            StringBuilder encryptedMsg = new StringBuilder();
            for (char c : msg.toCharArray()) {
                if (Character.isLetter(c)) {
                    char base = Character.isUpperCase(c) ? 'A' : 'a';
                    char encryptedChar = (char) (base + (c - base + key) % 26);
                    encryptedMsg.append(encryptedChar);
                } else {
                    encryptedMsg.append(c);
                }
            }
            return encryptedMsg.toString();
        };

        String encryptedMessage = encryptor.crypt(message, encryptionKey);
        return encryptedMessage;
    }

    public String receiveEncryptedMessage(String encryptedMessage, int encryptionKey) {
        DroidMessageEncryptor decryptor = (message, key) -> {
            StringBuilder decryptedMessage = new StringBuilder();
            for (char c : message.toCharArray()) {
                if (Character.isLetter(c)) {
                    char base = Character.isUpperCase(c) ? 'A' : 'a';
                    char decryptedChar = (char) (base + (c - base - key + 26) % 26);
                    decryptedMessage.append(decryptedChar);
                } else {
                    decryptedMessage.append(c);
                }
            }
            return decryptedMessage.toString();
        };

        String decryptedMessage = decryptor.crypt(encryptedMessage, encryptionKey);
        return decryptedMessage;
    }

}
