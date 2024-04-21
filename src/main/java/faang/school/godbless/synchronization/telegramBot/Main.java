package faang.school.godbless.synchronization.telegramBot;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    public static void main(String[] args) {
        TelegramBot telegramBot = new TelegramBot();

        ExecutorService usersThreads = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 20; i++) {
            int userId = i;
            usersThreads.submit(() -> {
                try {
                    Thread.sleep(new Random().nextInt(5, 100));
                } catch (InterruptedException e) {
                    log.warn("User thread was interrupted during sending message");
                }
                telegramBot.sendMessage("Message from user " + userId);
            });
        }

        usersThreads.shutdown();

        try {
            usersThreads.awaitTermination(60, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            log.error("Termination awaiting was interrupted.");
        }

        log.info("All users sent their messages.");
    }
}
