package faang.school.godbless.DroidSecrets;

import java.util.function.BiFunction;

public class Droid {
    private static final DroidMessageEncryptor ENCODER = getCoder((ch, key) -> (char) (ch + key));
    private static final DroidMessageEncryptor DECODER = getCoder((ch, key) -> (char) (ch - key));

    public String sendEncryptedMessage(String message, int encryptionKey) {
        return ENCODER.encrypt(message, encryptionKey);
    }

    public String receiveEncryptedMessage(String encryptedMessage, int encryptionKey) {
        return DECODER.encrypt(encryptedMessage, encryptionKey);
    }

    private static DroidMessageEncryptor getCoder(BiFunction<Character, Integer, Character> codingLogic) {
        return (mess, key) -> {
            StringBuilder decoded = new StringBuilder();
            for (char ch : mess.toCharArray()) {
                decoded.append(codingLogic.apply(ch, key));
            }
            return decoded.toString();
        };
    }
}
