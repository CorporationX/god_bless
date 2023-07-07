package faang.school;

import lombok.Getter;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class MilitaryBase implements Runnable {
    @Getter
    private final BlockingQueue<String> inbox = new ArrayBlockingQueue<>(3);
    private volatile boolean running = true;

    public void sendMessage(String message, MilitaryBase receiver) {
        try {
            receiver.getInbox().put(EncryptionUtils.encrypt(message));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void stop() {
        running = false;
        System.out.println(this + "is stopped");
    }

    @Override
    public void run() {
        while (running) {
            try {
                Thread.sleep(1000);
                if (!inbox.isEmpty()) {
                    System.out.println(EncryptionUtils.decrypt(inbox.poll(1, TimeUnit.SECONDS)));
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
