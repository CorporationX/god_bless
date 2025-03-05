package school.faang;

import lombok.extern.slf4j.Slf4j;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

@Slf4j
public class MilitaryBase implements Runnable {
    private final Queue<String> inbox = new LinkedBlockingQueue<>();
    private volatile boolean isRunning = true;
    private static final int DECRYPTION_INTERVAL_MS = 2000;

    @Override
    public void run() {
        while (isRunning && !inbox.isEmpty()) {
            try {
                log.info("Decrypted message: {}", EncryptionUtils.decrypt(inbox.remove()));
            } catch (Exception e) {
                log.error("Error while decrypting message.", e);
            }
            try {
                Thread.sleep(DECRYPTION_INTERVAL_MS);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error("Sleep was interrupted.");
            }
        }
    }

    public void sendMessage(MilitaryBase destinationBase, String message) {
        try {
            String encryptedMessage = EncryptionUtils.encrypt(message);
            destinationBase.inbox.add(encryptedMessage);
        } catch (Exception e) {
            log.error("Error while sending message.");
        }
    }

    public void stop() {
        isRunning = false;
        log.info("Message decryption stopped.");
    }
}
