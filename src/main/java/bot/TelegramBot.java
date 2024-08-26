package bot;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TelegramBot {
    private static final int REQUEST_LIMIT = 10;
    private static final long TIME_LIMIT = 1000;
    private volatile int requestCounter;
    private long lastRequestTime;

    public TelegramBot() {
        requestCounter = 0;
        lastRequestTime = System.currentTimeMillis();
    }

    public synchronized void sendMessage(@NonNull String message) {
        long deltaTime = System.currentTimeMillis() - lastRequestTime;
        if (deltaTime >= TIME_LIMIT) {
            lastRequestTime = System.currentTimeMillis();
            requestCounter = 0;
            notifyAll();
        } else {
            if (requestCounter >= REQUEST_LIMIT) {
                try {
                    log.info("Waiting for send..." + (TIME_LIMIT - deltaTime));
                    Thread.sleep(TIME_LIMIT - deltaTime);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    throw new RuntimeException(e);
                }
            }
            while (requestCounter >= REQUEST_LIMIT) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    throw new RuntimeException(e);
                }
            }
        }
        requestCounter++;
        sendMessageWithAPI(message);
    }

    private void sendMessageWithAPI(@NonNull String message) {
        log.info("Sending message: " + message);
    }
}
