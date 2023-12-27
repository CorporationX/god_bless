package faang.school.godbless.droid.secrets;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Droid {
    private static final String REGEX = "[a-zA-Z]";
    private static final String UPPERCASE_REGEX = "[A-Z]";
    private static final char FIRST_CHAR_LOWERCASE = 'a';
    private static final char FIRST_CHAR_UPPERCASE = 'A';
    private static final int LATIN_ALPHABET_LENGTH = 26;

    private String name;
    private String message;
    private int encryptKey;

    public String sendEncryptedMessage () {
        StringBuilder encryptedText = new StringBuilder();

        DroidMessageEncryptor encryptor = ((message, key) -> {
            for (char character : message.toCharArray()) {
                String charToString = String.valueOf(character);

                if (charToString.matches(REGEX)) {
                    char newCharacter = (char) (encryptCharacter(character, key));

                    encryptedText.append(newCharacter);
                } else {
                    encryptedText.append(character);
                }
            }
            String result = encryptedText.toString();

            System.out.println(result);
            return result;
        });

        return encryptor.encrypt(message, encryptKey);
    }

    public String receiveEncryptedMessage (String encryptedMessage, int encryptKey) {
        StringBuilder encryptedText = new StringBuilder();

        DroidMessageEncryptor decryptor = ((message, key) -> {
            for (char character : message.toCharArray()) {
                String charToString = String.valueOf(character);

                if (charToString.matches(REGEX)) {
                    char newCharacter = (char) (decryptCharacter(character, key));

                    encryptedText.append(newCharacter);
                } else {
                    encryptedText.append(character);
                }
            }
            String result = encryptedText.toString();

            System.out.println(result);
            return result;
        });

        return decryptor.encrypt(encryptedMessage, encryptKey);
    }

    private int encryptCharacter (char character, int key) {
        String charToString = String.valueOf(character);
        int originalCharPosition;

        if (charToString.matches(UPPERCASE_REGEX)) {
            originalCharPosition = character - FIRST_CHAR_UPPERCASE;
            return updateEncryptedCharPosition(originalCharPosition, key, FIRST_CHAR_UPPERCASE);
        } else {
            originalCharPosition = character - FIRST_CHAR_LOWERCASE;
            return updateEncryptedCharPosition(originalCharPosition, key, FIRST_CHAR_LOWERCASE);
        }
    }

    private int decryptCharacter (char character, int key) {
        String charToString = String.valueOf(character);
        int originalCharPosition;

        if (charToString.matches(UPPERCASE_REGEX)) {
            originalCharPosition = character - FIRST_CHAR_UPPERCASE;
            return updateDecryptedCharPosition(originalCharPosition, key, FIRST_CHAR_UPPERCASE);
        } else {
            originalCharPosition = character - FIRST_CHAR_LOWERCASE;
            return updateDecryptedCharPosition(originalCharPosition, key, FIRST_CHAR_LOWERCASE);
        }
    }

    private int updateEncryptedCharPosition (int originalCharPosition, int key, char firstCharacter) {
        return firstCharacter + (originalCharPosition + key) % LATIN_ALPHABET_LENGTH;
    }

    private int updateDecryptedCharPosition (int originalCharPosition, int key, char firstCharacter) {
        return firstCharacter + (originalCharPosition + (LATIN_ALPHABET_LENGTH - key % LATIN_ALPHABET_LENGTH)) % LATIN_ALPHABET_LENGTH;
    }
}
