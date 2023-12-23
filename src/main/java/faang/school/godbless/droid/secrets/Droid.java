package faang.school.godbless.droid.secrets;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Droid {
    private String name;
    private String message;
    private int encryptKey;

    public String sendEncryptedMessage() throws IllegalArgumentException {
        StringBuilder encryptedText = new StringBuilder();
        String regex = "[a-zA-Z]";

        DroidMessageEncryptor encryptor = ((message, key) -> {
            for (char character : message.toCharArray()) {
                String charToString = String.valueOf(character);

                if (charToString.matches(regex)) {
                    char newCharacter = (char) (updateCharacterPosition(character, key));
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

    private int updateCharacterPosition(char character, int key) throws IllegalArgumentException {
        String lowerCaseRegex = "[a-z]";
        String upperCaseRegex = "[A-Z]";
        char firstCharLowerCase = 'a';
        char firstCharUpperCase = 'A';
        int latinAlphabetLength = 26;
        String charToString = String.valueOf(character);

        int originalAlphabetPosition;
        int newAlphabetPosition;

        if (charToString.matches(lowerCaseRegex)) {
            originalAlphabetPosition = character - firstCharLowerCase;
            newAlphabetPosition = firstCharLowerCase + (originalAlphabetPosition + key) % latinAlphabetLength;
        } else if (charToString.matches(upperCaseRegex)) {
            originalAlphabetPosition = character - firstCharUpperCase;
            newAlphabetPosition = firstCharUpperCase + (originalAlphabetPosition + key) % latinAlphabetLength;
        } else {
            throw new IllegalArgumentException("Invalid character provided");
        }

        return newAlphabetPosition;
    }
}
