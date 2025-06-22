package school.faang.bjs2_81812;

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
        int millisPerSecond = 1000;

        try {
            if (timeElapsed < millisPerSecond) {
                requestCounter++;

                while (requestCounter > REQUEST_LIMIT) {
                    wait(millisPerSecond - timeElapsed);
                    log.info("Превышено ограничение на количество сообщений в секунду. Ожидание...");
                    requestCounter = 0;
                }
            } else {
                requestCounter = 1;
                lastRequestTime = currentTime;
                notifyAll();
            }

            log.info("Сообщение отправлено: {}", message);

        } catch (InterruptedException e) {
            log.error("Ошибка при отправке сообщения", e);
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}
