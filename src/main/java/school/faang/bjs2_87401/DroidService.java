package school.faang.bjs2_87401;

import java.util.Objects;

public class DroidService {

    private static final String EN = "abcdefghijklmnopqrstuvwxyz";
    private static final String RU = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";

    public static final DroidMessageEncryptor droidMessageEncryptor = (String mes, int key) -> {
        if (Objects.isNull(mes) || mes.isBlank()) {
            throw new RuntimeException("Message text missing!!");
        }
        return  mes.chars()
                .map(c -> Character.isLetter(c) ? shiftChar((char) c, key) : c)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    };

    private static char shiftChar(char c, int key) {
        char lower = Character.toLowerCase(c);
        String alphabet = Character.UnicodeBlock.of(lower) == Character.UnicodeBlock.CYRILLIC ? RU : EN;

        int index = alphabet.indexOf(lower);
        if (index == -1) {
            return c;
        }

        int newIndex = Math.floorMod(index + key, alphabet.length());
        char result = alphabet.charAt(newIndex);

        return Character.isUpperCase(c) ? Character.toUpperCase(result) : result;
    }

}
