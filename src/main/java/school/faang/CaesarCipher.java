package school.faang;

public class CaesarCipher {

    public static String caesarCipher(String input, int shift) {
        StringBuilder result = new StringBuilder();

        shift = shift % 26;

        for (char c : input.toCharArray()) {

            if (Character.isUpperCase(c)) {
                char shifted = (char) ('A' + (c - 'A' + shift + 26) % 26);
                result.append(shifted);
            }

            else if (Character.isLowerCase(c)) {
                char shifted = (char) ('a' + (c - 'a' + shift + 26) % 26);
                result.append(shifted);
            }

            else {
                result.append(c);
            }
        }
        return result.toString();
    }
}