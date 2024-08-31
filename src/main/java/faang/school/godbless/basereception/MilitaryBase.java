package faang.school.godbless.basereception;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

@Slf4j
public class MilitaryBase implements Runnable {
    private final String baseId;
    private final BlockingQueue<String> inbox;
    private volatile boolean running;

    public MilitaryBase(String id) {
        this.baseId = id;
        this.inbox = new LinkedBlockingQueue<>();
        this.running = true;
    }

    public void sendMessage(MilitaryBase receiverBase, String message) {
        String encryptedMessage = EncryptionUtils.encrypt(message);
        receiverBase.receiveMessage(encryptedMessage);
    }

    private void receiveMessage(String encryptedMessage) {
        inbox.offer(encryptedMessage);
    }

    public void stop() {
        running = false;
    }

    @Override
    public void run() {
        while (running) {
            try {
                String encryptedMessage = inbox.poll(1, TimeUnit.SECONDS);
                if (encryptedMessage != null) {
                    String decryptedMessage = EncryptionUtils.decrypt(encryptedMessage);
                    log.info("{} received message: {}", baseId, decryptedMessage);
                }
            } catch (InterruptedException e) {
                log.error("{} encountered an error: {}", baseId, e.getMessage());
            }
        }
        log.info("{} has stopped", baseId);
    }
}