package faang.school.godbless.Telegram.bot;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    private static TelegramBot telegramBot = new TelegramBot(0, LocalDateTime.now());

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 10; i++) {
            executor.submit(() -> telegramBot.sendMessage("Привет мир!"));
        }

        executor.shutdown();
    }
}
