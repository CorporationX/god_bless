package telegram_bot;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        TelegramBot bot = new TelegramBot(5, LocalDateTime.now(), 0);
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for (int i = 1; i <= 100; i++) {
            int messageNumber = i;
            Runnable task = () -> bot.sendMessage("Message №" + messageNumber);
            executorService.submit(task);
        }

        executorService.shutdown();

        try {
            executorService.awaitTermination(5, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Tasks completed - all messages sent");
    }
}
