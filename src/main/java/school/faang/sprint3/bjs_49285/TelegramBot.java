package school.faang.sprint3.bjs_49285;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TelegramBot {
    private static final int REQUEST_LIMIT = 5;
    private static final int MILLISECONDS_IN_SECOND = 1000;

    private int requestCounter;
    private long lastRequestTime;

    public TelegramBot() {
        this.requestCounter = 0;
        this.lastRequestTime = System.currentTimeMillis();
    }

    public synchronized void sendMessage(String message) {
        long currentTime = System.currentTimeMillis();
        long elapsedTime = currentTime - lastRequestTime;

        try {
            if (elapsedTime < MILLISECONDS_IN_SECOND) {
                requestCounter++;
                if (requestCounter > REQUEST_LIMIT) {
                    wait(1000 - elapsedTime);
                    requestCounter = 0;
                }
            } else {
                requestCounter = 1;
                lastRequestTime = currentTime;
                notifyAll();
            }

            log.info("Сообщение отправлено: " + message);
        } catch (InterruptedException e) {
            log.info("Поток был прерван");
        }
    }
}
