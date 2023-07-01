package faang.school.godbless.telegramBot;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        TelegramBot telegramBot = new TelegramBot(5);
        ExecutorService executorService = Executors.newFixedThreadPool(8);

        long start = System.currentTimeMillis();

        executorService.execute(() -> telegramBot.sendMessage("Hello"));
        executorService.execute(() -> telegramBot.sendMessage("World"));
        executorService.execute(() -> telegramBot.sendMessage("!"));
        executorService.execute(() -> telegramBot.sendMessage("Are"));
        executorService.execute(() -> telegramBot.sendMessage("There"));
        executorService.execute(() -> telegramBot.sendMessage("Anyone"));
        executorService.execute(() -> telegramBot.sendMessage("?"));
        executorService.execute(() -> telegramBot.sendMessage("?"));

        executorService.shutdown();

        try {
            executorService.awaitTermination(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Time to send messages: " + (System.currentTimeMillis() - start));
    }
}
