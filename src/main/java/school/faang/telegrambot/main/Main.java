package school.faang.telegrambot.main;

import school.faang.telegrambot.maincode.TelegramBot;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int THREAD_COUNT = 5;

    public static void main(String[] args) {
        TelegramBot bot = new TelegramBot();

        ExecutorService service = Executors.newFixedThreadPool(THREAD_COUNT);

        for (int i = 0; i < 10; i++) {
            String message = "message_" + i;
            service.submit(() -> bot.sendMessage(message));
        }

        service.shutdown();
        try {
            if (!service.awaitTermination(2, TimeUnit.MINUTES)) {
                service.shutdownNow();
            }
        } catch (InterruptedException e) {
            service.shutdownNow();
        }
    }
}
