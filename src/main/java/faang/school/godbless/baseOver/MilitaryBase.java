package faang.school.godbless.baseOver;

import lombok.Getter;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

@Getter
public class MilitaryBase implements Runnable {
    private final BlockingQueue<String> inbox;
    private volatile boolean running;

    public MilitaryBase() {
        inbox = new LinkedBlockingQueue<>();
        running = true;
    }

    public void sendMessage(String message, MilitaryBase recipient) {
        String encryptedMessage = EncryptionUtils.encrypt(message);

        if (encryptedMessage != null) {
            boolean offerResult = recipient.getInbox().offer(encryptedMessage);
            if (offerResult) {
                System.out.println("Sent encrypted message: " + encryptedMessage);
            } else {
                System.out.println("Failed to send encrypted message: " + encryptedMessage);
            }
        }
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
                    System.out.println("Received decrypted message: " + decryptedMessage);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
