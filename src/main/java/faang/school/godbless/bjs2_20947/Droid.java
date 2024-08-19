package faang.school.godbless.bjs2_20947;

public class Droid {
    public String sendEncryptedMessage(String message, int encryptionKey) {
        DroidMessageEncryptor encryptor = (m, key) -> {
            var shiftRule = encryptionKey;
            return shiftCharacters(message, encryptionKey, shiftRule);
        };
        return encryptor.encrypt(message, encryptionKey);
    }

    public String receiveEncryptedMessage(String message, int encryptionKey) {
        DroidMessageEncryptor encryptor = (m, key) -> {
            var shiftRule = -encryptionKey + 26;
            return shiftCharacters(message, encryptionKey, shiftRule);
        };
        return encryptor.encrypt(message, encryptionKey);
    }

    private String shiftCharacters(String message, int encryptionKey, int shiftRule) {
        StringBuilder encryptedMessage = new StringBuilder();
        for (char c : message.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                c = (char) ((c - base + shiftRule) % 26 + base);
            }
            encryptedMessage.append(c);
        }
        return encryptedMessage.toString();
    }
}
