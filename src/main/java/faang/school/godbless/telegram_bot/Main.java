package faang.school.godbless.telegram_bot;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        TelegramBot tBot = new TelegramBot();
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        for(int i = 0; i < 50; i++) {
            int count = i + 1;
            executorService.submit(() -> tBot.sendMessage("It's message number " + count));
        }
        executorService.shutdown();

        try {
            executorService.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("All messages has been sent");
    }
}
