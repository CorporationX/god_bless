package school.faang.star_wars;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import school.faang.util.AsciiUtil;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

@Getter
@Setter
@RequiredArgsConstructor
public class Droid {
    private final String name;

    public void sendMessage(@NonNull Droid recipient, @NonNull String message, int encryptorKey) {
        String encryptedMessage = encryptMessage(message, encryptorKey);
        System.out.printf("%s sent encrypted message: \"%s\"\n", name, encryptedMessage);
        recipient.receiveMessage(encryptedMessage, encryptorKey);
    }

    public void receiveMessage(@NonNull String encryptedMessage, int encryptorKey) {
        String decryptedMessage = decryptMessage(encryptedMessage, encryptorKey);
        System.out.printf("%s received encrypted message:\"%s\"\n\tdecrypted message: \"%s\"\n",
                name, encryptedMessage, decryptedMessage);
    }

    private String encryptMessage(@NonNull String message, int encryptorKey) {
        DroidMessageEncryptor encryptor = (msg, key) -> encryptDecryptMessage(msg, key, true);
        return encryptor.encrypt(message, encryptorKey);
    }

    private String decryptMessage(String message, int encryptorKey) {
        DroidMessageEncryptor encryptor = (msg, key) -> encryptDecryptMessage(msg, key, false);
        return encryptor.encrypt(message, encryptorKey);
    }

    private String encryptDecryptMessage(String message, int encryptorKey, boolean forward) {
        byte[] bytes = message.getBytes(StandardCharsets.US_ASCII);

        for (int i = 0; i < bytes.length; i++) {
            if (AsciiUtil.isLetter(bytes[i])) {
                bytes[i] = AsciiUtil.shiftAsciiLetter(bytes[i], encryptorKey, Character.isUpperCase(bytes[i]), forward);
            }
        }

        return new String(bytes, StandardCharsets.US_ASCII);
    }
}
