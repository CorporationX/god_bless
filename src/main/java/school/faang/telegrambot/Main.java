package school.faang.telegrambot;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    public static void main(String[] args) {
        TelegramBot telegramBot = new TelegramBot();
        ExecutorService executor = Executors.newFixedThreadPool(15);

        for (int i = 0; i < 100; i++) {
            executor.submit(() -> telegramBot.sendMessage("Message"));
        }

        executor.shutdown();
        try {
            if (executor.awaitTermination(10, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Поток прерван");
            executor.shutdownNow();
        }

        log.info("Задача выполнена");
    }
}