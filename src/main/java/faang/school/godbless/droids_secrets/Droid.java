package faang.school.godbless.droids_secrets;

public class Droid {

    DroidMessageEncryptor encryptor = (m, k) -> {
        StringBuilder sb = new StringBuilder();

        for (Character c : m.toCharArray()) {
            if (c != ' ') {
                int originalAlphabetPosition = c - 'a';
                int newAlphabetPosition = (originalAlphabetPosition + k) % 26;
                char newCharacter = (char) ('a' + newAlphabetPosition);
                sb.append(newCharacter);
            } else {
                sb.append(c);
            }
        }
        return String.valueOf(sb);
    };

    public String sendEncryptedMessage(String message, int key) {
        return encryptor.encrypt(message, key);
    }

    public String receiveEncryptedMessage(String encryptedMessage, int key) {
        return sendEncryptedMessage(encryptedMessage, 26 - (key % 26));
    }
}
