package faang.school.godbless.Sprint_4.Multithreading_Synchronization.TelegramBot;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    //private static TelegramBot telegramBot = new TelegramBot(0, LocalDateTime.now());
    private static TelegramBot telegramBot = new TelegramBot(0, Instant.now());

    public static void main(String[] args) throws InterruptedException {

        final int nThreads = 3;
        ExecutorService executor = Executors.newFixedThreadPool(nThreads);

        for (int i = 0; i < 10; i++) {
            executor.execute(() -> {
                try {
                    telegramBot.sendMessage("Привет мир!");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        try {
            executor.shutdown();
            executor.awaitTermination(10000, TimeUnit.MILLISECONDS);
            System.out.println("All sent");
        } catch (InterruptedException e) {
            System.out.println("Error");
        }
    }
}
