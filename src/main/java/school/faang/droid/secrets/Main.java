package school.faang.droid.secrets;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        DroidMessageEncryptor encryptor = (message, key) ->
                processMessage(message, key, (currentChar, shift) ->
                        (base) -> (char) ((currentChar - base + shift) % 26 + base));

        DroidMessageEncryptor decryptor = (message, key) ->
                processMessage(message, key, (currentChar, shift) ->
                        (base) -> (char) ((currentChar - base - shift + 26) % 26 + base));

        Droid r2d2 = new Droid("R2D2", encryptor, decryptor);
        Droid c3po = new Droid("C3PO", encryptor, decryptor);
        Droid bb8 = new Droid("BB-8", encryptor, decryptor);

        String message1 = "Join the Rebellion!";
        String message2 = "The Death Star is operational!";
        String message3 = "The mission is complete.";
        int encryptionKey1 = 3;
        int encryptionKey2 = 7;

        r2d2.sendMessage(message1, encryptionKey1, c3po);
        c3po.sendMessage(message2, encryptionKey2, r2d2);
        bb8.sendMessage(message3, encryptionKey1, c3po);
    }

    private static String processMessage(String message, int key,
                                         BiFunction<Character, Integer, Function<Character, Character>> charModifier) {
        char[] chars = message.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (Character.isLetter(chars[i])) {
                if (Character.isUpperCase(chars[i])) {
                    chars[i] = charModifier.apply(chars[i], key).apply('A');
                } else {
                    chars[i] = charModifier.apply(chars[i], key).apply('a');
                }
            }
        }
        return new String(chars);
    }
}
