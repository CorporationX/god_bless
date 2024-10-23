package org.example.model.telegramBot;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        final int REQUEST_NUM = 1000;
        TelegramBot telegramBot = new TelegramBot(0, System.currentTimeMillis());
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for (int i = 0; i < REQUEST_NUM; i++) {
            int finalI = i;
            executorService.submit(() -> telegramBot.sendMessage(String.format("message {%d}", finalI)));
        }

        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.MINUTES);
    }
}
