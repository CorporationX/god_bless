package school.faang.bjs290095;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    private static final int THREADS_COUNT = 5;
    private static final int MESSAGES_COUNT = 6;

    public static void main(String[] args) {
        TelegramBot bot = new TelegramBot();
        ExecutorService executorService = Executors.newFixedThreadPool(THREADS_COUNT);

        for (int i = 0; i < MESSAGES_COUNT; i++) {
            final int finalI = i;
            executorService.submit(() -> {
                bot.sendMessage("Some message " + finalI);
                try {
                    Thread.sleep(100); // Задержка для наглядности
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    e.printStackTrace();
                }
            });
        }

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(1, java.util.concurrent.TimeUnit.MINUTES)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }

        System.out.println("Task completed!");
    }
}
