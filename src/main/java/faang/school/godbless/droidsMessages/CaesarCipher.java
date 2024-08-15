package faang.school.godbless.droidsMessages;

public class CaesarCipher {
    private static final String LETTERS = "ABCDEFGHIJKLMNOPQRSTUVXYZ";

    public static String code(String message, int key) {
        String alphabet = LETTERS + LETTERS.toLowerCase();
        int alphabetSize = alphabet.length();
        StringBuilder encryptedMessage = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            int index = alphabet.indexOf(c);
            if (index < 0) {
                encryptedMessage.append(c);
            } else {
                int codeIndex = (alphabetSize + index + key) % alphabetSize;
                encryptedMessage.append(alphabet.charAt(codeIndex));
            }
        }
        return encryptedMessage.toString();
    }
}
