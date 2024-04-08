package faang.school.godbless.DroidSecrets;

import java.util.function.BiFunction;

public class Droid {
    private final DroidMessageEncryptor encoder;
    private final DroidMessageEncryptor decoder;

    public Droid() {
        this.encoder = getCoder((ch, key) -> (char) (ch + key));
        this.decoder = getCoder((ch, key) -> (char) (ch - key));
    }

    public String sendEncryptedMessage(String message, int encryptionKey) {
        return encoder.encrypt(message, encryptionKey);
    }

    public String receiveEncryptedMessage(String encryptedMessage, int encryptionKey) {
        return decoder.encrypt(encryptedMessage, encryptionKey);
    }

    private DroidMessageEncryptor getCoder(BiFunction<Character, Integer, Character> codingLogic) {
        return (mess, key) -> {
            StringBuilder decoded = new StringBuilder();
            for (char ch : mess.toCharArray()) {
                decoded.append(codingLogic.apply(ch, key));
            }
            return decoded.toString();
        };
    }
}
