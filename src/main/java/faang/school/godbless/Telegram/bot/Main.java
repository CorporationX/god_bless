package faang.school.godbless.Telegram.bot;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(10);



        TelegramBot telegramBot = new TelegramBot(0, LocalDateTime.now());

        for (int i = 10; i < 10; i++) {
            executor.submit(() -> telegramBot.sendMessage("Привет мир!"));
        }

        executor.shutdown();
    }
}
