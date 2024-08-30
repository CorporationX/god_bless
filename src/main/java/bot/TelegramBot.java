package bot;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TelegramBot {
    private static final int REQUEST_LIMIT = 10;
    private static final long TIME_LIMIT = 1000;
    private int requestCounter;
    private long lastRequestTime;

    public TelegramBot() {
        requestCounter = 0;
        lastRequestTime = System.currentTimeMillis();
    }

    public synchronized void sendMessage(@NonNull String message) {
        long deltaTime = System.currentTimeMillis() - lastRequestTime;
        if (deltaTime < TIME_LIMIT) {
            while (requestCounter >= REQUEST_LIMIT) {
                if (System.currentTimeMillis() - lastRequestTime >= TIME_LIMIT) {
                    reset();
                    break;
                }
                try {
                    wait(TIME_LIMIT - deltaTime);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    throw new RuntimeException(e);
                }
            }
        } else {
            reset();
        }
        sendMessageWithAPI(message);
        requestCounter++;
    }

    private synchronized void reset() {
        lastRequestTime = System.currentTimeMillis();
        requestCounter = 0;
        log.info("----");
        this.notifyAll();
    }

    private void sendMessageWithAPI(@NonNull String message) {
        log.info("Sending message: " + message);
    }
}
