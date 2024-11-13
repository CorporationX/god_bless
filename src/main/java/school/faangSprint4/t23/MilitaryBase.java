package school.faangSprint4.t23;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class MilitaryBase implements Runnable {
    private final BlockingQueue<String> inbox;
    private volatile boolean running;
    private final String baseName;

    public MilitaryBase(String baseName) {
        this.inbox = new LinkedBlockingQueue<>();
        this.running = true;
        this.baseName = baseName;
    }

    @Override
    public void run() {
        while (running) {
            try {
                String encryptedMessage = inbox.poll(1, TimeUnit.SECONDS);
                if (encryptedMessage != null) {
                    String decryptedMessage = EncryptionUtils.decrypt(encryptedMessage);
                    System.out.printf("%s received message: %s%n", baseName, decryptedMessage);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }

    public void sendMessage(MilitaryBase destinationBase, String message) {
        String encryptedMessage = EncryptionUtils.encrypt(message);
        destinationBase.inbox.offer(encryptedMessage);
        System.out.printf("%s sent encrypted message to %s%n", baseName, destinationBase.baseName);
    }

    public void stop() {
        running = false;
    }
}