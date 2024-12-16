package school.faang.task_49206;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int BUFFER_SIZE = 25;

    public static void main(String[] args) throws InterruptedException {
        TelegramBot telegramBot = new TelegramBot();
        ExecutorService executorService = Executors.newFixedThreadPool(BUFFER_SIZE);

        for (int i = 0; i < BUFFER_SIZE; i++) {
            int finalI = i;
            executorService.execute(() -> {
                try {
                    telegramBot.sendMessage("message number : " + finalI);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        if (!executorService.awaitTermination(15, TimeUnit.SECONDS)) {
            executorService.shutdown();
            System.out.println("Shutdown!");
        }
    }
}