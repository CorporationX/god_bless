package school.faang.thirdStream.BJS2_37256;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TelegramBot {
    private static final int REQUEST_LIMIT = 5;
    private int requestCounter;
    private long lastRequestTime;

    public TelegramBot() {
        this.requestCounter = 0;
        this.lastRequestTime = System.currentTimeMillis();
    }

    public synchronized void sendMessage(String message) {
        long currentTime = System.currentTimeMillis();
        long timeElapsed = currentTime - lastRequestTime;

        try {
            if (timeElapsed < 1000) {
                requestCounter++;
                if (requestCounter >= REQUEST_LIMIT) {
                    wait(1000 - timeElapsed);
                    requestCounter = 0;
                }
            } else {
                requestCounter = 1;
                lastRequestTime = currentTime;
                notifyAll();
            }

            log.info("Сообщение отправлено: {}", message);

        } catch (InterruptedException e) {
            log.info(e.getMessage());
        }
    }
}
