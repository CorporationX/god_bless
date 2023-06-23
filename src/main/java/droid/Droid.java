package droid;

public class Droid {
    private final int engAlphabetSize = 26;
    private final DroidMessageEncryptor encryptor = (inputMessage, inputKey) -> {
        StringBuilder builder = new StringBuilder();
        for (char ch : inputMessage.toCharArray()) {
            if (Character.isAlphabetic(ch)) {
                int currentAlphabetPosition = Character.isUpperCase(ch) ? ch - 'A' : ch - 'a';
                int newAlphabetPosition = (currentAlphabetPosition + inputKey) % engAlphabetSize;

                char newChar = (char) ((Character.isUpperCase(ch) ? 'A' : 'a') + newAlphabetPosition);
                builder.append(newChar);
            } else {
                builder.append(ch);
            }
        }
        return builder.toString();
    };

    public String sendEncryptedMessage(String message, int key) {
        if ((key % engAlphabetSize) == 0) {
            return message;
        }
        return encryptor.encrypt(message, key);
    }

    public String receiveEncryptedMessage(String message, int key) {
        if ((key % engAlphabetSize) == 0) {
            return message;
        }
        return encryptor.encrypt(message, engAlphabetSize - (key % engAlphabetSize));
    }
}