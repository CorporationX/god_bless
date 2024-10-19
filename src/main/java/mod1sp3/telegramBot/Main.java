package mod1sp3.telegramBot;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        TelegramBot telegramBot = new TelegramBot();
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(6);
        scheduledExecutorService.scheduleAtFixedRate(() -> {
            telegramBot.sendMessage("some message");
            System.out.println(Thread.currentThread().getName());
        }, 0, 707, TimeUnit.MILLISECONDS);
        try {
            Thread.sleep(30000);
            scheduledExecutorService.shutdown();
            if (!scheduledExecutorService.awaitTermination(45, TimeUnit.SECONDS)) {
                scheduledExecutorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            throw new IllegalStateException("Thread was interrupted: " + e.getMessage(), e);
        }
    }
}
