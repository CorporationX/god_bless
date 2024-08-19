package faang.school.godbless.BJS2_20978;

public class Droid {
    String sendEncryptedMessage(String message, int encryptionKey) {
        DroidMessageEncryptor encryptor = (msg, msgEncryptor) -> {
            StringBuilder result = new StringBuilder();
            for (char letter : msg.toCharArray()) {
                if (Character.isLetter(letter)) {
                    char base = Character.isUpperCase(letter) ? 'A' : 'a';
                    result.append((char) ((letter - base + msgEncryptor) % 26 + base));
                } else {
                    result.append(letter);
                }
            }
            return result.toString();
        };
        return encryptor.processMessage(message, encryptionKey);
    }

    String receiveEncryptedMessage(String encryptedMessage, int encryptionKey) {
        DroidMessageEncryptor decryptor = (encryptedMsg, msgEncryptor) -> {
            StringBuilder result = new StringBuilder();
            for (char letter : encryptedMsg.toCharArray()) {
                if (Character.isLetter(letter)) {
                    char base = Character.isUpperCase(letter) ? 'A' : 'a';
                    result.append((char) ((letter - base - msgEncryptor + 26) % 26 + base));
                } else {
                    result.append(letter);
                }
            }
            return result.toString();
        };
        return decryptor.processMessage(encryptedMessage, encryptionKey);
    }
}
