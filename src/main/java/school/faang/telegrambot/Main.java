package school.faang.telegrambot;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int THREAD_POOL_SIZE = 8;
    private static final int TIME_TO_WORK = 100;
    private static final int COUNT_MESSAGE = 30;

    public static void main(String[] args) {
        TelegramBot telegramBot = new TelegramBot();

        ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        for (int i = 0; i < COUNT_MESSAGE; i++) {
            executor.submit(() -> telegramBot.sendMessage("Новое сообщение"));
        }

        executor.shutdown();

        try {
            if (executor.awaitTermination(TIME_TO_WORK, TimeUnit.SECONDS)) {
                System.out.println("Программа завершила работу.");
            } else {
                System.out.println("Программа была принудительно завершена.");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}