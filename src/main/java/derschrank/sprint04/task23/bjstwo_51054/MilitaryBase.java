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
    private static final int DELAY_SEC = 0;
    private static final int FREQUENCY_SEC = 1;

    private final ScheduledExecutorService executor;
    private final Queue<String> inbox;
    private final String name;

    private Future<?> future;
    private volatile boolean running;

    public MilitaryBase(String name) {
        running = false;
        this.name = name;
        inbox = new LinkedBlockingQueue<>();
        executor = Executors.newSingleThreadScheduledExecutor();
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
        Optional.ofNullable(future).ifPresent(f -> f.cancel(true));
        Optional.ofNullable(executor).ifPresent(ExecutorService::shutdownNow);
        System.out.printf("Base: %s is STOPPED for receive messages.%n", name);
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
        future = executor.scheduleAtFixedRate(
                () -> checkNewMessages(),
                DELAY_SEC,
                FREQUENCY_SEC,
                TimeUnit.SECONDS
        );
        System.out.printf("Base: %s is RUNNING for receive messages.%n", name);
    }

    @Override
    public String toString() {
        return name;
    }
}
