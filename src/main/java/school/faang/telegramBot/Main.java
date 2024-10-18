package school.faang.telegramBot;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int NUM_THREADS = 10;

    public static void main(String[] args) {
        TelegramBot bot = new TelegramBot();
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);
        for (int i = 0; i < 100; i++) {
            int finalI = i;
            executor.submit(() -> bot.sendMessage("Message " + finalI));
        }
        executor.shutdown();
        try {
            if (!executor.awaitTermination(5, TimeUnit.MINUTES)) {
                System.out.println("Some threads couldn't complete their tasks in time");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("All threads completed working.");
    }
}
