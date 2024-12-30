package school.faang.sprint_4.task_51034;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.LinkedBlockingQueue;

@Slf4j
public class MilitaryBase implements Runnable {
    private static final int READING_DELAY = 1000;

    private final LinkedBlockingQueue<String> inbox = new LinkedBlockingQueue<>();

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Thread.sleep(READING_DELAY);
                String encryptedMessage = inbox.take();
                String decryptedMessage = EncryptionUtils.decrypt(encryptedMessage);
                System.out.println(decryptedMessage);
            } catch (InterruptedException e) {
                handleInterrupt();
                break;
            } catch (Exception e) {
                log.warn("Decryption error", e);
            }
        }
    }

    public void sendMessage(MilitaryBase destinationBase, String message) {
        try {
            destinationBase.inbox.put(EncryptionUtils.encrypt(message));
        } catch (InterruptedException e) {
            handleInterrupt();
        } catch (Exception e) {
            log.warn("Encryption error", e);
        }
    }

    private void handleInterrupt() {
        log.info("Thread interrupted");
        Thread.currentThread().interrupt();
    }
}
