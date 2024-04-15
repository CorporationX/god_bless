package faang.school.godbless.sprint_2.droid_secrets;

import java.util.function.BiFunction;

public class Droid {

    private static final BiFunction<Character, Integer, Character> ENCRYPTION_FUNC = ((character, key) -> (char) ((int) character + key));
    private static final BiFunction<Character, Integer, Character> DECRYPTION_FUNC = ((character, key) -> (char) ((int) character - key));

    public String sendEncryptedMessage(String message, int key) {
        return getEncryptor(ENCRYPTION_FUNC).encrypt(message, key);
    }

    public String receiveEncryptedMessage(String message, int key) {
        return getEncryptor(DECRYPTION_FUNC).encrypt(message, key);
    }

    public DroidMessageEncryptor getEncryptor(BiFunction<Character, Integer, Character> func) {
        return (message, key) -> {
            char[] charsInMessage = message.toCharArray();
            for (int i = 0; i < charsInMessage.length; i++) {
                charsInMessage[i] = func.apply(charsInMessage[i], key);
            }
            return new String(charsInMessage);
        };
    }
}