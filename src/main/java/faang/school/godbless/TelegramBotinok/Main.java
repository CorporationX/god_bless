package faang.school.godbless.TelegramBotinok;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        TelegramBot telegramBot = new TelegramBot(5, LocalDateTime.now());
        ExecutorService executor = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 3; i++) {
            executor.execute(() -> {
                for (int j = 0; j < 10; j++) {
                    telegramBot.sendMessage("j " + Thread.currentThread().getName());
                }
            });
        }
        executor.shutdown();
    }
}
