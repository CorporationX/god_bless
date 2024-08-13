package faang.school.godbless.secondsprint.droids;

public class Droid {
    public String sendEncryptedMessage(String message, int key) {
        DroidMessageEncryptor encryptor = (msg, encryptionKey) -> {
            StringBuilder encryptedMessage = new StringBuilder();
            for (char character : msg.toCharArray()) {
                if (Character.isLetter(character)) {
                    char base = Character.isLowerCase(character) ? 'a' : 'A';
                    encryptedMessage.append((char) ((character - base + encryptionKey) % 26 + base));
                } else {
                    encryptedMessage.append(character);
                }
            }
            return encryptedMessage.toString();
        };

        String encryptedMessage = encryptor.encrypt(message, key);
        return encryptedMessage;
    }

    public String receiveEncryptedMessage(String encryptedMessage, int key) {
        DroidMessageEncryptor decryptor = (msg, encryptionKey) -> {
            StringBuilder decryptedMessage = new StringBuilder();
            for (char character : msg.toCharArray()) {
                if (Character.isLetter(character)) {
                    char base = Character.isLowerCase(character) ? 'a' : 'A';
                    decryptedMessage.append((char) ((character - base - encryptionKey + 26) % 26 + base));
                } else {
                    decryptedMessage.append(character);
                }
            }
            return decryptedMessage.toString();
        };

        String decryptedMessage = decryptor.encrypt(encryptedMessage, key);
        return decryptedMessage;
    }
}
