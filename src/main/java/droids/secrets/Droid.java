package droids.secrets;

import lombok.NonNull;

import java.util.stream.Collectors;

public class Droid {
    public String sendEncryptedMessage(@NonNull String message, int key) {
        return encryptMessage(((m, k) -> m.chars().map(c -> {
                    if (c >= 'A' && c <= 'Z') {
                        return getNewLetter('A', c, k % 26);
                    }
                    if (c >= 'a' && c <= 'z') {
                        return getNewLetter('a', c, k % 26);
                    }
                    return c;
                }).mapToObj(Character::toString)
                .collect(Collectors.joining())), message, key);
    }

    public String receiveEncryptedMessage(@NonNull String encryptedMessage, int key) {
        return encryptMessage(((m, k) -> m.chars().map(c -> {
                    if (c >= 'A' && c <= 'Z') {
                        return getNewLetter('A', c, 26 - k % 26);
                    }
                    if (c >= 'a' && c <= 'z') {
                        return getNewLetter('a', c, 26 - k % 26);
                    }
                    return c;
                }).mapToObj(Character::toString)
                .collect(Collectors.joining())), encryptedMessage, key);
    }

    private String encryptMessage(@NonNull DroidMessageEncryptor encryptor, @NonNull String message, int key) {
        return encryptor.processMessage(message, key);
    }

    private char getNewLetter(char axisSym, int letter, int key) {
        return (char) (axisSym + ((letter + key) - axisSym) % 26);
    }
}
