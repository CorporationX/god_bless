package school.faang.sprint_3.task_49209;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int NUMBER_OF_THREADS = 4;
    private static final int NUMBER_OF_MESSAGES = 1000;
    private static final int AWAIT_DELAY = 1;

    public static void main(String[] args) {
        TelegramBot telegramBot = new TelegramBot();

        ExecutorService executorService = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

        for (int i = 1; i <= NUMBER_OF_MESSAGES; i++) {
            int finalI = i;
            executorService.submit(() -> telegramBot.sendMessage("Message " + finalI));
        }

        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(AWAIT_DELAY, TimeUnit.MINUTES)) {
                System.out.println("Await timed out. Shutting down...");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted. Shutting down...");
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
