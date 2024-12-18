package school.faang.task49222;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Slf4j
public class TelegramBot {
    private static final int REQUEST_LIMIT = 5;

    private int requestCounter;
    private long lastRequestTime;

    public synchronized void sendMessage(String message) {
        long afterTime = System.currentTimeMillis() - lastRequestTime;

        if (afterTime < 1000) {
            requestCounter++;
            if (requestCounter > REQUEST_LIMIT) {
                log.info("Превышено число запросов");
                try {
                    wait(1000 - afterTime);
                } catch (InterruptedException e) {
                    log.error("Error message", e);
                }
                requestCounter = 0;
            }
        } else {
            requestCounter = 1;
            lastRequestTime = System.currentTimeMillis();
            notifyAll();
        }

        log.info("{} отправил сообщение {}", Thread.currentThread().getName(), message);
    }
}
