package school.faang.telegrambot;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int THREAD_COUNT = 5;

    public static void main(String[] args) {
        TelegramBot bot = new TelegramBot();
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);

        for (int i = 0; i < 100; i++) {
            final int messageId = i;
            executor.submit(() -> bot.sendMessage("Сообщение #" + messageId));
        }

        executor.shutdown();
        try {
            if (!executor.awaitTermination(20, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            throw new IllegalStateException("Thread hes been interrupted " + e);
        }

        System.out.println("Все сообщения отправлены.");
    }
}