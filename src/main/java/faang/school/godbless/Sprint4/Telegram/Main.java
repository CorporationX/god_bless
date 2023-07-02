package faang.school.godbless.Sprint4.Telegram;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        TelegramBot telegramBot = new TelegramBot(0, LocalDateTime.now());
        ExecutorService executors = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 10; i++) {
            executors.execute(telegramBot);
        }
        Thread.sleep(20000);
        for (int i = 0; i < 10; i++) {
            executors.execute(telegramBot);
        }
        executors.shutdown();
    }
}
