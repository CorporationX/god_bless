package droids.secrets;

import lombok.NonNull;

import java.util.stream.Collectors;

public class Droid {
    public String sendEncryptedMessage(@NonNull String message, int key) {
        return encryptMessage(((m, k) -> m.chars().map(c -> {
            if (c >= 'A' && c <= 'Z') {
                return 'A' + ((c + k % 26) - 'A') % 26;
            }
            if (c >= 'a' && c <= 'z') {
                return 'a' + ((c + k % 26) - 'a') % 26;
            }
            return c + k % 26;
        }).mapToObj(Character::toString)
                .collect(Collectors.joining())), message, key);
    }

    public String receiveEncryptedMessage(@NonNull String encryptedMessage, int key) {
        return encryptMessage(((m, k) -> m.chars().map(c -> {
                    if (c >= 'A' && c <= 'Z') {
                        return 'A' + Math.floorMod((c + (26 - k % 26)) - 'A', 26);
                    }
                    if (c >= 'a' && c <= 'z') {
                        return 'a' + Math.floorMod((c + (26 - k % 26)) - 'a', 26);
                    } else {
                        return c;
                    }}).mapToObj(Character::toString)
                .collect(Collectors.joining())), encryptedMessage, key);
    }

    private String encryptMessage(@NonNull DroidMessageEncryptor encryptor, @NonNull String message, int key) {
        return encryptor.processMessage(message, key);
    }

    private char getNewLetter(char axisSym, char letter, int key) {
        return (char) (axisSym + ((letter + key) - axisSym) % 26);
    }
}
