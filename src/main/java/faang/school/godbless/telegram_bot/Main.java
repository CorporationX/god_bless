package faang.school.godbless.telegram_bot;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        TelegramBot telegramBot = new TelegramBot(0, LocalDateTime.now());
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 50; i++) {
            int number = i;
            executorService.submit(() -> telegramBot.sendMessage("Message " + number));
        }

        executorService.shutdown();

        try {
            executorService.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("All messages send");
    }
}
