package school.faang.lambda.droids;

import java.util.stream.Collectors;

public class DroidService {

    private static final char UPPER_FIRST_LETTER = 'A';
    private static final char LOWER_FIRST_LETTER = 'a';
    private static final int ALPHABET_SIZE = 26;

    public static final DroidMessageEncryptor TRANSFORMER = ((message, key) ->
            message.chars()
            .map(c -> Character.isUpperCase(c) ? shiftLetter(c, key, UPPER_FIRST_LETTER) :
                    shiftLetter(c, key, LOWER_FIRST_LETTER))
            .mapToObj(c -> String.valueOf((char) c))
            .collect(Collectors.joining()));

    private static char shiftLetter(int ch, int key, char base) {
        if (base <= ch & ch <= base + ALPHABET_SIZE) {
            return (char) ((ch - base + key + ALPHABET_SIZE) % ALPHABET_SIZE + base);
        } else {
            return (char) ch;
        }
    }
}
