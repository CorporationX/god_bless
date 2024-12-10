package school.faang.sprint2.task_46203;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class Droid {
    @NonNull
    private final String title;

    public void sendMessage(Droid droid, @NonNull String message, int key) {
        String encrypted = encryptMessage(message, key);
        log.info("Droid: " + title + ". Sending encrypted message: " + encrypted);
        droid.recieveMessage(encrypted, key);
    }

    public void recieveMessage(@NonNull String message, int key) {
        String decrypted = decryptMessage(message, key);
        log.info("Droid: "  + title + ". Recieved decrypted message: " + decrypted);
    }

    private String encryptMessage(@NonNull String message, int key) {
        DroidMessageEncryptor messageEncryptor = (m, k) -> {
            StringBuilder encryptedMessage = new StringBuilder();
            for (char c : m.toCharArray()) {
                if (Character.isLetter(c)) {
                    char base = Character.isLowerCase(c) ? 'a' : 'A';
                    encryptedMessage.append((char) ((c - base + k) % 26 + base));
                } else {
                    encryptedMessage.append(c);
                }
            }
            return encryptedMessage.toString();
        };
        return messageEncryptor.cryptor(message, key);
    }

    private String decryptMessage(@NonNull String message, int key) {
        DroidMessageEncryptor messageEncryptor = (m, k) -> {
            StringBuilder decryptedMessage = new StringBuilder();
            for (char c : m.toCharArray()) {
                if (Character.isLetter(c)) {
                    char base = Character.isLowerCase(c) ? 'a' : 'A';
                    decryptedMessage.append((char) ((c - base - k + 26) % 26 + base));
                } else {
                    decryptedMessage.append(c);
                }
            }
            return decryptedMessage.toString();
        };
        return messageEncryptor.cryptor(message, key);
    }
}
