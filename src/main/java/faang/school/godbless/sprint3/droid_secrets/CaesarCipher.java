package faang.school.godbless.sprint3.droid_secrets;

public class CaesarCipher {
    private static final int LOWER_CASE = 97;
    private static final int UPPER_CASE = 65;

    static String crypt(String message, int key) {
        key = key % 26;
        if (key < 0) {
            key = 26 + key;
        }

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            if (Character.isLowerCase(c)) {
                c = (char) ((c - LOWER_CASE + key) % 26 + LOWER_CASE);
            } else if (Character.isUpperCase(c)) {
                c = (char) ((c - UPPER_CASE + key) % 26 + UPPER_CASE);
            }
            builder.append(c);
        }

        return builder.toString();
    }

    static String decrypt(String message, int key) {
        return crypt(message, 26 - (key % 26));
    }
}
