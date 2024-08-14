package droids.secrets;

import lombok.NonNull;

import java.util.stream.Collectors;

public class Droid {
    public String sendEncryptedMessage(@NonNull String message, int key) {
        return encryptMessage(((m, k) -> m.chars().map(c -> {
            if (c < 91 && c > 64) {
                return 'A' + ((c + k % 26) - 'A') % 26;
            }
            if (c < 123 && c > 96) {
                return 'a' + ((c + k % 26) - 'a') % 26;
            }
            return c + k % 26;
        }).mapToObj(Character::toString)
                .collect(Collectors.joining())), message, key);
    }

    public String receiveEncryptedMessage(@NonNull String encryptedMessage, int key) {
        return encryptMessage(((m, k) -> m.chars().map(c -> {
                    if (c < 91 && c > 64) {
                        return 'A' + Math.floorMod((c - k % 26) - 'A', 26);
                    }
                    if (c < 123 && c > 96) {
                        return 'a' + Math.floorMod((c - k % 26) - 'a', 26);
                    }
                    return c - k % 26;
                }).mapToObj(Character::toString)
                .collect(Collectors.joining())), encryptedMessage, key);
    }

    private String encryptMessage(@NonNull DroidMessageEncryptor encryptor, @NonNull String message, int key) {
        return encryptor.processMessage(message, key);
    }
}
