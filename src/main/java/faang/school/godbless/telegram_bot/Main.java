package faang.school.godbless.telegram_bot;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class Main {
    private static final int THREAD_POOL_SIZE = 3;
    private static final int TOTAL_MESSAGES = 20;

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(TOTAL_MESSAGES);
        TelegramBot telegramBot  = new TelegramBot(5);
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        for (int i = 0; i < TOTAL_MESSAGES; i++) {
            String message = "Message_" + i;
            executorService.execute(() -> {
                try {
                    telegramBot.sendMessage(message);
                } finally {
                    countDownLatch.countDown();
                }
            });
        }
        Thread.sleep(5000);
        telegramBot.sendMessage("Another message from main thread");

        countDownLatch.await();
        executorService.shutdown();
        log.info("All messages were sent!");
    }
}