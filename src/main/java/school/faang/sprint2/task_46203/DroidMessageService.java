package school.faang.sprint2.task_46203;

import java.util.stream.Collectors;

public class DroidMessageService {

    public String encryptMessage(String message, int key) {
        boolean isEnglishOnly = message.matches("[A-Za-z\\s.,!?'\";:-]*");
        if (!isEnglishOnly) {
            throw new IllegalArgumentException("You have provided non-english message!");
        }

        DroidMessageEncryptor messageEncryptor = (m, k) ->
            cryptMessage(m, k, ((c, base, key1) -> (char) ((c - base + key1 + 26) % 26 + base)));
        return messageEncryptor.cryptor(message, key);
    }

    public String decryptMessage(String message, int key) {
        DroidMessageEncryptor messageEncryptor = (m, k) ->
                cryptMessage(m, k, ((c, base, key1) -> (char) ((c - base - key1 + 26) % 26 + base)));
        return messageEncryptor.cryptor(message, key);
    }

    private String cryptMessage(String message, int key, CharCryptor cryptor) {
        return message.chars()
                .mapToObj(c -> (char) c)
                .map((c) -> Character.isLetter(c) ? cryptor.cryptChar(c, Character.isLowerCase(c) ? 'a' : 'A', key) : c)
                .map(String::valueOf)
                .collect(Collectors.joining());
    }
}


