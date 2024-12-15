package school.faang.sprint2.task_46203;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class Droid {
    private static final DroidMessageService droidMessageService = new DroidMessageService();

    @NonNull
    private final String title;

    public void sendMessage(@NonNull Droid droid, @NonNull String message, int key) {
        String encrypted = droidMessageService.encryptMessage(message, key);
        log.info("Droid: " + title + ". Sending encrypted message: " + encrypted);
        droid.receiveMessage(encrypted, key);
    }

    private void receiveMessage(String message, int key) {
        String decrypted = droidMessageService.decryptMessage(message, key);
        log.info("Droid: " + title + ". Received decrypted message: " + decrypted);
    }
}
