package school.faang.task_49233;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public class TelegramBot {

    private static final int REQUEST_LIMIT = 5;
    public static final long MILLISECONDS_PER_SECOND = 1000;
    private static final int ONE_SECOND_IN_SECONDS = 1;


    private int requestCounter;
    private long lastRequestTime;

    public TelegramBot() {
        this.requestCounter = 0;
        this.lastRequestTime = System.currentTimeMillis();
    }

    public synchronized void sendMessage(String message) {
        long currentTimeMillis = System.currentTimeMillis();
        long elapsedTime = (currentTimeMillis - lastRequestTime) / MILLISECONDS_PER_SECOND;
        try {
            if (elapsedTime < ONE_SECOND_IN_SECONDS) {
                requestCounter++;
                if (requestCounter > REQUEST_LIMIT) {
                    long waitTime = MILLISECONDS_PER_SECOND - (currentTimeMillis - lastRequestTime);
                    System.out.println("Лимит превышен. Ожидайте.");
                    Thread.sleep(waitTime);
                }
            } else {
                requestCounter = 1;
                lastRequestTime = currentTimeMillis;
            }
        } catch (InterruptedException e) {
            log.info(e.getMessage());
        }

        System.out.printf("Сообщение с текстом: <%s> - отправлено!\n", message);
    }
}
