package faang.school.godbless.telegram_bot;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        int totalThreads = 5;
        TelegramBot telegramBot = new TelegramBot();
        ExecutorService executorService = Executors.newFixedThreadPool(totalThreads);

        int totalMessages = 100;

        for (int i = 0; i < totalMessages; i++) {
            int messageNumber = i;
            executorService.submit(() -> telegramBot.sendMessage("Message " + messageNumber));
        }

        executorService.shutdown();

        try {
            executorService.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Messages has been sent");
    }
}
