package faang.school.godbless.synchronize.telegramBot;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        TelegramBot bot = new TelegramBot();

        ExecutorService executorService = Executors.newFixedThreadPool(20);

        for (int i = 0; i < 20; i++) {
            int finalI = i;
            executorService.execute(() -> {
                try {
                    bot.sendMessage("Hello" + finalI);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        executorService.shutdown();

        executorService.awaitTermination(10, TimeUnit.SECONDS);
    }
}
