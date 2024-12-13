package school.faang.task_46184;

public final class CaesarCipherEncryptor {
    public static final DroidMessageEncryptor ENCRYPT = (message, key) -> {
        StringBuilder result = new StringBuilder();

        for (char character : message.toCharArray()) {
            if (Character.isLetter(character)) {
                char base = Character.isLowerCase(character) ? 'a' : 'A';
                char encryptedChar = (char) ((character - base + key) % 26 + base);
                result.append(encryptedChar);
            } else {
                result.append(character);
            }
        }

        return result.toString();
    };

    public static final DroidMessageEncryptor DECRYPT = (message, key) -> {
        StringBuilder result = new StringBuilder();
        key = key % 26;

        for (char character : message.toCharArray()) {
            if (Character.isLetter(character)) {
                char base = Character.isLowerCase(character) ? 'a' : 'A';
                char decryptedChar = (char) ((character - base - key + 26) % 26 + base);
                result.append(decryptedChar);
            } else {
                result.append(character);
            }
        }

        return result.toString();
    };
}
