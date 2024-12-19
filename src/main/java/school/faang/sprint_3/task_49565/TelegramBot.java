package school.faang.sprint_3.task_49565;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

@Slf4j
public class TelegramBot {
    private static final int REQUEST_LIMIT = 5;
    public static final long REQUEST_DELAY = 1000;
    private int requestCounter;
    private long lastRequestTime;


    public TelegramBot() {
        this.requestCounter = 0;
        this.lastRequestTime = System.currentTimeMillis();
    }

    public synchronized void sendMessage(String message) {
        long currentTime = System.currentTimeMillis();
        long timeElapsed = currentTime - lastRequestTime;
        long waitTime = REQUEST_DELAY - timeElapsed;

        if (timeElapsed < REQUEST_DELAY) {
            log.info("Запрос №{}", requestCounter);
            requestCounter++;
            if (requestCounter > REQUEST_LIMIT) {
                try {
                    log.info("Ожидаю окончание срока приостановки запроса. Осталось {} мс", waitTime);
                    Thread.sleep(waitTime);
                    requestCounter = 0;
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    log.error("Поток прерван во время ожидания приостановки запроса");
                }
            }
        } else {
            requestCounter = 0;
            lastRequestTime = currentTime;
            notifyAll();
        }
        System.out.println("Отправлено сообщение: " + message);

    }
}
