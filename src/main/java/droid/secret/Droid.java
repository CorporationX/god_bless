package droid.secret;

import java.util.function.BiFunction;

public class Droid {
    public String sendEncryptedMessage(String message, int encryptionKey) {
        BiFunction<Character, Integer, Integer> function = (c, i) -> c + i;
        DroidMessageEncryptor droidMessageEncryptor = (hash, key) -> this.encryptionAlgorithm(hash, key, function);

        return droidMessageEncryptor.encrypt(message, encryptionKey);
    }

    public String receiveEncryptedMessage(String hashMessage, int encryptKey) {
        BiFunction<Character, Integer, Integer> function = (c, i) -> c - i;
        DroidMessageEncryptor droidMessageEncryptor = (hash, key) -> this.encryptionAlgorithm(hash, key, function);

        return droidMessageEncryptor.encrypt(hashMessage, encryptKey);
    }

    private String encryptionAlgorithm(String message, int key, BiFunction<Character, Integer, Integer> function) {
        char[] chars = message.toCharArray();
        StringBuilder builder = new StringBuilder();
        for (char ch : chars) {
            builder.append((char) function.apply(ch, key).intValue());
        }

        return builder.toString();
    }
}
