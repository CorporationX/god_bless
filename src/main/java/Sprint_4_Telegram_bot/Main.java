package Sprint_4_Telegram_bot;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        TelegramBot bot = new TelegramBot(0);

        ExecutorService executorService = Executors.newFixedThreadPool(15);
        for (int i = 0; i < 34; i++) {
            executorService.execute(() -> {
                bot.sendMessage(Thread.currentThread().getName() + "Hello");
            });
        }

        executorService.shutdown();
        try {
            executorService.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("задача выполнена.");
    }
}
