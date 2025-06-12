package school.faang.util;

import java.util.function.BiFunction;
import java.util.function.Predicate;

public class AsciiUtil {
    private static final byte LETTER_DIAPASON = 26;

    public static byte shiftAsciiLetter(byte letter, int shift, boolean isUpper, boolean forward) {
        final byte aLetter = (byte) (isUpper ? 'A' : 'a');
        if (shift < 0) {
            throw new IllegalArgumentException("shift steps can not to be negative");
        }

        shift = shift % 26;
        if (forward) {
            return (byte) ((letter - aLetter + shift) % LETTER_DIAPASON + aLetter);
        }

        return (byte) ((letter - aLetter - shift + LETTER_DIAPASON) % LETTER_DIAPASON + aLetter);
    }

    public static boolean isLetter(Byte symbol) {
        return ('A' <= symbol && symbol <= 'Z') || ('a' <= symbol && symbol < 'z');
    }
}
