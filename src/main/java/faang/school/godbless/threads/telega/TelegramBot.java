package faang.school.godbless.threads.telega;

import lombok.AllArgsConstructor;

import javax.xml.crypto.Data;
import java.time.Duration;
import java.time.LocalTime;

public class TelegramBot{
    private final int REQUEST_LIMIT = 5;
    private int requestCounter;
    private LocalTime lastRequestTime;

    public TelegramBot() {
        this.requestCounter = 0;
        this.lastRequestTime = LocalTime.now();
    }

    public synchronized void sendMessage() {
        LocalTime nowTime = LocalTime.now();
        long diffSeconds = Duration.between(lastRequestTime, nowTime).toMillis();
        if (diffSeconds < 1000) {
            requestCounter++;
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Сообщение отправлено: " + requestCounter);
            if (requestCounter == 5) {
                try {
                    System.out.println("Ожидаем освобождение лимита ...");
                    Thread.sleep(1000 - diffSeconds);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        else {
            requestCounter = 0;
            this.lastRequestTime = LocalTime.now();
            System.out.println("Лимит обновлен!");
        }
    }
}
