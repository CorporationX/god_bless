package faang.school.godbless.DroidSecret;

public class DroidCrypto {
    public static DroidMessageEncryptor encryptor = (value, key) -> {
        return shiftChars(value, key);
    };

    public static DroidMessageDecryptor decryptor = (value, key) -> {
        return shiftChars(value, -key);
    };

    static String shiftChars(String str, int shift) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char shiftedChar = (char) (str.charAt(i) + shift);
            result.append(shiftedChar);
        }
        return result.toString();
    }
}
