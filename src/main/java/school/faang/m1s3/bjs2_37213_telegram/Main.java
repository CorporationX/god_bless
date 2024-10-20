package school.faang.m1s3.bjs2_37213_telegram;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        TelegramBot telegramBot = new TelegramBot();

        ExecutorService service = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 100; i++) {
            String message = "message_" + i;
            service.execute(() ->
                    telegramBot.sendMessage(message)
            );
        }

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new IllegalStateException("Thread has been interrupted " + e.getMessage(), e);
        }

        for (int i = 0; i < 10; i++) {
            String message = "message_" + i;
            service.execute(() ->
                    telegramBot.sendMessage(message)
            );
        }

        service.shutdown();

        try {
            if (!service.awaitTermination(25, TimeUnit.SECONDS)) {
                service.shutdownNow();
            }
        } catch (InterruptedException e) {
            throw new IllegalStateException("Thread has been interrupted " + e.getMessage(), e);
        }

        System.out.println();
        System.out.println("Task completed successfully");
    }
}
