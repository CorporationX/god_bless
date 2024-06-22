package faang.school.godbless.BJS2_9056;

public class Droid {
    private String message;
    private int offset;

    public String sendEncryptedMessage(String message, int offset) {
        DroidMessageEncryptor encryptor = (msg, key) -> {
            StringBuilder result = new StringBuilder();
            for (char character : msg.toCharArray()) {
                char firstLetter;
                if (Character.isLowerCase(character)) {
                    firstLetter = 'a';
                } else {
                    firstLetter = 'A';
                }
                if (Character.isLetter(character)) {
                    int originalAlphabetPosition = character - firstLetter;
                    int newAlphabetPosition = (originalAlphabetPosition + key) % 26;
                    char newCharacter = (char) (firstLetter + newAlphabetPosition);
                    result.append(newCharacter);
                } else {
                    result.append(character);
                }
            }
            return result.toString();
        };
        return encryptor.encrypt(message, offset);
    }

    public String receiveEncryptedMessage(String message, int offset) {
        return sendEncryptedMessage(message, 26 - (offset % 26));
    }
}
