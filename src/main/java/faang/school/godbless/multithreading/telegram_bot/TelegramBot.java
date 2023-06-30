package faang.school.godbless.multithreading.telegram_bot;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TelegramBot {
    private final static int REQUEST_LIMIT = 5;
    private final static int INTERVAL_MS = 1000;
    private int requestCounter;
    private ScheduledExecutorService service;


    public TelegramBot() {
        this.requestCounter = 0;
        service = Executors.newSingleThreadScheduledExecutor();
    }

    public synchronized void sendMessage() {
        if (requestCounter < REQUEST_LIMIT) {
            requestCounter++;
            System.out.printf("Request N%s\n", requestCounter);
        } else {
            System.out.println("Limit reached. Wait..");
        }
    }

    public void start() {
        service.scheduleAtFixedRate(this::resetCounter, 0, INTERVAL_MS, TimeUnit.MILLISECONDS);
    }

    public void stop() {
        service.shutdown();
    }

    private void resetCounter() {
        requestCounter = 0;
    }
}
