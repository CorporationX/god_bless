package faang.school.godbless.aged777_BJS2_9031_secrets_of_the_droids;

import java.util.Arrays;

public class Droid {
    private static final DroidMessageEncryptor<String, Integer> droidMessageEncryptor = ((message, key) -> {
        char[] symbols = message.toCharArray();
        for (int i = 0; i < symbols.length; i++) {
            symbols[i] += key;
        }
        return Arrays.toString(symbols);
    });

    public String sendEncryptedMessage(Droid droid, String message, Integer key) {
        return droidMessageEncryptor.encrypt(message, key);
    }
}
