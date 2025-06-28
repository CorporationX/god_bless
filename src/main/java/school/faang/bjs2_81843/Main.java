package school.faang.bjs2_81843;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        TelegramBot bot = new TelegramBot();

        Runnable task = () -> {
            for (int i = 0; i < 3; i++) {
                bot.sendMessage("Hello from " + Thread.currentThread().getName());
            }
        };

        Thread[] threads = new Thread[10];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(task, "BotThread-" + i);
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error("Main thread was interrupted", e);
            }
        }

        log.info("All messages have been sent. Task is complete.");
    }
}