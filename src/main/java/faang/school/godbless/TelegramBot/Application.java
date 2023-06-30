package faang.school.godbless.TelegramBot;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Application {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        TelegramBot telegramBot = new TelegramBot(0, System.currentTimeMillis());
        for (int i = 0; i < 10; i++) {
            int j = i + 1;
            executorService.submit(() -> {
                try {
                    telegramBot.sendMessage(String.valueOf(j));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }
    }
}
