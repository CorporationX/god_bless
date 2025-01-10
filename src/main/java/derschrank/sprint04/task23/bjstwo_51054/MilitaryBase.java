package derschrank.sprint04.task23.bjstwo_51054;

import java.util.Optional;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MilitaryBase implements Base {
    private static final int FREQUENCY_SEC = 1;

    private final Queue<String> inbox;
    private final String name;

    private volatile boolean running;

    public MilitaryBase(String name) {
        running = false;
        this.name = name;
        inbox = new LinkedBlockingQueue<>();
    }

    @Override
    public void sendMessage(Base destinationBase, String message) {
        message = String.format("From Base: %s, message: %s", name, message);
        destinationBase.receiveMessage(
                EncryptionUtils.encrypt(message)
        );
    }

    @Override
    public void receiveMessage(String encryptedMessage) {
        inbox.add(encryptedMessage);
    }

    @Override
    public void stop() {
        running = false;
    }

    @Override
    public void checkNewMessages() {
        while (running && !inbox.isEmpty()) {
            outPutMessage(
                    EncryptionUtils.decrypt(
                            inbox.poll()
                    )
            );
        }
    }

    @Override
    public void outPutMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void run() {
        running = true;
        System.out.printf("Base: %s is RUNNING for receive messages.%n", name);
        while (running && !Thread.currentThread().isInterrupted()) {
            checkNewMessages();
            doSleep(FREQUENCY_SEC);
        }
        System.out.printf("Base: %s is STOPPED for receive messages.%n", name);
    }

    private void doSleep(int delaySec) {
        try {
            Thread.sleep(delaySec * 1000);
        } catch (InterruptedException e) {
            System.out.println("Was interrupted: " + e);
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
