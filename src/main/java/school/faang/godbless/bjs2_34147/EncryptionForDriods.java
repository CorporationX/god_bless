package school.faang.godbless.bjs2_34147;

import java.util.stream.IntStream;

public class EncryptionForDriods {
    private static EncryptionForDriods instance = new EncryptionForDriods();

    private DroidMessageEncryptor encryptor = (text, key) -> {
        char[] symbols = text.toCharArray().clone();
        IntStream.range(0, symbols.length).forEach(i -> symbols[i] += (char) key);
        return new String(symbols);
    };

    private DroidMessageEncryptor decryptor = (text, key) -> {
        char[] symbols = text.toCharArray().clone();
        IntStream.range(0, symbols.length).forEach(i -> symbols[i] -= (char) key);
        return new String(symbols);
    };

    private EncryptionForDriods() {
    }


}
