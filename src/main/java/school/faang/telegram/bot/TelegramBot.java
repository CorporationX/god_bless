package school.faang.telegram.bot;

import lombok.extern.slf4j.Slf4j;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;

@Slf4j
public class TelegramBot {
    private static final int REQUEST_LIMIT = 5;

    private int requestCounter = 0;
    private LocalDateTime lastRequestTime;

    public TelegramBot() {
        lastRequestTime = LocalDateTime.now();
    }

    public synchronized void sendMessage(String message) {
        Duration timeSinceLastRequest = Duration.between(lastRequestTime, LocalDateTime.now());
        if (timeSinceLastRequest.getSeconds() <= 1) {
            requestCounter++;
            if (requestCounter >= REQUEST_LIMIT) {
                System.out.println("Превышено число запросов в секунду");
                System.out.println(timeSinceLastRequest.getSeconds());
                try {
                    Thread.sleep(getMillisToWait());
                } catch (InterruptedException e) {
                    log.error(e.getMessage());
                    log.error(Arrays.toString(e.getStackTrace()));
                }
            }
        } else {
            System.out.println("Последний запрос был " + lastRequestTime);
            System.out.println(timeSinceLastRequest.getSeconds() + " секунд назад");
            requestCounter = 0;
            lastRequestTime = LocalDateTime.now();
            System.out.println("Текущее время " + lastRequestTime);
        }
        System.out.println("Сообщение " + message + " было успешно отправлено");
    }

    private long getMillisToWait() {
        var now = LocalDateTime.now();
        var nextSecond = now.plusSeconds(1).truncatedTo(ChronoUnit.SECONDS);
        return Duration.between(now, nextSecond).toMillis();
    }
}
