package droid;

public class Droid {
    private static final int ENG_ALPHABET_SIZE = 26;
    private static final DroidMessageEncryptor ENCRYPTOR = (inputMessage, inputKey) -> {
        StringBuilder builder = new StringBuilder();
        for (char ch : inputMessage.toCharArray()) {
            if (Character.isAlphabetic(ch)) {
                int currentAlphabetPosition = Character.isUpperCase(ch) ? ch - 'A' : ch - 'a';
                int newAlphabetPosition = (currentAlphabetPosition + inputKey) % ENG_ALPHABET_SIZE;

                char newChar = (char) ((Character.isUpperCase(ch) ? 'A' : 'a') + newAlphabetPosition);
                builder.append(newChar);
            } else {
                builder.append(ch);
            }
        }
        return builder.toString();
    };

    public String sendEncryptedMessage(String message, int key) {
        if ((key % ENG_ALPHABET_SIZE) == 0) {
            return message;
        }
        return ENCRYPTOR.encrypt(message, key);
    }

    public String receiveEncryptedMessage(String message, int key) {
        return sendEncryptedMessage(message, ENG_ALPHABET_SIZE - (key % ENG_ALPHABET_SIZE));
    }
}