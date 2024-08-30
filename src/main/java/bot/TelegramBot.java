package bot;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

@Slf4j
public class TelegramBot {
    private static final int REQUEST_LIMIT = 10;
    private static final long TIME_LIMIT = 1000;
    private AtomicInteger requestCounter;
    private AtomicLong lastRequestTime;

    public TelegramBot() {
        requestCounter = new AtomicInteger(0);
        lastRequestTime = new AtomicLong(System.currentTimeMillis());
    }

    public synchronized void sendMessage(@NonNull String message) {
        long deltaTime = System.currentTimeMillis() - lastRequestTime.get();
        if (deltaTime < TIME_LIMIT) {
            while (requestCounter.get() >= REQUEST_LIMIT) {
                if (System.currentTimeMillis() - lastRequestTime.get() >= TIME_LIMIT) {
                    reset();
                }
                try {
                    wait(TIME_LIMIT - deltaTime);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    throw new RuntimeException(e);
                }
            }
        }
        sendMessageWithAPI(message);
        requestCounter.getAndIncrement();
    }

    private synchronized void reset() {
        lastRequestTime.set(System.currentTimeMillis());
        requestCounter.set(0);
        log.info("----");
        this.notifyAll();
    }

    private void sendMessageWithAPI(@NonNull String message) {
        log.info("Sending message: " + message);
    }
}
