package faang.school.godbless.BaseReception;

import java.util.Objects;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

import static faang.school.godbless.BaseReception.EncryptionUtils.decrypt;
import static faang.school.godbless.BaseReception.EncryptionUtils.encrypt;

public class MilitaryBase implements Runnable {
    private BlockingDeque<String> inbox;
    private volatile boolean isRunning;

    public MilitaryBase() {
        this.inbox = new LinkedBlockingDeque<>();
    }

    public void sendMessage(String message, MilitaryBase militaryBase) {
        try {
            militaryBase.inbox.put(Objects.requireNonNull(encrypt(message)));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        isRunning = true;
        if (inbox != null) {
            while (isRunning) {
                try {
                    String message = inbox.poll(1, TimeUnit.SECONDS);
                    if (message != null) {
                        String decryptedMessage = decrypt(message);
                        System.out.println(Thread.currentThread().getId() + " | Received message: " + decryptedMessage);
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public void stop() {
        isRunning = false;
        System.out.println("Reading stopped");
    }
}
