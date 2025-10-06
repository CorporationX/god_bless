package school.faang.module2.droid;

public class CaesarCipher implements DroidMessageEncryptor {

    @Override
    public String crypt(String message, int key) {
        return processText(message, key);
    }

    private static String processText(String text, int key) {
        if (text == null || text.isEmpty()) {
            return text;
        }

        StringBuilder result = new StringBuilder();

        for (char character : text.toCharArray()) {
            if (Character.isLetter(character)) {
                char base = Character.isUpperCase(character) ? 'A' : 'a';
                char encryptedChar = (char) ((character - base + key) % 26 + base);
                result.append(encryptedChar);
            } else {
                result.append(character);
            }
        }

        return result.toString();
    }
}
