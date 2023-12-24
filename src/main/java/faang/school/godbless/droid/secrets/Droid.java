package faang.school.godbless.droid.secrets;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Droid {
    private String name;
    private String message;
    private int encryptKey;

    public String sendEncryptedMessage() throws IllegalArgumentException {
        DroidMessageEncryptor encryptor = encryptMessage(false);

        return encryptor.encrypt(message, encryptKey);
    }

    public String receiveEncryptedMessage(String encryptedMessage, int encryptKey) {
        DroidMessageEncryptor decryptor = encryptMessage(true);

        return decryptor.encrypt(encryptedMessage, encryptKey);
    }

    private DroidMessageEncryptor encryptMessage(boolean decrypt) {
        StringBuilder encryptedText = new StringBuilder();
        String regex = "[a-zA-Z]";

        DroidMessageEncryptor encryptor = ((message, key) -> {
            for (char character : message.toCharArray()) {
                String charToString = String.valueOf(character);

                if (charToString.matches(regex)) {
                    char newCharacter = (char) (updateCharacterPosition(character, key, decrypt));
                    encryptedText.append(newCharacter);
                } else {
                    encryptedText.append(character);
                }
            }
            String result = encryptedText.toString();

            System.out.println(result);
            return result;
        });

        return encryptor;
    }

    private int updateCharacterPosition(char character, int key, boolean decrypt) throws IllegalArgumentException {
        String lowerCaseRegex = "[a-z]";
        String upperCaseRegex = "[A-Z]";
        char firstCharLowerCase = 'a';
        char firstCharUpperCase = 'A';
        int latinAlphabetLength = 26;
        String charToString = String.valueOf(character);

        int originalCharPosition;
        int newCharPosition;

        if (charToString.matches(lowerCaseRegex)) {
            originalCharPosition = character - firstCharLowerCase;
            if (!decrypt) {
                newCharPosition = firstCharLowerCase + (originalCharPosition + key) % latinAlphabetLength;
            } else {
                newCharPosition = firstCharLowerCase + (originalCharPosition + (latinAlphabetLength - key % latinAlphabetLength)) % latinAlphabetLength;
            }
        } else if (charToString.matches(upperCaseRegex)) {
            originalCharPosition = character - firstCharUpperCase;
            if (!decrypt) {
                newCharPosition = firstCharUpperCase + (originalCharPosition + key) % latinAlphabetLength;
            } else {
                newCharPosition = firstCharUpperCase + (originalCharPosition + (latinAlphabetLength - key % latinAlphabetLength)) % latinAlphabetLength;
            }
        } else {
            throw new IllegalArgumentException("Invalid character provided");
        }

        return newCharPosition;
    }
}
