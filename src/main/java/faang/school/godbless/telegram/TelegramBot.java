package faang.school.godbless.telegram;

import ch.qos.logback.core.joran.conditional.ThenAction;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;

@AllArgsConstructor
@Getter
public class TelegramBot {
    private final int REQUEST_LIMIT = 5;
    private int requestCounter;
    private long lastRequestTime;

    public void sendMessage(String message) throws InterruptedException {
        long startTime = lastRequestTime;
        System.out.println(message);
        long currentTime = System.currentTimeMillis() - startTime;

        if (currentTime < TimeUnit.MILLISECONDS.toMillis(1000)) {
            requestCounter++;
        }
        if (REQUEST_LIMIT < requestCounter) {
            wait();
        }
        if (currentTime >= TimeUnit.MILLISECONDS.toMillis(1000)) {
            requestCounter = 0;
            lastRequestTime = 0;
            notify();
        }
    }


    public static void main(String[] args) {
        TelegramBot telegramBot = new TelegramBot(0, System.currentTimeMillis());

        Runnable runnable = () -> {
            try {
                telegramBot.sendMessage("hello");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        Thread thread3 = new Thread(runnable);
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
