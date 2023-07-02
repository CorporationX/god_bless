package faang.school.godbless.Sprint_4.Multithreading_Synchronization.TelegramBot;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static TelegramBot telegramBot = new TelegramBot(0, LocalDateTime.now());

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executor = Executors.newFixedThreadPool(10);

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
            executor.awaitTermination(10000, TimeUnit.MILLISECONDS);
            executor.shutdown();
            System.out.println("All sent");
        } catch (InterruptedException e) {
            System.out.println("Error");
        }
    }
}
